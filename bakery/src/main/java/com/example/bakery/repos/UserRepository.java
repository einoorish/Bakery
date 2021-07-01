package com.example.bakery.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.bakery.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();
}
