using FluentAssertions;
using System.Linq;
using Training.Crafting.Code.Stacks;
using Xunit;

namespace Training.Crafting.Code.Tests.Stacks
{
    public class StackShould
    {
        private static object OBJECT_1 = "Some Object";
        private static object OBJECT_2 = "Another object";
        private readonly Stack stack;

        public StackShould()
        {
            stack = new Stack();
        }

        //NO VALUE TO TEST THE PUSH
        [Fact]
        public void raise_an_exception_when_popped_and_empty()
        {
            Stack emptyStack = new Stack();
            Assert.Throws<EmptyStackException>(() => emptyStack.Pop());
        }

        [Fact]
        public void pop_the_last_object_pushed()
        {
            var stackElement = new object();

            stack.Push(stackElement);
            var poppedElement = stack.Pop();
            poppedElement.Should().Be(stackElement);
        }

        [Fact]
        public void pop_objects_in_the_reverse_order_they_were_pushed()
        {
            stack.Push(OBJECT_1);
            stack.Push(OBJECT_2);

            stack.Pop().Should().Be(OBJECT_2);
            stack.Pop().Should().Be(OBJECT_1);
        }
    }
}
