package MyGame;

public class RecoverItem extends Item{
    int NumRecover;
    public RecoverItem(String n, int c, int r){
        super(n, c);
        NumRecover = r;
    }
    public void use(Player p, Enemy e){
        p.AddHP(NumRecover);
        System.out.println(
                "\n>> You healed yourself\n" +
                        ">> 🧘‍♀️ Healed: " + NumRecover + "Hp" + "\n"
        );
    }
}
