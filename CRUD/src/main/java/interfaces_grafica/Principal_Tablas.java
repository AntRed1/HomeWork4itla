package interfaces_grafica;

import informacion.*;
import informacion.conexion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;

public class Principal_Tablas extends javax.swing.JFrame {

    DefaultTableModel dtm;

    public Principal_Tablas() {
        super("Ejercicio.4");
        initComponents();
        setLocationRelativeTo(null);
        this.dispose();
        String[] titulo = new String[]{"ID_User", "Nomb_User", "Password", " Nombres ", "Apellidos ", "Telefono", "Email"};
        dtm = new DefaultTableModel(null, titulo);

        tblCliente_Registro.setModel(dtm);
        dtm.isCellEditable(0, 1);

        try {

            PreparedStatement ps = null;
            ResultSet rs = null;
            SQL_Metodos conn = new SQL_Metodos();
            Connection con = conn.getConnection();

            String SQL_SELECT = "SELECT ID_User,Nomb_User, Password, Nombres,Apellidos,Telefono, Email FROM informacion_usuarios";
            ps = con.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = rs.getObject(i + 1);

                }

                dtm.addRow(filas);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente_Registro = new javax.swing.JTable();
        btnEliminar_Registro = new javax.swing.JButton();
        btnActualizar_Registro = new javax.swing.JButton();
        btmLimpiar_Registro = new javax.swing.JButton();
        btnAñadir_Tabla_Registro = new javax.swing.JButton();
        btnRefrescar_Registro = new javax.swing.JButton();
        btnCerrar_Sesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNomb_User_Update = new javax.swing.JTextField();
        txtPassword_Update = new javax.swing.JTextField();
        txtNombres_Update = new javax.swing.JTextField();
        txtEmail_Update = new javax.swing.JTextField();
        txtApellidos_Update = new javax.swing.JTextField();
        txtTelefono_Update = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtID_User_Update = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Clientes Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N

        tblCliente_Registro = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblCliente_Registro.setBackground(new java.awt.Color(204, 204, 204));
        tblCliente_Registro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblCliente_Registro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_User", "Nomb_User", "Password", "Nombres", "Apellidos", "Telefono", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente_Registro.setToolTipText("");
        tblCliente_Registro.setCellSelectionEnabled(true);
        tblCliente_Registro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblCliente_Registro.setFocusable(false);
        tblCliente_Registro.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCliente_Registro);

        btnEliminar_Registro.setText("Eliminar");
        btnEliminar_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_RegistroActionPerformed(evt);
            }
        });

        btnActualizar_Registro.setText("Actualizar");
        btnActualizar_Registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUserMouseClicked(evt);
            }
        });
        btnActualizar_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar_RegistroActionPerformed(evt);
            }
        });

        btmLimpiar_Registro.setText("Limpiar");
        btmLimpiar_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmLimpiar_RegistroActionPerformed(evt);
            }
        });

        btnAñadir_Tabla_Registro.setText("Añadir");
        btnAñadir_Tabla_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadir_Tabla_RegistroActionPerformed(evt);
            }
        });

        btnRefrescar_Registro.setText("Refrescar");
        btnRefrescar_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescar_RegistroActionPerformed(evt);
            }
        });

        btnCerrar_Sesion.setText("<html>Cerrar Sesion</html>");
        btnCerrar_Sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar_SesionActionPerformed(evt);
            }
        });

        jLabel1.setText("Nomb_User");

        jLabel2.setText("Password");

        jLabel3.setText("Nombres");

        jLabel4.setText("Apellidos");

        jSeparator1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel5.setText("Telefono");

        jLabel6.setText("Email");

        txtNomb_User_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomb_User_UpdateActionPerformed(evt);
            }
        });

        jLabel7.setText("ID_User");

        txtID_User_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtID_User_UpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAñadir_Tabla_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnActualizar_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btmLimpiar_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRefrescar_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrar_Sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomb_User_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassword_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombres_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtApellidos_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtEmail_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtTelefono_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(txtID_User_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtID_User_Update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomb_User_Update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos_Update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword_Update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono_Update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombres_Update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail_Update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar_Sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefrescar_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btmLimpiar_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAñadir_Tabla_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAñadir_Tabla_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadir_Tabla_RegistroActionPerformed
        Principal_Registro pr = new Principal_Registro();
        pr.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_btnAñadir_Tabla_RegistroActionPerformed

    private void btnActualizar_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar_RegistroActionPerformed
        int fila = tblCliente_Registro.getSelectedRow();
        
        User_Signup us = new User_Signup();
        
        

    }//GEN-LAST:event_btnActualizar_RegistroActionPerformed

    private void btnRefrescar_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescar_RegistroActionPerformed

        SQL_Metodos metodos = new SQL_Metodos();
        User_Signup user = new User_Signup();
        List<User_Signup> users = metodos.seleccionar();

        if (users != null) {

            try {

                PreparedStatement ps = null;
                ResultSet rs = null;
                SQL_Metodos conn = new SQL_Metodos();
                Connection con = conn.getConnection();

                String SQL_SELECT = "SELECT ID_User,Nomb_User, Password, Nombres,Apellidos,Telefono, Email FROM informacion_usuarios";
                ps = con.prepareStatement(SQL_SELECT);
                rs = ps.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();
                int cantidadColumnas = rsmd.getColumnCount();

                while (rs.next()) {

                    Object[] filas = new Object[cantidadColumnas];

                    for (int i = 0; i < cantidadColumnas; i++) {

                        filas[i] = rs.getObject(i + 1);

                    }

                    dtm.addRow(filas);
                }

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);

            }
        } else {
            JOptionPane.showMessageDialog(null, "No existen datos");
        }

    }//GEN-LAST:event_btnRefrescar_RegistroActionPerformed

    private void btmLimpiar_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmLimpiar_RegistroActionPerformed
        //Limpiar Filas//
        int filas = dtm.getRowCount();
        for (int i = 0; i < filas; i++) {

            dtm.removeRow(0);
            txtID_User_Update.setText(null);
            txtNomb_User_Update.setText(null);
            txtNombres_Update.setText(null);
            txtApellidos_Update.setText(null);
            txtPassword_Update.setText(null);
            txtTelefono_Update.setText(null);
            txtEmail_Update.setText(null);

        }

    }//GEN-LAST:event_btmLimpiar_RegistroActionPerformed

    private void btnEliminar_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_RegistroActionPerformed
        SQL_Metodos delete = new SQL_Metodos();
        DefaultTableModel dtm = new DefaultTableModel();
        PreparedStatement ps = null;

        try {
            Connection conn = delete.getConnection();
            int fila = tblCliente_Registro.getSelectedRow();
            String codigo = tblCliente_Registro.getValueAt(fila, 0).toString();

            ps = conn.prepareStatement("DELETE FROM informacion_usuarios WHERE ID_User = ?");
            ps.setString(1, codigo);
            ps.execute();

            dtm.removeRow(fila);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }


    }//GEN-LAST:event_btnEliminar_RegistroActionPerformed

    private void btnCerrar_SesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar_SesionActionPerformed
        this.dispose();
        Principal_Login pl = new Principal_Login();
        pl.setVisible(true);

    }//GEN-LAST:event_btnCerrar_SesionActionPerformed

    private void jtUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUserMouseClicked

    }//GEN-LAST:event_jtUserMouseClicked

    private void txtNomb_User_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomb_User_UpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomb_User_UpdateActionPerformed

    private void txtID_User_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtID_User_UpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtID_User_UpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmLimpiar_Registro;
    private javax.swing.JButton btnActualizar_Registro;
    private javax.swing.JButton btnAñadir_Tabla_Registro;
    private javax.swing.JButton btnCerrar_Sesion;
    private javax.swing.JButton btnEliminar_Registro;
    private javax.swing.JButton btnRefrescar_Registro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable tblCliente_Registro;
    public javax.swing.JTextField txtApellidos_Update;
    public javax.swing.JTextField txtEmail_Update;
    public javax.swing.JTextField txtID_User_Update;
    public javax.swing.JTextField txtNomb_User_Update;
    public javax.swing.JTextField txtNombres_Update;
    public javax.swing.JTextField txtPassword_Update;
    public javax.swing.JTextField txtTelefono_Update;
    // End of variables declaration//GEN-END:variables
}
