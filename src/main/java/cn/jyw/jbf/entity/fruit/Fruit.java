package cn.jyw.jbf.entity.fruit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 定义水果父类
 *
 * @author MineCraft
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fruit {
    /**
     * 数量
     */
    int number = 0;
    /**
     * 获取每斤的价格
     */
    double price = 0;

    /**
     * 获得总价
     *
     * @return 总价
     */
    public double getTotalPrice() {
        return number * price;
    }
}
