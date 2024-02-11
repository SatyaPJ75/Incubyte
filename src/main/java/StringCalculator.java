import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StringCalculator {

    public List<Integer> add(String [] numbers){
        List<Integer> ans = new ArrayList<>();
        //AtomicInteger sum = new AtomicInteger();
        Arrays.stream(numbers).forEach(numberString->{
            int sum =0;
            char delemitor = isDelimitorChanged(numberString);
            if(delemitor!=',' && numberString.charAt(3)=='\n'){
                numberString = numberString.substring(4);
            }
            String [] digits = numberString.split(String.valueOf(delemitor));
            for(int i=0;i<digits.length;i++){
                sum+=Integer.valueOf(digits[i]);
            }
            ans.add(sum);
        });
        return ans;
    }

    private char isDelimitorChanged(String numberString) {
        char delemitor = ',';
        if(numberString.startsWith("//")){
            delemitor = numberString.charAt(2);
        }
        return delemitor;
    }
}
