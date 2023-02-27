import java.math.BigDecimal;
import java.math.RoundingMode;

public class IceCream extends MenuItem {
    private final BigDecimal PRICEPERSCOOP = new BigDecimal("1.7");
    private final BigDecimal numScoop;
    public IceCream(String numScoop){
        super("IceCream");
        this.numScoop = new BigDecimal(numScoop);
    }
    public BigDecimal totalPrice(){
        return PRICEPERSCOOP.multiply(numScoop);
    }
}
