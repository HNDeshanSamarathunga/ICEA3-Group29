import java.util.ArrayList;
import java.util.Scanner;
class ClothingShop {
	ArrayList<String> CName = new ArrayList<String>();
	ArrayList<String> CCode = new ArrayList<String>();
	ArrayList<Double> Price = new ArrayList<Double>();
	ArrayList<Integer> Quantity = new ArrayList<Integer>();
	ArrayList<Double> Total_Price = new ArrayList<Double>();
	double totalBill = 0.0;
	Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		ClothingShop obj = new ClothingShop();
		obj.start();
	}
	void start() {
		System.out.println("*****************************************************************************************");
		System.out.println("        !!!------------------Welcome to Our Clothing Store-------------------!!!");
		System.out.println("*****************************************************************************************");
		System.out.println("If you want to see our list of items, please type 1");
		int choice = input.nextInt();
		if (choice == 1) {
			displayClothingItems();
		} else {
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("You entered an invalid option. Please choose a correct option.");
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println();
			start();
		}
	}
	double discount(double totalBill) {
		//discout if your total bill above 1000...
		double discount = 0.0;
		if (totalBill >= 1000) {
			discount = 0.1 * totalBill;
		}
		return discount;
	}
	void processClothingItem(double total, String name, String code, double price, int quantity) {
		System.out.println("Press 1 to continue shopping");
		System.out.println("Press 2 to stop and get the bill");
		System.out.println("Press 3 to exit");
		int choice = input.nextInt();
		if (choice == 1) {
			totalBill += total;
			addToCart(name, code, price, quantity, total);
			displayClothingItems();
		} else if (choice == 2) {
			totalBill += total;
			addToCart(name, code, price, quantity, total);
			System.out.print("Enter your name: ");
			input.nextLine();
			String customerName = input.nextLine();
			System.out.print("Enter your address: ");
			String address = input.nextLine();
			String phoneNumber = "";
			int validPhone = 1;
			while (validPhone == 1) {
				System.out.print("Enter your contact number: ");
				String phone = input.next();
				if (phone.length() == 10) {
					phoneNumber = phoneNumber + phone;
					validPhone = 0;
				} else {
					System.out.println("Please check and enter a valid phone number.");
					validPhone = 1;
				}
				System.out.println();
			}
			printBill(customerName, address, phoneNumber);
		} else if (choice == 3) {
			System.out.println();
			System.exit(0);
		} else {
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("You entered an invalid option. Please choose a correct option.");
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println();
			processClothingItem(total, name, code, price, quantity);
		}
	}
	void displayClothingItems() {
		System.out.println();
		System.out.println("Clothing Items:");
		System.out.println("1) T-Shirts");
		System.out.println("2) Jeans");
		System.out.println("3) Dresses");
		System.out.println("4) Accessories");
		System.out.println("5) BMI Calculator (New Feature)");
		System.out.println("6) Exit");
		System.out.println("****************************************************************************************");
		System.out.println("Please choose your option: ");
		int option = input.nextInt();
		selectClothingCategory(option);
	}
	void selectClothingCategory(int option) {
		if (option <= 6) {
			System.out.println("Are you sure? Type 1 for yes, Type 2 for no");
			int confirm = input.nextInt();
			if (confirm == 1) {
				chooseClothingProduct(option);
			} else if (confirm == 2) {
				displayClothingItems();
			} else {
				System.out.println();
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println("You entered an invalid option. Please choose a correct option (1 or 2).");
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println();
				selectClothingCategory(option);
			}
		} else {
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("You entered an invalid option. Please choose a correct option.");
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println();
			displayClothingItems();
		}
	}
	void chooseClothingProduct(int option) {
		switch (option) {
		case 1:
			System.out.println();
			System.out.println("101 - Men's T-Shirt - Rs.20");
			System.out.println("102 - Women's T-Shirt - Rs.18");
			System.out.println("103 - Kid's T-Shirt - Rs.15");
			System.out.println("104 - Polo Shirt - Rs.25");
			System.out.println("*****************************************************************************************");
			System.out.println("Please choose a product code: ");
			int productCode = input.nextInt();
			if (productCode == 101) {
				buyTShirt("Men's T-Shirt", "101", 20);
			} else if (productCode == 102) {
				buyTShirt("Women's T-Shirt", "102", 18);
			} else if (productCode == 103) {
				buyTShirt("Kid's T-Shirt", "103", 15);
			} else if (productCode == 104) {
				buyTShirt("Polo Shirt", "104", 25);
			} else {
				System.out.println();
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println("You entered an invalid product code. Please choose a correct option.");
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println();
				chooseClothingProduct(option);
			}
			break;
		case 2:
			System.out.println();
			System.out.println("201 - Men's Jeans - Rs.50");
			System.out.println("202 - Women's Jeans - Rs.45");
			System.out.println("203 - Kid's Jeans - Rs.40");
			System.out.println("204 - Slim Fit Jeans - Rs.60");
			System.out.println("*****************************************************************************************");
			System.out.println("Please choose a product code: ");
			int jeansCode = input.nextInt();
			if (jeansCode == 201) {
				buyJeans("Men's Jeans", "201", 50);
			} else if (jeansCode == 202) {
				buyJeans("Women's Jeans", "202", 45);
			} else if (jeansCode == 203) {
				buyJeans("Kid's Jeans", "203", 40);
			} else if (jeansCode == 204) {
				buyJeans("Slim Fit Jeans", "204", 60);
			} else {
				System.out.println();
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println("You entered an invalid product code. Please choose a correct option.");
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println();
				chooseClothingProduct(option);
			}
			break;
		case 3:
			System.out.println();
			System.out.println("301 - Women's Dress - Rs.80");
			System.out.println("302 - Party Dress - Rs.100");
			System.out.println("303 - Summer Dress - Rs.60");
			System.out.println("304 - Maxi Dress - Rs.70");
			System.out.println("*****************************************************************************************");
			System.out.println("Please choose a product code: ");
			int dressCode = input.nextInt();
			if (dressCode == 301) {
				buyDress("Women's Dress", "301", 80);
			} else if (dressCode == 302) {
				buyDress("Party Dress", "302", 100);
			} else if (dressCode == 303) {
				buyDress("Summer Dress", "303", 60);
			} else if (dressCode == 304) {
				buyDress("Maxi Dress", "304", 70);
			} else {
				System.out.println();
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println("You entered an invalid product code. Please choose a correct option.");
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println();
				chooseClothingProduct(option);
			}
			break;
		case 4:
			System.out.println();
			System.out.println("401 - Scarf - Rs.10");
			System.out.println("402 - Hat - Rs.12");
			System.out.println("403 - Sunglasses - Rs.15");
			System.out.println("404 - Belt - Rs.8");
			System.out.println("*****************************************************************************************");
			System.out.println("Please choose a product code: ");
			int accessoryCode = input.nextInt();
			if (accessoryCode == 401) {
				buyAccessory("Scarf", "401", 10);
			} else if (accessoryCode == 402) {
				buyAccessory("Hat", "402", 12);
			} else if (accessoryCode == 403) {
				buyAccessory("Sunglasses", "403", 15);
			} else if (accessoryCode == 404) {
				buyAccessory("Belt", "404", 8);
			} else {
				System.out.println();
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println("You entered an invalid product code. Please choose a correct option.");
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println();
				chooseClothingProduct(option);
			}
			break;
		case 5:
			Bmi obj=new Bmi();
			obj.bmi();
			displayClothingItems();
			break;	
		case 6:
			
			break;
		default:
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("You entered an invalid option. Please choose a correct option.");
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println();
			displayClothingItems();
		}
	}
	void addToCart(String name, String code, double price, int quantity, double total) {
		CName.add(name);
		CCode.add(code);
		Price.add(price);
		Quantity.add(quantity);
		Total_Price.add(total);
	}
	void buyTShirt(String name, String code, double price) {
		System.out.print("Enter quantity: ");
		int quantity = input.nextInt();
		double total = price * quantity;
		processClothingItem(total, name, code, price, quantity);
	}
	void buyJeans(String name, String code, double price) {
		System.out.print("Enter quantity: ");
		int quantity = input.nextInt();
		double total = price * quantity;
		processClothingItem(total, name, code, price, quantity);
	}
	void buyDress(String name, String code, double price) {
		System.out.print("Enter quantity: ");
		int quantity = input.nextInt();
		double total = price * quantity;
		processClothingItem(total, name, code, price, quantity);
	}
	void buyAccessory(String name, String code, double price) {
		System.out.print("Enter quantity: ");
		int quantity = input.nextInt();
		double total = price * quantity;
		processClothingItem(total, name, code, price, quantity);
	}
	void printBill(String customerName, String address, String phoneNumber) {
		System.out.println("*****************************************************************************************");
		System.out.println(" Clothing Shopping Bill ");
		System.out.println("*****************************************************************************************");
		System.out.println("Name: " + customerName);
		System.out.println("Address: " + address);
		System.out.println("Phone Number: " + phoneNumber);
		System.out.println();
		System.out.println("Code | Name | Price | Quantity | Total ");
		System.out.println("----------------------------------------------------------------------");
		for (int i = 0; i < CName.size(); i++) {
			System.out.println(CCode.get(i) + " | " + CName.get(i) + " | Rs." + Price.get(i) + " | " + Quantity.get(i) + " | Rs." +
			Total_Price.get(i));
		}
		System.out.println("----------------------------------------------------------------------");
		double grandTotal = 0;
		for (Double price : Total_Price) {
			grandTotal += price;
		}
		System.out.println(" Grand Total: Rs." + grandTotal);
		System.out.println("*****************************************************************************************");
		System.out.println("Thank you for shopping with us! Please come again.");
		System.out.println("*****************************************************************************************");
	}
}

class Bmi{
	void bmi(){
		String w;
		double x,z;
		System.out.println("enter your name : ");
		Scanner sc=new Scanner(System.in);
		w=sc.nextLine();
		System.out.println("your weight (kg): ");
		x=sc.nextInt();
		System.out.println("your height (cm) : ");
		z=sc.nextInt();
		double a=z/100;
		double y=a*a;
		double b=x/y;
		
		if(b<18.5){
			System.out.println("-> "+w+" your are underweight...");
			System.out.println("-> risk of nutritional deficiency diseases and osteoporosis");
		}else if(b<25){
			System.out.println("-> "+w+" you are normal...");
			System.out.println("-> healthy range");
		}else if(b<30){
			System.out.println("-> "+w+" you are overweight...");
			System.out.println("-> moderate risk");
		}else if(b<=30){
			System.out.println("-> "+w+" you are obese");
			System.out.println("-> high risk");
		}else{
			System.out.println("check your inputs");
		}
		
		System.out.println("-> BMI value: "+b);
	}
}