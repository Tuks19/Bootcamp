//Se ponen los botones
const botones = document.querySelectorAll("button");
const display = document.getElementById("display");

botones.forEach(boton => {
    boton.addEventListener("click", () => {
        if (boton.classList.contains("num")) {
            appendToDisplay(boton.textContent);
            display.value += boton.textContent;
        } else if (boton.classList.contains("ope")) {
            appendToDisplay(boton.textContent);
            display.value += boton.textContent;
        } else if (boton.id === "limpiar") {
            clearDisplay();
        } else if (boton.id === "resultado") {
            calculateResult();
        }
    });
});

function clearDisplay() {
    display.value = "";
}

function calculateResult() {
    try {
        const expression = display.value.replace(/\s/g, ''); 
        
        if (!expression) {
            display.value = "0";
            return;
        }
        
        const result = evaluateExpression(expression);
        
        if (isNaN(result) || !isFinite(result)) {
            display.value = "Error";
        } else {
            display.value = result;
        }
    } catch (error) {
        display.value = "Error";
    }
}

function evaluateExpression(expr) {
    expr = expr.replace(/(\d+(?:\.\d+)?)\s*\*\s*(\d+(?:\.\d+)?)/g, (match, a, b) => {
        return parseFloat(a) * parseFloat(b);
    });
    
    expr = expr.replace(/(\d+(?:\.\d+)?)\s*\/\s*(\d+(?:\.\d+)?)/g, (match, a, b) => {
        const divisor = parseFloat(b);
        if (divisor === 0) throw new Error("División por cero");
        return parseFloat(a) / divisor;
    });
    
    expr = expr.replace(/(\d+(?:\.\d+)?)\s*\+\s*(\d+(?:\.\d+)?)/g, (match, a, b) => {
        return parseFloat(a) + parseFloat(b);
    });
    
    expr = expr.replace(/(\d+(?:\.\d+)?)\s*-\s*(\d+(?:\.\d+)?)/g, (match, a, b) => {
        return parseFloat(a) - parseFloat(b);
    });
    
    return parseFloat(expr);
}