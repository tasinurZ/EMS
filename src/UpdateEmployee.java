import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.Map;
import java.util.Scanner;

public class UpdateEmployee {
    UpdateEmployee(){
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        System.out.print("Enter Employee Name Whom You Want to Update:");
        String name = sc.nextLine();
        System.out.print("Enter Updated ID:");
        int id = sc.nextInt();
        System.out.print("Enter Updated Salary:");
        int salary = sc2.nextInt();
        System.out.print("Enter Updated Performance:");
        String performance = sc3.nextLine();
        System.out.print("Enter Updated Position:");
        String position = sc3.nextLine();
        try(MongoClient mongoClient = new MongoClient("localhost",27017)) {
            MongoDatabase db = mongoClient.getDatabase("admin");
            MongoCollection<Document> employeecollection = db.getCollection("Employeeinfo");
            FindOneAndUpdateOptions options = new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER);
            Document doc = employeecollection.findOneAndUpdate(Filters.eq("Name",name),Updates.set("ID",id));
            Document doc2 = employeecollection.findOneAndUpdate(Filters.eq("Name",name),Updates.set("Salary",salary));
            Document doc3 = employeecollection.findOneAndUpdate(Filters.eq("Name",name),Updates.set("Performance",performance));
            Document doc4= employeecollection.findOneAndUpdate(Filters.eq("Name",name),Updates.set("Position",position));
            EmployeeDatabase ed = new EmployeeDatabase();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
