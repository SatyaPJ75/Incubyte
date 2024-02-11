import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public List<Integer> add(String [] numbers){
        Arrays.stream(numbers).forEach(numberString->{
            int start =0;
            char delemitor = isDelimitorChanged(numberString);
            if(delemitor!=',' && numberString.charAt(3)=='\n'){
                numberString = numberString.substring(4);
            }
        });
        return null;
    }

    private char isDelimitorChanged(String numberString) {
        char delemitor = ',';
        if(numberString.startsWith("//")){
            delemitor = numberString.charAt(2);
        }
        return delemitor;
    }
}
