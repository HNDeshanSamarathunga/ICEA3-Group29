import java.util.Scanner;

class Clothes {
    private String name;
    private String type;
    private double price;
    private int quantity;

    public Clothes(String name, String type, double price, int quantity) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class ClothingShop {
    private Clothes[] clothes;

    public ClothingShop(int numClothes) {
        clothes = new Clothes[numClothes];
    }

    public void addClothes(Clothes clothes, int index) {
        this.clothes[index] = clothes;
    }

    public void displayClothes() {
        System.out.println("Available Clothes:");
        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i] != null) {
                System.out.println(i + ". " + clothes[i].getName() + " - Type: " + clothes[i].getType()
                        + ", Price: $" + String.format("%.2f", clothes[i].getPrice()) + ", Quantity: " + clothes[i].getQuantity());
            }
        }
    }

    public Clothes getClothes(int index) {
        if (index >= 0 && index < clothes.length && clothes[index] != null) {
            return clothes[index];
        } else {
            System.out.println("Invalid selection.");
            return null;
        }
    }

    public void updateClothesQuantity(int index, int quantity) {
        if (index >= 0 && index < clothes.length && clothes[index] != null) {
            clothes[index].setQuantity(clothes[index].getQuantity() - quantity);
        } else {
            System.out.println("Invalid selection.");
        }
    }
}

class Bill {
    private double totalAmount;
    private double receivedAmount;
    private double changeAmount;

    public Bill() {
        totalAmount = 0;
        receivedAmount = 0;
        changeAmount = 0;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(double receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public double getChangeAmount() {
        return changeAmount;
    }

    public void calculateChange() {
        changeAmount = receivedAmount - totalAmount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ClothingShop clothingShop = new ClothingShop(5);
        Bill bill = new Bill();

        clothingShop.addClothes(new Clothes("SHIRT", "MEN", 10.99, 50), 0);
        clothingShop.addClothes(new Clothes("PANTS", "KIDS", 5.99, 30), 1);
        clothingShop.addClothes(new Clothes("BLOUSE", "WOMEN", 8.99, 40), 2);
        clothingShop.addClothes(new Clothes("TOYS", "KIDS", 7.99, 20), 3);
        clothingShop.addClothes(new Clothes("SAREES", "WOMEN", 15.99, 10), 4);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display Clothes");
            System.out.println("2. Add to Bill");
            System.out.println("3. Generate Bill");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    clothingShop.displayClothes();
                    break;
                case 2:
                    System.out.print("Enter the number of the items you want to add to the bill: ");
                    int colIndex = scanner.nextInt();
                    Clothes selectedClothes = clothingShop.getClothes(colIndex);
                    if (selectedClothes != null) {
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        if (quantity <= selectedClothes.getQuantity()) {
                            double total = selectedClothes.getPrice() * quantity;
                            bill.setTotalAmount(bill.getTotalAmount() + total);
                            clothingShop.updateClothesQuantity(colIndex, quantity);
                            System.out.println("Added " + quantity + " " + selectedClothes.getName() + "(s) to the bill.");
                        } else {
                            System.out.println("Insufficient quantity in stock.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nGenerating Bill...");
                    System.out.println("Total Amount: $" + String.format("%.2f", bill.getTotalAmount()));
                    System.out.print("Enter the amount received: $");
                    double receivedAmount = scanner.nextDouble();
                    bill.setReceivedAmount(receivedAmount);
                    bill.calculateChange();
                    System.out.println("Change: $" + String.format("%.2f", bill.getChangeAmount()));
                    System.out.println("*******Thank you for your Shopping!******* ");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }
}
