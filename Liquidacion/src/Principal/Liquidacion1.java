/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Properties.PropiedadesSistema;
import com.lowagie.text.Anchor;
import com.lowagie.text.pdf.PdfWriter;
import datos.imp_calculadoDao;
import datos.productoDao;
import java.awt.Font;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.Document;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import modelos.imp_calculados;
import modelos.producto;

public class Liquidacion1 extends javax.swing.JFrame {

    PropiedadesSistema sistema = new PropiedadesSistema();
    imp_calculadoDao base;
    productoDao productoDao = new productoDao();

    imp_calculados productoSeleccionado = null;

    DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private JFileChooser abrirArchivo = new JFileChooser();
    private TableModel tableModel;
    private File archivo;
//    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
//    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);

    public Liquidacion1() {
        initComponents();
        base = new imp_calculadoDao();
        cargarColumnasTabla();
        cargarModeloTabla();
        totales();
        ocultar_columnas();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setIconImage(new ImageIcon(getClass().getResource("/Principal/new.png")).getImage());

        this.tabla_liqui.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void limpiarTabla() {
        int numFilas = modeloTabla.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                modeloTabla.removeRow(i);
            }
        }
    }
    Timer timer = null;
    TimerTask task;
    int i = 32;

    private void Cerrar() {
        this.dispose();
        timer = null;
        task = null;
    }

    void ocultar_columnas() {
//
//        tabla_liqui.getColumnModel().getColumn(0).setMaxWidth(0);
//        tabla_liqui.getColumnModel().getColumn(0).setMinWidth(0);
//        tabla_liqui.getColumnModel().getColumn(0).setPreferredWidth(0);
//        tabla_liqui.getColumnModel().getColumn(1).setMaxWidth(0);
//        tabla_liqui.getColumnModel().getColumn(1).setMinWidth(0);
////        tabla_liqui.getColumnModel().getColumn(1).setPreferredWidth(0);
//        tabla_liqui.getColumnModel().getColumn(20).setMaxWidth(0);
//        tabla_liqui.getColumnModel().getColumn(20).setMinWidth(0);
//        tabla_liqui.getColumnModel().getColumn(20).setPreferredWidth(0);

    }

    private void cargarColumnasTabla() {

//        modeloTabla.addColumn("ID");
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

//        modeloTabla.addColumn("Prueba");
    }
    DecimalFormat df = new DecimalFormat("#0.00");

    private void cargarModeloTabla() {

        limpiarTabla();
        ArrayList<imp_calculados> listaImpuestoC = base.obtenerImpuestoC();
        int numeroProductos = listaImpuestoC.size();
        modeloTabla.setNumRows(numeroProductos);
        for (int i = 0; i < numeroProductos; i++) {

            imp_calculados calculado = listaImpuestoC.get(i);

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

//            modeloTabla.setValueAt(idCalculado, i, 0);
            modeloTabla.setValueAt(codProd, i, 0);
            modeloTabla.setValueAt(existencias, i, 1);
            modeloTabla.setValueAt(descripcion, i, 2);
            modeloTabla.setValueAt(marca, i, 3);
            modeloTabla.setValueAt(precio, i, 4);
            modeloTabla.setValueAt(df.format(p_cif), i, 5);
            modeloTabla.setValueAt(df.format(dai), i, 6);
            modeloTabla.setValueAt(df.format(isc), i, 7);
            modeloTabla.setValueAt(df.format(tf), i, 8);
            modeloTabla.setValueAt(df.format(gto_agencia), i, 9);
            modeloTabla.setValueAt(df.format(costo_total), i, 10);
            modeloTabla.setValueAt(df.format(costo_unitario), i, 11);
            modeloTabla.setValueAt(df.format(minorista), i, 12);
            modeloTabla.setValueAt(df.format(licitacion), i, 13);
            modeloTabla.setValueAt(df.format(mayorista), i, 14);
            modeloTabla.setValueAt(df.format(mpyme), i, 15);
            modeloTabla.setValueAt(df.format(publico), i, 16);
            modeloTabla.setValueAt(df.format(enemigo), i, 17);
            modeloTabla.setValueAt(df.format(malo), i, 18);
//            modeloTabla.setValueAt(calculado, i, 20);
        }

    }

    private void totales() {

        String cant;
        String pre;
        String pcif;
        String dai;
        String isc;
        String tf;
        String agencia;
        String costo_total;

        double cantidad = 0, cantidad2 = 0;
        double precio = 0, precio2 = 0;
        double p_cif = 0, p_cif2 = 0;
        double dai1 = 0, dai2 = 0;
        double isc1 = 0, isc2 = 0;
        double tf1 = 0, tf2 = 0;
        double agencia1 = 0, agencia2 = 0;
        double costo_total1 = 0, costo_total2 = 0;

        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            cant = modeloTabla.getValueAt(i, 1).toString();
            pre = modeloTabla.getValueAt(i, 4).toString();
            pcif = modeloTabla.getValueAt(i, 5).toString();
            dai = modeloTabla.getValueAt(i, 6).toString();
            isc = modeloTabla.getValueAt(i, 7).toString();
            tf = modeloTabla.getValueAt(i, 8).toString();
            agencia = modeloTabla.getValueAt(i, 9).toString();
            costo_total = modeloTabla.getValueAt(i, 10).toString();

            precio = Double.parseDouble(pre);
            cantidad = Double.parseDouble(cant);
            p_cif = Double.parseDouble(pcif);
            dai1 = Double.parseDouble(dai);
            isc1 = Double.parseDouble(isc);
            tf1 = Double.parseDouble(tf);
            agencia1 = Double.parseDouble(agencia);
            costo_total1 = Double.parseDouble(costo_total);

            p_cif2 += p_cif;
            precio2 += precio;
            cantidad2 += cantidad;
            dai2 += dai1;
            isc2 += isc1;
            tf2 += tf1;
            agencia2 += agencia1;
            costo_total2 += costo_total1;

        }
        label_cant.setText("" + df.format(cantidad2));
        label_precio.setText("" + df.format(precio2));
        label_pcif.setText("" + df.format(p_cif2));
        label_dai.setText("" + df.format(dai2));
        label_isc.setText("" + df.format(isc2));
        label_tf.setText("" + df.format(tf2));
        label_agencia1.setText("" + df.format(agencia2));
        label_costo_total.setText("" + df.format(costo_total2));
    }

    public void exportarDataExcel(JTable table, String[] titles, int[] colum, String pagina) {
        abrirArchivo.setFileFilter(new FileNameExtensionFilter("Excel", "xls"));
        abrirArchivo.setDialogTitle("Especifique un archivo para guardar");
        int respuesta = abrirArchivo.showSaveDialog(this);
        WritableSheet excelSheet = null;
        WritableWorkbook excelWorkbook = null;
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            archivo = new File(abrirArchivo.getSelectedFile().getPath() + ".xls");
            try {
                excelWorkbook = Workbook.createWorkbook(archivo);
                excelWorkbook.createSheet(pagina, 0);
                excelSheet = excelWorkbook.getSheet(0);
                tableModel = table.getModel();
                int cols = tableModel.getColumnCount();
                int filas = tableModel.getRowCount();
                int fila = 1;
                int column = 0;
                for (int i = 0; i < titles.length; i++) {
                    jxl.write.Label title = new jxl.write.Label(i, 0, titles[i]);
                    excelSheet.addCell(title);
                }
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < cols; j++) {
                        boolean valor = true;
                        for (int k = 0; k < colum.length; k++) {
                            if (j == colum[k]) {
                                valor = false;
                            }
                        }
                        if (valor) {
                            jxl.write.Label datos = new jxl.write.Label(column, fila, tableModel.getValueAt(i, j).toString());
                            excelSheet.addCell(datos);
                            column++;
                        }
                    }
                    fila++;
                    column = 0;
                }
                int opcion = 1;
                if (opcion != 0) {

                    JOptionPane.showMessageDialog(null, "Exportación exitosa");
                }
                excelWorkbook.write();
                excelWorkbook.close();
            } catch (IOException ex) {

            } catch (WriteException ex) {

            }

        }
    }

//    public void exportarDataPdf(JTable tables, String[] titles, int[] colum, String pagina) {
//        abrirArchivo.setFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
//        abrirArchivo.setDialogTitle("Especifique un archivo para guardar");
//        int respuesta = abrirArchivo.showSaveDialog(this);
//        if (respuesta == JFileChooser.APPROVE_OPTION) {
//            archivo = new File(abrirArchivo.getSelectedFile().getPath() + ".pdf");
//            // Creamos el documento e indicamos el nombre del fichero.
//            Document document = new Document();
//            try {
//                PdfWriter.getInstance(document, new FileOutputStream(archivo));
//
//                document.open();
//                // Añadimos los metadatos del PDF
//                document.addKeywords("Java, PDF");
//                document.addAuthor("Código PDHN");
//                document.addCreator("Código PDHN");
//
//                // Primera página
//                Anchor anchor = new Anchor(pagina, categoryFont);
//                // El segundo parámetro es el número del capítulo.
//                Chapter catPart = new Chapter(new Paragraph(anchor), 1);
//                Paragraph subPara = new Paragraph("JON JIM S.A", subcategoryFont);
//                Section subCatPart = catPart.addSection(subPara);
//                subCatPart.add(new Paragraph("Listado"));
//                // Creamos la tabla
//                PdfPTable table = new PdfPTable(titles.length);
//                // Ahora llenamos las filas de Table
//                PdfPCell columnHeader;
//                // Rellenamos las cabeceras de las columnas de la tabla.                
//                for (int column = 0; column < titles.length; column++) {
//                    columnHeader = new PdfPCell(new Phrase(titles[column]));
//                    table.addCell(columnHeader);
//                }
//                table.setHeaderRows(1);
//                // rellenamos las filas de la tabla.                
//                for (int row = 0; row < tables.getRowCount(); row++) {
//                    for (int column = 0; column < tables.getColumnCount(); column++) {
//                        boolean valor = true;
//                        for (int a = 0; a < colum.length; a++) {
//                            if (column == colum[a]) {
//                                valor = false;
//                            }
//                        }
//                        if (valor) {
//                            table.addCell(tables.getValueAt(row, column).toString());
//                        }
//                    }
//                }
//                subCatPart.add(table);
//
//                document.add(catPart);
//
//                int opcion = 1;
//                if (opcion != 0) {
//
//                    JOptionPane.showMessageDialog(null,"Exportación exitosa");
//                }
//                document.close();
//
//            } catch (FileNotFoundException ex) {
//                System.out.println("No se encontró el fichero para generar el pdf" + ex.getMessage());
//            } catch (DocumentException ex) {
//                System.out.println("No se encontró el fichero para generar el pdf" + ex.getMessage());
//            }
//
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

        btngenerar = new javax.swing.JButton();
        btnExportarExcel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label_precio = new javax.swing.JLabel();
        label_cant = new javax.swing.JLabel();
        label_pcif = new javax.swing.JLabel();
        label_dai = new javax.swing.JLabel();
        label_isc = new javax.swing.JLabel();
        label_tf = new javax.swing.JLabel();
        label_costo_total = new javax.swing.JLabel();
        label_agencia1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_liqui = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btngenerar.setText("GENERAR NUEVA TABLA");
        btngenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngenerarActionPerformed(evt);
            }
        });

        btnExportarExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Excel (1).png"))); // NOI18N
        btnExportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarExcelActionPerformed(evt);
            }
        });

        jLabel1.setText("CANTIDAD");

        jLabel2.setText("PRECIO");

        jLabel3.setText("P CIF");

        jLabel4.setText("DAI");

        jLabel5.setText("ISC");

        jLabel6.setText("TF");

        jLabel7.setText("GASTO DE AGENCIA");

        jLabel8.setText("COSTO TOTAL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(label_cant, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(label_pcif, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_dai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label_isc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel6)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(label_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(label_agencia1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_costo_total, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_cant, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_pcif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_dai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_isc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_tf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_costo_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_agencia1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btngenerar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExportarExcel)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnExportarExcel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(btngenerar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btngenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngenerarActionPerformed

        base.borrarImpuestoC();
        cargarModeloTabla();

        label_cant.setText("0.00");
        label_precio.setText("0.00");
        label_pcif.setText("0.00");
        label_dai.setText("0.00");
        label_isc.setText("0.00");
        label_tf.setText("0.00");
        label_agencia1.setText("0.00");
        label_costo_total.setText("0.00");
    }//GEN-LAST:event_btngenerarActionPerformed

    private void btnExportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarExcelActionPerformed
        String[] title = {"CODIGO", "CANTIDAD", "DESCRIPCIÓN", "MARCA", "PRECIO FOB", "P.CIF",
            "DAI", "ISC", "TF", "GASTOS AGEN. Y OTROS", "COSTO TOTAL", "COSTO UNITARIO", "8%",
            "10%", "12%", "15%", "17%", "20%", "25%"};
        int[] colum = {};

        exportarDataExcel(tabla_liqui, title, colum, "MAESTRO DE LIQUIDACIÓN DE POLIZA");
    }//GEN-LAST:event_btnExportarExcelActionPerformed

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
            java.util.logging.Logger.getLogger(Liquidacion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Liquidacion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Liquidacion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Liquidacion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Liquidacion1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportarExcel;
    private javax.swing.JButton btngenerar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_agencia1;
    private javax.swing.JLabel label_cant;
    private javax.swing.JLabel label_costo_total;
    private javax.swing.JLabel label_dai;
    private javax.swing.JLabel label_isc;
    private javax.swing.JLabel label_pcif;
    private javax.swing.JLabel label_precio;
    private javax.swing.JLabel label_tf;
    private javax.swing.JTable tabla_liqui;
    // End of variables declaration//GEN-END:variables
}
