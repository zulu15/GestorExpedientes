/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.controlador;

import com.gestor.daos.ExpedienteDAO;
import com.gestor.daos.OperadorDAO;
import com.gestor.impl.ExpedienteImpl;
import com.gestor.impl.OperadorImpl;
import com.gestor.modelo.Expediente;
import com.gestor.modelo.Operador;
import com.gestor.util.Fecha;
import com.gestor.vistas.VistaLogin;
import com.gestor.vistas.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class ControladorPrincipal implements ActionListener {

    public static final String BOTON_INGRESAR_LOGIN = "INGRESAR";
    public static final String BOTON_EXPEDIENTE = "GENERAR EXPEDIENTE";

    private ExpedienteDAO expedienteService = new ExpedienteImpl();
    private OperadorDAO operadorService = new OperadorImpl();
    public static Operador operador;

    @Override
    public void actionPerformed(ActionEvent e) {

        String evento = e.getActionCommand();
        switch (evento) {

            case BOTON_INGRESAR_LOGIN:

                operador = obtenerOperadorLogin();

                if (isOperadorValido(operador)) {

                    operador = operadorService.buscarOperador(operador);
                    //  System.out.println("ES VALIDO MOSTRAR LA VENTANA DE EXPEDIENTES");
                    VentanaPrincipal.login.setVisible(false);
                    VentanaPrincipal.vistaExpediente.show();
                    

                } else {
                    VentanaPrincipal.vistaExpediente.setVisible(false);
                    VentanaPrincipal.vistaExpediente.dispose();
                    VistaLogin.lblErrorLogin.setText("ERROR USUARIO O CONTRASEÑA INCORRECTAS");

                }

                break;

            case BOTON_EXPEDIENTE: {
                try {
                    Expediente expediente = new Expediente();
                    expediente.setNumeroExpediente(0);
                    expediente.setIdPersona(obtenerCodigo(String.valueOf(VentanaPrincipal.vistaExpediente.comboPersona.getSelectedItem())));
                    expediente.setFechaDenuncia(Fecha.getCurrentDate());
                    expediente.setFechaHecho(Fecha.getCurrentDate(VentanaPrincipal.vistaExpediente.txtFechaDelito.getDate()));
                    expediente.setCodDelito(obtenerCodigo(String.valueOf(VentanaPrincipal.vistaExpediente.comboDelito.getSelectedItem())));
                    expediente.setDescripcion(VentanaPrincipal.vistaExpediente.txtDescripcionDenuncia.getText());
                    expediente.setIdEstado(5);
                    expediente.setCodOperador(operador.getCodOperador());
                    expedienteService.generarExpediente(expediente);
                    JOptionPane.showInternalMessageDialog(VentanaPrincipal.vistaExpediente, "Se agrego el expediente correctamente!", "Generacion de Expediente", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showInternalMessageDialog(VentanaPrincipal.vistaExpediente, "Error agregando el registro!", "Generacion de Expediente", JOptionPane.ERROR_MESSAGE);
                }
            }

            break;

        }

    }

    private Operador obtenerOperadorLogin() {

        return new Operador(0, VistaLogin.txtUsuario.getText(), VistaLogin.txtContrasenia.getText());

    }

    private boolean isOperadorValido(Operador operador) {
        Operador operadorEncontrado = operadorService.buscarOperador(operador);

        return (operadorEncontrado.getClave() != null && operadorEncontrado.getUsuario() != null);
    }

    private static long obtenerCodigo(String prueba) {

        String[] resultados = prueba.split("[()]");
        return Long.parseLong(resultados[1]);
    }

}
