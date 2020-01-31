package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    // Variables for the tests
    User lars;
    User mitnick;
    List<User> testList = new ArrayList<User>();

    // Before each test a the user lars is created and added to the testlist arraylist.
    @BeforeEach
    void createUser() {
       lars = new User("lars","asd",1,200,10,"winhof");
       testList.add(lars);
    }

    // Stress test to see what happens if you add 10000 users to the Arraylist
    @RepeatedTest(1)
    void repeatedTest() {
        mitnick = new User("micknick","asd",1,200,10,"winhof");
        testList.add(mitnick);

        testList.forEach(user -> {
            System.out.println(user.getUsername());
        });
        assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
    }

    //test that checks users account balance
    @Test
    void viewAccountBalance() {
        assertEquals(200, lars.getAccountBalance());
    }
    //test that checks users Salary
    @Test
    void viewSalary() {
        assertEquals(10, lars.getSalary());
    }
    //test that checks users Role
    @Test
    void viewRole() {
        assertEquals("winhof", lars.getRole());
    }

    //test that checks if you can delete a account
    @Test
    void deleteAccount() {
        assertEquals(1,testList.size());
        testList.remove(0);
        assertEquals(0,testList.size(),"Not null");
    }
    //test that checks if a request is set to the user object.
    @Test
    void requestHigherSalary() {
        testList.get(0).setRequest(100);
        assertEquals(100, testList.get(0).getRequest());
    }

    // Intergration test that's run all the User tests except repeatedTest()
    @Test
    void adminIntegrationsTest () {
        requestHigherSalary();
        deleteAccount();
        viewRole();
        viewSalary();
        viewAccountBalance();
        createUser();
    }
}