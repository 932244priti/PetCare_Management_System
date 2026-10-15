package com.petcare;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class PetCareSystem implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient Scanner sc = new Scanner(System.in);

    private ArrayList<PetOwner> owners =
            new ArrayList<PetOwner>();

    private ArrayList<Pet> pets =
            new ArrayList<Pet>();

    private ArrayList<Veterinarian> veterinarians =
            new ArrayList<Veterinarian>();

    private ArrayList<Appointment> appointments =
            new ArrayList<Appointment>();

    private ArrayList<Vaccination> vaccinations =
            new ArrayList<Vaccination>();

    private ArrayList<Treatment> treatments =
            new ArrayList<Treatment>();

    private int ownerId = 1;
    private int petId = 1;
    private int vetId = 1;
    private int appointmentId = 1;
    private int vaccinationId = 1;
    private int treatmentId = 1;

    private static final String DATA_FILE = "petcare.dat";

    // Arrays
    private String[] timeSlots = {
            "10:00 AM",
            "11:00 AM",
            "12:00 PM",
            "02:00 PM",
            "04:00 PM"
    };

    private String[] vaccineOptions = {
            "Rabies",
            "DHPP",
            "FVRCP",
            "Bordetella"
    };

    // Constructor
    public PetCareSystem() {

        sc = new Scanner(System.in);

        loadData();
    }

    // =====================================================
    // START
    // =====================================================

    public void start() {

        int choice = 0;

        do {

            displayMenu();

            String input = sc.nextLine().trim();

            try {

                if (input.isEmpty()) {

                    System.out.println(
                            "Please enter a choice.");

                    continue;
                }

                choice = Integer.parseInt(input);

                switch (choice) {

                case 1:
                    addOwner();
                    break;

                case 2:
                    viewOwners();
                    break;

                case 3:
                    addPet();
                    break;

                case 4:
                    viewPets();
                    break;

                case 5:
                    addVeterinarian();
                    break;

                case 6:
                    viewVeterinarians();
                    break;

                case 7:
                    bookAppointment();
                    break;

                case 8:
                    viewAppointments();
                    break;

                case 9:
                    addVaccination();
                    break;

                case 10:
                    viewVaccinations();
                    break;

                case 11:
                    addTreatment();
                    break;

                case 12:
                    viewTreatments();
                    break;

                case 13:

                    saveData();

                    System.out.println();
                    System.out.println(
                            "Thank you for using PetCare!");

                    System.out.println(
                            "All data has been saved.");

                    break;

                default:

                    System.out.println(
                            "Invalid choice! " +
                            "Enter 1 to 13.");
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter numbers only.");
            }

        } while (choice != 13);
    }

    // =====================================================
    // MENU
    // =====================================================

    private void displayMenu() {

        System.out.println();
        System.out.println(
                "========================================");

        System.out.println(
                "       PETCARE MANAGEMENT SYSTEM");

        System.out.println(
                "========================================");

        System.out.println("1.  Add Pet Owner");
        System.out.println("2.  View Pet Owners");
        System.out.println("3.  Add Pet");
        System.out.println("4.  View Pets");
        System.out.println("5.  Add Veterinarian");
        System.out.println("6.  View Veterinarians");
        System.out.println("7.  Book Appointment");
        System.out.println("8.  View Appointments");
        System.out.println("9.  Add Vaccination");
        System.out.println("10. View Vaccinations");
        System.out.println("11. Add Treatment");
        System.out.println("12. View Treatments");
        System.out.println("13. Exit");

        System.out.print("Enter your choice: ");
    }

    // =====================================================
    // OWNER
    // =====================================================

    private void addOwner() {

        System.out.println();
        System.out.println(
                "----- ADD PET OWNER -----");

        System.out.print("Enter Owner Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        PetOwner owner =
                new PetOwner(
                        ownerId++,
                        name,
                        phone,
                        email,
                        address
                );

        owners.add(owner);

        saveData();

        System.out.println(
                "Owner added successfully!");

        System.out.println(
                "Generated Owner ID: " +
                owner.getId());
    }

    private void viewOwners() {

        System.out.println();
        System.out.println(
                "----- PET OWNERS -----");

        if (owners.isEmpty()) {

            System.out.println(
                    "No owners available.");

            return;
        }

        for (PetOwner owner : owners) {

            owner.displayInfo();
        }
    }

    // =====================================================
    // PET
    // =====================================================

    private void addPet() {

        System.out.println();
        System.out.println(
                "----- ADD PET -----");

        try {

            System.out.print("Enter Pet Name: ");
            String name = sc.nextLine();

            if (name.trim().isEmpty()) {

                throw new InvalidPetException(
                        "Pet name cannot be empty.");
            }

            System.out.print(
                    "Enter Type (Dog/Cat/etc.): ");

            String type = sc.nextLine();

            System.out.print("Enter Breed: ");
            String breed = sc.nextLine();

            System.out.print("Enter Age: ");

            int age =
                    Integer.parseInt(sc.nextLine());

            if (age < 0) {

                throw new InvalidPetException(
                        "Age cannot be negative.");
            }

            System.out.print("Enter Gender: ");
            String gender = sc.nextLine();

            System.out.print(
                    "Enter Weight (kg): ");

            double weight =
                    Double.parseDouble(sc.nextLine());

            if (weight <= 0) {

                throw new InvalidPetException(
                        "Weight must be greater than 0.");
            }

            System.out.print("Enter Owner ID: ");

            int owner =
                    Integer.parseInt(sc.nextLine());

            if (!ownerExists(owner)) {

                throw new InvalidPetException(
                        "Owner ID does not exist.");
            }

            Pet pet =
                    new Pet(
                            petId++,
                            name,
                            type,
                            breed,
                            age,
                            gender,
                            weight,
                            owner
                    );

            pets.add(pet);

            saveData();

            System.out.println(
                    "Pet added successfully!");

            System.out.println(
                    "Generated Pet ID: " +
                    pet.getPetId());

        } catch (InvalidPetException e) {

            System.out.println(
                    "Error: " + e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter valid numbers.");
        }
    }

    private void viewPets() {

        System.out.println();
        System.out.println(
                "----- PET LIST -----");

        if (pets.isEmpty()) {

            System.out.println(
                    "No pets available.");

            return;
        }

        for (Pet pet : pets) {

            pet.displayInfo();
        }
    }

    // =====================================================
    // VETERINARIAN
    // =====================================================

    private void addVeterinarian() {

        System.out.println();
        System.out.println(
                "----- ADD VETERINARIAN -----");

        System.out.print(
                "Enter Veterinarian Name: ");

        String name = sc.nextLine();

        System.out.print("Enter Phone: ");

        String phone = sc.nextLine();

        System.out.print(
                "Enter Specialization: ");

        String specialization =
                sc.nextLine();

        Veterinarian vet =
                new Veterinarian(
                        vetId++,
                        name,
                        phone,
                        specialization
                );

        veterinarians.add(vet);

        saveData();

        System.out.println(
                "Veterinarian added successfully!");

        System.out.println(
                "Generated Vet ID: " +
                vet.getId());
    }

    private void viewVeterinarians() {

        System.out.println();
        System.out.println(
                "----- VETERINARIANS -----");

        if (veterinarians.isEmpty()) {

            System.out.println(
                    "No veterinarians available.");

            return;
        }

        for (Veterinarian vet :
                veterinarians) {

            vet.displayInfo();
        }
    }

    // =====================================================
    // APPOINTMENT
    // =====================================================

    private void bookAppointment() {

        System.out.println();
        System.out.println(
                "----- BOOK APPOINTMENT -----");

        try {

            System.out.print(
                    "Enter Pet ID: ");

            int pet =
                    Integer.parseInt(
                            sc.nextLine());

            if (!petExists(pet)) {

                System.out.println(
                        "Pet ID not found.");

                return;
            }

            System.out.print(
                    "Enter Veterinarian ID: ");

            int vet =
                    Integer.parseInt(
                            sc.nextLine());

            if (!vetExists(vet)) {

                System.out.println(
                        "Veterinarian ID not found.");

                return;
            }

            System.out.print(
                    "Enter Date: ");

            String date = sc.nextLine();

            System.out.println();
            System.out.println(
                    "Available Time Slots:");

            for (int i = 0;
                 i < timeSlots.length;
                 i++) {

                System.out.println(
                        (i + 1) + ". " +
                        timeSlots[i]);
            }

            System.out.print(
                    "Select Time Slot (1-5): ");

            int slot =
                    Integer.parseInt(
                            sc.nextLine());

            if (slot < 1 ||
                slot > timeSlots.length) {

                System.out.println(
                        "Invalid time slot.");

                return;
            }

            String time =
                    timeSlots[slot - 1];

            System.out.print(
                    "Enter Reason: ");

            String reason = sc.nextLine();

            Appointment appointment =
                    new Appointment(
                            appointmentId++,
                            pet,
                            vet,
                            date,
                            time,
                            reason
                    );

            appointments.add(appointment);

            saveData();

            System.out.println(
                    "Appointment booked successfully!");

        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter valid numbers.");
        }
    }

    private void viewAppointments() {

        System.out.println();
        System.out.println(
                "----- APPOINTMENTS -----");

        if (appointments.isEmpty()) {

            System.out.println(
                    "No appointments available.");

            return;
        }

        for (Appointment appointment :
                appointments) {

            appointment.displayInfo();
        }
    }

    // =====================================================
    // VACCINATION
    // =====================================================

    private void addVaccination() {

        System.out.println();
        System.out.println(
                "----- ADD VACCINATION -----");

        try {

            System.out.print(
                    "Enter Pet ID: ");

            int pet =
                    Integer.parseInt(
                            sc.nextLine());

            if (!petExists(pet)) {

                System.out.println(
                        "Pet ID not found.");

                return;
            }

            System.out.println();
            System.out.println(
                    "Available Vaccines:");

            for (int i = 0;
                 i < vaccineOptions.length;
                 i++) {

                System.out.println(
                        (i + 1) + ". " +
                        vaccineOptions[i]);
            }

            System.out.print(
                    "Select Vaccine (1-4): ");

            int choice =
                    Integer.parseInt(
                            sc.nextLine());

            if (choice < 1 ||
                choice > vaccineOptions.length) {

                System.out.println(
                        "Invalid vaccine choice.");

                return;
            }

            String vaccine =
                    vaccineOptions[choice - 1];

            System.out.print(
                    "Enter Vaccination Date: ");

            String date = sc.nextLine();

            System.out.print(
                    "Enter Next Due Date: ");

            String nextDate =
                    sc.nextLine();

            Vaccination vaccination =
                    new Vaccination(
                            vaccinationId++,
                            pet,
                            vaccine,
                            date,
                            nextDate
                    );

            vaccinations.add(vaccination);

            saveData();

            System.out.println(
                    "Vaccination added successfully!");

        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter valid numbers.");
        }
    }

    private void viewVaccinations() {

        System.out.println();
        System.out.println(
                "----- VACCINATIONS -----");

        if (vaccinations.isEmpty()) {

            System.out.println(
                    "No vaccination records.");

            return;
        }

        for (Vaccination vaccination :
                vaccinations) {

            vaccination.displayInfo();
        }
    }

    // =====================================================
    // TREATMENT
    // =====================================================

    private void addTreatment() {

        System.out.println();
        System.out.println(
                "----- ADD TREATMENT -----");

        try {

            System.out.print(
                    "Enter Pet ID: ");

            int pet =
                    Integer.parseInt(
                            sc.nextLine());

            if (!petExists(pet)) {

                System.out.println(
                        "Pet ID not found.");

                return;
            }

            System.out.print(
                    "Enter Veterinarian ID: ");

            int vet =
                    Integer.parseInt(
                            sc.nextLine());

            if (!vetExists(vet)) {

                System.out.println(
                        "Veterinarian ID not found.");

                return;
            }

            System.out.print(
                    "Enter Diagnosis: ");

            String diagnosis =
                    sc.nextLine();

            System.out.print(
                    "Enter Medicine: ");

            String medicine =
                    sc.nextLine();

            System.out.print(
                    "Enter Treatment Date: ");

            String date =
                    sc.nextLine();

            Treatment treatment =
                    new Treatment(
                            treatmentId++,
                            pet,
                            vet,
                            diagnosis,
                            medicine,
                            date
                    );

            treatments.add(treatment);

            saveData();

            System.out.println(
                    "Treatment added successfully!");

        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter valid numbers.");
        }
    }

    private void viewTreatments() {

        System.out.println();
        System.out.println(
                "----- TREATMENTS -----");

        if (treatments.isEmpty()) {

            System.out.println(
                    "No treatment records.");

            return;
        }

        for (Treatment treatment :
                treatments) {

            treatment.displayInfo();
        }
    }

    // =====================================================
    // CHECK METHODS
    // =====================================================

    private boolean ownerExists(int id) {

        for (PetOwner owner : owners) {

            if (owner.getId() == id) {

                return true;
            }
        }

        return false;
    }

    private boolean petExists(int id) {

        for (Pet pet : pets) {

            if (pet.getPetId() == id) {

                return true;
            }
        }

        return false;
    }

    private boolean vetExists(int id) {

        for (Veterinarian vet :
                veterinarians) {

            if (vet.getId() == id) {

                return true;
            }
        }

        return false;
    }

    // =====================================================
    // SAVE ALL DATA
    // =====================================================

    private void saveData() {

        try {

            FileOutputStream file =
                    new FileOutputStream(DATA_FILE);

            ObjectOutputStream output =
                    new ObjectOutputStream(file);

            output.writeObject(this);

            output.close();
            file.close();

        } catch (IOException e) {

            System.out.println(
                    "Error while saving data.");

            e.printStackTrace();
        }
    }

    // =====================================================
    // LOAD ALL DATA
    // =====================================================

    private void loadData() {

        try {

            FileInputStream file =
                    new FileInputStream(DATA_FILE);

            ObjectInputStream input =
                    new ObjectInputStream(file);

            PetCareSystem savedSystem =
                    (PetCareSystem) input.readObject();

            this.owners = savedSystem.owners;
            this.pets = savedSystem.pets;
            this.veterinarians =
                    savedSystem.veterinarians;
            this.appointments =
                    savedSystem.appointments;
            this.vaccinations =
                    savedSystem.vaccinations;
            this.treatments =
                    savedSystem.treatments;

            this.ownerId =
                    savedSystem.ownerId;

            this.petId =
                    savedSystem.petId;

            this.vetId =
                    savedSystem.vetId;

            this.appointmentId =
                    savedSystem.appointmentId;

            this.vaccinationId =
                    savedSystem.vaccinationId;

            this.treatmentId =
                    savedSystem.treatmentId;

            input.close();
            file.close();

            System.out.println(
                    "✓ Previous data loaded successfully.");

        } catch (IOException e) {

            System.out.println(
                    "No previous data found.");
            System.out.println(
                    "Starting new PetCare system.");

        } catch (ClassNotFoundException e) {

            System.out.println(
                    "Saved data format is invalid.");

        } finally {

            sc = new Scanner(System.in);
        }
    }
}