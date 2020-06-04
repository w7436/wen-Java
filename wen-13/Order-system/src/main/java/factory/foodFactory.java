package factory;

import food.*;

/**
 * @ClassName foodFactory
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/2 10:22
 * @Version 1.0
 **/
public interface foodFactory {
    public Hamburgers createHamburgers(int kind, int num);  //根据不同的kind参数确定不同的汉堡种类，生产汉堡
    public FrenchFries createFrenchFries(int kind, int num);  //生产薯条
    public Chicken createChickens(int kind, int num);  //生产鸡
    public Drinkings createDrinkings(int kind, int num);  //生产饮料
    public Rices createRices(int kind, int num);  //生产米饭
}
