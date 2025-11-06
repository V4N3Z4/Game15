# Game of 15

This project implements the classic **Game of 15** in Java with a graphical interface using Swing.

## Features

- 4x4 board with pieces numbered 1 through 15 and one empty space.
- A move is only valid if the piece is adjacent to the empty space.
- "New Game" button that shuffles the pieces randomly.
- Solveability check: only solvable boards are generated.
- Victory message: "Congratulations, you've won!"

## Code Structure
Game15/
-  src/
-  Main.java
- Board.java
- Piece.java
- Controller.java
-  README.md

## How to Run

From the `src` folder, compile and run:
java Main

## Game Logic
The GameController class is responsible for:

- Generating a random and solvable board.
- Validating piece moves adjacent to the empty space.
- Checking if the player has won.
