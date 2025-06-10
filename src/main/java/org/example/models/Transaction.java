package org.example.models;

import java.util.Date;

// Représente une opération d'achat
public class Transaction {
    private Boisson boisson;   // La boisson achetée
    private double montant;    // Montant payé
    private Date date;         // Date de la transaction

    // Constructeur
    public Transaction(Boisson boisson, double montant) {
        this.boisson = boisson;
        this.montant = montant;
        this.date = new Date(); // Date actuelle
    }

    // Retourne une description de la transaction
    public String getDetails() {
        return "Transaction : " + boisson.getNom() + " - " + montant + " FCFA le " + date;
    }

    // Accesseurs
    public Boisson getBoisson() {
        return boisson;
    }

    public double getMontant() {
        return montant;
    }

    public Date getDate() {
        return date;
    }
}

