package com.company;
import java.util.Scanner;
import static com.company.Admin.userList;
import static com.company.Main.*;

public class User extends Account {

    //Constructor for creating a user
    public User(String newusername, String newpassword, int newid, int newaccountBalance, int newsalary, String newrole) {
        super(newusername, newpassword, newid, newaccountBalance, newsalary, newrole);
        username = newusername;
        password = newpassword;
        salary = newsalary;
        role = newrole;
        accountBalance = newaccountBalance;
        id = newid;
        this.sRequest= sRequest;
        this.rRequest= rRequest;

    }

    // User Variables
    private Integer sRequest;
    private String rRequest;
    private String username;
    private String password;
    private String role;
    private Integer id;
    private Integer salary;
    private Integer accountBalance;


    // Using a get method to view the Users Account Balance
    public static void viewAccountBalance() {
        System.out.println("Your account balance is:" + userList.get(userIndex).getAccountBalance());
    }
    // Using a get method to view the Users Salary
    public static void viewSalary() {
        System.out.println("Your salary is:" + userList.get(userIndex).getSalary());
    }
    // Using a get method to view the Users Role
    public static void viewRole() {
        System.out.println("Your role is:" + userList.get(userIndex).getRole());
    }

    // A method that deletes the users account by typing their Username and password for verification.
    public static void deleteAccount(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Write your Username and password to delete account:");
        System.out.println("Username:");
        String username= scan.nextLine();
        System.out.println("Password:");
        String password= scan.nextLine();

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username) && password.equals(userList.get(i).getPassword())) {
                userList.remove(i);
                System.out.println("Your Account is now deleted");
            }
        }
        userList.forEach(user -> {
            System.out.println(user.getUsername());
        });
    }

    // A method that adds a request to the users object. So that the admin can view it later.
    public static void requestNewSalaryRole () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Request higher Salary or change of Role? Salary:1 Role:2 ");
        int input = scan.nextInt();
        switch (input){
            case 1:
                System.out.println("how mutch more do you want?");
                int request = scan.nextInt();
                userList.get(userIndex).setRequest(request);
                break;
            case 2:
                System.out.println("Which role do you want?");
                String bug = scan.nextLine();
                String newRole= scan.nextLine();
                userList.get(userIndex).setrRequest(newRole);
                break;
        }
    }

   /* Getters and Setter*/
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
        return sRequest;
    }

    public void setRequest(Integer request) {
        this.sRequest = request;
    }
    public String getrRequest() {
        return rRequest;
    }

    public void setrRequest(String rRequest) {
        this.rRequest = rRequest;
    }

}