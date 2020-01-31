package com.company;

public class Account {

    //Parent class for User and Admin

    public String username;
    public String password;
    public Integer id;
    public Integer accountBalance;
    public Integer salary;
    public String role;

    // Constructor for Account
    public Account (String newusername, String newpassword, int newid, int newaccountBalance, int newsalary, String newrole)
    {
        username = newusername;
        password = newpassword;
        id = newid;
        accountBalance = newaccountBalance;
        salary = newsalary;
        role = newrole;
    }
}
