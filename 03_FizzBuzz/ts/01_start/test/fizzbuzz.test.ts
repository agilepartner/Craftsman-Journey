import { fizzbuzz } from "../src/fizzbuzz";

describe("FizzBuzz should", () => {
  it("should return '1' when 1", () => {
    const result = fizzbuzz(1);
    expect(result).toEqual("1");
  });
});
