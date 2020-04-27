/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import baseDatos.BaseDatosPG;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.imp_pagados;
import modelos.producto;

/**
 *
 * @author PC-SOPORTE
 */
public class imp_pagadosDao {

    PreparedStatement ps = null;

    public imp_pagadosDao() {

    }

    public imp_pagados insertarImpPaga(imp_pagados pagado) throws FileNotFoundException {
        BaseDatosPG base = new BaseDatosPG();
        try {

            String sql = "INSERT INTO imp_pagados ( tf, isc, dai,p_cif_ingre,flete_final,"
                    + "flete_usa,agencia,timbres_fis,impuesto_selec,derecho_arance, gto_agenci,fecha) "
                    + "values(  ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?)";

            PreparedStatement ps = base.getConn().prepareStatement(sql);

            ps.setDouble(1, pagado.getTf());
            ps.setDouble(2, pagado.getIsc());
            ps.setDouble(3, pagado.getDai());
            ps.setDouble(4, pagado.getP_cif_ingre());
            ps.setDouble(5, pagado.getFlete_final());
            ps.setDouble(6, pagado.getFlete_usa());
            ps.setDouble(7, pagado.getAgencia());
            ps.setDouble(8, pagado.getTimbres());
            ps.setDouble(9, pagado.getImp_selec());
            ps.setDouble(10, pagado.getDerecho_aranc());
            ps.setDouble(11, pagado.getGto_agenci());
            ps.setDate(12, pagado.getFecha());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (base.getConn() != null) {
                base.desconectardb();
            }
        }
        return pagado;
    }

//    public void actualizarPagado(imp_pagados pagado) {
//        BaseDatosPG base = new BaseDatosPG();
//        try {
//
//            String sql = " UPDATE imp_calculado SET dgi=?,tf=?,isc=?,"
//                    + "dai = ?, p_cif_ingre= ?,flete_final= ?,flete_usa= ?,agencia= ?,"
//                    + "timbres_fis= ?,impuesto_selec= ?,derecho_arance= ?,fecha= ?"
//                    + " WHERE id_imp_pagados=?";
//
//            ps = base.getConn().prepareStatement(sql);
//            
//            ps.setDouble(1, pagado.getDgi());
//            ps.setDouble(2, pagado.getTf());
//            ps.setDouble(3, pagado.getIsc());
//            ps.setDouble(4, pagado.getDai());
//            ps.setDouble(5, pagado.getP_cif_ingre());
//            ps.setDouble(6, pagado.getFlete_final());
//            ps.setDouble(7, pagado.getFlete_usa());
//            ps.setDouble(8, pagado.getAgencia());
//            ps.setDouble(9, pagado.getTimbres());
//            ps.setDouble(10, pagado.getImp_selec());
//            ps.setDouble(11, pagado.getDerecho_aranc());
//            ps.setDouble(12, pagado.getGto_agenci());
//            ps.setDate(13, pagado.getFecha());
//            ps.setInt(14, pagado.getId_imp_pagados());
//            ps.executeUpdate();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            if (base.getConn() != null) {
//                base.desconectardb();
//            }
//        }
//    }

    public ArrayList<imp_pagados> obtenerImpuesto() {

        BaseDatosPG base = new BaseDatosPG();
        ArrayList<imp_pagados> listaImpuestoP = new ArrayList<imp_pagados>();
        try {

            String sql = "select * "
                    + "from imp_pagados order by id_imp_pagados desc";

            PreparedStatement sentencia = base.getConn().prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {

                double tf = rs.getDouble("tf");
                double isc = rs.getDouble("isc");
                double dai = rs.getDouble("dai");
                double p_cif = rs.getDouble("p_cif_ingre");
                double flete_final = rs.getDouble("flete_final");
                double flete_usa = rs.getDouble("flete_usa");
                double agencia = rs.getDouble("agencia");
                double timbres_fis = rs.getDouble("timbres_fis");
                double impuesto_selec = rs.getDouble("impuesto_selec");
                double derecho_arance = rs.getDouble("derecho_arance");
                double gto_agenci = rs.getDouble("gto_agenci");
                Date fecha = rs.getDate("fecha");

                imp_pagados pagados = new imp_pagados(tf, isc, dai, p_cif, flete_final, flete_usa, agencia, timbres_fis, impuesto_selec, derecho_arance, gto_agenci, fecha);

                listaImpuestoP.add(pagados);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            if (base.getConn() != null) {
                base.desconectardb();
            }
        }
        return listaImpuestoP;
    }

}
