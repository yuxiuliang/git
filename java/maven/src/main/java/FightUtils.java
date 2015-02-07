import java.io.PrintStream;

/**
 * 作者：余秀良
 * 时间：2015年 02月 05日 下午5:59
 * 地点：成都
 * 描述：
 * 备注：
 */
public class FightUtils {
    private PrintStream out;
    public  FightUtils(PrintStream out) {
        this.out = out;
    }
    public void fightEachOther(Person zhangSan,Person liSi) {
        while (true){
            if (!zhangSan.isAlive()) {
                out.println(zhangSan.getName()+"被打败了");
                break;
            }
            out.println(zhangSan.attack(liSi));
            if (!liSi.isAlive()) {
                out.println(liSi.getName()+"被打败了");
                break;
            }
            out.println(liSi.attack(zhangSan));
        }
    }
}
