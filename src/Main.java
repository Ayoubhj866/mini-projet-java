import abonnement.AbonnementServiceImpl;
import magasin.Magasin;
import personne.Client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Part I *************************** Saisie des attributs de Magasin*****************
        System.out.print("🏦 Partie I : Création d'un magasin 🏦\n");


        System.out.print("Entrez le nom du magasin : ");
        String nomMagasin = scanner.nextLine();
        System.out.print("Entrez l'adresse du magasin : ");
        String adresseMagasin = scanner.nextLine();

        Magasin magasin = new Magasin(nomMagasin, adresseMagasin);

        // ------------------Stockage du magasin dans un fichier CSV------------------
        try (FileWriter writerMagasin = new FileWriter("magasins.csv", true)) {
            writerMagasin.write(magasin.getId() + "," + nomMagasin + "," + adresseMagasin + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print( "\n");



        // Parte II ********************Saisie des attributs de Client*********************
        System.out.print("\n");
        System.out.print(" 👤 Partie II : Création d'un Client  👤 \n");


        System.out.print("Entrez le nom du client : ");
        String nomClient = scanner.nextLine();
        System.out.print("Entrez le prénom du client : ");
        String prenomCLient = scanner.nextLine();

        Client client = new Client(nomClient, prenomCLient);

        // ___________________Stockage du client dans un fichier CSV______________________________
        try (FileWriter writerClient = new FileWriter("clients.csv", true)) {
            writerClient.write(client.getID() + "," + nomClient + "," + prenomCLient + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print( "\n");

        // Parte II ********************Création d'un abonnement*********************
        System.out.print("📅 Partie III : Créaction d'un abonnement 📅 \n");



        AbonnementServiceImpl abonnementService = new AbonnementServiceImpl();

        // faire appel à la  méthode abonné pour crier un abonnement
        abonnementService.abonner(client, magasin);

        // Stockage de l'abonnement dans un fichier CSV
        try (FileWriter writerAbonnement = new FileWriter("abonnements.csv", true)) {
            writerAbonnement.write(magasin.getId() + "," + client.getID() + "," + abonnementService.getDateDebut() + "," + abonnementService.getDateFin() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print( "\n");
     System.out.println("*************************************************************");
        System.out.print( "\n");



        System.out.print(" 🏦 LISTE DES MAGASIN   \n");
        System.out.printf("%-5s %-20s %-30s%n", "ID", "Nom", "Adresse");
        System.out.printf("%-5s %-20s %-30s%n", "------------------", "--------------------", "----------------------");

        List<String[]> magasins = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("magasins.csv"))) {
            String line;
            while ((line = reader.readLine())!= null) {
                String[] values = line.split(",");
                magasins.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //*************** Afficher les données des magasins dans une table

        for (String[] mag : magasins) {
            System.out.printf("%-5s %-20s %-30s%n", mag[0], mag[1], mag[2]);
        }
        System.out.println("*************************************************************");



        System.out.print( "\n");
        System.out.println("---------------------------------------------------------");
        System.out.print( "\n");


        System.out.println("*************************************************************");
        System.out.print(" 👤 LISTE DES CLIENTS  \n");

        System.out.printf("%-5s %-20s %-20s%n", "ID", "Nom", "Prénom");
        System.out.printf("%-5s %-20s %-20s%n", "------------------", "--------------------", "--------------------");

        List<String[]> clients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("clients.csv"))) {
            String line;
            while ((line = reader.readLine())!= null) {
                String[] values = line.split(",");
                clients.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    // Afficher les données des clients dans une table
        for (String[] cl : clients) {
            System.out.printf("%-5s %-20s %-20s%n", cl[0], cl[1], cl[2]);
        }

        System.out.println("*************************************************************");


        System.out.print( "\n");
        System.out.print( "\n");
        System.out.println("---------------------------------------------------------");
        System.out.print( "\n");
        System.out.print( "\n");

        System.out.println("*************************************************************");


        System.out.print(" 🎟️  LISTE DES ABONNEMENTS   \n");

        System.out.printf("%-20s %-20s %-10s %-10s%n", "Magasin", "Client", "Date de début", "Date de fin");
        System.out.printf("%-20s %-20s %-10s %-10s%n", "--------------------", "--------------------", "----------------", "----------------");

        List<String[]> abonnements = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("abonnements.csv"))) {
            String line;
            while ((line = reader.readLine())!= null) {
                String[] values = line.split(",");
                abonnements.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Afficher les données des abonnements dans une table
        for (String[] abonne : abonnements) {
            System.out.printf("%-20s %-20s %-10s %-10s%n", abonne[0], abonne[1], abonne[2], abonne[3]);
        }
        System.out.println("*************************************************************");

    }
}