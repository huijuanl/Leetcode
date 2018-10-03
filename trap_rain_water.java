package LeetCode;
//https://aaronice.gitbooks.io/lintcode/two_pointers/trapping_rain_water.html
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//给首尾两个指针a,b。
//left_Max表示a左边的最大值，right_Max表示b右边的最大值
//对于当前元素而言，当前元素上积水等于min{该元素左边的最大值,该元素右边的最大值}-nums[a]
//如果left_Max<right_Max，那么对于a所指的元素的min一定是left_Max，因为a右边的最大值肯定>=right_Max
//如果left_Max>=right_Max,那么对于b所指的元素的min一定是riht_Max，理由同上。那么当前的积水就可以确定了
//对于最左端和最右端是没有积水的
public class trap_rain_water {
    public int trap(int[] height) {
        if(height==null||height.length<=2)
            return 0;
        int a = 0;
        int b = height.length-1;
        int left_Max = height[0];
        int right_Max = height[height.length-1];
        a++;
        b--;
        int sum = 0;
        while (a<=b){
            if(left_Max<=right_Max){
                sum += Math.max(0,left_Max-height[a]);
                left_Max = Math.max(left_Max,height[a]);
                a++;
            }
            else {
                sum+=Math.max(0,right_Max-height[b]);
                right_Max = Math.max(right_Max,height[b]);
                b--;
            }
        }
        return sum;
    }
    public static void main(String[]args){
        trap_rain_water it = new trap_rain_water();
        int[]height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int sum = it.trap(height);
        System.out.println(sum);
    }
}
