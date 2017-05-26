package model.dao;

import java.util.Optional;

import model.entities.Client;

public interface DaoClient extends GenericDao <Client>{
	
	Optional<Client> getClientByName(String name);
}
