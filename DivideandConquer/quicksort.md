Quick sort:
definition:"Quick sort is divide and conquer. We pick last element as pivot and call partition. Partition uses two pointers i and j — j scans every element, whenever element is smaller than pivot i moves forward and swaps with j. After scanning pivot is placed in its correct position and its index is returned. Then we recursively sort left side and right side of pivot until array is fully sorted"
Paradigm
Divide and Conquer
Time complexity averageO(n log n)
Time complexity worstO(n²)
Space complexityO(log n)
Why in place?
no temp array created!
swapping happens within
the same original array
unlike merge sort ✅
"Merge sort uses extra space but guarantees O(n log n) — Quick sort is in place but can hit O(n²) in worst case"
CODE:
 public static void quicksort(int arr[],int si,int ei){
    if(si>=ei){
        return;
    }
int index=pivotindex(int arr[],int si,int ei);
quicksort( arr,si,index-1);
quicksort(arr,index+1,ei);

 }
 public static int pivotindex(int arr[],int si,int ei){
    int i=si-1;
     int pivot=ei;
    for(int j=si;j<ei;j++){
        if(arr[j]<=pivot){
            i++;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp; 
        return i;
    }
 }
 dry run:
 [6, 3, 9, 5, 2, 8]  → pivot=8 fixed at 4
[6, 3, 5, 2, 8, 9]  → pivot=2 fixed at 0
[2, 3, 5, 6, 8, 9]  → pivot=6 fixed at 3
[2, 3, 5, 6, 8, 9]  → pivot=5 fixed at 2
[2, 3, 5, 6, 8, 9]  → pivot=3 fixed at 1
DONE ✅
quicksort(0,5) → partition → pivot=8 → returns index 4
quicksort(0,3) → partition → pivot=2 → returns index 0
quicksort(1,3) → partition → pivot=6 → returns index 3
quicksort(1,2) → partition → pivot=5 → returns index 2