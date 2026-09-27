import java.util.Comparator;
class comparator implements Comparator<Student>{

    @Override
    public int compare(Student student1, Student student2) {
        return student1.name.compareToIgnoreCase(student2.name);
    }
}

class RollNoComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return Integer.compare(student1.rollno, student2.rollno);
    }
}

