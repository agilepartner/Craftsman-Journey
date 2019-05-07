using FluentAssertions;
using Moq;
using Moq.Language.Flow;
using System;
using Xunit;

namespace AgilePartner.Mock.Kata.Tests
{
    public class CurrencyConverter_should
    {
        private const string FROM_CURRENCY = "USD";
        private const string TO_CURRENCY = "USD";

        protected static CurrencyConverter CreateCurrencyConverter(
            Action<ISetup<IChangeRateService, double>> setupMock)
        {
            return new CurrencyConverter(
                CreateMock(setupMock)
            );
        }

        protected static IChangeRateService CreateMock(
        Action<ISetup<IChangeRateService, double>> setupMock)
        {
            Mock<IChangeRateService> changeRateServiceMock = new Mock<IChangeRateService>();
            setupMock(changeRateServiceMock.Setup(service => service.GetChangeRate(It.IsAny<string>(), It.IsAny<string>())));

            return changeRateServiceMock.Object;
        }

        public class throws_an_argument_exception_when : CurrencyConverter_should
        {
            [Fact]
            public void currency_is_not_found()
            {
                var amountToConvert = 1;
                Mock<IChangeRateService> changeRateServiceMock = new Mock<IChangeRateService>();
                changeRateServiceMock
                    .Setup(service => service.GetChangeRate(It.IsAny<string>(), It.IsAny<string>()))
                    .Throws(new ArgumentException("Currency not found"));

                var converter = new CurrencyConverter(changeRateServiceMock.Object);

                /*var converter = CreateCurrencyConverter(
                    setupMock => setupMock.Throws(new ArgumentException("Currency not found"))
                );*/

                Assert.Throws<ArgumentException>(() =>
                {
                    converter.Convert(FROM_CURRENCY, TO_CURRENCY, amountToConvert);
                })
                .Message.Should().Be("Currency not found");
            }

            [Fact]
            public void amount_to_convert_less_than_0()
            {
                var amountToConvert = -1;
                var changeRate = 1;

                var converter = CreateCurrencyConverter(
                    setupMock => setupMock.Returns(changeRate)
                );

                Assert.Throws<ArgumentException>(() =>
                {
                    converter.Convert(FROM_CURRENCY, TO_CURRENCY, amountToConvert);
                })
                .Message.Should().Be("Amount must be equal or greater than zero");
            }
        }

        public class throws_an_invalid_operation_exception_when : CurrencyConverter_should
        {
            [Fact]
            public void change_rate_is_negative()
            {
                var amountToConvert = 1;
                var changeRate = -1;

                var converter = CreateCurrencyConverter(
                    setupMock => setupMock.Returns(changeRate)
                );

                Assert.Throws<InvalidOperationException>(() =>
                {
                    converter.Convert(FROM_CURRENCY, TO_CURRENCY, amountToConvert);
                })
                .Message.Should().Be("Retrieved rate not equal or greater than zero");
            }

            [Fact]
            public void an_unknown_exception_occured()
            {
                var amountToConvert = 1;

                var converter = CreateCurrencyConverter(
                    setupMock => setupMock.Throws<NullReferenceException>()
                );

                Assert.Throws<InvalidOperationException>(() =>
                {
                    converter.Convert(FROM_CURRENCY, TO_CURRENCY, amountToConvert);
                })
                .Message.Should().Be("An unexpected error has been thrown during the conversion");
            }

            [Fact]
            public void change_rate_is_max_value()
            {
                var amountToConvert = 1;
                var changeRate = double.MaxValue;

                var converter = CreateCurrencyConverter(
                    setupMock => setupMock.Returns(changeRate)
                );

                Assert.Throws<InvalidOperationException>(() =>
                {
                    converter.Convert(FROM_CURRENCY, TO_CURRENCY, amountToConvert);
                })
                .Message.Should().Be("Result out of bound");
            }
        }

        public class returns_converted_value_when
        {
            [Theory]
            [InlineData(9, 0, 0)]
            [InlineData(4, 0.89, 3.56)]
            [InlineData(34, 1.67, 56.78)]
            public void change_rate_is_positive(
                double amountToConvert,
                double changeRate,
                double expectedResult)
            {
                var converter = CreateCurrencyConverter(
                    setupMock => setupMock.Returns(changeRate)
                );

                converter.Convert(FROM_CURRENCY, TO_CURRENCY, amountToConvert)
                        .Should()
                        .Be(expectedResult);
            }
        }
    }
}
