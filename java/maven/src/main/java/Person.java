/**
 * 作者：余秀良
 * 时间：2015年 02月 05日 下午1:55
 * 地点：成都
 * 描述：
 * 备注：
 */
public class Person {
    private int blood;//血量
    private String name;//人的名字
    private int attack;//攻击力

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name, int blood, int attack) {
        this.name = name;
        this.blood = blood;
        this.attack = attack;
    }
}
