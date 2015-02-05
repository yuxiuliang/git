/**
 * 作者：余秀良
 * 时间：2015年 02月 05日 上午9:50
 * 地点：成都
 * 描述：武器进化
 * 备注：
 */
public class WeaponsEvolution {
    /**
     * 游戏攻击方法
     */
    public  void attack(Person person){
        int blood=person.getBlood();
        while (blood>1){
            blood=person.getBlood()-person.getAttack();
        }
    }
}
