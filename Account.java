package assignment1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Account {

    ArrayList<Student> account;

    public Account()
    {
        account = new ArrayList<Student>();
    }

    public boolean createAccount(Student student) throws IOException, ClassNotFoundException {
    	
    	String fileName="accountFile" ;

        File file = new File(fileName);

        if(file.exists())
        {
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream objectInput = new ObjectInputStream(fin);
            ArrayList<Student> myStudent = (ArrayList<Student>)objectInput.readObject();

            account.clear();

            for(Student st : myStudent)
            {
                account.add(st);
            }

            for(int i=0; i<myStudent.size(); i++)
            {
                Student s = myStudent.get(i);
                if (s.accountNumber.equals(student.accountNumber))
                        return false;
            }
        }

        account.add(student);
        FileOutputStream fout = new FileOutputStream(new File(fileName));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);
        objectOutputStream.writeObject(account);

        return true;
    }

    public boolean login(String accountNumber, String password) throws IOException, ClassNotFoundException {

    	String fileName="accountFile" ;
        File file = new File(fileName);

        if(file.exists())
        {
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream object = new ObjectInputStream(fin);
            ArrayList<Student> tmpStudent = (ArrayList<Student>) object.readObject();

            for(int i=0; i<tmpStudent.size(); i++)
            {
                if (tmpStudent.get(i).accountNumber.equals(accountNumber) && tmpStudent.get(i).password.equals(password))
                        return true;

            }
        }

        return false;
    }

    public boolean withDraw(String accountNumber, double ammount) throws IOException, ClassNotFoundException {

    	String fileName="accountFile" ;
        if(ammount<500)
            return false;

        File file = new File(fileName);

        if(file.exists())
        {
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream object = new ObjectInputStream(fin);
            ArrayList<Student> tmpStudent = (ArrayList<Student>) object.readObject();

            account.clear();

            for(Student s : tmpStudent)
            {
                account.add(s);
            }

            for(int i=0; i<account.size(); i++)
            {
                Student s = account.get(i);
                if (s.accountNumber.equals(accountNumber))
                {
                    if(s.ammount<ammount)
                        return false;

                    s.ammount = s.ammount - ammount;
                    account.set(i, s);
                    FileOutputStream fout = new FileOutputStream(new File(fileName));
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);
                    objectOutputStream.writeObject(account);

                    return true;
                }
            }
        }
        return false;
    }

    public boolean diposite(String accountNumber, double ammount) throws IOException, ClassNotFoundException {

    	String fileName="accountFile" ;
        if(ammount<0)
            return false;

        File file = new File(fileName);

        if(file.exists())
        {
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream object = new ObjectInputStream(fin);
            ArrayList<Student> tmpStudent = (ArrayList<Student>) object.readObject();

            account.clear();

            for(Student s : tmpStudent)
            {
                account.add(s);
            }

            for(int i=0; i<account.size(); i++)
            {
                Student s = account.get(i);
                if (s.accountNumber.equals(accountNumber))
                {
                    s.ammount = s.ammount + ammount;
                    account.set(i, s);
                    FileOutputStream fout = new FileOutputStream(new File(fileName));
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);
                    objectOutputStream.writeObject(account);

                    return true;
                }
            }
        }
        return false;
    }

    public void printInfo(String accountNumber) throws IOException, ClassNotFoundException {
    	String fileName="accountFile" ;
        File file = new File(fileName);

        if(file.exists())
        {
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream object = new ObjectInputStream(fin);
            ArrayList<Student> tmpStudent = (ArrayList<Student>) object.readObject();

            for(int i=0; i<account.size(); i++)
            {
                Student s = account.get(i);
                if (s.accountNumber.equals(accountNumber))
                {
                    System.out.println("Name: " + s.name);
                    System.out.println("Account Number: " + s.accountNumber);
                    System.out.println("Ammount: " + s.ammount + " taka only");
                    System.out.println("Password: " + s.password);
                    System.out.println();

                    return;
                }
            }
        }
    }

    public void printInfo() throws IOException, ClassNotFoundException {
    	String fileName="accountFile" ;
        File file = new File(fileName);

        if(file.exists())
        {
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream object = new ObjectInputStream(fin);
            ArrayList<Student> tmpStudent = (ArrayList<Student>) object.readObject();

            for(int i=0; i<account.size(); i++)
            {
                Student s = account.get(i);

                System.out.println("Name: " + s.name);
                System.out.println("Account Number: " + s.accountNumber);
                System.out.println("Ammount: " + s.ammount + " taka only");
                System.out.println("Password: " + s.password);
                System.out.println();
            }
        }
    }



}
