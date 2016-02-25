# Exercise 1

In this warmup exercise, we implement a simple program and establish a workflow
for future exercises, using git, Java, and JUnit.

## Problem Description

*Glob patterns* are strings that specify filenames. They contain regular
characters that are literally matched, as well as the *wildcard* characters `*`
(matching any number of characters) and `?` (matching exactly one arbitrary
character). Our goal is to implement an algorithm that checks whether a pattern
matches a filename.

In order to pass this exercise, you must fulfill the following requirements:

- Implement the missing methods in class `FilePattern`.

- Pass all tests in `FilePatternTest`. Note that your solution must be generic;
  you are not allowed to handle each test case individually in your
  implementation.

- Write proper git commits. Read the [git
  documentation](http://git-scm.com/book/ch5-2.html#Commit-Guidelines) for a
  description of "best practices".

## Hints

- You might want to implement additional tests to verify the handling of other
  kinds of filenames not covered in `FilePatternTest`!
- There exist two main approaches: You can implement the pattern matching
  algorithm yourself, or use the regular expression library (classes in
  the `java.util.regex` package). If you opt for the latter, you need to pay
  attention to special characters in regular expression patterns (e.g. the
  character `[` has a special meaning inside a regular expression pattern!).
- Either way, we suggest to implement your own matching algorithm: It is a nice
  exercise and does not require knowledge of the regular expressions classes.

## Mandatory Reading Material

- [What is a versioning control system?](http://www.git-tower.com/learn/ebook/command-line/basics/what-is-version-control)

- [Why use git in the first place?](http://www.git-tower.com/learn/ebook/command-line/basics/why-use-version-control)

- [How does committing work and what does it do?](http://www.git-tower.com/learn/ebook/command-line/basics/basic-workflow)

- [Got 15 minutes and want to learn Git?](https://try.github.io/levels/1/challenges/15)

  This is a very nice tutorial  if you never used git before. Do at least the
  first 13 challenges from level 1.

- [Git Commit Guidelines](http://git-scm.com/book/ch5-2.html#Commit-Guidelines)

  Note that these guidelines do not have to be implemented too strictly. For
  example, you may want to prefer writing your commits in past tense (e.g.,
  "fixed type" instead of "fix typo"); it is more important to be consistent
  in your commit history.

## Optional Reading Material

  - [An introduction to version control](http://guides.beanstalkapp.com/version-control/intro-to-version-control.html)

  - [Become a git guru](https://www.atlassian.com/git/tutorials/) 

  - [A Successful Git Branching Model](http://nvie.com/posts/a-successful-git-branching-model/)

## Deadline

Submit your solutions by pushing your code to the git repository by
___Friday, 4 March, 13:00___.
