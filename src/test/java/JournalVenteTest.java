import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.example.models.*;
import java.util.List;

public class JournalVenteTest {

    @Test
    void testJournalVideAuDebut() {
        // Le journal doit être vide à la création
        JournalVente jv = new JournalVente();
        assertEquals(0, jv.listerVentes().size());
    }

    @Test
    void testEnregistrerTransaction() {
        // Vérifie qu'on peut ajouter une transaction au journal
        JournalVente jv = new JournalVente();
        Transaction t = new Transaction(new Boisson("Sprite", 450, 3), 450);
        jv.enregistrer(t);
        assertEquals(1, jv.listerVentes().size());
    }

    @Test
    void testListerTransactionsContientTransaction() {
        // Vérifie que la liste contient bien la transaction ajoutée
        JournalVente jv = new JournalVente();
        Transaction t = new Transaction(new Boisson("Fanta", 400, 4), 400);
        jv.enregistrer(t);
        List<Transaction> list = jv.listerVentes();
        assertTrue(list.contains(t));
    }
}
