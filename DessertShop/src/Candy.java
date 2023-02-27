import java.math.BigDecimal;


public class Candy extends MenuItem {
    private final BigDecimal PRICE_PER_POUND = new BigDecimal("4.75");
    private final BigDecimal weight;

    public Candy(String weight) {
        super("Candy");
        this.weight = new BigDecimal(weight);
    }

    public BigDecimal totalPrice() {
        return PRICE_PER_POUND.multiply(weight);
    }
}
