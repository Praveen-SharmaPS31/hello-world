import java.util.Scanner;
import java.util.ArrayList;

public class HR
{
     static void display()
     {
        System.out.println("***********HR MANAGEMENT***********");
        System.out.println("1.Add Employee ");
        System.out.println("2.Remove Employee");
        System.out.println("3.Display Employee Details ");
        System.out.println("4.Exit");
        System.out.println("***********************************");
        System.out.print("What do you want to do ? : ");
    }

    public static void main(String[] args)
    {
        System.out.println('\u000c');
        ArrayList<Employee> list = new ArrayList<Employee>();                   //
        int no_of_emp, count = 0;
        String name_of_emp, email, nEmail;
        long phone, nPhone;
        long  uid, pick_ID, dID;
        boolean found=false;
        Scanner input = new Scanner(System.in);
        while (true)
        {
            display();
            int choice = input.nextInt();

            while (choice < 1 || choice > 5)
            {
                System.out.println("Invalid Input ..!!");
                System.out.print("Re-enter : ");
                choice = input.nextInt();
            }

            if (choice == 1)
            {
                System.out.println("----------------------------------------");
                System.out.print("Enter the number of Employees : ");
                no_of_emp = input.nextInt();
                System.out.println("----------------------------------------");

                System.out.println("Enter Details of Employee(s)");

                for (int i = 0; i < no_of_emp; i++)
                {
                    System.out.println("-------------EMPLOYEE[" + (i + 1) + "]-------------");
                    System.out.print("\nUID : ");
                    uid = input.nextLong();
                    System.out.print("\nName  : ");
                    name_of_emp = input.next();
                    System.out.print("\nE-mail ID : ");
                    email = input.next();
                    System.out.print("\nPhone No : ");
                    phone = input.nextLong();
                    System.out.println("---------------------------------------------");
                    list.add(new Employee(uid, name_of_emp, email, phone));
                    count++;
                }
            }
            else if (choice == 2)
            {
                if (count == 0)
                {
                    System.out.println("Sorry Record is Empty ..!!");
                }
                else
                {
                    System.out.print("Enter the UID of Employee : ");
                    pick_ID = input.nextLong();
                    found = false;
                    for (Employee s : list)
                    {
                        if (s.ID == pick_ID /*&& !found*/)
                        {
                            found=true;
                            for (int i = 0; i < list.size(); i++)
                            {
                                if (list.get(i) == s)
                                {
                                    list.remove(i);
                                }
                            }
                            System.out.println("Employee Details Deleted from Record .!!");

                        }
                        if (found==false)
                        {
                            System.out.println("No Employee with that ID exists in our Record .");
                            System.exit(0);
                        }
                    }

                }
            }

            else if (choice == 3)
            {
                if (count == 0)
                {
                    System.out.println("Sorry Record is Empty ..!!");
                }
                else
                {
                    System.out.println("Enter the UID of employee : ");
                    dID = input.nextInt();
                    found = false;
                    for (Employee s : list)
                    {
                        if (s.ID == dID && !found)
                        {
                            found = true;
                            System.out.println("**************************************************");
                            System.out.println("UID : " + s.ID);
                            System.out.println("Name : " + s.Name);
                            System.out.println("Phone : " + s.Phone);
                            System.out.println("E-mail ID : " + s.Email);
                            System.out.println("**************************************************");
                        }
                        if (found==false)
                        {
                            System.out.println("No Employee with that ID.");
                        }
                    }
                }
            }
            else
            {
                System.out.println("Good Bye ..! You can close this window ");
                System.exit(0);
            }
        }
    }
}

class Employee
{
    public long ID;
    public String Name;
    public String Email;
    public long Phone;

    public Employee(long id,String name,String email,long phone)
    {
        this.ID=id;
        this.Name=name;
        this.Email=email;
        this.Phone=phone;
    }
    public void setEmail(String nemail)
    {
        this.Email=nemail;
    }
    public void setPhone(long nphone)
    {
        this.Phone=nphone;
    }
}
