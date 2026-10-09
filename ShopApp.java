import java.util.*;
public class ShopApp
{
    private Scanner pln = new Scanner(System.in);
    private Product[] productIn = new Product[5];
    public ShopApp()
    {
        
        System.out.println("Ege Güldal's Work");
        System.out.println("Student ID: 3065720");
        
        
        productIn[0] = new Product("Water", 80, 0.50);
        productIn[1] = new Product("Milk", 30, 1.50);
        productIn[2] = new Product("Juice", 30, 3.30);
        productIn[3] = new Product("Coke", 50, 2.10);
        productIn[4] = new Product("Coffee", 25, 1.90);
        
        menu();
    }
    public static void main (String args[])
    {
        new ShopApp();
    }
    private void menu()
    {
        int choice = -1;
        while (choice != 0)
        {
            System.out.println("---------------------");
            System.out.println("1 Display Products");
            System.out.println("2 Buy Stock");
            System.out.println("3 Sell Stock");
            System.out.println("4 Re-Price Product");
            System.out.println("5 Total Stock Value");
            System.out.println("0 Exit");
            System.out.println("---------------------");
            System.out.print("Choose a section: ");
            
            choice = pln.nextInt();
            
            if(choice == 1)
            {
                displayProducts();
            }
            else if (choice == 2)
            {
                buyStock();
            }
            else if (choice == 3)
            {
                sellStock();
            }
            else if (choice == 4)
            {
                reprice();
            }
            else if (choice == 5)
            {
                totalValue();
            }
            else if (choice == 0)
            {
                System.out.println("Program stopped.");
            }
            else if (choice > 5)
            {
                System.out.println("Choose a valid section!");
            }
        }
    }
    
    private void displayProducts()
    {
        for(int i=0; i < productIn.length; i++)
        {
            System.out.println(i + " " + productIn[i].getName() + " Stock: " + productIn[i].getStockLevel() + " Price: £" + productIn[i].getPrice());
        }
    }
    private void buyStock()
    {
        displayProducts();
        System.out.print("Enter product index: ");
        int i = pln.nextInt();
        System.out.print("Enter amount to buy: ");
        int amount = pln.nextInt();
        double value = productIn[i].buyStock(amount);
        System.out.println("Value bought: £" + value);
    }
    private void sellStock()
    {
        displayProducts();
        System.out.print("Product index: ");
        int i = pln.nextInt();
        System.out.print("Amount to sell: ");
        int amount = pln.nextInt();
        if (productIn[i].sell(amount))
        {
            System.out.println("Successfully sold!");
        }
        else
        {
            System.out.println("Not enough stock!");
        }
    }
    private void reprice()
    {
        displayProducts();
        System.out.print("Enter product index: ");
        int i = pln.nextInt();
        System.out.print("Enter the new price: ");
        double x = pln.nextDouble();
        productIn[i].setPrice(x);
        System.out.println("Price successfully updated!");
    }
    private void totalValue()
    {
        double total = 0;
        for(int i=0; i<productIn.length; i++)
        {
            double value = productIn[i].getStockLevel() * productIn[i].getPrice();
            total = total + value;
        }
        System.out.println("Total stock value is £" + total);
    }
}