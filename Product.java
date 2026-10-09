public class Product
{
    private String name;
    private int stockLevel;
    private double price;

    public Product(String nameIn, int stockLevelIn, double priceIn)
    {
        name = nameIn;
        stockLevel = stockLevelIn;
        price = priceIn;
    }



    public double buyStock(int number)
    {
        if (number > 0)
        {
            stockLevel = stockLevel + number;
            return number * price;
        }
        return 0;
    }



    public boolean sell(int number)
    {
        if (number > 0 && number <= stockLevel)
        {
            stockLevel = stockLevel - number;
            return true;
        }
        return false;
    }



    public void setPrice(double newPrice)
    {
        price = newPrice;
    }



    public String getName()
    {
        return name;
    }
    public int getStockLevel()
    {
        return stockLevel;
    }
    public double getPrice()
    {
        return price;
    }
}