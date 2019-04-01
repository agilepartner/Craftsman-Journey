namespace AgilePartner.FizzBuzz

module fizzBuzz =
    let map x =
        match x with
        | _ when x < 1 || x > 100 -> raise (new System.ArgumentOutOfRangeException("number", "Number must be greater than 0 and lower than 101");)
        | _ when (x % 15) = 0 -> "FizzBuzz"
        | _ when (x % 3) = 0 -> "Fizz"
        | _ when (x % 5) = 0 -> "Buzz"
        | _ -> x.ToString()