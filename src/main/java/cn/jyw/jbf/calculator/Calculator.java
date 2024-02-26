package cn.jyw.jbf.calculator;

import cn.jyw.jbf.entity.fruit.Fruit;
import cn.jyw.jbf.entity.fruit.Strawberry;

import java.util.List;
import java.util.Map;

/**
 * 计价器接口
 */
public interface Calculator {
    /**
     * 计算总价
     *
     * @param fruits 水果
     * @return 总价
     */
    double calculateTotalPrice(List<Fruit> fruits);


    /**
     * 基础计价策略类
     */
    class BasicCalculator implements Calculator {
        @Override
        public double calculateTotalPrice(List<Fruit> fruits) {
            double totalPrice = 0;
            for (Fruit fruit : fruits) {
                totalPrice += fruit.getTotalPrice();
            }
            return totalPrice;
        }
    }

    /**
     * 打折计价策略类
     */
    class DiscountedStrawberryCalculator implements Calculator {
        @Override
        public double calculateTotalPrice(List<Fruit> fruits) {
            double totalPrice = 0;
            for (Fruit fruit : fruits) {
                if (fruit instanceof Strawberry) {
                    totalPrice += fruit.getTotalPrice() * 0.8;
                } else {
                    totalPrice += fruit.getTotalPrice();
                }

            }
            return totalPrice;
        }
    }

    /**
     * 满减计价策略类
     */
    class FullReductionCalculator implements Calculator {
        @Override
        public double calculateTotalPrice(List<Fruit> fruitList) {
            double totalPrice = new BasicCalculator().calculateTotalPrice(fruitList);
            if (totalPrice >= 100) {
                // 每满100减10
                totalPrice -= (int) (totalPrice / 100) * 10;
            }
            return totalPrice;
        }
    }
}