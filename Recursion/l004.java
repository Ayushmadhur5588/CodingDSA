public class l004 {
    public static void main(String[] args){
     int[][] arr = new int[5][5];
     int[][] dir = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
     printKnightTour(arr, 2, 2, 1,dir);

    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void printKnightTour(int[][] chess, int r, int c, int move, int[][] dir){
     
        if(move == chess.length * chess.length){
        chess[r][c] = move;
        display(chess);
        chess[r][c] = 0;
        return;
      }
    
        chess[r][c] = move;
        int n = chess.length;
        int m = chess[0].length;

        for(int d = 0; d < dir.length; d++){
            int row = r + dir[d][0];
            int col = c + dir[d][1];

            if(row >= 0 && col >= 0 && row < n && col < m && chess[row][col] == 0){
                printKnightTour(chess, row, col, move + 1, dir);
            }
        }
        chess[r][c] = 0;



    }


   
}
