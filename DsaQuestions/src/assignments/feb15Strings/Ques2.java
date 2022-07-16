package assignments.feb15Strings;

public class Ques2 {
    public static void main(String[] args) {
          String s="AAACCCBBDD";
//        Scanner s= new Scanner(System.in);
//        int t= s.nextInt();
//        for (int i = 0; i < t; i++) {
//            String str= s.next();
//            System.out.println(result(str));
//        }

    }
    public static String result(String s){
        int count=1;
        StringBuilder res= new StringBuilder();
        res.append(s.charAt(0));
        for (int i = 1; i <s.length() ; i++) {
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }
            else{
                res.append((char)(count+'0'));
                res.append(s.charAt(i));
                count=1;
            }
        }

            res.append((char)(count+'0'));

         return res.toString();
//        System.out.println(res);
    }
}
