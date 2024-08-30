import java.util.Scanner;

public class Login {
    Login() {
        System.out.println("\n\t\t\t\t\t\tEmployee Management System");
        boolean relogin = false;
        int count = 0;
        while (relogin == false) {
            Scanner obj = new Scanner(System.in);
            System.out.print("\n\t\t\t\t\t\tEnter Username:");
            String x1 = obj.nextLine();
            System.out.print("\n\t\t\t\t\t\tEnter Password:");
            String y1 = obj.nextLine();
            String x2 = "admin";
            String y2 = "admin";
            if (x1.equals(x2) && y1.equals(y2)) {
                System.out.println("\n\t\t\t\t\t\t\tYou have successfully logged in!");
                relogin = true;
                count = 1;
            } else {
                System.out.println("\n\t\t\t\t\t\tYou have not successfully logged in!");
            }
        }
        if (count != 0) {
            Function f1 = new Function();
        }
    }
}
