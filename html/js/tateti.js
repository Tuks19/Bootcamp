// Variables del juego
let currentPlayer = 'X';
let gameBoard = ['', '', '', '', '', '', '', '', ''];
let gameActive = true;

// Combinaciones ganadoras
const winConditions = [
    [0, 1, 2], // Fila 1
    [3, 4, 5], // Fila 2
    [6, 7, 8], // Fila 3
    [0, 3, 6], // Columna 1
    [1, 4, 7], // Columna 2
    [2, 5, 8], // Columna 3
    [0, 4, 8], // Diagonal principal
    [2, 4, 6]  // Diagonal secundaria
];

document.addEventListener('DOMContentLoaded', function() {
    inicializar();
});

function inicializar() {
    document.querySelectorAll('.celda').forEach(button => {
        button.addEventListener('click', handleCellClick);
    });
    
    document.getElementById('reiniciar').addEventListener('click', resetGame);
    
    console.log('Juego inicializado');
}

function handleCellClick(event) {
    const cellIndex = parseInt(event.target.id);
    
    if (gameBoard[cellIndex] !== '' || !gameActive) {
        return;
    }
    
    gameBoard[cellIndex] = currentPlayer;
    event.target.textContent = currentPlayer;
    event.target.disabled = true;
    
    event.target.setAttribute('aria-label', 
        event.target.getAttribute('aria-label') + `, ocupada por ${currentPlayer}`);

    verificarCeldas();
}

function verificarCeldas() {
    let roundWon = false;
    let winningCombination = null;
    
    for (let i = 0; i < winConditions.length; i++) {
        const [a, b, c] = winConditions[i];
        if (gameBoard[a] && gameBoard[a] === gameBoard[b] && gameBoard[a] === gameBoard[c]) {
            roundWon = true;
            winningCombination = [a, b, c];
            break;
        }
    }
    
    if (roundWon) {
        gameActive = false;
        anunciarGanador(currentPlayer, winningCombination);
        return;
    }
    
    if (!gameBoard.includes('')) {
        gameActive = false;
        anunciarEmpate();
        return;
    }
    
    currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
}

function anunciarGanador
(winner, combination) {
    alert(`¡${winner} ganó!`);
    
    combination.forEach(index => {
        document.getElementById(index).style.backgroundColor = '#4CAF50';
    });
    
    document.querySelectorAll('.celda').forEach(button => {
        button.disabled = true;
    });
}

function anunciarEmpate() {
    alert('¡Empate!');
    
    document.querySelectorAll('.celda').forEach(button => {
        button.style.backgroundColor = '#FFC107';
    });
}

function resetGame() {
    currentPlayer = 'X';
    gameBoard = ['', '', '', '', '', '', '', '', ''];
    gameActive = true;
    
    document.querySelectorAll('.celda').forEach(button => {
        button.textContent = '';
        button.disabled = false;
        button.style.backgroundColor = '';
        const cellNumber = parseInt(button.id) + 1;
        button.setAttribute('aria-label', `Celda ${cellNumber}`);
    });
    
    console.log('Juego reiniciado');
}