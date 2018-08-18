package LeetCode;

//https://www.cnblogs.com/zichi/p/5745992.html
//思路: 求 min{a[i],a[j]}*(j-i)
//暴力法是O(n^2)的时间复杂度
//优化法：双指针法
//start,min (每次去掉start和min所指元素较小的那一个，因为包含 较小的元素的之后的区间都不可能再大过当前最大值)
public class container_with_most_water {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            max = Math.max(max, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else end--;

        }
        return max;
    }
}
