PROJECT TITLE: Chasing Bombs
PURPOSE OF PROJECT: Stage 1 of University, Further Object-Oriented Programming ~ Assignment 2
VERSION or DATE: 04/03/2019
AUTHOR: Wai Shan (Karen) Yip
EXPLANATION: 
This assignment focuses on GUI Application. 
This is a single player game where the player presses on a square in the hopes of avoiding a hidden bomb. 
With every square that is pressed that does not uncover a bomb, the player gains 1 point. 
If a square unveils a bomb, this will result in the game ending. 
The difficulty levels are Easy, Intermediate and Difficult. 
If Easy is selected, selecting 5 safe squares will result in a win, Intermediate requires 7 and Difficult requires all 9.

The JFrame is divided into 3 panels. 
The left panel called Panel A contains the game board which is 10 squares. 
The middle panel called Panel B contains the Start/Restart and Exit button and also displays the score. 
The right panel called Panel C contains the difficulty level buttons. 
Every square on Panel A contains a mouse listener so the score increases with every selection of a safe square as well as it disappearing. 
The "Play a Game" button contains an action listener so when it is selected, the bomb positioning is randomised again, 
any panels that had been selected by the player are replaced, and the win status of the player is updated so they can play again. 
The Exit button contains an action listener so when it is selected, the application closes. 
The Easy button contains an action listener so the player wins the game if they have avoided the bomb, having made 5 moves. 
The Intermediate button contains an action listener so the player wins if they avoid the bomb, having made 7 moves. 
The Difficult button contains an action listener so the player wins if they have avoided the bomb, having made all 9 moves. 
