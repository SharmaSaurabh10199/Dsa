package mockInterviews;
/*
  [1, 2, 3]

[3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3], []
 */
public class printSubSequences {
    static void print(String ip, String op){
        if(ip.length()==0){
            System.out.print(op+" ");
            return;
        }
        String ip1= ip.substring(1);
        String op1= op+ip.charAt(0);
        print(ip1,op);
        print(ip1,op1);
    }

    public static void main(String[] args) {
        int[] arr={1,2,3};
        String ip= arr.toString();
        System.out.println(ip);
        print("12","");
    }
}
