/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import connexiondb.connexiondb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Commande {
    public  Statement stx;
    public  String code;
    public  String codeFour;
    public  Date date;
    public  double montant;
     public double prix_achat;
     public  String codemedicament;
    public  int qtemedicament;
    public  ResultSet rset;
    public Connection conn;
    JOptionPane jop1, jop2, jop3;
    
    public Commande(){
         this.code="";
        this.codeFour="";
        this.codemedicament="";
        this.qtemedicament=0;
        this.date=null;
        this.prix_achat=0;
        this.montant=0;
    }
    public Commande(String code,String codeFour,String codemedicament,int qtemedicament,Date date,double prix_achat,double montant){
        this.code=code;
        this.codeFour=codeFour;
        this.codemedicament=codemedicament;
        this.qtemedicament=qtemedicament;
        this.date=date;
        this.prix_achat=prix_achat;
        this.montant=montant;

    }
    
    
    public String getCode() 
    {
        return code;
    }

    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getcodeFour() 
    {
        return codeFour;
    }

    public void setcodeFour(String codeFour) 
    {
        this.codeFour = codeFour;
    }

    public String getcodemedicament() 
    {
        return codemedicament;
    }

    public void setcodemedicament(String codemedicament)
    {
        this.codemedicament = codemedicament;
    }

    public Date getdate() 
    {
        return date;
    }

    public void setdate(Date date) 
    {
        this.date= date;
    }

    public double getmontant() 
    {
        return montant;
    }

    public void setmontant(double montant) 
    {
        this.montant = montant;
    } 
    
    public double getprix_achat() 
    {
        return prix_achat;
    }

    public void setprix_achat(double prix_achat) 
    {
        this.prix_achat= prix_achat;
    }

    public int getqtemedicament() 
    {
        return qtemedicament;
    }

    public void setqtemedicament(int qtemedicament) 
    {
        this.qtemedicament = qtemedicament;
    } 
    
    
    connexiondb cnx= new connexiondb();
    public  int ajouter(String numcommande,String codefournisseur,String datecommande,double montant){
        
            //Execution de la requete
            
           
           
            int i =  cnx.setDataBase("INSERT INTO  commande(numcommande,codefournisseur,datecommande,montant) "
                    + "VALUES('"+numcommande+"','"+codefournisseur+"','"+datecommande+"',"+montant+") ");
      return (i);
                   
        } 
     public  int ajouter1(String numcommande,String codemedicament,int qtemedicament,double prix){
        
            //Execution de la requete
            
           
            int i =  cnx.setDataBase("INSERT INTO  lignecommande(numcommande,codemedicament,qtemedicament,prix_achat) "
                    + "VALUES('"+numcommande+"','"+codemedicament+"',"+qtemedicament+","+prix+") ");
      return (i);
                   
        } 
       
    public  int modifier(String numcommande,String codefournisseur,String datecommande,double montant){
        
            //Execution de la requete
            
           
           
            int i =  cnx.setDataBase("UPDATE commande  SET codefournisseur='"+codefournisseur+"',datecommande='"+datecommande+"',montant="+montant+" WHERE numcommande='"+numcommande+"'");
      return (i);
                   
        } 
     public  int modifier1(String numcommande,String codemedicament,int qtemedicament,double prix){
        
            //Execution de la requete
            
           
            int i =  cnx.setDataBase("UPDATE lignecommande SET codemedicament='"+codemedicament+"',qtemedicament="+qtemedicament+",prix_achat="+prix+" WHERE numcommande='"+numcommande+"'");
      return (i);
                   
        } 
    public int supprimer(String numcommande){
     
            //Execution de la requete
            int query=cnx.setDataBase ("DELETE FROM commande WHERE numcommande = "+numcommande+"");
            return (query);
           
    }//
    public int supprimer1(String numcommande){
     
            //Execution de la requete
            int query=cnx.setDataBase ("DELETE FROM lignecommande WHERE numcommande = "+numcommande+"");
            return (query);
           
    }//
    @SuppressWarnings("static-access")
   
    public  Commande rechercherNum (String code)
    {
        try {   
                        
             
             ResultSet rs =  cnx.getDataBase("SELECT commande.numcommande codefournisseur, codemedicament, qtemedicament,datecommande, prix_achat, montant\n" +
"FROM commande, lignecommande\n" +
"WHERE commande.numcommande = lignecommande.numcommande\n" +
"AND commande.numcommande ='"+code+"'");
             if (rs.next()){
                 
                 this.code=rs.getString(1);
                 this.codeFour=rs.getString(2);
                 this.codemedicament=rs.getString(3);
                 this.date=rs.getDate("datecommande");
                 this.prix_achat=rs.getDouble("prix_achat");
                 this.qtemedicament=rs.getInt(4);
                 this.montant=rs.getDouble("montant");
                 
                 
                 
                 
                 return(this);
                            }
            } 
        catch (SQLException ex) {
             Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
                                }
        return(null);
        
   }
    public  Commande rechercherCodeFour (String code)
    {
        try {   
                        
             
              ResultSet rs1 =  cnx.getDataBase("SELECT commande.numcommande ,codefournisseur, codemedicament, qtemedicament, datecommande, prix_achat, montant\n" +
"FROM commande, lignecommande\n" +
"WHERE commande.numcommande = lignecommande.numcommande\n" +
"AND codefournisseur ='"+code+"'");
            if (rs1.next()){
                 
                 this.code=rs1.getString(1);
                 this.codeFour=rs1.getString(2);
                 this.codemedicament=rs1.getString(3);
                 this.date=rs1.getDate("datecommande");
                 this.prix_achat=rs1.getDouble(6);
                 this.qtemedicament=rs1.getInt(4);
                 this.montant=rs1.getDouble(7);
                 
                 
                 return(this);
                            }
            } 
        catch (SQLException ex) {
             Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
                                }
        return(null);
        
   }

   public  Vector<Commande> afficher ()
   {
       Vector<Commande> listeF=new Vector<Commande>();
         try {  
              connexiondb cnx= new connexiondb();
             
             ResultSet r =  cnx.getDataBase("SELECT commande.numcommande ,codefournisseur, codemedicament, qtemedicament, datecommande, prix_achat, montant\n" +
"FROM commande, lignecommande\n" +
"WHERE commande.numcommande = lignecommande.numcommande ");
             while(r.next()){
                 
                Commande f =new Commande(r.getString(1), r.getString(2), r.getString(3), r.getInt(4), r.getDate(5),r.getDouble(6), r.getDouble(7));
                listeF.add(f);
                            }
             } 
            catch (SQLException ex) {
             Logger.getLogger(fourni.class.getName()).log(Level.SEVERE, null, ex);
                                    }
         return(listeF);
        
   }

   
}
