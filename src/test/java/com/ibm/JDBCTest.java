package com.ibm;


import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by Karim on 23/12/2014.
 */
public class JDBCTest extends TestCase {


    Logger logger = LoggerFactory.getLogger(JDBCTest.class);


    /**
     * Dans ce premier test unitaire, nous voyons que l'usage de JDBC
     * nous conduit à écrire beaucoup de code pour l'ouverture et la fermeture des connexions,
     * l'exécution des requêtes et la lecture des résultats.
     * **/
    public void testEliminateJDBCCode() {

        if(logger.isDebugEnabled()) {
            logger.debug("Eliminates a lot of JDBC boilerplate code..........");
        }
        Connection c = getConnection();
        logger.info("ouverture de la connexion JDBC");
        ResultSet reponse = getAllStudents(c);
        int count = 0;
       try {
           while (reponse.next()) {
              count+=1;

           }
           logger.info("il y a "+count+" résultats");
       }
       catch(SQLException se) {
       }
        finally {
           try {
               if(c!=null) {
                   c.close();
                   logger.info("fermeture de la connexion JDBC");
               }
           }
           catch(SQLException e) {

           }
       }
    }

    /** Méthode connection JDBC **/

    protected Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/myibatis", "root", "root");
        }
        catch(Exception e) {
            logger.error("erreur de connexion à la base de données: "+e.getMessage());
            return null;
        }
    }

    /** Méthode implémentation requête SQL **/
    protected ResultSet getAllStudents(Connection c) {
        ResultSet res = null;
        try {
            String sql = "select * from STUDENTS";
            PreparedStatement p = c.prepareStatement(sql);
            res = p.executeQuery();

        }
        catch(SQLException se) {
            logger.info("erreur exécution requête sql");
        }
        return res;
    }

}
