using System;

namespace AgilePartner.FizzBuzz
{
    public class FizzBuzz
    {
        public string Map(int number)
        {
            CheckNumber(number);

            if (IsDivisibleByThree(number) && IsDivisibleByFive(number))
            {
                return "FizzBuzz";
            }
            else if (IsDivisibleByThree(number))
            {
                return "Fizz";
            }
            else if (IsDivisibleByFive(number))
            {
                return "Buzz";
            }
            else
            {
                return number.ToString();
            }
        }

        private void CheckNumber(int number)
        {
            if (number < 1)
            {
                throw new ArgumentOutOfRangeException("number", number, "Number must be greater than 0");
            }
            else if (number > 100)
            {
                throw new ArgumentOutOfRangeException("number", number, "Number must be less than 101");
            }
        }

        private bool IsDivisibleByFive(int number)
        {
            return number % 5 == 0;
        }

        private bool IsDivisibleByThree(int number)
        {
            return number % 3 == 0;
        }
    }
}
