
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CaffeinatedBeverage[] inventory = new CaffeinatedBeverage[10];
        Scanner keyboard = new Scanner(System.in);
        // Prompt user with options in a loop
        int choice, ounces, brewTemp, count = 0;
        String name;
        double price;

        do {
            System.out.println("1) Enter new Tea");
            System.out.println("2) Enter new Yerba Mate");
            System.out.println("3) Exit");
            System.out.print(">> ");
            choice = keyboard.nextInt();
            keyboard.nextLine();  // Consume newline left from nextInt()

            switch (choice) {
                case 1: // Tea
                    System.out.print("Enter name      : ");
                    name = keyboard.nextLine();
                    System.out.print("Enter ounces    : ");
                    ounces = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.print("Enter price     $ ");
                    price = keyboard.nextDouble();
                    keyboard.nextLine();
                    System.out.print("Enter brew temperature (in Celsius): ");
                    brewTemp = keyboard.nextInt();
                    keyboard.nextLine();

                    inventory[count] = new Tea(name, ounces, price, brewTemp);

                    System.out.println("Your tea order has been added: " + inventory[count]);
                    count++;
                    break;

                case 2:
                    System.out.print("Enter name      : ");
                    name = keyboard.nextLine();
                    System.out.print("Enter ounces    : ");
                    ounces = keyboard.nextInt();
                    System.out.print("Enter price     $ ");
                    price = keyboard.nextDouble();
                    System.out.print("Enter brew temperature (in Celsius): ");
                    brewTemp = keyboard.nextInt();

                    // Create a Yerba Mate, put into array
                    inventory[count] = new YerbaMate(name, ounces, price, brewTemp, 0); // Start with 0 passes
                    System.out.println("Yerba Mate added: " + inventory[count]);
                    count++;
                    break;

            }

        } while (choice != 3);

        // Print inventory
        System.out.println("\nInventory:");
        for (int i = 0; i < count; i++) {
            System.out.println(inventory[i]);
        }

        // Find the Yerba Mate with the highest price
        YerbaMate mostExpensiveYerbaMate = findHighestPricedYerbaMate(inventory);
        if (mostExpensiveYerbaMate != null) {
            System.out.println("\nMost expensive Yerba Mate: " + mostExpensiveYerbaMate);
        }

        // Calculate and display the average price of all beverages
        double averagePrice = findAveragePrice(inventory);
        System.out.println("Average price of all beverages: $" + String.format("%.2f", averagePrice));
    }

    // Method to find the average price of all beverages
    public static double findAveragePrice(CaffeinatedBeverage[] inventory) {
        double total = 0;
        int count = 0;
        for (CaffeinatedBeverage beverage : inventory) {
            if (beverage != null) {
                total += beverage.getPrice();
                count++;
            }
        }
        return count > 0 ? total / count : 0;
    }

    // Method to find the Yerba Mate with the highest price
    public static YerbaMate findHighestPricedYerbaMate(CaffeinatedBeverage[] inventory) {
        YerbaMate mostExpensive = null;
        for (CaffeinatedBeverage beverage : inventory) {
            if (beverage instanceof YerbaMate) {
                if (mostExpensive == null || beverage.getPrice() > mostExpensive.getPrice()) {
                    mostExpensive = (YerbaMate) beverage;
                }
            }
        }
        return mostExpensive;
    }
}
