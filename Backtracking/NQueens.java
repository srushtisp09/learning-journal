// NQueens
// Step 1:Ignoring the safety majors of placement we will just find the number of ways
//  in which Q can be placed
//  public class NQueens{
//    public static void NQueens(char board[][],int row){
// if(row==board.length){
//   printBoard(board);
//   return;
// }
// for(int j=0;j<board.length;j++){
//    board[row][j]='Q';
//    NQueens(board,row+1);
//    board[row][j]='X';
// }
//    }
//    public static void printBoard(char board[][] ){
//       System.out.println("----Chess Board-----");
//       for(int i=0;i<board.length;i++){
//          for(int j=0;j<board.length;j++){
//             System.out.print(board[i][j]+" ");
//          }
//          System.out.println();
//       }
//    }
//     public static void main(String args[]){
//       int n=2;

//       char board[][]=new char[n][n];
//       for(int i=0;i<n;i++){
//          for(int j=0;j<n;j++){
//             board[i][j]='X';
//          }
//       }
//       NQueens(board,0);
//     }

//  }

// considering the condition of safe place
// so basically if a queen is placed in certain no position then the placement of no other queens in the same col or same
// row and also not in diagonal ways both right and left
public class NQueens{
   public static boolean isSafe(char board[][],int row,int col ){
      //Vertical up
      for(int i=row-1;i>=0;i--){
         if(board[i][col]=='Q'){
            return false;
         }
        
      }
      //diag right up 
      for(int i=row-1,j=col+1;i>=0 &&j<board.length;i--,j++){
         if(board[i][j]=='Q'){
            return false;
         }
      }
      //diag left up
      for(int i=row-1,j=col-1;i>=0 && j>=0 ;i--,j--){
         if(board[i][j]=='Q'){
            return false;
         }
      }

      return true;
   } 
   public static void NQueens(char board[][],int row){
     if(row==board.length){
         printBoard(board);
         return ;
      }
      for(int j=0;j<board.length;j++){
     if(isSafe(board,row,j)){
      board[row][j]='Q';
      NQueens(board,row+1);
      board[row][j]='.';
       }
     }
     
   }
   public static void printBoard(char board[][]){
      for(int i=0;i<board.length;i++){
         for(int j=0;j<board.length;j++){
            System.out.print(board[i][j]);   
               }
      }
      System.out.println();
   } 
   public static void main(String args[]){
      int n=5;
      char board[][]=new char[n][n];
      for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
            board[i][j]='.';
         }
      }
 NQueens(board,0);
 
   }
} 