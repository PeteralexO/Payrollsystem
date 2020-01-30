package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    Admin testAdmin;
    User lars;

    static List<User> testList = new ArrayList<User>();



    @BeforeEach
    void createstUserAdmin() {
        testAdmin = new Admin("Alex","asd",1,200,10,"chipsmaster");
        lars = new User("lars","asd",1,200,10,"winhof");
        testList.add(lars);
    }

    @Test
    void createUser() {
        User eric= new User("eric","asd", 1,400,20,"programmer");
        assertEquals("eric",eric.getUsername());

    }

    @Test
    void viewUsersPasswords() {
        assertEquals("asd", testAdmin.getPassword());
    }

    @Test
    void plusOneMonth() {
        int newAb= 210;

      assertEquals(lars.getSalary()+lars.getAccountBalance(), newAb);

    }

    @Test
    void viewAccountBalance() {
        assertEquals(200, testAdmin.getAccountBalance());
    }

    @Test
    void viewSalary() {
        assertEquals(10, testAdmin.getSalary());
    }

    @Test
    void viewRole() {
        assertEquals("chipsmaster", testAdmin.getRole());
    }

    @Test
    void viewRequests() {
        assertEquals(null, lars.getRequest());
    }

    @Test
    void deleteUsers() {

        assertEquals(1,testList.size());
        testList.remove(0);
        assertEquals(0,testList.size(),"Not null");
    }

    @Test
    void adminIntegrationsTest () {
        createUser();
        deleteUsers();
        viewRequests();
        viewAccountBalance();
        viewRole();
        viewSalary();
        viewUsersPasswords();
        plusOneMonth();
    }

}