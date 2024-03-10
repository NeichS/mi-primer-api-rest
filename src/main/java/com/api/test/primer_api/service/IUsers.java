package com.api.test.primer_api.service;

import com.api.test.primer_api.model.dto.UsersDto;
import com.api.test.primer_api.model.entity.Users;

import java.util.List;

public interface IUsers {

    List<Users> listAll();
    Users save(UsersDto users); //cumple la funcion del update tambien, artilugio de CrudRepository
    Users findById(Integer id);

    void delete(Users users);
}
