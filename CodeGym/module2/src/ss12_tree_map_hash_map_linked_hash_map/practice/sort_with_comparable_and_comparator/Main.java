package ss12_tree_map_hash_map_linked_hash_map.practice.sort_with_comparable_and_comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1,"Kien", 30);
        Student student1 = new Student(1,"Nam", 28);
        Student student2 = new Student(1,"Hoa", 31);
        Student student3 = new Student(1,"Hung", 29);


        ArrayList<Student> lists = new ArrayList<Student>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        Collections.sort(lists);
        for(Student st : lists){
            System.out.println(st.toString());
        }

        AgeComparator ageComparator = new AgeComparator();
        lists.sort(ageComparator);
        System.out.println("So sanh theo tuoi:");
        for(Student st : lists){
            System.out.println(st.toString());
        }
    }


}
