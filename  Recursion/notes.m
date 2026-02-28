Recursion:Recursion is based on  two concepts that is iteration and  Functions .
Recursion is majorly used in trees, Graphs , Dynamic programing 
So what exactly is recursion: Recursion is the method of solving a computational problem where the solution depends
on a solution to smaller instance of the same problem.
Ex : Lets say f(x)=x^2 where x=2 so f(x) will be 4
and if you are asked to find f(f(x)) then it means (x^2)^2 so your previous function itself helped 
you to find the ans for your next question that is your f(f(x)) the function called itself.
 So Remeber Recursion gets divided into three parts:
 1.Base case : Base case prevents stack overflow — without it, 
recursive calls never stop and the call stack runs 
out of memory and crashes.
2.Recursive case: This is where the function calls 
itself with a SMALLER input each time.
Ex: fib(5) calls fib(4), fib(4) calls fib(3)...
each call brings us closer to the base case.
3.Recursive call + Return: The function calls itself 
with smaller input, and when base case is hit, 
values start RETURNING back (unwinding).
Each paused function resumes and completes 
its remaining work.


So the real 3 parts of any recursive function are:

Base case — where it stops
Recursive case — smaller input, calls itself
Unwinding — returning back up the call stack


DRY RUNS CREATE CLARITY: lets not be lazy to do that!
Dry Run — fib(5):

fib(5)
    fnm1 = fib(4)
        fnm1 = fib(3)
            fnm1 = fib(2)
                fnm1 = fib(1) → returns 1
                fnm2 = fib(0) → returns 0
                fn = 1+0 = 1
            returns 1
            fnm2 = fib(1) → returns 1
            fn = 1+1 = 2
        returns 2
        fnm2 = fib(2)
            fnm1 = fib(1) → returns 1
            fnm2 = fib(0) → returns 0
            fn = 1+0 = 1
        returns 1
        fn = 2+1 = 3
    returns 3
    fnm2 = fib(3) → returns 2
    fn = 3+2 = 5
returns 5 ✅


/// Key Takeaway: Trust the recursion, define the base case, 
and let unwinding do the rest ///
