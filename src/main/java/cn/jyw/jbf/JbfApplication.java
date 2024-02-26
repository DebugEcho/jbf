package cn.jyw.jbf;

import cn.jyw.jbf.calculator.Calculator;
import cn.jyw.jbf.entity.fruit.Apple;
import cn.jyw.jbf.entity.fruit.Fruit;
import cn.jyw.jbf.entity.fruit.Mango;
import cn.jyw.jbf.entity.fruit.Strawberry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class JbfApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JbfApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Random random = new Random();
        List<Fruit> fruitMap = new ArrayList<>();
        Apple apple = new Apple(random.nextInt(100), 8);
        fruitMap.add(apple);
        Strawberry strawberry = new Strawberry(random.nextInt(100), 13);
        fruitMap.add(strawberry);
        // 1 初始化
        Calculator basicCalculator = new Calculator.BasicCalculator();
        System.out.println("苹果数量:" + apple.getNumber() + "   草莓数量:" + strawberry.getNumber());
        double result = apple.getTotalPrice() + strawberry.getTotalPrice();
        System.out.println("1:基础计价： " + basicCalculator.calculateTotalPrice(fruitMap) + "   验证结果:" + result);
        // 2 增加芒果
        Fruit mango = new Mango(random.nextInt(100), 20);
        fruitMap.add(mango);
        result = apple.getTotalPrice() + strawberry.getTotalPrice() + mango.getTotalPrice();
        System.out.println("芒果数量:" + mango.getNumber());
        System.out.println("2:基础计价： " + basicCalculator.calculateTotalPrice(fruitMap) + "   验证结果:" + result);
        // 3 草莓8折扣
        Calculator discountedCalculator = new Calculator.DiscountedStrawberryCalculator();
        result = apple.getTotalPrice() + strawberry.getTotalPrice() * 0.8 + mango.getTotalPrice();
        System.out.println("3:打折后计价： " + discountedCalculator.calculateTotalPrice(fruitMap) + "   验证结果:" + result);
        // 3 每满100减10
        Calculator fullReductionCalculator = new Calculator.FullReductionCalculator();
        result = apple.getTotalPrice() + strawberry.getTotalPrice() + mango.getTotalPrice();
        if (result >= 100) {
            // 每满100减10
            result -= (int) (result / 100) * 10;
        }
        System.out.println("4:满减后计价： " + fullReductionCalculator.calculateTotalPrice(fruitMap) + "   验证结果:" + result);
    }
}
