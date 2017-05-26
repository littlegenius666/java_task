package model.dao.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

import model.dao.DaoConnection;
import model.dao.DaoFactory;
import model.dao.DaoCar;
import model.dao.DaoClient;
import model.dao.jdbc.JdbcDaoConnection;
import model.dao.jdbc.JdbcDaoClient;

public class JdbcDaoFactory extends DaoFactory {

	private Connection connection;
	private static final String DB_URL = "url";

	public JdbcDaoFactory() {
		try {
			InputStream inputStream = DaoFactory.class.getResourceAsStream(DB_FILE);
			Properties dbProps = new Properties();
			dbProps.load(inputStream);
			String url = dbProps.getProperty(DB_URL);
			new Driver();
			connection = DriverManager.getConnection(url, dbProps);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public DaoClient createClientDao() {
		return new JdbcDaoClient(connection);
	}

	@Override
	public DaoCar createCarDao() {
		return new JdbcDaoCar(connection);
	}
	
	@Override
	public DaoConnection getConnection() {
		return new JdbcDaoConnection(connection);
	}

	@Override
	public DaoClient createClientDao(DaoConnection conection) {
		JdbcDaoConnection jdbcConnection = (JdbcDaoConnection) connection;
		Connection sqlConnection = jdbcConnection.getConnection();
		return new JdbcDaoClient(sqlConnection);
	}
	
	@Override
	public DaoCar createCarDao(DaoConnection conection) {
		JdbcDaoConnection jdbcConnection = (JdbcDaoConnection) connection;
		Connection sqlConnection = jdbcConnection.getConnection();
		return new JdbcDaoCar(sqlConnection);
	};

}
