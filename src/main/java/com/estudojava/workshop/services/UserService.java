package com.estudojava.workshop.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.estudojava.workshop.entities.User;
import com.estudojava.workshop.repositories.UserRepository;
import com.estudojava.workshop.services.exceptions.DatabaseException;
import com.estudojava.workshop.services.exceptions.ResourceNotFoundException;

@Service//Permite a injeção de dependência (Classe de Serviço, então é indicado usar o service
public class UserService {

	@Autowired(required = true)
	private UserRepository rep;
	
	//Métdo para retornar todos os dados do BD
	public List<User> findAll(){
		return rep.findAll();
	}
	
	//Buscando usuário por Id
	public User findById(Long id) {
		Optional<User> obj = rep.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id)); //Retorna o objetivo que estiver no Optional
	}
	
	//Retorna usuário salvo
	public User insert(User obj) {
		return rep.save(obj);
	}
	
	public void delete(Long id) {
		try {
		rep.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {//A exceção do erro
			//e.printStackTrace();//Para ver o tipo da exceção que foi lançada
			throw new ResourceNotFoundException(id);
		}
		//Capturando qualquer outra exceção que ocorrer 
		catch (DataIntegrityViolationException e) {
			//e.printStackTrace();//Mostrará no console
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		@SuppressWarnings("deprecation")
		User entity = rep.getById(id);//getOne instancia um usuario mas ainda nao irá no bd(so deixa um objeto monitorado pelo jpa e em seguida, poderei efetuar alguma oporeção com o bd)
		atualizaDado(entity,obj);
		return rep.save(entity);
	}

	private void atualizaDado(User entity, User obj) {//Atualiza o entity com o que chegou no obj
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setFone(obj.getFone());
	}
}
