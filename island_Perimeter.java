package LeetCode;

//这道题是说给了一个二维矩阵，代表一个棋盘地图，1代表岛屿占用的地方，其他地方为海
//1一定会围成一个岛，那么求岛的周长。
public class island_Perimeter {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if(j==0||grid[i][j-1]==0)
                        res++;
                    if(j==cols-1||grid[i][j+1]==0)
                        res++;
                    if(i==0||grid[i-1][j]==0)
                        res++;
                    if(i==rows-1||grid[i+1][j]==0)
                        res++;
                }
            }
        return res;
    }
    public static void main(String[]args){
        island_Perimeter it = new island_Perimeter();
        int[][]grid = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.print(it.islandPerimeter(grid));


    }
}
