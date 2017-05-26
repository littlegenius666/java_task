package services;

import java.util.List;

import javax.xml.ws.Holder;

import model.dao.DaoCar;
import model.dao.DaoFactory;
import model.entities.Car;

public final class CarService {
	
	public static List<Car> getAllCarsFromDB() {
		DaoFactory factory = DaoFactory.getInstance();
		DaoCar carDao=factory.createCarDao();
		return carDao.findAll();
	}
	
	public static List<Car> getAllCarsByOwner(int id) {
		DaoFactory factory = DaoFactory.getInstance();
		DaoCar carDao=factory.createCarDao();
		return carDao.getCarsByOwnerId(id);
	}
}
