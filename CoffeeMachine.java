import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        String str = """
        Starting to make a coffee
        Grinding coffee beans
        Boiling water
        Mixing boiled water with crushed coffee beans
        Pouring coffee into the cup
        Pouring some milk into the cup
        Coffee is ready!
        """;
        System.out.println(str);

        Scanner sc = new Scanner(System.in);

       // Espresso
        int waterEspresso = 250;
        int cbeansEspresso = 16;
        int priceEspresso = 4;

        // Latte
        int waterLatte = 350;
        int milkLatte = 75;
        int cbeansLatte = 20;
        int priceLatte = 7;

        // Cappuccino
        int waterCappuccino = 200;
        int milkCappuccino = 100;
        int cbeansCappuccino = 12;
        int priceCappuccino = 6;

        // Coffee machine start
        int waterStart = 400;
        int milkStart = 540;
        int cbeansStart = 120;
        int cupsStart = 9;
        int moneyStart = 550;

        // Beginning of code
        System.out.println("""
                The coffee machine has:
                400 ml of water
                540 ml of milk
                120 g of coffee beans
                9 disposable cups
                $550 of money
                """);
        System.out.println("Write action (buy, fill, take): ");
        String action = sc.next();
        if (action.equals("buy")) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
            int item = sc.nextInt();
            switch (item) {
                case 1:
                    System.out.println("The coffee machine has:");
                    System.out.println((waterStart - waterEspresso) + " ml of water");
                    System.out.println(milkStart + " ml of milk");
                    System.out.println((cbeansStart - cbeansEspresso) + " g of coffee beans");
                    System.out.println((cupsStart - 1) + " disposable cups");
                    System.out.println("$" + (moneyStart + priceEspresso) + " of money");
                    break;
                case 2:
                    System.out.println("The coffee machine has:");
                    System.out.println((waterStart - waterLatte) + " ml of water");
                    System.out.println((milkStart - milkLatte) + " ml of milk");
                    System.out.println((cbeansStart - cbeansLatte) + " g of coffee beans");
                    System.out.println((cupsStart - 1) + " disposable cups");
                    System.out.println("$" + (moneyStart + priceLatte) + " of money");
                    break;
                case 3:
                    System.out.println("The coffee machine has:");
                    System.out.println((waterStart - waterCappuccino) + " ml of water");
                    System.out.println((milkStart - milkCappuccino) + " ml of milk");
                    System.out.println((cbeansStart - cbeansCappuccino) + " g of coffee beans");
                    System.out.println((cupsStart - 1) + " disposable cups");
                    System.out.println("$" + (moneyStart + priceCappuccino) + " of money");
                    break;
            }
        } else if (action.equals("fill")) {
            System.out.println("Write how many ml of water you want to add: ");
            int newWater = sc.nextInt();
            System.out.println("Write how many ml of milk you want to add: ");
            int newMilk = sc.nextInt();
            System.out.println("Write how many grams of coffee beans you want to add: ");
            int newCBeans = sc.nextInt();
            System.out.println("Write how many disposable cups you want to add: ");
            int newCups = sc.nextInt();

            System.out.println("The coffee machine has:");
            System.out.println((waterStart + newWater) + " ml of water");
            System.out.println((milkStart + newMilk) + " ml of milk");
            System.out.println((cbeansStart + newCBeans) + " g of coffee beans");
            System.out.println((cupsStart + newCups) + " disposable cups");
            System.out.println("$" + moneyStart + " of money");
        } else if (action.equals("take")) {
            System.out.println("I gave you $" + moneyStart);

            System.out.println("The coffee machine has:");
            System.out.println(waterStart + " ml of water");
            System.out.println(milkStart + " ml of milk");
            System.out.println(cbeansStart + " g of coffee beans");
            System.out.println(cupsStart + " disposable cups");
            System.out.println("$0 of money");
        }
    }
}
