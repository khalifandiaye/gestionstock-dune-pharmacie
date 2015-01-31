
import connexiondb.connexiondb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class fourni {
    
     public  String code;
     public String nom;
     public  String adresse;
     public String ville;
     public int tele;
     public int i=0;
     
     
     
    public fourni()
   {
      this.code=null;
      this.nom=null;
      this.adresse=null;
      this.ville=null;
      this.tele=0;
       
   }
    
   public fourni(String code,String nom,String adresse,String ville,int tele)
   {
      this.code=code;
      this.nom=nom;
      this.adresse=adresse;
      this.ville=ville;
      this.tele=tele;
       
   }
   
   
//les getters et les setters  
    public String getCode() 
    {
        return code;
    }

    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getNom() 
    {
        return nom;
    }

    public void setNom(String nom) 
    {
        this.nom = nom;
    }

    public String getAdresse() 
    {
        return adresse;
    }

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    public String getVille() 
    {
        return ville;
    }

    public void setVille(String ville) 
    {
        this.ville = ville;
    }

    public int getTele() 
    {
        return tele;
    }

    public void setTele(int tele) 
    {
        this.tele = tele;
    } 
//Fonction d'ajout   
    public  int Ajouter(String code,String nom,String adresse,String ville,Integer tele)
   {
      connexiondb cnx= new connexiondb();
      i =  cnx.setDataBase("INSERT INTO  fournisseur VALUES('"+code+"','"+nom+"','"+adresse+"','"+ville+"',"+tele+") ");
      return (i);
        
   }
//Fonction de suppresion   
   public  int supprimer(String code)
   {
      connexiondb cnx= new connexiondb();
      i =  cnx.setDataBase("DELETE FROM fournisseur WHERE codefournisseur='"+code+"'");
      return (i);
        
   }
//Fonction de modification
    public  int modifier(String code,String nom,String adresse,String ville,Integer tele)
   {
      connexiondb cnx= new connexiondb();
      i =  cnx.setDataBase("UPDATE  fournisseur SET nomfournisseur='"+nom+"' , adressefournisseur='"+adresse+"' , villefournisseur='"+ville+"' , telefournisseur='"+tele+"'  WHERE codefournisseur='"+code+"'");
      return (i);  
   }
//Fonction de recherche par code    
    public  fourni rechercherCode (String code)
    {
        try {   
                        
             connexiondb cnx= new connexiondb();
             ResultSet rs =  cnx.getDataBase("select * FROM  fournisseur WHERE codefournisseur='"+code+"'");
             if (rs.next()){
                 
                 this.code=rs.getString(1);
                 this.nom=rs.getString(2);
                 this.adresse=rs.getString(3);
                 this.ville=rs.getString(4);
                 this.tele=rs.getInt(5);
                 
                 return(this);
                            }
            } 
        catch (SQLException ex) {
             Logger.getLogger(fourni.class.getName()).log(Level.SEVERE, null, ex);
                                }
        return(null);
        
   }
//Fonction de recherche par nom     
    public  fourni rechercherNom (String nom)
   {
        try {           
             connexiondb cnx= new connexiondb();
             ResultSet rs =  cnx.getDataBase("select * FROM  fournisseur WHERE nomfournisseur='"+nom+"'");
             if (rs.next())
             { 
                 this.code=rs.getString(1);
                 this.nom=rs.getString(2);
                 this.adresse=rs.getString(3);
                 this.ville=rs.getString(4);
                 this.tele=rs.getInt(5);
                 return(this);
             }
            }   
            catch (SQLException ex) {
             Logger.getLogger(fourni.class.getName()).log(Level.SEVERE, null, ex);
                                    }
         return(null);
        
   }
//Fonction d'affichage
   public  Vector<fourni> afficher ()
   {
       Vector<fourni> listeF=new Vector<fourni>();
         try {  
              connexiondb cnx= new connexiondb();
             
             ResultSet r =  cnx.getDataBase("select * FROM  fournisseur ORDER BY nomfournisseur  ASC  ");
             while(r.next()){
                 
                fourni f =new fourni(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5));
                listeF.add(f);
                            }
             } 
            catch (SQLException ex) {
             Logger.getLogger(fourni.class.getName()).log(Level.SEVERE, null, ex);
                                    }
         return(listeF);
        
   }

//Fonction d'affichage par code    
 public boolean code(String code)
   {
         try {
             connexiondb c = new connexiondb();
             ResultSet rs =  c.getDataBase("select * from fournisseur where codefournisseur='"+code+"'");
             if (rs.next()){
                  
                    this.code=rs.getString(1);
                   
                    
                return(true);
                            }
         } catch (SQLException ex) {
             Logger.getLogger(utilisateur.class.getName()).log(Level.SEVERE, null, ex);
                                    } 
            return(false);
   }
}