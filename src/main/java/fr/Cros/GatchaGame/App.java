package fr.Cros.GatchaGame;
import fr.Cros.GatchaGame.Bdd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class App{

    private JPanel panel1;  // panel de test ne pas enlever




    // Création du tableau comprenant les différent personnages d'un portail
    // les probabilités sont effectué en mettant plusieurs fois les meme personnages
    String[][] Portail = {
            {"P13", "Covided", "Dylan"},            // tous les personnages disponibles dans le portail
            {"P14", "Télékinésiste", "Nicolas S."},           // ils y sont plusieurs fois pour permettre
            {"P15", "Matthias forever", "Garoby"},         // de faire les taux d'apparition du personnage
            {"P16", "Dépréssif", "Théo"},
            {"P06", "Perché", "Mehdi"},
            {"P13", "Covided", "Dylan"},                        // taux : "Covided"; "Dylan" : 2/20
            {"P14", "Télékinésiste", "Nicolas S."},           // taux : "Télékinesiste"; "Nicolas S." : 3/20
            {"P15", "Matthias forever", "Garoby"},         // taux : "Matthias forever"; "Garoby" : 3/20
            {"P16", "Dépréssif", "Théo"},                 // taux : "Dépressif"; "Théo" : 3/20
            {"P05", "Vomito", "Clement"},                           // taux : "Vomito"; "Clement" : 4/20
            {"P14", "Télékinésiste", "Nicolas S."},               // taux : "Perché"; "Mehdi" : 5/20
            {"P06", "Perché", "Mehdi"},
            {"P16", "Dépréssif", "Théo"},
            {"P06", "Perché", "Mehdi"},
            {"P15", "Matthias forever", "Garoby"},
            {"P05", "Vomito", "Clement"},
            {"P06", "Perché", "Mehdi"},
            {"P05", "Vomito", "Clement"},
            {"P06", "Perché", "Mehdi"},
            {"P05", "Vomito", "Clement"}
    };

    private JLabel GachaTitre;
    private ImageIcon imgBackground;

    private JLabel InterfaceApp;
    private JButton TirageBtn;
    private JButton BoxBtn;
    private JButton Accueil;
    private JButton Tirages;
    private JButton Box;
    private ImageIcon ImgBtnPerso;
    private  ImageIcon ImgBtnTirage;

    private ImageIcon imgPortailPilier;
    private JLabel imgPortailPilierLabel;

    private JButton Tiragesx1;
    private  ImageIcon ImgTiragex1;
    private JButton Tiragesx10;
    private  ImageIcon ImgTiragex10;




    private  JTextArea contenuBox;

    Bdd MaBdd = new Bdd();

    public App() {

        /*------------------------------------------Accueil--------------------------------------------------------------*/
        imgBackground = new ImageIcon(this.getClass().getResource("/Images/SoloLevening.jpeg")); // récupération de l'image dans les ressources
        InterfaceApp = new JLabel(imgBackground);       // création du label
        InterfaceApp.setSize(300, 700);     // taille du label défini


        ImgBtnTirage = new ImageIcon(this.getClass().getResource("/Images/boutonTirage.png"));

        TirageBtn = new JButton(ImgBtnTirage);                 // création du button avec son nom
        //rendre le bouton transparent
        TirageBtn.setOpaque(false);
        //enlever la zone de contenu
        TirageBtn.setContentAreaFilled(false);
        //enlever la bordure
        TirageBtn.setBorderPainted(false);
        TirageBtn.setBounds(0,600,190,200);   // taille du bouton défini
        InterfaceApp.add(TirageBtn);                           // ajout du bouton au label

        ImgBtnPerso = new ImageIcon(this.getClass().getResource("/Images/boutonPerso.png")); // lien de l'image
        BoxBtn = new JButton(ImgBtnPerso);                // création du button avec son nom
        //rendre le bouton transparent
        BoxBtn.setOpaque(false);
        //enlever la zone de contenu
        BoxBtn.setContentAreaFilled(false);
        //enlever la bordure
        BoxBtn.setBorderPainted(false);
        BoxBtn.setBounds(220,600,190,200);    // taille du bouton défini
        InterfaceApp.add(BoxBtn);                              // ajout du bouton au label


        GachaTitre = new JLabel(" GachaGame du Bachelor");              // déclaration d'un label
        GachaTitre.setBounds(100, 70, 200, 50);             // mise en page
        Font fontTitre = new Font("Arial", Font.BOLD, 16);          // |
        GachaTitre.setFont(fontTitre);                                       //  |
        GachaTitre.setForeground(new Color(255,255,255));             // |
        GachaTitre.setOpaque(true);                                           // |
        GachaTitre.setBackground(new Color(0,0,0));                   // |
        InterfaceApp.add(GachaTitre);                                       // ajout  de l'élément au label d'affichage

        /*--------------------------------------------------------------------------------------------------------------*/

        /*------------------------------------------Menu-----------------------------------------------------------------*/
        Accueil = new JButton("Accueil");                   // création du button avec son nom
        Accueil.setBounds(0,0, 133, 30);      // taille du bouton défini
        InterfaceApp.add(Accueil);                             // ajout du bouton au label

        Tirages = new JButton("Tirages");                   // création du button avec son nom
        Tirages.setBounds(133,0, 133, 30);    // taille du bouton défini
        InterfaceApp.add(Tirages);                             // ajout du bouton au label

        Box = new JButton("Box");                           // création du button avec son nom
        Box.setBounds(266,0, 133, 30);        // taille du bouton défini
        InterfaceApp.add(Box);                                 // ajout du bouton au label
        /*---------------------------------------------------------------------------------------------------------------*/

        /*------------------------------------------Onglet Tirage-------------------------------------------------------*/
        ImgTiragex1 = new ImageIcon(this.getClass().getResource("/Images/Tiragex1.png")); // lien de l'image

        Tiragesx1 = new JButton(ImgTiragex1);                 // création du button avec son nom
        //rendre le bouton transparent
        Tiragesx1.setOpaque(false);
        //enlever la zone de contenu
        Tiragesx1.setContentAreaFilled(false);
        //enlever la bordure
        Tiragesx1.setBorderPainted(false);
        Tiragesx1.setBounds(0,650,190,70);   // taille du bouton défini
        Tiragesx1.setVisible(false);
        InterfaceApp.add(Tiragesx1);                           // ajout du bouton au label


        ImgTiragex10 = new ImageIcon(this.getClass().getResource("/Images/tiragex10.png"));// lien de l'image
        Tiragesx10 = new JButton(ImgTiragex10);                // création du button avec son nom
        //rendre le bouton transparent
        Tiragesx10.setOpaque(false);
        //enlever la zone de contenu
        Tiragesx10.setContentAreaFilled(false);
        //enlever la bordure
        Tiragesx10.setBorderPainted(false);
        Tiragesx10.setBounds(220,650,190,70);    // taille du bouton défini
        Tiragesx10.setVisible(false);
        InterfaceApp.add(Tiragesx10);                              // ajout du bouton au label


        imgPortailPilier = new ImageIcon(this.getClass().getResource("/Images/BanniereCovided.png")); // récupération de l'image dans les ressources
        imgPortailPilierLabel = new JLabel(imgPortailPilier);       // création du label
        imgPortailPilierLabel.setBounds(0,0,400,800);    // taille du label défini
        imgPortailPilierLabel.setVisible(false);                    // cacher l'élément
        InterfaceApp.add(imgPortailPilierLabel);                      // ajout  de l'élément au label d'affichage





        /*--------------------------------------------------------------------------------------------------------------*/

        /*-----------------------------------------Onglet Box--------------------------------------------------------*/





        contenuBox = new JTextArea();
        contenuBox.setBounds(50,120,300,500);
        contenuBox.setText(MaBdd.LireBDD());
        contenuBox.setVisible(false);// cacher l'élément

        InterfaceApp.add(contenuBox);




        /*---------------------------------------------------------------------------------------------------------------*/




        JFrame frame= new JFrame("GachaGame du Bachelor");    // Donne un nom a la fenettre

        frame.add(InterfaceApp);                            // ajout du label a la fenetre

        frame.setSize(400,700);     // regler la taille de la fenettre


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);     // Affiche la fenettre







        /*-------------------------------------------------------Button menu----------------------------------------------*/

        Tirages.addActionListener(new ActionListener() {                  // si on clique sur le boutton
            @Override
            public void actionPerformed(ActionEvent e) {

                GachaTitre.setVisible(false);// cacher l'élément
                BoxBtn.setVisible(false);
                TirageBtn.setVisible(false);
                contenuBox.setVisible(false);
                imgPortailPilierLabel.setVisible(true);// afficher l'élément
                Tiragesx1.setVisible(true);
                Tiragesx10.setVisible(true);



            }
        });

        Accueil.addActionListener(new ActionListener() {                  // si on clique sur le boutton
            @Override
            public void actionPerformed(ActionEvent e) {

                contenuBox.setVisible(false);// cacher l'élément
                imgPortailPilierLabel.setVisible(false);
                Tiragesx1.setVisible(false);
                Tiragesx10.setVisible(false);

                GachaTitre.setVisible(true);// afficher l'élément
                BoxBtn.setVisible(true);
                TirageBtn.setVisible(true);

            }
        });

        Box.addActionListener(new ActionListener() {                  // si on clique sur le boutton
            @Override
            public void actionPerformed(ActionEvent e) {


                contenuBox.setVisible(true);// afficher l'élément
                imgPortailPilierLabel.setVisible(false);// cacher l'élément
                Tiragesx1.setVisible(false);
                Tiragesx10.setVisible(false);

                GachaTitre.setVisible(false);
                BoxBtn.setVisible(false);
                TirageBtn.setVisible(false);

                contenuBox.setText(MaBdd.LireBDD()); // actualise le text area quand on va sur l'onglet


            }
        });


        /*----------------------------------------------------------------------------------------------------------------*/


        /*-------------------------------------------------------Button Accueil----------------------------------------------*/

        BoxBtn.addActionListener(new ActionListener() {                  // si on clique sur le boutton
            @Override
            public void actionPerformed(ActionEvent e) {

                contenuBox.setVisible(true);                    // systeme qui cache et affiche les éléments en  fonction de la page choisit
                imgPortailPilierLabel.setVisible(false);
                Tiragesx1.setVisible(false);
                Tiragesx10.setVisible(false);

                GachaTitre.setVisible(false);
                BoxBtn.setVisible(false);
                TirageBtn.setVisible(false);
                contenuBox.setText(MaBdd.LireBDD()); // actualise le text area quand on va sur l'onglet
            }
        });

        TirageBtn.addActionListener(new ActionListener() {                  // si on clique sur le boutton
            @Override
            public void actionPerformed(ActionEvent e) {
                contenuBox.setVisible(false); // systeme qui cache et affiche les éléments en  fonction de la page choisit
                GachaTitre.setVisible(false);
                BoxBtn.setVisible(false);
                TirageBtn.setVisible(false);

                imgPortailPilierLabel.setVisible(true);
                Tiragesx1.setVisible(true);
                Tiragesx10.setVisible(true);


            }
        });



        /*----------------------------------------------------------------------------------------------------------------*/




        Tiragesx1.addActionListener(new ActionListener() {                  // si on clique sur le bouton
            @Override
            public void actionPerformed(ActionEvent e) {

                int Perso = (int) (Math.random()* Portail.length);  // tire un nombre aléatoire dans le tableau en fonction de sa taille

                JOptionPane.showMessageDialog(null,Portail[Perso][2] + ", " + Portail[Perso][1] + "\n");

                 // enregistre le personnage obtenu dans le fichier texte comprennant les personnages du compte

                String GachaID = Portail[Perso][0];
                String titre = Portail[Perso][1];
                String nom = Portail[Perso][2];
                String carte = Portail[Perso][2];
                String logo = Portail[Perso][2];
                int ATK = 0;                        //valeurs non fonctionnel (0 dans la bdd)
                int DEF = 0;                        //valeurs non fonctionnel (0 dans la bdd)
                int PV = 0;                         //valeurs non fonctionnel (0 dans la bdd)
                MaBdd.EnregistrerBDD(GachaID, titre, nom, carte, logo, ATK, DEF, PV); // appel de la méthode qui permet l'enregistrement sur la bdd



            }
        });

        Tiragesx10.addActionListener(new ActionListener() { // si on clique sur le boutton
            @Override
            public void actionPerformed(ActionEvent e) {
                int Perso = 0;
                for (int t=0; t<10; ++t){
                    Perso = (int) (Math.random()* Portail.length);  // tire un nombre aléatoire dans le tableau en fonction de sa taille
                    JOptionPane.showMessageDialog(null,Portail[Perso][2] + ", " + Portail[Perso][1] + "\n");
                      // enregistre le personnage obtenu dans le fichier texte comprennant les personnages du compte
                    String GachaID = Portail[Perso][0];
                    String titre = Portail[Perso][1];
                    String nom = Portail[Perso][2];
                    String carte = Portail[Perso][2];
                    String logo = Portail[Perso][2];
                    int ATK = (int) Math.random();//valeurs non fonctionnel (0 dans la bdd)
                    int DEF = (int) Math.random();//valeurs non fonctionnel (0 dans la bdd)
                    int PV = (int) Math.random();//valeurs non fonctionnel (0 dans la bdd)
                    MaBdd.EnregistrerBDD(GachaID, titre, nom, carte, logo, ATK, DEF, PV); // appel de la méthode qui permet l'enregistrement sur la bdd
                }


            }
        });




    }









    public static void main(String[]args){


        new App();  // création de l'application à l'exécution du code




    }







}
