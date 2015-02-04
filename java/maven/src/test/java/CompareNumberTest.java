

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
}
