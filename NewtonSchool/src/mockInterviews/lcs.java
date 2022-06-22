package mockInterviews;
/*
“ABCDGH” and “AEDFHR”
 */
public class lcs {
    public static void main(String[] args) {
        String str1= "ABCDGH";
        String str2= "AEDFHR"; // 3 a
        lcs(str1,str2);

    }
    static void lcs(String str1, String str2){
        int n= str1.length();
        int m= str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i< n+1 ; i++){
            for(int j=0; j<m+1 ; j++){
                if(i==0 || j==0){
                    // initialization
                    dp[i][j]=0;
                }
                else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]= 1+dp[i-1][j-1];

                }
                else {
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int i=n, j=m;
        StringBuilder sb= new StringBuilder("");
        while (i>0 && j>0){
            if(str1.charAt(i-1)== str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i][j-1]>dp[i-1][j]){
                j--;
            }
            else {
                i--;
            }
        }
        System.out.println(sb.reverse());
    }
}
