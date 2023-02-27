import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.accessibility.AccessibleStateSet;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Order order;
    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @Test
    void totalEverything() {
        order.add(new Cookies("1"));
        order.add(new Candy("1"));
        Sundae mySundae= new Sundae();
        mySundae.addHotFudge();
        mySundae.addCoconut();
        mySundae.addPeanut();
        mySundae.addCaramel();
        mySundae.addStrawberry();
        order.add(mySundae);
        order.add(new IceCream("1"));
        assertEquals(new BigDecimal(19.15).setScale(2, RoundingMode.HALF_EVEN), new BigDecimal(order.total()));
    }
    @Test
    void totalSundaeOnly(){
        Sundae sundaeYum = new Sundae();
        sundaeYum.addStrawberry();
        sundaeYum.addCoconut();
        order.add(sundaeYum);
        assertEquals(new BigDecimal(4.35).setScale(2, RoundingMode.HALF_EVEN), new BigDecimal(order.total()));

    }
    @Test
    void totalNothing(){
        //assertEquals(new BigDecimal(0.00).setScale(2, RoundingMode.HALF_EVEN), new BigDecimal(order.total()));
    }
    @Test
    void totalIceCreamAndCandy(){
        order.add(new IceCream("1"));
        order.add(new Candy("1"));
        assertEquals(new BigDecimal(6.45).setScale(2, RoundingMode.HALF_EVEN), new BigDecimal(order.total()));
    }
}