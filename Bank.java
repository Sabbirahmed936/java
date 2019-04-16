package assignment1;


import java.io.IOException;

public class Bank {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Account acc = new Account();

        Student student1 = new Student();
        student1.name = "Sabbir";
        student1.accountNumber = "400";
        student1.password = "1234";
        student1.ammount = 10000;

        Student student2 = new Student();
        student2.name = "Sabbir";
        student2.accountNumber = "400";
        student2.password = "1234";
        student2.ammount = 100000;

        
        if(acc.createAccount(student1)==true)System.out.println("Done");
        if(acc.createAccount(student2)==false)System.out.println("Account Already Exists");
   
        acc.printInfo();

        if(acc.login("400", "1234")==true)System.out.println("Log in Successful");
        if(acc.login("400", "1234")==false)System.out.println("Log in failed");
        
       
        acc.printInfo("400");
        System.out.println(acc.withDraw("400", 100));
        System.out.println(acc.diposite("400", 500));
        acc.printInfo("b");


   }

}
