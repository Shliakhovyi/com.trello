package junk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test6 {
    //Дан список студентов. Элемент списка содержит фамилию, имя, отчество, год рождения, курс, номер группы, оценки по
    // пяти предметам. Упорядочите студентов по курсу, причем студенты одного курса располагались в алфавитном порядке.
    // Найдите средний балл каждой группы по каждому предмету. Определите самого старшего студента и самого младшего
    // студентов. Для каждой группы найдите лучшего с точки зрения успеваемости студента.

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Vasilkin", "Vasya", 1993, 5, 3,
                2, 5, 4, 3 ,2));
        students.add(new Student("Petrin", "Petya", 1995, 3, 2,
                2, 1, 3, 3 ,2));


        System.out.println("Упорядочить по курсу: ");
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
