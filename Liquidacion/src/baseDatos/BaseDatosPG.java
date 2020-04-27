package baseDatos;

import Properties.PropiedadesSistema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDatosPG {

    private String db = "db_liquidacion";
//    private String user = "clinicajubileo";
//    private String password = "clinicajubileo";
    private String url = "jdbc:mysql://10.196.53.198/" + db;
    private String user = "";
    private String password = "";
//    private String url = "jdbc:mysql://localhost/db_centrosistemas";
    private Connection conn = null;

    static Statement sentencia;
    static ResultSet resultado;

    public BaseDatosPG() {
//
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(PropiedadesSistema.urlDB, PropiedadesSistema.usuarioBD, PropiedadesSistema.passDB);
            sentencia = conn.createStatement();

            if (conn != null) {
                System.out.println("Conexion a la base de datos " + PropiedadesSistema.urlDB + "...... Listo");
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(this.url, this.user, this.password);
//            sentencia = conn.createStatement();
//
//            if (conn != null) {
//                System.out.println("Conexion a la base de datos " + this.db + "...... Listo");
//            }
//        } catch (Exception ex) {
//            System.out.println("Error: " + ex);
//        }
    }

    public Connection getConn() {
        return conn;
    }

    public void desconectardb() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatosPG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
