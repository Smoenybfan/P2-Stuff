# Exercise 4

The fourth lecture covers *Test Driven Development* (TDD). In TDD, test cases
are written in order to check whether a component behaves as expected. Good
tests cover as much code as possible and use diverse methods inputs. Complex
methods should have multiple tests in order to cover all paths, and one should
think of corner cases and special circumstances in which a method could be
executed. In this exercise, we will revisit the Snakes & Ladders game and the
Turtle game and practice writing good tests using JUnit, JExample, and
Mockito.


## Mocking Frameworks

For this exercise, you will need to use the [Mockito](http://mockito.org/)
framework for mocking objects. A quick introduction is given in the exercise
session slides, but you should check the project website to familiarize
yourself with the framework. In particular, take a look at [the
documentation](http://mockito.github.io/mockito/docs/current/org/mockito/Mockito.html)
to find out how you can use mock objects to your advantage.


## Test coverage

You have seen different qualitative criteria that make up good tests. For
example, you should keep edge cases in mind when writing tests, and you should
test one thing at a time, using few assertions per test method.

One quantitative criterion is called *test coverage*. Test coverage measures
how much code is reached by your tests. For example, this measurement tells
you whether your tests can reach both branches in an `if then else` construct.
Of course, it is desirable to cover as much code with the tests as possible. A
lack of coverage may indicate that you do not use certain kinds of inputs in
your tests.

To help you determine the coverage of your tests, there are many tools that
trace which parts of the source code are reached by the tests. One such tool
that integrates into Eclipse is called [EclEmma](http://eclemma.org/). You can
install this plugin by selecting the *Help* menu in Eclipse and choosing
*Eclipse Marketplace...*. In the search field, write "EclEmma" and you will
see an entry for the plugin which you can then choose to install.

You should use this or any other code coverage tool during this exercise in
order to make sure that your tests sufficiently cover your code. We will use
EclEmma during the corrections to check how well your code is covered. Note
that you are not required to cover 100% of your code. Your focus should still
be on the qualitative criteria, but a coverage tool can and will help you come
up with better tests. An example of code that you probably do not want to test
is a trivial getter method (e.g. `int getDestination()` which simply returns
the field `int destination`).


## Problem Description

Your task this week is to improve the code of your Snakes & Ladders and turtle
games and add tests.

You *must* complete the tasks in the following sections (*Snakes & Ladders*
and *Turtle Game*) in order to pass this exercise.


### Snakes & Ladders

Your Snakes & Ladders game should already have a few tests from the previous
weeks. Unfortunately, there are still quite a few parts of your code that are
not covered by any tests.

Furthermore, `Game#play(Die)` is not (or rather may not, depending on what you
implemented during exercise 2) covered by unit tests. To test this method, you
must write a test that mocks the `Die` class. In order to do that, you should
first use Eclipse's *extract interface* feature (right click on the class
`Die`, then choose *Refactor*, and finally choose *extract interface...*) to
create an interface `IDie` with the method `roll()`. Make sure that
`Game#play(IDie)` now takes an `IDie` as an argument. Next, write unit tests
that cover the `Game#play(IDie)` method. You must implement two different
types of tests that cover `Game#play(IDie)` by using two different approaches
to mocking as follows:

- In the first variant, you must mock an `IDie` object using Mockito. This
  way, you can specify the behaviour of some die and do not have to rely on a
  correct implementation of some die.
- Another approach to mocking is creating explicit mock objects without
  relying on a framework or library. To do that, you should create a class
  `MockDie` that implements `IDie`. In this `MockDie`, you should implement
  the die behaviour as you need it for your test (you are of course free to do
  whatever you want in `MockDie`).

Write a short paragraph about these two approaches to mocking. Tell us which
approach is better in your opinion and why.

You should also write tests for all squares in your game. Again, you should
use Mockito to mock the objects that are unrelated to the current test. Take a
look at the exercise session slides for an example on how to use mocking
properly in these cases. Make sure that your tests cover various scenarios. A
single test per square is not enough. (E.g., does your game work correctly
when there are `WormholeEntrance` squares, but no exits? Or is your
`SwapSquare` behaving correctly in games with more than two players?)

Keep in mind that you should test both individual methods using JUnit and
Mockito, but also longer examples as we did before, using JExample.


### Turtle Game

Similar to the Snakes & Ladders game, there are not enough tests in the turtle
game. In order to be sure that the implementation behaves correctly, you
should add more tests.

Since you split the parser from the construction of the matrix (a requirement
in exercise 3), you first need to create a class `ParserTest`, in which you
verify that your parser works correctly. Since the parser works with input
typed by a user, you should make sure that your tests cover a lot of possible
inputs. For example, you should make sure your program works correctly with
invalid input (such as typos in the commands or invalid coordinates). Try to
think of edge cases and off-by-one situations.

In a second test class `MatrixBuildTest`, you should implement tests that
verify that the correct squares are marked when executing commands. In these
tests, you should provide parsed commands directly. Don't use a turtle program
as input (i.e. the string you would pass to the parser), but instead construct
the commands manually. This way, you make sure that your tests are independent
of the parser (and can pass even if the parser is not working correctly).

You should make sure that all parts of your game are properly tested. In
particular, if you use exceptions in some places, you should have tests that
result in the exceptions being thrown. Take a look at the slides from the
exercise session to see how you can test whether an exception is thrown.


## Additional Tasks

Use a code coverage tool such as EclEmma to find out which parts of your code
are covered by your tests. You do not need to achieve 100% coverage (see
comment in section *Test coverage*). However, if there are parts of your games
that are not covered, you should write a short statement explaining why you
don't need to cover these particular parts. Do this for both games.


## Deadline

Submit your solutions by pushing your code to the git repository by
___Thursday, 7 April, 13:00___.
