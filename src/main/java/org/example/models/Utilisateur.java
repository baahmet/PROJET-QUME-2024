package org.example.models;

// Représente un utilisateur qui interagit avec le distributeur
public class Utilisateur {
    private String nom;                 // Nom de l'utilisateur
    private Portefeuille portefeuille; // Son portefeuille

    // Constructeur
    public Utilisateur(String nom) {
        this.nom = nom;
        this.portefeuille = new Portefeuille();
    }

    // Insère de l'argent dans le portefeuille
    public void insererMontant(double montant) {
        portefeuille.insererMontant(montant);
    }

    // Tente d'acheter une boisson via le distributeur
    public void selectionnerBoisson(Distributeur d, String nomBoisson, double montant) {
        d.acheterBoisson(nomBoisson, montant);
    }

    // Retourne le nom de l'utilisateur
    public String getNom() {
        return nom;
    }
}

