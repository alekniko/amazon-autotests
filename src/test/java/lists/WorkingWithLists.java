package lists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WorkingWithLists {

    @Test
    public void createAndWorkWithLists() {
        Student valera = new Student();
        valera.setFirstName("Valera");
        valera.setLastName("The Tester");
        valera.setEmail("valerunchik@test.lv");
        valera.setPhoneNumber("+37129232323");

        Student liga = new Student("Liga", "Ivanova", "liga@test.lv", "+37229445566");
        Student dimko = new Student("Dimko", "Skatinishe", "omg@test.lv", "+37129777888");
        Student artis = new Student("Artis", "Greatest", "", "+37229333888");

        List<Student> students = new ArrayList<>();
        students.add(valera);
        students.add(liga);
        students.add(dimko);
        students.add(artis);

//        ____________________FOR____________________
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getFirstName());
        }

//        ____________________FOR_EACH_______________

        for (Student s : students
        ) {
            System.out.println(s.getFirstName() + " " + s.getLastName());
            System.out.println("Using method");
            System.out.println(s.getFullName());
        }

//        For each with if
        System.out.println("Printing students with phone Nr starting with +371");
        for (Student s: students
             ) {
            if (s.getPhoneNumber().contains("+371")) {
                System.out.println(s.getFullName() +" " + s.getPhoneNumber());

            }
        }
    }
}
