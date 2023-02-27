import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class SundaeTest {
    Sundae mostSundae;
    Sundae leastSundae;
    Sundae coconutSundae;
    Sundae chocoPeanutSundae;

    @BeforeEach
    void setUp() {
        mostSundae = new Sundae();
        leastSundae = new Sundae();
        coconutSundae = new Sundae();
        chocoPeanutSundae = new Sundae();
    }

    @Test
    void totalPrice() {
        mostSundae.addHotFudge();
        mostSundae.addCoconut();
        mostSundae.addPeanut();
        mostSundae.addStrawberry();
        mostSundae.addCaramel();

        coconutSundae.addCoconut();

        chocoPeanutSundae.addHotFudge();
        chocoPeanutSundae.addPeanut();

        assertEquals(new BigDecimal(6.45).setScale(2, RoundingMode.HALF_EVEN), mostSundae.totalPrice());
        assertEquals(new BigDecimal(3.40).setScale(2, RoundingMode.HALF_EVEN), leastSundae.totalPrice());
        assertEquals(new BigDecimal(3.60).setScale(2, RoundingMode.HALF_EVEN), coconutSundae.totalPrice());
        assertEquals(new BigDecimal(5.00).setScale(2, RoundingMode.HALF_EVEN), chocoPeanutSundae.totalPrice());
    }
}