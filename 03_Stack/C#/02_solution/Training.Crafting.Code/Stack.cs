using System.Collections.Generic;
using System.Linq;

namespace Training.Crafting.Code.Stacks
{
    public class Stack
    {
        private List<object> objects = new List<object>();

        public object Pop()
        {
            if (!objects.Any())
            {
                throw new EmptyStackException();
            }
            var lastElement = objects.Last();
            objects.Remove(lastElement);

            return lastElement;
        }

        public void Push(object @object)
        {
            objects.Add(@object);
        }
    }
}