package com.arithmetic;/*
 @author hzy
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/1/12
*/

public class Demo_12 {

    /**
     *
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
     *
     * 示例 1:
     *
     * 输入: 3
     * 输出: "III"
     *
     */



    /**
     * 暴力破解
     * 抽取出公共方法，然后每次对最后一位数进行罗马数字转换，再舍掉最后一位。
     */
    public static String intToRoman(int num) {
        String[] str = { "I","V","X","L","C","D","M"};
        int idx = 0;
        String lmNum = "";
        while(num > 0){
            if(idx == 6){
                lmNum = getLMNumber(num % 10,str[idx],str[idx],str[idx]) + lmNum;
            }else{
                lmNum = getLMNumber(num % 10,str[idx],str[idx+1],str[idx+2]) + lmNum;
            }
            num = num/10;
            idx+=2;
        }
        return lmNum;
    }

    public static String getLMNumber(int num,String str1,String str2,String str3){
        String lmNumber = "";
        if(num < 4){
            for (int i = 0; i < num; i++) {
                lmNumber +=  str1;
            }
            return lmNumber;
        }
        if(num == 4){
            lmNumber = str1 + str2;
            return lmNumber;
        }
        if(num == 5){
            lmNumber = str2;
            return lmNumber;
        }
        if(num < 9){
            for (int i = 0; i < num - 5; i++) {
                lmNumber +=  str1;
            }
            return str2 + lmNumber;
        }
        if(num == 9){
            lmNumber = str1 + str3;
            return lmNumber;
        }
        return lmNumber;
    }


    /**
     * 贪心算法 我永远用最接近的去做比较
     *
     * 如果我去小卖部买55元的东西
     *
     * 你可以选择一张面值50的 和一张5块的
     * 也可以给一张100的让老板找零
     * 贪心算法就是前者
     *
     * 假定我买3块的东西 我先用5块去比较 太多了 老板问 你还有小点的纸币没 我找不开
     * 这时候 你给个两块 还差一块 又给了一块
     * 看着很蠢 但是这确实有效
     *
     */
    public static String intToRoman2(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] moneys = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1 };
        String[] moneyToStr = new String[] {"M", "CM", "D","CD","C","XC","L","XL","X", "IX", "V", "IV", "I" };
        int index = 0;
        while(num > 0){
            //如果下标对应的罗马数字大于等于当前数，将当前数对应的罗马数字拼进字符串中，然后将总数减去已经拼进去的部分
            if(num >= moneys[index]){
                stringBuilder.append(moneyToStr[index]);
                num -= moneys[index];
            }else{//如果小于当前数字，则将当前下标向后推一位，取下一个数字比较大小
                index++;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman2(3));
    }

}
