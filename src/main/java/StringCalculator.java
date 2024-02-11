import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public List<Integer> add(String [] numbers){
        List<Integer> ans = new ArrayList<>();
        Arrays.stream(numbers).forEach(numberString->{
            int sum =0;
            char delemitor = isDelimitorChanged(numberString);
            if(delemitor!=',' && numberString.charAt(3)=='\n'){
                numberString = numberString.substring(4);
            }
            String [] digits = numberString.split(String.valueOf(delemitor));
            checkNewLineNotInBetween(digits);
            for(int i=0;i<digits.length;i++){
                    if(digits[i].contains("\n"))
                        digits[i].replace("\n","");
                    int num = Integer.valueOf(digits[i]);
                    if(num<0){
                        throw new NumberFormatException("negative numbers not allowed "+num);
                    }
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

    private char isDelimitorChanged(String numberString) {
        char delemitor = ',';
        if(numberString.startsWith("//")){
            delemitor = numberString.charAt(2);
        }
        return delemitor;
    }
}
