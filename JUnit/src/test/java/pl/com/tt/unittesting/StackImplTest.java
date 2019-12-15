package pl.com.tt.unittesting;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import pl.com.tt.unittesting.Stack.StackOverflow;

public class StackImplTest {

    private StackImpl stack = new StackImpl(2);

    @Test
    public void shouldPopReturnNullOnEmptyStack() {
        assertNull(stack.pop(), "Stack should be empty at the begining");
    }

    @Test
    public void shouldPopElementFromTopOfStack() throws StackOverflow {
        Object object = new Object();
        stack.push(object);

        Object result = stack.pop();
        assertNotNull(result, "Should return sth");
        assertSame(object, result);
    }

    @Test
    public void shouldPopElementInOrder() throws StackOverflow {
        Object object1 = new Object();
        stack.push(object1);
        Object result = stack.pop();
        Object result2 = stack.pop();
        assertSame(object1, result);
        assertNull(result2, "Should return null");

    }

    @Test
    public void shouldThrowExcepetionOnStackOverflow() throws StackOverflow {
        stack.push(new Object());
        stack.push(new Object());

        assertThrows(StackOverflow.class, () -> {
            stack.push(new Object());
        });
    }
}
