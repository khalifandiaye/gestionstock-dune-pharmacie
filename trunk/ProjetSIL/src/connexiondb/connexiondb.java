/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connexiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class connexiondb {

    private Connection conn;
     
   

    public static ResultSet rs1 = null;
    public String req1= null;

    public connexiondb() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erreur Driver  " , "Etat de L'opération", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(connexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/pharmacie?useUnicode=true&characterEncoding=cp1256", "root", "");

        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erreur Connection Base de donnée", "Etat de L'opération", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(connexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getDataBase(String req) {
        Vector res = new Vector();
        Statement s = null;
        ResultSet rs = null;
        try {
            s = conn.createStatement();
//            javax.swing.JOptionPane.showMessageDialog(null,"getdata","Etat de L'op?ration",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erreur get data", "Etat de L'op?ration", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(connexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs = s.executeQuery(req);
        } catch (SQLException ex) {
            Logger.getLogger(connexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
//        try {
//            while (rs.next()) {
//                res.add(rs.getString(1));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return rs;
    }

    public int setDataBase(String req) {
        int i = 0;
        try {
            Statement s = conn.createStatement();
            i = s.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("erreur" + req);
        }
        return i;
    }

    public java.io.InputStream getUserImage(String req) throws Exception {
        java.io.InputStream istreamImage = null;
        // String req = "SELECT Photo FROM TABLE_UTILISATEUR WHERE IDUTILISATEUR ="+IdUtilisateur;
        //Connection conn = sopro.SoproConnectionManager.getMyConnection();
        ResultSet resultSet1 = conn.createStatement().executeQuery(req);
        if (resultSet1.next()) {
            istreamImage = resultSet1.getBinaryStream("Photo");
        }

        return istreamImage;
    }
    

    public static void main(String[] arg) {
        try {
            connexiondb c = new connexiondb();
            ResultSet rs1 =  c.getDataBase("select * from fournisseur");
            if (rs1.next()){
                System.out.println(rs1.getString(1)+ " "+ rs1.getString(2));
            }
//       Vector v= c.getDataBase("select * from personne");
//       for(int i=0;i<v.size();i++)
//            System.out.println("nom:"+v.get(i).toString());
        } catch (SQLException ex) {
            Logger.getLogger(connexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}