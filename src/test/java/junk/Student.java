package junk;

public class Student implements Comparable {

    public String surname;
    public String name;
    public int year;
    public int course;
    public int groupNumber;
    public int firstLessonNumber;
    public int secondLessonNumber;
    public int thirdLessonNumber;
    public int fourLessonNumber;
    public int fiveLessonNumber;

    public Student(String surname, String name, int year, int course, int groupNumber, int firstLessonNumber,
                   int secondLessonNumber, int thirdLessonNumber, int fourLessonNumber, int fiveLessonNumber) {
        this.surname = surname;
        this.name = name;
        this.year = year;
        this.course = course;
        this.groupNumber = groupNumber;
        this.firstLessonNumber = firstLessonNumber;
        this.secondLessonNumber = secondLessonNumber;
        this.thirdLessonNumber = thirdLessonNumber;
        this.fourLessonNumber = fourLessonNumber;
        this.fiveLessonNumber = fiveLessonNumber;
    }

    @Override
    public int compareTo(Object o) {
        Student m = (Student) o;
        return Integer.compare(course, m.course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", course=" + course +
                ", groupNumber=" + groupNumber +
                ", firstLessonNumber=" + firstLessonNumber +
                ", secondLessonNumber=" + secondLessonNumber +
                ", thirdLessonNumber=" + thirdLessonNumber +
                ", fourLessonNumber=" + fourLessonNumber +
                ", fiveLessonNumber=" + fiveLessonNumber +
                '}';
    }
}
