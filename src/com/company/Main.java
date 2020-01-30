package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.Admin.userList;

public class Main {


    static Admin boss = new Admin("boss", "asd", 1, 142000, 54000, "Overlord");
    static boolean isAdmin;
    static Integer userIndex;

    public static void main(String[] args) {
        // write your code here
        userList.add(new User("alex", "asd", 1, 9, 6, "slave"));
        userList.add(new User("chips", "asd", 2, 3, 4, "asd"));
        System.out.println("Welcome to the Payrollsystem!");
       /* Admin.plusOneMonth();*/
        System.out.println(userList.size()+1);
        boolean inMenu = true;
        while (inMenu) {
            Login.run();
        if (!isAdmin) {
            userOptions();
        } else {
            adminOptions();
        }


        }

    }



    public static void userOptions() {

        Scanner scanUserInput = new Scanner(System.in);
        int userInput;
        boolean menuOptions = true;

        while (menuOptions) {

            System.out.println("\n Things to do as user: " + userList.get(userIndex).getUsername() +
                    "\n1 View your Account balance \n" +
                    "2 View your Salary \n" +
                    "3 View your Role \n" +
                    "4 Request higher salary \n" +
                    "5 Delete your account \n"+
                    "6 Log out"
            );

            userInput = scanUserInput.nextInt();

            switch (userInput) {
                case 1:
                    User.viewAccountBalance();
                    break;
                case 2:
                    User.viewSalary();
                    break;
                case 3:
                    User.viewRole();
                    break;
                case 4:
                    User.requestHigherSalary();
                    break;
                case 5:
                    User.deleteAccount();
                    break;
                case 6:
                    menuOptions = false;
                    break;

            }

        }
    }

    public static void adminOptions() {

        Scanner scanUserInput = new Scanner(System.in);
        int adminInput;
        boolean menuOptions= true;
        while (menuOptions) {
            System.out.println("\n Things to do as Admin: \n" +
                    "1 View your Account balance \n" +
                    "2 View your Salary \n" +
                    "3 View your Role \n" +
                    "4 View Users and their Passwords\n" +
                    "5 View User Requests\n" +
                    "6 Create User\n" +
                    "7 Delete Users\n"+
                    "8 Plus one month\n" +
                    "9 Log out"

            );

            adminInput = scanUserInput.nextInt();

            switch (adminInput) {
                case 1:
                    Admin.viewAccountBalance();

                    break;
                case 2:
                    Admin.viewSalary();

                    break;
                case 3:
                    Admin.viewRole();
                    break;
                case 4:
                    Admin.viewUsersPasswords();
                    break;
                case 5:
                    Admin.viewRequests();
                    break;
                case 6:
                    Admin.createUser();

                    break;
                case 7:
                    Admin.deleteUsers();
                    break;
                case 8:
                    Admin.plusOneMonth();
                    break;
                case 9:
                    menuOptions = false;
                    break;

                default:
            }
        }
    }


}



/*
    public static void menu() {
        int menuInput = 0;
        Scanner choose = new Scanner(System.in);
        System.out.print("1 Admin login, 2 User login, 3 Quit.");
        try {
            menuInput = choose.nextInt();
        } catch (Exception InputMismatchException) {
            System.out.println("Invalid choice.");

            menu();

        }
        switch (menuInput) {
            case 1:
                adminOptions();
                break;
            case 2:
                userOptions();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }*/
