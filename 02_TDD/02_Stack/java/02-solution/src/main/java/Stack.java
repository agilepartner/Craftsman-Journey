import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack {
    private final ArrayList<Object> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public Object pop() {
        if(stack.isEmpty()) {
            throw new EmptyStackException();
        }
        Object lastElement = stack.get(stack.size() - 1);
        stack.remove(lastElement);

        return lastElement;
    }

    public void push(Object element) {
        stack.add(element);
    }
}