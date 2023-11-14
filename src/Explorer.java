import java.util.ArrayList;

public class Explorer extends LivingThing {
    private ArrayList<Treasure> treasures;

    public Explorer(String name, int health) {
        super(name, health);
        treasures = new ArrayList<>();
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void addTreasure(Treasure treasure) {
        treasures.add(treasure);
    }

    public int getTreasureValue() {
        int totalValue = 0;
        for (Treasure treasure : treasures) {
            totalValue += treasure.getValue();
        }
        return totalValue;
    }
}