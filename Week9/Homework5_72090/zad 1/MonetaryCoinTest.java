package fmi.poop.zad1;

public class MonetaryCoinTest {
    public static void main(String[] args) {
        MonetaryCoin coin1 = new MonetaryCoin();
        System.out.println(coin1.getValue());
        coin1.setValue(1);
        MonetaryCoin coin2 = new MonetaryCoin(-10);
        System.out.println(coin2.getValue());
        coin2.setValue(10);
        MonetaryCoin coin3 = new MonetaryCoin(20);
        System.out.println(coin3.getValue());
        MonetaryCoin coin4 = new MonetaryCoin(50);
        MonetaryCoin coin5 = new MonetaryCoin(5);
        MonetaryCoin coin6 = new MonetaryCoin();
        coin6.setValue(2);
        System.out.println("All coins: " + coin1.getValue() + " ; " + coin2.getValue() + " ; " + coin3.getValue() + " ; " + coin4.getValue() + " ; " + coin5.getValue() + " ; " + coin6.getValue());
        coin1.flip();
        coin2.flip();
        coin3.flip();
        coin4.flip();
        coin5.flip();
        coin6.flip();
        System.out.println("All coin faces: " + coin1.getFace() + " ; " + coin2.getFace() + " ; " + coin3.getFace() + " ; " + coin4.getFace() + " ; " + coin5.getFace() + " ; " + coin6.getFace());
        System.out.print("Is the first coin's face heads? - ");
        if (coin1.isHeads())
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.print("Is the last coin's face heads? - ");
        if (coin6.isHeads())
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.print("Sum of all coins: ");
        System.out.println(coin1.getValue() + coin2.getValue() + coin3.getValue() + coin4.getValue() + coin5.getValue() + coin6.getValue());
    }
}
