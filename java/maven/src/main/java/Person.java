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
    public static final String ROLE="普通人";

    public static String getRole() {
        return ROLE;
    }
    public void setName(String name) {
        this.name = name;
    }

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

    public String getName() {
        return name;
    }

    public Person(String name, int blood, int attack) {
        this.name = name;
        this.blood = blood;
        this.attack = attack;
    }
    public String attack(Person person) {
        person.setBlood(person.getBlood() - this.getAttack());
        return this.getAttackName(person);
    }
    protected String getAttackName(Person person) {
        return this.getName() + "攻击了" + person.getName() + "," + person.getName() + "受到了" + person.getAttack() + "点伤害,剩余血量" + person.getBlood();
    }
    public boolean isAlive() {
        return this.blood > 0;
    }
    public String defense() {
        return null;
    }
    public int getDamage(int attack){
        return attack;
    }
}
