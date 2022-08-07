package dataStructures.graph;

public class LandWaterProblem {
    static int findLandMasses(int[][] mat){
        int count=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]==0){
                    count++;
                    solve(i,j,mat);
                }
            }
        }
        return count;
    }
    static void solve(int i, int j, int[][] mat){
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || mat[i][j]==1){
            return;
        }
        // mark the node visited
        mat[i][j]=1;
        // call recursively for the neighbours

        solve(i+1,j,mat);
        solve(i-1,j,mat);
        solve(i,j+1,mat);
        solve(i,j-1,mat);

        // or we could just use the array
        int[] dx= {-1,0,0,1};
        int[] dy= {0,-1,-1,1};
        for(int k=0; k<4; k++){
            solve(i+dx[k], j+dy[k], mat);
        }
        // the time complexity should be o(n2)+ o(n2) at worst case
    }

    public static void main(String[] args) {
        int[][] body = {{1,1,1,0,0},
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,1,1,1,1},
                {0,1,1,1,1}};
        System.out.println(findLandMasses(body));
    }
}
