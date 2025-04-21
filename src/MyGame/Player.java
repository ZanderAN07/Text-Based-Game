package MyGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    int hp;
    int maxHp;
    int attack;
    int defense;
    int gold;
    ArrayList<Item> inventory;
    ArrayList<Skill> skills;
    public Player(){
        hp = 1;
        maxHp = 10;
        attack = 2;
        defense = 2;
        gold = 100;
        inventory = new ArrayList<>();
        skills = new ArrayList<Skill>();
    }
    public void ReduceHP(int lostHP){
        int r = defense - lostHP;
        if(r < 0){
            hp += r;
        }
    }

    void Attack(Enemy enemy){
        enemy.ReduceHP(attack);
    }
    public int getHp(){
        return hp;
    }
    public void AddHP(int add){
        int Newhp = hp + add;
        hp = Math.min(Newhp, maxHp);
    }
    public void addMaxHP(int add){
        maxHp += add;
    }
    public void addDefense(int add){
        defense += add;
    }
    public void addGold(int add){
        gold += add;
    }
    public void ReduceGold(int r){
        gold -= r;
    }

}
