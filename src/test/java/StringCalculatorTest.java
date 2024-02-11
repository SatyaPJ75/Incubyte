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

    @Test
    public void addTest(){
        String [] numbers = {"1","2","1,2"};
        List<Integer> list = List.of(1,2,3);
        assertEquals(stringCalculator.add(numbers), list);
    }
}
