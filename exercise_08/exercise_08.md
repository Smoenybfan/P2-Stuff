# Exercise 8

The last lecture discussed *GUI Construction* and gave an introduction to GUI 
design. A GUI for the TicTacToe game has been designed, and was implemented 
using Java Swing and the Model-View-Controller paradigm.

In this week's exercise, we go back to pen and paper and learn how GUIs are 
commonly designed. GUI mockups are dummies that are used to design a GUI and 
presenting some use cases without actually implementing program logic in the 
background. Initial mockups are often done with pen and paper, especially when 
designing a game interface. In addition, paper prototypes are used to simulate 
the user experience and get a first feeling on how the designed interface can 
be used.

In the first part of the exercise, you will draw mockups and create a 
prototype for the Sokoban game.

In the second part, we will once more practice testing. Your task is to review 
your tests and use mocking where appropriate, and you will distinguish between 
unit and integration tests.


## GUI Design

Before implementing a GUI, it is often a good idea to first think about how 
the GUI should look like. The easiest way to do this is by sketching out your 
ideas with pen and paper. In this part of the exercise, you **do not need to 
implement anything**. Instead, we focus on bringing the ideas to paper. To 
pass this part, **you must complete the following tasks**:

- Create at least 6 different sketches for the main view of the Sokoban game 
  (by main view we mean the state of a game where the player is playing the 
  game and moving around the board in an unsolved state). Draw your sketches
  by hand (on paper and preferably with a pencil; we do not accept drawings 
  that have crossed out and corrected parts!) and take a photo or scan the 
  results and add them to your repository. Your sketches can be similar, but 
  you should include at least three radically different designs.

- Select one of your sketches and create a paper prototype of your game. 
  Simulate the user experience by showing how the user interface can be used. 
  Take a picture of each (major) step. Your prototype should show the 
  following:
  - Selecting a level at the start of the game
  - Pushing a box (both before and after the step).
  - Solving a puzzle (i.e., pushing a box to a goal square while all other 
    boxes are already on a goal square).
  - Whatever you intend to do after a level is solved (is the next level 
    loaded? Are you going back to the start view? ...)

- Create a file `sketches.md` where you include the pictures for the 6 
  sketches you created before.

- Create a file `prototype.md`, where you include the pictures that show the 
  individual steps. For each picture, you should give a short description of 
  what it shows and what the user needs to do in order to get to the next one. 
  For example, you need to describe how the user can make the player move 
  around in order to solve the level.


## Modular unit tests

So far, we used testing in different scenarios: We have seen unit tests that 
use mocking to isolate the method that is being tested, but more often than 
not our tests depend on the correct function of a range of classes and 
methods. Furthermore, we tested complete program executions using JExample, 
where we split the program execution in different steps and put the assertions 
in between intermediate steps. This week, we try to focus a bit more on the 
different kinds of tests and want to make sure that the Sokoban game is 
properly tested.

**Unit tests**, as discussed in the lecture and previous exercises, focus on a 
single class in your program. Dependencies on other parts of the system should 
be avoided. Instead, everything outside of the class under test should be 
mocked. Each method in the class you are testing should be thoroughly tested 
and you should make sure that all paths of a method are covered. Unit tests 
should test the methods with different parameters and cover normal usage, but 
also corner cases.

**Integration tests** on the other hand are tests that exercise multiple
classes. These are useful when you do fundamental changes to your system, for
example when you do refactoring and change your class structure. Writing 
integration tests can also be a great help when coming up with a design of 
your system: You simply write down how you want to use the program as an 
integration test (e.g. using JExample), and then let Eclipse generate 
skeletons for the missing classes and methods, which can later be implemented.

In this part, you **must** update your Sokoban game tests as follows:

- All publicly visible classes must have at least one unit test, where "unit 
  test" refers to a class of test methods. Create at least one test (i.e., a 
  method with the `@Test` annotation and JUnit assertions) for each public 
  method. For example, for the class `Player`, you should create a class 
  `PlayerTest` and at least one test method (with the `@Test` annotation) for 
  each public method in `Player`.

- A unit test may only use and test the class it is testing and must not 
  depend on other classes. Classes on which the class under test is depending 
  **must be mocked**! You can use mock classes or Mockito to do that.

- Integration tests must be marked as such. Do this by adding a JavaDoc 
  comment containing the comment "This is an integration test." and putting 
  them at the end of the class, or alternatively, solve the optional task and 
  use the created annotation.

### Optional Tasks

Create a custom annotation `@IntegrationTest` that can be used to mark 
integration tests. Methods marked like this should still be recognized by 
JUnit and executed when selecting "Run all tests" in Eclipse.


## Evaluation Form

We prepared an [evaluation 
form](https://docs.google.com/forms/d/1ADYZ-ECF2vzuECI8rC7C_f-1dIoL2nfyCVDA8MsdmAM/viewform) 
that covers the previous exercises and lectures. We are constantly working on 
the course material and appreciate any feedback on it, so please fill it out 
and let us know how we can improve the lecture and exercises in the future.

(Submitting the evaluation form is optional, anonymous, and unrelated to this 
exercise.)


## Notes

- Make sure that all your photos and/or scans are readable. If we can't read 
  them, we may ask you to redo them.

- Your designs can be intended for different devices. For example, you could 
  sketch a GUI for a smartphone or a console.

- Make sure you use proper markdown syntax in `sketches.md` and 
  `prototype.md`. If you are unsure about how to do that, read the [markdown 
  documentation](https://daringfireball.net/projects/markdown/).

- Keep in mind that the GUI is not necessarily just about visualizing the 
  board. Maybe there is other useful information that you can present to the 
  user?

- In the unit tests, we may overlook the occasional dependency on other 
  classes in the system (**e.g.**, if you use trivial data classes, such as a 
  class `Point` that is used for storing coordinates, it is ok to use them in 
  the unit tests).


## Deadline

Submit your solutions by pushing your code to the git repository by 
___Thursday, 5 May, 13:00___.
