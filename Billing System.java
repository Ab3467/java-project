import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private List<Item> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double getTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void printBill() {
        System.out.println("-------- Bill --------");
        for (Item item : items) {
            System.out.println(item.getName() + "\t$" + item.getPrice());
        }
        System.out.println("----------------------");
        System.out.println("Total\t$" + getTotal());
        System.out.println("----------------------");
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Print bill");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.next();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    Item item = new Item(name, price);
                    order.addItem(item);
                    System.out.println("Item added to the order.");
                    break;
                case 2:
                    System.out.print("Enter item name to remove: ");
                    String itemName = scanner.next();
                    boolean found = false;
                    for (Item orderItem : order.getItems()) {
                        if (orderItem.getName().equals(itemName)) {
                            order.removeItem(orderItem);
                            found = true;
                            System.out.println("Item removed from the order.");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Item not found in the order.");
                    }
                    break;
                case 3:
                    order.printBill();
                    break;
                case 4:
                    System.out.println("Thank you for using the billing system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
