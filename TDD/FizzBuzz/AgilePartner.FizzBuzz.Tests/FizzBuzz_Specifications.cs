using FluentAssertions;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace AgilePartner.FizzBuzz.Tests
{
    [TestClass]
    public class FizzBuzz_should
    {
        protected FizzBuzz fizzBuzz;

        [TestInitialize]
        public void Setup()
        {
            fizzBuzz = new FizzBuzz();
        }

        [TestClass]
        public class raise_an_argument_out_of_range_exception : FizzBuzz_should
        {
            [TestMethod, ExpectedException(typeof(ArgumentOutOfRangeException))]
            public void when_number_is_smaller_than_1()
            {
                fizzBuzz.Map(0);
            }

            [TestMethod, ExpectedException(typeof(ArgumentOutOfRangeException))]
            public void when_number_is_negative()
            {
                fizzBuzz.Map(-1);
            }

            [TestMethod, ExpectedException(typeof(ArgumentOutOfRangeException))]
            public void when_number_is_greater_than_100()
            {
                fizzBuzz.Map(-1);
            }
        }

        [TestClass]
        public class returns_Number : FizzBuzz_should
        {
            [TestMethod]
            public void when_number_is_not_multiple_of_3_or_5()
            {
                fizzBuzz.Map(1).Should().Be("1");
                fizzBuzz.Map(38).Should().Be("38");
            }
        }

        [TestClass]
        public class returns_Fizz : FizzBuzz_should
        {
            [TestMethod]
            public void when_number_is_multiple_of_3()
            {
                fizzBuzz.Map(3).Should().Be("Fizz");
                fizzBuzz.Map(36).Should().Be("Fizz");
            }
        }

        [TestClass]
        public class returns_Buzz : FizzBuzz_should
        {
            [TestMethod]
            public void when_number_is_multiple_of_5()
            {
                fizzBuzz.Map(5).Should().Be("Buzz");
                fizzBuzz.Map(100).Should().Be("Buzz");
            }
        }

        [TestClass]
        public class returns_FizzBuzz : FizzBuzz_should
        {
            [TestMethod]
            public void when_number_is_multiple_of_3_and_5()
            {
                fizzBuzz.Map(15).Should().Be("FizzBuzz");
                fizzBuzz.Map(90).Should().Be("FizzBuzz");
            }
        }
    }
}