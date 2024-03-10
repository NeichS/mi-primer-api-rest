package com.api.test.primer_api.controller;

import com.api.test.primer_api.model.dto.UsersDto;
import com.api.test.primer_api.model.entity.Users;
import com.api.test.primer_api.model.payload.MessageResponse;
import com.api.test.primer_api.service.IUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UsersController {

    @Autowired
    private IUsers userService;

    @GetMapping("users")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showAll() {
        List<Users> userList = userService.listAll();

        if (userList == null) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Empty database")
                    .object(null)
                    .build()
                    , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Ok")
                    .object(userList)
                    .build()
                    , HttpStatus.OK);

        }

    }

    @PostMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody UsersDto usersDto) {
        Users userSave = null;
        try {
            userSave = userService.save(usersDto);

            usersDto = UsersDto.builder()
                    .id(userSave.getId())
                    .name(userSave.getName())
                    .password(userSave.getPassword())
                    .email(userSave.getEmail())
                    .build();

            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Correctly saved")
                            .object(usersDto)
                            .build()
                            , HttpStatus.CREATED);


        } catch (DataAccessException dataException) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(dataException.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("user/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody UsersDto usersDto) {
        Users userUpdate = null;
        try {
            userUpdate = userService.save(usersDto);

            usersDto = UsersDto.builder()
                    .id(userUpdate.getId())
                    .name(userUpdate.getName())
                    .password(userUpdate.getPassword())
                    .email(userUpdate.getEmail())
                    .build();

            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Correctly updated")
                            .object(usersDto)
                            .build()
                    , HttpStatus.CREATED);


        } catch (DataAccessException dataException) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(dataException.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        try {
            Users usersDelete = userService.findById(id);
            userService.delete(usersDelete);
            return new ResponseEntity<>(usersDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException dataException) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(dataException.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Users user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("User not found")
                    .object(null)
                    .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            UsersDto userDto = UsersDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .password(user.getPassword())
                    .email(user.getEmail())
                    .build();

            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Ok")
                    .object(userDto)
                    .build()
                    , HttpStatus.OK);

        }

    }
}
