package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
    // Variables for the tests
    Admin testAdmin;
    User lars;
    List<User> testList = new ArrayList<User>();

    // Before each test a the user lars is created and added to the testlist arraylist and a admin is created.
    @BeforeEach
    void createstUserAdmin() {
        testAdmin = new Admin("Alex","asd",1,200,10,"chipsmaster");
        lars = new User("lars","asd",1,200,10,"winhof");
        testList.add(lars);
    }

    // tests if you can create a user
    @Test
    void createUser() {
        User eric= new User("eric","asd", 1,400,20,"programmer");
        assertEquals("eric",eric.getUsername());

    }
    // tests if one mouth goes by adding the salary to the users account balance
    @Test
    void plusOneMonth() {
        int newAb= 210;
        assertEquals(lars.getSalary()+lars.getAccountBalance(), newAb);

    }

    //test that checks adminds password
    @Test
    void viewUsersPasswordsUsername() {
        assertEquals("asd", lars.getPassword());
        assertEquals("lars", lars.getUsername());
    }

    //test that checks adminds Account Balance
    @Test
    void viewAccountBalance() {
        assertEquals(200, testAdmin.getAccountBalance());
    }
    //test that checks adminds Salary
    @Test
    void viewSalary() {
        assertEquals(10, testAdmin.getSalary());
    }
    //test that checks adminds Role
    @Test
    void viewRole() {
        assertEquals("chipsmaster", testAdmin.getRole());
    }

    //test that checks if the users have any requests
    @Test
    void viewRequests() {
        assertEquals(null, lars.getRequest());
    }

    //test that checks if a admin can delete a user
    @Test
    void deleteUsers() {
        assertEquals(1,testList.size());
        testList.remove(0);
        assertEquals(0,testList.size(),"Not null");
    }

    // Intergration test that's run all the admins tests
    @Test
    void adminIntegrationsTest () {
        createUser();
        deleteUsers();
        viewRequests();
        viewAccountBalance();
        viewRole();
        viewSalary();
        viewUsersPasswordsUsername();
        plusOneMonth();
    }
}