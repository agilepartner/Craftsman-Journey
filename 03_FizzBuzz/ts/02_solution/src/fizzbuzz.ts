const FIZZ = "Fizz";
const BUZZ = "Buzz";
const FIZZBUZZ = FIZZ + BUZZ;

export function fizzbuzz(number: number): string {
  if (isFizz(number) && isBuzz(number)) return FIZZBUZZ;
  if (isFizz(number)) return FIZZ;
  if (isBuzz(number)) return BUZZ;
  return number.toString();
}

function isFizz(number: number) {
  return isMultipleOf(3, number);
}

function isBuzz(number: number) {
  return isMultipleOf(5, number);
}

function isMultipleOf(multiple: number, number: number) {
  return number % multiple === 0;
}
