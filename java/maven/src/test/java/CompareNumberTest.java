

import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Scanner;

import static org.junit.Assert.assertThat;

/**
 * 作者：余秀良
 * 时间：2015年 02月 03日 上午8:55
 * 地点：成都
 * 描述：
 * 备注：
 */
public class CompareNumberTest {
    @Test
    public void test_0A0B() {
        String input = "1234";
        String sysNum = "5678";
        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.compaer(input, sysNum);
        assertThat(result).isEqualTo("0A0B");
    }
    @Test
    public void test_4A4B() {
        String input = "1234";
        String sysNum = "1234";
        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.compaer(input, sysNum);
        assertThat(result).isEqualTo("4A4B");
    }
    @Test
    public void test_0A4B() {
        String input = "1234";
        String sysNum = "4321";
        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.compaer(input, sysNum);
        assertThat(result).isEqualTo("0A4B");
    }
    @Test
    public void test_2A2B() {
        String input = "1234";
        String sysNum = "1243";
        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.compaer(input, sysNum);
        assertThat(result).isEqualTo("2A2B");
    }
    public static void main(String[] args) {
        int num=6;
        while (num>0){
            show(num);
            num--;
        }
    }

    public  static  void show(int num){
        System.out.println("Welcome");
        System.out.println();
        System.out.println("Please input your number("+num+")");
        CompareNumber com=new CompareNumber();
        String sys=AnswerGenerator.random(1, 9, 4);
        System.out.println(sys + "随机数");
        System.out.println("请输入数字，按Enter键结束！");
        Scanner s=new Scanner(System.in);
        String user=s.next();
        System.out.println("结果如下所示");
        System.out.println(com.return_str(sys,user));
        if (user.length()<4){
            System.out.println("数字非法，程序结束");
            System.exit(0);
        }
        if(sys.equals(user)){
            System.out.println("Congratulations");
            System.exit(0);
        }
        if (num<1){
            System.out.println("Game Over");
            System.exit(0);
        }
    }
}
