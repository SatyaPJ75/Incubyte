import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {

    @InjectMocks
    StringCalculator stringCalculator;

    /**
    * Test case 1 and 2 : Allow the Add method to handle an unknown amount of numbers
     */
    @Test
    public void addTest(){
        List<String> numbers = List.of("1","2","1,2");
        List<Integer> list = List.of(1,2,3);
        assertEquals(stringCalculator.add(numbers), list);
    }

    /**
     * Test case 3 : Allow the Add method to handle new lines between numbers
     */
    @Test(expected = NumberFormatException.class)
    public void addTestWithNewLine(){
        List<String> numbers =  List.of("1","2","1,\n");
        List<Integer> list = List.of(1,2,3);
        assertEquals(stringCalculator.add(numbers), list);
    }

    /**
     * Testcase 4: Support different delimiters
     */
    @Test
    public void addTestWithDifferentMultipleDelimitor(){
        List<String> numbers =  List.of("1","2","//[;;;]\n1;;;2");
        List<Integer> list = List.of(1,2,3);
        assertEquals(stringCalculator.add(numbers), list);
    }

    /**
     * Testcase 5: Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed.
     */
    @Test
    public void addTestWithDifferentDelimitor(){
        List<String> numbers =  List.of("1","2","//[;]\n1;2");
        List<Integer> list = List.of(1,2,3);
        assertEquals(stringCalculator.add(numbers), list);
    }

    /**
     * Testcase 6: Numbers bigger than 1000 should be ignored, so adding
     */
    @Test(expected = NumberFormatException.class)
    public void addTestWithNegativeNumbers(){
        List<String> numbers =  List.of("1","2","-1,2");
        List<Integer> list = List.of(1,2,1);
        assertEquals(stringCalculator.add(numbers), list);
    }

    /**
     * Testcase 7 : Delimiters can be of any length with the following format: “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6
     */
    @Test
    public void addTestBiggerNumber(){
        List<String> numbers =  List.of("1","2","1,2000");
        List<Integer> list = List.of(1,2,1);
        assertEquals(stringCalculator.add(numbers), list);
    }
}
