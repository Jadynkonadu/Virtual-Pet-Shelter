package pets_amok;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelterApplication {

    public static VirtualPet initializePet(String name, String species) {
        PetType petType = (Math.random() < 0.5) ? PetType.ORGANIC : PetType.ROBOTIC;

        return new VirtualPet(name,
                1 + (int) (Math.random() * 50),
                1 + (int) (Math.random() * 50),
                1 + (int) (Math.random() * 50),
                1 + (int) (Math.random() * 50),
                1 + (int) (Math.random() * 50),
                species,
                (int) (1 + Math.random() * 100),
                petType,
                1 + (int) (Math.random() * 50));
    }

    public static void main(String[] args) {
        // Intro
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println(
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> WELCOME TO VIRTUAL PET SHELTER <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("");
        System.out.println(
                ">> In this game, you will take care of a variety of pets as well as adopt and interact with each individual");
        System.out.println(">> There are two pet species available in this game: Dogs and Cats");
        System.out.println(">> As well as two different types: Organic and Robotic");
        System.out.println(">> Both the Species and Type of pet will strongly affect your game-play");
        System.out.println(
                ">> Pay CLOSE attention to the prompts as you navigate the terminal and you'll definetely succeed at keeping all your pets both happy & healthy");
        System.out.println("");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> CURRENT PETS IN THE SHELTER <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------");
        // HashMap
        Map<String, VirtualPet> petData = new HashMap<>();
        petData.put("Milo", initializePet("Milo", "Cat"));
        petData.put("Hazel", initializePet("Hazel", "Dog"));
        petData.put("Luna", initializePet("Luna", "Dog"));
        petData.put("Caprica", initializePet("Caprica", "Dog"));

        // Shelter Header Format
        System.out.format("%-10s | %-8s | %-7s | %-8s | %-8s | %-8s | %-8s | %-8s | %-15s | %-8s | %-10s%n",
                "Name", "Species", "Type", "Hunger", "Thirst", "Waste", "Boredom", "Sickness", "Cage Filth", "Health",
                "Oil Levels");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------");
        // Print Pet Shelter
        for (VirtualPet pet : petData.values()) {
            int health = VirtualPetShelter.calculateHealth(pet);

            String hungerDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--" : String.valueOf(pet.getHunger());
            String thirstDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--" : String.valueOf(pet.getThirst());
            String wasteDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--" : String.valueOf(pet.getWaste());
            String sicknessDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--" : String.valueOf(pet.getSickness());
            String cageCleanlinessDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                    : String.valueOf(pet.getCageCleanliness());
            String maintenanceDisplay = (pet.getPetType() == PetType.ORGANIC) ? "--"
                    : String.valueOf(pet.getMaintenance());

            System.out.format("%-10s | %-8s | %-7s | %-8s | %-8s | %-8s | %-8d | %-8s | %-15s | %-8d | %-10s%n",
                    pet.getName(), pet.getSpecies(), pet.getPetType(), hungerDisplay, thirstDisplay,
                    wasteDisplay, pet.getBoredom(), sicknessDisplay, cageCleanlinessDisplay, health,
                    maintenanceDisplay);
        }

        // Main Menu
        do {
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("1. Add pet to the shelter");
            System.out.println("2. Remove pet from shelter");
            System.out.println("3. Interact with an organic pet");
            System.out.println("4. Interact with a robotic pet");
            System.out.println("5. Show Pets in Shelter");
            System.out.println("6. Give all pets a treat");
            System.out.println("7. Refill all pets water");
            System.out.println("8. Take all pets out to potty");
            System.out.println("9. Play with all pets");
            System.out.println("10. Take all pets to the vet");
            System.out.println("11. Clean all cages");
            System.out.println("12. Perform maintenance on Robotic pets");
            System.out.println("0. Quit");
            System.out.println("-----------------------------------------------------");
            choice = input.nextInt();

            // Add Pet
            if (choice == 1) {
                System.out.println("Enter the name of the new pet:");
                String petName = input.next();
                System.out.println("-----------------------------------------------------");
            
                PetType petType;
            
                // Get the type of the new pet
                String type;
                do {
                    System.out.println("Enter the type (Dog/Cat) of the new pet:");
                    type = input.next();
                    if (type.equalsIgnoreCase("Dog")) {
                        petType = (Math.random() < 0.5) ? PetType.ORGANIC : PetType.ROBOTIC;
                        break;
                    } else if (type.equalsIgnoreCase("Cat")) {
                        petType = (Math.random() < 0.5) ? PetType.ORGANIC : PetType.ROBOTIC;
                        break;
                    } else {
                        System.out.println("Sorry, please enter a valid pet type (Dog or Cat).");
                    }
                } while (true);
            
                if (petData.containsKey(petName)) {
                    System.out.println(petName + " already exists in this shelter");
                } else {
                    int hunger = 1 + (int) (Math.random() * 50);
                    int thirst = 1 + (int) (Math.random() * 50);
                    int waste = 1 + (int) (Math.random() * 50);
                    int boredom = 1 + (int) (Math.random() * 50);
                    int sickness = 1 + (int) (Math.random() * 50);
                    int health = 1 + (int) (Math.random() * 50);
                    int maintenance = 1 + (int) (Math.random() * 50);
                    VirtualPet newPet = new VirtualPet(petName, hunger, thirst, waste, boredom, sickness, type, health, petType, maintenance);
                    petData.put(petName, newPet);
                    System.out.println("-----------------------------------------------------");
                    System.out.println(petName + " has been added to the shelter!");
                    System.out.println("-----------------------------------------------------");
                    System.out.format("%-10s | %-8s | %-7s | %-8s | %-8s | %-8s | %-8s | %-8s | %-15s | %-8s | %-10s%n",
                            "Name", "Species", "Type", "Hunger", "Thirst", "Waste", "Boredom", "Sickness", "Cage Filth",
                            "Health",
                            "Oil Levels");
                    System.out.println(
                            "----------------------------------------------------------------------------------------------------------------------");


                    for (VirtualPet pet : petData.values()) {
                        int hp = VirtualPetShelter.calculateHealth(pet);

                        String hungerDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                                : String.valueOf(pet.getHunger());
                        String thirstDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                                : String.valueOf(pet.getThirst());
                        String wasteDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                                : String.valueOf(pet.getWaste());
                        String sicknessDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                                : String.valueOf(pet.getSickness());
                        String cageCleanlinessDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                                : String.valueOf(pet.getCageCleanliness());
                        String maintenanceDisplay = (pet.getPetType() == PetType.ORGANIC) ? "--"
                                : String.valueOf(pet.getMaintenance());

                        System.out.format(
                                "%-10s | %-8s | %-7s | %-8s | %-8s | %-8s | %-8d | %-8s | %-15s | %-8d | %-10s%n",
                                pet.getName(), pet.getSpecies(), pet.getPetType(), hungerDisplay, thirstDisplay,
                                wasteDisplay, pet.getBoredom(), sicknessDisplay, cageCleanlinessDisplay, hp,
                                maintenanceDisplay);
                    }

                }
            }

            // Remove Pet
            else if (choice == 2) {
                System.out.println("Choose the pet to remove");
                String petName = input.next();
                if (!petData.containsKey(petName)) {
                    System.out.println("-----------------------------------------------------");
                    System.out.println("This pet doesn't live in this shelter");
                } else if (petData.containsKey(petName)) {
                    petData.remove(petName);
                    System.out.println("-----------------------------------------------------");
                    System.out.println(petName + " has been removed from the shelter!");
                    System.out.println("--------------------------------------------------------");
                    System.out.format("%-10s | %-8s | %-7s | %-8s | %-8s | %-8s | %-8s | %-8s | %-15s | %-8s | %-10s%n",
                            "Name", "Species", "Type", "Hunger", "Thirst", "Waste", "Boredom", "Sickness", "Cage Filth",
                            "Health",
                            "Oil Levels");
                    System.out.println(
                            "----------------------------------------------------------------------------------------------------------------------");
                    for (VirtualPet pet : petData.values()) {
                        int health = VirtualPetShelter.calculateHealth(pet);

                        String hungerDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                                : String.valueOf(pet.getHunger());
                        String thirstDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                                : String.valueOf(pet.getThirst());
                        String wasteDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                                : String.valueOf(pet.getWaste());
                        String sicknessDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                                : String.valueOf(pet.getSickness());
                        String cageCleanlinessDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                                : String.valueOf(pet.getCageCleanliness());
                        String maintenanceDisplay = (pet.getPetType() == PetType.ORGANIC) ? "--"
                                : String.valueOf(pet.getMaintenance());

                        System.out.format(
                                "%-10s | %-8s | %-7s | %-8s | %-8s | %-8s | %-8d | %-8s | %-15s | %-8d | %-10s%n",
                                pet.getName(), pet.getSpecies(), pet.getPetType(), hungerDisplay, thirstDisplay,
                                wasteDisplay, pet.getBoredom(), sicknessDisplay, cageCleanlinessDisplay, health,
                                maintenanceDisplay);
                    }
                }
            }

            // Select an Organic Pet to Interact With
            else if (choice == 3) {
                // Interaction Menu DO/While Loop
                do {
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Pick a pet to interact with: ");
                    System.out.println(">>");
                    for (Map.Entry<String, VirtualPet> entry : petData.entrySet()) {
                        System.out.println(entry.getKey());
                    }
                    System.out.println("-----------------------------------------------------");
                    String selectedPet = input.next();

                    // Check if Pet exists in Shelter
                    if (petData.containsKey(selectedPet)) {
                        VirtualPet selectedPetData = petData.get(selectedPet);

                        // Check if Pet is Organic
                        if (selectedPetData.getPetType() == PetType.ORGANIC) {
                            // Interact with Singular Pet
                            do {
                                System.out.println("--------------------------");
                                System.out.println("Pet Status");
                                System.out.println(">>");
                                VirtualPetShelter.showPetNeeds(selectedPetData);
                                System.out.println("");
                                System.out.println("---------------------------");
                                System.out.println("What would you like to do?");
                                System.out.println("1. Give " + selectedPet + " a treat");
                                System.out.println("2. Refill " + selectedPet + "'s water");
                                System.out.println("3. Play with " + selectedPet);
                                System.out.println("4. Take " + selectedPet + " out to potty");
                                System.out.println("5. Take " + selectedPet + " to the vet");
                                System.out.println("6. Clean " + selectedPet + "'s cage");
                                System.out.println("7. Pass time");
                                System.out.println("0. Back to main menu");
                                System.out.println("--------------------------");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    if (selectedPetData.getHunger() > 30) {
                                        System.out.println(">> " + selectedPet + " isn't hungry!");
                                    } else {
                                        System.out.println(">> " + selectedPet + " loved the treat!");
                                        selectedPetData.updateHunger(+1);
                                        selectedPetData.updateThirst(-1);
                                        selectedPetData.updateWaste(+2);
                                        selectedPetData.updateBoredom(-1);
                                        selectedPetData.updateSicknessRandom(+1);
                                    }
                                } else if (choice == 2) {
                                    if (selectedPetData.getThirst() > 30) {
                                        System.out.println(">> " + selectedPet + " isn't thirsty!");
                                    } else {
                                        System.out.println(">> " + selectedPet + "'s thirst is quenched!");
                                        selectedPetData.updateThirst(+1);
                                        selectedPetData.updateWaste(+1);
                                        selectedPetData.updateSicknessRandom(+1);
                                    }
                                } else if (choice == 3) {
                                    if (selectedPetData.getBoredom() < 30) {
                                        System.out.println(">> " + selectedPet + " doesn't want to play!");
                                    } else {
                                        System.out.println(">> " + selectedPet + " loved playing with you!");
                                        selectedPetData.updateThirst(-2);
                                        selectedPetData.updateHunger(-1);
                                        selectedPetData.updateBoredom(-2);
                                        selectedPetData.updateSicknessRandom(+1);
                                    }
                                } else if (choice == 4) {
                                    if (selectedPetData.getPetType() == PetType.ORGANIC) {
                                        if (selectedPetData.getSpecies().equalsIgnoreCase("Dog")) {
                                            if (selectedPetData.getWaste() < 25) {
                                                System.out.println(">> " + selectedPet + " doesn't want to potty");
                                            } else {
                                                System.out.println(">> " + selectedPet + " needed that bathroom break!");
                                                selectedPetData.updateHunger(-2);
                                                selectedPetData.updateWaste(-3);
                                                selectedPetData.updateSicknessRandom(+1);
                                            }
                                        } else if (selectedPetData.getSpecies().equalsIgnoreCase("Cat")) {
                                            System.out.println("Silly, Cats can't be taken on a walk!!!");
                                        }
                                    }
                                } else if (choice == 5) {
                                    if (selectedPetData.getSickness() < 30) {
                                        System.out.println(">> " + selectedPet + " is in good health!");
                                    } else {
                                        System.out.println(
                                                ">> " + selectedPet + " is feeling better after going to the vet!");
                                        selectedPetData.updateSickness(-3);
                                    }
                                } else if (choice == 6) {
                                    VirtualPetShelter.manageCages(petData);
                                    System.out.println(selectedPet + "'s cage has been cleaned!");
                                } else if (choice == 7) {
                                    selectedPetData.tick();
                                } else if (choice == 0) {
                                    System.out.println("--------------------------");
                                    System.out.println(selectedPet + " couldn't ask for a better owner!!!");
                                    break;
                                } else {
                                    System.out.println(">> " + "Please choose something to do with " + selectedPet);
                                }
                                // Update pet health
                                int updatedHealth = VirtualPetShelter.calculateHealth(selectedPetData);
                                selectedPetData.setHealth(updatedHealth);
                                // Remove pet
                                if (updatedHealth <= 0) {
                                    System.out.println(selectedPetData.getName() + " has unfortunately passed away...");
                                    petData.remove(selectedPetData.getName());
                                    break;
                                }
                            } while (true);
                        } else {
                            System.out.println("-----------------------------------------------------");
                            System.out.println(
                                    selectedPet + " is not an organic pet and cannot be interacted with in this way.");
                            break;
                        }
                    } else {
                        System.out.println("The selected pet doesn't live in this shelter");
                    }
                } while (true);
            }
            // Select a Robotic Pet to Interact With
            else if (choice == 4) {
                // Interaction Menu DO/While Loop
                do {
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Pick a pet to interact with: ");
                    System.out.println(">>");
                    for (Map.Entry<String, VirtualPet> entry : petData.entrySet()) {
                        System.out.println(entry.getKey());
                    }
                    System.out.println("-----------------------------------------------------");
                    String selectedPet = input.next();

                    // Check if Pet exists in Shelter
                    if (petData.containsKey(selectedPet)) {
                        VirtualPet selectedPetData = petData.get(selectedPet);

                        // Check if Pet is Robotic
                        if (selectedPetData.getPetType() == PetType.ROBOTIC) {
                            // Interact with Singular Pet
                            do {
                                System.out.println("--------------------------");
                                System.out.println("Pet Status");
                                System.out.println(">>");
                                VirtualPetShelter.showPetMaintenance(selectedPetData);
                                System.out.println("");
                                System.out.println("---------------------------");
                                System.out.println("What would you like to do?");
                                System.out.println("1. Oil " + selectedPet);
                                System.out.println("2. Pass time");
                                System.out.println("0. Back to main menu");
                                System.out.println("--------------------------");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    if (selectedPetData.getMaintenance() > 80) {
                                        System.out.println(">> " + selectedPet + " doesn't need maintenance");
                                    } else {
                                        System.out.println(">> " + selectedPet + " has undergone successful maintenance");
                                        selectedPetData.updateMaintenance(+3);
                                    }
                                } else if (choice == 2) {
                                    selectedPetData.tick();
                                } else if (choice == 0) {
                                    System.out.println("--------------------------");
                                    System.out.println(selectedPet + " couldn't ask for a better owner!!!");
                                    break;
                                } else {
                                    System.out.println(">> " + "Please choose something to do with " + selectedPet);
                                }
                                // Update pet health
                                int updatedHealth = VirtualPetShelter.calculateHealth(selectedPetData);
                                selectedPetData.setHealth(updatedHealth);
                                // Remove pet
                                if (updatedHealth <= 0) {
                                    System.out.println(
                                            selectedPetData.getName() + " has unfortunately stopped functioning...");
                                    petData.remove(selectedPetData.getName());
                                    break;
                                }
                            } while (true);
                        } else {
                            System.out.println("-----------------------------------------------------");
                            System.out.println(
                                    selectedPet + " is not a robotic pet and cannot be interacted with in this way.");
                            break;
                        }
                    } else {
                        System.out.println("The selected pet doesn't live in this shelter");
                    }
                } while (true);
            }

            // Show pets in Shelter
            else if (choice == 5) {
                System.out.println(
                        "----------------------------------------------------------------------------------------------------------------------");
                System.out.println(
                        ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> CURRENT PETS IN THE SHELTER <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println(
                        "----------------------------------------------------------------------------------------------------------------------");
                System.out.format("%-10s | %-8s | %-7s | %-8s | %-8s | %-8s | %-8s | %-8s | %-15s | %-8s | %-10s%n",
                        "Name", "Species", "Type", "Hunger", "Thirst", "Waste", "Boredom", "Sickness", "Cage Filth",
                        "Health",
                        "Oil Levels");
                System.out.println(
                        "----------------------------------------------------------------------------------------------------------------------");
                for (VirtualPet pet : petData.values()) {
                    int health = VirtualPetShelter.calculateHealth(pet);

                    String hungerDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                            : String.valueOf(pet.getHunger());
                    String thirstDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                            : String.valueOf(pet.getThirst());
                    String wasteDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--" : String.valueOf(pet.getWaste());
                    String sicknessDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                            : String.valueOf(pet.getSickness());
                    String cageCleanlinessDisplay = (pet.getPetType() == PetType.ROBOTIC) ? "--"
                            : String.valueOf(pet.getCageCleanliness());
                    String maintenanceDisplay = (pet.getPetType() == PetType.ORGANIC) ? "--"
                            : String.valueOf(pet.getMaintenance());

                    System.out.format("%-10s | %-8s | %-7s | %-8s | %-8s | %-8s | %-8d | %-8s | %-15s | %-8d | %-10s%n",
                            pet.getName(), pet.getSpecies(), pet.getPetType(), hungerDisplay, thirstDisplay,
                            wasteDisplay, pet.getBoredom(), sicknessDisplay, cageCleanlinessDisplay, health,
                            maintenanceDisplay);
                }

            }

            // Interact with all pets
            else if (choice == 6) {
                System.out.println("--------------------------------------------------------");
                System.out.println("All pets loved the treat");
                for (Map.Entry<String, VirtualPet> entry : petData.entrySet()) {
                    VirtualPet pet = entry.getValue();
                    // pet.tick();
                    pet.updateHunger(+1);
                    pet.updateThirst(-1);
                    pet.updateWaste(+2);
                    pet.updateBoredom(-1);
                    pet.updateSicknessRandom(+1);
                }
            }

            else if (choice == 7) {
                System.out.println("--------------------------------------------------------");
                System.out.println("All pets have been given a bowl of water");
                for (Map.Entry<String, VirtualPet> entry : petData.entrySet()) {
                    VirtualPet pet = entry.getValue();
                    pet.updateThirst(+2);
                    pet.updateWaste(+1);
                    pet.updateSicknessRandom(+1);
                }
            }

            else if (choice == 8) {
                System.out.println("--------------------------------------------------------");
                System.out.println("All pets have been taken out to potty");
                for (Map.Entry<String, VirtualPet> entry : petData.entrySet()) {
                    VirtualPet pet = entry.getValue();
                    pet.updateHunger(-2);
                    pet.updateWaste(-3);
                    pet.updateSicknessRandom(+1);

                }
            }

            else if (choice == 9) {
                System.out.println("--------------------------------------------------------");
                System.out.println("All pets engaged in a fun game of fetch!");
                for (Map.Entry<String, VirtualPet> entry : petData.entrySet()) {
                    VirtualPet pet = entry.getValue();
                    pet.updateThirst(-2);
                    pet.updateHunger(-1);
                    pet.updateBoredom(-2);
                    pet.updateSicknessRandom(+1);

                }
            } else if (choice == 10) {
                System.out.println("--------------------------------------------------------");
                System.out.println("The vet visited the shelter to give all pets a checkup");
                for (Map.Entry<String, VirtualPet> entry : petData.entrySet()) {
                    VirtualPet pet = entry.getValue();
                    pet.updateSickness(-3);
                }
            } else if (choice == 11) {
                VirtualPetShelter.manageCages(petData);
                System.out.println("Cages have been cleaned! All pet sickness and health statuses have been updated");
            } else if (choice == 12) {
                System.out.println("--------------------------------------------------------");
                System.out.println("Maintenance was performed on all robotic pets. Oil levels increased");
                for (Map.Entry<String, VirtualPet> entry : petData.entrySet()) {
                    VirtualPet pet = entry.getValue();
                    if (pet.getPetType() == PetType.ROBOTIC) {

                        pet.updateMaintenance(+5);
                    }
                }
            }
            // Quit Application
            else if (choice == 0) {
                System.out.println("--------------------------------------------------------");
                System.out.println("Thanks for visiting the Shelter!");
                break;
            } else {
                System.out.println("--------------------------------------------------------");
                System.out.println("Invalid choice. Please choose a number between 1 - 5");
            }
        } while (true);

        input.close();
    }
}

 