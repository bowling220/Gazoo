public class Monster extends LivingThing {
    private int damage;

    public Monster(String name, int health, String textColor, int damage) {
        super(name, health, textColor);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void hurt(LivingThing target) {
        int newHealth = target.getHealth() - damage;
        target.setHealth(newHealth);
    }
}