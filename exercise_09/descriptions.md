# Descriptions

## Using a Service Locator

###Case 1

The first case where we found a dependency was in
the class game with the Parser.

We decided to create a ParserLocator class
that provides the asked Parser. For more explanation
look at the javadoc in the ParserLocator class.

Then all we had to do in the class game was removing the
dependency by using this ParserLocator. We also had to catch the general Exception
in the constructor since the ParserLocator requires this. But this Exception
shouldn't be thrown, in the case it is thrown there are more detailed Exceptions
missing.

###Case 2

The second case with a dependency was in the box class that depends
on the Floor class.

The Floor is the Tile a Box stands on. So the GroundLocator extends the Tile
and provides the required type of Ground tile.

And again all we had to do was replacing the dependency with the GroundLocator.

###Case 3

These are already all our dependencies we had in our class constructors so
this case is in a method, more exactly in the run method of the class Game.
First we introduced the Superclass RendererLocator (look at the javadoc for
further explanation). Then we extracted an Interface, which isn't really
nescessary as long as all types of Renderer inherit from the Locator but using
an IRenderer just looks way better and is more readable. And it could come in
handy in the future.

##Using the injection

###Case 1
I just extended the Game constructor with the parameter Parser and changed the
affected initialisations (added simply a New Parser()).

###Case 2
Same as in Case 1 with box and new Floor. This time I had to adapt also the subclasses.

###Case 3
Same as the other cases with the run method and a Renderer.

#Comparison
In my opinion, the first approach with Locator is far better. You have more control
over your program. Specially when you got lot of code you have to write a lot more
and lose easily the control.