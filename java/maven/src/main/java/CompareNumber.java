import java.util.*;

/**
 * 作者：余秀良
 * 时间：2015年 02月 03日 上午8:59
 * 地点：成都
 * 描述：
 * 备注：
 */
public class CompareNumber {
    public  static  String return_str(String random,String userInput){
        int a=0,b=0;
       for(int i=0;i<userInput.length();i++){
           if (random.contains(userInput.charAt(i)+"")){
               b++;
           }
           if (random.charAt(i)==userInput.charAt(i)){
                a++;
               b--;
           }
        }
        String str=a+"A"+b+"B";
        return str;
    }

    public String compaer(String input, String sysNum) {
        int a_count=0,b_count=0;
        for (int i=0;i<input.length();i++){
            if (input.contains(sysNum.charAt(i)+" ")) {
                b_count++;
            }
            if (input.charAt(i)== sysNum.charAt(i)) {
                a_count++;
                b_count--;
            }
        }
        return a_count+"A"+b_count+"B";
    }
}
