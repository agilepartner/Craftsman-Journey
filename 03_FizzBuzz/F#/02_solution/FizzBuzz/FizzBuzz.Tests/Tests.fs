module Tests

open System
open Xunit
open FizzBuzz

[<Fact>]
let ``1 returns "1"`` () =
    let actual = fizzbuzz(1)
    Assert.Equal("1", actual)

[<Fact>]
let ``2 returns "2"`` () =
    let actual = fizzbuzz(2)
    Assert.Equal("2", actual)

[<Fact>]
let ``3 returns "Fizz"`` () =
    let actual = fizzbuzz(3)
    Assert.Equal("Fizz", actual)

[<Fact>]
let ``4 returns "4"`` () =
    let actual = fizzbuzz(4)
    Assert.Equal("4", actual)

[<Fact>]
let ``5 returns "Buzz"`` () =
    let actual = fizzbuzz(5)
    Assert.Equal("Buzz", actual)

[<Fact>]
let ``6 returns "Fizz"`` () =
    let actual = fizzbuzz(6)
    Assert.Equal("Fizz", actual)

[<Fact>]
let ``9 returns "Fizz"`` () =
    let actual = fizzbuzz(9)
    Assert.Equal("Fizz", actual)

[<Fact>]
let ``10 returns "Buzz"`` () =
    let actual = fizzbuzz(10)
    Assert.Equal("Buzz", actual)

[<Fact>]
let ``15 returns "FizzBuzz"`` () =
    let actual = fizzbuzz(15)
    Assert.Equal("FizzBuzz", actual)

[<Fact>]
let ``30 returns "FizzBuzz"`` () =
    let actual = fizzbuzz(30)
    Assert.Equal("FizzBuzz", actual)
