@Mathias
#Corrections for exercise 06 & 07 (group03)

Note:
In the stages i just will correct the exercise/stage specific tasks beside code style, JavaDoc and DbC. For code style, JavaDoc and DbC i will just have a look at your third stage version and write my feedback in a separate paragraph.

##sokoban1
You even add additional .sok files and tested for different kind of exeception.
Well done.

##sokoban2
Well done.

You should not use try/catch as you did in `solveBasic1#solveBasic1`. You don't need to put in an assertion that fails. The test case will fail if there is an unexpected exception.
Either you test that the level is played correctly then you do not expect an exception at all or you expect an exception but then you should do it like you did in your `ParserTest`.
If your test fails like here with the message
```
	java.lang.Error: Unresolved compilation problem: 
	Unhandled exception type RenderException
```
just add `throws RenderException` to your method signature: `public void solveBasic1() throws RenderException`


Note also that you had `multiplePlayerException.java` already in sokoban1, in sokoban2 you have additionaly `move.java` and `up.java`. Java complains because you had the class names correct with first char uppercase but the file names have lowercase in the begin. You should always ensure, that your tagged commits don't have any obvious problems.

##sokoban3
You implemented the things we ask you in stage3.
You even implemented an interactive game which ask for the level and load it.
Well done.

Unfortunately your test for extended1.sok (`WallBreakerTest#movePlayerIntoBomb`) fails.

Some other things i stumbled upon:

* In `Game` constructor you catch different exceptions like this:
```
catch(Exception e){
            System.out.println("Could not load level!");
            if(e.getClass().equals(java.io.FileNotFoundException.class)){
                System.out.println("File not found!");
            }
            if(e.getClass().equals(IOException.class)){
                System.out.println("Could not read from the file " + path);
            }
            if(e.getClass().equals(NumberFormatException.class)){
                System.out.println("Either height or width could not be parsed!");
            }
            if(e.getClass().equals(InvalidSizeException.class)){
                System.out.println("Either height or width was 0!");
            }
            if(e.getClass().equals(MultiplePlayerException.class)){
                System.out.println("There is more than one Player!");
            }
            if(e.getClass().equals(BoxGoalException.class)){
                System.out.println("There aren't as much Boxes as Goals!");
            }
            if(e.getClass().equals(IndexOutOfBoundsException.class)){
                System.out.println("The height or the width isn't correct");
            }
        }
```
This is problematic: If you work on your implementation an change something in the logic that raises another exception you will not see which one it is, because you catch every possible exception with `catch(Exception e)`. You can use more than one catch (one for every exception) or multiple catch, see [here](https://docs.oracle.com/javase/7/docs/technotes/guides/language/catch-multiple.html).

* Minimize mutability
I found one single (local) variable which is declared as final.
Looking trough your classes i find at least two instance variables that could be declared final.
Note: You can declare a final variable without assign a value. In this case you need to assign a value in the constructor.
Hint: Check your instance variables and constructors. If the constructor is the only place where you assign a value to this variable you can declare it final.

If you want to know which other method or classes use a variable or method in eclipse, then just mark the name of the variable or method and hit ctrl + shift + g.

##Code style, JavaDoc & DbC
**Code style:**
Your code style is well readable and clean.

**JavaDoc:**
You mostly wrote well class and method comments.
Sometimes you wrote nice parameter explanation in the method commments but you do not mention what the method itself does. A kind of a summary would be nice here.

**DbC:**
The task was:
>**For each method that takes parameters**, you should think about the valid inputs
(e.g., "must not be null"). Write preconditions in the form of `assert`
statements **for all methods** in your code. In addition, write JavaDoc comments
for all _public_ methods in your code, explaining what the restrictions on the
parameters are.
I just found three assertions that check that the parameter is not null.

Note: In `Parser#newTile` you used assertion like this in the switch statement: `default: assert false;`
You should not use assertions inside the logic. You could throw an exception there if you like. Anyway, here is maybe a good place to use enums like showed in the week 8 lab slides.

##Conclusion
You created a very nice solution.
Unfortunately your level test for stage 3 fails and you did not complete the mutability and DbC task.

Please revise your solution for excercise 07 **until 05/12/2016 13:00**

Exercise 06 (Stage 1 & 2 / JavaDoc class / method comments):
**Status: ACCEPTED (ok)**

Exercise 07 (Stage 3 / Mutability / DbC):
**Status: REVISION REQUIRED (nef)**
