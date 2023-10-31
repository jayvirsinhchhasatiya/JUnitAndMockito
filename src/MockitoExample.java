import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

// Interface representing a math service
interface MathService {
    int add(int a, int b);
    int subtract(int a, int b);
}

class Calculator {
    private MathService mathService;

    public Calculator(MathService mathService) {
        this.mathService = mathService;
    }

    public int add(int a, int b) {
        return mathService.add(a, b);
    }

    public int subtract(int a, int b) {
        return mathService.subtract(a, b);
    }
}

public class MockitoExample {
    @Test
    public void testAddition() {
        // Create a mock MathService
        MathService mathService = mock(MathService.class);

        // Set up behavior for the add method
        when(mathService.add(2, 3)).thenReturn(5);

        // Create a Calculator with the mock MathService
        Calculator calculator = new Calculator(mathService);

        // Perform the test and check the result
        assertEquals(5, calculator.add(2, 3));

        // Verify that the add method was called with the expected arguments
        verify(mathService).add(2, 3);
    }

    @Test
    public void testSubtraction() {
        // Create a mock MathService
        MathService mathService = mock(MathService.class);

        // Set up behavior for the subtract method
        when(mathService.subtract(5, 2)).thenReturn(3);

        // Create a Calculator with the mock MathService
        Calculator calculator = new Calculator(mathService);

        // Perform the test and check the result
        assertEquals(3, calculator.subtract(5, 2));

        // Verify that the subtract method was called with the expected arguments
        verify(mathService).subtract(5, 2);
    }
}
