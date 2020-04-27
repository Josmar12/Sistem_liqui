
package modelos;

import java.sql.Date;


public class liquidacion {
    
    private int id_liquidacion;
    private String fac_proveedor;
    private String nom_proveedor;
    private Date fecha;

    public liquidacion(int id_liquidacion, String fac_proveedor, String nom_proveedor, Date fecha) {
        this.id_liquidacion = id_liquidacion;
        this.fac_proveedor = fac_proveedor;
        this.nom_proveedor = nom_proveedor;
        this.fecha = fecha;
    }

    public int getId_liquidacion() {
        return id_liquidacion;
    }

    public void setId_liquidacion(int id_liquidacion) {
        this.id_liquidacion = id_liquidacion;
    }

    public String getFac_proveedor() {
        return fac_proveedor;
    }

    public void setFac_proveedor(String fac_proveedor) {
        this.fac_proveedor = fac_proveedor;
    }

    public String getNom_proveedor() {
        return nom_proveedor;
    }

    public void setNom_proveedor(String nom_proveedor) {
        this.nom_proveedor = nom_proveedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
