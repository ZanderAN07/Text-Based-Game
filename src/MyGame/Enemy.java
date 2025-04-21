package MyGame;

public class Enemy {
    String name;
    int hp, attack;
    int MaxHp;
    Enemy(String n, int h, int atk){
        name = n;
        MaxHp = h;
        hp = MaxHp;
        attack = atk;
    }
    int getHp(){
        return hp;
    }
    void ReduceHP(int r){
        hp -= r;
    }
    void RegularRecover(int r){
        int NewHp  = hp + r;
        if(NewHp >= MaxHp ){
            hp = MaxHp;
        }
        else{
            hp += r;
        }
    }
    void Attack(Player player){
        player.ReduceHP(attack);
    }
}
