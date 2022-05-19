package algorithms.recursion.sorting;

import java.util.Vector;

public class SortArray {
    public static void sort(Vector<Integer> v){
        if(v.size()==1){
            return;
        }
        int last=v.remove(v.size()-1);
        sort(v);
        insert(v,last);

    }
    public static void insert(Vector<Integer> v, int element){
        if(v.size()==0 || element>= v.lastElement()){
            v.add(element);
            return;
        }
        int last=v.remove(v.size()-1);
        insert(v,element);
        v.add(last);
    }

    public static void main(String[] args) {
        Vector<Integer> v= new Vector<>();
        v.add(5);
        v.add(4);
        v.add(3);
        v.add(2);
        v.add(1);
        sort(v);
        System.out.println(v);
    }
}

