import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class PersonList {
    private LinkedList<Person> list;

    // getting it constructed
    public PersonList() {
        this.list = new LinkedList<>();
    }

    // Function to read data and store it in the list
    public void store(InputStream inputStream) {
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

    // function to display all persons
    public void display(PrintStream outputStream) {
        for (Person person : list) {
            outputStream.println(person);
        }
    }

    // funciton to find a person by ID in the list
    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }
}
