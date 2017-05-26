package model.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.dao.DaoCar;
import model.entities.Car;
import model.entities.Car.*;
import model.entities.Client;


public class JdbcDaoCar implements DaoCar {
	
	private static final String SELECT_FROM_CAR = "SELECT * FROM Car";
	private static final String SELECT_FROM_CAR_BY_NUMBERS = "SELECT * FROM Car WHERE plate_numbers = ?";
	private static final String PLATE_NUMBERS = "plate_numbers";
	private static final String OWNER = "owner";
	private static final String CAR_TYPE = "type";
	private static final String INSERT_CAR="INSERT INTO Car ("+PLATE_NUMBERS+","+OWNER+","+CAR_TYPE+") VALUES (?,?,?)";
	private static final String UPDATE_CAR="UPDATE Car SET "+PLATE_NUMBERS+"= ? ,"+OWNER+"= ? ,"+CAR_TYPE+"= ? WHERE "+PLATE_NUMBERS+"= ?";
	private static final String DELETE_CAR="DELETE FROM Car WHERE "+PLATE_NUMBERS+"= ?";
	private static final String SELECT_CARS_BY_OWNER="Select * from Car WHERE "+OWNER+"= ?";
	
	private Connection connection;

	public JdbcDaoCar() {
	}

	JdbcDaoCar(Connection connection) {
		super();
		this.connection = connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public Optional<Car> find(String id) {
		Optional<Car> result = Optional.empty();
		try (PreparedStatement query = connection.prepareStatement(SELECT_FROM_CAR_BY_NUMBERS)) {
			query.setString(1, id);
			ResultSet resultSet = query.executeQuery();
			if (resultSet.next()) {
				result = Optional.of(extractCarFromResultSet(resultSet));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	private Car extractCarFromResultSet(ResultSet resultSet) throws SQLException {
		Car_Type a;
		String resultType=resultSet.getString(CAR_TYPE);
		if ("jeep".equals(resultType)) {
			a=Car_Type.jeep;
		} else if ("passenger".equals(resultType)) {
			a=Car_Type.passenger;
		} else {
			a=Car_Type.minibus;
		}
		new Car();
		Car car=Car
			.newBuilder()
			.setPlate_numbers(resultSet.getString(PLATE_NUMBERS))
			.setOwner(new JdbcDaoClient(connection).find(resultSet.getString(OWNER)).get())
			.setType(a)
			.build();

		return car;
	};
	
	@Override
	public List<Car> findAll() {
		List<Car> result = new ArrayList<>();
        try(Statement query = connection.createStatement();
            ResultSet resultSet = query.executeQuery(SELECT_FROM_CAR)){

            while (resultSet.next()) {
                result.add( extractCarFromResultSet(resultSet));
          
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
	}

	@Override
	public void create(Car car) {
		try (PreparedStatement query = connection.prepareStatement(INSERT_CAR)) {
			query.setString(1,car.getPlate_numbers());
			query.setInt(2,car.getOwner().getId_client());
			query.setString(3,car.getType().toString());
			query.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void update(Car car) {
		try (PreparedStatement query = connection.prepareStatement(UPDATE_CAR)) {
			query.setString(1,car.getPlate_numbers());
			query.setInt(2,car.getOwner().getId_client());
			query.setString(3,car.getType().toString());
			query.setString(4,car.getPlate_numbers());
			query.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delete(String id) {
		try (PreparedStatement query = connection.prepareStatement(DELETE_CAR)) {
			query.setString(1,id);
			query.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public ArrayList<Car> getCarsByOwnerName(String name) {
		ArrayList<Car> result = new ArrayList<Car>();
		Optional<Client> owner=Optional.empty();
		owner = new JdbcDaoClient(connection).getClientByName(name);
		return getCarsByOwnerId(owner.get().getId_client());
	}
	
	@Override
	public ArrayList<Car> getCarsByOwnerId(int id) {
		ArrayList<Car> result = new ArrayList<Car>();
		try (PreparedStatement query = connection.prepareStatement(SELECT_CARS_BY_OWNER)) {
			query.setInt(1, id);
			ResultSet resultSet = query.executeQuery();
			while (resultSet.next()) {
                result.add( extractCarFromResultSet(resultSet));
          
            }
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	};
	
}
