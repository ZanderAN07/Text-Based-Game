package MyGame;

import java.util.Scanner;

public class EventSystem {
    public static void battle(Player player, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "+------------------------------------------------+\n" +
                        "| ⚔️  !! Enemy Ahead !!                          |\n" +
                        "|                                                |\n" +
                        "|    Enemy Type: 🐉  << " + enemy.name + " >>             |\n" +
                        "|                                                |\n" +
                        "|    ❤️  HP:       " + enemy.hp + "                          |\n" +
                        "|    💥  Attack:    " + enemy.attack + "                          |\n" +
                        "|                                                |\n" +
                        "+------------------------------------------------+\n"
        );
        int round = 0;
        while (player.getHp() > 0 && enemy.getHp() > 0) {
            // 玩家回合
            round ++;
            System.out.println(
                    "\n+================================================+\n" +
                            "|                 ⚔ ROUND " + round + " - YOUR TURN ⚔                |\n" +
                            "+================================================+\n" +
                            "| What will you do?                              |\n" +
                            "|   Press：                                       |\n" +
                            "|   1. 🤺 Attack                                 |\n" +
                            "|   2. 🧪 Use an Item                            |\n" +
                            "|   3. 🫵 Use a Skill                            |\n" +
                            "|                                                |\n" +
                            "+------------------------------------------------+\n"
            );

            int input = Helper.getValidIntInput(scanner, 1, 4);
            if (input == 1) {
                player.Attack(enemy);
                System.out.println(
                        "\n>> You attacked the enemy!\n" +
                                ">> 💥 Damage Dealt: " + player.attack + "\n" +
                                ">> 🩸 Enemy Remaining HP: " + enemy.getHp()
                );
            }
            else if (input == 2) {
                System.out.println("Checking Your Bag……");
                if (player.inventory.isEmpty()) {
                    System.out.println("Oops, Seems That Your Bag Is Empty");
                } else {
                    for (int index = 0; index < player.inventory.size(); index++) {
                        System.out.println("=== Press " + index + " For Using " + player.inventory.get(index).name + " ===");
                    }
                    Scanner sc = new Scanner(System.in);
                    while (true) {
                        if (sc.hasNextInt()) {
                            int in = sc.nextInt();
                            if (in < player.inventory.size() || in > 0) {
                                Item i = player.inventory.get(in);
                                i.use(player, enemy);
                            }
                            break;
                        } else {
                            System.out.println("⚠️ Invalid Input!");
                            sc.next(); // 把错误的输入清除
                        }
                    }
                }
            }
            else if (input == 3){
                System.out.println("Checking Your Skill……");
                System.out.println("=== Current Available Skills: ===");
                if(player.skills.isEmpty()){
                    System.out.println("Oops, Your Have No Skills");
                }
                for(int index = 0; index < player.skills.size(); index ++){
                    Skill thisSkill = player.skills.get(index);
                    if(thisSkill.useable()){
                        System.out.println("Press " + index + " For Using " + thisSkill.name);
                    }
                }
            }

            // 怪物回合
            if (enemy.getHp() > 0) {
                System.out.println("=== Enemy's Turn ===");
                int a = (int) (Math.random() * 10);
                if (a > 2) {
                    System.out.println("Enemy Attack!! Causing Damage: " + enemy.attack);
                    enemy.Attack(player);
                    System.out.println("Your Current HP: " + player.getHp());
                } else {
                    System.out.println("Enemy Healing! 2hp Recovered");
                    enemy.RegularRecover(2);
                    System.out.println("Enemy Remaining Hp: " + enemy.getHp());
                }
                // 直接调用

            }
            if(!player.skills.isEmpty()){
                for(int index = 0; index < player.skills.size(); index ++){
                    player.skills.get(index).update_rounds();
                }
            }
        }
        if (player.getHp() <= 0) {
            System.out.println("☠️YOU ARE DEAD☠️");
        } else {
            System.out.println("Enemy Defeated!!, 25 gold is added");
            player.addGold(25);
            System.out.println("Your Gold: " + player.gold);
            }
        }


        }
