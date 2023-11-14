public class Space {
    private LivingThing occupant;
    private Treasure cache;

    public Space() {
        this.occupant = null;
        this.cache = null;
    }

    public Space(LivingThing occupant) {
        this.occupant = occupant;
        this.cache = null;
    }

    public Space(Treasure cache) {
        this.occupant = null;
        this.cache = cache;
    }

    public LivingThing getOccupant() {
        return occupant;
    }

    public void setOccupant(LivingThing occupant) {
        this.occupant = occupant;
    }

    public Treasure getCache() {
        return cache;
    }

    public void setCache(Treasure cache) {
        this.cache = cache;
    }

    public String getConsoleStr() {
        if (occupant == null) {
            return (cache != null) ? cache.getConsoleStr() : "-";
        } else {
            return occupant.getConsoleStr();
        }
    }

    public String getConsoleStr(boolean reveal) {
        if (reveal) {
            if (cache != null) {
                return cache.getConsoleStr();
            } else if (occupant != null) {
                return occupant.getConsoleStr();
            } else {
                return "-";
            }
        } else {
            if (occupant != null && occupant instanceof Explorer) {
                return occupant.getConsoleStr();
            } else {
                return "-";
            }
        }
    }
}
