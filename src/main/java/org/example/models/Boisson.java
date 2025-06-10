package org.example.models;

// Classe représentant une boisson vendue par le distributeur
public class Boisson {
    private String nom;       // Nom de la boisson
    private double prix;      // Prix unitaire de la boisson
    private int stock;        // Quantité disponible en stock

    // Constructeur
    public Boisson(String nom, double prix, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
    }

    // Accesseurs
    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public int getStock() {
        return stock;
    }

    // Vérifie si la boisson est disponible (stock > 0)
    public boolean estDisponible() {
        return stock > 0;
    }

    // Réduit le stock de 1 après un achat
    public void reduireStock() {
        if (stock > 0) {
            stock--;
        }
    }

    // Ajoute une quantité au stock
    public void ajouterStock(int qte) {
        if (qte > 0) {
            stock += qte;
        }
    }

    // Affiche les détails de la boisson
    @Override
    public String toString() {
        return nom + " - " + prix + " FCFA (" + stock + " en stock)";
    }
}

