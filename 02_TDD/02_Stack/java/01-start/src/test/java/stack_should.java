import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class stack_should {
    private Stack stack;

    @BeforeEach
    public void init() {
        stack = new Stack();
    }

    @Test
    public void fail() {
        Assertions.fail("Fist test fails");
    }

}