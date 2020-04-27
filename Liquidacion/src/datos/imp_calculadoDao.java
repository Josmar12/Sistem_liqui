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
import modelos.imp_calculados;
import modelos.imp_pagados;
import modelos.producto;

/**
 *
 * @author PC-SOPORTE
 */
public class imp_calculadoDao {

    PreparedStatement ps = null;

    public imp_calculadoDao() {

    }

    public imp_calculados crearCompra(imp_calculados compra) throws FileNotFoundException {
        BaseDatosPG base = new BaseDatosPG();
        try {

            String sql = "insert into imp_calculado (codigo_pro,cantidad,descripcion,marca,precio,p_cif,dai,isc,tf,gato_agencia,costo_total,costo_unitario,"
                    + "minorista,licitacion,mayorista,pyme,publico,enemigo,malo)"
                    + "values(?,?,?,?,?,?,?,?, ? ,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = base.getConn().prepareStatement(sql);
            
            ps.setString(1, compra.getCodigo());
            ps.setInt(2, compra.getCantidad());
            ps.setString(3, compra.getDescripcion());
            ps.setString(4, compra.getMarca());
            ps.setDouble(5, compra.getPrecio());
            ps.setDouble(6, compra.getP_cif());
            ps.setDouble(7, compra.getDai());
            ps.setDouble(8, compra.getIsc());
            ps.setDouble(9, compra.getTf());
            ps.setDouble(10, compra.getGto_agencia());
            ps.setDouble(11, compra.getCosto_total());
            ps.setDouble(12, compra.getCosto_unitario());
            ps.setDouble(13, compra.getMinorista());
            ps.setDouble(14, compra.getLicitacion());
            ps.setDouble(15, compra.getMayorista());
            ps.setDouble(16, compra.getMpyme());
            ps.setDouble(17, compra.getPublico());
            ps.setDouble(18, compra.getEnemigo());
            ps.setDouble(19, compra.getMalo());

            ps.executeUpdate();

//            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (base.getConn() != null) {
                base.desconectardb();
            }
        }
        return compra;
    }
    
    public void actualizarCompra(imp_calculados producto) {
        BaseDatosPG base = new BaseDatosPG();
        try {

            
                String sql = " UPDATE imp_calculado SET codigo_pro=?,cantidad=?, descripcion=?,marca=?,"
                        + "precio=?,p_cif=?,dai=?,isc=?,tf=?,gato_agencia=?,costo_total=?,costo_unitario=?,"
                        + "minorista=?,licitacion=?,mayorista=?,pyme=?,publico=?,enemigo=?,malo=?"
                        + " WHERE id_imp_cal=?";

                ps = base.getConn().prepareStatement(sql);

                ps.setString(1, producto.getCodigo());
                ps.setInt(2, producto.getCantidad());
                ps.setString(3, producto.getDescripcion());
                ps.setString(4, producto.getMarca());
                ps.setDouble(5, producto.getPrecio());
                ps.setDouble(6, producto.getP_cif());
                ps.setDouble(7, producto.getDai());
                ps.setDouble(8, producto.getIsc());
                ps.setDouble(9, producto.getTf());
                ps.setDouble(10, producto.getGto_agencia());
                ps.setDouble(11, producto.getCosto_total());
                ps.setDouble(12, producto.getCosto_unitario());
                ps.setDouble(13, producto.getMinorista());
                ps.setDouble(14, producto.getLicitacion());
                ps.setDouble(15, producto.getMayorista());
                ps.setDouble(16, producto.getMpyme());
                ps.setDouble(17, producto.getPublico());
                ps.setDouble(18, producto.getEnemigo());
                ps.setDouble(19, producto.getMalo());
                ps.setInt(20, producto.getId_imp_cal());
            
                ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (base.getConn() != null) {
                base.desconectardb();
            }
        }
    }
    
    public ArrayList<imp_calculados> obtenerImpuestoC() {

        BaseDatosPG base = new BaseDatosPG();
        ArrayList<imp_calculados> listaImpuestoC = new ArrayList<imp_calculados>();
        try {

            String sql = "select * from imp_calculado order by id_imp_cal desc";

            PreparedStatement sentencia = base.getConn().prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
//                
                Integer id = rs.getInt("id_imp_cal");
                String codProd = rs.getString("codigo_pro");
                int cantidad = rs.getInt("cantidad");
                String descripcion = rs.getString("descripcion");
                String marca = rs.getString("marca");
                double precio = rs.getDouble("precio");
                double p_cif = rs.getDouble("p_cif");
                double dai = rs.getDouble("dai");
                double isc = rs.getDouble("isc");
                double tf = rs.getDouble("tf");
                double agencia = rs.getDouble("gato_agencia");
                double costo_total = rs.getDouble("costo_total");
                double costo_unitario = rs.getDouble("costo_unitario");
                double minorista = rs.getDouble("minorista");
                double licitacion = rs.getDouble("licitacion");
                double mayorista = rs.getDouble("mayorista");
                double mpyme = rs.getDouble("pyme");
                double publico = rs.getDouble("publico");
                double enemigo = rs.getDouble("enemigo");
                double malo = rs.getDouble("malo");

                imp_calculados calculado = new imp_calculados(id,codProd, cantidad, descripcion, marca, precio, p_cif, dai, isc, tf, agencia,
                        costo_total, costo_unitario, minorista, licitacion, mayorista, mpyme, publico, enemigo, malo);

                listaImpuestoC.add(calculado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            if (base.getConn() != null) {
                base.desconectardb();
            }
        }
        return listaImpuestoC;
    }

    public ArrayList<imp_calculados> borrarImpuestoC() {

        BaseDatosPG base = new BaseDatosPG();
        try {

            String sql = "DELETE FROM imp_calculado WHERE id_imp_cal >= 0";
            PreparedStatement ps = base.getConn().prepareStatement(sql);

//            ps.setString(1, producto.getIdProducto());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            if (base.getConn() != null) {
                base.desconectardb();
            }

        }
        return null;

    }
}
