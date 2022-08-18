package dataStructures.strings;

public class nextGreaterpalindrome {

    public static String nextGreaterPalin(String str) {
        int n = str.length();

        char[] ch = str.toCharArray();
        if (n < 4) {
            return "-1";
        }
        int i = n / 2 - 1;
        int j;
        if (n % 2 == 0) {
            j = i + 1;
        } else {
            j = i + 2;
        }
        int idxi = i;
        int idxj = j;
        while (i > 0 && ch[i - 1] >= ch[i]) {
            i--;
            j++;
        }
        if (i == 0) {
            return "-1";
        }
        swap(ch, i - 1, idxi);
        swap(ch, j + 1, idxj);
        String s = String.valueOf(ch);
        return s;

    }

    public static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void main(String[] args) {
        String str = "9876789";
        System.out.println(nextGreaterPalin(str));
    }
}
