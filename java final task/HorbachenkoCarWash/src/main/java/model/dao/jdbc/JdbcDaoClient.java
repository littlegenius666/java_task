package model.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import model.dao.*;
import model.entities.Client;
import model.entities.Client.*;

public class JdbcDaoClient implements DaoClient {
	
	private static final String SELECT_FROM_CLIENT = "SELECT * FROM Client";
	private static final String SELECT_FROM_CLIENT_BY_ID = "SELECT * FROM Client WHERE id_client = ?";
	
	private static final String CLIENT_ID = "id_client";
	private static final String NAME = "name";
	private static final String GENDER = "gender";
	private static final String CAR_COUNT = "car_count";
	private static final String SERVICE_COUNT = "service_count";
	private static final String PHONE_NUMBER = "phone_number";
	private static final String INSERT_CLIENT="INSERT INTO Client ("+NAME+","+GENDER+","+CAR_COUNT+","+SERVICE_COUNT+","+PHONE_NUMBER+") VALUES (?,?,?,?,?)";
	private static final String UPDATE_CLIENT="UPDATE Client SET "+NAME+"= ? ,"+GENDER+"= ? ,"+CAR_COUNT+"= ? ,"+SERVICE_COUNT+"= ? ,"+PHONE_NUMBER+"= ? WHERE "+CLIENT_ID+"= ?";
	private static final String DELETE_CLIENT="DELETE FROM Client WHERE "+CLIENT_ID+"= ?";
	private static final String SELECT_CLIENT_BY_NAME="SELECT * FROM Client WHERE "+NAME+" = ?";
	
	private Connection connection;

	public JdbcDaoClient() {
	}

	JdbcDaoClient(Connection connection) {
		super();
		this.connection = connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
	@Override
	public Optional<Client> find(String id) {
		Optional<Client> result = Optional.empty();
		try (PreparedStatement query = connection.prepareStatement(SELECT_FROM_CLIENT_BY_ID)) {
			query.setInt(1, Integer.valueOf(id));
			ResultSet resultSet = query.executeQuery();
			if (resultSet.next()) {
				result = Optional.of(extractClientFromResultSet(resultSet));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	private Client extractClientFromResultSet(ResultSet resultSet) throws SQLException {
		Gender a;
		if ("male".equals(resultSet.getString(GENDER))) {
			a=Gender.male;
		} else {a=Gender.female;}
		Client student=Client
			.newBuilder()
			.setId_client(resultSet.getInt(CLIENT_ID))
			.setName(resultSet.getString(NAME))
			.setGender(a)
			.setCar_count(resultSet.getInt(CAR_COUNT))
			.setService_count(resultSet.getInt(SERVICE_COUNT))
			.setPhone_number(resultSet.getString(PHONE_NUMBER))
			.build();

		return student;
	};

	@Override
	public List<Client> findAll() {
	    List<Client> result = new ArrayList<>();
        try(Statement query = connection.createStatement();
            ResultSet resultSet = query.executeQuery(SELECT_FROM_CLIENT)){

            while (resultSet.next()) {
                result.add( extractClientFromResultSet(resultSet));
          
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
	}

	@Override
	public void create(Client client) {
		try (PreparedStatement query = connection.prepareStatement(INSERT_CLIENT)) {
			query.setString(1,client.getName());
			query.setString(2,client.getGender().toString());
			query.setInt(3,client.getCar_count());
			query.setInt(4, client.getService_count());
			query.setString(5, client.getPhone_number());
			query.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void update(Client client) {
		
		try (PreparedStatement query = connection.prepareStatement(UPDATE_CLIENT)) {
			query.setString(1,client.getName());
			query.setString(2,client.getGender().toString());
			query.setInt(3,client.getCar_count());
			query.setInt(4, client.getService_count());
			query.setString(5, client.getPhone_number());
			query.setInt(6, client.getId_client());
			query.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(String id) {
		try (PreparedStatement query = connection.prepareStatement(DELETE_CLIENT)) {
			query.setInt(1,Integer.valueOf(id));
			query.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	@Override
	public Optional<Client> getClientByName(String name) {
		Optional<Client> result = Optional.empty();
		try (PreparedStatement query = connection.prepareStatement(SELECT_CLIENT_BY_NAME)) {
			query.setString(1, name);
			ResultSet resultSet = query.executeQuery();
			if (resultSet.next()) {
				result = Optional.of(extractClientFromResultSet(resultSet));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	
}
