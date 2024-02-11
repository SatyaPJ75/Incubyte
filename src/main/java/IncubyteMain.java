public class IncubyteMain {
    public static void main (String s[]){
        StringCalculator sc = new StringCalculator();
        String [] numbers = {"1","2","3,4,5"};
        System.out.print(sc.add(numbers));
    }
}
