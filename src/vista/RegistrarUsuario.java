/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;



import modelos.Usuario;
import javax.swing.JOptionPane;
import ControladorEntidades.RegistarU;


/**
 *
 * @author Andres R
 */
public class RegistrarUsuario extends javax.swing.JFrame {


    /**
     * Creates new form RegistrarUsuario
     */
    public RegistrarUsuario() {
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Registro");
    }
    
//    UsuarioJpaController CUsuar = new UsuarioJpaController();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextCedula = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        jTextApellidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboDia = new javax.swing.JComboBox<>();
        jComboMes = new javax.swing.JComboBox<>();
        jComboAnio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboGenero = new javax.swing.JComboBox<>();
        jTextCorreo = new javax.swing.JTextField();
        jTextTelefono = new javax.swing.JTextField();
        jTextDireccion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DATOS PERSONALES:");

        jTextCedula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextCedula.setText("Cédula");
        jTextCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextCedulaMouseReleased(evt);
            }
        });
        jTextCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCedulaActionPerformed(evt);
            }
        });
        jTextCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCedulaKeyTyped(evt);
            }
        });

        jTextNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextNombre.setText("Nombres");
        jTextNombre.setDragEnabled(true);
        jTextNombre.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                jTextNombreAncestorRemoved(evt);
            }
        });
        jTextNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextNombreMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextNombreMouseReleased(evt);
            }
        });
        jTextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreActionPerformed(evt);
            }
        });
        jTextNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreKeyTyped(evt);
            }
        });

        jTextApellidos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextApellidos.setText("Apellidos");
        jTextApellidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextApellidosMouseReleased(evt);
            }
        });
        jTextApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextApellidosKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Fecha de Nacimiento:");

        jComboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboDiaActionPerformed(evt);
            }
        });

        jComboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes ", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jComboAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980" }));
        jComboAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAnioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Género:");

        jComboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer", "Otro" }));

        jTextCorreo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextCorreo.setText("Correo Electronico");
        jTextCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextCorreoMouseReleased(evt);
            }
        });

        jTextTelefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextTelefono.setText("Teléfono");
        jTextTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextTelefonoMouseReleased(evt);
            }
        });
        jTextTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTelefonoKeyTyped(evt);
            }
        });

        jTextDireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextDireccion.setText("Dirección");
        jTextDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextDireccionMouseReleased(evt);
            }
        });
        jTextDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDireccionKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ic-back_97586.png"))); // NOI18N
        jButton1.setText("Regresar");
        jButton1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/diskette_save_saveas_1514.png"))); // NOI18N
        jButton2.setText("Registrarse");
        jButton2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("REGISTRO ");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/businessapplication_edit_male_user_thepencil_theclient_negocio_2321.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Football_2-25_icon-icons.com_72097.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jComboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21)
                                .addComponent(jComboAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextCedula)
                                        .addComponent(jTextNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                                    .addComponent(jTextApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextTelefono)
                                        .addComponent(jTextCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                    .addComponent(jTextDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCorreo))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCedulaActionPerformed

    private void jComboDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboDiaActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jComboDiaActionPerformed

    private void jTextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       JFramePerfilUsuario menu = new JFramePerfilUsuario();
       menu.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            RegistarU regis = new RegistarU();
            regis.registrarUsu();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboAnioActionPerformed

    private void jTextNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextNombreMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreMouseExited

    private void jTextNombreAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTextNombreAncestorRemoved
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextNombreAncestorRemoved

    private void jTextNombreMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextNombreMouseReleased
        // TODO add your handling code here:
         jTextNombre.setText("");
    }//GEN-LAST:event_jTextNombreMouseReleased

    private void jTextCedulaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextCedulaMouseReleased
        // TODO add your handling code here:
        jTextCedula.setText("");
    }//GEN-LAST:event_jTextCedulaMouseReleased

    private void jTextApellidosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextApellidosMouseReleased
        // TODO add your handling code here:
        jTextApellidos.setText("");
    }//GEN-LAST:event_jTextApellidosMouseReleased

    private void jTextCorreoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextCorreoMouseReleased
        // TODO add your handling code here:
        jTextCorreo.setText("");
    }//GEN-LAST:event_jTextCorreoMouseReleased

    private void jTextTelefonoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextTelefonoMouseReleased
        // TODO add your handling code here:
        jTextTelefono.setText("");
    }//GEN-LAST:event_jTextTelefonoMouseReleased

    private void jTextDireccionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextDireccionMouseReleased
        // TODO add your handling code here:
        jTextDireccion.setText("");
    }//GEN-LAST:event_jTextDireccionMouseReleased

    private void jTextCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCedulaKeyTyped
        // TODO add your handling code here:
        char verificaram = evt.getKeyChar();
        if (Character.isLetter(verificaram) || jTextCedula.getText().length() >9) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextCedulaKeyTyped

    private void jTextNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyTyped
        // TODO add your handling code here:
        char verificarno = evt.getKeyChar();
        if (Character.isDigit(verificarno)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextNombreKeyTyped

    private void jTextApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextApellidosKeyTyped
        // TODO add your handling code here:
        char verificarno = evt.getKeyChar();
        if (Character.isDigit(verificarno)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextApellidosKeyTyped

    private void jTextDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDireccionKeyTyped
        // TODO add your handling code here:
        char verificarno = evt.getKeyChar();
        if (Character.isDigit(verificarno)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextDireccionKeyTyped

    private void jTextTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTelefonoKeyTyped
        // TODO add your handling code here:
        char verificaram = evt.getKeyChar();
        if (Character.isLetter(verificaram) || jTextTelefono.getText().length() > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextTelefonoKeyTyped

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
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JComboBox<String> jComboAnio;
    private javax.swing.JComboBox<String> jComboBox1;
    public static javax.swing.JComboBox<String> jComboDia;
    private javax.swing.JComboBox<String> jComboGenero;
    public static javax.swing.JComboBox<String> jComboMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField jTextApellidos;
    public static javax.swing.JTextField jTextCedula;
    public static javax.swing.JTextField jTextCorreo;
    public static javax.swing.JTextField jTextDireccion;
    public static javax.swing.JTextField jTextNombre;
    public static javax.swing.JTextField jTextTelefono;
    // End of variables declaration//GEN-END:variables
}
