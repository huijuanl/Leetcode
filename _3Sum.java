package LeetCode;
//Given an array nums of n integers, are there elements a, b, c in nums
// such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
//Given array nums = [-1, 0, 1, 2, -1, -4],
//A solution set is:
//  [-1, 0, 1],
//  [-1, -1, 2]
//结果要去重
//对于3Sum问题，解决方法就是最外层遍历一遍，等于选出一个数，
//之后的数组中转化为找和为target-nums[i]的2SUM问题。
//本题推荐做法：转化为2SUM+双指针首尾逼近法
import java.util.*;

//我自己想到的：递归，每个数取或者不取
//递归超时了
public class _3Sum {
    int target = 0;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        process3(nums);
        return res;
    }
    public void process3(int[]nums){//时间复杂度O(n2),空间复杂度O(1)
        //先排序
        //三个指针a,b,c。先固定c:对剩下的元素用双指针法，退化为2_Sum问题
        //这种方法需要考虑去重问题
        Arrays.sort(nums);
        for(int c = nums.length-1;c>1;c--){
            if(c<nums.length-1&&nums[c]==nums[c+1])//去重
                continue;
            int a = 0;
            int b =c-1;
            int lasta = Integer.MIN_VALUE;
            int lastb = Integer.MIN_VALUE;
            while (b>a){
                if(nums[b]+nums[a]==target-nums[c]){
                    if(lasta==nums[a]&&lastb==nums[b]){
                        a++;
                        b--;
                        continue;
                    }
                    res.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    lasta = nums[a];
                    lastb = nums[b];
                    a++;
                    b--;

                }
                else if(nums[b]+nums[a]>target-nums[c])
                    b--;
                else a++;

            }
        }
    }
    //性能不太好，容易超时，去重增加了很大复杂度
    public void process4(int[]nums){
        //不排序，用哈希表,也不能去重，需要去重，同时元素是乱序的,对每一组符合的结果，需要排序去重
        for(int c = nums.length-1;c>1;c--){
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            for(int i =0;i<c;i++){
                if(hashMap.containsKey(target-nums[c]-nums[i])){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(target-nums[c]-nums[i]);
                    tmp.add(nums[c]);
                    Collections.sort(tmp);
                    if(res.indexOf(tmp)==-1)
                    res.add(tmp);
                }
                hashMap.put(nums[i],i);
            }
        }
    }

    //复杂度最高的方法(O^3)
    public void process2(int[]nums){
        int[][][]matrix = new int[nums.length][nums.length][nums.length];
        for(int k =0;k<nums.length;k++)
        for(int i =0;i<nums.length;i++)
            for (int j =0;j<nums.length;j++){
                if(i!=j&&k!=j&&i!=k){
                    matrix[i][j][k] = nums[i]+nums[j]+nums[k];
                    if(matrix[i][j][k]==target){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        Collections.sort(tmp);
                        int p = res.indexOf(tmp);
                        if(p==-1)
                        res.add(tmp);
                    }

                }
            }

    }
    public void process(int[]nums,int i ,int sum,List<Integer> list ){
        if(i==nums.length){
            if(sum==target&&list.size()==3){
                List<Integer> tmp = new ArrayList<>();
                for(int j=0;j<list.size();j++){
                    tmp.add(list.get(j));

                }
                Collections.sort(tmp);
                int k = res.indexOf(tmp);
                if(k==-1)
                   res.add(tmp);
            }
            return;
        }

        process(nums,i+1,sum,list);
        list.add(nums[i]);
        process(nums,i+1,sum+nums[i],list);
        list.remove(list.size()-1);
    }
    public static void main(String[]args){
        int[]nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        _3Sum it = new _3Sum();
        List<List<Integer>> res = it.threeSum(nums);
        for(int i =0;i<res.size();i++){
            for(int j =0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
