package contests;

public class mysteryBook {
    public static boolean contains(String str, String[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(!str.contains(arr[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str="newtonschoolisbest";
        String[] arr={"newton"};
    }
}
