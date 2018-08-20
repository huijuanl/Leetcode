package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

//统计朋友圈的个数
//可以用深度优先搜索（递归实现）或者广度优先搜索（非递归队列）
public class friend_Circle_Num {
    boolean[] visited ;
    public int findCircleNum(int[][] M) {
        visited = new boolean[M.length];
        int count = 0;
        for(int i =0;i<M.length;i++){
            if(!visited[i]){
                count++;
                process2(M,i);
            }
        }

        return count;
    }
    //广度优先搜索
    public void process(int[][]M,int i){
        Queue<Integer>queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()){
            int cur = queue.poll();
            if(!visited[cur])
                visited[cur]=true;
            for(int j =0;j<M[0].length;j++){
                if(M[cur][j]==1&&!visited[j])
                    queue.add(j);
            }
        }
    }
    //深度优先搜索
    public void process2(int[][]M,int i){
        if(visited[i])
            return;
        visited[i] = true;
        for(int j =0;j<M.length;j++){
            if(M[i][j]==1&&!visited[j])
                process(M,j);
        }
    }
    public static void main(String[]args){
        int [][]M = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        friend_Circle_Num it = new friend_Circle_Num();
        int res = it.findCircleNum(M);
        System.out.print(res);
    }
}
