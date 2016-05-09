@Mathias
#Corrections for exercise 08 (group03)
##GUI Design
Well done

##Modular unit tests
Where you wrote unit tests, you wrote mostly well tought ones.

It seems that you did not write a unit test for all the classes that are public.
The following classes have just trivial methods, so not testing them is ok with me:
- `BreakableWall`
- `Floor`
- `Goal`
- `Wall`
- All the classes that implement `Move`

But you did not write test classes for the following classes:
- `Game`
- `InteractiveGame`
- `Player`

And you missed to add unit tests for `Renderer` (especially a unit test where you expect the RenderException).

When i have seen it right, you wrote just three test classes that have unit tests:
- `BombTest`
- `BoxTest`
- `TileTest`

Note that in `Box` not all branches are adequately tested (use a coverage tool like EclEmma with your `BoxTest`).

Note that you used Mockitos `spy` in some of your tests. In the exercise was stated *"everything outside of the class under test should be mocked"*. If you use `spy` you still rely on the effective implementation of a class. Of course you could stub methods but are you sure that no other implemented method is called that you do not stub? In the contrary a real mock just returns default values for primitive datatypes and null for objects if nothing further is defined. This means also with a mock you can't be sure that you stubed all the needed methods but you will at least receive NullpointerException for the methods that return objects when trying to use that returned object.

You did not mark all of your integration tests.

##Conclusion
Your GUI Design is accepted.
If i would follow the exercise description literally i would ask you to go over all your publicitly visible classes and public method and check that you have at least one unit test for them. I do not ask you to do it for all classes.

But you need to provide unit tests for all non-trivial public methods in `Game`, `InteractiveGame` and `Player`. Furthermore i want you to mark all integration tests with a JavaDoc comment.

Please submit your revised solution **until Thursday, 05/12/2016 13:00**.
Let me know if you have questions regarding testing or other P2 related questions.

**Status: REVISION REQUIRED (nef)**