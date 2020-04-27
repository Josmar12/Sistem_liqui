/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import Properties.PropiedadesSistema;
import datos.productoDao;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.producto;

public class Nuevo_producto1 extends javax.swing.JFrame {
productoDao base;
    DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    PropiedadesSistema sistema = new PropiedadesSistema();
    /**
     * Creates new form Nuevo_producto
     */
    public Nuevo_producto1() {
        initComponents();
        base = new productoDao();
        cargarColumnasTabla();
        cargarModeloTabla();
        ocultar_columnas();
        btn_actualizar.setEnabled(false);
        txtcod.setVisible(false);
        txtcod.setEnabled(false);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setIconImage(new ImageIcon(getClass().getResource("/Principal/new.png")).getImage());
    }
    Timer timer = null;
    TimerTask task;
    int i = 32;
    
    private void Cerrar() {
        this.dispose();
        timer = null;
        task = null;
    }
    private void limpiarTabla() {
        int numFilas = modeloTabla.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                modeloTabla.removeRow(i);
            }
        }
    }
    
    void ocultar_columnas() {

        tabla_producto.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_producto.getColumnModel().getColumn(0).setMinWidth(0);
        tabla_producto.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabla_producto.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla_producto.getColumnModel().getColumn(4).setMinWidth(0);
        tabla_producto.getColumnModel().getColumn(4).setPreferredWidth(0);

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
    
    
    private void cargarModeloTabla() {

        limpiarTabla();
        ArrayList<producto> listaProductos = base.obtenerProductos();
        int numeroProductos = listaProductos.size();
        modeloTabla.setNumRows(numeroProductos);
        int totalregistros = 0;
        for (int i = 0; i < numeroProductos; i++) {

            producto producto = listaProductos.get(i);
            
            int cod = producto.getCodigo();
            String codProd = producto.getCodigo_pro();
            String descripcion = producto.getDescripcion();

            String marca = producto.getMarca();

            
            modeloTabla.setValueAt(cod, i, 0);
            modeloTabla.setValueAt(codProd, i, 1);
            modeloTabla.setValueAt(descripcion, i, 2);
            modeloTabla.setValueAt(marca, i, 3);
            modeloTabla.setValueAt(producto, i, 4);
            totalregistros = i + 1;
        }
        CompoTotalRegistrosProductosRegistrados.setText(String.valueOf(totalregistros));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        label_codigo = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        label_descripcion = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        label_marca = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_producto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        CompoTotalRegistrosProductosRegistrados = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        campoBuscar = new app.bolivia.swing.JCTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("INGRESO DE PRODUCTOS");

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

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnmodificar.setText("MODIFICAR");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btn_actualizar.setText("ACTUALIZAR");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

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
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CompoTotalRegistrosProductosRegistrados, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CompoTotalRegistrosProductosRegistrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1074, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(447, 447, 447)
                .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(jLabel5))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnGuardar)
                            .addGap(18, 18, 18)
                            .addComponent(btnmodificar)
                            .addGap(10, 10, 10)
                            .addComponent(btn_actualizar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelar))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label_descripcion)
                                        .addComponent(label_codigo))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_descripcion)
                                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label_marca)
                                    .addGap(38, 38, 38)
                                    .addComponent(txt_marca)))))
                    .addGap(32, 32, 32)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(388, 388, 388)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(106, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(278, 278, 278))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jLabel5))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(label_codigo)
                                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(label_descripcion)
                                .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(label_marca)
                                .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnGuardar)
                                .addComponent(btnmodificar)
                                .addComponent(btn_actualizar)
                                .addComponent(btnCancelar))
                            .addGap(385, 385, 385))
                        .addComponent(jScrollPane1))
                    .addContainerGap()))
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        tabla_producto.clearSelection();
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

                                String nom_pro = txt_descripcion.getText();

                                String marca = txt_marca.getText();
                                String codigo = txt_codigo.getText();

                                producto producto = new producto(codigo, nom_pro, marca);

                                try {
                                    base.insertarProducto(producto);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(Producto1.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                cargarModeloTabla();
                                txt_descripcion.setText("");
                                txt_marca.setText("");
                                txt_codigo.setText("");

                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        DefaultTableModel modelo_imp = (DefaultTableModel) tabla_producto.getModel();
        txtcod.setText(modelo_imp.getValueAt(tabla_producto.getSelectedRow(), 0).toString());
        txt_codigo.setText(modelo_imp.getValueAt(tabla_producto.getSelectedRow(), 1).toString());
        txt_descripcion.setText(modelo_imp.getValueAt(tabla_producto.getSelectedRow(), 2).toString());
        txt_marca.setText(modelo_imp.getValueAt(tabla_producto.getSelectedRow(), 3).toString());

        btn_actualizar.setEnabled(true);
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        tabla_producto.clearSelection();

        if (tabla_producto.getSelectedRow() == 1) {
            if (tabla_producto.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "La tabla esta vacia");
            } else {
                JOptionPane.showMessageDialog(null, "Seleccion un elemento de la tabla");
            }
        } else {
            //
            //
            int cod = Integer.parseInt(txtcod.getText());
            String nom_pro = txt_descripcion.getText();
            String marca = txt_marca.getText();
            String codigo = txt_codigo.getText();

            producto producto = new producto(cod,codigo, nom_pro, marca);

            base.actualizarProducto(producto);

            cargarModeloTabla();
            int opcion = 1;
            if (opcion != 0) {
                JOptionPane.showMessageDialog(null, "Se ha actualizado el producto");
            }
        }

        txt_codigo.setText("");
        txt_descripcion.setText("");
        txt_marca.setText("");
        btn_actualizar.setEnabled(false);
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txt_codigo.setText("");
        txt_descripcion.setText("");
        txt_marca.setText("");
        btn_actualizar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tabla_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_productoMouseClicked

    }//GEN-LAST:event_tabla_productoMouseClicked

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
            java.util.logging.Logger.getLogger(Nuevo_producto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nuevo_producto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nuevo_producto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nuevo_producto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nuevo_producto1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CompoTotalRegistrosProductosRegistrados;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btnmodificar;
    private app.bolivia.swing.JCTextField campoBuscar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_codigo;
    private javax.swing.JLabel label_descripcion;
    private javax.swing.JLabel label_marca;
    private javax.swing.JTable tabla_producto;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txtcod;
    // End of variables declaration//GEN-END:variables
}
