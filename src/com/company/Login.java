package com.company;

import java.util.Scanner;

import static com.company.Admin.userList;
import static com.company.Main.*;

public class Login {

    public static void run() {

        boolean login = false;

        while (!login) {

            System.out.println("LOGIN \nUsername:");
            Scanner scan = new Scanner(System.in);

            String user = scan.nextLine();
            System.out.println("Password:");
            String pass = scan.nextLine(); // looks at selected file in scan

            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUsername().equals(user) && pass.equals(userList.get(i).getPassword())) {
                    login= true;
                    isAdmin = false;
                    userIndex = i;
                    break;
                }
            }

            if (user.equals(boss.getUsername()) && pass.equals(boss.getPassword()) ) {
                System.out.println("Login in...");
                login= true;
                isAdmin = true;
                break;
            }
            if(!login) {
                System.out.println("Wrong Password or Username");
            }
        }
    }
}


/* if (pass.equals(userList.get(0).getPassword())) {
                System.out.println("right Password");
            } else {
                System.out.println("wrong");
            }*/
/*
Admin.setLoginAsAdmin(true);

        Admin chips = new Admin();
       */
/*chips.setLoginAsAdmin(true);
        chips.isLoginAsAdmin();
        testUser.setUsername("chips");*//*


        String inpUser = keyboard.nextLine();
        String inpPass = keyboard.nextLine(); // gets input from user
//&& inpPass.equals(pass)

        if (inpUser.equals(Admin.getUsername(0)) ) {
            System.out.print("your login message");
        } else {
            System.out.print("your error message");
        }
    }
}
*/
 /*  if (user.equals(userList.get(0).getUsername()) && pass.equals(userList.get(0).getPassword()) ) {
                System.out.println("Login in...");
                login= true;
                isAdmin = false;
            }*/
