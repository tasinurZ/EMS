import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;

public class AddEmployee {
    AddEmployee(){
        Scanner obj = new Scanner(System.in);
        Scanner obj2 = new Scanner(System.in);
        Scanner obj3 = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        String name = obj.nextLine();
        System.out.print("Enter Employee ID: ");
        int id = obj.nextInt();
        System.out.print("Enter Employee Performance: ");
        String performance = obj2.nextLine();
        System.out.print("Enter Employee Salary: ");
        int salary = obj2.nextInt();
        System.out.print("Enter Employee Position: ");
        String position = obj3.nextLine();
        try(MongoClient mongoClient = new MongoClient("localhost", 27017)) {
            MongoDatabase db = mongoClient.getDatabase("admin");
            MongoCollection<Document> employeeCollection = db.getCollection("Employeeinfo");
            Document doc= new Document("Name",name)
                    .append("ID",id)
                    .append("Performance",performance)
                    .append("Salary",salary)
                    .append("Position",position);
            employeeCollection.insertOne(doc);
        }
        EmployeeDatabase ed = new EmployeeDatabase();
    }
}
