package abonnement;

import interfaces.AbonnementService;
import magasin.Magasin;
import personne.Client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AbonnementServiceImpl implements AbonnementService {

    private Date dateDebut;
    private Date dateFin;

    @Override
    public void abonner (Client client, Magasin magasin) {


        // saisir les donnée de magasin
        System.out.print("Entrez la date de début de l'abonnement (format jj/mm/aaaa) : ");
        Scanner scanner = new Scanner(System.in);
        String dateDebutString = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            dateDebut = dateFormat.parse(dateDebutString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.print("Entrez la date de fin de l'abonnement (format jj/mm/aaaa) : ");
        String dateFinString = scanner.nextLine();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dateFin = dateFormat2.parse(dateFinString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.print("  ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️  \n");
        System.out.println("Le client " + client.getFirstName() + " s'est bien abonné au magasin " + magasin.getName());
        System.out.print("  ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️ ⚠️  \n");

    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

}
