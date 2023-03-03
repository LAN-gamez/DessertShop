import java.math.BigDecimal;
public interface Taxable {
    BigDecimal taxRate = new BigDecimal(".0625");
    BigDecimal calculateTax();
}
