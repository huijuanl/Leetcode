package LeetCode;

import java.util.ArrayList;

//Given a collection of numbers, return all possible permutations.
//给定一组数，返回全排列，可能存在重复元素
public class permutations {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num==null)
            return res;
        process(num,0);
        return res;
    }
    public void process(int[]num,int i){
        if(i==num.length){
            ArrayList<Integer> tmp =new ArrayList<>();
            for(int k = 0 ;k< num.length;k++)
                tmp.add(num[k]);
            res.add(tmp);
        }
        for(int j = i;j<num.length;j++){
            boolean hasSame = false;
            for(int k=j-1;k>=i;k--){//判断{i,i+1,...j-1}上有没有与num[j]相同的元素
                if(num[k]==num[j]){
                    hasSame = !hasSame;
                    break;
                }
            }
            if(hasSame)
                continue;
            swap(num,i,j);
            process(num,i+1);
            swap(num,i,j);
        }


    }
    public void swap(int[]num,int i ,int j ){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    public static void main(String[]args){
        permutations it = new permutations();
        int[]num = {2,1,1};
        ArrayList<ArrayList<Integer>> res = it.permute(num);
        for(int i =0;i<res.size();i++){
            for(int j =0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }
}
