
package datos;

import baseDatos.BaseDatosPG;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.nuevo_producto;
import modelos.producto;


public class productoDao {
        PreparedStatement ps = null;

    public productoDao() {

    }

    public producto insertarProducto(producto producto) throws FileNotFoundException {
        BaseDatosPG base = new BaseDatosPG();
        try {

            String sql = "INSERT INTO productos_fijo (codigo_pro,descripcion, marca) "
                    + "values( ?, ?, ?)";

            PreparedStatement ps = base.getConn().prepareStatement(sql);
            
            ps.setString(1, producto.getCodigo_pro());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getMarca());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (base.getConn() != null) {
                base.desconectardb();
            }
        }
        return producto;
    }
    
    public nuevo_producto insertarProductoNuevo(nuevo_producto producto) throws FileNotFoundException {
        BaseDatosPG base = new BaseDatosPG();
        try {

            String sql = "INSERT INTO productos (codigo_pro,cantidad,descripcion, marca, precio, p_cif,dai,isc,tf) "
                    + "values( ?, ?, ?,?,?,?,?,?,?)";

            PreparedStatement ps = base.getConn().prepareStatement(sql);
            
            ps.setString(1, producto.getCodigo_prod());
            ps.setInt(2, producto.getCantidad());
            ps.setString(3, producto.getDescripcion());
            ps.setString(4, producto.getMarca());
            ps.setDouble(5, producto.getPrecio());
            ps.setDouble(6, producto.getP_cif());
            ps.setInt(7, producto.getDai());
            ps.setInt(8, producto.getIsc());
            ps.setInt(9, producto.getTf());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (base.getConn() != null) {
                base.desconectardb();
            }
        }
        return producto;
    }
    public void actualizarProductoNuevo(nuevo_producto producto) {
        BaseDatosPG base = new BaseDatosPG();
        try {

            
                String sql = " UPDATE productos SET codigo_pro=?, cantidad=?,descripcion=?,marca=?,"
                        + "precio=?, p_cif=?,dai = ?, isc = ?, tf = ?"
                        + " WHERE idproductos=?";

                ps = base.getConn().prepareStatement(sql);

                ps.setString(1, producto.getCodigo_prod());
                ps.setInt(2, producto.getCantidad());
                ps.setString(3, producto.getDescripcion());
                ps.setString(4, producto.getMarca());
                ps.setDouble(5, producto.getPrecio());
                ps.setDouble(6, producto.getP_cif());
                ps.setInt(7, producto.getDai());
                ps.setInt(8, producto.getIsc());
                ps.setInt(9, producto.getTf());
                ps.setInt(10, producto.getCodigo());
            
                ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (base.getConn() != null) {
                base.desconectardb();
            }
        }
    }
    public void actualizarProducto(producto producto) {
        BaseDatosPG base = new BaseDatosPG();
        try {

            
                String sql = " UPDATE productos_fijo  SET codigo_pro=?, descripcion=?,marca=?"
                        + " WHERE id=?";

                ps = base.getConn().prepareStatement(sql);

                ps.setString(1, producto.getCodigo_pro());
                ps.setString(2, producto.getDescripcion());
                ps.setString(3, producto.getMarca());
                ps.setInt(4, producto.getCodigo());
            
                ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (base.getConn() != null) {
                base.desconectardb();
            }
        }
    }
    
    public ArrayList<producto> obtenerProductos() {

        BaseDatosPG base = new BaseDatosPG();
        ArrayList<producto> listaProductos = new ArrayList<producto>();
        try {

            String sql = "select * "
                    + "from productos_fijo order by id desc";

            PreparedStatement sentencia = base.getConn().prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                
                Integer id = rs.getInt("id");
                String codProd = rs.getString("codigo_pro");
                String descripcion = rs.getString("descripcion");
                String marca = rs.getString("marca");

                producto producto = new producto(id,codProd, descripcion, marca);

                listaProductos.add(producto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            if (base.getConn() != null) {
                base.desconectardb();
            }
        }
        return listaProductos;
    }
    
public ArrayList<nuevo_producto> obtenerProductosNuevo() {

        BaseDatosPG base = new BaseDatosPG();
        ArrayList<nuevo_producto> listaProductos1 = new ArrayList<nuevo_producto>();
        try {

            String sql = "select * "
                    + "from productos";

            PreparedStatement sentencia = base.getConn().prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                
                Integer id = rs.getInt("idproductos");
                String codProd = rs.getString("codigo_pro");
                Integer cantidad = rs.getInt("cantidad");
                String descripcion = rs.getString("descripcion");
                String marca = rs.getString("marca");
                double precio = rs.getDouble("precio");
                double p_cif = rs.getDouble("p_cif");
                Integer dai = rs.getInt("dai");
                Integer isc = rs.getInt("isc");
                Integer tf = rs.getInt("tf");
                
                nuevo_producto prod = new nuevo_producto(id, codProd,cantidad, descripcion, marca, precio, p_cif,dai,isc,tf);

                listaProductos1.add(prod);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            if (base.getConn() != null) {
                base.desconectardb();
            }
        }
        return listaProductos1;
    }

    public ArrayList<producto> obtenerProductosPorCriterio(String criterio) {

        BaseDatosPG base = new BaseDatosPG();
        ArrayList<producto> listaProductos = new ArrayList<producto>();
        try {

            String sql ="SELECT * "
                    +"FROM productos_fijo pro "
                    + "WHERE pro.codigo_pro LIKE '" + criterio + "%'";

            PreparedStatement sentencia = base.getConn().prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                
                Integer id = rs.getInt("id");
                String codProd = rs.getString("pro.codigo_pro");
                String descripcion = rs.getString("pro.descripcion");
                String marca = rs.getString("pro.marca");

                producto producto = new producto(id,codProd, descripcion, marca);
                
                listaProductos.add(producto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            if (base.getConn() != null) {
                base.desconectardb();
            }
        }
        return listaProductos;
    }
    public ArrayList<nuevo_producto> obtenerProductosNuevoPorCriterio(String criterio) {

        BaseDatosPG base = new BaseDatosPG();
        ArrayList<nuevo_producto> listaProductos1 = new ArrayList<nuevo_producto>();
        try {

            String sql ="SELECT * "
                    +"FROM productos pro "
                    + "WHERE pro.codigo_pro LIKE '" + criterio + "%'";

            PreparedStatement sentencia = base.getConn().prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                
                Integer id = rs.getInt("idproductos");
                String codProd = rs.getString("codigo_pro");
                Integer cantidad = rs.getInt("cantidad");
                String descripcion = rs.getString("descripcion");
                String marca = rs.getString("marca");
                double precio = rs.getDouble("precio");
                double p_cif = rs.getDouble("p_cif");
                Integer dai = rs.getInt("dai");
                Integer isc = rs.getInt("isc");
                Integer tf = rs.getInt("tf");
                
                nuevo_producto prod = new nuevo_producto(id, codProd,cantidad, descripcion, marca, precio, p_cif, dai, isc, tf);
                
                listaProductos1.add(prod);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            if (base.getConn() != null) {
                base.desconectardb();
            }
        }
        return listaProductos1;
    }
    public ArrayList<producto> borrarProductosNuevo() {

        BaseDatosPG base = new BaseDatosPG();
        try {

            String sql = "DELETE FROM productos WHERE idproductos >= 0";
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
