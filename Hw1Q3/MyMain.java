import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        PersonList personList = new PersonList();
        
        try {
            // Create a FileInputStream from the data file
            FileInputStream fis = new FileInputStream("data.txt");
            personList.store(fis);
            
            // Display all persons in the list
            personList.display(System.out);
            
            // Test the find method
            String searchId = "0911"; // Replace with an appropriate ID for testing
            int index = personList.find(searchId);
            if (index != -1) {
                System.out.println("Person with ID " + searchId + " found at index " + index);
            } else {
                System.out.println("Person with ID " + searchId + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
