import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import java.io.PrintStream;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * 作者：余秀良
 * 时间：2015年 02月 05日 上午10:55
 * 地点：成都
 * 描述：武器进化第一问和第二问的测试
 * 备注：
 */
public class WeaponsEvolutionTest {
    private PrintStream out;
    private Person zhangSan;
    private Person liSi;
    private InOrder inOrder;
    @Before
    public void out() {
        zhangSan = mock(Person.class);
        liSi = mock(Person.class);
        out = mock(PrintStream.class);
        inOrder = inOrder(out);
    }

    /**
     * 测试被攻击者血量是否减少
     */
    @Test
    public void out_LiSi_Failure() {
        Person zhangSan = new Person("张三", 10, 4);
        Person liSi = new Person("李四", 10, 4);
        String str = zhangSan.attack(liSi);
        assertThat(liSi.getBlood()).isEqualTo(6);
        //verify(out).println("李四被打败了");
        assertThat(str).isEqualTo("张三攻击了李四,张三受到4点伤害,剩余血量6");
    }

    @Test
    public void should_fist_fight_person_die() {
        Person zhangSan = new Person("张三", 100, 8);
        Person liSi = new Person("李四", 100, 5);
        new FightUtils(out).fightEachOther(zhangSan, liSi);
        verify(out).println("李四被打败了");
    }

    @Test
    public void should_be_alive_when_blood_is_more_than_0() {
        Person liSi = new Person("李四", 100, 5);
        assertThat(liSi.isAlive()).isEqualTo(true);
    }

    @Test
    public void should_be_die_when_blood_is_equal_0() {
        Person liSi = new Person("李四", 0, 5);
        assertThat(liSi.isAlive()).isEqualTo(false);
    }

    @Test
    public void should_be_die_when_blood_is_less_than_0() {
        Person liSi = new Person("李四", -1, 5);
        assertThat(liSi.isAlive()).isEqualTo(false);
    }

    @Test
    public void zhangSanAttackLiSi() {
        Person zhangSan = new Person("张三", 10, 8);
        Person liSi = new Person("李四", 20, 9);
        zhangSan.attack(liSi);
        assertThat(liSi.getBlood()).isEqualTo(12);
    }

    @Test
    public void should_fisrt_fight_person_die() {
        given(zhangSan.getName()).willReturn("张三");
        given(liSi.getName()).willReturn("李四");
        given(zhangSan.attack(liSi)).willReturn("张三攻击了");
        given(liSi.attack(zhangSan)).willReturn("李四攻击了");
        given(zhangSan.isAlive()).willReturn(true,false);
        given(liSi.isAlive()).willReturn(true,true);
        new FightUtils(out).fightEachOther(zhangSan, liSi);
        inOrder.verify(out).println("张三攻击了");
        inOrder.verify(out).println("李四攻击了");
        inOrder.verify(out).println("张三被打败了");
    }

    @Test
    public void should_second_fight_person_die() {
        given(zhangSan.getName()).willReturn("张三");
        given(liSi.getName()).willReturn("李四");
        given(zhangSan.attack(liSi)).willReturn("张三攻击了");
        given(liSi.attack(zhangSan)).willReturn("李四攻击了");
        given(zhangSan.isAlive()).willReturn(true,true,true);
        given(liSi.isAlive()).willReturn(true,true,false);
        new FightUtils(out).fightEachOther(zhangSan, liSi);
        inOrder.verify(out).println("张三攻击了");
        inOrder.verify(out).println("李四攻击了");
        inOrder.verify(out).println("张三攻击了");
        inOrder.verify(out).println("李四攻击了");
        inOrder.verify(out).println("张三攻击了");
        inOrder.verify(out).println("李四被打败了");
    }
}
