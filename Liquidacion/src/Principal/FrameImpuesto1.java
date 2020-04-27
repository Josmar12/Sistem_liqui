/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

//import todo.Producto;
import PROGRAMACION.calculos;
import Properties.PropiedadesSistema;
import datos.imp_calculadoDao;
import datos.imp_pagadosDao;
import datos.productoDao;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.imp_calculados;
import modelos.imp_pagados;
import modelos.nuevo_producto;
import static variables.IClassModels.evento;

/**
 *
 * @author PC-SOPORTE
 */
public class FrameImpuesto1 extends javax.swing.JFrame {

    productoDao base;
    imp_calculadoDao base2;
    calculos liqui = new calculos();

    String informacion = "";
    imp_pagadosDao base1;

    DefaultTableModel ModeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    PropiedadesSistema sistema = new PropiedadesSistema();

    public FrameImpuesto1() {
        initComponents();
        base = new productoDao();
        base1 = new imp_pagadosDao();
        base2 = new imp_calculadoDao();
        cargarColumnasTabla1();
        cargarColumnasTabla3();
        cargarModeloTabla3();
        cargarModeloTabla1();
        ocultar_columnas1();
        ocultar_columnas3();
        cargarPcif();
        txt_codigo.setEditable(false);
        txt_descripcion.setEditable(false);
        txt_marca.setEditable(false);
        txt_pcif.setEditable(false);
        txt_cantidad.setEditable(false);
        txt_precio.setEditable(false);
        txt_pcif.setEditable(false);
        txtp_cif.setEnabled(false);
        txtflete.setEditable(false);
        txt_timbres.setEditable(false);
        txt_imp_selec.setEditable(false);
        txt_dere_aran.setEditable(false);
        txt_gto_agencia.setEditable(false);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setIconImage(new ImageIcon(getClass().getResource("/Principal/new.png")).getImage());
    }

    void ocultar_columnas3() {

        tabla_liqui.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_liqui.getColumnModel().getColumn(0).setMinWidth(0);
        tabla_liqui.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabla_liqui.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla_liqui.getColumnModel().getColumn(4).setMinWidth(0);
        tabla_liqui.getColumnModel().getColumn(4).setPreferredWidth(0);
        tabla_liqui.getColumnModel().getColumn(11).setMaxWidth(0);
        tabla_liqui.getColumnModel().getColumn(11).setMinWidth(0);
        tabla_liqui.getColumnModel().getColumn(11).setPreferredWidth(0);
        tabla_liqui.getColumnModel().getColumn(12).setMaxWidth(0);
        tabla_liqui.getColumnModel().getColumn(12).setMinWidth(0);
        tabla_liqui.getColumnModel().getColumn(12).setPreferredWidth(0);
        tabla_liqui.getColumnModel().getColumn(13).setMaxWidth(0);
        tabla_liqui.getColumnModel().getColumn(13).setMinWidth(0);
        tabla_liqui.getColumnModel().getColumn(13).setPreferredWidth(0);
        tabla_liqui.getColumnModel().getColumn(14).setMaxWidth(0);
        tabla_liqui.getColumnModel().getColumn(14).setMinWidth(0);
        tabla_liqui.getColumnModel().getColumn(14).setPreferredWidth(0);
        tabla_liqui.getColumnModel().getColumn(15).setMaxWidth(0);
        tabla_liqui.getColumnModel().getColumn(15).setMinWidth(0);
        tabla_liqui.getColumnModel().getColumn(15).setPreferredWidth(0);
        tabla_liqui.getColumnModel().getColumn(16).setMaxWidth(0);
        tabla_liqui.getColumnModel().getColumn(16).setMinWidth(0);
        tabla_liqui.getColumnModel().getColumn(16).setPreferredWidth(0);
        tabla_liqui.getColumnModel().getColumn(17).setMaxWidth(0);
        tabla_liqui.getColumnModel().getColumn(17).setMinWidth(0);
        tabla_liqui.getColumnModel().getColumn(17).setPreferredWidth(0);
        tabla_liqui.getColumnModel().getColumn(18).setMaxWidth(0);
        tabla_liqui.getColumnModel().getColumn(18).setMinWidth(0);
        tabla_liqui.getColumnModel().getColumn(18).setPreferredWidth(0);
        tabla_liqui.getColumnModel().getColumn(19).setMaxWidth(0);
        tabla_liqui.getColumnModel().getColumn(19).setMinWidth(0);
        tabla_liqui.getColumnModel().getColumn(19).setPreferredWidth(0);
        tabla_liqui.getColumnModel().getColumn(20).setMaxWidth(0);
        tabla_liqui.getColumnModel().getColumn(20).setMinWidth(0);
        tabla_liqui.getColumnModel().getColumn(20).setPreferredWidth(0);
    }

    void ocultar_columnas1() {

        tabla_imp.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_imp.getColumnModel().getColumn(0).setMinWidth(0);
        tabla_imp.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabla_imp.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla_imp.getColumnModel().getColumn(4).setMinWidth(0);
        tabla_imp.getColumnModel().getColumn(4).setPreferredWidth(0);
//        tabla_imp.getColumnModel().getColumn(7).setMaxWidth(0);
//        tabla_imp.getColumnModel().getColumn(7).setMinWidth(0);
//        tabla_imp.getColumnModel().getColumn(7).setPreferredWidth(0);
        tabla_imp.getColumnModel().getColumn(10).setMaxWidth(0);
        tabla_imp.getColumnModel().getColumn(10).setMinWidth(0);
        tabla_imp.getColumnModel().getColumn(10).setPreferredWidth(0);
    }

    private void cargarColumnasTabla3() {

        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("CÓDIGO");
        modeloTabla.addColumn("CANTIDAD");
        modeloTabla.addColumn("DESCRIPCIÓN");
        modeloTabla.addColumn("MARCA");
        modeloTabla.addColumn("PRECIOS FOB");
        modeloTabla.addColumn("P.CIF");
        modeloTabla.addColumn("DAI");
        modeloTabla.addColumn("ISC");
        modeloTabla.addColumn("TF");
        modeloTabla.addColumn("GASTO DE AGENCIA");
        modeloTabla.addColumn("COSTO TOTAL");
        modeloTabla.addColumn("COSTO UNITARIO");
        modeloTabla.addColumn("8%");
        modeloTabla.addColumn("10%");
        modeloTabla.addColumn("12%");
        modeloTabla.addColumn("15%");
        modeloTabla.addColumn("17%");
        modeloTabla.addColumn("20%");
        modeloTabla.addColumn("25%");
        modeloTabla.addColumn("Prueba");
    }

    private void cargarColumnasTabla1() {

        ModeloTabla.addColumn("Cod");
        ModeloTabla.addColumn("Codigo");
        ModeloTabla.addColumn("Cantidad");
        ModeloTabla.addColumn("Descripcion");
        ModeloTabla.addColumn("Marca");
        ModeloTabla.addColumn("Precio");
        ModeloTabla.addColumn("P CIF");
        ModeloTabla.addColumn("DAI");
        ModeloTabla.addColumn("ISC");
        ModeloTabla.addColumn("TF");

        ModeloTabla.addColumn("Prueba");

    }

    private void limpiarTabla1() {
        int numFilas = ModeloTabla.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                ModeloTabla.removeRow(i);
            }
        }
    }

    private void limpiarTabla3() {
        int numFilas = ModeloTabla.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                ModeloTabla.removeRow(i);
            }
        }
    }

    private void txtvalidar(KeyEvent evt) {
        //Declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        //Condición que nos permite ingresar datos de tipo texto
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car < '0' || car > '9') && (car != 'ñ' || car != 'ñ') && (car != 'Ñ' || car != 'Ñ')
                && (car != (char) KeyEvent.VK_BACK_SPACE) && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }

    }

    private void cargarModeloTabla1() {

        limpiarTabla1();
        ArrayList<nuevo_producto> listaProductos = base.obtenerProductosNuevo();
        int numeroProductos = listaProductos.size();
        ModeloTabla.setNumRows(numeroProductos);
        int totalregistros = 0;
        for (int i = 0; i < numeroProductos; i++) {

            nuevo_producto producto = listaProductos.get(i);

            Integer cod = producto.getCodigo();
            String codProd = producto.getCodigo_prod();
            String descripcion = producto.getDescripcion();
            Integer cant = producto.getCantidad();
            String marca = producto.getMarca();
            double precio = producto.getPrecio();
            double p_cif = producto.getP_cif();
            Integer dai = producto.getDai();
            Integer isc = producto.getIsc();
            Integer tf = producto.getTf();

            ModeloTabla.setValueAt(cod, i, 0);
            ModeloTabla.setValueAt(codProd, i, 1);
            ModeloTabla.setValueAt(cant, i, 2);
            ModeloTabla.setValueAt(descripcion, i, 3);
            ModeloTabla.setValueAt(marca, i, 4);
            ModeloTabla.setValueAt(df.format(precio), i, 5);
            ModeloTabla.setValueAt(df.format(p_cif), i, 6);
            ModeloTabla.setValueAt(dai, i, 7);
            ModeloTabla.setValueAt(isc, i, 8);
            ModeloTabla.setValueAt(tf, i, 9);
            ModeloTabla.setValueAt(producto, i, 10);
            totalregistros = i + 1;
        }
        CompoTotalRegistrosProductosRegistrados.setText(String.valueOf(totalregistros));
    }

    DecimalFormat df = new DecimalFormat("#0.00");

    private void cargarModeloTabla3() {

        limpiarTabla3();
        ArrayList<imp_calculados> listaImpuestoC = base2.obtenerImpuestoC();
        int numeroProductos = listaImpuestoC.size();
        modeloTabla.setNumRows(numeroProductos);
        for (int i = 0; i < numeroProductos; i++) {

            imp_calculados calculado = listaImpuestoC.get(i);

            int cod = calculado.getId_imp_cal();
            //TABLA PRODUCTO
            String codProd = calculado.getCodigo();
            String descripcion = calculado.getDescripcion();
            String marca = calculado.getMarca();
            int existencias = calculado.getCantidad();
            Double precio = calculado.getPrecio();

            //TABLA IMPUESTO A CALCULAR
            double p_cif = calculado.getP_cif();
            double dai = calculado.getDai();
            double isc = calculado.getIsc();
            double tf = calculado.getTf();
            double gto_agencia = calculado.getGto_agencia();
            double costo_total = calculado.getCosto_total();
            double costo_unitario = calculado.getCosto_unitario();
            double minorista = calculado.getMinorista();
            double licitacion = calculado.getLicitacion();
            double mayorista = calculado.getMayorista();
            double mpyme = calculado.getMpyme();
            double publico = calculado.getPublico();
            double enemigo = calculado.getEnemigo();
            double malo = calculado.getMalo();

            modeloTabla.setValueAt(cod, i, 0);
            modeloTabla.setValueAt(codProd, i, 1);
            modeloTabla.setValueAt(existencias, i, 2);
            modeloTabla.setValueAt(descripcion, i, 3);
            modeloTabla.setValueAt(marca, i, 4);
            modeloTabla.setValueAt(precio, i, 5);
            modeloTabla.setValueAt(df.format(p_cif), i, 6);
            modeloTabla.setValueAt(df.format(dai), i, 7);
            modeloTabla.setValueAt(df.format(isc), i, 8);
            modeloTabla.setValueAt(df.format(tf), i, 9);
            modeloTabla.setValueAt(df.format(gto_agencia), i, 10);
            modeloTabla.setValueAt(df.format(costo_total), i, 11);
            modeloTabla.setValueAt(df.format(costo_unitario), i, 12);
            modeloTabla.setValueAt(df.format(minorista), i, 13);
            modeloTabla.setValueAt(df.format(licitacion), i, 14);
            modeloTabla.setValueAt(df.format(mayorista), i, 15);
            modeloTabla.setValueAt(df.format(mpyme), i, 16);
            modeloTabla.setValueAt(df.format(publico), i, 17);
            modeloTabla.setValueAt(df.format(enemigo), i, 18);
            modeloTabla.setValueAt(df.format(malo), i, 19);
            modeloTabla.setValueAt(calculado, i, 20);
        }

    }

    private void cargarPcif() {

        String pcif;
        double p_cif3 = 0, p_cif4 = 0;

        for (int i = 0; i < ModeloTabla.getRowCount(); i++) {
            pcif = ModeloTabla.getValueAt(i, 6).toString();

            p_cif3 = Double.parseDouble(pcif);
            p_cif4 += p_cif3;
        }
        txtp_cif.setText("" + df.format(p_cif4));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        label_codigo = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        label_descripcion = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        label_cantidad = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        label_marca = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        label_precio = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_pcif = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        CompoTotalRegistrosProductosRegistrados = new javax.swing.JLabel();
        campoBuscar = new app.bolivia.swing.JCTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_imp = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        label_tf = new javax.swing.JLabel();
        txtTF = new javax.swing.JTextField();
        label_isc = new javax.swing.JLabel();
        txtisc = new javax.swing.JTextField();
        label_dai = new javax.swing.JLabel();
        txtdai = new javax.swing.JTextField();
        dai_flete = new javax.swing.JLabel();
        txtflete = new javax.swing.JTextField();
        dai_pcif = new javax.swing.JLabel();
        txtp_cif = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtflete_usa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtagencia = new javax.swing.JTextField();
        btncal_razon = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_timbres = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_imp_selec = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_dere_aran = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_gto_agencia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_liqui = new javax.swing.JTable();
        txtisc2 = new javax.swing.JTextField();
        txtdai2 = new javax.swing.JTextField();
        txttf2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        label_codigo.setText("Codigo:");
        label_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                label_codigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                label_codigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                label_codigoKeyTyped(evt);
            }
        });

        label_descripcion.setText("Descripción:");
        label_descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                label_descripcionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                label_descripcionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                label_descripcionKeyTyped(evt);
            }
        });

        txt_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descripcionActionPerformed(evt);
            }
        });

        label_cantidad.setText("Cantidad:");
        label_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                label_cantidadKeyTyped(evt);
            }
        });

        txt_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidadActionPerformed(evt);
            }
        });
        txt_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyTyped(evt);
            }
        });

        label_marca.setText("Marca:");
        label_marca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                label_marcaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                label_marcaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                label_marcaKeyTyped(evt);
            }
        });

        label_precio.setText("Precio de compra FOB:");
        label_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                label_precioKeyPressed(evt);
            }
        });

        txt_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precioActionPerformed(evt);
            }
        });
        txt_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_precioKeyTyped(evt);
            }
        });

        jLabel1.setText("P CIF");

        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(label_marca)
                            .addGap(97, 97, 97)
                            .addComponent(txt_marca))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_descripcion)
                                .addComponent(label_cantidad)
                                .addComponent(label_codigo))
                            .addGap(9, 9, 9)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_codigo)
                                .addComponent(txt_descripcion)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(62, 62, 62)
                                    .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_precio)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_precio, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(txt_pcif))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_codigo)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_descripcion)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_cantidad)
                    .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_marca)
                    .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_precio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_pcif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnguardar)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("TOTAL:");

        CompoTotalRegistrosProductosRegistrados.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        CompoTotalRegistrosProductosRegistrados.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CompoTotalRegistrosProductosRegistrados, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addComponent(CompoTotalRegistrosProductosRegistrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setCornerSize(4);
        dropShadowBorder1.setShadowColor(new java.awt.Color(109, 109, 109));
        dropShadowBorder1.setShadowSize(3);
        dropShadowBorder1.setShowRightShadow(false);
        campoBuscar.setBorder(dropShadowBorder1);
        campoBuscar.setForeground(new java.awt.Color(109, 109, 109));
        campoBuscar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        campoBuscar.setPlaceholder("Buscar por Codigo");
        campoBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                campoBuscarMousePressed(evt);
            }
        });
        campoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscarActionPerformed(evt);
            }
        });
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBuscarKeyTyped(evt);
            }
        });

        tabla_imp.setModel(ModeloTabla);
        tabla_imp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_impMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_imp);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("IMPUESTOS");

        label_tf.setText("TF:");

        txtTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTFKeyTyped(evt);
            }
        });

        label_isc.setText("ISC:");

        txtisc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtiscKeyTyped(evt);
            }
        });

        label_dai.setText("DAI:");

        txtdai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdaiKeyTyped(evt);
            }
        });

        dai_flete.setText("FLETE:");

        dai_pcif.setText("P.CIF:");

        txtp_cif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtp_cifKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("FLETE Y AGENCIA");

        jLabel11.setText("FLETE/USA:");

        txtflete_usa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtflete_usaActionPerformed(evt);
            }
        });
        txtflete_usa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtflete_usaKeyTyped(evt);
            }
        });

        jLabel12.setText("AGENCIA:");

        txtagencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtagenciaKeyTyped(evt);
            }
        });

        btncal_razon.setText("Calcular");
        btncal_razon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncal_razonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_tf)
                            .addComponent(label_isc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTF)
                            .addComponent(txtisc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(label_dai))
                    .addComponent(dai_pcif))
                .addGap(123, 123, 123)
                .addComponent(jLabel10)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdai, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtp_cif, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btncal_razon)
                        .addGap(93, 93, 93)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtflete_usa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(23, 23, 23))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(dai_flete)
                                .addGap(13, 13, 13)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtflete)
                            .addComponent(txtagencia, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtflete_usa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label_dai)
                        .addComponent(txtdai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_tf)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txtagencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtp_cif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dai_pcif))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label_isc)
                        .addComponent(txtisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dai_flete)
                            .addComponent(txtflete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addComponent(btncal_razon))))
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("RAZONES");

        jLabel15.setText("Timbres fiscales:");

        jLabel16.setText("Impuesto selectivo:");

        txt_imp_selec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_imp_selecActionPerformed(evt);
            }
        });

        jLabel17.setText("Derecho arancelario:");

        jLabel18.setText("Gasto de agencia:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_timbres, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(txt_imp_selec))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_dere_aran)
                            .addComponent(txt_gto_agencia, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel14))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txt_timbres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txt_imp_selec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txt_dere_aran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txt_gto_agencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tabla_liqui.setModel(modeloTabla);
        jScrollPane1.setViewportView(tabla_liqui);

        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(37, 37, 37)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 529, Short.MAX_VALUE)
                    .addComponent(txtisc2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 529, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 529, Short.MAX_VALUE)
                    .addComponent(txtdai2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 529, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 529, Short.MAX_VALUE)
                    .addComponent(txttf2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 529, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txtisc2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txtdai2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txttf2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_label_codigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_codigo.requestFocus();
        }
    }//GEN-LAST:event_label_codigoKeyPressed

    private void label_codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_label_codigoKeyReleased
        if (txt_codigo.getText().equals("")) {
            label_codigo.setForeground(new Color(0, 0, 0));
        } else {
            label_codigo.setText("Código");
            label_codigo.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_label_codigoKeyReleased

    private void label_codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_label_codigoKeyTyped
        String Caracteres = txt_codigo.getText();
        if (Caracteres.length() > 0) {
            evt.consume();
        }
    }//GEN-LAST:event_label_codigoKeyTyped

    private void label_descripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_label_descripcionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_descripcion.requestFocus();
        }
    }//GEN-LAST:event_label_descripcionKeyPressed

    private void label_descripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_label_descripcionKeyReleased
        if (txt_descripcion.getText().equals("")) {
            label_descripcion.setForeground(new Color(0, 0, 0));
        } else {
            label_descripcion.setText("Descripción");
            label_descripcion.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_label_descripcionKeyReleased

    private void label_descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_label_descripcionKeyTyped
        String Caracteres = txt_descripcion.getText();
        if (Caracteres.length() >= 0) {
            evt.consume();
        }
    }//GEN-LAST:event_label_descripcionKeyTyped

    private void txt_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripcionActionPerformed

    private void label_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_label_cantidadKeyTyped

    }//GEN-LAST:event_label_cantidadKeyTyped

    private void txt_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidadActionPerformed

    }//GEN-LAST:event_txt_cantidadActionPerformed

    private void txt_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyTyped
        evento.numberKeyPres(evt);
    }//GEN-LAST:event_txt_cantidadKeyTyped

    private void label_marcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_label_marcaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_marca.requestFocus();
        }
    }//GEN-LAST:event_label_marcaKeyPressed

    private void label_marcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_label_marcaKeyReleased
        if (txt_marca.getText().equals("")) {
            label_marca.setForeground(new Color(0, 0, 0));
        } else {
            label_marca.setText("Descripción");
            label_marca.setForeground(new Color(0, 0, 0));

        }
    }//GEN-LAST:event_label_marcaKeyReleased

    private void label_marcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_label_marcaKeyTyped
        String Caracteres = txt_marca.getText();
        if (Caracteres.length() >= 0) {
            evt.consume();
        }
    }//GEN-LAST:event_label_marcaKeyTyped

    private void label_precioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_label_precioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_precio.requestFocus();
        }
    }//GEN-LAST:event_label_precioKeyPressed

    private void txt_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precioActionPerformed

    private void txt_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precioKeyTyped
        String Caracteres = txt_precio.getText();
        if (Caracteres.length() >= 15) {
            evt.consume();
        }
        evento.numberDecimalKeyPress(evt, txt_precio);
    }//GEN-LAST:event_txt_precioKeyTyped

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        //        tabla_imp.clearSelection();
        imp_calculados calculo;

        DecimalFormat df = new DecimalFormat("#0.00");

        String tf1 = txtTF.getText();
        String isc1 = txtisc.getText();
        String dai1 = txtdai.getText();
        String p_cif1 = txtp_cif.getText();
        String flete_f1 = txtflete.getText();
        String flete_usa1 = txtflete_usa.getText();
        String agencia1 = txtagencia.getText();
        String timbres1 = txt_timbres.getText();
        String imp_sele = txt_imp_selec.getText();
        String derecho = txt_dere_aran.getText();
        String gto = txt_gto_agencia.getText();
        int dai3 = Integer.parseInt(txtdai2.getText());
        int isc3 = Integer.parseInt(txtisc2.getText());
        int tf3 = Integer.parseInt(txttf2.getText());

        if ((tf1.equals("")) || (tf1.equals("0"))) {
            JOptionPane.showMessageDialog(null, "Ingrese un número mayor que cero");
        } else {
            if ((isc1.equals("")) || (isc1.equals("0"))) {
                JOptionPane.showMessageDialog(null, "Ingrese un número mayor que cero");
            } else {
                if ((dai1.equals("")) || (dai1.equals("0"))) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número mayor que cero");
                } else {
                    if ((p_cif1.equals("")) || (p_cif1.equals("0"))) {
                        JOptionPane.showMessageDialog(null, "Ingrese un número mayor que cero");
                    } else {
                        if ((flete_f1.equals("")) || (flete_f1.equals("0"))) {
                            JOptionPane.showMessageDialog(null, "Ingrese un número mayor que cero");
                        } else {
                            if ((flete_usa1.equals("")) || (flete_usa1.equals("0"))) {
                                JOptionPane.showMessageDialog(null, "Ingrese un número mayor que cero");
                            } else {
                                if ((agencia1.equals("")) || (agencia1.equals("0"))) {
                                    JOptionPane.showMessageDialog(null, "Ingrese un número mayor que cero");
                                } else {
                                    if ((timbres1.equals("")) || (timbres1.equals("0"))) {
                                        JOptionPane.showMessageDialog(null, "Ingrese un número mayor que cero");
                                    } else {
                                        if ((imp_sele.equals("")) || (imp_sele.equals("0"))) {
                                            JOptionPane.showMessageDialog(null, "Ingrese un número mayor que cero");
                                        } else {
                                            if ((derecho.equals("")) || (derecho.equals("0"))) {
                                                JOptionPane.showMessageDialog(null, "Ingrese un número mayor que cero");
                                            } else {
                                                if ((gto.equals("")) || (gto.equals("0"))) {
                                                    JOptionPane.showMessageDialog(null, "Ingrese un número mayor que cero");
                                                } else {
                                                    if (txt_codigo.getText().equals("")) {
                                                        label_codigo.setText("Ingrése código ");
                                                        label_codigo.setForeground(new Color(204, 0, 0));
                                                        txt_codigo.requestFocus();
                                                    } else {
                                                        if (txt_codigo.getText().trim().length() < 0) {
                                                            label_codigo.setText("Ingrése código ");
                                                            label_codigo.setForeground(new Color(204, 0, 0));
                                                            txt_codigo.requestFocus();
                                                        } else {
                                                            if (txt_descripcion.getText().equals("")) {
                                                                label_descripcion.setText("Ingrése descripción ");
                                                                label_descripcion.setForeground(new Color(204, 0, 0));
                                                                txt_descripcion.requestFocus();
                                                            } else {
                                                                if (txt_descripcion.getText().trim().length() < 1) {
                                                                    label_descripcion.setText("Ingrése descripción ");
                                                                    label_descripcion.setForeground(new Color(204, 0, 0));
                                                                    txt_descripcion.requestFocus();
                                                                } else {
                                                                    String cant = txt_cantidad.getText();
                                                                    if ((cant.equals("")) || (cant.equals("0"))) {
                                                                        JOptionPane.showMessageDialog(null, "Ingrese un número mayor que cero");
                                                                    } else {
                                                                        if (txt_marca.getText().equals("")) {
                                                                            label_marca.setText("Ingrése marca ");
                                                                            label_marca.setForeground(new Color(204, 0, 0));
                                                                            txt_marca.requestFocus();
                                                                        } else {
                                                                            if (txt_marca.getText().trim().length() < 1) {
                                                                                label_marca.setText("Ingrése descripción ");
                                                                                label_marca.setForeground(new Color(204, 0, 0));
                                                                                txt_marca.requestFocus();
                                                                            } else {
                                                                                String canti = txt_precio.getText();
                                                                                if ((canti.equals("")) || (canti.equals("0"))) {
                                                                                    JOptionPane.showMessageDialog(null, "Ingrese un número mayor que cero");
                                                                                } else {

                                                                                    String codigo = txt_codigo.getText();
                                                                                    String nom_pro = txt_descripcion.getText();

                                                                                    String marca = txt_marca.getText();
                                                                                    double precio = Double.parseDouble(txt_precio.getText());
                                                                                    double tf = Double.parseDouble(txtTF.getText());
                                                                                    double isc = Double.parseDouble(txtisc.getText());
                                                                                    double dai = Double.parseDouble(txtdai.getText());
                                                                                    double p_cif = Double.parseDouble(txtp_cif.getText());
                                                                                    double flete_final = Double.parseDouble(txtflete.getText());
                                                                                    double flete_usa = Double.parseDouble(txtflete_usa.getText());
                                                                                    double agencia = Double.parseDouble(txtagencia.getText());
                                                                                    double timbres = Double.parseDouble(txt_timbres.getText());
                                                                                    double impuesto_selec = Double.parseDouble(txt_imp_selec.getText());
                                                                                    double derecho_arance = Double.parseDouble(txt_dere_aran.getText());
                                                                                    double gto_agencia = Double.parseDouble(txt_gto_agencia.getText());

                                                                                    Calendar calendarioLocal = Calendar.getInstance();
                                                                                    java.util.Date fechaActual = calendarioLocal.getTime();
                                                                                    long fechaMilisegundos = fechaActual.getTime();
                                                                                    java.sql.Date fechaingreso = new Date(fechaMilisegundos);

                                                                                    imp_pagados pagados = new imp_pagados(tf, isc, dai, p_cif, flete_final, flete_usa, agencia, timbres,
                                                                                        impuesto_selec, derecho_arance, gto_agencia, fechaingreso);

                                                                                    int cantidad = Integer.parseInt(cant);
                                                                                    double p_cif2 = 0;
                                                                                    double dere_aran = Double.parseDouble(txt_dere_aran.getText());
                                                                                    double dai2 = 0;
                                                                                    double imp_selec = Double.parseDouble(txt_imp_selec.getText());
                                                                                    double isc2 = 0;
                                                                                    double tf2 = 0;
                                                                                    double gto_agen = Double.parseDouble(txt_gto_agencia.getText());
                                                                                    double gastos = 0;
                                                                                    double costo_total = 0;
                                                                                    double costo_unitario = 0;

                                                                                    if (dai3 == 1 && isc3 == 1 && tf3 == 1) {
                                                                                        //Guardado en tabla final
                                                                                        ////                                                                                          double canti = Double.parseDouble(can);
                                                                                        p_cif2 = liqui.p_cif(precio, cantidad, p_cif2);
                                                                                        dai2 = liqui.dai(p_cif2, dere_aran, dai2);
                                                                                        isc2 = liqui.isc(p_cif2, imp_selec, isc2);
                                                                                        tf2 = liqui.tf(p_cif2, timbres, tf2);
                                                                                        gastos = liqui.gto_agen(p_cif2, gto_agen, gastos);
                                                                                        costo_total = liqui.costo_total(p_cif2, dai2, isc2, tf2, gastos, costo_total);
                                                                                        costo_unitario = liqui.costo_unitario(costo_total, cantidad, costo_unitario);

                                                                                        double nose = 0, licitacion = 0, mayorista = 0, pyme = 0, publico = 0, enemigo = 0, malo = 0;

                                                                                        nose = liqui.nose1(costo_unitario, nose);
                                                                                        licitacion = liqui.lici(costo_unitario, licitacion);
                                                                                        mayorista = liqui.mayo(costo_unitario, mayorista);
                                                                                        pyme = liqui.pyme(costo_unitario, pyme);
                                                                                        publico = liqui.publico(costo_unitario, publico);
                                                                                        enemigo = liqui.enemigo(costo_unitario, enemigo);
                                                                                        malo = liqui.malo(costo_unitario, malo);

                                                                                        //                                                                                        String fact_liqui = Label_NumeroProducto.getText();
                                                                                        calculo = new imp_calculados(codigo, cantidad, nom_pro, marca, precio,
                                                                                            p_cif2, dai2, isc2, tf2, gastos, costo_total, costo_unitario, nose, licitacion, mayorista, pyme,
                                                                                            publico, enemigo, malo);

                                                                                        try {
                                                                                            base1.insertarImpPaga(pagados);
                                                                                            base2.crearCompra(calculo);

                                                                                        } catch (FileNotFoundException ex) {
                                                                                            Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                                                        }
                                                                                        //                                                                                                cargarModeloTabla();
                                                                                        txt_codigo.setText("");
                                                                                        txt_descripcion.setText("");
                                                                                        txt_marca.setText("");
                                                                                        txt_pcif.setText("");
                                                                                        txt_precio.setText("");
                                                                                        txt_cantidad.setText("");

                                                                                    } else {
                                                                                        if (dai3 == 1 && isc3 == 1 && tf3 == 0) {

                                                                                            p_cif2 = liqui.p_cif(precio, cantidad, p_cif2);
                                                                                            dai2 = 0;
                                                                                            isc2 = liqui.isc(p_cif2, imp_selec, isc2);
                                                                                            tf2 = liqui.tf(p_cif2, timbres, tf2);
                                                                                            gastos = liqui.gto_agen(p_cif2, gto_agen, gastos);
                                                                                            costo_total = liqui.costo_total(p_cif2, dai2, isc2, tf2, gastos, costo_total);
                                                                                            costo_unitario = liqui.costo_unitario(costo_total, cantidad, costo_unitario);

                                                                                            double nose = 0, licitacion = 0, mayorista = 0, pyme = 0, publico = 0, enemigo = 0, malo = 0;

                                                                                            nose = liqui.nose1(costo_unitario, nose);
                                                                                            licitacion = liqui.lici(costo_unitario, licitacion);
                                                                                            mayorista = liqui.mayo(costo_unitario, mayorista);
                                                                                            pyme = liqui.pyme(costo_unitario, pyme);
                                                                                            publico = liqui.publico(costo_unitario, publico);
                                                                                            enemigo = liqui.enemigo(costo_unitario, enemigo);
                                                                                            malo = liqui.malo(costo_unitario, malo);

                                                                                            //                                                                                        String fact_liqui = Label_NumeroProducto.getText();
                                                                                            calculo = new imp_calculados(codigo, cantidad, nom_pro, marca, precio,
                                                                                                p_cif2, dai2, isc2, tf2, gastos, costo_total, costo_unitario, nose, licitacion, mayorista, pyme,
                                                                                                publico, enemigo, malo);

                                                                                            try {
                                                                                                base1.insertarImpPaga(pagados);
                                                                                                base2.crearCompra(calculo);

                                                                                            } catch (FileNotFoundException ex) {
                                                                                                Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                                                            }
                                                                                            //                                                                                                    txt_codigo.setText("");
                                                                                            txt_descripcion.setText("");
                                                                                            txt_marca.setText("");
                                                                                            txt_pcif.setText("");
                                                                                            txt_precio.setText("");
                                                                                            txt_cantidad.setText("");
                                                                                        } else {
                                                                                            if (tf3 == 0 && isc3 == 1 && dai3 == 1) {

                                                                                                p_cif2 = liqui.p_cif(precio, cantidad, p_cif2);
                                                                                                dai2 = liqui.dai(p_cif2, dere_aran, dai2);
                                                                                                isc2 = liqui.isc(p_cif2, imp_selec, isc2);
                                                                                                tf2 = 0;
                                                                                                gastos = liqui.gto_agen(p_cif2, gto_agen, gastos);
                                                                                                costo_total = liqui.costo_total(p_cif2, dai2, isc2, tf2, gastos, costo_total);
                                                                                                costo_unitario = liqui.costo_unitario(costo_total, cantidad, costo_unitario);

                                                                                                double nose = 0, licitacion = 0, mayorista = 0, pyme = 0, publico = 0, enemigo = 0, malo = 0;

                                                                                                nose = liqui.nose1(costo_unitario, nose);
                                                                                                licitacion = liqui.lici(costo_unitario, licitacion);
                                                                                                mayorista = liqui.mayo(costo_unitario, mayorista);
                                                                                                pyme = liqui.pyme(costo_unitario, pyme);
                                                                                                publico = liqui.publico(costo_unitario, publico);
                                                                                                enemigo = liqui.enemigo(costo_unitario, enemigo);
                                                                                                malo = liqui.malo(costo_unitario, malo);

                                                                                                //                                                                                        String fact_liqui = Label_NumeroProducto.getText();
                                                                                                calculo = new imp_calculados(codigo, cantidad, nom_pro, marca, precio,
                                                                                                    p_cif2, dai2, isc2, tf2, gastos, costo_total, costo_unitario, nose, licitacion, mayorista, pyme,
                                                                                                    publico, enemigo, malo);

                                                                                                try {
                                                                                                    base1.insertarImpPaga(pagados);
                                                                                                    base2.crearCompra(calculo);

                                                                                                } catch (FileNotFoundException ex) {
                                                                                                    Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                                                                }
                                                                                                //                                                                                                        cargarModeloTabla();
                                                                                                txt_codigo.setText("");
                                                                                                txt_descripcion.setText("");
                                                                                                txt_marca.setText("");
                                                                                                txt_pcif.setText("");
                                                                                                txt_precio.setText("");
                                                                                                txt_cantidad.setText("");
                                                                                            } else {
                                                                                                if (dai3 == 1 && isc3 == 0 && tf3 == 1) {

                                                                                                    p_cif2 = liqui.p_cif(precio, cantidad, p_cif2);
                                                                                                    dai2 = liqui.dai(p_cif2, dere_aran, dai2);
                                                                                                    isc2 = 0;
                                                                                                    tf2 = liqui.tf(p_cif2, timbres, tf2);
                                                                                                    gastos = liqui.gto_agen(p_cif2, gto_agen, gastos);
                                                                                                    costo_total = liqui.costo_total(p_cif2, dai2, isc2, tf2, gastos, costo_total);
                                                                                                    costo_unitario = liqui.costo_unitario(costo_total, cantidad, costo_unitario);

                                                                                                    double nose = 0, licitacion = 0, mayorista = 0, pyme = 0, publico = 0, enemigo = 0, malo = 0;

                                                                                                    nose = liqui.nose1(costo_unitario, nose);
                                                                                                    licitacion = liqui.lici(costo_unitario, licitacion);
                                                                                                    mayorista = liqui.mayo(costo_unitario, mayorista);
                                                                                                    pyme = liqui.pyme(costo_unitario, pyme);
                                                                                                    publico = liqui.publico(costo_unitario, publico);
                                                                                                    enemigo = liqui.enemigo(costo_unitario, enemigo);
                                                                                                    malo = liqui.malo(costo_unitario, malo);

                                                                                                    //                                                                                        String fact_liqui = Label_NumeroProducto.getText();
                                                                                                    calculo = new imp_calculados(codigo, cantidad, nom_pro, marca, precio,
                                                                                                        p_cif2, dai2, isc2, tf2, gastos, costo_total, costo_unitario, nose, licitacion, mayorista, pyme,
                                                                                                        publico, enemigo, malo);

                                                                                                    try {
                                                                                                        base1.insertarImpPaga(pagados);
                                                                                                        base2.crearCompra(calculo);

                                                                                                    } catch (FileNotFoundException ex) {
                                                                                                        Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                                                                    }
                                                                                                    //                                                                                                            cargarModeloTabla();
                                                                                                    txt_codigo.setText("");
                                                                                                    txt_descripcion.setText("");
                                                                                                    txt_marca.setText("");
                                                                                                    txt_pcif.setText("");
                                                                                                    txt_precio.setText("");
                                                                                                    txt_cantidad.setText("");
                                                                                                }else {
                                                                                                    if (dai3 == 1 && isc3 == 0 && tf3 == 0) {

                                                                                                        p_cif2 = p_cif2 = liqui.p_cif(precio, cantidad, p_cif2);;
                                                                                                        dai2 = liqui.dai(p_cif2, dere_aran, dai2);
                                                                                                        isc2 = 0;
                                                                                                        tf2 = 0;
                                                                                                        gastos = liqui.gto_agen(p_cif2, gto_agen, gastos);
                                                                                                        costo_total = liqui.costo_total(p_cif2, dai2, isc2, tf2, gastos, costo_total);
                                                                                                        costo_unitario = liqui.costo_unitario(costo_total, cantidad, costo_unitario);

                                                                                                        double nose = 0, licitacion = 0, mayorista = 0, pyme = 0, publico = 0, enemigo = 0, malo = 0;

                                                                                                        nose = liqui.nose1(costo_unitario, nose);
                                                                                                        licitacion = liqui.lici(costo_unitario, licitacion);
                                                                                                        mayorista = liqui.mayo(costo_unitario, mayorista);
                                                                                                        pyme = liqui.pyme(costo_unitario, pyme);
                                                                                                        publico = liqui.publico(costo_unitario, publico);
                                                                                                        enemigo = liqui.enemigo(costo_unitario, enemigo);
                                                                                                        malo = liqui.malo(costo_unitario, malo);

                                                                                                        //                                                                                        String fact_liqui = Label_NumeroProducto.getText();
                                                                                                        calculo = new imp_calculados(codigo, cantidad, nom_pro, marca, precio,
                                                                                                            p_cif2, dai2, isc2, tf2, gastos, costo_total, costo_unitario, nose, licitacion, mayorista, pyme,
                                                                                                            publico, enemigo, malo);

                                                                                                        try {
                                                                                                            base1.insertarImpPaga(pagados);
                                                                                                            base2.crearCompra(calculo);

                                                                                                        } catch (FileNotFoundException ex) {
                                                                                                            Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                                                                        }
                                                                                                        //                                                                                                                cargarModeloTabla();
                                                                                                        txt_codigo.setText("");
                                                                                                        txt_descripcion.setText("");
                                                                                                        txt_marca.setText("");
                                                                                                        txt_pcif.setText("");
                                                                                                        txt_precio.setText("");
                                                                                                        txt_cantidad.setText("");
                                                                                                    } else {
                                                                                                        if (dai3 == 0 && tf3 == 1 && isc3 == 0) {

                                                                                                            p_cif2 = p_cif2 = liqui.p_cif(precio, cantidad, p_cif2);;
                                                                                                            dai2 = 0;
                                                                                                            isc2 = 0;
                                                                                                            tf2 = liqui.tf(p_cif2, timbres, tf2);
                                                                                                            gastos = liqui.gto_agen(p_cif2, gto_agen, gastos);
                                                                                                            costo_total = liqui.costo_total(p_cif2, dai2, isc2, tf2, gastos, costo_total);
                                                                                                            costo_unitario = liqui.costo_unitario(costo_total, cantidad, costo_unitario);

                                                                                                            double nose = 0, licitacion = 0, mayorista = 0, pyme = 0, publico = 0, enemigo = 0, malo = 0;

                                                                                                            nose = liqui.nose1(costo_unitario, nose);
                                                                                                            licitacion = liqui.lici(costo_unitario, licitacion);
                                                                                                            mayorista = liqui.mayo(costo_unitario, mayorista);
                                                                                                            pyme = liqui.pyme(costo_unitario, pyme);
                                                                                                            publico = liqui.publico(costo_unitario, publico);
                                                                                                            enemigo = liqui.enemigo(costo_unitario, enemigo);
                                                                                                            malo = liqui.malo(costo_unitario, malo);

                                                                                                            //                                                                                        String fact_liqui = Label_NumeroProducto.getText();
                                                                                                            calculo = new imp_calculados(codigo, cantidad, nom_pro, marca, precio,
                                                                                                                p_cif2, dai2, isc2, tf2, gastos, costo_total, costo_unitario, nose, licitacion, mayorista, pyme,
                                                                                                                publico, enemigo, malo);

                                                                                                            try {
                                                                                                                base1.insertarImpPaga(pagados);
                                                                                                                base2.crearCompra(calculo);

                                                                                                            } catch (FileNotFoundException ex) {
                                                                                                                Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                                                                            }
                                                                                                            //                                                                                                                    cargarModeloTabla();
                                                                                                            txt_codigo.setText("");
                                                                                                            txt_descripcion.setText("");
                                                                                                            txt_marca.setText("");
                                                                                                            txt_pcif.setText("");
                                                                                                            txt_precio.setText("");
                                                                                                            txt_cantidad.setText("");
                                                                                                        }
                                                                                                        if (tf3 == 0 && isc3 == 1 && dai3 == 0) {

                                                                                                            p_cif2 = p_cif2 = liqui.p_cif(precio, cantidad, p_cif2);;
                                                                                                            dai2 = 0;
                                                                                                            isc2 = liqui.isc(p_cif2, imp_selec, isc2);
                                                                                                            tf2 = 0;
                                                                                                            gastos = liqui.gto_agen(p_cif2, gto_agen, gastos);
                                                                                                            costo_total = liqui.costo_total(p_cif2, dai2, isc2, tf2, gastos, costo_total);
                                                                                                            costo_unitario = liqui.costo_unitario(costo_total, cantidad, costo_unitario);

                                                                                                            double nose = 0, licitacion = 0, mayorista = 0, pyme = 0, publico = 0, enemigo = 0, malo = 0;

                                                                                                            nose = liqui.nose1(costo_unitario, nose);
                                                                                                            licitacion = liqui.lici(costo_unitario, licitacion);
                                                                                                            mayorista = liqui.mayo(costo_unitario, mayorista);
                                                                                                            pyme = liqui.pyme(costo_unitario, pyme);
                                                                                                            publico = liqui.publico(costo_unitario, publico);
                                                                                                            enemigo = liqui.enemigo(costo_unitario, enemigo);
                                                                                                            malo = liqui.malo(costo_unitario, malo);

                                                                                                            //                                                                                        String fact_liqui = Label_NumeroProducto.getText();
                                                                                                            calculo = new imp_calculados(codigo, cantidad, nom_pro, marca, precio,
                                                                                                                p_cif2, dai2, isc2, tf2, gastos, costo_total, costo_unitario, nose, licitacion, mayorista, pyme,
                                                                                                                publico, enemigo, malo);

                                                                                                            try {
                                                                                                                base1.insertarImpPaga(pagados);
                                                                                                                base2.crearCompra(calculo);

                                                                                                            } catch (FileNotFoundException ex) {
                                                                                                                Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                                                                            }
                                                                                                            //                                                                                                                    cargarModeloTabla();
                                                                                                            txt_codigo.setText("");
                                                                                                            txt_descripcion.setText("");
                                                                                                            txt_marca.setText("");
                                                                                                            txt_pcif.setText("");
                                                                                                            txt_precio.setText("");
                                                                                                            txt_cantidad.setText("");

                                                                                                        } else {
                                                                                                            if (tf3 == 1 && isc3 ==0 && dai == 1) {

                                                                                                                p_cif2 = liqui.p_cif(precio, cantidad, p_cif2);
                                                                                                                dai2 = liqui.dai(p_cif2, dere_aran, dai2);
                                                                                                                isc2 = 0;
                                                                                                                tf2 = liqui.tf(p_cif2, timbres, tf2);
                                                                                                                gastos = liqui.gto_agen(p_cif2, gto_agen, gastos);
                                                                                                                costo_total = liqui.costo_total(p_cif2, dai2, isc2, tf2, gastos, costo_total);
                                                                                                                costo_unitario = liqui.costo_unitario(costo_total, cantidad, costo_unitario);

                                                                                                                double nose = 0, licitacion = 0, mayorista = 0, pyme = 0, publico = 0, enemigo = 0, malo = 0;

                                                                                                                nose = liqui.nose1(costo_unitario, nose);
                                                                                                                licitacion = liqui.lici(costo_unitario, licitacion);
                                                                                                                mayorista = liqui.mayo(costo_unitario, mayorista);
                                                                                                                pyme = liqui.pyme(costo_unitario, pyme);
                                                                                                                publico = liqui.publico(costo_unitario, publico);
                                                                                                                enemigo = liqui.enemigo(costo_unitario, enemigo);
                                                                                                                malo = liqui.malo(costo_unitario, malo);

                                                                                                                //                                                                                        String fact_liqui = Label_NumeroProducto.getText();
                                                                                                                calculo = new imp_calculados(codigo, cantidad, nom_pro, marca, precio,
                                                                                                                    p_cif2, dai2, isc2, tf2, gastos, costo_total, costo_unitario, nose, licitacion, mayorista, pyme,
                                                                                                                    publico, enemigo, malo);

                                                                                                                try {
                                                                                                                    base1.insertarImpPaga(pagados);
                                                                                                                    base2.crearCompra(calculo);

                                                                                                                } catch (FileNotFoundException ex) {
                                                                                                                    Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                                                                                }
                                                                                                                //                                                                                                                        cargarModeloTabla();
                                                                                                                txt_codigo.setText("");
                                                                                                                txt_descripcion.setText("");
                                                                                                                txt_marca.setText("");
                                                                                                                txt_pcif.setText("");
                                                                                                                txt_precio.setText("");
                                                                                                                txt_cantidad.setText("");
                                                                                                            } else {
                                                                                                                if (tf3 == 0 && isc3 == 1 && dai3 ==1) {
                                                                                                                    p_cif2 = liqui.p_cif(precio, cantidad, p_cif2);
                                                                                                                    dai2 = liqui.dai(p_cif2, dere_aran, dai2);
                                                                                                                    isc2 = liqui.isc(p_cif2, imp_selec, isc2);
                                                                                                                    tf2 = 0;
                                                                                                                    gastos = liqui.gto_agen(p_cif2, gto_agen, gastos);
                                                                                                                    costo_total = liqui.costo_total(p_cif2, dai2, isc2, tf2, gastos, costo_total);
                                                                                                                    costo_unitario = liqui.costo_unitario(costo_total, cantidad, costo_unitario);

                                                                                                                    double nose = 0, licitacion = 0, mayorista = 0, pyme = 0, publico = 0, enemigo = 0, malo = 0;

                                                                                                                    nose = liqui.nose1(costo_unitario, nose);
                                                                                                                    licitacion = liqui.lici(costo_unitario, licitacion);
                                                                                                                    mayorista = liqui.mayo(costo_unitario, mayorista);
                                                                                                                    pyme = liqui.pyme(costo_unitario, pyme);
                                                                                                                    publico = liqui.publico(costo_unitario, publico);
                                                                                                                    enemigo = liqui.enemigo(costo_unitario, enemigo);
                                                                                                                    malo = liqui.malo(costo_unitario, malo);

                                                                                                                    //                                                                                        String fact_liqui = Label_NumeroProducto.getText();
                                                                                                                    calculo = new imp_calculados(codigo, cantidad, nom_pro, marca, precio,
                                                                                                                        p_cif2, dai2, isc2, tf2, gastos, costo_total, costo_unitario, nose, licitacion, mayorista, pyme,
                                                                                                                        publico, enemigo, malo);

                                                                                                                    try {
                                                                                                                        base1.insertarImpPaga(pagados);
                                                                                                                        base2.crearCompra(calculo);

                                                                                                                    } catch (FileNotFoundException ex) {
                                                                                                                        Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                                                                                    }
                                                                                                                    //                                                                                                                            cargarModeloTabla();
                                                                                                                    txt_codigo.setText("");
                                                                                                                    txt_descripcion.setText("");
                                                                                                                    txt_marca.setText("");
                                                                                                                    txt_pcif.setText("");
                                                                                                                    txt_precio.setText("");
                                                                                                                    txt_cantidad.setText("");
                                                                                                                } else {
                                                                                                                    if (tf3 == 1 && isc3 == 1 && dai3 == 0) {
                                                                                                                        p_cif2 = liqui.p_cif(precio, cantidad, p_cif2);
                                                                                                                        dai2 = 0;
                                                                                                                        isc2 = liqui.isc(p_cif2, imp_selec, isc2);
                                                                                                                        tf2 = liqui.tf(p_cif2, timbres, tf2);
                                                                                                                        gastos = liqui.gto_agen(p_cif2, gto_agen, gastos);
                                                                                                                        costo_total = liqui.costo_total(p_cif2, dai2, isc2, tf2, gastos, costo_total);
                                                                                                                        costo_unitario = liqui.costo_unitario(costo_total, cantidad, costo_unitario);

                                                                                                                        double nose = 0, licitacion = 0, mayorista = 0, pyme = 0, publico = 0, enemigo = 0, malo = 0;

                                                                                                                        nose = liqui.nose1(costo_unitario, nose);
                                                                                                                        licitacion = liqui.lici(costo_unitario, licitacion);
                                                                                                                        mayorista = liqui.mayo(costo_unitario, mayorista);
                                                                                                                        pyme = liqui.pyme(costo_unitario, pyme);
                                                                                                                        publico = liqui.publico(costo_unitario, publico);
                                                                                                                        enemigo = liqui.enemigo(costo_unitario, enemigo);
                                                                                                                        malo = liqui.malo(costo_unitario, malo);

                                                                                                                        //                                                                                        String fact_liqui = Label_NumeroProducto.getText();
                                                                                                                        calculo = new imp_calculados(codigo, cantidad, nom_pro, marca, precio,
                                                                                                                            p_cif2, dai2, isc2, tf2, gastos, costo_total, costo_unitario, nose, licitacion, mayorista, pyme,
                                                                                                                            publico, enemigo, malo);

                                                                                                                        try {
                                                                                                                            base1.insertarImpPaga(pagados);
                                                                                                                            base2.crearCompra(calculo);

                                                                                                                        } catch (FileNotFoundException ex) {
                                                                                                                            Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                                                                                        }
                                                                                                                        //                                                                                                                                cargarModeloTabla();
                                                                                                                        txt_codigo.setText("");
                                                                                                                        txt_descripcion.setText("");
                                                                                                                        txt_marca.setText("");
                                                                                                                        txt_pcif.setText("");
                                                                                                                        txt_precio.setText("");
                                                                                                                        txt_cantidad.setText("");
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }

                                                                                                    }
                                                                                                }

                                                                                            }
                                                                                        }

                                                                                    }
                                                                                }
                                                                            }

                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }

                                            }

                                        }

                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void campoBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoBuscarMousePressed
        tabla_imp.clearSelection();
    }//GEN-LAST:event_campoBuscarMousePressed

    private void campoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscarActionPerformed

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased

        limpiarTabla1();
        String cadenaBusqueda = campoBuscar.getText();
        ArrayList<nuevo_producto> listaProductos = base.obtenerProductosNuevoPorCriterio(cadenaBusqueda);

        int numeroProductos = listaProductos.size();

        ModeloTabla.setNumRows(numeroProductos);
        int totalregistros = 0;
        for (int i = 0; i < numeroProductos; i++) {

            nuevo_producto producto = listaProductos.get(i);
            //

            int id = producto.getCodigo();
            String codProd = producto.getCodigo_prod();
            String descripcion = producto.getDescripcion();
            int cantidad = producto.getCantidad();
            String marca = producto.getMarca();
            double precio = producto.getPrecio();
            double p_cif = producto.getP_cif();

            ModeloTabla.setValueAt(id, i, 0);
            ModeloTabla.setValueAt(codProd, i, 1);
            ModeloTabla.setValueAt(cantidad, i, 2);
            ModeloTabla.setValueAt(descripcion, i, 3);
            ModeloTabla.setValueAt(marca, i, 4);
            ModeloTabla.setValueAt(precio, i, 5);
            ModeloTabla.setValueAt(p_cif, i, 6);
            ModeloTabla.setValueAt(producto, i, 7);
            totalregistros = i + 1;
        }
        CompoTotalRegistrosProductosRegistrados.setText(String.valueOf(totalregistros));
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void campoBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyTyped
        txtvalidar(evt);
    }//GEN-LAST:event_campoBuscarKeyTyped

    private void tabla_impMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_impMouseClicked
        // TODO add your handling code here:

        DefaultTableModel modelo_imp = (DefaultTableModel) tabla_imp.getModel();

        txt_codigo.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 1).toString());
        txt_cantidad.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 2).toString());
        txt_descripcion.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 3).toString());
        txt_marca.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 4).toString());
        txt_precio.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 5).toString());
        txt_pcif.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 6).toString());
        txtdai2.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 7).toString());
        txtisc2.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 8).toString());
        txttf2.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 9).toString());
    }//GEN-LAST:event_tabla_impMouseClicked

    private void txtTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTFKeyTyped
        String Caracteres = txtTF.getText();
        if (Caracteres.length() >= 15) {
            evt.consume();
        }
        evento.numberDecimalKeyPress(evt, txtTF);
    }//GEN-LAST:event_txtTFKeyTyped

    private void txtiscKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtiscKeyTyped
        String Caracteres = txtisc.getText();
        if (Caracteres.length() >= 15) {
            evt.consume();
        }
        evento.numberDecimalKeyPress(evt, txtisc);
    }//GEN-LAST:event_txtiscKeyTyped

    private void txtdaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdaiKeyTyped
        String Caracteres = txtdai.getText();
        if (Caracteres.length() >= 15) {
            evt.consume();
        }
        evento.numberDecimalKeyPress(evt, txtdai);
    }//GEN-LAST:event_txtdaiKeyTyped

    private void txtp_cifKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtp_cifKeyTyped
        String Caracteres = txtp_cif.getText();
        if (Caracteres.length() >= 15) {
            evt.consume();
        }
        evento.numberDecimalKeyPress(evt, txtp_cif);
    }//GEN-LAST:event_txtp_cifKeyTyped

    private void txtflete_usaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtflete_usaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtflete_usaActionPerformed

    private void txtflete_usaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtflete_usaKeyTyped
        String Caracteres = txtflete.getText();
        if (Caracteres.length() >= 15) {
            evt.consume();
        }
        evento.numberDecimalKeyPress(evt, txtflete);
    }//GEN-LAST:event_txtflete_usaKeyTyped

    private void txtagenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtagenciaKeyTyped
        String Caracteres = txtagencia.getText();
        if (Caracteres.length() >= 15) {
            evt.consume();
        }
        evento.numberDecimalKeyPress(evt, txtagencia);
    }//GEN-LAST:event_txtagenciaKeyTyped

    private void btncal_razonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncal_razonActionPerformed
        btnguardar.setEnabled(true);
        DecimalFormat df = new DecimalFormat("#.00");

        double tf = Double.parseDouble(txtTF.getText());
        double pcif = Double.parseDouble(txtp_cif.getText());
        double timbres = 0;
        double imp_selec = 0;
        double isc = Double.parseDouble(txtisc.getText());
        double dere_arance = 0;
        double dai = Double.parseDouble(txtdai.getText());
        double gto_agencia = 0;
        double flete = 0;
        double flete_usa = Double.parseDouble(txtflete_usa.getText());
        double agencia = Double.parseDouble(txtagencia.getText());

        timbres = calculos.razones_tim(tf, pcif, timbres);
        imp_selec = calculos.razon_imp_selec(isc, pcif, imp_selec);
        dere_arance = calculos.razon_dere_aran(dai, pcif, dere_arance);
        flete = flete_usa + agencia;
        gto_agencia = calculos.razon_dere_aran(flete, pcif, gto_agencia);

        txtflete.setText(String.valueOf(df.format(flete)));//Esto no tiene nada que ver con las razones pero si es un calculo a hacerS//

        txt_timbres.setText(String.valueOf(df.format(timbres)));
        txt_imp_selec.setText(String.valueOf(df.format(imp_selec)));
        txt_dere_aran.setText(String.valueOf(df.format(dere_arance)));
        txt_gto_agencia.setText(String.valueOf(df.format(gto_agencia)));
    }//GEN-LAST:event_btncal_razonActionPerformed

    private void txt_imp_selecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_imp_selecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_imp_selecActionPerformed
    
    Timer timer = null;
    TimerTask task;
    int i = 32;
    
    private void Cerrar() {
        this.dispose();
        timer = null;
        task = null;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        task = new TimerTask() {
            @Override
            public void run() {
                if (i == 0) {
                    Cerrar();
                } else {

                    i -= 32;

                }
            }
        };
        timer = new Timer();
        timer.schedule(task, 0, 2);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameImpuesto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameImpuesto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameImpuesto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameImpuesto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameImpuesto1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CompoTotalRegistrosProductosRegistrados;
    private javax.swing.JButton btncal_razon;
    private javax.swing.JButton btnguardar;
    private app.bolivia.swing.JCTextField campoBuscar;
    private javax.swing.JLabel dai_flete;
    private javax.swing.JLabel dai_pcif;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_cantidad;
    private javax.swing.JLabel label_codigo;
    private javax.swing.JLabel label_dai;
    private javax.swing.JLabel label_descripcion;
    private javax.swing.JLabel label_isc;
    private javax.swing.JLabel label_marca;
    private javax.swing.JLabel label_precio;
    private javax.swing.JLabel label_tf;
    private javax.swing.JTable tabla_imp;
    private javax.swing.JTable tabla_liqui;
    private javax.swing.JTextField txtTF;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_dere_aran;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_gto_agencia;
    private javax.swing.JTextField txt_imp_selec;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_pcif;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_timbres;
    private javax.swing.JTextField txtagencia;
    private javax.swing.JTextField txtdai;
    private javax.swing.JTextField txtdai2;
    private javax.swing.JTextField txtflete;
    private javax.swing.JTextField txtflete_usa;
    private javax.swing.JTextField txtisc;
    private javax.swing.JTextField txtisc2;
    private javax.swing.JTextField txtp_cif;
    private javax.swing.JTextField txttf2;
    // End of variables declaration//GEN-END:variables
}
