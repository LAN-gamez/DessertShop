import java.math.BigDecimal;


public class Candy extends MenuItem implements Taxable {
    private final BigDecimal PRICE_PER_POUND = new BigDecimal("4.75");
    private final BigDecimal weight;

    public Candy(String weight) {
        super("Candy");
        this.weight = new BigDecimal(weight);
    }

    public BigDecimal totalPrice() {
        return PRICE_PER_POUND.multiply(weight);
    }

    public BigDecimal calculateTax(){
        return totalPrice().multiply(taxRate);
    }
    @Override
    public String toString(){
        return this.totalPrice().toString();
    }
}
