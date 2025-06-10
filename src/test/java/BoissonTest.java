import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.example.models.*;

public class BoissonTest {

    @Test
    void testCreationBoisson() {
        // Teste la création d'une boisson avec nom, prix et stock
        Boisson b = new Boisson("Coca", 500, 10);
        assertEquals("Coca", b.getNom());
        assertEquals(500, b.getPrix());
        assertEquals(10, b.getStock());
    }

    @Test
    void testEstDisponibleTrue() {
        // Vérifie que la boisson est disponible si le stock est > 0
        Boisson b = new Boisson("Coca", 500, 2);
        assertTrue(b.estDisponible());
    }

    @Test
    void testEstDisponibleFalse() {
        // Vérifie que la boisson n'est pas disponible si le stock est 0
        Boisson b = new Boisson("Coca", 500, 0);
        assertFalse(b.estDisponible());
    }

    @Test
    void testReducStock() {
        // Vérifie que le stock diminue après appel de reduireStock()
        Boisson b = new Boisson("Coca", 500, 2);
        b.reduireStock();
        assertEquals(1, b.getStock());
    }

    @Test
    void testAjouterStock() {
        // Vérifie que le stock augmente après appel de ajouterStock()
        Boisson b = new Boisson("Coca", 500, 2);
        b.ajouterStock(3);
        assertEquals(5, b.getStock());
    }

    @Test
    public void testPrixBoisson() {
        Boisson b = new Boisson("Sprite", 350, 5);
        Assertions.assertEquals(350, b.getPrix());
    }

}
