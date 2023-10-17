package com.rv;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rv.entities.Medecin;
import com.rv.entities.Patient;
import com.rv.repositories.bd.Database;

public class Main {
    public static void main(String[] args) {
        Database database = new MySqlDatabase("jdbc:mysql://localhost:3306/rv_db", "your_username", "your_password");
        PatientRepository patientRepository = new PatientRepository(database);
        MedecinRepository medecinRepository = new MedecinRepository(database);

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createPatient(scanner, patientRepository);
                    break;
                case 2:
                    createMedecin(scanner, medecinRepository);
                    break;
                
                case 7:
                    System.out.println("Aurevoir!");
                    break;
                default:
                    System.out.println("Choix invalide,reesayer");
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Cree un Patient");
        System.out.println("2. Cree un Medecin");
        System.out.println("3-planifier un rendez vous");
        System.out.println("4-Afficher les rendez vous du jour");
        System.out.println("5-Affichez les rendez vous d'un medecin par jour");
        System.out.println("6-Annuler un rendez vous");
        System.out.println("7. Quittter");
        System.out.print("Enter your choice: ");
    }

    private static void createPatient(Scanner scanner, PatientRepository patientRepository) {
        System.out.print("Entrer nom ");
        String name = scanner.nextLine();

        System.out.print("Entrer prenom ");
        String surname = scanner.nextLine();

        System.out.print("Entrer antecedent: ");
        String antecedent = scanner.nextLine();

        Patient patient = new Patient(name, surname, antecedent);
        patientRepository.createPatient(patient);
        System.out.println("Patient creer avec succes");
    }

    private static void createMedecin(Scanner scanner, MedecinRepository medecinRepository) {
        System.out.print("Entrer nom: ");
        String name = scanner.nextLine();

        System.out.print("Entrer prenom: ");
        String surname = scanner.nextLine();

        System.out.print("Entrer specialites : ");
        String specialitiesInput = scanner.nextLine();
        List<String> specialities = new ArrayList<>();
        for (String speciality : specialitiesInput.split(",")) {
            specialities.add(speciality.trim());
        }

        Medecin medecin = new Medecin(name, surname, specialities);
        medecinRepository.createMedecin(medecin);
        System.out.println("Medecin creer avec succes");
    }
}
