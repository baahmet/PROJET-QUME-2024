import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.example.models.*;

public class DistributeurTest {

    private Distributeur d;

    @BeforeEach
    void setUp() {
        d = new Distributeur();
        d.ajouterBoisson(new Boisson("Coca", 500, 2));
        d.ajouterBoisson(new Boisson("Eau", 300, 0)); // en rupture
    }

    @AfterEach
    void tearDown() {
        // Nettoyage ou message après chaque test
        System.out.println("Test terminé.");
    }
    @Test
    void testChercherBoissonExistante() {
        // Teste la recherche d'une boisson existante
        assertNotNull(d.chercherBoisson("Coca"));
    }

    @Test
    void testChercherBoissonInexistante() {
        // Doit retourner null si la boisson n’existe pas
        assertNull(d.chercherBoisson("Jus"));
    }

    @Test
    void testAchatReussi() {
        // Achat valide avec montant suffisant
        Transaction t = d.acheterBoisson("Coca", 500);
        assertNotNull(t);
    }

    @Test
    void testAchatMontantInsuffisant() {
        // Achat refusé si le montant est trop bas
        Transaction t = d.acheterBoisson("Coca", 100);
        assertNull(t);
    }

    @Test
    void testAchatBoissonInexistante() {
        // Achat échoue si la boisson n'existe pas
        Transaction t = d.acheterBoisson("Redbull", 500);
        assertNull(t);
    }

    @Test
    void testAchatBoissonRupture() {
        // Achat échoue si la boisson est en rupture
        Transaction t = d.acheterBoisson("Eau", 300);
        assertNull(t);
    }

    @Test
    void testRechargeStock() {
        // Recharge du stock avec succès
        d.rechargerStock("Eau", 5);
        Boisson b = d.chercherBoisson("Eau");
        assertEquals(5, b.getStock());
    }

    @Test
    void testRechargeStockBoissonInconnue() {
        // Recharge échoue sur boisson inconnue
        d.rechargerStock("Thé", 5); // ne plante pas, mais ne change rien
        assertNull(d.chercherBoisson("Thé"));
    }
}
