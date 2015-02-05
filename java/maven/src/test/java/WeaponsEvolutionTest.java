import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * 作者：余秀良
 * 时间：2015年 02月 05日 上午10:55
 * 地点：成都
 * 描述：
 * 备注：
 */
public class WeaponsEvolutionTest {
    //@Test
    public void out_LiSi_Failure(){
        Person per=new Person("张三",100,8);
        Person per2=new Person("李四",100,10);
        WeaponsEvolution w=new WeaponsEvolution();
        w.attack(per);
        if (per.getBlood()>1){
            w.attack(per);
        }
        String result="1";
        assertThat(result).isEqualTo("李四被打败了");
    }
}
