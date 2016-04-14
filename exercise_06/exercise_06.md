# Exercise 6

## Problem Description

*Sokoban* is a simple puzzle game created in the early 1980s. In the game, the 
player is placed on a grid, which contains wall and floor tiles. In addition, 
there are boxes lying around and target tiles where the boxes need to be 
placed. The player's goal is to move all the boxes on to target tiles by 
pushing them around the grid. The difficulty of the puzzle comes with the fact 
that boxes can only be pushed and not pulled, so the player needs to be 
careful not to push boxes to a position where they can not be moved anymore.

Your goal in this exercise is to implement your own *Sokoban* game. To fit the 
topic of this week's game of *Iterative Development*, you will be implementing 
the game in two stages that build on top of each other.

See [wikipedia](https://en.wikipedia.org/wiki/Sokoban) for more details.

### First Stage

In the first part, your task is to implement the initialization and basic 
rendering of the grid. In order to easily share and reuse game levels, you 
will write a parser that reads plaintext levels and initializes the game with 
the given structure. Your parser should store the grid somehow (keep in mind 
that you will need to be able to move the player and boxes around in your 
representation in later stages). Finally, you need to write a renderer for 
your game that displays the current game state.

Level files are ASCII representation of Sokoban levels. The following 
characters can be used:
- `#`: Wall tile
- `_`: Floor tile
- `G`: Goal tile
- `B`: Box
- `P`: Player

A valid input starts with two positive integers `w` and `h`, separated by a 
single whitespace, denoting width and height of the game. The following `h` 
lines contain `w` characters each, where each character is one of the above.

There should be one player only, and at least as many goal tiles as boxes. An 
example of a simple game input file is the following:
```
7 6
#######
#     #
#P    #
###B  #
###  G#
#######
```

When you are done with this stage, 
[tag](http://kernel.org/pub/software/scm/git/docs/git-tag.html) your solution 
as `sokoban1` with the `-a` option: `git tag -a sokoban1`. Push your tag with 
the `--tags` option so we can see it: `git push --tags origin master`. If you 
want to find out whether everything is pushed properly, you can simply check 
out your repository in a different folder and make sure everything is there.

In this stage, you __must__ implement the following:

- Set up the game representation (e.g., write classes like `Game`, `Player`, 
  `Floor`, and so on).
- Write a parser that reads the above board specification. There are some 
  files containing levels in the `levels` folder with the extension `.sok`. 
  These are just simple text files (you can open it with any text editor), 
  each containing one level.
- Write an ASCII renderer that prints any given state (in this stage this 
  happens to be just the initial state) of the game to standard output (using 
  `System.out.print*` methods). The renderer should print the board in the 
  same format as described above (without the integers).
- Write test that make sure the `levels/basic1.sok` and `levels/basic2.sok` 
  are parsed and printed correctly.
- Tag the solution with `sokoban1` and make sure the tag is pushed to the 
  remote repository.

### Second Stage

Once you complete the first stage, your program consists of a parser, an 
initialized game, and a renderer that can print out any game state. In the 
second stage, you will add program logic that allows you to move the player 
around and move boxes.

In this stage, you __must__ implement the following tasks:

- Allow the player to move around on the board. You do not need to make this 
  interactive (but of course you are free to do so), but you should provide 
  test cases that show that player movement is working.
- When the player is in front of a box and moves in the direction of the box, 
  the box should be moved in the same direction if possible. Again, show that 
  this works by writing appropriate unit tests.
- If all boxes are on a goal tile, the game should terminate. You should 
  indicate that the puzzle has been solved, e.g. by printing a message after 
  rendering the final game state.
- In order to pass this stage, you must provide a JUnit test that solves the 
  level `levels/basic1.sok`. The test should use the parser to create a new 
  game, then you should instruct the player to move around the board in order 
  to solve the puzzle. Use your renderer to print the game state to the 
  console after each step and in the final step (when the puzzle is solved), 
  your game should print some sort of message indicating that the puzzle has 
  been solved.
- Tag the solution with `sokoban2` and make sure the tag is pushed to the 
  remote repository.


### Hints

- We encourage you to write more tests than mentioned in the above 
  descriptions. This will help you during development and can help capture 
  mistakes early on.

- Similarly, writing contracts early on helps making sure that the 
  implementations are correct. This is especially useful when your code 
  undergoes lots of changes.

- Pay attention to your code quality. Your code should be understandable and 
  easy to read. If some methods are very complicated, use inline comments to 
  describe what the code is achieving. You should also write JavaDoc comments 
  for classes and methods. __If the code is too difficult to understand and 
  not sufficiently documented, we may ask you to revise it.__

### Optional Tasks

**The tasks and suggestions in this subsections are completely optional and 
you should only do them once you implemented everything else.**

If you want to do even more, here are some suggestions on how you could extend 
your game:

- Make the game interactive. Write a main routine that can be used to run the 
  program and which takes input of some sorts (e.g., when running from the 
  console, you could enter commands for the player like `up` or `left`, 
  similar to what we did for the turtle game).
- Add more tiles and objects. Maybe you can find more types of objects and 
  tiles which interact with each other and can be used for clever level 
  design.
- Add more player objects. Having two player objects may allow for interesting 
  puzzles. E.g. in a game where a player is "stuck" behind a box (meaning that 
  the player wants to be on the other side of the box but doesn't want to move 
  it), a second player object may be used to defuse the situation. Clever 
  levels may require both player objects to be moved in order to solve the 
  puzzle.

If you extend your game, make sure that the functionality described in the two 
stages is still there. In particular, you should still be able to parse the 
mentioned files and solve the `levels/basic1.sok` game with the described 
rules.

## Deadline

Submit your solutions by pushing your code to the git repository by
___Thursday, 21 April, 13:00___.
