import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Order {
    List<MenuItem> menuItems;

    public Order(){
        menuItems = new ArrayList<>();
    }

    public void add(MenuItem food){
        menuItems.add(food);
    }

    public String total(){
        BigDecimal total = new BigDecimal(0);
        for (MenuItem food: menuItems){
            total = total.add(food.totalPrice());
        }
        return total.toString();
    }
}
