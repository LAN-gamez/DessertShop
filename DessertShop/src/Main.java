public class Main {
    public static void main(String[] args) {
        Candy chocolate = new Candy(".5");
        System.out.println("$" + chocolate.totalPrice());

        Cookies toffee = new Cookies("144");
        System.out.println("$" + toffee .totalPrice());

        Sundae Conner_sundae = new Sundae();
        Conner_sundae.addCoconut();

    }
}