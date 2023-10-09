import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String a = "aaaaa//asdasdad";
        a = a.substring(0, a.indexOf("//"));
        System.out.println(a);
    }
}
