/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author PC-SOPORTE
 */
import PROGRAMACION.calculos;
import Properties.PropiedadesSistema;
import baseDatos.BaseDatosPG;
import datos.imp_calculadoDao;
import datos.imp_pagadosDao;
import datos.productoDao;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelos.imp_calculados;
import modelos.imp_pagados;
import modelos.nuevo_producto;
import modelos.producto;
import static variables.IClassModels.evento;
import variables.generarcodigoProducto;

public class Producto1 extends javax.swing.JFrame {

    productoDao base;
    imp_calculadoDao base2;
    DecimalFormat df = new DecimalFormat("#0.00");
    calculos liqui = new calculos();
    imp_pagadosDao base1;

    DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultTableModel ModeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    PropiedadesSistema sistema = new PropiedadesSistema();

    /**
     * Creates new form Producto
     */
    public Producto1() {
        initComponents();
        base = new productoDao();
        base1 = new imp_pagadosDao();
        base2 = new imp_calculadoDao();
        cargarColumnasTabla();
        cargarColumnasTabla1();
        cargarModeloTabla();
        cargarModeloTabla1();
//        tabla_imp.setVisible(false);
        txt_id.setVisible(false);
        txt_id.setEnabled(false);
        txt_codigo.setEditable(false);
        txt_descripcion.setEditable(false);
        txt_marca.setEditable(false);
        txt_pcif.setEditable(false);
//        columnas();
        ocultar_columnas();
        ocultar_columnas1();
        this.tabla_producto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setIconImage(new ImageIcon(getClass().getResource("/Principal/new.png")).getImage());

        campoBuscar.requestFocus();
    }

    private void limpiarTabla1() {
        int numFilas = ModeloTabla.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                ModeloTabla.removeRow(i);
            }
        }
    }

    private void limpiarTabla() {
        int numFilas = modeloTabla.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                modeloTabla.removeRow(i);
            }
        }
    }

//    public void columnas() {
//
//        //desde aqui  
//        TableColumnModel columnModel = tabla_producto.getColumnModel();
//        columnModel.getColumn(0).setPreferredWidth(30);
//        columnModel.getColumn(1).setPreferredWidth(120);
//        columnModel.getColumn(2).setPreferredWidth(360);
//        columnModel.getColumn(5).setPreferredWidth(40);
//        columnModel.getColumn(6).setPreferredWidth(50);
//
//    }
    void ocultar_columnas() {

        tabla_producto.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_producto.getColumnModel().getColumn(0).setMinWidth(0);
        tabla_producto.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabla_producto.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla_producto.getColumnModel().getColumn(4).setMinWidth(0);
        tabla_producto.getColumnModel().getColumn(4).setPreferredWidth(0);

    }

    void ocultar_columnas1() {

        tabla_imp.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_imp.getColumnModel().getColumn(0).setMinWidth(0);
        tabla_imp.getColumnModel().getColumn(0).setPreferredWidth(0);
//        tabla_imp.getColumnModel().getColumn(7).setMaxWidth(0);
//        tabla_imp.getColumnModel().getColumn(7).setMinWidth(0);
//        tabla_imp.getColumnModel().getColumn(7).setPreferredWidth(0);
        tabla_imp.getColumnModel().getColumn(10).setMaxWidth(0);
        tabla_imp.getColumnModel().getColumn(10).setMinWidth(0);
        tabla_imp.getColumnModel().getColumn(10).setPreferredWidth(0);
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

    private void cargarColumnasTabla() {

        modeloTabla.addColumn("Cod");
        modeloTabla.addColumn("Codigo");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Marca");

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

    private void cargarModeloTabla() {

        limpiarTabla();
        ArrayList<producto> listaProductos = base.obtenerProductos();
        int numeroProductos = listaProductos.size();
        modeloTabla.setNumRows(numeroProductos);
        int totalregistros = 0;
        for (int i = 0; i < numeroProductos; i++) {

            producto producto = listaProductos.get(i);

            Integer id = producto.getCodigo();
            String codProd = producto.getCodigo_pro();
            String descripcion = producto.getDescripcion();

            String marca = producto.getMarca();

            modeloTabla.setValueAt(id, i, 0);
            modeloTabla.setValueAt(codProd, i, 1);
            modeloTabla.setValueAt(descripcion, i, 2);
            modeloTabla.setValueAt(marca, i, 3);
            modeloTabla.setValueAt(producto, i, 4);
            totalregistros = i + 1;
        }
        CompoTotalRegistrosProductosRegistrados.setText(String.valueOf(totalregistros));
    }

    private void cargarModeloTabla1() {

        limpiarTabla1();
        ArrayList<nuevo_producto> listaProductos = base.obtenerProductosNuevo();
        int numeroProductos = listaProductos.size();
        ModeloTabla.setNumRows(numeroProductos);
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

        }
    }

//
//    private void cargarModeloTabla1() {
//
//        limpiarTabla1();
//        ArrayList<imp_pagados> listaImpuestoP = base1.obtenerImpuesto();
//        int numeroImpuesto = listaImpuestoP.size();
//        ModeloTabla.setNumRows(numeroImpuesto);
//        for (int i = 0; i < numeroImpuesto; i++) {
//
//            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//            imp_pagados impuesto = listaImpuestoP.get(i);
//
//            int idImpuesto = impuesto.getId_imp_pagados();
//            double dgi = impuesto.getDgi();
//            double tf = impuesto.getTf();
//            double isc = impuesto.getIsc();
//            double dai = impuesto.getDai();
//            double p_cif = impuesto.getP_cif_ingre();
//            double flete_final = impuesto.getFlete_final();
//            double flete_usa = impuesto.getFlete_usa();
//            double agencia = impuesto.getAgencia();
//            double timbres = impuesto.getTimbres();
//            double impuesto_selec = impuesto.getImp_selec();
//            double derecho_arance = impuesto.getDerecho_aranc();
//            double gto_agenci = impuesto.getGto_agenci();
//            Date fechaingreso = impuesto.getFecha();
//            String fecha = formato.format(fechaingreso);
//
//            ModeloTabla.setValueAt(idImpuesto, i, 0);
//            ModeloTabla.setValueAt(dgi, i, 1);
//            ModeloTabla.setValueAt(tf, i, 2);
//            ModeloTabla.setValueAt(isc, i, 3);
//            ModeloTabla.setValueAt(dai, i, 4);
//            ModeloTabla.setValueAt(p_cif, i, 5);
//            ModeloTabla.setValueAt(flete_final, i, 6);
//            ModeloTabla.setValueAt(flete_usa, i, 7);
//            ModeloTabla.setValueAt(agencia, i, 8);
//            ModeloTabla.setValueAt(timbres, i, 9);
//            ModeloTabla.setValueAt(impuesto_selec, i, 10);
//            ModeloTabla.setValueAt(derecho_arance, i, 11);
//            ModeloTabla.setValueAt(gto_agenci, i, 12);
//            ModeloTabla.setValueAt(fecha, i, 13);
//            ModeloTabla.setValueAt(impuesto, i, 14);
//        }
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_producto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        CompoTotalRegistrosProductosRegistrados = new javax.swing.JLabel();
        campoBuscar = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        checkdai = new javax.swing.JCheckBox();
        checkisc = new javax.swing.JCheckBox();
        checktf = new javax.swing.JCheckBox();
        btninfo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_imp = new javax.swing.JTable();
        txt_id = new javax.swing.JTextField();
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

        label_precio.setText("Precio  FOB:");
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

        jButton1.setText("ACTUALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(label_descripcion)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_marca, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label_cantidad, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label_codigo, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_marca, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                .addComponent(txt_descripcion)
                                .addComponent(txt_cantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txt_pcif, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(label_precio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1))))
                .addContainerGap(12, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_precio)
                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_pcif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("INGRESO DE PRODUCTOS");

        tabla_producto.setModel(modeloTabla);
        tabla_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_productoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_producto);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("IMPUESTOS");

        checkdai.setText("DAI");

        checkisc.setText("ISC");

        checktf.setText("TF");

        btninfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/about.gif"))); // NOI18N
        btninfo.setText("INFO");
        btninfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninfoActionPerformed(evt);
            }
        });

        tabla_imp.setModel(ModeloTabla);
        tabla_imp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_impMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_imp);

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(40, 40, 40))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(283, 283, 283)
                            .addComponent(jLabel5))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(checkdai)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(checkisc)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(checktf))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btninfo)
                                    .addGap(31, 31, 31)))))
                    .addContainerGap(757, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(459, 459, 459)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(818, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5)
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(checkdai)
                                .addComponent(checkisc)
                                .addComponent(checktf))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btninfo)))
                    .addContainerGap(405, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(337, 337, 337)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(394, Short.MAX_VALUE)))
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
                                        int cantidad = Integer.parseInt(txt_cantidad.getText());

                                        double p_cif = 0;
                                        p_cif = precio * cantidad;
                                        if (checkdai.isSelected() == false && checkisc.isSelected() == false && checktf.isSelected() == false) {
                                            JOptionPane.showMessageDialog(null, "ELIGE UNA OPCIÓN DE IMPUESTO PARA AVANZAR");
                                        } else {
                                            if (checkdai.isSelected() && checkisc.isSelected() && checktf.isSelected()) {
                                                int dai1 = 1;
                                                int isc1 = 1;
                                                int tf1 = 1;
                                                nuevo_producto nuevo = new nuevo_producto(codigo, cantidad, nom_pro, marca, precio, p_cif, dai1, isc1, tf1);
                                                try {
                                                    base.insertarProductoNuevo(nuevo);
                                                } catch (FileNotFoundException ex) {
                                                    Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                }

                                                cargarModeloTabla1();
                                                txt_cantidad.setText("");
                                                txt_precio.setText("");
                                            } else {
                                                if (checktf.isSelected() && checkisc.isSelected() && checkdai.isSelected() == false) {
                                                    int dai1 = 0;
                                                    int isc1 = 1;
                                                    int tf1 = 1;
                                                    nuevo_producto nuevo = new nuevo_producto(codigo, cantidad, nom_pro, marca, precio, p_cif, dai1, isc1, tf1);
                                                    try {
                                                        base.insertarProductoNuevo(nuevo);
                                                    } catch (FileNotFoundException ex) {
                                                        Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                    }

                                                    cargarModeloTabla1();
                                                    txt_cantidad.setText("");
                                                    txt_precio.setText("");
                                                } else {
                                                    if (checktf.isSelected() == false && checkisc.isSelected() && checkdai.isSelected()) {
                                                        int dai1 = 1;
                                                        int isc1 = 1;
                                                        int tf1 = 0;
                                                        nuevo_producto nuevo = new nuevo_producto(codigo, cantidad, nom_pro, marca, precio, p_cif, dai1, isc1, tf1);
                                                        try {
                                                            base.insertarProductoNuevo(nuevo);
                                                        } catch (FileNotFoundException ex) {
                                                            Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                        }

                                                        cargarModeloTabla1();
                                                        txt_cantidad.setText("");
                                                        txt_precio.setText("");
                                                    } else {
                                                        if (checktf.isSelected() && checkisc.isSelected() == false && checkdai.isSelected()) {
                                                            int dai1 = 1;
                                                            int isc1 = 0;
                                                            int tf1 = 1;
                                                            nuevo_producto nuevo = new nuevo_producto(codigo, cantidad, nom_pro, marca, precio, p_cif, dai1, isc1, tf1);
                                                            try {
                                                                base.insertarProductoNuevo(nuevo);
                                                            } catch (FileNotFoundException ex) {
                                                                Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                            }

                                                            cargarModeloTabla1();
                                                            txt_cantidad.setText("");
                                                            txt_precio.setText("");
                                                        } else {
                                                            if (checktf.isSelected() == false && checkisc.isSelected() == false && checkdai.isSelected()) {
                                                                int dai1 = 1;
                                                                int isc1 = 0;
                                                                int tf1 = 0;
                                                                nuevo_producto nuevo = new nuevo_producto(codigo, cantidad, nom_pro, marca, precio, p_cif, dai1, isc1, tf1);
                                                                try {
                                                                    base.insertarProductoNuevo(nuevo);
                                                                } catch (FileNotFoundException ex) {
                                                                    Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                                }

                                                                cargarModeloTabla1();
                                                                txt_cantidad.setText("");
                                                                txt_precio.setText("");
                                                            } else {
                                                                if (checktf.isSelected() && checkisc.isSelected() == false && checkdai.isSelected() == false) {
                                                                    int dai1 = 0;
                                                                    int isc1 = 0;
                                                                    int tf1 = 1;
                                                                    nuevo_producto nuevo = new nuevo_producto(codigo, cantidad, nom_pro, marca, precio, p_cif, dai1, isc1, tf1);
                                                                    try {
                                                                        base.insertarProductoNuevo(nuevo);
                                                                    } catch (FileNotFoundException ex) {
                                                                        Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                                    }

                                                                    cargarModeloTabla1();
                                                                    txt_cantidad.setText("");
                                                                    txt_precio.setText("");
                                                                } else {
                                                                    if (checktf.isSelected() == false && checkisc.isSelected() && checkdai.isSelected() == false) {
                                                                        int dai1 = 0;
                                                                        int isc1 = 1;
                                                                        int tf1 = 0;
                                                                        nuevo_producto nuevo = new nuevo_producto(codigo, cantidad, nom_pro, marca, precio, p_cif, dai1, isc1, tf1);
                                                                        try {
                                                                            base.insertarProductoNuevo(nuevo);
                                                                        } catch (FileNotFoundException ex) {
                                                                            Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                                                        }

                                                                        cargarModeloTabla1();
                                                                        txt_cantidad.setText("");
                                                                        txt_precio.setText("");

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

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
                                        int id = Integer.parseInt(txt_id.getText());
                                        String codigo = txt_codigo.getText();
                                        String nom_pro = txt_descripcion.getText();

                                        String marca = txt_marca.getText();
                                        double precio = Double.parseDouble(txt_precio.getText());
                                        int cantidad = Integer.parseInt(txt_cantidad.getText());

                                        double p_cif = 0;
                                        p_cif = precio * cantidad;
                                        if (checkdai.isSelected() == false && checkisc.isSelected() == false && checktf.isSelected() == false) {
                                            JOptionPane.showMessageDialog(null, "ELIGE UNA OPCIÓN DE IMPUESTO PARA AVANZAR");
                                        } else {
                                            if (checkdai.isSelected() && checkisc.isSelected() && checktf.isSelected()) {
                                                int dai1 = 1;
                                                int isc1 = 1;
                                                int tf1 = 1;
                                                nuevo_producto nuevo = new nuevo_producto(id, codigo, cantidad, nom_pro, marca, precio, p_cif, dai1, isc1, tf1);
                                                base.actualizarProductoNuevo(nuevo);

                                                cargarModeloTabla1();
                                                txt_cantidad.setText("");
                                                txt_precio.setText("");
                                            } else {
                                                if (checktf.isSelected() && checkisc.isSelected() && checkdai.isSelected() == false) {
                                                    int dai1 = 0;
                                                    int isc1 = 1;
                                                    int tf1 = 1;
                                                    nuevo_producto nuevo = new nuevo_producto(id, codigo, cantidad, nom_pro, marca, precio, p_cif, dai1, isc1, tf1);
                                                    base.actualizarProductoNuevo(nuevo);

                                                    cargarModeloTabla1();
                                                    txt_cantidad.setText("");
                                                    txt_precio.setText("");
                                                } else {
                                                    if (checktf.isSelected() == false && checkisc.isSelected() && checkdai.isSelected()) {
                                                        int dai1 = 1;
                                                        int isc1 = 1;
                                                        int tf1 = 0;
                                                        nuevo_producto nuevo = new nuevo_producto(id, codigo, cantidad, nom_pro, marca, precio, p_cif, dai1, isc1, tf1);
                                                        base.actualizarProductoNuevo(nuevo);

                                                        cargarModeloTabla1();
                                                        txt_cantidad.setText("");
                                                        txt_precio.setText("");
                                                    } else {
                                                        if (checktf.isSelected() && checkisc.isSelected() == false && checkdai.isSelected()) {
                                                            int dai1 = 1;
                                                            int isc1 = 0;
                                                            int tf1 = 1;
                                                            nuevo_producto nuevo = new nuevo_producto(id, codigo, cantidad, nom_pro, marca, precio, p_cif, dai1, isc1, tf1);
                                                            base.actualizarProductoNuevo(nuevo);

                                                            cargarModeloTabla1();
                                                            txt_cantidad.setText("");
                                                            txt_precio.setText("");
                                                        } else {
                                                            if (checktf.isSelected() == false && checkisc.isSelected() == false && checkdai.isSelected()) {
                                                                int dai1 = 1;
                                                                int isc1 = 0;
                                                                int tf1 = 0;
                                                                nuevo_producto nuevo = new nuevo_producto(id, codigo, cantidad, nom_pro, marca, precio, p_cif, dai1, isc1, tf1);
                                                                base.actualizarProductoNuevo(nuevo);

                                                                cargarModeloTabla1();
                                                                txt_cantidad.setText("");
                                                                txt_precio.setText("");
                                                            } else {
                                                                if (checktf.isSelected() && checkisc.isSelected() == false && checkdai.isSelected() == false) {
                                                                    int dai1 = 0;
                                                                    int isc1 = 0;
                                                                    int tf1 = 1;
                                                                    nuevo_producto nuevo = new nuevo_producto(id, codigo, cantidad, nom_pro, marca, precio, p_cif, dai1, isc1, tf1);
                                                                    base.actualizarProductoNuevo(nuevo);

                                                                    cargarModeloTabla1();
                                                                    txt_cantidad.setText("");
                                                                    txt_precio.setText("");
                                                                } else {
                                                                    if (checktf.isSelected() == false && checkisc.isSelected() && checkdai.isSelected() == false) {
                                                                        int dai1 = 0;
                                                                        int isc1 = 1;
                                                                        int tf1 = 0;
                                                                        nuevo_producto nuevo = new nuevo_producto(id, codigo, cantidad, nom_pro, marca, precio, p_cif, dai1, isc1, tf1);
                                                                        base.actualizarProductoNuevo(nuevo);

                                                                        cargarModeloTabla1();
                                                                        txt_cantidad.setText("");
                                                                        txt_precio.setText("");

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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabla_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_productoMouseClicked
        DefaultTableModel modelo_imp = (DefaultTableModel) tabla_producto.getModel();
        txt_id.setText(modelo_imp.getValueAt(tabla_producto.getSelectedRow(), 0).toString());
        txt_codigo.setText(modelo_imp.getValueAt(tabla_producto.getSelectedRow(), 1).toString());
        txt_descripcion.setText(modelo_imp.getValueAt(tabla_producto.getSelectedRow(), 2).toString());
        txt_marca.setText(modelo_imp.getValueAt(tabla_producto.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_tabla_productoMouseClicked

    private void campoBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoBuscarMousePressed
        tabla_producto.clearSelection();
    }//GEN-LAST:event_campoBuscarMousePressed

    private void campoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscarActionPerformed

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased

        limpiarTabla();
        String cadenaBusqueda = campoBuscar.getText();
        ArrayList<producto> listaProductos = base.obtenerProductosPorCriterio(cadenaBusqueda);

        int numeroProductos = listaProductos.size();

        modeloTabla.setNumRows(numeroProductos);
        int totalregistros = 0;
        for (int i = 0; i < numeroProductos; i++) {

            producto producto = listaProductos.get(i);
            //

            int id = producto.getCodigo();
            String codProd = producto.getCodigo_pro();
            String descripcion = producto.getDescripcion();

            String marca = producto.getMarca();

            modeloTabla.setValueAt(id, i, 0);
            modeloTabla.setValueAt(codProd, i, 1);
            modeloTabla.setValueAt(descripcion, i, 2);
            modeloTabla.setValueAt(marca, i, 3);
            modeloTabla.setValueAt(producto, i, 4);
            totalregistros = i + 1;
        }
        CompoTotalRegistrosProductosRegistrados.setText(String.valueOf(totalregistros));
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void campoBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyTyped
        txtvalidar(evt);
    }//GEN-LAST:event_campoBuscarKeyTyped

    private void btninfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btninfoActionPerformed

    private void tabla_impMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_impMouseClicked
        DefaultTableModel modelo_imp = (DefaultTableModel) tabla_imp.getModel();
        txt_id.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 0).toString());
        txt_codigo.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 1).toString());
        txt_cantidad.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 2).toString());
        txt_descripcion.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 3).toString());
        txt_marca.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 4).toString());
        txt_precio.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 5).toString());
        txt_pcif.setText(modelo_imp.getValueAt(tabla_imp.getSelectedRow(), 6).toString());
    }//GEN-LAST:event_tabla_impMouseClicked
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
            java.util.logging.Logger.getLogger(Producto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Producto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Producto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Producto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Producto1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CompoTotalRegistrosProductosRegistrados;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btninfo;
    private app.bolivia.swing.JCTextField campoBuscar;
    private javax.swing.JCheckBox checkdai;
    private javax.swing.JCheckBox checkisc;
    private javax.swing.JCheckBox checktf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_cantidad;
    private javax.swing.JLabel label_codigo;
    private javax.swing.JLabel label_descripcion;
    private javax.swing.JLabel label_marca;
    private javax.swing.JLabel label_precio;
    private javax.swing.JTable tabla_imp;
    private javax.swing.JTable tabla_producto;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_pcif;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
