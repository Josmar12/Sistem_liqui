/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Date;

/**
 *
 * @author PC-SOPORTE
 */
public class imp_pagados {

    //tabla impuestos pagados
    private int id_imp_pagados;
    private double tf;
    private double isc;
    private double dai;
    private double p_cif_ingre;
    private double flete_final;
    private double flete_usa;
    private double agencia;

    //RAZONES
    double timbres;
    double imp_selec;
    double derecho_aranc;
    double gto_agenci;

    private Date fecha;

    public imp_pagados() {

    }

    public imp_pagados(int id_imp_pagados, double tf, double isc, double dai, double p_cif_ingre, double flete_final, double flete_usa, double agencia, double timbres, double imp_selec, double derecho_aranc, double gto_agenci, Date fecha) {
        this.id_imp_pagados = id_imp_pagados;
        this.tf = tf;
        this.isc = isc;
        this.dai = dai;
        this.p_cif_ingre = p_cif_ingre;
        this.flete_final = flete_final;
        this.flete_usa = flete_usa;
        this.agencia = agencia;
        this.timbres = timbres;
        this.imp_selec = imp_selec;
        this.derecho_aranc = derecho_aranc;
        this.gto_agenci = gto_agenci;
        this.fecha = fecha;
    }

    public imp_pagados(double tf, double isc, double dai, double p_cif_ingre, double flete_final, double flete_usa, double agencia, double timbres, double imp_selec, double derecho_aranc, double gto_agenci, Date fecha) {

        this.tf = tf;
        this.isc = isc;
        this.dai = dai;
        this.p_cif_ingre = p_cif_ingre;
        this.flete_final = flete_final;
        this.flete_usa = flete_usa;
        this.agencia = agencia;
        this.timbres = timbres;
        this.imp_selec = imp_selec;
        this.derecho_aranc = derecho_aranc;
        this.gto_agenci = gto_agenci;
        this.fecha = fecha;
    }

    public int getId_imp_pagados() {
        return id_imp_pagados;
    }

    public void setId_imp_pagados(int id_imp_pagados) {
        this.id_imp_pagados = id_imp_pagados;
    }

    public double getTf() {
        return tf;
    }

    public void setTf(double tf) {
        this.tf = tf;
    }

    public double getIsc() {
        return isc;
    }

    public void setIsc(double isc) {
        this.isc = isc;
    }

    public double getDai() {
        return dai;
    }

    public void setDai(double dai) {
        this.dai = dai;
    }

    public double getP_cif_ingre() {
        return p_cif_ingre;
    }

    public void setP_cif_ingre(double p_cif_ingre) {
        this.p_cif_ingre = p_cif_ingre;
    }

    public double getFlete_final() {
        return flete_final;
    }

    public void setFlete_final(double flete_final) {
        this.flete_final = flete_final;
    }

    public double getFlete_usa() {
        return flete_usa;
    }

    public void setFlete_usa(double flete_usa) {
        this.flete_usa = flete_usa;
    }

    public double getAgencia() {
        return agencia;
    }

    public void setAgencia(double agencia) {
        this.agencia = agencia;
    }

    public double getTimbres() {
        return timbres;
    }

    public void setTimbres(double timbres) {
        this.timbres = timbres;
    }

    public double getImp_selec() {
        return imp_selec;
    }

    public void setImp_selec(double imp_selec) {
        this.imp_selec = imp_selec;
    }

    public double getDerecho_aranc() {
        return derecho_aranc;
    }

    public void setDerecho_aranc(double derecho_aranc) {
        this.derecho_aranc = derecho_aranc;
    }

    public double getGto_agenci() {
        return gto_agenci;
    }

    public void setGto_agenci(double gto_agenci) {
        this.gto_agenci = gto_agenci;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
