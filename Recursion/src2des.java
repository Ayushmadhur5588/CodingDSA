public class src2des {
    public static void main(String[] args){
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    int[][] arr = new int[4][4];
    System.out.println(totalPath(0,0,3,3, dir, arr));
    }

    public static int totalPath(int sr, int sc, int dr, int dc, int[][] dir, int[][] arr){
            if(sr == dr && sc == dc){
                return 1;
            }

        int count = 0;
        arr[sr][sc] = 1;
        int n = arr.length;
        int m = arr[0].length;

        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >= 0 && c >= 0 && r < n && c < m && arr[r][c] == 0){
                count += totalPath(r, c, dr, dc, dir, arr);
            }
        }
        
        arr[sr][sc] = 0;
        return count;
    }

    
}

