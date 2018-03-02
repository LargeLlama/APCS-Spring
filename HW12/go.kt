Wubin Peco
APCS pd02
HW12 - teenage mutant ninja turtles
2018-03-01
stir fry by migos

0)
The Boardasaurus class definition appears to be lacking in a specification of whether it is public or not - additionally the actual name of the class
is Demo.java, which has a class definition that we are accustomed to. I tested this out by making another quick test file that referenced the aforementioned
Boardasaurus class, but it provided an error, say it doesn't exist, allowing me to come to the conclusion that it is a private class, for the sole use of
within the file it's actually written to. This makes sense, as Demo is a simple driver class and having one file can be useful in cases like this.

1)
The first argument provided must be an int that specifices the board size - the board is n x n, with n being whatever integer the user put. The next number
is how long to wait between moves in milliseconds. Both of these have default values that are used when no paramters are given or if improper ones are provided.

2)
The defualt values, when no arguments are given, are, board size of 8 and delay time of 500ms.

3) 
The recursion simply repeats the act of taking a random spot on the board and setting it the current move counter, which is incremented. The base case is when the 
number of moves is greater than the size of the board, which prevents any of the "borders" being affected and changed. It is not necessary, as there is an iterative
way to do this, but the recursive way works.

4)
When I do run it, I expect to see a small board of an 8x8 matrix, with a bunch of -1's surrounding it, and then a random spot on the board of 0's will be changed to the number of moves. It won't run more than 64 times.

5)
Depends on the delay, but there isn't any actually computationally extensive work to do as long as the board size isn't too large, so it will simply be the delay multipled by the number of moves plus a couple of extra milliseconds, maybe even a second, to account for the actually updating.

6)
ANSI is the American National Standards Institute. It's responsible for setting up a voluntary consensus for a variety of things, but mostly in technology. This goal is 
very important because consistency is very useful in the field of STEM as it makes sure everyone can understand each other's results and conclusions and ideas if they 
are conveyed using the standard.

7)
My expectations were pretty clear, but I didn't expect to be in the top corner, and seeing the terminal "move" like it does when it's downloading something or any task
like that was surprising - I expected a choppier animation or it to be printed in succession, but I realized it clears the board each time, which I missed in my initial 
analysis of the code.

8)
We can simply change the part that makes a random spot on the board a move number and instead put our algorithm that does the knights tour.

	My original version of knight's tour implemented a similar technique in the queens problem, but I realized that it was not truly effective. I was working with Tim Marder, and we determined that each spot on the board has a certain number of possible moves for the knight to move to, with a maximum of 8 towards the cenyer and a minimum of 2
at the edges. 
	Thus, we presumed that moving to the spot with the most number of moves would work as a valid algorithm, instead of picking any of the possible moves. This felt right 
because we believed that jumping to the spot with the most possible moves available would prevent a "dead end," where the knight finds itself unable to move without
breaking the rules of the tour.
	However, we soon realized that this was not working as we could not find a solution after running a couple trials. Then, we realized that we should do the opposite;
move to the spot with the LEAST number of moves available because in the beginning is where one is least likely to get caught up in a dead end when moving on these spots,
so if we get rid of these when it is safe to do so, we also start lowering the number of possible moves in the center, but since there are so many it works out and we 
were able to arrive at a solution.

Thus, here is our final algo

1) Start from the corners
2) Move to the spot with the least number of moves available when moved to
3) Repeat 2
	a) if we reach a tie, just pick one, and if it doesn't work, go back and try the other option

We found to is to work in many cases, and when it didn't we simply picked the wrong one in the case of a tie, or we actually picked the wrong spot, as we are prone to
human error.
