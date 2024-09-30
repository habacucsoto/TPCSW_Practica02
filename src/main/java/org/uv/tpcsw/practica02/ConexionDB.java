package org.uv.tpcsw.practica02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {

    private static ConexionDB cx = null;

    public static ConexionDB getInstance() {
        if (cx == null) {
            cx = new ConexionDB();
        }
        return cx;
    }

    private Connection con = null;

    public ConexionDB() {
        try {
            String url = "jdbc:postgresql://localhost:5432/prueba";
            con = DriverManager.getConnection(url, "postgres", "admin");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet select(String sql ){
        try {
            Statement stm = con.createStatement();
            ResultSet reg=stm.executeQuery(sql);
            return reg;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean execute(TransactionDB transaction){
        return transaction.execute(con);
    }

    public boolean execute(String sql) {
        Statement stm= null;
        try {
            stm = con.createStatement();
            return stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}