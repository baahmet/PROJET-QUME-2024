package org.example.models;

import java.util.ArrayList;
import java.util.List;

// Journal des transactions effectuées
public class JournalVente {
    private List<Transaction> transactions;

    // Constructeur
    public JournalVente() {
        transactions = new ArrayList<>();
    }

    // Enregistre une nouvelle transaction
    public void enregistrer(Transaction t) {
        transactions.add(t);
    }

    // Retourne la liste complète des transactions
    public List<Transaction> listerVentes() {
        return transactions;
    }

    // Affiche toutes les ventes
    public void afficherJournal() {
        for (Transaction t : transactions) {
            System.out.println(t.getDetails());
        }
    }
}
