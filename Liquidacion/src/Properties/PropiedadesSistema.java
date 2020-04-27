package Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropiedadesSistema {

    public static String urlDB;
    public static String passDB;
    public static String usuarioBD;

    Properties prop = new Properties();
    InputStream is = null;

    public PropiedadesSistema() {
        try {
            is = new FileInputStream("C:/Users/PC-SOPORTE/Desktop/Liquidacion/Liquidacion/src/Properties/configuracion.properties");

            prop.load(is);
            leerPropiedades();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void leerPropiedades() {
        urlDB = prop.getProperty("urlBaseDatos");
        passDB = prop.getProperty("passBaseDatos");
        usuarioBD = prop.getProperty("usuarioBD");
    }
}
