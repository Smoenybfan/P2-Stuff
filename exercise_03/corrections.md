@Mathias

#corrections for exercise_03 (group03)

##1. split parsing and execution of programs
You split it. Well done.
Hint: If you check the responsibilities of <code>BoardMaker</code> and <code>CommandParser</code> you will see that they have more than one responsibility. This is an indicator for missing classes.

##2. Explicitly state pre- and postconditions in API documentation
You stated some pre- and postconditions.
But you did not really state them explicitly enough. The reader does not know what you exactly mean when you state something is or has to be (not) "valid". You need to explain when it is valid (or when is it not).

Hint: Don't state like "Asserts that..." - just state how it has the be. In class comments you should write things like "The user/implementor has to ensure that ...", "positionX and positionY will always be ...". In method commments you can put the preconditions into the <code>@param</code> or <code>@throws</code> annotations (@param are checked with assertions, @throws handled with exceptions in code) and the postconditions into the <code>@return</code> annotation.

##3. Check pre- and postconditions using the assert keyword
You checked pre- and postconditions.
You should check preconditions at top of the method and not mix the assertions with the rest of your code.

##4. Check class invariants
You stated invariants in class comment of <code>BoardMaker</code> and checked them, but again the reader does not know what "valid" means according to <code>xPosition</code> and <code>yPosition</code>. No invariants stated/checked in <code>CommandParser</code>.

##5. Reasonably deal with all input programs, in exactly the place that your contracts prescribe
The given documentation for <code>BoardMaker#makeBoardFrom</code> tells me as precondition:
*"@param turtleProgram input program according to specification. may also contain invalid text!"*.
And as postcondition:
*"@return SIZExSIZE boolean board, where true values denote 'red trail'."*

So according to the preconditions i fulfill my part of the contract everytime i enter something. Then i should get back a "SIZExSIZE boolean board, where true values denote 'red trail'." as your part of the contract. But as soon as i enter a command followed by a space and a number i get an assertion exception. Except for the jump command - there i get the assertion exception when i enter "jump" followed by a space, then the first number followed by a space and then the second number. **Did you activate assertions in your IDE?**

##6. Write proper class comments (explain responsibilities and invariants)
The class comment for <code>CommandParser</code> is more detailed than the class comment for <code>BoardMaker</code>. But as mentioned before <code>CommandParser</code> has no invariant declared and the reader does not know what you exactly mean with "valid", "invalid", "not valid" or "a formatted program".

If the reader is interessed how you validate, that is the time he has to look in your code, but it should not be necessary to look into your code to get the information when exactly something is valid and when not.

##7. Include a UML class and sequence diagram
###Class diagram
You draw a nice class diagram with a good amount of information in it to understand the relationship between the classes.

###Sequence diagram
You also draw a sequence diagram.
But you forgot the actor and I can't see the initialisation of the BoardMaker and CommandParser Object. In the sequence diagram you deal with Objects not classes, so your naming is not correct, it should be (<code>objectName:ClassName</code>). When a self-call happens you have to draw a new bar wich is half inside the existing bar.

##8. Dealing with invalid input
Your solution seems to ignore invalid input.

##Other
Your naming is revealing and descriptive.
<code>BoardMaker#makeBoardFrom</code>: Returning an array (or any kind of container for multiple objects), which is a class or instance variable, violates encapsulation. It is better to return a copy, so the original can not be modified from outside.

##Conclusion
Your solution does not work as inteded with activated assertions.

The documentation is insufficient and should have the purpose that the reader does not to have to look into your code to understand what it does, who uses it and how it should be used (preconditions) and what the reader can expect in return (class invariant, postcondition).

The UML sequence diagram is also insufficient.

Check the lecture, lab slides and reading material about documenation/commenting, invariants, assertions, pre- and postconditions and as well UML diagrams.

I need you to revise your solution (including documentation) and the UML sequence diagram **until 04/07/2016 13:00**.
Let me know if you revised your solution earlier.
If you have any questions, don't hesitate to contact me or to visit us in the pool hour.

**UPDATE 04/09/2016:**

The correction of your revision is based on this commit:
```code
commit 62aef00adfe9f70003d478823da71220a105c82e
Author: David Bösiger <david.boesiger@bluewin.ch>
Date:   Thu Apr 7 12:57:31 2016 +0200

    Made spelling corrections
```

**documentation, pre- and postconditions, invariants**
You improved your documentation a little and explain the responsibilites better. Still your class comments are minimalistic. Please not for future assignments, that your class comment should answer this questions:

- What is the class responsible for?
- What information does it hold?
- What things can it do?
- Who uses this class?
- How should the class be used?
- Does this class need special treatment?


In your whole solution i could find some explicitly stated preconditions (whitout assertions) in the <code>CommandParser</code>.

It seems that you removed completely the (few) assertions on post- and preconditions you had.
**I can't find any assertions on pre- or postcondition in the actual solution.**
You have 5 assertions on the invariant in <code>Turtle</code> and no other assertions in your project.

**Application does still violate contracts**
If i enable assertions (<code>-ea</code> as vm argument), running <code>TurtleRenderer</code> and move the turtle out of the board (e.g. right 50) i get an assertion error. 

In <code>BoardMaker#MakeBoardFrom</code> is stated that i should get back a board with a trail. In the method sigature i can also see that a <code>ParserException</code> could be thrown. Getting something else back (here assertion error) means that your implementation somewhere violates a contract.

Your UML sequence diagram is a little bit better. But still you did not add an actor and i can't see the initialization (instanciation) of objects (where you use "new" in Java).

**Conclusion for your revision**
Your class comments and your UML sequence diagram are minimalistic but barely accepted.
You have a few preconditions stated. There is not a single assertion on pre- or postconditions.
Your application still happen to have assertion errors where it should not.

Normally i had to give you a fail now.

I will give you a last chance to improve your solution for exercise_03:
- You need to add pre- and postconditions to your methods that make sense and assert on them where it makes sense.
- You need to meet the contracts (no assertion errors when using <code>TurtleRenderer</code>)

Please revise your work and submit before **04/14/2016 13:00**
Don't hesitate to contact me or p2 staff if you have any questions. Remeber there is a pool hour next Tuesday. 

**Status: REVISION REQUIRED (nef)**