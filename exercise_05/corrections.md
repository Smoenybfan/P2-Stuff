@Mathias

#corrections for exercise_05 (group03)

Well done and really nice documented.
You did not name your markdown file *debugger.md*.
You did not solve the optional task.

Hint:
In <code>ProgramParser</code> you have the following code:
```java
blocks.add(program.substring(blockStartIndex, ++i));
blockStartIndex = i;
```

You added some code below, that increased the blockStartIndex on spaces, so that the next command does not have leading space.

Another solution would be just to trim the command so it has no white space at beginning or end of command:
```java
blocks.add(program.substring(blockStartIndex, ++i).trim());
```

**Status: ACCEPTED (OK)**