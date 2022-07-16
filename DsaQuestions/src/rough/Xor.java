package rough;

public class Xor {
//    public static void main(String[] args) {
//        Scanner s= new Scanner(System.in);
//        int t= s.nextInt();
//        int[] arr= new int[t+1];
//        int sum=0;
//        for(int k=1; k<t+1; k++){
//            arr[k]=s.nextInt();
//        }
//        for (int i = 1; i < t+1; i++) {
//            sum+= (t-i)^arr[i];
//        }
//        System.out.println(sum);
//    }

//    static void fun(int x)
//    {
//        if(x > 0)
//        {
//            fun(--x);
//            System.out.print(x + " ");
//            fun(--x);
//        }
//    }
//
//    public static void main (String[] args)
//    {
//        int a = 4;
//        fun(a);
//    }
static int fun(int i)
{
    if (i % 2 == 1) return (i++);
    else return fun(fun(i - 1));
}

    public static void main (String[] args) {
        System.out.println(" " + fun(200) + " ");
    }
}

