package model.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import model.dao.DaoConnection;

public class JdbcDaoConnection implements DaoConnection {

	private Connection connection;
	private boolean inTransaction = false;

	JdbcDaoConnection(Connection connection) {
		super();
		this.connection = connection;
	}

	public void close() {
		if (inTransaction) {
			rollback();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public void begin() {
		try {
			connection.setAutoCommit(false);
			inTransaction = true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void commit() {
		try {
			connection.commit();
			inTransaction = false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void rollback() {
		try {
			connection.rollback();
			inTransaction = false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	Connection getConnection() {
		return connection;
	}

}
