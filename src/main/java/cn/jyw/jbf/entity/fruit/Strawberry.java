package cn.jyw.jbf.entity.fruit;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 草莓
 */

@AllArgsConstructor
public class Strawberry extends Fruit {
    public Strawberry(int number, double price) {
        super(number, price);
    }
}