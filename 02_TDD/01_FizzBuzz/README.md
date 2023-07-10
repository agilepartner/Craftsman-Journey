# FizzBuzz

## Requirements

Write a class `FizzBuzz` with a method that returns for a number from 1 to 100 this given number, except that :
* for multiples of 3 returns “Fizz” instead of the number
* for the multiples of 5 returns “Buzz”
* for numbers which are multiples of both 3 and 5 returns “FizzBuzz”

```
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
16
17
Fizz
19
Buzz
... etc up to 100
```

## Variations

### Divisible & contains

A number is fizz if it is divisible by 3 or if it has a 3 in it
A number is buzz if it is divisible by 5 or if it has a 5 in it

For exemple :

* 53 should return FizzBuzz (contain 5 and 3)
* 35 should return FizzBuzzBuzz (contain 3 and 5 and it divided by 5)

### No if

Same problem without using any `if` statement in your code.

### No modulo

Same problem without using the modulo operator.

### With parameters

Add this method

``` java
public class FizzBuzz {

    ...

    public String get(int limit, int fizz, int buzz) {
        ...
    }
}
```

with

- limit = 100
- fizz = 3
- buzz = 5



### Use predicates

Same problem with passing two predicates to the method to inject the behavior.


## References

* [Coding Dojo](https://codingdojo.org/kata/FizzBuzz/)
