package com.bankflow.bankflow_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.bankflow.bankflow_api.domain.Auth;
import com.bankflow.bankflow_api.repository.AuthRepository;
import com.bankflow.bankflow_api.service.AuthService;
import com.bankflow.bankflow_api.controller.AuthController;

import static org.mockito.Mockito.*;

@SpringBootTest
public class AuthTest {
    @Test
	void contextLoads() {
    }

    @Test 
    void testLoginSuccessful(){
        String username = "testuser";
        String password = "testpassword";

        Auth authObject = new Auth(username, password);
        AuthRepository authRepository = mock(AuthRepository.class);
        when(authRepository.findByUsername(username)).thenReturn(authObject);
        AuthService authService = mock(AuthService.class);
        AuthController authController = new AuthController(authService); 
        
        assert(authController.login(username, password).equals(authService.login(username, password)));
    }

    @Test
    void testLoginFailed(){
        String username = "testuser";
        String password = "testpassword";

        Auth authObject = new Auth(username, password);
        AuthRepository authRepository = mock(AuthRepository.class);
        when(authRepository.findByUsername(username)).thenReturn(authObject);
        AuthService authService = mock(AuthService.class);
        AuthController authController = new AuthController(authService); 
        
        assert(authController.login(username, password).equals(authService.login("wrong name", "wrong password")));
    }

    @Test
    void testRegisterSuccessful(){
        String username = "testuser";
        String password = "testpassword";

        Auth authObject = new Auth(username, password);
        AuthRepository authRepository = mock(AuthRepository.class);
        when(authRepository.findByUsername(username)).thenReturn(authObject);
        AuthService authService = mock(AuthService.class);
        AuthController authController = new AuthController(authService); 
        
        assert(authController.register(username, password).equals(authService.register(username, password)));
    }

    @Test 
    void testRegisterFailed(){
        String username = "testuser";
        String password = "testpassword";

        Auth authObject = new Auth(username, password);
        AuthRepository authRepository = mock(AuthRepository.class);
        when(authRepository.findByUsername(username)).thenReturn(authObject);
        AuthService authService = mock(AuthService.class);
        AuthController authController = new AuthController(authService); 
        
        assert(authController.register(username, password).equals(authService.register("wrong name", "wrong password")));
    }

    @Test
    void testLogoutSuccessful(){
        String username = "testuser";
        String password = "testpassword";

        Auth authObject = new Auth(username, password);
        AuthRepository authRepository = mock(AuthRepository.class);
        when(authRepository.findByUsername(username)).thenReturn(authObject);
        AuthService authService = mock(AuthService.class);
        AuthController authController = new AuthController(authService); 

        String token = authService.generateToken(username);

        assert(authController.logout(token).equals(authService.logout(token)));
    }
}