/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import connexiondb.connexiondb;
import static java.lang.Integer.parseInt;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
public class Fournisseur extends javax.swing.JFrame {

    fourni listef = new fourni();
   // Connection con;
    //Statement st;
   // ResultSet rs;
    DefaultTableModel tb = new DefaultTableModel();
    int i;

    fourni f = new fourni();
    fourni f1 = new fourni();

    /**
     * Creates new form Fournisseur
     */
    public Fournisseur() 
    {
        initComponents();
        tb.addColumn("Code Fournisseur");
        tb.addColumn("Nom");
        tb.addColumn("adresse");
        tb.addColumn("ville");
        tb.addColumn("tele");
        buttonGroup1.add(jRadioCode);
        buttonGroup1.add(jRadioNom);
        jRadioCode.setSelected(true);
       

    }
// la fonction nouveau permet de vider tous les champs 
    public void nouveau()
    {
        code.setText(null);
        nom.setText(null);
        adresse.setText(null);
        ville.setText(null);
        tele.setText(null);
        txtrechercher.setText(null);
        tb.setNumRows(0);
        
    }
// la fonction remplir permet de remplir tous les champs qui sont vides
    public void remplir()
    {
        if(code.getText().isEmpty())
          javax.swing.JOptionPane.showMessageDialog(null, "Remplir le champs code", "Etat", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        if(nom.getText().isEmpty())
          javax.swing.JOptionPane.showMessageDialog(null, "Remplir le champs nom", "Etat", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        if(adresse.getText().isEmpty())
          javax.swing.JOptionPane.showMessageDialog(null, "Remplir le champs adresse", "Etat", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        if(ville.getText().isEmpty())
          javax.swing.JOptionPane.showMessageDialog(null, "Remplir le champs ville", "Etat", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        if(tele.getText().isEmpty())
          javax.swing.JOptionPane.showMessageDialog(null, "Remplir le champs tele", "Etat", javax.swing.JOptionPane.INFORMATION_MESSAGE);

           
    }
// la fonction deplacer permet de deplacer la ligne du table vers les chapmps du text
    public void deplacer(int i) {
        code.setText(tb.getValueAt(i, 0).toString());
        nom.setText(tb.getValueAt(i, 1).toString());
        adresse.setText(tb.getValueAt(i, 2).toString());
        ville.setText(tb.getValueAt(i, 3).toString());
        tele.setText(tb.getValueAt(i, 4).toString());
    }
// la fonction afficher permet de afficher la table du Fournisseur
    public void afficher() 
    {

        tb.setRowCount(0);
        Vector<fourni> lists = new Vector<fourni>();
        lists = listef.afficher();
        
        for (i = 0; i < lists.size(); i++) 
        {
            Object[] e = {lists.get(i).getCode(), lists.get(i).getNom(), lists.get(i).getAdresse(), lists.get(i).getVille(), lists.get(i).getTele()};
            tb.addRow(e);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Ajouter = new javax.swing.JButton();
        Modifier = new javax.swing.JButton();
        Change = new javax.swing.JButton();
        Supprimer = new javax.swing.JButton();
        Afficher = new javax.swing.JButton();
        Nouveau = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jRadioCode = new javax.swing.JRadioButton();
        jRadioNom = new javax.swing.JRadioButton();
        txtrechercher = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        adresse = new javax.swing.JTextField();
        ville = new javax.swing.JTextField();
        tele = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabFournisseur = new javax.swing.JTable();
        Menu = new javax.swing.JButton();
        Quitter = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion des Fournisseurs");
        setBackground(null);
        setMinimumSize(new java.awt.Dimension(820, 410));
        setName("fournisseur"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Gestion des Fournisseurs");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(444, 15, 270, 30);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Les opérations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(102, 102, 255))); // NOI18N

        Ajouter.setForeground(new java.awt.Color(0, 102, 0));
        Ajouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/enr.gif"))); // NOI18N
        Ajouter.setText("Ajouter");
        Ajouter.setMaximumSize(new java.awt.Dimension(87, 23));
        Ajouter.setMinimumSize(new java.awt.Dimension(87, 23));
        Ajouter.setPreferredSize(new java.awt.Dimension(111, 29));
        Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterActionPerformed(evt);
            }
        });

        Modifier.setForeground(new java.awt.Color(0, 102, 0));
        Modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icone_modifier.gif"))); // NOI18N
        Modifier.setText("Modifier");
        Modifier.setMaximumSize(new java.awt.Dimension(111, 29));
        Modifier.setMinimumSize(new java.awt.Dimension(111, 29));
        Modifier.setPreferredSize(new java.awt.Dimension(111, 29));
        Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });

        Change.setForeground(new java.awt.Color(0, 102, 0));
        Change.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/noloc_env_search_icon.gif"))); // NOI18N
        Change.setText("Rechercher");
        Change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeActionPerformed(evt);
            }
        });

        Supprimer.setForeground(new java.awt.Color(0, 102, 0));
        Supprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/overview_button_delete.gif"))); // NOI18N
        Supprimer.setText("Supprimer");
        Supprimer.setPreferredSize(new java.awt.Dimension(111, 29));
        Supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerActionPerformed(evt);
            }
        });

        Afficher.setForeground(new java.awt.Color(0, 102, 0));
        Afficher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images.jpg"))); // NOI18N
        Afficher.setText("Afficher");
        Afficher.setPreferredSize(new java.awt.Dimension(111, 29));
        Afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfficherActionPerformed(evt);
            }
        });

        Nouveau.setForeground(new java.awt.Color(0, 102, 0));
        Nouveau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user-reset.png"))); // NOI18N
        Nouveau.setText("Nouveau");
        Nouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NouveauActionPerformed(evt);
            }
        });

        jLabel7.setText("Rechercher par :");

        jRadioCode.setText("Code");
        jRadioCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioCodeActionPerformed(evt);
            }
        });

        jRadioNom.setText("Nom");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Modifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioCode)
                    .addComponent(jRadioNom))
                .addGap(18, 18, 18)
                .addComponent(txtrechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Change)
                .addGap(18, 18, 18)
                .addComponent(Supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Nouveau)
                .addGap(18, 18, 18)
                .addComponent(Afficher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Afficher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Modifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Nouveau)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Change))
                    .addComponent(jRadioCode)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jRadioNom))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtrechercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 51, 1120, 80);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Les informations du Fournisseur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(102, 102, 255))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Code Fournisseur");

        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Nom");

        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Adresse");

        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Ville");

        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Téléphone");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(code)
                    .addComponent(nom)
                    .addComponent(adresse)
                    .addComponent(ville)
                    .addComponent(tele, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 142, 343, 260);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listes des fournisseurs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(102, 102, 255))); // NOI18N
        jPanel3.setToolTipText("");

        tabFournisseur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabFournisseurMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabFournisseur);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(363, 142, 770, 260);

        Menu.setForeground(new java.awt.Color(0, 102, 0));
        Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/menu.gif"))); // NOI18N
        Menu.setText("Menu");
        Menu.setPreferredSize(new java.awt.Dimension(111, 29));
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed(evt);
            }
        });
        getContentPane().add(Menu);
        Menu.setBounds(620, 440, 111, 29);

        Quitter.setForeground(new java.awt.Color(0, 102, 0));
        Quitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bouton_fermer.png"))); // NOI18N
        Quitter.setText("Quitter");
        Quitter.setPreferredSize(new java.awt.Dimension(111, 29));
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });
        getContentPane().add(Quitter);
        Quitter.setBounds(800, 440, 111, 29);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/d8e8c57e4c07ddfdbe387271e2930732_large.jpeg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(-410, 0, 1580, 580);

        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(1179, 554));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
// Bouton Ajouter un fournisseur
    
    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed
           
        code.setVisible(true);
        remplir();
        if (code.getText().length() != 0 && nom.getText().length() != 0 && adresse.getText().length() != 0 && ville.getText().length() != 0 && tele.getText().length() != 0) 
        {
            if(f.code(code.getText()))
            {
                javax.swing.JOptionPane.showMessageDialog(null, "Le fournisseur deja ajouter", "AJOUTER", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                           
            }else
            {
            if (f.Ajouter(code.getText(), nom.getText(), adresse.getText(), ville.getText(), Integer.parseInt(tele.getText())) == 1)
            {
                javax.swing.JOptionPane.showMessageDialog(null, "Ajout avec succes", "AJOUTER", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            nouveau(); 
            } 
            else
            {
                javax.swing.JOptionPane.showMessageDialog(null, "le fournisseur n'est pas ajouter ", "AJOUTER", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            }

            }
    }//GEN-LAST:event_AjouterActionPerformed
    }
// Bouton de retour au Menu
    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
        
            fenetredemarrage fen = new fenetredemarrage();
            fen.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_MenuActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        

    }//GEN-LAST:event_formWindowOpened
// Bouton Afficher un fournisseur

    private void AfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfficherActionPerformed
    
        tabFournisseur.setModel(tb);
        afficher();
        deplacer(0);
    }//GEN-LAST:event_AfficherActionPerformed
// Bouton modifier un fournisseur
    private void ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierActionPerformed
        
        remplir();
       
        if ( nom.getText().length() != 0 && adresse.getText().length() != 0 && ville.getText().length() != 0 && tele.getText().length() != 0) 
        {
            if (JOptionPane.showConfirmDialog(null, "conffirmer la modification", "modification", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
            {
                if (f.modifier(code.getText(), nom.getText(), adresse.getText(), ville.getText(), Integer.parseInt(tele.getText())) == 1) 
                {
                    javax.swing.JOptionPane.showMessageDialog(null, "Modifier avec succes", "Modifier", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    nouveau();
                }
            }    
            else 
            {
                javax.swing.JOptionPane.showMessageDialog(null, "le fournisseur n'est pas modifier ", "Modifier", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_ModifierActionPerformed
// Foncion tabFournisseurMouseClicked qui permet de si on clique sur une  ligne les informations de ce ligne s'affichent sur les champs du text
    private void tabFournisseurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabFournisseurMouseClicked
        try {
            i = tabFournisseur.getSelectedRow();
            deplacer(i);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Ajout avec succes", "AJOUTER", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        }


    }//GEN-LAST:event_tabFournisseurMouseClicked
//Bouton Supprimer un Fournisseur
    private void SupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "conffirmer la suppression", "Supprimer", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) 
        {
            if (f.supprimer(code.getText()) == 1) 
            {
                javax.swing.JOptionPane.showMessageDialog(null, "Supprimer avec succes", "Supprimer", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                nouveau();
            }
        }
        else 
        {
            javax.swing.JOptionPane.showMessageDialog(null, "le fournisseur n'est pas Supprimer ", "Supprimer", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_SupprimerActionPerformed

    private void jRadioCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioCodeActionPerformed
//Bouton Nouveau Fournisseur
    private void NouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NouveauActionPerformed
    nouveau();        
    }//GEN-LAST:event_NouveauActionPerformed
//Fonction ChangeActionPerformed permet de changer les jRadioButtons
    private void ChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeActionPerformed
        try { fourni f2 = new fourni();
            tb.setRowCount(0);
            if (jRadioCode.isSelected()) {
               
                f2 = f.rechercherCode(txtrechercher.getText());
                
            }
            if (jRadioNom.isSelected()) {
               
                f2 = f.rechercherNom(txtrechercher.getText());
                
            }
                Object[] a = {f2.getCode(), f2.getNom(), f2.getAdresse(), f2.getVille(), f2.getTele()};
                tb.addRow(a);

            i = 0;
            deplacer(i);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "le fournisseur n'existe pas ", "Rechercher", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            nouveau();

        }
    }//GEN-LAST:event_ChangeActionPerformed
//Bouton Quiter le feuille du fournisseur
    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
       this.hide();
    }//GEN-LAST:event_QuitterActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new connexion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Afficher;
    private javax.swing.JButton Ajouter;
    private javax.swing.JButton Change;
    private javax.swing.JButton Menu;
    private javax.swing.JButton Modifier;
    private javax.swing.JButton Nouveau;
    private javax.swing.JButton Quitter;
    private javax.swing.JButton Supprimer;
    private javax.swing.JTextField adresse;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JTextField code;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioCode;
    private javax.swing.JRadioButton jRadioNom;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nom;
    private javax.swing.JTable tabFournisseur;
    private javax.swing.JTextField tele;
    private javax.swing.JTextField txtrechercher;
    private javax.swing.JTextField ville;
    // End of variables declaration//GEN-END:variables

}
