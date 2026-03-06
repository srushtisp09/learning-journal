merge sort 
One Line Definition

Merge Sort is a divide and conquer sorting algorithm that recursively splits an array into halves, sorts them, and merges them back in sorted order.
"Merge sort works in two phases:
First, we keep dividing the array into two halves until we reach individual elements — a single element is always sorted by definition.
Then we merge those sorted halves back together by comparing elements one by one and picking the smaller one each time — this gives us a fully sorted array."
PointWhat to sayParadigmDivide and Conquer
Time complexityO(n log n) — all cases
Space complexityO(n) — extra temp array
Stable?✅ Yes — equal elements maintain original order
In-place?❌ No — needs extra space
"why use merge sort?"
"When we need a guaranteed O(n log n) — unlike quicksort which can go O(n²) in worst case. Also when we need a stable sort, or when sorting linked lists where merge sort is preferred over quicksort."
 
 Why is merge sort preferred for linked lists?
"Because in linked lists, we don't need extra space for merging — we just re-link the pointers. So the O(n) space disadvantage disappears, making it better than quicksort for linked lists."

Merge sort uses O(n) extra space because temp array grows as your input grows — so not in-place
code:
public class divideandconquer {
    public static void mergesort(int arr[],int  si,int ei){
 if(si>=ei){
    return;
 }
        int mid=si+(ei-si)/2; //finding middle element
mergesort(arr,si,mid);        //sort left part
mergesort(arr,mid+1,ei);        //sort right part
merge(arr, si, mid,ei);         //merge both halves

  }
    public static void merge(int arr[],int si,int mid,int ei){
        //left [0 3] and right[4 6] 6-0+1//like a method to create the arr
        int temp[]=new int[ ei-si+1];//temp arr to store sorted elements 

        Great question! But there is a KEY difference —

---

## Without temp — Problem!

```
arr = [3, 6, 5, 9]
       ↑       ↑
      LEFT    RIGHT
```

If we try to sort directly in arr:
```
compare 3 vs 5 → 3 is smaller, keep at index 0 ✅
compare 6 vs 5 → 5 is smaller, put at index 1

arr = [3, 5, ?, 9]
           ↑
        but we just OVERWROTE 6 forever! ❌
        6 is lost!
        we still needed 6 to compare with 9!
```

---

## With temp — Problem solved!

```
arr  = [3, 6, 5, 9]   ← never touched while comparing
temp = [_, _, _, _]   ← we write here safely

compare 3 vs 5 → temp[0]=3
compare 6 vs 5 → temp[1]=5
compare 6 vs 9 → temp[2]=6
leftover       → temp[3]=9

arr  = [3, 6, 5, 9]   ← 6 still safe here! ✅
temp = [3, 5, 6, 9]   ← sorted result here
```

NOW safely copy back:
```
arr = [3, 5, 6, 9] ✅
```

---

### One Line
> *"Temp exists to protect original elements from being overwritten WHILE we are still comparing them — once comparison is done THEN we overwrite arr safely"* 
        int i=si;//iterator for i; left part

        int j=mid+1;//iterator for j right part
        int k=0;//iterstor for temp arr
        while(i<=mid&&j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++ ;
            }else{
                temp[k]=arr[j];
                j++ ;
            }
            k++;
        }
        //left when the elemnets are leftover in left part this happens when the elements in the right are still there while the elements in the left are over
        while(i<=mid ){
            temp[k++]=arr[i++];
        }
        //right paart
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        for(k=0,i=si;k<temp.length;k++,i++){
         arr[i]=temp[k];
        }
 
 }
    
    public static void printarr(int arr[]){
        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println();
    } 
    public static void main(String args[]){
int arr[]={6,3,9,5,2,8,};
mergesort( arr, 0,arr.length-1);
printarr(arr);
    }
 }

 also called depth first search
 "We take an array and recursively divide it into two halves — left and right — until we reach single elements. Single elements are already sorted by definition.
The left side fully completes first, then the right side.
Once we have two sorted halves we merge them by creating a temp array, comparing elements from both halves one by one and picking the smaller one each time.
If any elements are left over in either half after comparison, we directly copy them since they are already sorted.
Finally we copy everything from temp back to the original array."

