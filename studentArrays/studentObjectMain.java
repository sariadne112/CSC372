import java.util.ArrayList;

public class studentObjectMain {
  public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(105, "Maria", "California"));
        students.add(new Student(102, "James", "Texas"));
        students.add(new Student(109, "Sofia", "Arizona"));
        students.add(new Student(101, "Daniel", "Michigan"));
        students.add(new Student(108, "Emily", "Nevada"));
        students.add(new Student(103, "Carlos", "Florida"));
        students.add(new Student(110, "Olivia", "Colorado"));
        students.add(new Student(104, "Anthony", "Ohio"));
        students.add(new Student(107, "Isabella", "New Mexico"));
        students.add(new Student(106, "Michael", "New York"));

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
}
}