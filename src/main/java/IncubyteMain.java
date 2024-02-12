import java.util.List;

public class IncubyteMain {
    public static void main (String s[]){
        StringCalculator sc = new StringCalculator();
        List<String> numbers = List.of("1","2","1;;2;;3");
        System.out.print(sc.add(numbers));
    }
}
