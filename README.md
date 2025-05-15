# TicTacToe

This is a simple Tic-Tac-Toe game built using Java and JavaFX. It features a UI and a basic AI opponent. The game logic handles player turns, win detection, and draw conditions. 

## Features
- 3x3 game boarding using JavaFX GridPane
- Player vs. Computer gameplay
- color-coded X (blue) and O (red) markers
- Win, lose, and draw detection with alert pop-ups
- Disables clicked cells to prevent replays

## Project Struture
```text
ticTacToe/
├── GameBoard.java        # Handles the UI and board state
├── GameController.java   # Contains game logic and turn handling
├── Main.java             # Entry point that sets up the scene
└── ...```

## How To Play
- The game starts with the player (X)
- Click an empty cell to make your move
- The computer (O) will respond automatically
- Win, lose, or draw - an alert will show the result
