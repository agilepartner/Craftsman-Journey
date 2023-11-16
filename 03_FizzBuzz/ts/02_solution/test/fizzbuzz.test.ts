import { fizzbuzz } from "../src/fizzbuzz";

describe("FizzBuzz should", () => {
  it.each([1, 2, 4, 7, 8, 11, 13, 14, 16, 17, 19, 22])(
    "return the number when '%d'",
    (number: number) => {
      const result = fizzbuzz(number);
      expect(result).toEqual(number.toString());
    }
  );

  it.each([3, 6, 9, 12, 18, 21, 24, 27, 33])(
    "return Fizz when '%d'",
    (number: number) => {
      const result = fizzbuzz(number);
      expect(result).toEqual("Fizz");
    }
  );

  it.each([5, 10, 20, 25, 35, 40, 50])(
    "return Buzz when '%d'",
    (number: number) => {
      const result = fizzbuzz(number);
      expect(result).toEqual("Buzz");
    }
  );

  it.each([15, 30, 45, 60, 75])(
    "return FizzBuzz when '%d'",
    (number: number) => {
      const result = fizzbuzz(number);
      expect(result).toEqual("FizzBuzz");
    }
  );
});
