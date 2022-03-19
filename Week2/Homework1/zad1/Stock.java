package fmi.poop.zad1;

public class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock()
    {
        this.symbol = "Empty";
        this.name = "Empty";
        this.previousClosingPrice = 1;
        this.currentPrice = 1;
    }

    public Stock(String symbol, String name)
    {
        if (symbol != null && name != null)
        {
            this.symbol = symbol;
            this.name = name;
        }
        else
        {
            this.symbol = "Empty";
            this.name = "Empty";
        }

        this.previousClosingPrice = 1;
        this.currentPrice = 1;
    }

    public String getSymbol()
    {
        return this.symbol;
    }

    public String getName()
    {
        return this.name;
    }

    public double getPreviousClosingPrice()
    {
        return this.previousClosingPrice;
    }

    public double getCurrentPrice()
    {
        return this.currentPrice;
    }

    public void setPreviousClosingPrice(double price)
    {
        if (price < 1)
        {
            System.out.println("The price cannot be lower than 1! Therefore, it is set to 1.");
            this.previousClosingPrice = 1;
        }
        else
            this.previousClosingPrice = price;
    }

    public void setCurrentPrice(double price)
    {
        if (price < 1)
        {
            System.out.println("The price cannot be lower than 1! Therefore, it is set to 1.");
            this.currentPrice = 1;
        }
        else
            this.currentPrice = price;
    }

    public double changePercent()
    {
        return 100 * (currentPrice - previousClosingPrice) / previousClosingPrice;
    }
}
