using System;
using System.Collections.Generic;

namespace AgilePartner.FizzBuzz
{
    public class ChainOfResponsibility<T>
    {
        private List<ConditionalAction<T>> chain = new List<ConditionalAction<T>>();

        private ChainOfResponsibility(ConditionalAction<T> conditionalAction)
        {
            chain.Add(conditionalAction);
        }

        private class ConditionalAction<TInput>
        {
            public Predicate<TInput> If { get; set; }
            public Action<TInput> Do { get; set; }
        }

        public static ChainOfResponsibility<T> Start(Predicate<T> condition, Action<T> action)
        {
            return new ChainOfResponsibility<T>(new ConditionalAction<T>()
            {
                If = condition,
                Do = action
            });
        }

        public ChainOfResponsibility<T> Then(Predicate<T> condition, Action<T> action)
        {
            chain.Add(new ConditionalAction<T>()
            {
                If = condition,
                Do = action
            });
            return this;
        }

        public void Run(T input)
        {
            foreach (var conditionalAction in chain)
            {
                if (conditionalAction.If(input))
                {
                    conditionalAction.Do(input);
                    break;
                }
            }
        }

        public ChainOfResponsibility<T> Else(Action<T> action)
        {
            return Then((i) => true, action);
        }
    }
}