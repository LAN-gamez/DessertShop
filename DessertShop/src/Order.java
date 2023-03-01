import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Map<String, List<MenuItem>> groupItemsByName() {
        return menuItems.stream()
                .collect(Collectors.groupingBy(MenuItem::getName));
    }
}
