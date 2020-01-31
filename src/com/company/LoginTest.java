package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    // Login test that checks if the boolean login changes if you type in the right username and password
    @Test
    void run() {
        boolean login;
        User eric = new User("eric","asd",1,123,321,"tester");
        String username= "eric";
        String password= "asd";

        if(eric.getUsername().equals(username) && eric.getPassword().equals(password)){
            login= true;
        }
        else {
            login=false;
        }
        assertTrue(login,"User not logged in");
    }
}