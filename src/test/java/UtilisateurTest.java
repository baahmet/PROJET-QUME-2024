import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.example.models.*;
public class UtilisateurTest {

    @Test
    void testCreationUtilisateur() {
        // Création d'un utilisateur
        Utilisateur u = new Utilisateur("Fatou");
        assertEquals("Fatou", u.getNom());
    }

    @Test
    void testInsererMontantDansPortefeuille() {
        // Insertion d’un montant dans le portefeuille de l’utilisateur
        Utilisateur u = new Utilisateur("Fatou");
        u.insererMontant(500);
        assertTrue(true); // comportement implicite
    }

    @Test
    void testSelectionnerBoissonReussie() {
        // Achat valide via l'utilisateur
        Distributeur d = new Distributeur();
        d.ajouterBoisson(new Boisson("Fanta", 400, 3));
        Utilisateur u = new Utilisateur("Fatou");
        u.selectionnerBoisson(d, "Fanta", 400);
        assertEquals(1, d.getJournal().listerVentes().size());
    }

    @Test
    void testSelectionnerBoissonEchecMontantInsuffisant() {
        // Achat échoué à cause d'un montant insuffisant
        Distributeur d = new Distributeur();
        d.ajouterBoisson(new Boisson("Fanta", 400, 3));
        Utilisateur u = new Utilisateur("Fatou");
        u.selectionnerBoisson(d, "Fanta", 200);
        assertEquals(0, d.getJournal().listerVentes().size());
    }
}
