import org.junit.Test;

import java.util.*;

/**
 * 作者：余秀良
 * 时间：2015年 02月 03日 上午9:12
 * 地点：成都
 * 描述：
 * 备注：
 */
public class AnswerGeneratorTest {
    @Test
    public void test1(){
        for (int i=0;i<3;i++){
            String str=AnswerGenerator.random(1,9,4);
            System.out.println(str);
        }
    }
}
