using AgilePartner.FizzBuzz;
using NinjaTurtles;
using NUnit.Framework;

namespace UnitTestProject1
{
    public class UnitTest1
    {
        [Test, MutationTest]
        public void test()
        {
            MutationTestBuilder<FizzBuzz>
                .For("Map")
                .Run();
        }
    }
}
