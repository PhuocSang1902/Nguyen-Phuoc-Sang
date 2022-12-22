function isPrime(number: number): boolean {
    let isPrime = true;
    if (number < 2) {
        isPrime = false;
    } else if (number > 2) {
        for (let i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
    }
    return isPrime;
}
let array = [1, 5, 9, 2, 6, 15, 19, 35, 51, 53];
let total = 0;
for (let number of array) {
    if (isPrime(number)) {
        total += number;
    }
}
console.log("Tổng các số nguyên tố trong mảng trên là: " + total);