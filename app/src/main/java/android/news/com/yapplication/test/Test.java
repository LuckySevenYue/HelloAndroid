package android.news.com.yapplication.test;

/**
 * Created by yy10017 on 2016/8/22.
 * 这个类用来测试
 */

public class Test {

    public static void main(String []args){
        // TODO: 2016/8/22
        String str = "0  1 2 3 5";
        /**************fun1()**********************/
        String newStr = "";
        String arr[] = str.split(" ");
        for (int i = 0; i < arr.length; i++) {
            newStr += arr[i];
        }
        System.out.println("s1 = " + newStr);
        /**************fun2()**********************/
        String ss = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' '){
                continue;
            }
            ss += Character.toString(c);
        }
        System.out.println("s2 = " + ss);

        /**************fun3()**********************/
        System.out.println("s3 = " + str.replace(" ",""));
    }
}
