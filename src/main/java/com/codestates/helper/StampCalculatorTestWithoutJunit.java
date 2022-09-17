package com.codestates.helper;

import com.codestates.order.entity.Order;
import com.codestates.order.entity.OrderCoffee;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public class StampCalculatorTestWithoutJunit {
    public static void main(String[] args) {
        calculatorStampCountTest();
        calculateEarnedStampCountByOrder();
    }

    public static void calculatorStampCountTest() {
        //given
        int nowCtn = 3;
        int earnedCtn = 4;

        //when
        int result = StampCalculator.calculateStampCount(3,4);


        //then
        int expected = 7;

        System.out.println("결과 : " + (result == expected));
    }

    public static void calculateEarnedStampCountByOrder() {

        //given
        Order order = new Order();
        OrderCoffee orderCoffee1= new OrderCoffee();
        orderCoffee1.setQuantity(2);
        OrderCoffee orderCoffee2= new OrderCoffee();
        orderCoffee2.setQuantity(11);
        order.setOrderCoffees(List.of(orderCoffee1, orderCoffee2));

        //when
        int result = StampCalculator.calculateEarnedStampCountByOrder(order);

        //then
        int expected = 13;

        System.out.println(result == expected);
    }
}


class StampCalculator{
    public static int calculateStampCount(int nowCtn, int earnedCtn) {
        return  nowCtn + earnedCtn;
    }

    public static int calculateEarnedStampCountByOrder(Order order) {

        return order.getOrderCoffees().stream().map(orderCoffee -> orderCoffee.getQuantity()).mapToInt(i->i).sum();
    }
}
