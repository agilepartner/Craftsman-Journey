export class EmptyStackError extends Error {}

export class Stack {
  items: Object[] = [];

  push(value: object): void {
    this.items.push(value);
  }
  pop(): object | undefined {
    if (this.items.length == 0) throw new EmptyStackError();
    return this.items.pop();
  }
}
