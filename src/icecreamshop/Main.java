package icecreamshop;

import icecreamshop.facade.IceCreamShopFacade;
import icecreamshop.model.IceCreamOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IceCreamShopFacade shopFacade = new IceCreamShopFacade();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Ice Cream Shop (SDP Project) ===");

        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();


        System.out.println("\nChoose base flavor (default: 1 - Vanilla):");
        System.out.println("1. Vanilla\n2. Chocolate\n3. Strawberry");
        System.out.print("Choice: ");
        String flavor = scanner.nextLine().trim();
        if (flavor.isEmpty()) flavor = "1";

        System.out.println("\nEnter toppings separated by comma (or press Enter to skip):");
        System.out.println("1. Chocolate Syrup (+200 KZT)");
        System.out.println("2. Sprinkles (+150 KZT)");
        System.out.println("3. Waffle Cone (+300 KZT)");
        System.out.println("4. Crushed Nuts (+250 KZT)");
        System.out.print("Choices (e.g. 1, 4): ");
        String toppingsInput = scanner.nextLine();

        List<String> toppings = new ArrayList<>();
        if (!toppingsInput.trim().isEmpty()) {
            toppings = Arrays.asList(toppingsInput.split("\\s*,\\s*"));
        }


        System.out.print("\nServing style (Cup / Cone): ");
        String servingStyle = scanner.nextLine();

        System.out.print("Is it takeaway? (true/false, default false): ");
        String takeawayInput = scanner.nextLine().trim();
        boolean takeaway = !takeawayInput.isEmpty() && Boolean.parseBoolean(takeawayInput);

        System.out.print("Include spoon? (true/false, default true): ");
        String spoonInput = scanner.nextLine().trim();
        boolean includeSpoon = spoonInput.isEmpty() || Boolean.parseBoolean(spoonInput);

        System.out.println("\nChoose payment method (default: 1 - Cash):");
        System.out.println("1. Cash\n2. Card\n3. Kaspi Pay");
        System.out.print("Choice: ");
        String paymentMethod = scanner.nextLine().trim();
        if (paymentMethod.isEmpty()) paymentMethod = "1";


        IceCreamOrder order = shopFacade.placeFullOrder(
                customerName,
                flavor,
                toppings,
                servingStyle,
                takeaway,
                includeSpoon,
                paymentMethod
        );


        if (order != null) {
            System.out.println("\n=== RECEIPT ===");
            System.out.println(order);
        }

        scanner.close();
    }
}
