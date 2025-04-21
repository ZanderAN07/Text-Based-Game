package MyGame;

public class Skill {
    String name;
    int cd;
    int rounds_needed;
    int AttackDamage;
    int RecoverValue;

    public Skill(String n, int c, int a, int r) {
        name = n;
        cd = c;
        AttackDamage = a;
        RecoverValue = r;
        rounds_needed = cd;
    }

    void use(Player p, Enemy e) {
        p.AddHP(RecoverValue);
        e.ReduceHP(AttackDamage);
    }
    void update_rounds(){
        if(rounds_needed > 0){
            rounds_needed -= 1;
        }
    }
    boolean useable(){
        return rounds_needed == 0;
    }
}
