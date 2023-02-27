import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class MenuItem {
    private final String name;


    public MenuItem(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    //abstract public BigDecimal totalPrice();

    public abstract BigDecimal totalPrice();
}
