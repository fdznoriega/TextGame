----What is this?----
Text-based adventure game that takes inputs through terminal.
Not exactly elegant, but the main intent is to observe how some design
decision might impact future development. Also I'm bored.
I plan on using this as a launching point from which I will implement a true user interface 
(possibly through JavaFX) rather than the crude console IO that is in place.

----How do I use it?----
Download, then access folder with terminal. In terminal,
Input: javac *.java
Input: java Game
And from there the game will run.

----Controls?----
Everything is a text input you provide.

/Navigating the Map
Commands: north, south, east, west.

/Inventory and Equipment
Commands: I, E.
-I will open the inventory.
-E will show you your current equipment and prompt you to equip something.

/Battles
Commands: Provided. May change as dev continues.

/Systems:
Commands: quit, help
-quit will exit the game.
-help will present all possible actions while navigating.
