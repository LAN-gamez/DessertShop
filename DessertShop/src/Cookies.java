import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cookies extends MenuItem implements Taxable {
    private final BigDecimal PRICE_PER_DOZEN = new BigDecimal("6.25");
    private BigDecimal dozen;

    public Cookies(String dozen) {
        super("Cookies");
        this.dozen = new BigDecimal(dozen);
    }

    public BigDecimal totalPrice() {
        return PRICE_PER_DOZEN.multiply(dozen);
    }
    public BigDecimal calculateTax(){
        return totalPrice().multiply(taxRate);
    }
    @Override
    public String toString(){
        return this.totalPrice().toString();
    }
}
