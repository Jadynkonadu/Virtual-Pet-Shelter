package pets_amok;

public class VirtualPet {
    // Variables
    private String name;
    private int hunger;
    private int thirst;
    private int waste;
    private int boredom;
    private int sickness;
    private String species;
    private int health;
    private int cageCleanliness;
    private PetType petType;
    private int maintenance;


    // Constructor
    public VirtualPet(String name, int hunger, int thirst, int waste, int boredom, int sickness, String species, int health, PetType petType, int maintenance) {
        this.name = name;
        this.hunger = hunger;
        this.thirst = thirst;
        this.waste = waste;
        this.boredom = boredom;
        this.sickness = sickness;
        this.species = species;
        this.health = health;
        this.cageCleanliness = 50;
        this.petType = petType;
        this.maintenance = maintenance;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getWaste() {
        return waste;
    }

    public void setWaste(int waste) {
        this.waste = waste;
    }

    public int getBoredom() {
        return boredom;
    }

    public void setBoredom(int boredom) {
        this.boredom = boredom;
    }

    public int getSickness() {
        return sickness;
    }

    public void setSickness(int sickness) {
        this.sickness = sickness;
    }
    
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCageCleanliness(){
        return cageCleanliness;
    }

    public void setCageCleanliness(int cageCleanliness){
        this.cageCleanliness = cageCleanliness;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType (PetType petType) {
        this.petType = petType;
    }

        public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    // Tick Method
    public void tick() {
        hunger += 1 + (int) (Math.random() * 50);
        thirst += 1 + (int) (Math.random() * 50);
        waste += 1 + (int) (Math.random() * 50);
        boredom += 1 + (int) (Math.random() * 50);
        sickness += 1 + (int) (Math.random() * 50);
        health += 1 + (int) (Math.random() * 100);
        cageCleanliness += 1 + (int) (Math.random() * 20);
        maintenance +=1 + (int) (Math.random() * 50);
    }

    // Status Update Methods
    public void updateHunger(int h) {
        hunger += h;
        if (hunger <= 0) {
            hunger = 0;
        }
    }

    public void updateThirst(int t) {
        thirst += t;
        if (thirst <= 0) {
            thirst = 0;
        }
    }

    public void updateWaste(int w) {
        waste += w;
        if (waste <= 0) {
            waste = 0;
        }
    }

    public void updateBoredom(int b) {
        boredom += b;
        if (boredom <= 0) {
            boredom = 0;
        }
    }

    public void updateSickness(int s) {
        sickness += s;
        if (sickness <= 0) {
            sickness = 0;
        }
    }

    public void updateMaintenance(int m) {
        maintenance += m;
        if (maintenance <= 0) {
            maintenance = 0;
        }
    }

    public void updateSicknessRandom(int sr) {
        int sicknessUpdate = 1 + (int) (Math.random() * 20);
        sickness = Math.max(0, sickness + sicknessUpdate);
    }
    // Pet Health Method
    public static int calculateHealth(VirtualPet pet) {
        int sickness = pet.getSickness();

        int calculatedHealth = 100 - (sickness / 2);
        if (calculatedHealth < 0) {
            calculatedHealth = 0;
        }

        return calculatedHealth;
    }
}

