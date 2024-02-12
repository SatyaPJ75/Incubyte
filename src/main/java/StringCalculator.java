import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringCalculator {

    /**
     * Adding numbers by separating delimiter
     * @param numbers
     * @return
     */
    public List<Integer> add(List<String> numbers){
        List<Integer> ans = new ArrayList<>();
        numbers.stream().forEach(numberString->{
            int sum =0;
            String deliminator = isDelimiterChanged(numberString);
            numberString = handleDifferentDelemitor(deliminator,numberString);
            String [] digits = numberString.split(deliminator);
            checkNewLineNotInBetween(digits);
            for (String digit : digits) {
                if (digit.contains(StringCalculatorConstant.NEW_LINE))
                    digit = digit.replace(StringCalculatorConstant.NEW_LINE, "");
                int num = Integer.parseInt(digit);
                handlenegativeNumbers(num);
                num = handleBiggerNumbers(num);
                sum += num;

            }
            ans.add(sum);
        });
        return ans;
    }

    /**
     * Handling \n other than in between 2 numbers
     * @param digits
     */
    private void checkNewLineNotInBetween(String[] digits) {
        if(digits[0].startsWith(StringCalculatorConstant.NEW_LINE) || digits[digits.length-1].endsWith(StringCalculatorConstant.NEW_LINE)){
            throw new NumberFormatException();
        }
    }

    /**
     * Handling differt type of delimiter
     * @param numberString
     * @return
     */
    private String isDelimiterChanged(String numberString) {
        StringBuilder delemitor = new StringBuilder(StringCalculatorConstant.COMMA);
        if(numberString.startsWith(StringCalculatorConstant.DOUBLE_FORWARD)){
            int i= 3;
            delemitor = new StringBuilder();
            while(numberString.charAt(i)!=']') {
                delemitor.append(numberString.charAt(i));
                i++;
            }
        }
        return delemitor.toString();
    }

    /**
     * Handling negative numbers
     * @param num
     */
    public void handlenegativeNumbers(int num){
        if(num<0){
            throw new NumberFormatException("negative numbers not allowed "+num);
        }
    }

    /**
     * Handling number greater than bigger number
     * @param num
     * @return
     */
    public int handleBiggerNumbers(int num){
        if(num > StringCalculatorConstant.BIGGER_NUMBER){
            return 0;
        }
        return num;
    }

    /**
     * Handling multiple numbers of different delimiter
     * @param delemitor
     * @param numberString
     * @return
     */
    public String handleDifferentDelemitor(String delemitor,String numberString) {
        if (!Objects.equals(delemitor, StringCalculatorConstant.COMMA) && numberString.charAt(4 + delemitor.length()) == '\n') {
            numberString = numberString.substring(5 + delemitor.length());
        }
        return numberString;
    }
}
