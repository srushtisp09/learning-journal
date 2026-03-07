Binary search on a sorted and rotated array using both recursive and iterative approaches in Java
# Search in Sorted Rotated Array

## Problem
Given a sorted array that has been rotated at some unknown pivot point,
find the index of a target element efficiently.

## Example
Input:  arr = [4, 5, 6, 7, 1, 2, 3], target = 1
Output: 4 (index of target)

## Approach
- Uses modified Binary Search
- At every step, one half is always sorted
- Check which half is sorted, then check if target lies in it
- If yes → search that half
- If no  → search the other half

## Time & Space Complexity
| Approach   | Time     | Space  |
|------------|----------|--------|
| Recursive  | O(log n) | O(log n) |
| Iterative  | O(log n) | O(1)   |

## What I Learned
- How rotation affects binary search
- Identifying the sorted half at each step
- Converting recursive logic to iterative
```

---
This question can be solved in bith recursive as well as by iterative method 
Recursive method is as follows:
ublic class searchinsortedarray {
    public static int search(int arr[],int tar,int si,int ei ){
        int mid=si+(ei-si)/2;
        if(si>ei){
            return -1;
        }
        if(arr[mid]==tar){
            return mid;
        }
        if(arr[si]<=arr[mid]){
            if(arr[si]<=tar&&tar<=arr[mid]){
                 return search(arr,tar,si,mid);
            }
            else{
               return search(arr,tar,mid+1,ei);
            }
        }else{
            if(arr[mid]<=tar&&tar<=arr[ei]){
                return search(arr,tar,mid+1,ei);
            }else{
                  return search(arr,tar,si,mid-1);
            }
             
            } 
             
        }


          
    public static void main(String[] args) {
        int arr[]={4,5,6,7,0,1,2};
        int target=0;
        int targetindex=search(arr,target,0,arr.length-1);
        System.out.println(targetindex);

    }
}
 we also have a iterative based solution
 public static int search(int arr[], int tar, int si, int ei) {
    
    while(si <= ei) {                          // your while loop ✅
        int mid = si + (ei - si) / 2;
        
        if(arr[mid] == tar) return mid;        // found it!
        
        if(arr[si] <= arr[mid]) {              // left sorted
            if(arr[si] <= tar && tar <= arr[mid]) {
                ei = mid - 1;                  // go left
            } else {
                si = mid + 1;                  // go right
            }
        } else {                               // right sorted
            if(arr[mid] <= tar && tar <= arr[ei]) {
                si = mid + 1;                  // go right
            } else {
                ei = mid - 1;                  // go left
            }
        }
    }
    return -1;                                 // not found
}
```

---

## The Only Difference
```
Recursion          Iteration
---------          ---------
calls itself   →   just updates si or ei
uses stack     →   no stack, just loop
                   more memory efficient ✅
```

---

## Same Logic, Just
```
wherever you wrote:
return search(arr, tar, si, mid-1)  →  ei = mid-1

wherever you wrote:
return search(arr, tar, mid+1, ei)  →  si = mid+1

then while loop automatically 
runs the same logic again! 
 
 