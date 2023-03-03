import java.util.Map;
import java.util.Scanner;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        String option = "0";
        while (!option.equals("2")){
            System.out.println("Welcome to the dessert shop ordering thing");
            System.out.println("Enter 1 to create a new order or 2 to exit");
            option = scanner.nextLine().trim();
            if (option.equals("1")){
                m.doOrder(scanner);
            } else if (option.equals("2")){
                System.out.println("Later gator");
            } else {
                System.out.println("Invalid");
            }
        }

    }
    public static boolean isDouble(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean isInt(String strNum) {
        if (strNum == null) {
            return false;
        } try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    private void doOrder(Scanner scanner){
        Order order = new Order();
        String option = "0";
        while (!option.equals("5")){
            System.out.println("Enter the menu item");
            System.out.println("1 - Candy");
            System.out.println("2 - Cookies");
            System.out.println("3 - Ice Cream");
            System.out.println("4 - Sundae");
            System.out.println("5 - Finish and print total");
            option = scanner.nextLine().trim();
            switch (option){
                case "1" -> addCandy(order, scanner);
                case "2" -> addCookies(order, scanner);
                case "3" -> addIceCream(order, scanner);
                case "4" -> addSundae(order, scanner);
                case "5" -> printReceipt(order);
                default -> System.out.println("Invalid selection, try again");
            }
        }
    }
    private void addCandy(Order order, Scanner scanner){
        System.out.println("How much candy in lbs?");
        String weight = scanner.nextLine().trim();
        if (isDouble(weight)){
            Candy candy = new Candy(weight);
            order.add(candy);
        }else {
            System.out.println("Invalid");
        }
    }
    private void addCookies(Order order, Scanner scanner){
        System.out.println("How many dozens of cookies?");
        String dozens = scanner.nextLine().trim();
        if (isDouble(dozens)){
            Cookies cookies = new Cookies(dozens);
            order.add(cookies);
        }else {
            System.out.println("Invalid");
        }
    }
    private void addIceCream(Order order, Scanner scanner){
        System.out.println("How many scoops of ice cream?");
        String scoops = scanner.nextLine().trim();
        if (isDouble(scoops)){
            IceCream iceCream = new IceCream(scoops);
            order.add(iceCream);
        }else {
            System.out.println("Invalid");
        }
    }
    private void addSundae(Order order, Scanner scanner){
        Sundae sundae = new Sundae();
        String option = "0";
        while (!option.equals("6")){
            System.out.println("Sundae Option ");
            System.out.println("1 - Hot Fudge");
            System.out.println("2 - Caramel Syrup");
            System.out.println("3 - Strawberry Syrup");
            System.out.println("4 - Coconut");
            System.out.println("5 - Peanuts");
            System.out.println("6 - Complete Sundae");
            option = scanner.nextLine();
            switch (option){
                case "1" -> sundae.addHotFudge();
                case "2" -> sundae.addCaramel();
                case "3" -> sundae.addStrawberry();
                case "4" -> sundae.addCoconut();
                case "5" -> sundae.addPeanut();
                case "6" -> order.add(sundae);
                default -> System.out.println("Invalid");
            }
        }
    }
    private void printReceipt(Order order) {
        String total = order.total();
        Map<String, List<MenuItem>> categories = order.groupItemsByName();
        System.out.println("---------------");
        System.out.println("Purchased Items");
        for (String category : categories.keySet()) {
            System.out.println(category);
            List<MenuItem> items = categories.get(category);
            for (MenuItem item : items) {
                System.out.println(items);
            }
        }
        System.out.println("Sub Total: " + order.total());
        System.out.println("Tax: " + order.getTax());
        System.out.println("----------------------");
        System.out.println("Total: " + order.totalWithTax());

    }
}