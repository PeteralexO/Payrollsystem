package com.company;


import java.util.Scanner;

import static com.company.Admin.userList;
import static com.company.Main.boss;
import static com.company.Main.userIndex;

public class User extends Account {

    public User(String newusername, String newpassword, int newid, int newaccountBalance, int newsalary, String newrole) {
        super(newusername, newpassword, newid, newaccountBalance, newsalary, newrole);
        username = newusername;
        password = newpassword;
        salary = newsalary;
        role = newrole;
        accountBalance = newaccountBalance;
        id = newid;
        this.request= request;

    }



    private Integer request;
    private String username;
    private String password;


    private String role;
    private Integer id;
    private Integer salary;
    private Integer accountBalance;

    public static void viewAccountBalance() {


        System.out.println("Your account balance is:" + userList.get(userIndex).getAccountBalance());
    }
    public static void viewSalary() {

        System.out.println("Your salary is:" + userList.get(userIndex).getSalary());
    }
    public static void viewRole() {

        System.out.println("Your role is:" + userList.get(userIndex).getRole());
    }
    public static void deleteAccount(){
        Scanner scan = new Scanner(System.in);
        System.out.println(userIndex);

        System.out.println("Write your Username and password to delete account:");
        System.out.println("Username:");
        String username= scan.nextLine();
        System.out.println("Password:");
        String Password= scan.nextLine();


        userList.remove(userIndex);

        userList.forEach(user -> {

            System.out.println(user.getUsername());

        });
    }

    public static void requestHigherSalary () {
        System.out.println("how mutch more do you want?");
        Scanner scan = new Scanner(System.in);
        int request = scan.nextInt();
        userList.get(userIndex).setRequest(request);
        Admin.viewRequests();

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Integer getRequest() {
        return request;
    }

    public void setRequest(Integer request) {
        this.request = request;
    }

}