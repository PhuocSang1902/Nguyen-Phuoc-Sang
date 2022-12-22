function findFibonacci(number) {
    if (number <= 1) {
        return number;
    }
    return findFibonacci(number - 1) + findFibonacci(number - 2);
}
let number = 10;
let totalFibonacci = 0;
let arrayFibonacci = [];
for (let i = 0; i < number; i++) {
    arrayFibonacci.push(findFibonacci(i));
    totalFibonacci += findFibonacci(i);
}
console.log(arrayFibonacci);
console.log(totalFibonacci);
//# sourceMappingURL=fibonancy.js.map