
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class CommandeTest {
    
    Commande cmd= new Commande();
    Commande cmd1= new Commande("1", "1", "1 ",1,new Date(2014/11/10), 12.33,12.33);
    
    
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
   
    public void ajouter1Test() throws Exception {
    
    assertEquals(0,cmd.ajouter1("1", "1", 1, 13.33)) ;   
    }
    @Test
    public void supprimerTest() throws Exception {
     assertEquals(0,cmd.supprimer("16")) ;  
    }
     @Test
    public void supprimer1Test() throws Exception {
     assertEquals(0,cmd.supprimer1("16")) ;  
    }
 
    @Test
   
    
     
    public void modifier1Test() throws Exception {
        
       
     assertEquals(0,cmd. modifier1("8", "1", 1, 1.33)) ;
    }
    
    
    
    
    
}
