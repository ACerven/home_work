package lab2;

public class MainClass {
    public MainClass() {
    }

    public static void main(String[] var0) {
        Stove stove1 = new Stove(4, 10, 9);
        StoveOven stoveOven1 = new StoveOven(4, 10, 9, 3);
        if (stove1.getPerson() < stoveOven1.getPerson())
            System.out.println("On stove with oven you can cook more food for " + stoveOven1.getPerson() + " people!");
        else System.out.println("On this stove you can cook more food for " + stove1.getPerson() + " people");
    }
}
