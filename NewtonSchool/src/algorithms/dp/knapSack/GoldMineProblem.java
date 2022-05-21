package algorithms.dp.knapSack;

public class GoldMineProblem {
    static int maxGold(int[][] grid){
        int[][] t= new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(j==grid[0].length-1){
                    t[i][j]=grid[i][j];
                }
                else if(i==0){
                    t[i][j]=grid[i][j]+Math.max(t[i][j+1],t[i+1][j+1]);
                }
                else if(i==grid.length-1){
                    t[i][j]=grid[i][j]+Math.max(t[i][j+1],t[i-1][j+1]);
                }
                else {
                    t[i][j]=grid[i][j]+Math.max(t[i][j+1],Math.max(t[i-1][j+1],t[i+1][j+1]));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < t.length; i++) {
            max=Math.max(max,t[i][0]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] grid={{1,3,1,5},{2,2,4,1},{5,0,2,3},{0,6,1,2}};
        System.out.println(maxGold(grid));
    }

}
