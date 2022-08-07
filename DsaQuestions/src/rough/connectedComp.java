package rough;

import oops.Mobile;

public class connectedComp {
    static int findLandMasses(int[][] mat){
        int count=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]==1){
                    count++;
                    solve(i,j,mat);
                }
            }
        }
        return count;
    }
    static void solve(int i, int j, int[][] mat){
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || mat[i][j]==0){
            return;
        }
        // mark the node visited
        mat[i][j]=0;
        // call recursively for the neighbours
        int[] moves= {-1,0,1};

        for(int row: moves ){
            for(int col: moves){
                if(row==0 && col==0){
                    continue;
                }
                solve(i+row,j+col,mat);
            }
        }
        // solve(i+1,j,mat);
        // solve(i-1,j,mat);
        // solve(i,j+1,mat);
        // solve(i,j-1,mat);
        // the time complexity should be o(n2)+ o(n2) at worst case
    }
    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
//        int n=sc.nextInt();
//        int m= sc.nextInt();
//        int[][] mat= new int[n][m];
//        boolean[] visited= new boolean[n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                mat[i][j]=sc.nextInt();
//            }
//        }
        int[][] mat={{1,1,0},{0,0,1},{1,0,1}};
        int count=findLandMasses(mat);
        Mobile m= new Mobile(4,2400,256,"ios","iphone13");
        m.printDeatails();

        System.out.println(count);
    }
}
