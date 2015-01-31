
import connexiondb.connexiondb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class utilisateur {
     public int id;
     public String login;
     public String password;
     
    public utilisateur()
   {
      this.id=0;
      this.login=null;
      this.password=null;
       
   }
    
   public utilisateur(int id,String login,String password)
   {
      this.id=id;
      this.login=login;
      this.password=password;
       
   }
//Fonction de login
   public boolean login(String login,String password)
   {
         try {
             connexiondb c = new connexiondb();
             ResultSet rs =  c.getDataBase("select * from user where login='"+login+"' and password='"+password+"'");
             if (rs.next()){    
                  
                    this.id=rs.getInt(1);
                    this.login=rs.getString(2);
                    this.password=rs.getString(3);
                    return(true);
                            }
            } catch (SQLException ex) {
             Logger.getLogger(utilisateur.class.getName()).log(Level.SEVERE, null, ex);
                                       } 
            return(false);
   }
    
}
