package ynu.edu.fly.algorithm;

/**
 * 实现当double 类型完全存储不了的时候，数据如何相加、减、乘、除
 *
 * Created by fly on 16-8-23.
 */
public class BigDataOperation {

    /**
     * 实现两个数的乘法
     * @param numA
     *          大数字 A
     * @param numB
     *          大数字 B
     * @return
     *          两数相乘的结果
     */

    public static String mutiple(String numA, String numB){

        String A = numA;
        String B = numB;

        //step1 判断符号
        char sign = '+';

        if(A.charAt(0) == '+' || A.charAt(0) == '-'){ // 第一位是否为符号位
            sign = A.charAt(0);
            A = A.substring(1); //去掉第一位符号位
        }

        if(B.charAt(0) == '+' || B.charAt(0) == '-'){

            //同号得正，异号得负
            if(sign == B.charAt(0)){
                sign = '+';
            } else {
                sign = '-';
            }
        }

        //setp 2 字符串逆序
        char []a = new StringBuffer(A).reverse().toString().toCharArray();
        char []b = new StringBuffer(B).reverse().toString().toCharArray();

        int len = a.length + b.length; //两个数相乘的位数不大于两数长度之和
        int []result = new int[len]; //存储每一位上的数据

        //step 3 开始计算
        for(int i=0; i<a.length; i++){
            for(int j=0; j<b.length; j++){
                result[i+j] += (int)(a[i]-'0')*(int)(b[j]-'0');
            }
        }

        // step 4 进位处理，满10进1,同时取余留下
        // 同时因为相邻的位置都相差10倍
        for(int i=0; i<result.length; i++){
            if(result[i] >= 10){ //满十进一
                result[i+1] += result[i] / 10;
                result[i] %= 10;

            }
        } //end for 至此处理结束乘法

        //将结果转为字符串输出
        StringBuffer res = new StringBuffer();
        boolean flag = true;

        for(int i=result.length-1; i>=0; i--){
            if(result[i]==0&& flag){
                continue;
            } else {
                flag = false;
            }

            res.append(result[i]);
        }

        if(!res.toString().equals("")){ //结果不为空
            if(sign == '-'){
                res.insert(0,sign);
            }
        } else {
            res.append(0);
        }

        return res.toString();
    }


    /**
     * 实现两个大数字的相加
     * @param numA
     *          大数字 A
     * @param numB
     *          大数字 B
     * @return
     *          字符串类型的结果
     */

    public static String add(String numA, String numB){

        // 默认规定两个都为正号
        char []a = new StringBuffer(numA).reverse().toString().toCharArray();
        char []b = new StringBuffer(numB).reverse().toString().toCharArray();

        int len = a.length > b.length ? a.length + 1 : b.length + 1;
        int []result = new int[len];

        // 实现两个数字的相加
        // 需要注意的是加法为 同位相加
        for(int i=0; i<len; i++){
            result[i] = (i<a.length ? (int)(a[i] - '0') : 0)
                    + (i<b.length ? (int)(b[i] - '0') : 0);
        }

        // 处理结果集

        for(int i=0; i<len; i++){
            if(result[i]>=10){
                result[i+1] += result[i] / 10;
                result[i] %= 10;
            }
        }

        // 将结果转为字符串输出
        StringBuffer res = new StringBuffer();
        boolean flag = true;

        for(int i=len-1; i>=0; i--){
            if(result[i] == 0 && flag){
                continue;
            } else {
                flag = false;
            }

            res.append(result[i]);
        }


        if(res.toString().equals("")){ //结果不为空
            res.append(0);
        }

        return res.toString();
    }


    /**
     * 实现两个大数字的加法
     * @param numA
     *          大数字 A
     * @param numB
     *          大数字 B
     * @return
     *          返回相减后的字符串结果
     */
    public static String substract(String numA, String numB){

        char []a = new StringBuffer(numA).reverse().toString().toCharArray();
        char []b = new StringBuffer(numB).reverse().toString().toCharArray();

        int len = a.length > b.length ? a.length : b.length;
        int []result = new int[len];

        //两个数字相减的时候，也许大减小 也许小减大 所以这里需要保留正负号的问题
        char sign = '+';

        if(a.length < b.length){
            sign = '-';
        } else if(a.length == b.length){
            //当两个长度相等的时候，也需要比较谁大谁小
            int i = a.length -1;
            while(i>0 && a[i]==b[i]){
                i--;
            }

            if(a[i] < b[i]){
                sign = '-';
            }
        }

        //开始相减
        for (int i=0; i<len; i++){
            int intA = i < a.length ? a[i]-'0' : 0;
            int intB = i < b.length ? b[i]-'0' : 0;

            if (sign == '+'){
                result[i] = intA - intB;
            } else {
                result[i] = intB - intA;
            }
        }

        //考虑 每一位上的数字 是否有负数 有负数则需要借位减法
        for(int i=0; i<result.length-1; i++){
            if(result[i]<0){
                result[i+1] -= 1;
                result[i] += 10;
            }
        }

        //转为字符串输出
        StringBuffer res = new StringBuffer();
        boolean flag = true;

        //考虑高位为0的结果
        for(int i=result.length-1; i>=0; i--){
            if(result[i] == 0 && flag){
                continue;
            } else {
                flag = false;
            }
            res.append(result[i]);
        }

        //考虑符号位
        if(sign == '-'){
            res.insert(0,sign);
        }

        if(res.toString().equals("")){
            res.append(0);
        }


        return res.toString();
    }


    public static String divide(String numA, String numB){

        //除法再续，相对有点难。
        //除法主要是通过乘法和减法来实现
        // 参考资料
        // http://www.cnblogs.com/javawebsoa/archive/2013/08/01/3231078.html
        // http://blog.csdn.net/sunkun2013/article/details/11833515
        // http://blog.csdn.net/lichong_87/article/details/6860329

        return "";
    }


    public static void main(String[] args){
        String numA = "980";
        String numB = "765";

        //String res = mutiple(numA,numB);
        //String res = add(numA,numB);
        String res = substract(numA,numB);


        System.out.println(res);
    }
}
