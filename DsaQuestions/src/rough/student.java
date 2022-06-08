package rough;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class student {
    int rollNo;
    String name;

    public student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public static void print(){

        System.out.println("called");
    }
    public void printme(){

        System.out.println("me printed");
    }

    public static void main(String[] args) {
//        int[] arr={1,2,3};
//        ArrayList<int[]> list= new ArrayList<int[]>();
//
//        int[] arr1={2,3,1};
//        int[] arr2={3,1,2};
//        list.add(arr);
//        list.add(arr1);
//        list.add(arr2);


    // sorting the objects:
        ArrayList<student> list1= new ArrayList<>();
        list1.add(new student(1,"krishan"));
        list1.add(new student(2,"harish"));
        Collections.sort(list1, new Comparator<student>() {
            @Override
            public int compare(student o1, student o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        for (student s:list1) {
            System.out.println(s.rollNo+" "+s.name);
        }


    }

}
