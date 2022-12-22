function findFibonacci(number:number):number{
    if (number <= 1){
        return number;
    }
    return findFibonacci(number-1) + findFibonacci(number-2);
}
let number: number = 10;
let totalFibonacci: number = 0;
let arrayFibonacci: Array<number> = [];
for (let i = 0; i < number; i++) {
    arrayFibonacci.push(findFibonacci(i));
    totalFibonacci += findFibonacci(i);
}
console.log(arrayFibonacci);
console.log(totalFibonacci);
