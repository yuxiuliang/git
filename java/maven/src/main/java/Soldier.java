/**
 * 作者：余秀良
 * 时间：2015年 02月 06日 下午5:18
 * 地点：成都
 * 描述：战士
 * 备注：
 */
public class Soldier extends Person {
    private Weapons weapons;
    private Defense defense;
    public static final String ROLE = "战士";

    public static String getRole() {
        return ROLE;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }

    public Defense getDefense() {
        return defense;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }

    public Soldier(String name, int blood, int attack, Weapons weapons, Defense defense) {
        super(name, blood, attack);
        this.weapons = weapons;
        this.defense = defense;
    }

    private int damage() {
        return this.getAttack() + this.weapons.getAttack();
    }

    @Override
    public String attack(Person person) {
        person.setBlood(person.getBlood() - this.getAttack() - this.weapons.getAttack());
        return this.getAttackName(person);
    }

    @Override
    protected String getAttackName(Person person) {
        return this.ROLE + this.getName() + "用" + this.weapons.getName() + "攻击了" + person.ROLE + person.getName() + "，" + person.getName() + "受到了" + person.getDamage(this.damage()) + "点伤害,剩余血量" + person.getBlood();
    }
}
