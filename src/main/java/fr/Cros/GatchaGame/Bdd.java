package fr.Cros.GatchaGame;

import java.sql.*;

public class Bdd {
    /*------------------------------BDD ------------------------------------------------------------*/

    public void EnregistrerBDD(String GachaID, String titre, String nom, String carte, String logo, int ATQ, int DEF, int PV){ //Méthode qui permet d'envoyer des infos dans une BDD
        try{
            // 1 Charger le driver mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2 Créer la connexion
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/gatcha", "root","");
            //3 Créer un état de connexion
            String sql = "insert into box (GatchaID, titre, nom, carte, logo, ATQ, DEF, PV) " + " values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ts = con.prepareStatement(sql);

            ts.setString(1, GachaID); //Permet de définir la valeur à envoyer
            ts.setString(2, titre); //Permet de définir la valeur à envoyer
            ts.setString(3, nom); //Permet de définir la valeur à envoyer
            ts.setString(4, carte); //Permet de définir la valeur à envoyer
            ts.setString(5, logo); //Permet de définir la valeur à envoyer
            ts.setInt(6, ATQ); //Permet de définir la valeur à envoyer
            ts.setInt(7, DEF); //Permet de définir la valeur à envoyer
            ts.setInt(8, PV); //Permet de définir la valeur à envoyer



            ts.executeUpdate(); // exécute la requête
            //con.close(); //Ferme la connexion

        }catch (Exception e){
            System.out.println("ERROR :" +e.getMessage());
        }

    }

    public String LireBDD(){//Méthode pour lire dans une BD
        String Result="";
        String GatchaID="";
        String titre="";
        String nom="";
        String carte;
        String logo;

        try{ //Permet de vérifier s'il y a pas un imprévu dans le block try. S'il y en a une, l'application passe dans le catch pour la traiter
            // 1 Charger le driver mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2 Créer la connexion en y entrant l'adresse de la BDD
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/gatcha", "root","");
            //3 Créer un état de connexion
            Statement st = con.createStatement();

            //4 créer une requête de selection dans un objet de la classe ResultSet
            ResultSet res = st.executeQuery("SELECT DISTINCT GatchaID, titre, nom, carte, logo, ATQ, DEF, PV from box");

            StringBuilder sb = new StringBuilder("Vos personnages: \n\n"); // texte qui va s'auto incrémenter avec les valeur fournit tant qu'il y'a des personnages

            //  Parcourt de données dans la bdd et attribution à la variable dédiée
            while(res.next()){

                GatchaID = res.getString(1); //Recupère la valeur de la colonne
                titre = res.getString(2); //Recupère la valeur de la colonne
                nom = res.getString(3); //Recupère la valeur de la colonne
                carte = res.getString(4); //Recupère la valeur de la colonne
                logo = res.getString(5); //Recupère la valeur de la colonne


                sb.append(titre + " / " + nom);         // incrémentation de la variable par le nom et titre du personnage
                sb.append('\n');                    // retour a la ligne
                sb.append('\n');




                System.out.println(GatchaID + " / " + titre + " / " + nom +" / " + carte + " / " + logo); //Structure d'affichage des infos de la BDD dans la console
                // con.close(); //Fermeture de la bdd

            }

            Result= sb.toString(); // attribution de la variable sb dans la variable Result avec conversion vers String

        }catch (Exception e){//Traitement d'erreur du try
            System.out.println("ERROR :" +e.getMessage()); // Affiche l'erreur dans la console
        }


        return Result; // valeur affiché à l'appel de la méthode

    }
}
