package services;

import java.util.List;

import model.dao.DaoClient;
import model.dao.DaoFactory;
import model.entities.Client;

public final class ClientService {

	public static List<Client> getAllClientsFromDB() {
		DaoFactory factory = DaoFactory.getInstance();
		DaoClient clientDao=factory.createClientDao();
		return clientDao.findAll();
	}
	
	public static Client getClientByName(String name) {
		DaoFactory factory = DaoFactory.getInstance();
		DaoClient clientDao=factory.createClientDao();
		return clientDao.getClientByName(name).get();
	}
	
	public static Client getClientById(Integer id) {
		DaoFactory factory = DaoFactory.getInstance();
		DaoClient clientDao=factory.createClientDao();
		return clientDao.find(id.toString()).get();
	}
	
	public static void deleteClientById(Integer id) {
		DaoFactory factory = DaoFactory.getInstance();
		DaoClient clientDao=factory.createClientDao();
		clientDao.delete(id.toString());
	}
	
	public static void updateClient(Client c) {
		DaoFactory factory = DaoFactory.getInstance();
		DaoClient clientDao=factory.createClientDao();
		clientDao.update(c);
	}
	
	public static void createClient(Client c) {
		DaoFactory factory = DaoFactory.getInstance();
		DaoClient clientDao=factory.createClientDao();
		clientDao.create(c);
	}
}
