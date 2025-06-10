package org.example;
import org.example.models.*;

// Programme principal pour tester le distributeur
public class Main {
    public static void main(String[] args) {
        Distributeur d = new Distributeur();

        // Ajouter des boissons
        d.ajouterBoisson(new Boisson("Coca", 500, 10));
        d.ajouterBoisson(new Boisson("Fanta", 400, 5));
        d.ajouterBoisson(new Boisson("Eau", 300, 8));

        // Afficher les boissons
        d.afficherBoissons();

        // Créer un utilisateur et effectuer des achats
        Utilisateur u = new Utilisateur("Aliou");

        u.selectionnerBoisson(d, "Coca", 500);  // Achat réussi
        u.selectionnerBoisson(d, "Eau", 100);   // Montant insuffisant

        // Recharger une boisson
        d.rechargerStock("Fanta", 3);

        // Afficher les transactions
        d.getJournal().afficherJournal();
    }
}
