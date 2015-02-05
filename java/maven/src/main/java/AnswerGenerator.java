import java.util.ArrayList;
import java.util.Random;

/**
 * 作者：余秀良
 * 时间：2015年 02月 03日 上午9:00
 * 地点：成都
 * 描述：生成随机数
 * 备注：
 */
public class AnswerGenerator {
    private  Random random;
    private final  ArrayList<String> historyGenerateNumber;
    public AnswerGenerator(Random random){
        this.historyGenerateNumber=new ArrayList<String>();
        this.random=random;
    }
    /**
     * 随机指定范围内N个不重复的数
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n 随机数个数
     */
    public static int[] randomCommon(int min, int max, int n){
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while(count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(num == result[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count] = num;
                count++;
            }
        }
        return result;
    }

    /**
     * 获取随机数
     * @param min 最小值
     * @param max 最大值
     * @param n 随机数个数
     * @return 随机数
     */
    public static  String random(int min, int max, int n){
        int[] reult1 =AnswerGenerator. randomCommon(min,max,n);
        StringBuilder sb = new StringBuilder();
        for (int i:reult1){
            sb.append(i);
        }
       return sb.toString();
    }
    /**
     * 测试三次不能出现重复随机数
     * @return
     */
    public  String  getgenerate() {
        String num= generationRandoms();
        while (historyGenerateNumber.contains(num)){
            num=generationRandoms();
        }
        if (historyGenerateNumber.size() == 2) {
            historyGenerateNumber.remove(0);
        }
        historyGenerateNumber.add(num);
        return num;
    }

    private String generationRandoms() {
        StringBuilder builder=new StringBuilder();
        while (builder.length()<4){
            String num=String.valueOf(random.nextInt(10));
            if (builder.indexOf(String.valueOf(num))==-1) {
                builder.append(num);
            }
        }
        return builder.toString();
    }
}
