# Software Development plan

## Phase 0: Requirements Analysis

*(20% of your effort)*

**Important - do not change the code in this phase**

Deliver:

*   [ ] Re-write the instructions in your own words.
    *   If you don't do this, you won't know what you're supposed to do!
    *   Don't leave out details!
*   [ ] Explain the problem this program aims to solve.
    *   Describe what a *good* solution looks like.
    *   List what you already know how to do.
    *   Point out any challenges that you can foresee.
*   [ ] List all of the data that is used by the program, making note of where it comes from.
    *   Explain what form the output will take.
*   [ ] List the algorithms that will be used (but don't write them yet).

### Assignment 4 - Hashing Poetry\

**TWO major parts:**

The purpose of this assingment is to practice using hash tables. Our hash table will 
consist of words given by reading poems, each word will have its own key. Each data point 
will contain a word, the probability that the word is used, and what words are likely to 
come after said word with their probablilities.

The program needs to read poems and build a hash table containing words and their priorites.
Then given a starting word and a length, generate a new poem.

During the writing process, the next word is chosen by taking a random number 0-1, and 
using that and the probability of what word might come next to chose what comes next.


#### 1) Modify the provided hash table class
* Update HashTable to accept 2 genaric parameters
	* Key (a word) and a value (WordFreqInfo)
	* `HashEntry` class must also accept 2 generic parameters
	* `find` should return a value not key
	* **use `testUpdatedHashTable` to test

#### 2) Write a program that will automatically generate a poem

Write a class `WritePoetry` with a method that accepts a file, the word to start with, 
how many words, and a boolean `printHashtable.
* punctuations count as words, and they include a newline
* End the poem with a period unless theres already punctiation as last char
	* this is the last word (the max length
	* When it gets to the final word, check if it can be a punctuation.
* `printHashtable` if true, then print the hash table to console

#### What I know how to do

* (in python) I know how to read a file and count the words. If I combine wordcount and 
grep(?) I should be able to read through the file and count how many of each word
	* Maybe a 2d array, `[ WORD, #ofTimes ]` if the word hasnt been counted yet, append it with a count of 1. If its already there, just add 1 to count.

#### What I dont know

* How the random function in java works. make sure it gives floats 0-1 (eg: .565)
* Once I have the prority of nextWord, how do I sort through a variable # of words/priorities?
	* "Sam" might have 2 possible nextWord, but "I" has 4.
 
#### Data Needed:
* provided poems (crash if file cant be found) 
	* Must have a good file path
* Info provided by the hash table
## Phase 1: Design
*(30% of your effort)*

**Important - do not change the code in this phase**

Deliver:

*   [ ] Function signatures that include:
    *   Descriptive names.
    *   Parameter lists.
    *   Documentation strings that explain its purpose and types of inputs and outputs.
*   [ ] Pseudocode that captures how each function works.
    *   Pseudocode != source code.  Do not paste your finished source code into this part of the plan.
*   Explain what happens in the face of good and bad input.
    *   Write a few specific examples that occur to you, and use them later when testing.


## Phase 2: Implementation
*(15% of your effort)*

**Finally, you can write code!**

Deliver:

*   [ ] More or less working code.
*   [ ] Note any relevant and interesting events that happened while you wrote the code.
    *   e.g. things you learned, things that didn't go according to plan.


## Phase 3: Testing and Debugging
*(30% of your effort)*

Deliver:

*   [ ] A set of test cases that you have personally run on your computer.
    *   Include a description of what happened for each test case.
    *   For any bugs discovered, describe their cause and remedy.
    *   Write your test cases in plain language such that a non-coder could run them and replicate your experience.


## Phase 4: Deployment
*(5% of your effort)*

Deliver:

*   [ ] Your repository is pushed to GitLab.
*   [ ] **Verify** that your final commit was received by browsing to its project page on GitLab.
    *   Ensure the project's URL is correct.
    *   Review the project to ensure that all required files are present and in correct locations.
    *   Check that unwanted files have not been included.
    *   Make any final touches to documentation, including the Sprint Signature and this Plan.
*   [ ] **Validate** that your submission is complete and correct by cloning it to a new location on your computer and re-running it.
	*	Run your program from the command line so you can see how it will behave when your grader runs it.  **Running it in PyCharm is not good enough!**
    *   Run through your test cases to avoid nasty surprises.
    *   Check that your documentation files are all present.


## Phase 5: Maintenance

Spend a few minutes writing thoughtful answers to these questions.  They are meant to make you think about the long-term consequences of choices you made in this project.

Deliver:

*   [ ] Write brief and honest answers to these questions:
    *   What parts of your program are sloppily written and hard to understand?
        *   Are there parts of your program which you aren't quite sure how/why they work?
        *   If a bug is reported in a few months, how long would it take you to find the cause?
    *   Will your documentation make sense to...
        *   ...anybody besides yourself?
        *   ...yourself in six month's time?
    *   How easy will it be to add a new feature to this program in a year?
    *   Will your program continue to work after upgrading...
        *   ...your computer's hardware?
        *   ...the operating system?
        *   ...to the next version of Python?
*   [ ] Make one final commit and push your **completed** Software Development Plan to GitLab.
*   [ ] Respond to the **Assignment Reflection Survey** on Canvas.
