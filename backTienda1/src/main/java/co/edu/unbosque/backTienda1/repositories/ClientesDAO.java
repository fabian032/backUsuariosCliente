package co.edu.unbosque.backTienda1.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.backTienda1.models.Clientes;

@Repository
public interface ClientesDAO extends MongoRepository<Clientes, String>{

}
