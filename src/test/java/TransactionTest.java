import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.example.models.*;

public class TransactionTest {

    @Test
    void testTransactionData() {
        // Vérifie que les attributs de la transaction sont bien enregistrés
        Boisson b = new Boisson("Eau", 300, 5);
        Transaction t = new Transaction(b, 300);
        assertEquals(b, t.getBoisson());
        assertEquals(300, t.getMontant());
        assertNotNull(t.getDate()); // la date ne doit pas être nulle
    }

    @Test
    void testTransactionDetailsFormat() {
        // Vérifie que le texte retourné contient bien le nom de la boisson
        Boisson b = new Boisson("Fanta", 400, 5);
        Transaction t = new Transaction(b, 400);
        assertTrue(t.getDetails().contains("Fanta"));
    }

    @Test
    public void testTransactionAvecMontantNegatif() {
        Boisson b = new Boisson("Thé", 300, 2);
        Transaction t = new Transaction(b, -100);
        Assertions.assertEquals(-100, t.getMontant());
    }
    @Test
    public void testTransactionHorodatageNonNull() {
        Boisson b = new Boisson("Jus", 500, 1);
        Transaction t = new Transaction(b, 500);
        Assertions.assertNotNull(t.getDate());
    }
    @Test
    public void testTransactionBoissonNonNull() {
        Boisson b = new Boisson("Café", 250, 2);
        Transaction t = new Transaction(b, 250);
        Assertions.assertNotNull(t.getBoisson());
    }

}
