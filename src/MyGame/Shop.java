package MyGame;

import java.util.Scanner;

public class Shop {

    Item[] Product = new Item[5];

    public Shop() {
        for (int a = 0; a < 5; a++) {
            Product[a] = AddRandomItem();
        }
    }

    Item AddRandomItem() {
        double rand = Math.random();

        if (rand < 0.25) {
            return new RecoverItem("Potion +3HP", 10, 3);
        } else if (rand < 0.5) {
            return new AttackItem("Attack Potion - Cause 5 Damage", 7, 5);
        } else if (rand < 0.75) {
            return new RecoverItem("Potion +5HP", 20, 5);
        } else {
            return new RecoverItem("Potion +10HP", 50, 10);
        }
    }


    void showShopInfo() {
        for (int index = 0; index < 5; index++) {
            if (Product[index] != null) {
                Item i = Product[index];
                System.out.println("Press " + index + " for buying " + i.name + ", Cost: " + i.value + " Gold");
            }
        }
    }

    void buy(Player p, int index) {
        if (index >= 5 || Product[index] == null) {
            System.out.println("Error: Invalid Index!");
        } else {
            int price = Product[index].value;
            if (p.gold < price) {
                System.out.println("Oops, Your Gold is not enough.");
            } else {
                p.ReduceGold(price);
                p.inventory.add(Product[index]);
                Product[index] = null;
            }
        }
    }

    void enterShop(Player p) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=== 🛒 Welcome to the Shop ===");
            showShopInfo();
            System.out.println("-1. Quit shop");

            int NoItem = Helper.getValidIntInput(sc, -1, 5);
            if (NoItem == -1) {
                System.out.println("Leaving shop...");
                break;
            } else {
                buy(p, NoItem);
            }
        }
    }
}

