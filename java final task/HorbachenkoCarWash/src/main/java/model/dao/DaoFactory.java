package model.dao;

import java.util.Properties;

import java.io.*;

public abstract class DaoFactory {

	public abstract DaoConnection getConnection();
	public abstract DaoClient createClientDao();
	
	public abstract DaoClient createClientDao(DaoConnection conection);
	
	public abstract DaoCar createCarDao();

	public abstract DaoCar createCarDao(DaoConnection conection);
	
	public static final String DB_FILE = "/db.properties";
	private static final String DB_FACTORY_CLASS = "factory.class";
	private static DaoFactory instance;
	
	public static DaoFactory getInstance(){
		if (instance == null){
			try{
				InputStream inputStream = DaoFactory.class.getResourceAsStream(DB_FILE);
                Properties dbProps = new Properties();
                dbProps.load(inputStream);
                String factoryClass = dbProps.getProperty(DB_FACTORY_CLASS);
                instance = (DaoFactory) Class.forName(factoryClass).newInstance();
			} catch (Exception e ) {
               throw new RuntimeException(e);
           }
		}
		return instance;
	}
}
