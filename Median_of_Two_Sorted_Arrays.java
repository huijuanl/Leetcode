package LeetCode;

//找两个有序数组的中位数
//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//nums1 = [1, 2]
//nums2 = [3, 4]
//The median is (2 + 3)/2 = 2.5
////归并排序思想,时间复杂度O(n+m)
//利用二分查找的方法，时间复杂度可以变为O(log(m+n))
//参考http://garfieldog.github.io/2015/08/19/median-of-two-sorted-arrays/
public class Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n) % 2 == 1)
            return FindKth(nums1, 0, nums2, 0, (m + n)/2 + 1);
        else
            return (FindKth(nums1, 0, nums2, 0, (m + n) / 2) + FindKth(nums1, 0, nums2, 0, (m + n)/2 + 1)) / 2.0;

    }

    public int FindKth(int[] a, int startA, int[] b, int startB, int k)//在两个区间上找第k小的数,k从1开始取
    {
        if (startA >= a.length)
            return b[startB + k - 1];
        if (startB >= b.length)
            return a[startA + k - 1];
        if (k == 1)
            return Math.min(a[startA], b[startB]);
        //halfk_actual是考虑到了在一个数组中找第k/2的元素时已经超出了该数组的范围，所以取min{k/2,区间长度}
        int halfk_actual = Math.min(k/2,Math.min(a.length-startA,b.length-startB));
        int halfk_A = a[startA + halfk_actual - 1];//第halfk_actual小的元素
        int halfk_B = b[startB + halfk_actual - 1];
        if (halfk_A < halfk_B)
            return FindKth(a, startA + halfk_actual, b, startB, k - halfk_actual);
        else return FindKth(a, startA, b, startB + halfk_actual, k - halfk_actual);


    }

    public static void main(String[] args) {
        Median_of_Two_Sorted_Arrays it = new Median_of_Two_Sorted_Arrays();
        int[] nums1 = {1};
        int[] nums2 = {2,3,4,5,6};
        double res = it.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);

    }
}
