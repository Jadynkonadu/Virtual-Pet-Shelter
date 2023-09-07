package pets_amok;

import java.util.Map;

public class VirtualPetShelter {
// Pet Needs Method
public static void showPetNeeds(VirtualPet selectedPet) {
    System.out.println("Name: " + selectedPet.getName());
    System.out.println("Hunger: " + selectedPet.getHunger());
    System.out.println("Thirst: " + selectedPet.getThirst());
    System.out.println("Waste: " + selectedPet.getWaste());
    System.out.println("Boredom: " + selectedPet.getBoredom());
    System.out.println("Sickness: " + selectedPet.getSickness());
    System.out.println("Health: " + calculateHealth(selectedPet));
    System.out.println(("Cage Filth: " + selectedPet.getCageCleanliness()));
}

  // Pet Maintenance Method
    public static void showPetMaintenance(VirtualPet selectedPet) {
    System.out.println("Name: " + selectedPet.getName());
    System.out.println("Oil Levels: " + selectedPet.getMaintenance());
    System.out.println("Health: " + calculateHealth(selectedPet));
    System.out.println(("Maintenance: " + selectedPet.getCageCleanliness()));
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

     // Cage Method
    public static void manageCages(Map<String, VirtualPet> petData) {
        for (VirtualPet pet : petData.values()) {
            int waste = pet.getWaste();
            int cageCleanliness = pet.getCageCleanliness();

            if (waste >= 25) {
                cageCleanliness -= (pet.getCageCleanliness() / 2);
                pet.updateSickness(+2);
            } else {
                cageCleanliness += 1;
            }
            pet.setCageCleanliness(cageCleanliness);
        }
    }
}
