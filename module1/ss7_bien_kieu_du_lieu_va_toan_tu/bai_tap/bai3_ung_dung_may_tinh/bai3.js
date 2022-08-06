function cong() {
    let a = parseFloat(document.getElementById('sothunhat').value);
    let b = parseFloat(document.getElementById('sothuhai').value);
    let e = a + b;
    document.getElementById("ketqua").innerHTML = +e;
}

function tru() {
    let a = parseFloat(document.getElementById('sothunhat').value);
    let b = parseFloat(document.getElementById('sothuhai').value);
    let e = a - b;
    document.getElementById("ketqua").innerHTML = +e;
}

function nhan() {
    let a = parseFloat(document.getElementById('sothunhat').value);
    let b = parseFloat(document.getElementById('sothuhai').value);
    let e = a * b;
    document.getElementById("ketqua").innerHTML = +e;
}

function chia() {
    let a = parseFloat(document.getElementById('sothunhat').value);
    let b = parseFloat(document.getElementById('sothuhai').value);
    let e = a / b;
    document.getElementById("ketqua").innerHTML = +e;
}