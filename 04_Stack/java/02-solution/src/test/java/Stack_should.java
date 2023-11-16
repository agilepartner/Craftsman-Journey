import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Stack_should {
    private final Object object1 = new Object();
    private final Object object2 = new Object();

    private Stack stack;

    @BeforeEach
    public void init() {
        stack = new Stack();
    }

    @Test
    public void raise_an_exception_when_popped_and_empty() {
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    public void pop_the_last_object_pushed() {
        stack.push(object1);
        assertEquals(object1, stack.pop());
    }

    @Test
    public void pop_objects_in_the_reverse_order_they_were_pushed()
    {
        stack.push(object1);
        stack.push(object2);

        assertEquals(object2, stack.pop());
        assertEquals(object1, stack.pop());
    }
}