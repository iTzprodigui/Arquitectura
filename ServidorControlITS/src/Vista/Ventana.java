
package Vista;

import ColaPrioridad.Cola;
import ColaPrioridad.Nodo;
import Servidor.Algoritmo;
import Servidor.Servidor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 * @author david
 */

public class Ventana extends javax.swing.JFrame
{    
    private Servidor servidor;
    private Cola prioridad;
    Hilo tabla;
    DefaultTableModel dtm;
    Object[] o = new Object[3];
    
    public Ventana() {
        initComponents();
        componentes();
        setTitle("Servidor - Prioridad Control ITS");
        setLocationRelativeTo(null);
        dtm = (DefaultTableModel) jTable1.getModel();
    }
    
    public void componentes(){
        prioridad = new Cola();
        servidor = new Servidor(prioridad,ConsolaDatos);
        servidor.encender();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonConfigurar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        OpcComs = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ConsolaDatos = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonConfigurar.setText("Configurar");
        botonConfigurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfigurarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dato 1", "Dato 2", "Operador "
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        OpcComs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "COM11" }));
        OpcComs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcComsActionPerformed(evt);
            }
        });

        ConsolaDatos.setEditable(false);
        ConsolaDatos.setColumns(20);
        ConsolaDatos.setRows(5);
        jScrollPane1.setViewportView(ConsolaDatos);

        jLabel1.setText("Datos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonConfigurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OpcComs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonConfigurar)
                            .addComponent(OpcComs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpcComsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcComsActionPerformed

    }//GEN-LAST:event_OpcComsActionPerformed

    private void botonConfigurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfigurarActionPerformed

        if (tabla == null){
            tabla = new Hilo();
            tabla.start();
        }else{
            JOptionPane.showMessageDialog(null, "Ya configurado");
        }
    }//GEN-LAST:event_botonConfigurarActionPerformed

    public String configurarCOM(){
        String Com = "";
            switch(OpcComs.getSelectedIndex()){
                case 0:
                    Com = "COM1";
                    break;
                case 1:
                    Com = "COM2";
                    break;
                case 2:
                    Com = "COM3";
                    break;
                case 3:
                    Com = "COM4";
                    break;
                case 4:
                    Com = "COM5";
                    break;
                case 5:
                    Com = "COM6";
                    break;
                case 6:
                    Com = "COM7";
                    break;
                case 7:
                    Com = "COM8";
                    break;
                case 8:
                    Com = "COM9";
                    break;
                case 9:
                    Com = "COM11";
                    break;
            }
            return Com;
    }
    
    class Eliminar extends Thread{
        Cola prioridad;
        
        Eliminar(Cola prioridad){
            this.prioridad = prioridad;
        }
        
        @Override
        public void run(){
            
            Algoritmo algoritmo = new Algoritmo(configurarCOM());
            Nodo nodo;
            
            while(true){
                try {
                    if(prioridad.getInicio() != null){
                        nodo = prioridad.getInicio();
                        algoritmo.algoritmo(nodo.getValor1(), nodo.getValor2(), nodo.getPrioridad());
                        Thread.sleep(10000);
                        prioridad.eliminar();
                    }else{
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    class Hilo extends Thread{
        @Override
        public void run(){
            Eliminar eliminar = new Eliminar(prioridad);
            Nodo aux, aux2;
            aux = prioridad.getInicio();
            int a;
            
            eliminar.start();
            
            while(true){
                if(aux != null){
                    try{
                        while(aux != null){
                            dtm = (DefaultTableModel) jTable1.getModel();
                            o[0] = aux.getValor1();
                            o[1] = aux.getValor2();
                            o[2] = aux.getPrioridad();
                            dtm.addRow(o);
                            aux = aux.getSiguiente();
                        }
                        aux = prioridad.getInicio();

                        Thread.sleep(100);
                        
                        a = dtm.getRowCount();
                        
                        for (int i= 0; i < a; i++){
                            dtm.removeRow(0);
                        }
                    }
                    catch(Exception e){
                        aux = prioridad.getInicio();
                    }
                }else{
                    aux = prioridad.getInicio();
                }
            }
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ConsolaDatos;
    private javax.swing.JComboBox<String> OpcComs;
    private javax.swing.JButton botonConfigurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
