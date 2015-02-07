/**
 * 作者：余秀良
 * 时间：2015年 02月 06日 下午5:06
 * 地点：成都
 * 描述：武器类
 * 备注：
 */
public class Weapons {
    private String name;//武器的名字
    private int attack;//攻击力

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Weapons(String name, int attack) {
        this.name = name;
        this.attack = attack;
    }
}
