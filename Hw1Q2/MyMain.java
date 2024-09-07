import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        LinkedList<Person> personList = new LinkedList<>();
        
        try {
            // Creates a FileInputStream from the data file
            FileInputStream fis = new FileInputStream("data.txt");
            store(fis, personList);
            
            // will show all the persons in the list
            display(System.out, personList);
            
            // Test the find function
            String searchId = "123"; 
            int index = find(searchId, personList);
            if (index != -1) {
                System.out.println("Person with ID " + searchId + " found at index " + index);
            } else {
                System.out.println("Person with ID " + searchId + " not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read from input and store in the linkedlist
    public static void store(InputStream inputStream, LinkedList<Person> list) {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            if (data.length == 3) {
                Person person = new Person(data[0].trim(), data[1].trim(), data[2].trim());
                list.add(person);
            }
        }
        scanner.close();
    }

    // function so show all the list of person
    public static void display(PrintStream outputStream, LinkedList<Person> list) {
        for (Person person : list) {
            outputStream.println(person);
        }
    }

    // function to find a person by ID
    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }
}
