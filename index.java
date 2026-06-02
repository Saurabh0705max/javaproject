// import java.util.*;

// class Calculator {
//     public int add(int a, int b) {
//         return a + b;
//     }

//     public double add(double a, double b) {
//         return a + b;
//     }

//     public int subtract(int a, int b) {
//         return a - b;
//     }

//     public double subtract(double a, double b) {
//         return a - b;
//     }

//     public int multiply(int a, int b) {
//         return a * b;
//     }

//     public double multiply(double a, double b) {
//         return a * b;
//     }

//     public void divide(double a, double b) {
//         try {
//             if (b == 0) {
//                 throw new ArithmeticException("Cannot divide by zero");
//             }
//             double result = a / b;
//             System.out.println("Division Result: " + result);
//         } catch (ArithmeticException e) {
//             System.out.println("Error: " + e.getMessage());
//         }
//     }

//     public double power(double base, double exponent) {
//         return Math.pow(base, exponent);
//     }
// }

// class ScientificCalculator {
//     public static void main(String[] args) {
//         Calculator calc = new Calculator();
//         System.out.println("--- Scientific Calculator Results ---");
//         System.out.println("Addition (int): " + calc.add(10, 5));
//         System.out.println("Addition (double): " + calc.add(5.5, 2.3));
//         System.out.println("Multiplication (int): " + calc.multiply(4, 3));
//         System.out.println("Multiplication (double): " + calc.multiply(4.5, 2.0));

//         calc.divide(10, 2);
//         calc.divide(10, 0);

//         System.out.println("Power (2^3): " + calc.power(2, 3));
//     }
// }





<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Scientific Calculator Ultra</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(135deg,#0f172a,#1e293b,#111827);
}

.calc{
    width:420px;
    padding:20px;
    border-radius:25px;
    backdrop-filter:blur(18px);
    background:rgba(255,255,255,0.08);
    box-shadow:0 20px 50px rgba(0,0,0,0.5);
}

h2{
    color:white;
    text-align:center;
    margin-bottom:10px;
}

#display{
    width:100%;
    height:90px;
    border:none;
    outline:none;
    border-radius:15px;
    padding:15px;
    text-align:right;
    font-size:2rem;
    color:white;
    background:rgba(255,255,255,0.12);
}

.info{
    text-align:center;
    color:#cbd5e1;
    font-size:12px;
    margin:10px 0;
}

.grid{
    display:grid;
    grid-template-columns:repeat(5,1fr);
    gap:8px;
}

button{
    height:58px;
    border:none;
    border-radius:14px;
    cursor:pointer;
    font-size:16px;
    transition:.2s;
}

button:hover{
    transform:scale(1.05);
}

.history{
    margin-top:15px;
    color:white;
    background:rgba(255,255,255,0.08);
    border-radius:12px;
    padding:10px;
    max-height:130px;
    overflow-y:auto;
}
</style>
</head>

<body>

<div class="calc">

<h2>Scientific Calculator Ultra</h2>

<input type="text" id="display" readonly>

<div class="info">
Keyboard Supported | Enter = Calculate | Backspace = Delete
</div>

<div class="grid">

<button onclick="ac()">AC</button>
<button onclick="bs()">⌫</button>
<button onclick="add('(')">(</button>
<button onclick="add(')')">)</button>
<button onclick="add('/')">÷</button>

<button onclick="add('7')">7</button>
<button onclick="add('8')">8</button>
<button onclick="add('9')">9</button>
<button onclick="add('*')">×</button>
<button onclick="sqrt()">√</button>

<button onclick="add('4')">4</button>
<button onclick="add('5')">5</button>
<button onclick="add('6')">6</button>
<button onclick="add('-')">−</button>
<button onclick="square()">x²</button>

<button onclick="add('1')">1</button>
<button onclick="add('2')">2</button>
<button onclick="add('3')">3</button>
<button onclick="add('+')">+</button>
<button onclick="cube()">x³</button>

<button onclick="add('0')">0</button>
<button onclick="add('.')">.</button>
<button onclick="calculate()">=</button>
<button onclick="pi()">π</button>
<button onclick="add('**')">xʸ</button>

<button onclick="sin()">sin</button>
<button onclick="cos()">cos</button>
<button onclick="tan()">tan</button>
<button onclick="log()">log</button>
<button onclick="ln()">ln</button>

</div>

<div class="history" id="history">
<b>History</b><br>
</div>

</div>

<script>

const display = document.getElementById("display");
const historyBox = document.getElementById("history");

function add(value){
    display.value += value;
}

function ac(){
    display.value = "";
}

function bs(){
    display.value = display.value.slice(0,-1);
}

function saveHistory(exp,result){
    historyBox.innerHTML += exp + " = " + result + "<br>";
}

function calculate(){

    try{

        let exp = display.value;
        let result = Function("return " + exp)();

        saveHistory(exp,result);

        display.value = result;

    }catch(error){

        display.value = "Error";
    }
}

function sqrt(){
    display.value = Math.sqrt(Number(display.value));
}

function square(){
    display.value = Math.pow(Number(display.value),2);
}

function cube(){
    display.value = Math.pow(Number(display.value),3);
}

function sin(){
    display.value = Math.sin(Number(display.value));
}

function cos(){
    display.value = Math.cos(Number(display.value));
}

function tan(){
    display.value = Math.tan(Number(display.value));
}

function log(){
    display.value = Math.log10(Number(display.value));
}

function ln(){
    display.value = Math.log(Number(display.value));
}

function pi(){
    display.value += Math.PI;
}

/* Keyboard Support */

document.addEventListener("keydown",(e)=>{

    if(/[0-9+\-*/().]/.test(e.key)){
        display.value += e.key;
    }

    else if(e.key==="Enter"){
        calculate();
    }

    else if(e.key==="Backspace"){
        bs();
    }

    else if(e.key==="Escape"){
        ac();
    }

});

</script>

</body>
</html>
