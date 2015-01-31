
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
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
public class utilisateurTest {
     
    public utilisateurTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        utilisateur ut= new utilisateur();
    }
    
    
    @After
    public void tearDown() {
    }

    @Test
    public void loginTest() {
    utilisateur ut1= new utilisateur();
   assertEquals(true,ut1.login("oifae", "123")) ;
   assertEquals(false,ut1.login("b", "a")) ;
    }
     
}
