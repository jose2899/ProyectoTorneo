/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorEntidades;

import Controlador.UsuarioJpaController;
import modelos.Usuario;
import javax.swing.JOptionPane;
import static vista.ModificarDatos.jCAnio;
import static vista.ModificarDatos.jCDia;
import static vista.ModificarDatos.jCMes;
import static vista.ModificarDatos.jTextApelli;
import static vista.ModificarDatos.jTextCorr;
import static vista.ModificarDatos.jTextNom;
import static vista.ModificarDatos.jTextTele;
import vista.PerfilU;
import static vista.PerfilU.TextApellido;
import static vista.PerfilU.TextCedula;
import static vista.PerfilU.TextCorreo;
import static vista.PerfilU.TextNombre;
import static vista.PerfilU.TextTelefono;
import static vista.RegistrarUsuario.jComboAnio;
import static vista.RegistrarUsuario.jComboDia;
import static vista.RegistrarUsuario.jComboMes;
import static vista.RegistrarUsuario.jTextApellidos;
import static vista.RegistrarUsuario.jTextCedula;
import static vista.RegistrarUsuario.jTextCorreo;
import static vista.RegistrarUsuario.jTextDireccion;
import static vista.RegistrarUsuario.jTextNombre;
import static vista.RegistrarUsuario.jTextTelefono;


/**
 *
 * @author Andres R
 */
public class RegistarU {
    UsuarioJpaController CUsuar = new UsuarioJpaController();
    Usuario us = new Usuario();
    Usuario edi ;
    PerfilU perfil = new PerfilU();
    public void registrarUsu() {

        if (jComboDia.getSelectedItem().toString() == "Dia" || jComboMes.getSelectedItem().toString() == "Mes"
                || jComboAnio.getSelectedItem().toString() == "Año") {
            JOptionPane.showMessageDialog(null, "Seleccione la fecha de nacimiento correcta");
            
        } else {
            try {
                us.setApellidos(jTextApellidos.getText());
                us.setCedula(jTextCedula.getText());
                us.setCorreo(jTextCorreo.getText());
                us.setDireccion(jTextDireccion.getText());
                us.setNombres(jTextNombre.getText());
                us.setTelefono(jTextTelefono.getText());
                if (jTextApellidos.getText().isEmpty() || jTextCedula.getText().isEmpty() || jTextCorreo.getText().isEmpty()
                        || jTextDireccion.getText().isEmpty() || jTextNombre.getText().isEmpty() || jTextTelefono.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
                } else {
                    TextNombre.setText(jTextNombre.getText());
                    TextApellido.setText(jTextApellidos.getText());
                    TextCedula.setText(jTextCedula.getText());
                    TextCorreo.setText(jTextCorreo.getText());
                    TextTelefono.setText(jTextTelefono.getText());
                    CUsuar.create(us);
                    JOptionPane.showMessageDialog(null, "Se ha registro con exito");
                    perfil.setVisible(true);
                    

                }

            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "No se realizo el registro con exito");
            }

        }

    }

    public void modiUsu() {
        if (jCDia.getSelectedItem().toString() == "Dia" || jCMes.getSelectedItem().toString() == "Mes"
                || jCAnio.getSelectedItem().toString() == "Año") {
            JOptionPane.showMessageDialog(null, "Seleccione la fecha de nacimiento correcta");
        } else {
            try {
                edi = CUsuar.findUsuarios(Integer.toUnsignedLong(1));
                edi.setNombres(jTextNom.getText());
                edi.setApellidos(jTextApelli.getText());
                edi.setCorreo(jTextCorr.getText());
                edi.setTelefono(jTextTele.getText());
                edi.setCedula(jTextCedula.getText());
                edi.setDireccion(jTextDireccion.getText());

                if (jTextNom.getText().isEmpty() || jTextApelli.getText().isEmpty() || jTextCorr.getText().isEmpty()
                        || jTextTele.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese todos los campos");

                } else {
                    TextNombre.setText(jTextNom.getText());
                    TextApellido.setText(jTextApelli.getText());
                    TextCorreo.setText(jTextCorr.getText());
                    TextTelefono.setText(jTextTele.getText());
                    TextCedula.setText(jTextCedula.getText());
                    CUsuar.edit(edi);
                    JOptionPane.showMessageDialog(null, "Se ha guardado con exito");
                    
                   
                    perfil.setVisible(true);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se realizo el guardado");
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

}
