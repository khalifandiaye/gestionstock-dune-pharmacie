import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */

public class fourniTest  {
   fourni ff= new fourni();
    fourni f= new fourni("16", "Ahmed Alawi", "67,rue nasr ", "ouarzazate", 12555);
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void ajouterTest() throws Exception {
    
    assertEquals(1,ff.Ajouter("16", "Ahmed Alawi", "67,rue nasr ", "ouarzazate", 12555)) ;   
    }
    @Test
    public void supprimerTest() throws Exception {
      assertEquals(1,ff.supprimer("16")) ;  
    }
 
    @Test
    public void modifierTest() throws Exception {
        
       
       assertEquals(1,ff.modifier("8", "Ahmed Alawi", "67,rue nasr ", "Rabat", 12555)) ;
    }
    
    
    @Test
    public void codeTest() throws Exception {
       assertEquals(true,ff.code("1")) ;
    }
     @Test
    public void rechercherCodeTest() throws Exception {
       assertEquals(ff,ff.rechercherCode("1")) ;
    }
    @Test
    public void rechercherNomTest() throws Exception {
       assertEquals(ff,ff.rechercherNom("OIFAE YAAKOUBI")) ;
    }
}
