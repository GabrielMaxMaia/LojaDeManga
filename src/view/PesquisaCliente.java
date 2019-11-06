/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClienteController;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import lojademanga.ClienteTableModel;
import model.Cliente;

/**
 *
 * @author Rogerio
 */
public class PesquisaCliente extends javax.swing.JFrame {
    MainView parent;
    
    private ClienteController controller = ClienteController.getClienteController();
    
    private JTextField[] campos;
    
    public PesquisaCliente(MainView parent) {
        this.parent = parent;
        initComponents();
        setResizable(false);
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                close();
            }
        }); 
        setVisible(true);
        setAlwaysOnTop(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/logo.png")));
        
        jTable1.setModel(controller.getTableModel());  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextFieldCodCli = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldCPF = new javax.swing.JTextField();
        jTextFieldMail = new javax.swing.JTextField();
        jTextFieldCel = new javax.swing.JTextField();
        jTextFieldTel = new javax.swing.JTextField();
        jTextFieldCEP = new javax.swing.JTextField();
        jTextFieldEnd = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldEndNum = new javax.swing.JTextField();
        jTextFieldCidade = new javax.swing.JTextField();
        jTextFieldEndComp = new javax.swing.JTextField();
        jButtonCadastra = new javax.swing.JButton();
        jButtonPesquisa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(68, 53, 48)), "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ink Free", 0, 15), new java.awt.Color(68, 53, 48))); // NOI18N
        jPanel10.setForeground(new java.awt.Color(68, 53, 48));

        jLabel19.setForeground(new java.awt.Color(68, 53, 48));
        jLabel19.setText("Código do Cliente:");

        jLabel21.setForeground(new java.awt.Color(68, 53, 48));
        jLabel21.setText("Nome:");

        jLabel22.setForeground(new java.awt.Color(68, 53, 48));
        jLabel22.setText("E-mail:");

        jLabel23.setForeground(new java.awt.Color(68, 53, 48));
        jLabel23.setText("CEP:");

        jLabel24.setForeground(new java.awt.Color(68, 53, 48));
        jLabel24.setText("Tel. celular:");

        jLabel25.setForeground(new java.awt.Color(68, 53, 48));
        jLabel25.setText("Tel. fixo:");

        jLabel26.setForeground(new java.awt.Color(68, 53, 48));
        jLabel26.setText("Endereço:");

        jLabel27.setForeground(new java.awt.Color(68, 53, 48));
        jLabel27.setText("Nº:");

        jLabel28.setForeground(new java.awt.Color(68, 53, 48));
        jLabel28.setText("Bairro:");

        jLabel29.setForeground(new java.awt.Color(68, 53, 48));
        jLabel29.setText("Cidade:");

        jLabel30.setForeground(new java.awt.Color(68, 53, 48));
        jLabel30.setText("Complemento:");

        jLabel32.setForeground(new java.awt.Color(68, 53, 48));
        jLabel32.setText("CPF:");

        jTextFieldCodCli.setForeground(new java.awt.Color(68, 53, 48));
        jTextFieldCodCli.setToolTipText("Digite o código do cliente");
        jTextFieldCodCli.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));
        jTextFieldCodCli.setCaretColor(new java.awt.Color(68, 53, 48));

        jTextFieldNome.setForeground(new java.awt.Color(68, 53, 48));
        jTextFieldNome.setToolTipText("Digite o código do cliente");
        jTextFieldNome.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));
        jTextFieldNome.setCaretColor(new java.awt.Color(68, 53, 48));

        jTextFieldCPF.setForeground(new java.awt.Color(68, 53, 48));
        jTextFieldCPF.setToolTipText("Digite o código do cliente");
        jTextFieldCPF.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));
        jTextFieldCPF.setCaretColor(new java.awt.Color(68, 53, 48));

        jTextFieldMail.setForeground(new java.awt.Color(68, 53, 48));
        jTextFieldMail.setToolTipText("Digite o código do cliente");
        jTextFieldMail.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));
        jTextFieldMail.setCaretColor(new java.awt.Color(68, 53, 48));

        jTextFieldCel.setForeground(new java.awt.Color(68, 53, 48));
        jTextFieldCel.setToolTipText("Digite o código do cliente");
        jTextFieldCel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));
        jTextFieldCel.setCaretColor(new java.awt.Color(68, 53, 48));

        jTextFieldTel.setForeground(new java.awt.Color(68, 53, 48));
        jTextFieldTel.setToolTipText("Digite o código do cliente");
        jTextFieldTel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));
        jTextFieldTel.setCaretColor(new java.awt.Color(68, 53, 48));

        jTextFieldCEP.setForeground(new java.awt.Color(68, 53, 48));
        jTextFieldCEP.setToolTipText("Digite o código do cliente");
        jTextFieldCEP.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));
        jTextFieldCEP.setCaretColor(new java.awt.Color(68, 53, 48));

        jTextFieldEnd.setForeground(new java.awt.Color(68, 53, 48));
        jTextFieldEnd.setToolTipText("Digite o código do cliente");
        jTextFieldEnd.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));
        jTextFieldEnd.setCaretColor(new java.awt.Color(68, 53, 48));

        jTextFieldBairro.setForeground(new java.awt.Color(68, 53, 48));
        jTextFieldBairro.setToolTipText("Digite o código do cliente");
        jTextFieldBairro.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));
        jTextFieldBairro.setCaretColor(new java.awt.Color(68, 53, 48));

        jTextFieldEndNum.setForeground(new java.awt.Color(68, 53, 48));
        jTextFieldEndNum.setToolTipText("Digite o código do cliente");
        jTextFieldEndNum.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));
        jTextFieldEndNum.setCaretColor(new java.awt.Color(68, 53, 48));

        jTextFieldCidade.setForeground(new java.awt.Color(68, 53, 48));
        jTextFieldCidade.setToolTipText("Digite o código do cliente");
        jTextFieldCidade.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));
        jTextFieldCidade.setCaretColor(new java.awt.Color(68, 53, 48));

        jTextFieldEndComp.setForeground(new java.awt.Color(68, 53, 48));
        jTextFieldEndComp.setToolTipText("Digite o código do cliente");
        jTextFieldEndComp.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 216, 207), null));
        jTextFieldEndComp.setCaretColor(new java.awt.Color(68, 53, 48));

        jButtonCadastra.setBackground(new java.awt.Color(153, 216, 207));
        jButtonCadastra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonCadastra.setForeground(new java.awt.Color(68, 53, 48));
        jButtonCadastra.setText("Cadastrar cliente");
        jButtonCadastra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastraActionPerformed(evt);
            }
        });

        jButtonPesquisa.setBackground(new java.awt.Color(153, 216, 207));
        jButtonPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonPesquisa.setForeground(new java.awt.Color(68, 53, 48));
        jButtonPesquisa.setText("Pesquisar cliente");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCPF))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGap(0, 41, Short.MAX_VALUE)
                                .addComponent(jButtonPesquisa)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCadastra))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldMail))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jTextFieldEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel27))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jTextFieldCidade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel30)
                                        .addGap(1, 1, 1)))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldEndComp, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(jTextFieldEndNum)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCel)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastra, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel22)
                    .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jTextFieldCel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldEndNum, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jTextFieldEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEndComp, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(153, 216, 207));

        jTable1.setModel(new ClienteTableModel());
        jTable1.setGridColor(new java.awt.Color(153, 216, 207));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastraActionPerformed
        controller.addCliente(getTodosOsCampos());
    }//GEN-LAST:event_jButtonCadastraActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        AbstractTableModel model = (AbstractTableModel) jTable1.getModel();
        int index = jTable1.getSelectedRow();
        String cpf = model.getValueAt(index, 1).toString();
        close(cpf);
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new PesquisaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastra;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCEP;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldCel;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldCodCli;
    private javax.swing.JTextField jTextFieldEnd;
    private javax.swing.JTextField jTextFieldEndComp;
    private javax.swing.JTextField jTextFieldEndNum;
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldTel;
    // End of variables declaration//GEN-END:variables
    
    private void close(){
        parent.setEnabled(true);
    }
    
    private void close(String cpf){
        parent.puxaCliente(cpf);
        parent.setEnabled(true);
        this.dispose();
    }
    
    private JTextField[] getTodosOsCampos(){
        JTextField[] aux = {jTextFieldCPF, jTextFieldNome,
            jTextFieldMail, jTextFieldCel,
            jTextFieldTel, jTextFieldCEP,
            jTextFieldEnd, jTextFieldCidade,
            jTextFieldBairro, jTextFieldEndComp};
        
        for (int i = 0; i < aux.length; i++) {
            aux[i].setBackground(Color.white);
        }
        
        return aux;
    }
    
}
