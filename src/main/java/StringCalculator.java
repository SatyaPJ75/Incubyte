import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringCalculator {


    public List<Integer> add(String [] numbers){
        List<Integer> ans = new ArrayList<>();
        Arrays.stream(numbers).forEach(numberString->{
            int sum =0;
            String delemitor = isDelimitorChanged(numberString);
            numberString = handleDifferentDelemitor(delemitor,numberString);
            String [] digits = numberString.split(delemitor);
            checkNewLineNotInBetween(digits);
            for (String digit : digits) {
                if (digit.contains("\n"))
                    digit = digit.replace("\n", "");
                int num = Integer.parseInt(digit);
                handlenegativeNumbers(num);
                num = handleBiggerNumbers(num);
                sum += num;

            }
            ans.add(sum);
        });
        return ans;
    }

    private void checkNewLineNotInBetween(String[] digits) {
        if(digits[0].startsWith("\n") || digits[digits.length-1].endsWith("\n")){
            throw new NumberFormatException();
        }
    }

    private String isDelimitorChanged(String numberString) {
        StringBuilder delemitor = new StringBuilder(",");
        if(numberString.startsWith("//")){
            int i= 3;
            delemitor = new StringBuilder();
            while(numberString.charAt(i)!=']') {
                delemitor.append(numberString.charAt(i));
                i++;
            }
        }
        return delemitor.toString();
    }

    public void handlenegativeNumbers(int num){
        if(num<0){
            throw new NumberFormatException("negative numbers not allowed "+num);
        }
    }

    public int handleBiggerNumbers(int num){
        if(num > StringCalculatorConstant.BIGGER_NUMBER){
            return 0;
        }
        return num;
    }

    public String handleDifferentDelemitor(String delemitor,String numberString) {
        if (!Objects.equals(delemitor, ",") && numberString.charAt(4 + delemitor.length()) == '\n') {
            numberString = numberString.substring(5 + delemitor.length());
        }
        return numberString;
    }
}
