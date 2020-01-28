package com.company;

public class Account {

    public String username;
    public String password;
    public Integer id;
    public Integer accountBalance;
    public Integer salary;
    public String role;

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
