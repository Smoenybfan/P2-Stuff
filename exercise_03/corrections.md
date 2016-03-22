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

**Status: REVISION REQUIRED (nef)**