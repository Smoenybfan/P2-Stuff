# Exercise 2

In the second exercise, we are extending an existing project by applying
object-oriented design principles. We learn how to reuse classes and interfaces
and how to write proper tests for the added functionality. The reading
materials cover some guidelines on how to write good code, comments, and
documentation.

## Problem Description

Due to your outstanding performance in programming, you've been hired by the
prestigious ACME Inc, Programming division. At the moment ACME Inc. is into
game development. Their latest game, *Snakes and Ladders*, has become a real
success. Therefore, they are currently looking into adding new features.

In order to pass this exercise, you need to modify the current implementation
of the Snakes and Ladders game (presented during the lecture) in the following
ways:

1. Add the following new types of squares
	- `TikTokSquare`: These squares are similar to ladders, but instead of
	  leading to one fixed target square, a `TikTokSquare` has two possible
	  destinations, which are visited in turn. This means that the first
	  player that visits the square ends up at the first destination, the
	  second one at the second destination, the third one at the first
	  destination again, and so on.
	- `SwapSquare`: When landing on a swap square, the player that landed
	  on it swaps place with the player who plays next (e.g., when there
	  are 3 players and player 3 lands on a swap square, player 3 and
	  player 1 swap places).
	- `WormholeEntrance` and `WormholeExit`: When entering a wormhole (upon
	  landing on a `WormholeEntrance`), the player is transferred to a
	  random `WormholeExit` square.

2. Add/extend tests (JUnit and/or JExample) to the classes `TikTokSquareTest`
   and `SwapSquareTest`. Your tests should make use of the corresponding
   squares. Some (partial) tests are already implemented; you should take a
   look at the classes `SimpleGameTest`, and `TikTokSquareTest` for reference.

3. Include the new squares in the `Game.main` method, such that each kind of
   square is included at least once in the board.

4. Add API documentation to the `snakes.ISquare` interface according to the
   Oracle-provided rules (see
   [http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html](http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html)).

5. Add class comments to the classes `SwapSquare`, `TikTokSquare`,
   `WormholeEntrance`, and `WormholeExit`, describing the responsibilities and
   functionality of each class.

## Hints

You are allowed to change all the existing classes and add new ones. Before
starting to code however, we advise you to think about which class has which
responsibility, and which class needs to know (and be able to manipulate) which
data.

## Mandatory Reading Material

- resources/01_Naming.pdf from you git repository

- resources/02_Encapsulation.pdf from you git repository

- [http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html](http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html): sections *Format of a Doc Comment* and *Doc Comment Checking Tool*. 

## Optional Reading Material

- [http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html](http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html): Remaining sections.

## Deadline

Submit your solutions by pushing your code to the git repository by
___Thursday, 10 March, 13:00___.
