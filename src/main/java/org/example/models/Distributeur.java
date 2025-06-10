package org.example.models;

import java.util.ArrayList;
import java.util.List;

// Gère l’ensemble des opérations du distributeur
public class Distributeur {
    private List<Boisson> boissons;           // Liste des boissons disponibles
    private Portefeuille portefeuille;        // Portefeuille pour gérer l'argent inséré
    private JournalVente journal;             // Journal des ventes

    // Constructeur
    public Distributeur() {
        boissons = new ArrayList<>();
        portefeuille = new Portefeuille();
        journal = new JournalVente();
    }

    // Ajoute une boisson à la machine
    public void ajouterBoisson(Boisson boisson) {
        boissons.add(boisson);
    }

    // Affiche toutes les boissons disponibles
    public void afficherBoissons() {
        for (Boisson b : boissons) {
            System.out.println(b);
        }
    }

    // Cherche une boisson par son nom
    public Boisson chercherBoisson(String nom) {
        for (Boisson b : boissons) {
            if (b.getNom().equalsIgnoreCase(nom)) {
                return b;
            }
        }
        return null;
    }

    // Permet d'acheter une boisson en insérant un montant
    public Transaction acheterBoisson(String nom, double montant) {
        Boisson b = chercherBoisson(nom);

        if (b == null) {
            System.out.println("Boisson introuvable.");
            return null;
        }

        if (!b.estDisponible()) {
            System.out.println("Boisson en rupture de stock.");
            return null;
        }

        portefeuille.insererMontant(montant);

        if (!portefeuille.aAssezPour(b.getPrix())) {
            System.out.println("Montant insuffisant.");
            return null;
        }

        portefeuille.reset(); // Vider le portefeuille après l'achat
        b.reduireStock();     // Réduire le stock de la boisson
        Transaction t = new Transaction(b, b.getPrix()); // Créer une transaction
        journal.enregistrer(t); // Enregistrer dans le journal

        System.out.println("Achat réussi de " + b.getNom());
        return t;
    }

    // Recharge le stock d'une boisson existante
    public void rechargerStock(String nom, int quantite) {
        Boisson b = chercherBoisson(nom);
        if (b != null) {
            b.ajouterStock(quantite);
            System.out.println("Stock rechargé.");
        } else {
            System.out.println("Boisson non trouvée.");
        }
    }

    // Accesseurs
    public JournalVente getJournal() {
        return journal;
    }

    public Portefeuille getPortefeuille() {
        return portefeuille;
    }
}

