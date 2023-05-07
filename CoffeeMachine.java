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

        int water = 200;
        int milk = 50;
        int coffee = 15;

        System.out.println("Write how many cups of coffee you will need:");
        Scanner sc = new Scanner(System.in);
        int numberOfCups = sc.nextInt();

        System.out.println("For " + numberOfCups + " cups of coffee you will need:");
        System.out.println(water * numberOfCups + " ml of water");
        System.out.println(milk * numberOfCups + " ml of milk");
        System.out.println(coffee * numberOfCups + " g of coffee beans");
    }
}
