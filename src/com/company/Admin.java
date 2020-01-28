package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.Main.boss;

public class Admin extends Account {


    private String username;
    private String password;
    private String role;
    private Integer id;
    private Integer accountBalance;
    private Integer salary;


    public static List<User> userList = new ArrayList<User>();



    public Admin(String newusername, String newpassword, int newid, int newaccountBalance, int newsalary, String newrole) {
        super(newusername, newpassword, newid, newaccountBalance, newsalary, newrole);
        username = newusername;
        password = newpassword;
        id = newid;
        accountBalance = newaccountBalance;
        salary = newsalary;
        role = newrole;


    }





   /* @Override
    public String toString() {
        return username + ", " + id + ", "; //The remaining fields
    }*/




    //String username, String password, Integer id, Integer accountBalance, Integer salary, String role
    public static void createUser() {


        Scanner scan = new Scanner(System.in);

        String username = "chips";
        String password;
        Integer id = 1;
        Integer accountBalance;
        Integer salary;
        String role;

        System.out.println("Username:");

        try {
            username = scan.nextLine();
        } catch (Exception InputMismatchException) {
            System.out.println("Wrong input");
            username = "chips";
        }

        System.out.println("Role:");
        role = scan.nextLine();
        System.out.println("Password:");
        password = scan.nextLine();
        boolean wrongInput;

        System.out.println("Id:");
        wrongInput = false;
        try {
            id = scan.nextInt();
        } catch (Exception InputMismatchException) {
            System.out.println("Wrong input");
            wrongInput = true;
        }

        System.out.println("AccountBalance:");
        accountBalance = scan.nextInt();
        System.out.println("Salary:");
        salary = scan.nextInt();


        User newuser = new User(username, password, id, accountBalance, salary, role);

        userList.add(newuser);


       /* userList.forEach(user -> {
            System.out.println("List of Users and their Passwords\n" + "Name : " + user.getUsername() + " Password : " + user.getPassword()
                    + " Id : " + user.getId()
                    + " AccountBalance : " + user.getAccountBalance()
                    + " Salary : " + user.getSalary()
                    + " Role : " + user.getRole())
            ;
        });*/


    }

    public static void viewUsersPasswords() {

        userList.forEach(user -> {
            System.out.println("Name : " + user.getUsername() + " | Password : " + user.getPassword())

            ;
        });

    }


    public static void viewAccountBalance() {

        System.out.println("Your account balance is:" + boss.getAccountBalance());
    }

    public static void viewSalary() {
        System.out.println("Your salary is:" + boss.getSalary());
    }

    public static void viewRole() {
        System.out.println("Your role is:" + boss.getRole());
    }

    public static void viewRequests() {
        Scanner scan = new Scanner(System.in);
        System.out.println("List of Requests:");
        userList.forEach(user -> {

                System.out.println(user.getUsername()+ ":"+user.getRequest());

        });
        System.out.println("Do you want to grant a request?");
        String input= scan.nextLine();

        if(input.equals("Y") || input.equals("y") ) {
            System.out.println("which user:");
            String username= scan.nextLine();

            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUsername().equals(username)) {
                    userList.get(i).setSalary(userList.get(i).getRequest());
                }
            }

        }
        else {
            System.out.println("Request denied");
        }


        /*if(input.equals("Y") || input.equals("y") ) {
            userList.get(0).setSalary(userList.get(0).getRequest());
        }*/



        userList.forEach(user -> {
            System.out.println(user.getSalary())

            ;
        });


    }

    public static void deleteUsers() {
        System.out.println("List of Users:");
        userList.forEach(user -> {
                    System.out.println(user.getUsername());
                });
        System.out.println("Name of User you want to delete:");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                userList.remove(i);
            }
        }
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

    public Integer getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}



/*
        List<User> students = new ArrayList();

// You can directly print your ArrayList

        User chips = new User("username","password",1, 1,2, "chips");
        User chips2 = new User("username","password",3, 1,2, "chips");
        students.add(chips);
        students.add(chips2);
        //System.out.println(students.toString());

// Or, iterate through it to print each instance
        for(User student: students) {
            System.out.println(student.id.toString());  // Will invoke overrided `toString()` method
        }*/
/*System.out.println(userList[i].username);*/

/*  for (User user : userList) {
 *//*  System.out.println(userList(i).username);*//*
            System.out.println("Id: " + user.id + " Username: " + user.username);
        }*/