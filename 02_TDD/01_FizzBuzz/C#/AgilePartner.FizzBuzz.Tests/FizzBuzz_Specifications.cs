using FluentAssertions;
using System;
using Xunit;

namespace AgilePartner.FizzBuzz.Tests
{
    public class FizzBuzz_Specifications
    {
        protected static string Map(int number) => FizzBuzz.Map(number);

        public class raise_an_argument_out_of_range_exception : FizzBuzz_Specifications
        {
            [Fact]
            public void when_number_is_smaller_than_1()
            {
                Assert.Throws<ArgumentOutOfRangeException>(() => Map(0));
            }

            [Fact]
            public void when_number_is_negative()
            {
                Assert.Throws<ArgumentOutOfRangeException>(() => Map(-1));
            }

            [Fact]
            public void when_number_is_greater_than_100()
            {
                Assert.Throws<ArgumentOutOfRangeException>(() => Map(101));
            }
        }

        public class returns_Number : FizzBuzz_Specifications
        {
            [Fact]
            public void when_number_is_not_multiple_of_3_or_5()
            {
                Map(1).Should().Be("1");
                Map(38).Should().Be("38");
            }
        }

        public class returns_Fizz : FizzBuzz_Specifications
        {
            [Fact]
            public void when_number_is_multiple_of_3()
            {
                Map(3).Should().Be("Fizz");
                Map(36).Should().Be("Fizz");
            }
        }

        public class returns_Buzz : FizzBuzz_Specifications
        {
            [Fact]
            public void when_number_is_multiple_of_5()
            {
                Map(5).Should().Be("Buzz");
                Map(100).Should().Be("Buzz");
            }
        }

        public class returns_FizzBuzz : FizzBuzz_Specifications
        {
            [Fact]
            public void when_number_is_multiple_of_3_and_5()
            {
                Map(15).Should().Be("FizzBuzz");
                Map(90).Should().Be("FizzBuzz");
            }
        }
    }
}