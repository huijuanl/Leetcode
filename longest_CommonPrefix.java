package LeetCode;
//Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".
//这道题比较简单，就是找出string数组中所有字符串的最大共同前缀。
//O(N2)的时间复杂度
//双层循环
//外层循环为第一个字符串划过的位置i，内层循环为剩下的n-1的字符串的位置i的元素是不是都与第一个字符串
//第i位置的值相同，都相同的话公共前缀个数+1，否则停止寻找。
public class longest_CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
          String ComPre = "";
          if(strs==null||strs.length==0)
              return ComPre;
          int i =0;
          ok:while (i<strs[0].length()){
              for(int j=1;j<strs.length;j++){
                  if(i>=strs[j].length()||strs[j].charAt(i)!=strs[0].charAt(i))
                      break ok;
              }
              ComPre += strs[0].charAt(i);
              i++;
          }
          return  ComPre;
    }
    public static void main(String[]args){
        String[]strs = {"dog","racecar","car"};
        longest_CommonPrefix it = new longest_CommonPrefix();
        String res = it.longestCommonPrefix(strs);
        System.out.println(res);

    }
}
