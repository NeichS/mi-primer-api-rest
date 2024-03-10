package com.api.test.primer_api.model.dao;

import com.api.test.primer_api.model.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersDao extends CrudRepository<Users, Integer> {

}
