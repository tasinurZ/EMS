import java.util.Scanner;

public class Function {
    Function(){
        boolean exit = false;
        while(exit != true){
            System.out.println("\nWelcome to Employee Management System");
            System.out.println("Choose an operation to perform");
            System.out.println("1 - Employee Database");
            System.out.println("2 - Search Employee");
            System.out.println("3 - Add Employee");
            System.out.println("4 - Delete Employee");
            System.out.println("5 - Update Employee");
            System.out.println("6 - Exit");
            System.out.print("Enter your choice: ");
            Scanner obj = new Scanner(System.in);
            int choice = obj.nextInt();
            switch(choice){
                case 1:
                    EmployeeDatabase ed = new EmployeeDatabase();
                    break;
                case 2:
                    SearchEmployee se = new SearchEmployee();
                    break;
                case 3:
                    AddEmployee ae = new AddEmployee();
                    break;
                case 4:
                    DeleteEmployee de = new DeleteEmployee();
                    break;
                case 5:
                    UpdateEmployee ue = new UpdateEmployee();
                    break;
                case 6:
                    System.out.println("\nE X I T E D");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
