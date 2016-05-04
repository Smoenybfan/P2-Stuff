@mathias
#corrections excercise 04 (group03)

##Snakes & Ladders
###Implement two different types of tests that cover <code>Game#play(IDie)</code>
You did not extract an interface <code>IDie</code> out of <code>Die</code>.
Neither did you use Mockito nor did you create a <code>MockedDie</code> class.

###Write a short paragraph and tell us which approach is better in your opinion and why
Not done.

###Test for all squares in your game (cover various scenarios)
You wrote tests for almost every Square (you forgot <code>LastSquare</code>) and i can see that you put some effort in.

But the following was stated in the exercise: "Again, you should use Mockito to mock the objects that are unrelated to the current test." 

What you did in your test is more an integration test (you test all involved classes and how they play together). This is also a part of testing, but we asked to mock all unrelated objects so that just the current class (for which the test class is written) is tested, also called unit test. If you instanciate existing classes instead of mocking them, your test depends on the implementation of this classes what you don't want if you just want to test the functionality of one single class.

##Turtle Game
###Create <code>ParserTest</code> class (verify that parser works correctly: cover a lot of possible inputs, command typos, invalid coordinates, edge cases, off-by-one situations)
You wrote some well thought out tests for your <code>Parser</code> class.

Maybe you should consider tests with a correct first part but decimal, not-a-number or other special coordinates in the command (e.g. "down x", "left 9.0", "up 3, 5", "right 0", "right -1" ...).

###Create <code>MatrixBuildTest</code> class (verify that the correct squares are marked, don't use turtle program as input, create commands manually, parser-independent)
Again well done.
Maybe you could add a test that checks correctnes if the turtle jumps outside of board.

###Make sure that all parts of your game are properly tested (including exceptions).
You test most parts of your game properly.

###Additional Task (coverage, where it is not covered explain why)
You did not solve the additional task.

##Other
You should not use <code>throws Exception</code> (as you did in <code>CommandParser</code>) same as you not should catch <code>Exception</code>. Always throw or catch the specific Exception(s).

##Conclusion
You did not solve the first part (snake & ladder) as we ask you for.

You need to revise your solution until **04/28/2016 13:00**.
If you don't know how to use Mockito or if you have any other questions, don't hesitate to ask me or somebody else of the P2 staff. You can also ask us after the lab on Friday or in the pool hours at Tuesday.


##UPDATE 05/03/2016:
###Implement two different types of tests that cover <code>Game#play(IDie)</code>
You extracted the `IDie` interface and you created a well designed `MockedDie`.
The task was to test the method `Game#play(IDie)` - i cant find such test case where you test exactly this method with Mockito and the mocked die. You created a `DieTestWithMockito` where you add some tests testing the mocked `Die` class. Be aware that testing mocked object does not make sense. You do test a dummy this way.

###Write a short paragraph and tell us which approach is better in your opinion and why
Found your comparison.md

###Test for all squares in your game (cover various scenarios)
You improved your tests.

If you mock all other objects for a class, then just test the functionalities of the class, don't test the mock, like you did for example in `SquareTest`:
```java
        assertEquals(spyGame.getSquare(2).position()+1,spyGame.getSquare(3).position());
        assertEquals(spyGame.getSquare(3).position()-1, spyGame.getSquare(2).position());
```
With this you test the functionality of Game (or better the mock of Game) not the functionality of Square.

###Conclusion
It seems that you misunderstood some tasks. You really should improve your knowledge about unit and integration testing and mocking. Try to understand what, how and why you should test.
If you are unsure about these and other topic, don't hesitate to ask us.

**Status: Barely Accepted (OK)**