import java.util.ArrayList;
class Healer extends LivingThing {
    private int healValue;
    private ArrayList<LivingThing> healed;
    public Healer(String name, int health, int textColor, int healValue) {
        super(name, health, String.valueOf(textColor));
        this.healValue = healValue;
        this.healed = new ArrayList<LivingThing>();
    }

    public int getHealValue() {
        return healValue;
    }

    public void Heal(LivingThing target) {
        int currentHealth = target.getHealth();
        target.setHealth(currentHealth + healValue);
        healed.add(target);
    }
}