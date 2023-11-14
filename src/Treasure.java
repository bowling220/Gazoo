public class Treasure {
    private int value;
    private String description;
    private boolean hidden;

    public Treasure(String description, int value) {
        this.description = description;
        this.value = value;
        this.hidden = true; // Treasure is hidden by default
    }

    public Treasure() {
        this("gold", 5);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getConsoleStr() {
        if (hidden) {
            return "?";
        } else {
            return ConsoleColors.YELLOW + description.charAt(0) + ConsoleColors.RESET; // Revealed treasure
        }
    }

}
