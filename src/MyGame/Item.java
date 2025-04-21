package MyGame;

abstract class Item {
    String name;
    int value;
    public Item(String n, int v){
        name = n;
        value = v;
    }
    public abstract void use(Player p, Enemy e);
}

