package com.example.mokito_demo;

import com.example.mokito_demo.controllers.UserController;
import com.example.mokito_demo.model.persistence.User;
import com.example.mokito_demo.model.requests.CreateUserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockDemo {

    @Mock
    private UserController userController;

    @Test
    public void whenThenReturn() {
        CreateUserRequest userRequest = new CreateUserRequest();
        String username = "username";
        String password = "password";
        String encodedPassword = "encoded";
        userRequest.setUsername(username);
        userRequest.setPassword(password);
        userRequest.setConfirmPassword(password);

        //mock method create user
        Mockito.when(userController.createUser(userRequest))
                .thenReturn(new ResponseEntity<>(new User(username, encodedPassword), HttpStatus.OK));

        ResponseEntity<User> userResponseEntity = userController.createUser(userRequest);
        User user = userResponseEntity.getBody();

        assertEquals(userRequest.getUsername(), user.getUsername());
        assertEquals(encodedPassword, user.getPassword());
    }

}
