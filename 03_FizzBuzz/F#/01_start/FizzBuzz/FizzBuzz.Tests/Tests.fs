module Tests

open Xunit
open FizzBuzz

[<Fact>]
let ``1 returns "1"`` () =
    let actual = fizzbuzz(1)
    Assert.Equal("1", actual)