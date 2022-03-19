package fmi.poop.zad1;

public class StockTest
{
    public static void main(String[] args)
    {
        Stock stockT = new Stock(); // Object of type Stock for testing the default constructor
        System.out.println("Default Values:\n");
        System.out.println("Symbol: " + stockT.getSymbol() + "\nName: " + stockT.getName());
        System.out.println("previousClosingPrice: " + stockT.getPreviousClosingPrice() + "\ncurrentPrice: " + stockT.getCurrentPrice());
        System.out.println("changePercent: " + stockT.changePercent() + "%");
        Stock stock = new Stock("Cool Symbol", "Cool Name");
        System.out.println("\nProgram Testing:\n");
        stock.setPreviousClosingPrice(5);
        stock.setCurrentPrice(10);
        System.out.println("Symbol: " + stock.getSymbol() + "\nName: " + stock.getName());
        System.out.println("previousClosingPrice: " + stock.getPreviousClosingPrice() + "\ncurrentPrice: " + stock.getCurrentPrice());
        System.out.println("changePercent: " + stock.changePercent() + "%");
    }
}
