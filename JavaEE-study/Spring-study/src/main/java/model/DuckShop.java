package model;

import java.util.List;

/**
 * @ClassName DuckShop
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/7 11:35
 * @Version 1.0
 **/
public class DuckShop {
    private List<Duck> ducks;

    @Override
    public String toString() {
        return "DuckShop{" +
                "ducks=" + ducks +
                '}';
    }

    public List<Duck> getDucks() {
        return ducks;
    }

    public void setDucks(List<Duck> ducks) {
        this.ducks = ducks;
    }
}
