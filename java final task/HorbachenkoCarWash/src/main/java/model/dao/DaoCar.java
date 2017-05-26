package model.dao;

import java.util.ArrayList;
import java.util.Optional;

import model.entities.Car;

public interface DaoCar extends GenericDao <Car> {

	ArrayList<Car> getCarsByOwnerName(String name);
	
	ArrayList<Car> getCarsByOwnerId(int id);
}
