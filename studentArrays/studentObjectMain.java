import java.util.ArrayList;

public class StudentObjectMain {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(2101, "Maria", "California"));
        students.add(new Student(2102, "Nicholas", "Texas"));
        students.add(new Student(2209, "Sofia", "Arizona"));
        students.add(new Student(2103, "Yuri", "Michigan"));
        students.add(new Student(3108, "Emily", "Nevada"));
        students.add(new Student(3103, "Carlos", "Florida"));
        students.add(new Student(2110, "Olivia", "Colorado"));
        students.add(new Student(2104, "Andres", "Ohio"));
        students.add(new Student(2107, "Isabel", "New Mexico"));
        students.add(new Student(3106, "Michael", "Colorado"));

        System.out.println("Original Student List:");
        printStudents(students);

        // Sort by name
        SelectionSort.selectionSort(
                students, new NameComparator());

        System.out.println("\nStudents Sorted by Name:");
        printStudents(students);

        // Sort by roll number
        SelectionSort.selectionSort(
                students, new RollNoComparator());

        System.out.println("\nStudents Sorted by Roll Number:");
        printStudents(students);
    }

    public static void printStudents(ArrayList<Student> students) {

        for (Student student : students) {
            System.out.println(student);
        }
    }
}