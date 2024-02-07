package com.epicode.U5D2;

import com.epicode.U5D2.entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


public class RestaurantTest {
    final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RestaurantTest.class);

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Prendo un bean");



    }

    @Test
    public void TestTableNumber(){
        Table t1 = (Table) ctx.getBean("Tavolo1");
        Order o1 = new Order(1,4, t1);
        o1.addItem(ctx.getBean("pizza_margherita", Pizza.class));
        o1.addItem(ctx.getBean("hawaiian_pizza", Pizza.class));
        o1.addItem(ctx.getBean("salami_pizza_xl", Pizza.class));
        o1.addItem(ctx.getBean("lemonade", Drink.class));
        o1.addItem(ctx.getBean("lemonade", Drink.class));
        o1.addItem(ctx.getBean("wine", Drink.class));
        t1.setFree(false);
        System.out.println("DETTAGLI TAVOLO 1:");
        o1.print();

        System.out.println("CONTO TAVOLO 1");
        System.out.println(o1.getTotal());

        assertEquals(t1, o1.getTable());
    }
}
