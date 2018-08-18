package LeetCode;
//求一个字符串中所有的回文串的数量
//仍然用中心扩展法
public class count_Substrings {
    public int countSubstrings(String s) {
        if(s==null)
            return 0;
        int count = s.length();
        //奇数
        for(int i =1;i<s.length();i++){
            int left = i-1;
            int right = i+1;
            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                count+=1;
                left--;
                right++;
            }
        }
        //偶数
        for(int i =1;i<s.length();i++){
            int left = i-1;
            int right = i;
            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                count+=1;
                left--;
                right++;
            }
        }
        return count;
    }
    public static void main(String[]args){
        count_Substrings it = new count_Substrings();
        String s = "abab";
        System.out.println(it.countSubstrings(s));

    }
}
