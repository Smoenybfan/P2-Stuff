@Mathias
#Corrections for exercise_02 (group03)

## 1. Add the following new types of squares

### TikTokSquare
Well done.

### SwapSquare
You put it in the responsibility of the next Player to move his game figure. Well done. 

### WormholeEntrance and WormholeExit
It is a bit a controverse discussion in whose responsibility to find a random <code>WormholeExit</code> should be. You put the responsibility inside <code>WormholeExit</code> with a class variable that holds all created wormholes in a List and a static getter method which returns that list. So far well done. The only problem is how you return that list, because it violates encapsulation:
You return the reference of this list. The caller could now manipulate the list that is a private class variable of WormholeExit. In this case you should return a copy of the actual list so you keep the ownership of the original list.

## 2. Add/extend tests
You test the main functionality of <code>TikTokSquare</code> and <code>SwapSquare</code>. You even wrote <code>WormholeTest</code>, Congrats.
Just one remark on the WormholeTest:
In <code>newGame()</code> you set the WormholeExits to the positions 5, 8 and 10.
After you move Jack or Jill to the WormholeEntrace you assert that jacks (or jills) position is greater than the WormholeEntrance. But why not checking directly if jack (or jill) stands on one of the exits: <code>assertTrue(jack.position() \=\= 5 || jack.position() \=\= 8 || jack.position \=\= 10);</code>

## 3. Include the new squares in the <code>Game.main</code> method
You added one or more of the new squares.

## 4. Add API documentation
You commented all the methods in the <code>ISquare</code>. You also add a class comment and used the "code" tag.
Just one small typo in *"Chekcks if a Square is the first on the board"*.
For <code>leave(Player player)</code> you wrote *"Must hold a Player"*, more correct would be "Must hold the given Player".

## 5. Add class comments
You added a class comment where you asked too. All class comments are written well (apart from small typos) and are revealing. Depending on the class, perhaps there could be some more information in the class comment.

This questions you should ask for a class comment (taken from lab slides):
- What is the class responsible for?
- What information does it hold?
- What things can it do?
- Who uses this class?
- How should the class be used?
- Does this class ned speacial threatment?

## Other stuff
You use revealing names troughout in your solution. Encapsulation is used as well, except for the exits list in WormholeExit. Watch out for unused imports (in eclipse check the warnings in problem window).

## Conclusion
You did a good job.

**Status: ACCEPTED (ok)**