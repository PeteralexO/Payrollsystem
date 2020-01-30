package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User lars;
    User mitnick

    static List<User> testList = new ArrayList<User>();

    @BeforeEach
    void createUser() {
       lars = new User("lars","asd",1,200,10,"winhof");
       testList.add(lars);
    }

    @RepeatedTest(1000000)
    void repeatedTest() {
        mitnick = new User("lars","asd",1,200,10,"winhof");
        testList.add(lars);

        assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
    }

    @Test
    void viewAccountBalance() {
        assertEquals(200, lars.getAccountBalance());
    }

    @Test
    void viewSalary() {
        assertEquals(10, lars.getSalary());
    }

    @Test
    void viewRole() {
        assertEquals("winhof", lars.getRole());
    }

    @Test
    void deleteAccount() {
        assertEquals(1,testList.size());
        testList.remove(0);
        assertEquals(0,testList.size(),"Not null");
    }

    @Test
    void requestHigherSalary() {
        testList.get(0).setRequest(100);
        assertEquals(100, testList.get(0).getRequest());
    }
}