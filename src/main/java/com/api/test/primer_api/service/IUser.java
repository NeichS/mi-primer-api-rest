package com.api.test.primer_api.service;

import com.api.test.primer_api.model.entity.User;

public interface IUser {
    User save(User user); //cumple la funcion del update tambien, artilugio de CrudRepository

    User findById(Integer id);

    void delete(User user);
}
