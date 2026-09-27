import java.util.Comparator;
import java.util.ArrayList;

public class studentObject {
  int rollno;
  String name;
  String address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
  // 
    @Override
    public String toString() {
        return rollno + " | " + name + " | " + address;
    }
}

public class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.name.compareToIgnoreCase(student2.name);
    }
}

public class SelectionSort {

    public static void selectionSort(
            ArrayList<Student> students,
            Comparator<Student> comparator) {

        for (int i = 0; i < students.size() - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < students.size(); j++) {

                if (comparator.compare(
                        students.get(j),
                        students.get(minIndex)) < 0) {

                    minIndex = j;
                }
            }

            Student temp = students.get(i);
            students.set(i, students.get(minIndex));
            students.set(minIndex, temp);
        }
    }



    public static void printStudents(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

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