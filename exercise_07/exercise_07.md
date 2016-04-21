# Exercise 7

This week, you will continue to improve the Sokoban game. In a first part, you
will need to implement additional elements for the game: breakable walls and
bombs. Since the game is now more complex, you may already have to deal with
some refactoring tasks and change your design in order to better support the
new game mechanics. In the second part of the exercise, you will be given a
set of rules that your code must fulfill. If your game does not fulfill these
yet, you can make use of the refactoring techniques shown in the lecture and
exercise session and get used to common tasks when changing and improving your
codebase.

## Third Stage of the Sokoban Game

In the final stage, you should extend your game by adding new gameplay
elements. So far, we have only three different kinds of tiles (wall, floor,
goal) and two kinds of objects (player and box). In order to spice things up,
we add breakable wall tiles as well as bomb objects. A player can push a bomb
into a breakable wall, making both disappear. The breakable wall will be
replaced by a floor tile, allowing the player to push a box to or walk on to
that position. The following symbols are used in the level files (an example
of a level using breakable walls and bombs is the file
`levels/extended1.sok`):

- `O`: Bomb
- `X`: Breakable wall

In this final stage, you __must__ implement the following tasks:

- Add bombs and breakable walls to your game as described above.
- Include these in your parser so that levels featuring the new objects can be
  parsed.
- Include these in your game logic, such that bombs are pushable and when
  pushed into a breakable wall, both disappear and such that the player is now
  able to move to the space that was previously occupied by the breakable
  wall.
- Write a test that solves the `levels/extended1.sok` level.
- Tag the solution with `sokoban3` and make sure the tag is pushed to the
  remote repository.


## Sticking to the principles

You now have implemented all three stages of your Sokoban game. We did not
provide any restrictions, but encouraged to apply the principles and
techniques you learned in the past weeks (such as design by contract, unit
testing, ...). In this part of the exercise, we explicitly ask you to do some
of these things, if you did not already do them.

To pass this part, your game __must__ implement the tasks described in the
following subsections.


### Group your classes into packages

So far, most of our exercises were solved by placing all classes in the same
package in the `src` folder. However, as you may have realized, having lots of
unrelated classes grouped together may become confusing quickly. Fortunately,
Java allows you to create
[packages](https://docs.oracle.com/javase/tutorial/java/package/packages.html),
enabling you to group related classes together.

In this subtask, you __must__ create different packages for your classes. You
are free to choose how the packages are organized, but should make sure that
related classes are close to each other, while mixing unrelated classes should
be avoided as much as possible. You are not allowed to have test classes in
the same package as the other classes.


### Always override `toString()` in each class (except test classes)

You must provide a reasonable `toString()` method in all classes that are
included in your game (except for the test classes). Ideally, the output of
`toString` is easy to read and reveals key information of the object. For
example, a `toString()` method of a game could return a representation of
the current state (and should in turn make use of the `toString()` methods of
the tiles and objects it contains).


### Minimize mutability

Whenever an instance variable is not modified after initialization, declare it
`final`. If you work with lists, use [unmodifiable
lists](http://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#unmodifiableList-java.util.List-)
instead.


### Encapsulation and information hiding

Use the appropriate access modifiers for all your methods and instance
variables. Keep in mind that apart from `public`, `private`, and `protected`,
having no modifier at all is also an option (and results in the method or
variable being visible to the class and to classes in the same package). See
[the
documentation](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
for more details on access modifiers.


### Check parameters for validity

For each method that takes parameters, you should think about the valid inputs
(e.g., "must not be null"). Write preconditions in the form of `assert`
statements for all methods in your code. In addition, write JavaDoc comments
for all _public_ methods in your code, explaining what the restrictions on the
parameters are.


## Deadline

Submit your solutions by pushing your code to the git repository by
___Thursday, 28 April, 13:00___.
