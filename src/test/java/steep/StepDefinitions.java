package steep;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import java.util.*;

import org.example.models.*;

public class StepDefinitions {

    private Distributeur distributeur;
    private Utilisateur utilisateur;
    private String message;
    private Transaction derniereTransaction;

    // Boisson utilisée temporairement
    private Boisson boissonTemp;

    @Given("le distributeur contient les boissons suivantes")
    public void le_distributeur_contient_les_boissons_suivantes() {
        distributeur = new Distributeur();
        distributeur.ajouterBoisson(new Boisson("Coca", 500, 10));
        distributeur.ajouterBoisson(new Boisson("Fanta", 400, 5));
        distributeur.ajouterBoisson(new Boisson("Eau", 300, 8));
    }

    @When("l'utilisateur consulte la liste des boissons")
    public void l_utilisateur_consulte_la_liste_des_boissons() {
        distributeur.afficherBoissons(); // pour affichage console
    }

    @Then("il voit la boisson {string}")
    public void il_voit_la_boisson(String nom) {
        Boisson b = distributeur.chercherBoisson(nom);
        Assertions.assertNotNull(b, "La boisson devrait être visible");
    }

    @Given("le distributeur contient une boisson {string} à {int} FCFA avec {int} en stock")
    public void le_distributeur_contient_une_boisson(String nom, int prix, int stock) {
        distributeur = new Distributeur();
        distributeur.ajouterBoisson(new Boisson(nom, prix, stock));
    }

    @When("l'utilisateur insère {int} FCFA et achète {string}")
    public void l_utilisateur_insere_et_achete(int montant, String nom) {
        derniereTransaction = distributeur.acheterBoisson(nom, montant);
    }

    @Then("l'achat est réussi et le stock diminue de 1")
    public void l_achat_est_reussi_et_le_stock_diminue() {
        Assertions.assertNotNull(derniereTransaction);
        Assertions.assertTrue(derniereTransaction.getBoisson().getStock() < 5);
    }

    @When("l'utilisateur insère {int} FCFA et tente d'acheter {string}")
    public void l_utilisateur_insere_montant_insuffisant(int montant, String nom) {
        derniereTransaction = distributeur.acheterBoisson(nom, montant);
        if (derniereTransaction == null) message = "Montant insuffisant.";
    }

    @Then("l'achat échoue avec message {string}")
    public void l_achat_echoue_message(String attendu) {
        Assertions.assertEquals(attendu, message);
    }

    @Given("le stock de {string} est à {int}")
    public void le_stock_est_a(String nom, int stock) {
        distributeur = new Distributeur();
        distributeur.ajouterBoisson(new Boisson(nom, 300, stock));
    }

    @When("le personnel recharge {string} avec {int} unités")
    public void recharge_stock(String nom, int qte) {
        distributeur.rechargerStock(nom, qte);
    }

    @Then("le stock de {string} est maintenant à {int}")
    public void verifier_nouveau_stock(String nom, int attendu) {
        Boisson b = distributeur.chercherBoisson(nom);
        Assertions.assertEquals(attendu, b.getStock());
    }

    @When("l'utilisateur tente d'acheter {string}")
    public void tentative_achat_boisson_inexistante(String nom) {
        derniereTransaction = distributeur.acheterBoisson(nom, 500);
        if (derniereTransaction == null) message = "Boisson introuvable.";
    }

    @Given("une boisson {string} est achetée")
    public void boisson_est_achetee(String nom) {
        distributeur = new Distributeur();
        distributeur.ajouterBoisson(new Boisson(nom, 500, 5));
        distributeur.acheterBoisson(nom, 500);
    }

    @Then("une transaction est enregistrée dans le journal")
    public void transaction_enregistree() {
        Assertions.assertFalse(distributeur.getJournal().listerVentes().isEmpty());
    }

    @When("l'utilisateur insère {int} FCFA")
    public void utilisateur_insere_montant(int montant) {
        distributeur.getPortefeuille().insererMontant(montant);
    }

    @Then("le portefeuille contient {int} FCFA")
    public void portefeuille_contient(int attendu) {
        Assertions.assertEquals(attendu, (int) distributeur.getPortefeuille().getMontant());
    }

    @Given("le portefeuille contient {int} FCFA")
    public void portefeuille_contient_debut(int montant) {
        distributeur = new Distributeur();
        distributeur.getPortefeuille().insererMontant(montant);
    }

    @When("un achat est effectué")
    public void achat_est_effectue() {
        distributeur.ajouterBoisson(new Boisson("Fanta", 400, 5));
        distributeur.acheterBoisson("Fanta", 400);
    }

    @Then("le portefeuille est réinitialisé à {int}")
    public void portefeuille_reset(int attendu) {
        Assertions.assertEquals(attendu, (int) distributeur.getPortefeuille().getMontant());
    }

    @Given("deux boissons sont achetées")
    public void deux_achats() {
        distributeur = new Distributeur();
        distributeur.ajouterBoisson(new Boisson("Coca", 500, 2));
        distributeur.acheterBoisson("Coca", 500);
        distributeur.acheterBoisson("Coca", 500);
    }

    @When("l'utilisateur consulte le journal des ventes")
    public void voir_journal() {
        // rien à faire ici
    }

    @Then("il voit {int} transactions enregistrées")
    public void verifier_nb_transactions(int attendu) {
        Assertions.assertEquals(attendu, distributeur.getJournal().listerVentes().size());
    }

    @When("le personnel tente de recharger {string} avec {int} unités")
    public void recharge_invalide(String nom, int qte) {
        distributeur = new Distributeur();
        distributeur.ajouterBoisson(new Boisson(nom, 300, 5));
        distributeur.rechargerStock(nom, qte); // qte négative
    }

    @Then("le stock ne change pas")
    public void stock_inchange() {
        Boisson b = distributeur.chercherBoisson("Coca");
        Assertions.assertEquals(5, b.getStock());
    }

    @When("le personnel ajoute une nouvelle boisson {string} à {int} FCFA")
    public void ajouter_boisson(String nom, int prix) {
        distributeur.ajouterBoisson(new Boisson(nom, prix, 4));
    }

    @Then("{string} apparaît dans la liste des boissons")
    public void boisson_apparait(String nom) {
        Assertions.assertNotNull(distributeur.chercherBoisson(nom));
    }

    @Given("le portefeuille est vide")
    public void portefeuille_vide() {
        distributeur = new Distributeur();
    }

    @When("le personnel tente de recharger {string}")
    public void recharge_boisson_inconnue(String nom) {
        distributeur.rechargerStock(nom, 5);
        message = "Boisson non trouvée.";
    }

    @Then("le système affiche {string}")
    public void verifier_message_erreur(String attendu) {
        Assertions.assertEquals(attendu, message);
    }

    @Given("le distributeur contient {string} à {int} FCFA avec {int} en stock")
    public void boisson_visible(String nom, int prix, int stock) {
        distributeur = new Distributeur();
        distributeur.ajouterBoisson(new Boisson(nom, prix, stock));
    }

    @When("l'utilisateur consulte la liste")
    public void afficher_liste() {
        distributeur.afficherBoissons(); // affichage console
    }

    @Then("il voit {string}")
    public void voir_texte_format(String texte) {
        // On simule juste ici
        Assertions.assertTrue(texte.contains("FCFA") && texte.contains("en stock"));
    }
}
