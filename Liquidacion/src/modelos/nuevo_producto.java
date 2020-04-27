
package modelos;


public class nuevo_producto {
    
    private int codigo;
    private String codigo_prod;
    private int cantidad;
    private String descripcion;
    private String marca;
    private double precio;
    private double p_cif;
    private int dai;
    private int isc;
    private int tf;
            
    public nuevo_producto() {
    }

    public nuevo_producto(int codigo, String codigo_prod, int cantidad, String descripcion, String marca, double precio, double p_cif, int dai, int isc, int tf) {
        this.codigo = codigo;
        this.codigo_prod = codigo_prod;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precio = precio;
        this.p_cif = p_cif;
        this.dai = dai;
        this.isc = isc;
        this.tf = tf;
    }

    public nuevo_producto(String codigo_prod, int cantidad, String descripcion, String marca, double precio, double p_cif, int dai, int isc, int tf) {
        this.codigo_prod = codigo_prod;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precio = precio;
        this.p_cif = p_cif;
        this.dai = dai;
        this.isc = isc;
        this.tf = tf;
    }

    public int getDai() {
        return dai;
    }

    public void setDai(int dai) {
        this.dai = dai;
    }

    public int getIsc() {
        return isc;
    }

    public void setIsc(int isc) {
        this.isc = isc;
    }

    public int getTf() {
        return tf;
    }

    public void setTf(int tf) {
        this.tf = tf;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    public double getP_cif() {
        return p_cif;
    }

    public void setP_cif(double p_cif) {
        this.p_cif = p_cif;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCodigo_prod() {
        return codigo_prod;
    }

    public void setCodigo_prod(String codigo_pro) {
        this.codigo_prod = codigo_pro;
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
}
