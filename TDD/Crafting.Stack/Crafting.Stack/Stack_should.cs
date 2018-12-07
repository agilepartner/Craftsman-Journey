using FluentAssertions;
using System;
using System.Collections.Generic;
using System.Linq;
using Xunit;

namespace Crafting.Stack
{
    public class Stack_should
    {
        private readonly Stack stack;
        public Stack_should()
        {
            stack = new Stack();
        }

        [Fact]
        public void pop_the_last_object_pushed()
        {
            var objectPushed = "objectPushed";

            stack.Push(objectPushed);

            stack.Pop().Should().Be(objectPushed);
        }

        [Fact]
        public void raise_an_exception_when_popped_and_empty()
        {
            Assert.Throws<EmptyStackException>(() => stack.Pop());
        }
    }

    public class Stack
    {
        private List<object> objects = new List<object>();

        internal object Pop()
        {
            if(objects.Count == 0)
            {
                throw new EmptyStackException();
            }

            var lastElement = objects.Last();
            objects.Remove(lastElement);

            return lastElement;
        }

        internal void Push(string @object)
        {
            objects.Add(@object);
        }
    }

    internal class EmptyStackException : Exception
    {
    }
}
