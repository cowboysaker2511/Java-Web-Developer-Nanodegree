package com.example.mokito_demo;

import com.example.mokito_demo.controllers.UserController;
import com.example.mokito_demo.model.persistence.User;
import com.example.mokito_demo.model.persistence.repositories.CartRepository;
import com.example.mokito_demo.model.persistence.repositories.UserRepository;
import com.example.mokito_demo.model.requests.CreateUserRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InjectDemo {

    private UserController userController;

    private CartRepository cartRepository;

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void init() {
        userController = new UserController();
        //mock 3 object dependency
        cartRepository = Mockito.mock(CartRepository.class);
        bCryptPasswordEncoder = Mockito.mock(BCryptPasswordEncoder.class);
        userRepository = Mockito.mock(UserRepository.class);

        //inject mock object dependency vào object target
        injectObject(userController, "cartRepository", cartRepository);
        injectObject(userController, "bCryptPasswordEncoder", bCryptPasswordEncoder);
        injectObject(userController, "userRepository", userRepository);
    }

    @Test
    public void whenThenReturn() {
        CreateUserRequest userRequest = new CreateUserRequest();
        String username = "username";
        String password = "password";
        String encodedPassword = "encoded";
        userRequest.setUsername(username);
        userRequest.setPassword(password);
        userRequest.setConfirmPassword(password);

        //mock method encode password
        Mockito.when(bCryptPasswordEncoder.encode(password)).thenReturn(encodedPassword);

        ResponseEntity<User> userResponseEntity = userController.createUser(userRequest);
        User user = userResponseEntity.getBody();

        assertEquals(userRequest.getUsername(), user.getUsername());
        assertEquals(encodedPassword, user.getPassword());
    }

    public void injectObject(Object target, String fieldName, Object toInject) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            //inject dependency vào object target
            field.set(target, toInject);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
