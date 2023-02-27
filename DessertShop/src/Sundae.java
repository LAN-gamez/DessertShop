import java.math.BigDecimal;
public class Sundae extends MenuItem {
    private final BigDecimal PRICEFUDGE = new BigDecimal("1.25");
    private final BigDecimal PRICESTRAWBERRY = new BigDecimal(".75");
    private final BigDecimal PRICECARAMEL = new BigDecimal(".50");
    private final BigDecimal PRICEPEANUT = new BigDecimal(".35");
    private final BigDecimal PRICECOCONUT = new BigDecimal(".2");
    private boolean hotFudge;
    private boolean strawberrySyrup;
    private boolean caramelSyrup;
    private boolean peanut;
    private boolean coconut;

    public void addHotFudge() {
        this.hotFudge = true;
    }

    public void addStrawberry() {
        this.strawberrySyrup = true;
    }

    public void addCaramel() {
        this.caramelSyrup = true;
    }

    public void addPeanut() {
        this.peanut = true;
    }

    public void addCoconut() {
        this.coconut = true;
    }

    private final IceCream iceCream;
    public Sundae(){
        super("Sundae");
        this.iceCream = new IceCream(new BigDecimal(2).toString());
    }
    public BigDecimal totalPrice(){
        BigDecimal cost = iceCream.totalPrice() ;
        if (hotFudge){
            cost = cost.add(PRICEFUDGE);
        } if (strawberrySyrup) {
            cost = cost.add(PRICESTRAWBERRY);
        } if (caramelSyrup) {
            cost = cost.add(PRICECARAMEL);
        } if (peanut) {
            cost = cost.add(PRICEPEANUT);
        } if (coconut) {
            cost = cost.add(PRICECOCONUT);
        }
        return cost;
    }
}
