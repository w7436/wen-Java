package factory;

import food.*;

/**
 * @ClassName foodFactory1
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/2 10:23
 * @Version 1.0
 **/

public class foodFactory1 implements foodFactory{


    public Hamburgers createHamburgers(int kind, int num) {
        //香辣鸡腿堡
        if(1==kind)
            return new Hamburgers_1(num);
        //烤鸡腿堡
        else if(2==kind)
            return new Hamburgers_2(num);
        else
            return null;
    }

    public FrenchFries createFrenchFries(int kind, int num) {
        if(1==kind)
            return new FrenchFries_1(num);
        else
            return null;
    }

    public Chicken createChickens(int kind, int num) {
        //吮指原味鸡
        if(1==kind)
            return new Chicken_1(num);
        //香辣鸡翅
        else if(2==kind)
            return new Chicken_2(num);
        else
            return null;

    }

    public Drinkings createDrinkings(int kind, int num) {
        //可乐
        if(1==kind)
            return new Drinkings_1(num);
        //九珍果汁饮料
        else if(2==kind)
            return new Drinkings_2(num);
        else
            return null;

    }

    public Rices createRices(int kind, int num) {
        //海苔盐烧大鸡腿饭
        if(1==kind)
            return new Rices_1(num);
            //川辣泡椒鸡块饭
        else if(2==kind)
            return new Rices_2(num);
        else
            return null;

    }
}
