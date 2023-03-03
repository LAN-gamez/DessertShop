import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Order implements Taxable {
    List<MenuItem> menuItems;

    public Order(){
        menuItems = new ArrayList<>();
    }

    public void add(MenuItem food){
        menuItems.add(food);
    }

    private  BigDecimal calculateTotal(){
        BigDecimal total = new BigDecimal(0);
        for (MenuItem food: menuItems){
            total = total.add(food.totalPrice());
        }
        return total;
    }
    public BigDecimal calculateTax() {
        return calculateTotal().multiply(taxRate);
    }

    public String total(){
        return calculateTotal().toString();
    }

    public String getTax() {
        return calculateTax().setScale(2, RoundingMode.HALF_EVEN).toString();
    }
    public String totalWithTax() {
        return calculateTotal().add(calculateTax()).setScale(2, RoundingMode.HALF_EVEN).toString();
    }

    public Map<String, List<MenuItem>> groupItemsByName() {
        return menuItems.stream().collect(Collectors.groupingBy(MenuItem::getName));
    }
}
