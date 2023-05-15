import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Machine machine = new Machine(400,540,120,9,550, MachineStatus.MAIN_MENU, sc);

        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        machine.action = sc.next();

        while (machine.status != MachineStatus.EXIT) {
            machine.work(machine.action);
        }
    }
}

enum MachineStatus {
    MAIN_MENU, BUY, FILL_WATER, FILL_MILK, FILL_CBEANS, FILL_CUPS, EXIT
}

class Machine {
    int waterCurrent;
    int milkCurrent;
    int cbeansCurrent;
    int cupsCurrent;
    int moneyCurrent;
    MachineStatus status;
    Scanner sc;
    String action;

    public Machine(int water, int milk, int cbeans, int cups, int money, MachineStatus status, Scanner sc) {
        this.waterCurrent = water;
        this.milkCurrent = milk;
        this.cbeansCurrent = cbeans;
        this.cupsCurrent = cups;
        this.moneyCurrent = money;
        this.status = status;
        this.sc = sc;
    }

    public void work(String action) {
        if (status == MachineStatus.MAIN_MENU) {
            if (action.equals("exit")) {
                this.status = MachineStatus.EXIT;
                sc.close();
            } else if (action.equals("buy")) {
                this.status = MachineStatus.BUY;
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                this.action = sc.next();
            } else if (action.equals("fill")) {
                status = MachineStatus.FILL_WATER;
                System.out.println("Write how many ml of water you want to add: ");
                this.action = sc.next();
            } else if (action.equals("take")) {
                System.out.println("I gave you $" + moneyCurrent);
                this.moneyCurrent = 0;
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                this.status = MachineStatus.MAIN_MENU;
                this.action = sc.next();
            } else if (action.equals("remaining")) {
                System.out.println("The coffee machine has:");
                System.out.println(this.waterCurrent + " ml of water");
                System.out.println(this.milkCurrent + " ml of milk");
                System.out.println(this.cbeansCurrent + " g of coffee beans");
                System.out.println(this.cupsCurrent + " disposable cups");
                System.out.println("$" + this.moneyCurrent + " of money");
                this.status = MachineStatus.MAIN_MENU;
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                this.action = sc.next();
            }
        } else if (status == MachineStatus.BUY) {
            if (action.equals("1")) {
                if (this.waterCurrent >= 250 && this.cbeansCurrent >= 16 && this.cupsCurrent >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.waterCurrent -= 250;
                    this.cbeansCurrent -= 16;
                    this.cupsCurrent -= 1;
                    this.moneyCurrent += 4;
                } else if (this.waterCurrent < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.cbeansCurrent < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.cupsCurrent == 0) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                status = MachineStatus.MAIN_MENU;
                this.action = sc.next();
            } else if (action.equals("2")) {
                if (this.waterCurrent >= 350 && this.milkCurrent >= 75 && this.cbeansCurrent >= 20 && this.cupsCurrent >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.waterCurrent -= 350;
                    this.milkCurrent -= 75;
                    this.cbeansCurrent -= 20;
                    this.cupsCurrent -= 1;
                    this.moneyCurrent += 7;
                } else if (this.waterCurrent < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.milkCurrent < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else if (this.cbeansCurrent < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.cupsCurrent == 0) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                this.status = MachineStatus.MAIN_MENU;
                this.action = sc.next();
            } else if (action.equals("3")) {
                if (this.waterCurrent >= 200 && this.milkCurrent >= 100 && this.cbeansCurrent >= 12 && this.cupsCurrent >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.waterCurrent -= 200;
                    this.milkCurrent -= 100;
                    this.cbeansCurrent -= 12;
                    this.cupsCurrent -= 1;
                    this.moneyCurrent += 6;
                } else if (this.waterCurrent < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.milkCurrent < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else if (this.cbeansCurrent < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.cupsCurrent == 0) {
                    System.out.println("Sorry, not enough disposable cups!");
                }
                this.status = MachineStatus.MAIN_MENU;
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                this.action = sc.next();
            } else if (action.equals("back")) {
                this.status = MachineStatus.MAIN_MENU;
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                this.action = sc.next();
            }
        } else if (status == MachineStatus.FILL_WATER) {
            waterCurrent += Integer.parseInt(action);
            System.out.println("Write how many ml of milk you want to add: ");
            status = MachineStatus.FILL_MILK;
            this.action = sc.next();
        } else if (status == MachineStatus.FILL_MILK) {
            milkCurrent += Integer.parseInt(action);
            System.out.println("Write how many grams of coffee beans you want to add: ");
            status = MachineStatus.FILL_CBEANS;
            this.action = sc.next();
        } else if (status == MachineStatus.FILL_CBEANS) {
            cbeansCurrent += Integer.parseInt(action);
            System.out.println("Write how many disposable cups you want to add: ");
            status = MachineStatus.FILL_CUPS;
            this.action = sc.next();
        } else if (status == MachineStatus.FILL_CUPS) {
            cupsCurrent += Integer.parseInt(action);
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            status = MachineStatus.MAIN_MENU;
            this.action = sc.next();
        }
    }
}