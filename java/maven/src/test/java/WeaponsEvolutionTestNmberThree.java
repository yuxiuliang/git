import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

/**
 * 作者：余秀良
 * 时间：2015年 02月 06日 下午5:15
 * 地点：成都
 * 描述：武器进化测试第三问（前两问的测试都写在了WeaponsEvolutionTest里面）
 * 备注：
 */
public class WeaponsEvolutionTestNmberThree {
    private PrintStream out;
    private InOrder inOrder;

    @Before
    public void out() {
        out = mock(PrintStream.class);
        inOrder = inOrder(out);
    }

    @Test
    public void have_weapons_soldier_attack_person() {
        Person soldier = new Soldier("张三", 100, 10, new Weapons("优质木棒", 10),null);
        Person person = new Person("李四", 100, 10);
        String obj = soldier.attack(person);
        assertThat(person.getBlood()).isEqualTo(80);
        assertThat(obj).isEqualTo("战士张三用优质木棒攻击了普通人李四，李四受到了20点伤害,剩余血量80");
    }

    @Test
    public void soldier_attack_solider() {

    }
}
