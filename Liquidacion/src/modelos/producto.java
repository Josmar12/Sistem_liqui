/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

public class producto {

    private String codigo_pro;
    private String descripcion;
    private String marca;
    private int codigo;

    public producto() {
    }

    public producto(String codigo_pro, String descripcion, String marca) {

        this.codigo_pro = codigo_pro;
        this.descripcion = descripcion;
        this.marca = marca;
    }

    public producto(int codigo, String codigo_pro,
            String descripcion, String marca) {
        this.codigo = codigo;
        this.codigo_pro = codigo_pro;
        this.descripcion = descripcion;
        this.marca = marca;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCodigo_pro() {
        return codigo_pro;
    }

    public void setCodigo_pro(String codigo_pro) {
        this.codigo_pro = codigo_pro;
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
