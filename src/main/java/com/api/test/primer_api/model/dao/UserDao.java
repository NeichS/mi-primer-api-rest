package com.api.test.primer_api.model.dao;

import com.api.test.primer_api.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {

}
