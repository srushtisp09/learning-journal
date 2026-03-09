quetsion 1:
Divide & Conquer QUESTIONSQuestion1:ApplyMergesorttosortanarrayofStrings.(Assumethatallthecharactersinall the Strings are in lowercase). (EASY)Sample Input 1: arr = { "sun", "earth", "mars", "mercury"}Sample Output 1: arr = { "earth", "mars", "mercury","sun"}
code:
import java.util.Arrays;

class Solution {

    public static String[] mergeSort(String[] arr, int lo, int hi) {
        if (lo == hi) {
            String[] A = {arr[lo]};
            return A;
        }

        int mid = lo + (hi - lo) / 2;

        String[] arr1 = mergeSort(arr, lo, mid);
        String[] arr2 = mergeSort(arr, mid + 1, hi);
        String[] arr3 = merge(arr1, arr2);

        return arr3;
    }

    static String[] merge(String[] arr1, String[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        String[] arr3 = new String[m + n];

        int idx = 0, i = 0, j = 0;

        while (i < m && j < n) {
            if (isAlphabeticallySmaller(arr1[i], arr2[j])) {
                arr3[idx] = arr1[i];
                i++;
            } else {
                arr3[idx] = arr2[j];
                j++;
            }
            idx++;
        }

        while (i < m) {
            arr3[idx] = arr1[i];
            i++;
            idx++;
        }

        while (j < n) {
            arr3[idx] = arr2[j];
            j++;
            idx++;
        }

        return arr3;
    }

    static boolean isAlphabeticallySmaller(String str1, String str2) {
        if (str1.compareTo(str2) < 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] arr = {"sun", "earth", "mars", "mercury"};

        String[] a = mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
```

**Output:**
```
earth
mars
mercury
sun
It depends on what your function returns

Case 1 — lo == hi (This solution)
When your function returns something (a new array):
java// Returns a new array
public static String[] mergeSort(String[] arr, int lo, int hi) {
    if (lo == hi) {
        String[] A = {arr[lo]};
        return A;               // MUST return something
    }
}
Case 2 — start >= end (Classic way)
When your function is void (sorts in-place, returns nothing):
java// Returns nothing, modifies original array
public static void mergeSort(int[] arr, int start, int end) {
    if (start >= end) return;   // just stop, no need to return value
}
```
> `>=` is used as a **safety guard** in case somehow start overshoots end.

---

### Simple Rule to Remember:
```
Function returns new array?  → use lo == hi
Function is void (in-place)? → use start >= end

 
Both work in both cases. The real difference is just:
lo == histart >= endChecksexactly 1 element1 or 0 elementsSafer?less safemore safe (extra guard)Used whenreturn type functionvoid function

start >= end is just a safer, more defensive way of writing it — that's why most people prefer it!

Phase 1 — SPLIT till single elements
{"sun","earth","mars","mercury"}
        ↓
["sun"] ["earth"] ["mars"] ["mercury"]

Phase 2 — MERGE back in sorted order
["earth","sun"] ["mars","mercury"]
        ↓
["earth","mars","mercury","sun"]


1. What is Merge Sort?
   → Divide & Conquer, splits array and merges back

2. Base case — why lo == hi?
   → Single element = already sorted

3. What does merge() do?
   → Combines two sorted arrays into one sorted array

4. compareTo() logic
   → negative = first string is smaller

5. Time & Space complexity
   → O(n log n) time, O(n) space



   How compareTo() Works

Simple Definition:

It goes character by character from left to right and subtracts ASCII values at the first difference it finds
"sun".compareTo("earth")

s vs e
115 - 101 = +14  → positive → "sun" comes AFTER "earth"


--------TIPS AND TRICK---------
When to use Recursion:
✅ Divide & Conquer problems (Merge Sort, Quick Sort)
✅ Tree problems
✅ When problem naturally breaks into subproblems
When NOT to use Recursion:
❌ Simple array problems (just use a loop!)
❌ When space matters (recursion uses stack space)
❌ When iterative solution is simpler
