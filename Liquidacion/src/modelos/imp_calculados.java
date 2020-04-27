package modelos;

import java.sql.Date;

public class imp_calculados {

    private int id_imp_cal;
    //TABLA PRODUCTOS
    private String codigo;
    private int cantidad;
    private String descripcion;
    private String marca;
    private double precio;
    //
    private double p_cif;
    private double dai;
    private double isc;
    private double tf;
    private double gto_agencia;
    private double costo_total;
    private double costo_unitario;
    private double minorista;
    private double licitacion;
    private double mayorista;
    private double mpyme;
    private double publico;
    private double enemigo;
    private double malo;

    //TABLA LIQUIDACIÓN
    private String id_liquidacion;
    private String n_factura;
    private String nom_proveedor;
    private Date fecha;

    public imp_calculados(int id_imp_cal, String codigo, int cantidad, String descripcion, String marca, double precio, double p_cif, double dai, double isc, double tf, double gto_agencia, double costo_total, double costo_unitario, double minorista, double licitacion, double mayorista, double mpyme, double publico, double enemigo, double malo) {
        this.id_imp_cal = id_imp_cal;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precio = precio;
        this.p_cif = p_cif;
        this.dai = dai;
        this.isc = isc;
        this.tf = tf;
        this.gto_agencia = gto_agencia;
        this.costo_total = costo_total;
        this.costo_unitario = costo_unitario;
        this.minorista = minorista;
        this.licitacion = licitacion;
        this.mayorista = mayorista;
        this.mpyme = mpyme;
        this.publico = publico;
        this.enemigo = enemigo;
        this.malo = malo;
    }

    public imp_calculados(String codigo, int cantidad, String descripcion, String marca, double precio, double p_cif, double dai, double isc, double tf, double gto_agencia, double costo_total, double costo_unitario, double minorista, double licitacion, double mayorista, double mpyme, double publico, double enemigo, double malo) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precio = precio;
        this.p_cif = p_cif;
        this.dai = dai;
        this.isc = isc;
        this.tf = tf;
        this.gto_agencia = gto_agencia;
        this.costo_total = costo_total;
        this.costo_unitario = costo_unitario;
        this.minorista = minorista;
        this.licitacion = licitacion;
        this.mayorista = mayorista;
        this.mpyme = mpyme;
        this.publico = publico;
        this.enemigo = enemigo;
        this.malo = malo;
    }

    public imp_calculados(String codigo, int cantidad, String descripcion, String marca, double precio, double p_cif, double dai, double isc, double tf, double gto_agencia, double costo_total, double costo_unitario, double minorista, double licitacion, double mayorista, double mpyme, double publico, double enemigo, double malo, String id_liquidacion) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precio = precio;
        this.p_cif = p_cif;
        this.dai = dai;
        this.isc = isc;
        this.tf = tf;
        this.gto_agencia = gto_agencia;
        this.costo_total = costo_total;
        this.costo_unitario = costo_unitario;
        this.minorista = minorista;
        this.licitacion = licitacion;
        this.mayorista = mayorista;
        this.mpyme = mpyme;
        this.publico = publico;
        this.enemigo = enemigo;
        this.malo = malo;
        this.id_liquidacion = id_liquidacion;
    }

    public imp_calculados(String id_liquidacion, String n_factura, String nom_proveedor, Date fecha) {
        this.id_liquidacion = id_liquidacion;
        this.n_factura = n_factura;
        this.nom_proveedor = nom_proveedor;
        this.fecha = fecha;
    }

    public int getId_imp_cal() {
        return id_imp_cal;
    }

    public void setId_imp_cal(int id_imp_cal) {
        this.id_imp_cal = id_imp_cal;
    }

    public double getP_cif() {
        return p_cif;
    }

    public void setP_cif(double p_cif) {
        this.p_cif = p_cif;
    }

    public double getDai() {
        return dai;
    }

    public void setDai(double dai) {
        this.dai = dai;
    }

    public double getIsc() {
        return isc;
    }

    public void setIsc(double isc) {
        this.isc = isc;
    }

    public double getTf() {
        return tf;
    }

    public void setTf(double tf) {
        this.tf = tf;
    }

    public double getGto_agencia() {
        return gto_agencia;
    }

    public void setGto_agencia(double gto_agencia) {
        this.gto_agencia = gto_agencia;
    }

    public double getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(double costo_total) {
        this.costo_total = costo_total;
    }

    public double getMinorista() {
        return minorista;
    }

    public void setMinorista(double minorista) {
        this.minorista = minorista;
    }

    public double getLicitacion() {
        return licitacion;
    }

    public void setLicitacion(double licitacion) {
        this.licitacion = licitacion;
    }

    public double getMayorista() {
        return mayorista;
    }

    public void setMayorista(double mayorista) {
        this.mayorista = mayorista;
    }

    public double getMpyme() {
        return mpyme;
    }

    public void setMpyme(double mpyme) {
        this.mpyme = mpyme;
    }

    public double getPublico() {
        return publico;
    }

    public void setPublico(double publico) {
        this.publico = publico;
    }

    public double getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(double enemigo) {
        this.enemigo = enemigo;
    }

    public double getMalo() {
        return malo;
    }

    public void setMalo(double malo) {
        this.malo = malo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getId_liquidacion() {
        return id_liquidacion;
    }

    public void setId_liquidacion(String id_liquidacion) {
        this.id_liquidacion = id_liquidacion;
    }

    public String getN_factura() {
        return n_factura;
    }

    public void setN_factura(String n_factura) {
        this.n_factura = n_factura;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(double costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

}
