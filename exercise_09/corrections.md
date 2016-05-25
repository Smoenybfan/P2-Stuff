git@Mathias
#corrections for exercise 09 (group 03)

##ex9.1
You did not really used the service locator pattern.
What you did is create a kind of an abstract interface (not literally a java interface) for `Parser` and `Renderer` which uses the singleton pattern but this is not the service locator pattern. The service in your example should be a returned IParser or IRenderer (something like `public abstract static IParser getParser();`), not the methods of `Parser` or `Renderer` it self like you did (`public abstract Tile[][] parse(String path) throws Exception;`). In my opinion the examples in the task description where clear and helpful.

##ex9.2
Can't find a descriptions.md when i checkout your tag `ex9.2` so i used the one in your actual master branch.
Your description and your refactoring seem reasonable.

##comparison paragraph
Of course it is your opinion but I guess you did not really mean that you want to avoid the open-closed principle.

##conclusion
You did use a singleton pattern but not in combination with the service locator pattern.
Please add the service locator pattern in the three cases you described and update your descriptions.md accordingly.
Tag the final result with `ex9.2-revised`.

Please submit your revision **until 06/01/2016 13:00**.

** Status: REVISION REQUIRED (nef) **

