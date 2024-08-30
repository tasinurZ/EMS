import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.Scanner;

public class DeleteEmployee {
    DeleteEmployee(){
        System.out.print("Enter Employee Name:");
        Scanner obj = new Scanner(System.in);
        String name = obj.nextLine();
        try(MongoClient mongoClient = new MongoClient("localhost",27017)){
            MongoDatabase db = mongoClient.getDatabase("admin");
            MongoCollection<Document> employeecollection = db.getCollection("Employeeinfo");
            DeleteResult result = employeecollection.deleteOne(Filters.eq("Name",name));
            System.out.println("Employee deleted successfully");
        }
    }
}
