package pl.com.tt.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import pl.com.tt.unittesting.Stack.StackOverflow;

public class StackImplTest {

    private Stack service = new StackImpl();

    @Test
    public void shouldPopReturnNullOnEmptyStack() {
        Object result = service.pop();
        assertNull(result);        
    }

    @Test
    public void shouldPopElementFromTopOfStack() throws StackOverflow {
        Object val = new Object();
        service.push(val);
        Object result = service.pop();
        assertEquals(val, result);
    }

    @Test
    public void shouldPopElementInOrder() throws StackOverflow {        
        Object val = new Object();
        service.push(val);
        service.push(new Object());
        
        service.pop();
        Object result = service.pop();
        assertEquals(val, result);
    }

    @Test
    public void shouldThrowExcepetionOnStackOverflow() throws StackOverflow {
        fail("");
    }
}
