package nancy;

/**
 * @ClassName Hero
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/7 21:27
 * @Version 1.0
 **/

class Hero {
        String name;
        String skill_q;
        String skill_w;
        String skill_e;
        String skill_r;

        public Hero(String name) {
            this.name = name;
        }

        public Hero(String name, String skill_q, String skill_w, String skill_e, String skill_r) {
            this(name); //调用当前类中的其他的构造方法
            this.skill_q = skill_q;
            this.skill_w = skill_w;
            this.skill_e = skill_e;
            this.skill_r = skill_r;
        }

        public void fight() {
            System.out.println(this.name + "在上阵杀敌");
        }


}
class ZhiWu {
    String name;
    int hp;
    int attack;
    public ZhiWu(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }
    //植物打僵尸
    public void fight(JiangShi js) {
        System.out.println(this.name + "在打" + js.name);
        //僵尸掉血
        js.hp -= this.attack;
        System.out.println("僵尸的血量剩余：" + js.hp);
    }
}
// 僵尸类
class JiangShi {
    String name;
    int hp;
    int attack;
    public JiangShi(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }
    public void eat(ZhiWu zw) {
        System.out.println(this.name + "正在吃" + zw.name + "植物");
        zw.hp -= this.attack;
        System.out.println("植物还有血量：" + zw.hp);
    }
}

public class Mian{
    public static void main(String[] args) {
        // 创建植物和僵尸
        ZhiWu zw = new ZhiWu("豌豆", 1000, 5);
        JiangShi js = new JiangShi("铁桶僵尸",800, 20);
        Hero hero = new Hero("盖伦","小宝剑","防御","电风扇","大宝剑");


        zw.fight(js);
        js.eat(zw);
        hero.fight();
    }
}
