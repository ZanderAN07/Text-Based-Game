package MyGame;

public class AttackItem extends Item {
    int AtkValue;

    public AttackItem(String n, int c, int a) {
        super(n, c);
        AtkValue = a;
    }
    public void use(Player p, Enemy e){
        e.hp -= AtkValue;
        System.out.println(
                "\n>> You attacked the enemy!\n" +
                        ">> 💥 Damage Dealt: " + AtkValue + "\n" +
                        ">> 🩸 Enemy Remaining HP: " + e.getHp()
        );
    }
}
