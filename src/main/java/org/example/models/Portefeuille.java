package org.example.models;

// Classe représentant l'argent inséré dans le distributeur
public class Portefeuille {
    private double montantInsere;

    // Constructeur
    public Portefeuille() {
        this.montantInsere = 0.0;
    }

    // Ajoute un montant inséré par l'utilisateur
    public void insererMontant(double montant) {
        if (montant > 0) {
            montantInsere += montant;
        }
    }

    // Récupère le montant actuel
    public double getMontant() {
        return montantInsere;
    }

    // Réinitialise le portefeuille à zéro (après achat)
    public void reset() {
        montantInsere = 0.0;
    }

    // Vérifie si le montant inséré est suffisant pour acheter une boisson
    public boolean aAssezPour(double prix) {
        return montantInsere >= prix;
    }
}

