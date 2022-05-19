package dataStructures.matrix;
/*
you have tpo print the spiral of a given ,matric starting from the (0,0);

 */
public class
SpiralMatrix {
    public static void main(String[] args) {
        int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printSpiral(a);
    }
    public static void printSpiral(int[][] a){
        int sr=0,sc=0,er=a.length-1,ec=a[0].length-1;
        int count=0,total=a.length*a[0].length;
        while (count<total){
            for (int i = sc; i <= ec && count<total; i++) {
                System.out.println(a[sr][i]);
                count++;
            }
            sr++;
            for (int i = sr; i <=er && count<total ; i++) {
                System.out.println(a[i][ec]);
                count++;
            }
            ec--;
            for (int i = ec; i >= sc && count<total; i--) {
                System.out.println(a[er][i]);
                count++;
            }
            er--;
            for (int i = er; i >=sr && count<total ; i--) {
                System.out.println(a[i][sc]);
                count++;
            }
            sc++;
        }
    }
}
