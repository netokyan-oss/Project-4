# Project-4
# Programming – Guillotine

**Course:** CSC2820 – Data Structures 
**Student:** Kyan Abreu Rezende Neto
**Language:** Java  
**IDE:** Visual Studio Code

#1 Project Description:**
This project implements a simplified version of the Guillotine card game.

The program uses a double-ended queue (Deque) to manage victim cards. Action cards can change the order of the queue during the game.

#2 Classes Implemented

#3 LinkedDeque.java
- Implements a double-ended queue using double linking.
- Adds and removes elements from both ends.
- Supports reversing the queue.
- Includes methods to check and display the queue.

#4 GuillotineLine.java
- Manages the line of victim cards.
- Adds new victims to the end of the line.
- Processes action cards.
- Calculates points from removed victim cards.

#5 How to Run
1. Open the project folder in Visual Studio Code.
2. Open `Game.java`.
3. Run the program using the Run button.

#6 Testing
The program should be tested with different action cards, including:
- REVERSE
- ESCAPE
- END_TO_FRONT
- SWAP_LEADER
- DOUBLE_FEATURE
- UNKNOWN

#7 Conclusion
This project demonstrates linked data structures, double-ended queues, and object-oriented programming in Java.
