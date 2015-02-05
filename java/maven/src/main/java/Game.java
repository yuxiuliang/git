import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 作者：余秀良
 * 时间：2015年 02月 04日 上午10:08
 * 地点：成都
 * 描述：游戏类
 * 备注：
 */
public class Game {

    public  static  void gamePlay(int num){
        if (num == 6) {
            System.out.println("Welcome");
            System.out.println();
            System.out.println("Please input your number("+num+")");
        }else {
            System.out.println();
            System.out.println("Please input your number("+num+")");
        }
        CompareNumber com=new CompareNumber();
        String sys=AnswerGenerator.random(0, 9, 4);
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

    /**
     * 游戏开始方法
     */
    public  static void play(){
        int num=6;
        while (num>0){
            Game.gamePlay(num);
            num--;
        }
    }

    private PrintStream out;
    private final BufferedReader reader;
    private final AnswerGenerator answerGenerator;
    private final CompareNumber compareNumber;

    public Game(PrintStream out,BufferedReader reader,AnswerGenerator answerGenerator,CompareNumber compareNumber) {
        this.out = out;
        this.reader = reader;
        this.answerGenerator = answerGenerator;
        this.compareNumber = compareNumber;
    }
    public void start() throws IOException {
        int num=6;
        out.println("welcome");
        while (num>0){
            out.println("Please input your number("+num+")");
            String input = answerGenerator.getgenerate();
            String answer = reader.readLine();
            String result = compareNumber.compaer(input, answer);
           if ("4A0B".equals(result)) {
                out.println("congratulation");
               return;
            }
            out.println(result);
            num--;
        }
        out.print("over");
    }
}
