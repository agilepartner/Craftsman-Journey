using FluentAssertions;
using System;
using Xunit;

namespace AgilePartner.FizzBuzz.Tests
{
    public class FizzBuzz_Specifications
    {
        protected FizzBuzz fizzBuzz;

        public FizzBuzz_Specifications()
        {
            fizzBuzz = new FizzBuzz();
        }

        public class raise_an_argument_out_of_range_exception : FizzBuzz_Specifications
        {
            [Fact]
            public void when_number_is_smaller_than_1()
            {
                Assert.Throws<ArgumentOutOfRangeException>(() => fizzBuzz.Map(0));
            }

            [Fact]
            public void when_number_is_negative()
            {
                Assert.Throws<ArgumentOutOfRangeException>(() => fizzBuzz.Map(-1));
            }

            [Fact]
            public void when_number_is_greater_than_100()
            {
                Assert.Throws<ArgumentOutOfRangeException>(() => fizzBuzz.Map(101));
            }
        }

        public class returns_Number : FizzBuzz_Specifications
        {
            [Fact]
            public void when_number_is_not_multiple_of_3_or_5()
            {
                fizzBuzz.Map(1).Should().Be("1");
                fizzBuzz.Map(38).Should().Be("38");
            }
        }

        public class returns_Fizz : FizzBuzz_Specifications
        {
            [Fact]
            public void when_number_is_multiple_of_3()
            {
                fizzBuzz.Map(3).Should().Be("Fizz");
                fizzBuzz.Map(36).Should().Be("Fizz");
            }
        }

        public class returns_Buzz : FizzBuzz_Specifications
        {
            [Fact]
            public void when_number_is_multiple_of_5()
            {
                fizzBuzz.Map(5).Should().Be("Buzz");
                fizzBuzz.Map(100).Should().Be("Buzz");
            }
        }

        public class returns_FizzBuzz : FizzBuzz_Specifications
        {
            [Fact]
            public void when_number_is_multiple_of_3_and_5()
            {
                fizzBuzz.Map(15).Should().Be("FizzBuzz");
                fizzBuzz.Map(90).Should().Be("FizzBuzz");
            }
        }
    }
}