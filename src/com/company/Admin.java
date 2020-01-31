package com.company;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static com.company.Main.admin1;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Admin extends Account {

    private String username;
    private String password;
    private String role;
    private Integer id;
    private Integer accountBalance;
    private Integer salary;
    public static List<User> userList = new ArrayList<User>();


    //Admin constructor
    public Admin(String newusername, String newpassword, int newid, int newaccountBalance, int newsalary, String newrole) {
        super(newusername, newpassword, newid, newaccountBalance, newsalary, newrole);
        username = newusername;
        password = newpassword;
        id = newid;
        accountBalance = newaccountBalance;
        salary = newsalary;
        role = newrole;
    }
    // Method that checks if a string contains a number
    public static boolean stringContainsNumber( String userName ) {

        return Pattern.compile( "[0-9]" ).matcher( userName).find();
    }

    // Method that the admin uses to create a new User and puts it in the userlist.
    public static void createUser() {

        Scanner scan = new Scanner(System.in);
        String username;
        String password;
        Integer id = 1;
        Integer accountBalance;
        Integer salary;
        String role;

        System.out.println("Username:");

        while(true){
            username = scan.next();
            if(stringContainsNumber(username)){
                break;
            }
            System.out.println("Username needs at least 1 number");
        }

        System.out.println("Role:");
        role = scan.nextLine();
        System.out.println("Password:");

        while(true){
            password = scan.next();
            if(stringContainsNumber(password)){
                break;
            }
            System.out.println("Password needs at least 1 number");
        }

        // Takes the size of the Arraylist and just add increase with one, to set the new Id
        id= userList.size()+1;

        System.out.println("AccountBalance:");
        accountBalance = scan.nextInt();
        System.out.println("Salary:");
        salary = scan.nextInt();

        User newUser = new User(username, password, id, accountBalance, salary, role);

        userList.add(newUser);
        System.out.println("List of Users:");
        userList.forEach(user -> {
            System.out.println("Name : " + user.getUsername() + " | Id : " + user.getId());
        });
    }

    // Prints out all the users UserNames and Passwords with a foreach and get methods.
    public static void viewUsersPasswordsUsername() {
        userList.forEach(user -> {
            System.out.println("Name : " + user.getUsername() + " | Password : " + user.getPassword());
        });

    }

    // Simulate one month passing by increasing the users and admins Account balance with there salary.
    public static void plusOneMonth() {

      System.out.println("One month has now passed, the users account balance is now: ");

      userList.forEach(user -> {
          user.setAccountBalance(user.getSalary()+user.getAccountBalance());
          System.out.println(user.getUsername() + "| Account balance: " + user.getAccountBalance() );
      });

      admin1.setAccountBalance(admin1.getSalary()+admin1.getAccountBalance());

    }

    // Using a get method to view the admins Account Balance
    public static void viewAccountBalance() {
        System.out.println("Your account balance is:" + admin1.getAccountBalance());
    }

    // Using a get method to view the admins Salary
    public static void viewSalary() {
        System.out.println("Your salary is:" + admin1.getSalary());
    }
    // Using a get method to view the admins role
    public static void viewRole() {
        System.out.println("Your role is:" + admin1.getRole());
    }


    // View the Requests that the users have send by looking at there object to see if there request variable.
    // You can choose if you want to grant there request.

    public static void viewRequests() {
        Scanner scan = new Scanner(System.in);
        System.out.println("List of Requests:");
        userList.forEach(user -> {
            System.out.println(user.getUsername() + "| Salary Request: " + user.getRequest() + " | Role Request: " + user.getrRequest());
        });
        System.out.println("Do you want to grant a request?");
        String input = scan.nextLine();

        if (input.equals("Y") || input.equals("y")) {

            System.out.println("which user:");
            String username = scan.nextLine();
            boolean test= true;

            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUsername().equals(username)) {

                    System.out.println("Their Salary or Role? Salary:1 Role:2");
                    int rOrS = scan.nextInt();

                    switch (rOrS) {
                        case 1:
                            for (int e = 0; e < userList.size(); e++) {
                                if (userList.get(e).getUsername().equals(username)) {
                                    userList.get(e).setSalary(userList.get(e).getRequest());
                                }
                            }
                            System.out.println("Users Salary is now changed");
                            break;
                        case 2:

                            for (int e = 0; e < userList.size(); e++) {
                                if (userList.get(e).getUsername().equals(username)) {
                                    userList.get(e).setRole(userList.get(e).getrRequest());
                                }
                            }
                            System.out.println("Users Role is now changed");
                            break;
                    }
                    test= false;
                    break;
                }
            }
            while (test) {
                System.out.println("invalid user");
                break;
            }
        }
        else {
            System.out.println("Request denied");
        }

    }


    // By typing the users Username and password the admin can delete a user.
    public static void deleteUsers() {
        System.out.println("List of Users:");
        userList.forEach(user -> {
            System.out.println("User: "+ user.getUsername()+" | Password: "+ user.getPassword());

        });
        System.out.println("Name of User you want to delete:");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String password = scan.nextLine();

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username) && password.equals(userList.get(i).getPassword())) {
                userList.remove(i);
            }
        }
    }

    //Getters and setters
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


  /*if(input.equals("Y") || input.equals("y") ) {
            userList.get(0).setSalary(userList.get(0).getRequest());
        }*/


 /*for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUsername().equals(username)) {
                    userList.get(i).setSalary(userList.get(i).getRequest());
                }
            }*/
 /*   try {
            username = scan.nextLine();
        } catch (Exception InputMismatchException) {
            System.out.println("Wrong input");
            username = "chips";
        }*/


 /*boolean wrongInput;

        System.out.println("Id:");
        wrongInput = false;*/

     /*   while(true) {
            System.out.println("Id");
            id = scan.next();
            try {
                Integer.valueOf(id);
            }
            catch (NumberFormatException ne) {
                System.out.println("do right bitch");
            }
        }*/
 /*    do{

         try {
             System.out.println("tset");
             id = scan.nextInt();
             break;
         } catch (Exception InputMismatchException) {
             System.out.println("Wrong input");




         } }while (true);*/

/*

    final ScheduledExecutorService executor = null;
    Runnable task = new Runnable() {
        @Override
        public void run() {
            ZonedDateTime now = ZonedDateTime.now();
            long delay = now.until(now.plusMonths(1), ChronoUnit.MILLIS);

            try {
                // ...
            } finally {
                executor.schedule(this, delay, TimeUnit.MILLISECONDS);
            }
        }
    };

    int dayOfMonth = 5;

    ZonedDateTime dateTime = ZonedDateTime.now();
        if (dateTime.getDayOfMonth() >= dayOfMonth) {
                dateTime = dateTime.plusMonths(1);
                }
                dateTime = dateTime.withDayOfMonth(dayOfMonth);
                executor.schedule(task,
                ZonedDateTime.now().until(dateTime, ChronoUnit.MILLIS),
                TimeUnit.MILLISECONDS);

                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                System.out.println(dateFormat.format(date));

                date.setMonth(+1);
                System.out.println(dateFormat.format(date));




                ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
                for (Date d : date) {
                long millis = d.getTime() - System.currentTimeMillis();
                service.schedule(new SmsSenderTask(text, phoneNumbers), millis, TimeUnit.MILLISECONDS);
                }
*/


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


       /* userList.forEach(user -> {
            System.out.println("List of Users and their Passwords\n" + "Name : " + user.getUsername() + " Password : " + user.getPassword()
                    + " Id : " + user.getId()
                    + " AccountBalance : " + user.getAccountBalance()
                    + " Salary : " + user.getSalary()
                    + " Role : " + user.getRole())
            ;
        });*/