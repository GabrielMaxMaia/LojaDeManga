/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.VendaController;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Rogerio
 */
public class MetodoPagamento extends javax.swing.JFrame {
    MainView parent;
    VendaController controller;
    public MetodoPagamento(MainView parent, String total) {
        this.parent = parent;
        this.controller = VendaController.getVendaController();
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jLabelTotalCompra.setText(total);
        jTextFieldValorRecebido.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                alterado();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                alterado();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                alterado();
            }
        });
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                close();
            }
        }); 
        setVisible(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/icone_manga.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bttGroupMetodo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelTotalCompra = new javax.swing.JLabel();
        jRadioButtonCredito = new javax.swing.JRadioButton();
        jRadioButtonDebito = new javax.swing.JRadioButton();
        jRadioButtonDinheiro = new javax.swing.JRadioButton();
        bttFinalizarPagamento = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldValorRecebido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabelTroco = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelTotalCompra1 = new javax.swing.JLabel();
        jLabelTotalCompra2 = new javax.swing.JLabel();
        jLabelTotalCompra3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(68, 53, 48));
        jLabel1.setText("Total da Compra:");

        jLabelTotalCompra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTotalCompra.setForeground(new java.awt.Color(68, 53, 48));
        jLabelTotalCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalCompra.setText("00,00");
        jLabelTotalCompra.setToolTipText("");
        jLabelTotalCompra.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));

        bttGroupMetodo.add(jRadioButtonCredito);
        jRadioButtonCredito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonCredito.setForeground(new java.awt.Color(68, 53, 48));
        jRadioButtonCredito.setText("Credito");

        bttGroupMetodo.add(jRadioButtonDebito);
        jRadioButtonDebito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonDebito.setForeground(new java.awt.Color(68, 53, 48));
        jRadioButtonDebito.setText("Debito");

        bttGroupMetodo.add(jRadioButtonDinheiro);
        jRadioButtonDinheiro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonDinheiro.setForeground(new java.awt.Color(68, 53, 48));
        jRadioButtonDinheiro.setText("Dinheiro");

        bttFinalizarPagamento.setBackground(new java.awt.Color(153, 216, 207));
        bttFinalizarPagamento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bttFinalizarPagamento.setForeground(new java.awt.Color(68, 53, 48));
        bttFinalizarPagamento.setText("Finalizar Pagamento");
        bttFinalizarPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bttFinalizarPagamentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bttFinalizarPagamentoMouseExited(evt);
            }
        });
        bttFinalizarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttFinalizarPagamentoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(68, 53, 48));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Valor Recebido:");

        jTextFieldValorRecebido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldValorRecebido.setForeground(new java.awt.Color(68, 53, 48));
        jTextFieldValorRecebido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldValorRecebido.setText("00,00");
        jTextFieldValorRecebido.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));
        jTextFieldValorRecebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorRecebidoActionPerformed(evt);
            }
        });
        jTextFieldValorRecebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldValorRecebidoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(68, 53, 48));
        jLabel4.setText("Troco:");

        jLabelTroco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTroco.setForeground(new java.awt.Color(68, 53, 48));
        jLabelTroco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTroco.setText("00,00");
        jLabelTroco.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(68, 53, 48));
        jLabel6.setText("Selecione a forma de pagamento:");

        jLabelTotalCompra1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTotalCompra1.setForeground(new java.awt.Color(68, 53, 48));
        jLabelTotalCompra1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalCompra1.setText("R$");
        jLabelTotalCompra1.setToolTipText("");
        jLabelTotalCompra1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));

        jLabelTotalCompra2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTotalCompra2.setForeground(new java.awt.Color(68, 53, 48));
        jLabelTotalCompra2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalCompra2.setText("R$");
        jLabelTotalCompra2.setToolTipText("");
        jLabelTotalCompra2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));

        jLabelTotalCompra3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTotalCompra3.setForeground(new java.awt.Color(68, 53, 48));
        jLabelTotalCompra3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalCompra3.setText("R$");
        jLabelTotalCompra3.setToolTipText("");
        jLabelTotalCompra3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(208, 208, 208)
                                .addComponent(jLabelTotalCompra3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(136, 136, 136)
                                .addComponent(jLabelTotalCompra2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(jLabelTotalCompra1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldValorRecebido, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelTotalCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))))
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jRadioButtonCredito)
                        .addGap(36, 36, 36)
                        .addComponent(jRadioButtonDebito)
                        .addGap(27, 27, 27)
                        .addComponent(jRadioButtonDinheiro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(bttFinalizarPagamento)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTotalCompra)
                    .addComponent(jLabelTotalCompra1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTotalCompra2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jLabelTroco)
                    .addComponent(jLabelTotalCompra3))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCredito)
                    .addComponent(jRadioButtonDebito)
                    .addComponent(jRadioButtonDinheiro))
                .addGap(18, 18, 18)
                .addComponent(bttFinalizarPagamento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldValorRecebidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorRecebidoActionPerformed
        
    }//GEN-LAST:event_jTextFieldValorRecebidoActionPerformed

    private void bttFinalizarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttFinalizarPagamentoActionPerformed
        if(controller.finalizarCompraDois()){
            parent.confirmaCompra();
        }
        close();
    }//GEN-LAST:event_bttFinalizarPagamentoActionPerformed

    private void bttFinalizarPagamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttFinalizarPagamentoMouseEntered
        // TODO add your handling code here:
        this.bttFinalizarPagamento.setForeground(Color.white);
    }//GEN-LAST:event_bttFinalizarPagamentoMouseEntered

    private void bttFinalizarPagamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttFinalizarPagamentoMouseExited
        // TODO add your handling code here:
        this.bttFinalizarPagamento.setForeground(new Color (68,53,48));
    }//GEN-LAST:event_bttFinalizarPagamentoMouseExited

    private void jTextFieldValorRecebidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorRecebidoKeyTyped
        
    }//GEN-LAST:event_jTextFieldValorRecebidoKeyTyped

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
            java.util.logging.Logger.getLogger(MetodoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MetodoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MetodoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MetodoPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MetodoPagamento(null, "10").setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bttFinalizarPagamento;
    private javax.swing.ButtonGroup bttGroupMetodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelTotalCompra;
    private javax.swing.JLabel jLabelTotalCompra1;
    private javax.swing.JLabel jLabelTotalCompra2;
    private javax.swing.JLabel jLabelTotalCompra3;
    private javax.swing.JLabel jLabelTroco;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonCredito;
    private javax.swing.JRadioButton jRadioButtonDebito;
    private javax.swing.JRadioButton jRadioButtonDinheiro;
    private javax.swing.JTextField jTextFieldValorRecebido;
    // End of variables declaration//GEN-END:variables
    
    private void close(){
        parent.setEnabled(true);
        dispose();
    }
    
    private void alterado(){
        if(jTextFieldValorRecebido.getText().length() > 0){
            float aux = stringToFloat(jLabelTotalCompra.getText()) 
                    - stringToFloat(jTextFieldValorRecebido.getText());
            jLabelTroco.setText(floatToString(aux));
        }
    }
    
    private float stringToFloat(String texto){
        String aux = texto.replaceAll(",", ".");
        System.out.println(aux);
        return Float.parseFloat(aux);
    }
    
    private String floatToString(float valor){
        System.out.println(Float.toString(valor));
        String aux = Float.toString(valor).replaceAll(".", ",");
        return aux;
    }
}
