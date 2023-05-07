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

        // Coffee machine start values
        int water = 400;
        int milk = 540;
        int cbeans = 120;
        int cups = 9;
        int money = 550;

        // Beginning of code
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = sc.next();
        while (!action.equals("exit")) {
            switch (action) {
                case "buy" -> {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                    String item = sc.next();
                    switch (item) {
                        case "1" -> {
                            if (water >= waterEspresso && cbeans >= cbeansEspresso && cups >= 1) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= waterEspresso;
                                cbeans -= cbeansEspresso;
                                cups -= 1;
                                money += priceEspresso;
                            } else if (water < waterEspresso) {
                                System.out.println("Sorry, not enough water!");
                            } else if (cbeans < cbeansEspresso) {
                                System.out.println("Sorry, not enough coffee beans!");
                            } else if (cups == 0) {
                                System.out.println("Sorry, not enough disposable cups!");
                            }
                        }
                        case "2" -> {
                            if (water >= waterLatte && milk >= milkLatte && cbeans >= cbeansLatte && cups >= 1) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= waterLatte;
                                milk -= milkLatte;
                                cbeans -= cbeansLatte;
                                cups -= 1;
                                money += priceLatte;
                            } else if (water < waterLatte) {
                                System.out.println("Sorry, not enough water!");
                            } else if (milk < milkLatte) {
                                System.out.println("Sorry, not enough milk!");
                            } else if (cbeans < cbeansLatte) {
                                System.out.println("Sorry, not enough coffee beans!");
                            } else if (cups == 0) {
                                System.out.println("Sorry, not enough disposable cups!");
                            }
                        }
                        case "3" -> {
                            if (water >= waterCappuccino && milk >= milkCappuccino && cbeans >= cbeansCappuccino && cups >= 1) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= waterCappuccino;
                                milk -= milkCappuccino;
                                cbeans -= cbeansCappuccino;
                                cups -= 1;
                                money += priceCappuccino;
                            } else if (water < waterCappuccino) {
                                System.out.println("Sorry, not enough water!");
                            } else if (milk < milkCappuccino) {
                                System.out.println("Sorry, not enough milk!");
                            } else if (cbeans < cbeansCappuccino) {
                                System.out.println("Sorry, not enough coffee beans!");
                            } else if (cups == 0) {
                                System.out.println("Sorry, not enough disposable cups!");
                            }
                        }
                    }
                    System.out.println("Write action (buy, fill, take, remaining, exit): ");
                    action = sc.next();
                }
                case "fill" -> {
                    System.out.println("Write how many ml of water you want to add: ");
                    water += sc.nextInt();
                    System.out.println("Write how many ml of milk you want to add: ");
                    milk += sc.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add: ");
                    cbeans += sc.nextInt();
                    System.out.println("Write how many disposable cups you want to add: ");
                    cups += sc.nextInt();
                    System.out.println("Write action (buy, fill, take, remaining, exit): ");
                    action = sc.next();
                }
                case "take" -> {
                    System.out.println("I gave you $" + money);
                    money = 0;
                    System.out.println("Write action (buy, fill, take, remaining, exit): ");
                    action = sc.next();
                }
                case "remaining" -> {
                    System.out.println("The coffee machine has:");
                    System.out.println(water + " ml of water");
                    System.out.println(milk + " ml of milk");
                    System.out.println(cbeans + " g of coffee beans");
                    System.out.println(cups + " disposable cups");
                    System.out.println("$" + money + " of money");
                    System.out.println("Write action (buy, fill, take, remaining, exit): ");
                    action = sc.next();
                }
            }
        }
    }
}
