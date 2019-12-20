package pl.com.tt.unittesting;

import java.util.ArrayList;
import java.util.List;

public class StackImpl implements Stack {

    private List<Object> stack = new ArrayList<>();
    
    @SuppressWarnings("unchecked")
    public void push(Object object) throws StackOverflow {
        stack.add(object);
    }

    public Object pop() {
        if(stack.isEmpty()) {
            return null;
        }
        return stack.remove(stack.size()-1);
    }

}
