import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;

public class SearchEmployee {
    SearchEmployee(){
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter employee name:");
        String n = obj.nextLine();
        try(MongoClient mongoClient = new MongoClient("localhost",27017)){
            MongoDatabase db = mongoClient.getDatabase("admin");
            MongoCollection<Document> employeeCollection = db.getCollection("Employeeinfo");
            Document doc = employeeCollection.find(new Document("Name", n)).first();
            if(doc != null){
                System.out.println("\nEmployee Name\t\tID\t\tPerformance\t\tSalary\t\tPosition");
                System.out.print(doc.getString("Name")+"\t\t\t\t"+doc.getInteger("ID")+"\t"+doc.getString("Performance"));
                System.out.print("\t\t\t\t"+doc.getInteger("Salary")+"\t\t"+doc.getString("Position"));
                System.out.println();
            }
            else{
                System.out.println("No Employee Found");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
