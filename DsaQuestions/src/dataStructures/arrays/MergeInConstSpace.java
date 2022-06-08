package dataStructures.arrays;

public class MergeInConstSpace {
    public static void merge(int[] a, int[] b, int n, int m){
        for (int i = 0; i < n; i++) {
            if(a[i]<=b[i]){
                i++;
            }
            else {
                int temp=a[i];
                a[i]=b[i];
                b[i]=temp;
                insert(b,m);
            }
        }
    }
    public static void insert(int[] b, int m){
        int key=b[0];
        int j=1;
        while (j<m && key>b[j]){
            b[j-1]=b[j];
            j++;
        }
        j--;
        b[j]=key;
    }
}
