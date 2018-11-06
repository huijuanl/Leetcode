package LeetCode;

import java.util.HashMap;

//3除以7为0.42857142...
//利用辗转相除法，哈希表中保存的是余数，和余数的位置
//一旦发现某位置的余数在哈希表里面出现，说明找到了循环节
public class _166fractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)
            return "";
        long numerator1 = (long) Math.abs(numerator);
        long denominator1 = Math.abs(denominator);
        String s = "";
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0))
            s += "-";
        long n = numerator1 % denominator1;
        long m = numerator1 / denominator1;
        s += Math.abs(m);
        HashMap<Long, Integer> hashMap = new HashMap<>();
        if (n != 0)
            s += ".";
        StringBuilder fraction = new StringBuilder("");
        int index = 0;
        while (n != 0) {
            if (!hashMap.containsKey(n)) {
                hashMap.put(n, index++);
                fraction.append(Math.abs(n * 10 / denominator1));
                n = n * 10 % denominator1;
            } else {
                int value = hashMap.get(n);
                fraction.insert(value,'(');
                s += fraction + ")";
                break;

            }
        }
        if (n == 0)
            s += fraction;
        return s;
    }

    public static void main(String[] args) {
        int numerator =-1;
        int denominator = 6;
        _166fractionToDecimal it = new _166fractionToDecimal();
        String s = it.fractionToDecimal(numerator, denominator);
        System.out.println(s);
    }
}

