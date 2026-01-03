import models.Employee;
import models.Person;
import models.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) throws FileNotFoundException {
        File studentFile = new File("C:\\Users\\User\\IdeaProjects\\Assignment2\\src\\source\\students_data");
        File employeeFile = new File("C:\\Users\\User\\IdeaProjects\\Assignment2\\src\\source\\employees_data");

        Scanner studentScanner = new Scanner(studentFile);
        Scanner employeeScanner = new Scanner(employeeFile);

        ArrayList<Person> list = new ArrayList<>();

        while (studentScanner.hasNextLine()) {
            String line = studentScanner.nextLine();
            String[] parts = line.split(", ");
            if (parts.length == 3) {
                String name = parts[0];
                String surname = parts[1];
                double gpa = Double.parseDouble(parts[2]);
                list.add(new Student(name, surname, gpa));
            }
        }

        while (employeeScanner.hasNextLine()) {
            String line = employeeScanner.nextLine();
            String[] parts = line.split(", ");
            if (parts.length == 4) {
                String name = parts[0];
                String surname = parts[1];
                String position = parts[2];
                double salary = Double.parseDouble(parts[3]);
                list.add(new Employee(name, surname, position, salary));
            }
        }

        studentScanner.close();
        employeeScanner.close();


        for (Person person : list) {
            System.out.println(person + " earns " + person.getPaymentAmount() + " tenge");

        }

    }
}