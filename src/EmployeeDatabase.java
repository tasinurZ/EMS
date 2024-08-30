import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;

public class EmployeeDatabase {
    EmployeeDatabase(){
        try(MongoClient mongoClient = new MongoClient("localhost", 27017);){
            MongoDatabase database = mongoClient.getDatabase("admin");
            System.out.println("\nEmployee Name\t\tID\t\tPerformance\t\tSalary\t\tPosition");
            MongoCollection<Document> employeeCollection = database.getCollection("Employeeinfo");
            FindIterable<Document> Iterable = employeeCollection.find();
            Iterator<Document> iterator = Iterable.iterator();
            while(iterator.hasNext()){
                Document document = iterator.next();
                System.out.print(document.getString("Name")+"\t\t\t\t"+document.getInteger("ID")+"\t"+document.getString("Performance"));
                System.out.print("\t\t\t\t"+document.getInteger("Salary")+"\t\t"+document.getString("Position"));
                System.out.println();
            }
        }
    }
}
