package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
//用递归的思想来输出（回溯法）
public class letter_Combinations {
    List<String> res = new LinkedList<>();
    HashMap<Character, String> hashMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0)
            return res;
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        process(digits,0,"");
        return res;

    }
    public void process(String digits,int i ,String strPre){
        if(i==digits.length()){
            res.add(strPre);
            return;
        }
        String value = hashMap.get(digits.charAt(i));
        for(int k =0;k<value.length();k++){
            strPre+=value.charAt(k);
            process(digits,i+1,strPre);
            strPre=strPre.length()==1?"":strPre.substring(0,strPre.length()-1);
        }
    }
    public static void main(String[]args){
        String input = "23";
        letter_Combinations it = new letter_Combinations();
        List<String> res = it.letterCombinations(input);
        for(int i =0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
