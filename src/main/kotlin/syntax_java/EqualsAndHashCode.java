package syntax_java;

public class EqualsAndHashCode {

    public static void main(String[] args) {
        String a = "privet";
        String b = "privet";
        System.out.println(a==b);
        System.out.println("privet" == "privet");
        System.out.println(a.equals(b));
    }
}
