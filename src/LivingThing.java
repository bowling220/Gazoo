import java.util.ArrayList;


class LivingThing {
    private String name;
    private int health;

    public LivingThing(String name, int health) {
        this(name, health, ConsoleColors.GREEN);
    }

    public LivingThing(String name, int health, String color) {
        setName(name);
        setHealth(health);
        setPieceColor(ConsoleColors.GREEN);
    }

    public void setName(String name) {
        name = name.trim(); 
        this.name = name.isEmpty() ? "undefined" : name;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }

    public void setPieceColor(String color) {

    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getConsoleStr() {
        return name.charAt(0) + "";
    }

}
