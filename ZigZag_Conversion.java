package LeetCode;
//zigzag题
//https://leetcode.com/problems/zigzag-conversion/description/
//发现所有行的重复周期都是 2 * nRows - 2
//
//对于首行和末行之间的行，还会额外重复一次，重复的这一次距离本周期起始字符的距离是 2 * nRows - 2 - 2 * i
//解析来自 ljiabin 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/ljiabin/article/details/40477429?utm_source=copy
public class ZigZag_Conversion {
    //找规律，注意寻找间隔规律
    public String convert(String s, int numRows) {
        String res = "";
        if(numRows==1)
            return s;
        for(int i =0;i<numRows;i++){//第i行
            int deta = 2*(numRows-1)-2*i;
            for(int j =i;j<s.length();j+=2*numRows-2) {//numRows!=1，因为2*numRows-2==0会造成死循环
                res += s.charAt(j);
                if(i<(numRows-1)&&i>0&&(j+deta)<s.length())
                res+=s.charAt(j+deta);
            }
        }
        return res;
    }
    public static void main(String[]args){
        ZigZag_Conversion it = new ZigZag_Conversion();
        String s ="A";
        int numRows = 1;
        String res = it.convert(s,numRows);
        System.out.println(res);


    }
}
