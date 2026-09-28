import java.util.ArrayList;
import java.util.Comparator;
public class SelectionSort {
  public static void selectionSort(ArrayList<Student> students, Comparator<Student> comparator) {
    //for loop to sort algorithm
    for (int i = 0; i < students.size() - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < students.size(); j++) {
        //starts with the next student
        if (comparator.compare(students.get(j), students.get(minIndex)) < 0) {
          minIndex = j;
          }
      }
      Student temp = students.get(i);
      students.set(i, students.get(minIndex));
      students.set(minIndex, temp);
    }
  }
}