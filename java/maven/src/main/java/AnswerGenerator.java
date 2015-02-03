/**
 * 作者：余秀良
 * 时间：2015年 02月 03日 上午9:00
 * 地点：成都
 * 描述：
 * 备注：
 */
public class AnswerGenerator {
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
    public static  String random(int min, int max, int n){
        int[] reult1 =AnswerGenerator. randomCommon(min,max,n);
        StringBuilder sb = new StringBuilder();
        for (int i:reult1){
            sb.append(i);
        }
       return sb.toString();
    }
}
