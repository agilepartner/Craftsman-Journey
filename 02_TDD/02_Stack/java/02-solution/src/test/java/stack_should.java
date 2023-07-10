import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

public class stack_should {
    private final Object object1 = new Object();
    private final Object object2 = new Object();

    private Stack stack;

    @BeforeEach
    public void init() {
        stack = new Stack();
    }

    @Test
    public void raise_an_exception_when_popped_and_empty() {
        Stack emptyStack = new Stack();
        Assertions.assertThrows(EmptyStackException.class, emptyStack::pop);
    }

    @Test
    public void pop_the_last_object_pushed() {
        stack.push(object1);
        Assertions.assertEquals(object1, stack.pop());
    }

    @Test
    public void pop_objects_in_the_reverse_order_they_were_pushed()
    {
        stack.push(object1);
        stack.push(object2);

        Assertions.assertEquals(object2, stack.pop());
        Assertions.assertEquals(object1, stack.pop());
    }
}