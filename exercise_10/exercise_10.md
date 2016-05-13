# Exercise 10

In this week's lecture, *design patterns* are covered which describe common 
methods of implementing certain problems. In the first part of this exercise, 
we deal with the recognition of design patterns in an existing implementation 
of the Sokoban game. In the second part, we use design patterns to design and 
implement an additional feature in the Sokoban game.


## Finding design patterns

In this folder, you find an implementation of the Sokoban game. Your task is 
to study the code and identify design patterns. To pass this part, you must do 
the following:
- Identify at least 4 different design patterns in the code.
- For each pattern:
	- Provide a short general description of the pattern (in your own 
	  words!).
	- Explain in a paragraph how the pattern is used in the Sokoban game 
	  (you can use UML diagrams if they help with the explanation).
	- Explain in a paragraph why you think the pattern was used there and 
	  what the advantages/disadvantages of using the pattern in that 
	  situations are.
	- The three points above must be clearly identifiable in your text!
- Put all descriptions in a file called `patterns.md`, which must be written 
  in proper markdown syntax.

### Notes

- Patterns from the Java Standard Library do not count. E.g., if the 
  `toString` method from a class is implemented using the `StringBuilder` 
  class, this does not count. Only patterns that are manually implemented by 
  the provided solution will be taken into account.

- Use the "Gang of Four" book you can get it 
  [here](http://scg.unibe.ch/teaching/p2/P2-Reading), which introduces a large 
  number of patterns. In addition, you should also take a look at additional 
  patterns in the Wikipedia article on [design 
  patterns](https://en.wikipedia.org/wiki/Software_design_pattern).

- The actual implementation of the patterns may differ from the ones in the 
  book. This is normal, since you adapt patterns to your domain when 
  implementing them.

- Our implementation is not perfect. In fact, we may have made poor design 
  decisions just for the sake of incorporating more design patterns. 
  Furthermore, documentation, Design by Contract, and testing may be lacking 
  at some points. This is due to the fact that we do not want to make all 
  patterns obvious. In addition, this also demonstrates how difficult it may 
  be when one has to read poorly documented code.


## Using design patterns

For this task, you can choose to work with your own Sokoban game or with the 
implementation provided in this exercise.

Since solving more challenging Sokoban levels can take a large number of 
steps, it may be frustrating when one gets stuck and has to restart the level. 
While purists may argue that undoing steps may be a form of cheating, the 
ability to revert mistakes may make the game more enjoyable.

Your task is to implement functionality that allows the player to undo 
actions. The following requirements must be implemented:
- Undoing an action must restore the game to the exact state it was in before 
  executing the action in the first place.
- You need to be able to undo an arbitrary number of steps (until you end up 
  at the initial board again).
- Once an action has been undone, it should be possible to redo it (that is, 
  there should be a separate command that allows redoing the action that was 
  undone last; however, if there were intermediate steps, it should not be 
  possible anymore to redo anything anymore). This should work with multiple 
  undo actions as well (e.g., first executing the undo action 3 times and then 
  executing the redo action 3 times should result in the same game state 
  again).
- Write unit tests for the above functionality.
- You must use at least one design pattern to implement this functionality!
- Create a file `undo.md` that outlines your implementation. You should 
  explain what you added, how the code changed overall and in particular with 
  regards of design patterns.
- For the new pattern(s) you implemented, create a class UML diagram showing 
  how you added that pattern(s) to your implementation. Include the diagram 
  and a brief explanation in `undo.md`.


## Deadline

Submit your solutions by pushing your code to the git repository by 
___Thursday, 26 May, 13:00___.
