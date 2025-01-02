public class src2des {

  public static class pathPair{
    int count = 0;
    String psf = "";
    int len = 0;

     pathPair(int count, String psf, int len){
        this.count = count;
        this.psf = psf;
        this.len = len;
     }

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

public static void printAllPAth(int sr, int sc, int dr, int dc, int[][] dir, int[][] arr, String[] dirS, String ans){
if(sr == dr && sc == dc){
    System.out.println(ans);
    return;
}


arr[sr][sc] = 1;
int n = arr.length;
int m = arr[0].length;

for(int d = 0; d < dir.length; d++){
int r = sr + dir[d][0];
int c = sc + dir[d][1];

if(r >= 0 && c >= 0 && r < n && c < m && arr[r][c] == 0){
     printAllPAth(r, c, dr, dc, dir, arr, dirS, ans + dirS[d]);
}
}

arr[sr][sc] = 0;

}

public static pathPair longestPath(int sr, int sc, int dr, int dc, int[][] dir, int[][] arr, String[] dirS){
    if(sr == dr && sc == dc){
        new pathPair(1, "", 0);
    }

 pathPair myans = new pathPair(0, "", 0);
  arr[sr][sc] = 1;
  int n = arr.length;
  int m = arr[0].length;

for(int d = 0; d < dir.length; d++){
    int r = sr + dir[d][0];
    int c = sc + dir[d][1];

    if(r >= 0 && c >= 0 && r < n && c < m && arr[r][c] == 0){
          pathPair recAns = longestPath(r, c, dr, dc, dir, arr, dirS);
          if(recAns.len + 1 > myans.len){
            myans.len = recAns.len + 1;
            myans.psf = dirS[d] + recAns.psf;
            
        }
        myans.count += recAns.count;
    } 
}

arr[sr][sc] = 0;
return myans;
}


    public static void main(String[] args){
   // int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
   // String[] dirS = {"L","R","T","D"};
    int[][] arr = new int[4][4];
    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
    String[] dirS = { "l", "r", "d", "u", "w", "s", "n", "e" };
    System.out.println(totalPath(0,0,3,3, dir, arr));
    }

  
}

