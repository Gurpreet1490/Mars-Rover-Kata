# Mars-Rover-Kata : 

Technology: Java

Used TDD approach to solve some of the problem in Mars Kata.

Mars Rover Kata, a program to move rovers around the surface of Mars!
Surface of Mars is represented by a Plateau. The Plateau is divided into a grid. A Rover’s position is represented by x and y co-ordinates and the letters N, S, W, E to represent North,
South, West, East. 

Rover has been moved around the surafce using a String of instruction: L R M, where L : turn Left, R: trun right and M: move forward. 

Assumption has been made that the Plateau is a square/rectangular grid for this task. 

UML Diagram created to show the flow and interaction of the classes


Main class:  created to check if Rover landed on Mars is following the instruction and throwing correct expection when condition do not meet the requirement.

Classes:
Rover, Plateau, Position, Instructions

Exception classes: 
NotLandedException, PositionNotFoundException, unknownInstructionException

Enum Classes:
Direction, InstructionType

Test Class:
RoverTest



