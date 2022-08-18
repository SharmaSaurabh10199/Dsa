package rough;

public class hashCode {
    public static void main(String[] args) {
        String s = "sonu";
        String m = new String("sonu");
        System.out.println(s.equals(m));
        System.out.println(s.hashCode());
        System.out.println(m.hashCode());

    }

}
