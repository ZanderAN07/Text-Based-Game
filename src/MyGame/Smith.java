package MyGame;

import java.util.Scanner;

public class Smith {
    void enterSmith(Player p){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("=== 🛒 Welcome to the Shop ===");
            System.out.println("== Press 1 for Armor Increase, 20 gold required ===");
            System.out.println("=== Press 2 for Sword Increase, 20 gold required ===");
            System.out.println("-1. Quit shop");
            if (sc.hasNextInt()) {
                int NoItem = sc.nextInt();
                if(NoItem == -1) {
                    break;
                }
                else
                    if (NoItem == 1){
                        if(p.gold < 20){
                            System.out.println("Oops, Not Enough Gold");
                            break;
                        }
                        p.attack += 2;
                        p.gold -= 20;
                        System.out.println("Your Current Gold: " + p.gold);
                } else if (NoItem == 2) {
                        if(p.gold < 20){
                            System.out.println("Oops, Not Enough Gold");
                            break;
                        }
                        p.defense += 2;
                        p.gold -= 20;
                        System.out.println("Your Current Gold: " + p.gold);
                    }
                } else {
                System.out.println("⚠️ Invalid Input!");
                sc.next(); // 把错误的输入清除
            }
        }
    }
}
