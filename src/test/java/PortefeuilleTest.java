import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.example.models.*;

public class PortefeuilleTest {

    @Test
    void testInitialMontant() {
        // Le montant inséré doit être 0 au départ
        Portefeuille p = new Portefeuille();
        assertEquals(0, p.getMontant());
    }

    @Test
    void testInsererMontant() {
        // Vérifie qu'on peut ajouter un montant
        Portefeuille p = new Portefeuille();
        p.insererMontant(500);
        assertEquals(500, p.getMontant());
    }

    @Test
    void testReset() {
        // Vérifie que reset() remet le montant à 0
        Portefeuille p = new Portefeuille();
        p.insererMontant(500);
        p.reset();
        assertEquals(0, p.getMontant());
    }

    @Test
    void testAAssezPourTrue() {
        // Vérifie qu'on a assez pour acheter une boisson
        Portefeuille p = new Portefeuille();
        p.insererMontant(600);
        assertTrue(p.aAssezPour(500));
    }

    @Test
    void testAAssezPourFalse() {
        // Vérifie que le montant est insuffisant
        Portefeuille p = new Portefeuille();
        p.insererMontant(200);
        assertFalse(p.aAssezPour(500));
    }

    @Test
    public void testInsererMontantNegatif() {
        Portefeuille p = new Portefeuille();
        p.insererMontant(-100);
        Assertions.assertEquals(0, p.getMontant());
    }

}
