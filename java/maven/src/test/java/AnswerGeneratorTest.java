import org.junit.Test;

import java.util.*;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * 作者：余秀良
 * 时间：2015年 02月 03日 上午9:12
 * 地点：成都
 * 描述：生成随机数测试类
 * 备注：
 */
public class AnswerGeneratorTest {
    //@Test
//    public void generation_One_Number() {
//        AnswerGenerator answer = new AnswerGenerator(new Random());
//        String num = answer.generationRandoms();
//        try {
//            Integer.parseInt(num);
//        } catch (Exception e) {
//            fail("不是数字", e);
//        }
//    }
//    @Test
//    public void generation_four_Number(){
//        AnswerGenerator answer = new AnswerGenerator(new Random());
//        String num=answer.generationRandoms();
//        assertThat(num.length()).isEqualTo(4);
//    }
//    @Test //黑盒测试 不知道是怎么执行的
//    public void generation_string_Number(){
//        AnswerGenerator answer = new AnswerGenerator(new Random());
//        String num=answer.generationRandoms();
//        for (int i = 0; i <num.length() ; i++) {
//            char ch = num.charAt(i);
//            assertThat(num.indexOf(ch)).isEqualTo(num.lastIndexOf(ch));
//        }
//    }
    @Test//白盒测试  知道实现
    public void generation_three_Number(){
        Random random=mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1, 2, 3, 4)
                .willReturn(1, 2, 3, 4)
                .willReturn(2, 3, 4, 5)
                .willReturn(3, 4, 5, 6);
        AnswerGenerator ans=new AnswerGenerator(random);
        HashSet<String> set=new LinkedHashSet<String>();
        set.add(ans.getgenerate());
        set.add(ans.getgenerate());
        set.add(ans.getgenerate());
        set.add(ans.getgenerate());
        assertThat(set.size()).isEqualTo(3);
    }
    @Test//白盒测试  知道实现的过程
    public void generation_Three_Number(){
        Random random=mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1, 2, 3, 4)
                .willReturn(3, 4, 5, 6)
                .willReturn(5, 6, 7, 8)
                .willReturn(1, 2, 3, 4);
        AnswerGenerator ans=new AnswerGenerator(random);
        HashSet<String> set=new LinkedHashSet<String>();
        set.add(ans.getgenerate());
        set.add(ans.getgenerate());
        set.add(ans.getgenerate());
        set.add(ans.getgenerate());
        assertThat(set.size()).isEqualTo(3);
    }
    @Test
    public void temp_test() {
        Random random = mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1, 2, 3, 4)
                .willReturn(5, 6, 7, 8)
                .willReturn(3, 4, 5, 6)
                .willReturn(2, 3, 4, 5);
        AnswerGenerator ans=new AnswerGenerator(random);
        HashSet<String> set=new LinkedHashSet<String>();
        set.add(ans.getgenerate());
        set.add(ans.getgenerate());
        set.add(ans.getgenerate());
        set.add(ans.getgenerate());
        assertThat(set.size()).isEqualTo(4);
    }


    /**
     * 测试生成3组4位不重复随机数
     */
    //@Test
    public void test1(){
        for (int i=0;i<3;i++){
            String str=AnswerGenerator.random(1,9,4);
            System.out.println(str);
        }
    }
  //  @Test
    public void generationOneNumber(){
        String randomNumber=AnswerGenerator.random(1, 9, 1);
        if (randomNumber.length()==1){
            assertThat(randomNumber).isEqualTo("生成的是一位随机数，错误");
        }
    }

   // @Test
    public void generationTwoNumber(){
        String randomNumber=AnswerGenerator.random(1, 9, 2);
        if (randomNumber.length()==2){
            assertThat(randomNumber).isEqualTo("生成的是两位随机数，错误");
        }
    }
    //@Test
    public void generationThreeNumber(){
        String randomNumber=AnswerGenerator.random(1, 9, 3);
        if (randomNumber.length()==3){
            assertThat(randomNumber).isEqualTo("生成的是三位随机数，错误");
        }
    }
    //@Test
    public void generationFourNumber(){
        String randomNumber=AnswerGenerator.random(1, 9, 4);
        if (randomNumber.length()==3){
            assertThat(randomNumber).isEqualTo("生成的是四位随机数,正确");
        }
    }
  //  @Test
    public void generationStringNumber() {
        boolean isNum = false;
        try {
            String str = "abcd";
            int num = Integer.valueOf(str);//把字符串强制转换为数字
            isNum = true;//是数字
        } catch (Exception e) {
            isNum = false;//是字符串，表示随机数错误
            fail("不是数字");
        }finally {
            assertThat(isNum).isEqualTo(false);
        }
    }
}
