/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


public class detalle_impuesto {
    private int id_detalle_impuesto;
    private double t_p_cif;
    private double t_dai;
    private double t_isc;
    private double t_tf;
    private double t_gasto_agen;
    private double t_costo_total;
    private double t_costo_unitario;
    private int id_imp_cal;

    public detalle_impuesto(int id_detalle_impuesto, double t_p_cif, double t_dai, double t_isc, double t_tf, double t_gasto_agen, double t_costo_total, double t_costo_unitario, int id_imp_cal) {
        this.id_detalle_impuesto = id_detalle_impuesto;
        this.t_p_cif = t_p_cif;
        this.t_dai = t_dai;
        this.t_isc = t_isc;
        this.t_tf = t_tf;
        this.t_gasto_agen = t_gasto_agen;
        this.t_costo_total = t_costo_total;
        this.t_costo_unitario = t_costo_unitario;
        this.id_imp_cal = id_imp_cal;
    }

    public int getId_detalle_impuesto() {
        return id_detalle_impuesto;
    }

    public void setId_detalle_impuesto(int id_detalle_impuesto) {
        this.id_detalle_impuesto = id_detalle_impuesto;
    }

    public double getT_p_cif() {
        return t_p_cif;
    }

    public void setT_p_cif(double t_p_cif) {
        this.t_p_cif = t_p_cif;
    }

    public double getT_dai() {
        return t_dai;
    }

    public void setT_dai(double t_dai) {
        this.t_dai = t_dai;
    }

    public double getT_isc() {
        return t_isc;
    }

    public void setT_isc(double t_isc) {
        this.t_isc = t_isc;
    }

    public double getT_tf() {
        return t_tf;
    }

    public void setT_tf(double t_tf) {
        this.t_tf = t_tf;
    }

    public double getT_gasto_agen() {
        return t_gasto_agen;
    }

    public void setT_gasto_agen(double t_gasto_agen) {
        this.t_gasto_agen = t_gasto_agen;
    }

    public double getT_costo_total() {
        return t_costo_total;
    }

    public void setT_costo_total(double t_costo_total) {
        this.t_costo_total = t_costo_total;
    }

    public double getT_costo_unitario() {
        return t_costo_unitario;
    }

    public void setT_costo_unitario(double t_costo_unitario) {
        this.t_costo_unitario = t_costo_unitario;
    }

    public int getId_imp_cal() {
        return id_imp_cal;
    }

    public void setId_imp_cal(int id_imp_cal) {
        this.id_imp_cal = id_imp_cal;
    }
    
    
           
}
