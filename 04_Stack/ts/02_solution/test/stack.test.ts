import { EmptyStackError, Stack } from "../src/stack";

describe("Stack should", () => {
  let stack: Stack;

  beforeEach(() => {
    stack = new Stack();
  });

  it("throw an error if empty", () => {
    expect(() => {
      stack.pop();
    }).toThrow(EmptyStackError);
  });

  it("be able to push and pop an object", () => {
    const obj = new Object();

    stack.push(obj);
    const actual = stack.pop();

    expect(actual).toBe(obj);
  });

  it("pop object in the correct order", () => {
    const obj1 = new Object();
    const obj2 = new Object();
    stack.push(obj1);
    stack.push(obj2);

    const actual1 = stack.pop();
    const actual2 = stack.pop();

    expect(actual1).toBe(obj2);
    expect(actual2).toBe(obj1);
  });
});
