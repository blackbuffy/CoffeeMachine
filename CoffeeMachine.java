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

        int water = 200;
        int milk = 50;
        int coffee = 15;

        System.out.println("Write how many ml of water the coffee machine has:");
        int waterHas = sc.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkHas = sc.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeHas = sc.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int numberOfCupsWanted = sc.nextInt();

        int waterNeeded = water * numberOfCupsWanted;
        int milkNeeded = milk * numberOfCupsWanted;
        int coffeeNeeded = coffee * numberOfCupsWanted;

        int cups = 0;

        if (waterHas >= waterNeeded && milkHas >= milkNeeded && coffeeHas >= coffeeNeeded) {
            for (int i = 0; waterHas >= water && milkHas >= milk && coffeeHas >= coffee; i++) {
                waterHas -= water;
                milkHas -= milk;
                coffeeHas -= coffee;
                cups += 1;
            }
            if (cups == numberOfCupsWanted) {
                System.out.println("Yes, I can make that amount of coffee");
            } else if (cups > numberOfCupsWanted) {
                int remainder = cups - numberOfCupsWanted;
                System.out.println("Yes, I can make that amount of coffee (and even " + remainder + " more that that)");
            }
        } else if (waterHas < waterNeeded || milkHas < milkNeeded || coffeeHas < coffeeNeeded) {
            waterHas = waterHas / water;
            milkHas = milkHas / milk;
            coffeeHas = coffeeHas / coffee;
            cups = Math.min(Math.min(waterHas, milkHas), coffeeHas);
            System.out.println("No, I can make only " + cups + " cup(s) of coffee");
        }
    }
}
