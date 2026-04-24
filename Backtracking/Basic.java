// Backtracking is the process wherein if you dont like the path or want to 
// return back to the start then you can traverse back the start 
public class Basic{
    public static void changeArr(int arr[],int i,int val){
        if(i==arr.length){
             printArr(arr);
             return; 
        }
        arr[i]=val;
       changeArr(arr,i+1,val+1);
arr[i]=arr[i]-2;        
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr[]=new int[5];
        changeArr(arr,0,1);
        printArr(arr); //print arr here gives the arr after backtracking 

    }
}
