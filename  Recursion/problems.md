Starting with :Types of Recursion
There are four types of recursion:
1.Tail Recursion
2.Head Recursion
3.Tree Recursion
4.Linear Recursion
 
1.Tail Recursion: NO work happens once the base case is reached. 
for example:Lets say You have an array and your supposed to check if its sorted or not
 Code:
 public static boolean  checksarr(int arr[],int i){
    //BASE CASE
    if(i==arr.length-1){
        return true;
    }
    ///condition
    if(arr[i]>arr[i+1]){
        return false;
    }
   return checksarr(arr,i+1);
 }
  So here the last work is done by the recursive function.So this problem falls under Tail Recursion.
  REMEMBER:NO UNWINDING HAPPENS



  2.Head recursion:Recursive call is the first thing, work is done during unwinding.
  void print(int n){
    if(n==0) return;
    print(n-1);         // call first
    System.out.println(n); // work done AFTER, during unwinding
}
3. Tree Recursion
Function makes more than one recursive call — branches like a tree.
 return fib(n-1) + fib(n-2);  // exactly what you studied in fib!
This is why fib had that big tree shaped dry run.
So basically fibonacci is nothing but lets say 01 the next number that comes will be 1 and then the series is 011 next number will be 0+1+1=2 0012..and soo on.

Code: public static int fib(int n){
     if(n==1||n==0){
          return n;
     }
     int fnm1=fib(n-1);
     int fnm2=fib(n-2);
     int fn=fnm1+fnm2;
     return fn;
 }
 4.Linear Recursion:
 Function calls itself only once each time — straight line, no branching.
    //BASE CASE
    if(i==arr.length-1){
        return true;
    }
    ///condition
    if(arr[i]>arr[i+1]){
        return false;
    }
   return checksarr(arr,i+1);
 }
 1. How many recursive calls are there?
   → More than one?  → TREE RECURSION
   → Only one?       → go to question 2

2. Where is the recursive call?
   → Last line?      → TAIL RECURSION
   → First line?     → HEAD RECURSION

3. Is there pending work after the call returns?
   → No pending work → TAIL RECURSION
   → Work pending    → HEAD RECURSION
   #PROBLEMSSS----
 Problem 1:Print numbers in decreasing  order
 code:
   if(n==1){
    //         System.out.print(n);
    //         return;
    //     }
    //     System.out.print(n+" ");
    //     printdec(n-1);
 

problem 2:print numbers in increasing order:
code:if(n==1){
    //         System.out.print(n+" ");
    //         return;
    //     }
    //     printIncreasing(n-1);
    //     System.out.print(n+" ");
   problem 3:Factorial of n
    if(n==1){
    //         System.out.print(n+" ");
    //         return;
    //     }
    //     printIncreasing(n-1);
    //     System.out.print(n+" ");  
    problem 4:Sum of n natural numbers:
     if(n==1){
//         return 1;
//     }
//     int  sumofnm1=sumofn(n-1);
//     int sumn=n+sumofn(n-1);
//     return sumn;
// }
problem 5:Sum of fibonacci
 if(n==1||n==0){
          return n;
     }
     int fnm1=fib(n-1);
     int fnm2=fib(n-2);
     int fn=fnm1+fnm2;
     return fn;
 }
 problem 6:Check if a array is sorted or not'
   //BASE CASE
    if(i==arr.length-1){
        return true;
    }
    ///condition
    if(arr[i]>arr[i+1]){
        return false;
    }
   return checksarr(arr,i+1);
   problem 7:First occurence
    if(i==arr.length){
//         return -1;
//     }
//     if(arr[i]==key){
//         return i;
//     }
//    return firstOccurence(arr,key, i+1);


firstOccurence(arr, 3, 0)
    i=0, arr[0]=1, 1==3? NO
    → calls firstOccurence(arr, 3, 1)
        i=1, arr[1]=3, 3==3? YES
        → return 1 ✅
Value bubbles straight up, returns index 1. Done!

Now where does return -1 come in? Take arr = [1, 2, 4, 5], key = 3 (key doesn't exist)
firstOccurence(arr, 3, 0)
    i=0, arr[0]=1, 1==3? NO
    → calls firstOccurence(arr, 3, 1)
        i=1, arr[1]=2, 2==3? NO
        → calls firstOccurence(arr, 3, 2)
            i=2, arr[2]=4, 4==3? NO
            → calls firstOccurence(arr, 3, 3)
                i=3, arr[3]=5, 5==3? NO
                → calls firstOccurence(arr, 3, 4)
                    i=4, i==arr.length? YES
                    → return -1  (key not found)
Unwinding:
firstOccurence(arr, 3, 4) → returns -1
firstOccurence(arr, 3, 3) → returns -1 (just passes up)
firstOccurence(arr, 3, 2) → returns -1 (just passes up)
firstOccurence(arr, 3, 1) → returns -1 (just passes up)
firstOccurence(arr, 3, 0) → returns -1 (just passes up)

FINAL ANSWER: -1  (key not found)

So return -1 is just a convention meaning:
-1 → key doesn't exist in the array
     (since -1 is never a valid index)
And yes — unwinding happens here but just like sorted array, no work is done during unwinding, the -1 just bubbles straight up! Tail recursion again

problem 7:last occurence
    if(i==arr.length){
//         return -1;
//     }
//     int isFound=lastOccurence(arr,key,i+1);
//     if(isFound==-1&&arr[i]==key){
//         return i;
//     }
// return isFound;

   dry run
   arr = [1, 2, 4, 2], key = 2

Going Down (recursive calls):
lastOccurence(arr, 2, 0)
    → calls lastOccurence(arr, 2, 1)
        → calls lastOccurence(arr, 2, 2)
            → calls lastOccurence(arr, 2, 3)
                → calls lastOccurence(arr, 2, 4)
                    i==arr.length? YES
                    → return -1
 Unwinding (where actual work happens):
 lastOccurence(arr, 2, 4)
    returns -1 ⬆️

lastOccurence(arr, 2, 3)
    ans = -1
    arr[3]=2, 2==2? YES → return 3 ⬆️

lastOccurence(arr, 2, 2)
    ans = 3
    arr[2]=4, 4==2? NO → return ans(3) ⬆️

lastOccurence(arr, 2, 1)
    ans = 3
    arr[1]=2, 2==2? YES → return 1?                   
 problem 8:power x^n
  if(n==0){
        return 1;
    }
    int halfsq=optimizepow(x,n/2) ;
    int halfpowsq=halfsq*halfsq;
    if(n%2!=0){
        halfpowsq=x*halfpowsq;

    }
    return halfpowsq;
}
int optimizepow(int x, int n) {
    if (n == 0) return 1;
    
    int halfsq = optimizepow(x, n/2);  // recurse with n/2
    int halfpowsq = halfsq * halfsq;   // square it
    
    if (n % 2 != 0) {                  // if n is ODD
        halfpowsq = x * halfpowsq;     // multiply one more x
    }
    return halfpowsq;
}
```

---

## PHASE 1: Calls Going DOWN 📞
```
optimizepow(2, 4)
|
|  n=4, not 0
|  n/2 = 2, "I need optimizepow(2,2) first..."
|
└──► optimizepow(2, 2)
        |
        |  n=2, not 0
        |  n/2 = 1, "I need optimizepow(2,1) first..."
        |
        └──► optimizepow(2, 1)
                |
                |  n=1, not 0
                |  n/2 = 0, "I need optimizepow(2,0) first..."
                |
                └──► optimizepow(2, 0)
                        |
                        |  n=0 ✅ BASE CASE
                        └──► returns 1
```

---

## PHASE 2: Bubbling UP ⬆️
```
optimizepow(2, 0)
└── returns 1


optimizepow(2, 1)
├── halfsq     = 1
├── halfpowsq  = 1 * 1 = 1
├── n=1, ODD! → halfpowsq = 2 * 1 = 2
└── returns 2


optimizepow(2, 2)
├── halfsq     = 2
├── halfpowsq  = 2 * 2 = 4
├── n=2, EVEN → no extra multiply
└── returns 4


optimizepow(2, 4)
├── halfsq     = 4
├── halfpowsq  = 4 * 4 = 16
├── n=4, EVEN → no extra multiply
└── returns 16 ✅
```

---

## Why ODD needs extra multiply?
```
2^5 = 2^(5/2) * 2^(5/2) * 2
           ^         ^      ^
         half      half   one extra!
       (integer   (integer  because
        div=2)     div=2)   5 is odd
```

When n is odd, `n/2` in integer division **loses** one, so we manually **compensate with one extra x**.

---

## Normal vs Optimized 🚀
```
Normal power(2,8):
calls → n=8,7,6,5,4,3,2,1,0  =  9 calls 😐

optimizepow(2,8):
calls → n=8,4,2,1,0           =  5 calls 🚀