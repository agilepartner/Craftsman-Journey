using System;
using System.Linq;
using System.Collections.Generic;

namespace AgilePartner.FizzBuzz
{
    public static class FizzBuzz
    {
        private static bool IsDividableBy(int a, int b) => a % b == 0;
        private static bool IsNumberOutOfRange(int number) => number < 1 || number > 100;

        private static IEnumerable<Tuple<Func<int, bool>, Func<int, string>>> mapToString = 
            new List<Tuple<Func<int, bool>, Func<int, string>>>
        {
            new Tuple<Func<int, bool>, Func<int, string>>(n => IsDividableBy(n, 15), (n) => "FizzBuzz"),
            new Tuple<Func<int, bool>, Func<int, string>>(n => IsDividableBy(n, 3), (n) => "Fizz"),
            new Tuple<Func<int, bool>, Func<int, string>>(n => IsDividableBy(n, 5), (n) => "Buzz"),
            new Tuple<Func<int, bool>, Func<int, string>>((n) => true, (n) => n.ToString()),
        };

        public static string Map(int number)
        {
            if(IsNumberOutOfRange(number))
                throw new ArgumentOutOfRangeException("number", number, "Number must be greater than 0 and lower than 101");

            return mapToString
                    .First(m => m.Item1.Invoke(number))
                    .Item2
                    .Invoke(number);
        }

        //1 line solution : Enumerable.Range(1, 100).Select(v => v % 15 > 0 ? v % 3 > 0 ? v % 5 > 0 ? "" + v : "Buzz" : "Fizz" : "FizzBuzz")
    }
}
