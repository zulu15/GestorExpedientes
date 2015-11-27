/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.controlador;

import com.empresa.util.UTabla;
import com.gestor.daos.ExpedienteDAO;
import com.gestor.daos.OperadorDAO;
import com.gestor.daos.PersonaDAO;
import com.gestor.impl.ExpedienteImpl;
import com.gestor.impl.OperadorImpl;
import com.gestor.impl.PersonaImpl;
import com.gestor.modelo.Expediente;
import com.gestor.modelo.Operador;
import com.gestor.modelo.Persona;
import com.gestor.util.Fecha;
import com.gestor.vistas.VistaLogin;
import com.gestor.vistas.VentanaPrincipal;
import com.gestor.vistas.VistaPersonas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class ControladorPrincipal implements ActionListener, MouseListener {

    public static final String BOTON_INGRESAR_LOGIN = "INGRESAR";
    public static final String BOTON_EXPEDIENTE = "GENERAR EXPEDIENTE";
    public static final String ACTUALIZAR_PERSONA = "Actualizar Departamento";
    public static final String ELIMINAR_PERSONA = "Eliminar Departamento";
    public static final String AGREGAR_PERSONA = "Nuevo Departamento";

    private PersonaDAO personaService = new PersonaImpl();
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

            case ACTUALIZAR_PERSONA:
                actualizarPersona();
                actualizarTabla();
                limpiar();
                break;
            case AGREGAR_PERSONA:
                agregarPersona();
                actualizarTabla();
                limpiar();
                break;
            case ELIMINAR_PERSONA:
                eliminarPersona();
                actualizarTabla();
                limpiar();
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

    @Override
    public void mouseClicked(MouseEvent me) {
        manejarClickTabla();
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    private void manejarClickTabla() {
        int row = VistaPersonas.tabla.getSelectedRow();
        VentanaPrincipal.ventanaPersonas.txtDNI.setText(String.valueOf(VistaPersonas.tabla.getValueAt(row, 0)));
        VentanaPrincipal.ventanaPersonas.txtNombre.setText((String) VistaPersonas.tabla.getValueAt(row, 1));
        VentanaPrincipal.ventanaPersonas.txtApellido.setText((String) VistaPersonas.tabla.getValueAt(row, 2));
        VentanaPrincipal.ventanaPersonas.txtDireccion.setText((String) VistaPersonas.tabla.getValueAt(row, 4));
        VentanaPrincipal.ventanaPersonas.txtTelefono.setText((String) VistaPersonas.tabla.getValueAt(row, 3));

        // Desactivo el campo del id del departamento ya que la clave unica no
        // deberia modificarse
        VentanaPrincipal.ventanaPersonas.txtDNI.setEditable(false);
    }

    private void eliminarPersona() {
        // Obtengo la fila seleccionada
        int row = VistaPersonas.tabla.getSelectedRow();
		// Obtengo el campo fila,0 es decir el primer campo que corresponde al
        // id

        if (row >= 0) {
            long idEliminar = (long) VistaPersonas.tabla.getValueAt(row, 0);

            try {

                personaService.eliminar(idEliminar);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            JOptionPane.showInternalMessageDialog(VistaPersonas.panelInputs, "Debe seleccionar un registro", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Actualiza la tabla obteniendo los registros desde la base de datos
     */
    private void actualizarTabla() {
        DefaultTableModel modelo = UTabla.buildTableModel("personas");
        VistaPersonas.tabla.setModel(modelo);
        modelo.fireTableDataChanged();

    }

    /**
     * Metodo que setea campos vacios limpiando los campos de texto
     */
    private void limpiar() {
        VentanaPrincipal.ventanaPersonas.txtTelefono.setText("");
        VentanaPrincipal.ventanaPersonas.txtNombre.setText("");
        VentanaPrincipal.ventanaPersonas.txtDNI.setText("");
           VentanaPrincipal.ventanaPersonas.txtDireccion.setText("");
              VentanaPrincipal.ventanaPersonas.txtApellido.setText("");
        // VentanaInicio.ventanaDepartamentos.labelCamposVacios.setText("");

    }

    private void agregarPersona() {

        try {

            JTextField txtDNI = new JTextField();
            JTextField txtNombre = new JTextField();
            JTextField txtApellido = new JTextField();
            JTextField txtTelefono = new JTextField();
            JTextField txtDireccion = new JTextField();

            Object[] campos = {"DNI", txtDNI, "Nombre", txtNombre, "Apellido", txtApellido, "Telefono:", txtTelefono, "Direccion", txtDireccion};
            int r = JOptionPane.showConfirmDialog(VistaPersonas.panelInputs, campos, "Agregar persona", JOptionPane.OK_CANCEL_OPTION, 1);
            
            if (r == JOptionPane.OK_OPTION) {
                Persona persona = new Persona(Long.parseLong(txtDNI.getText()), txtNombre.getText(), txtApellido.getText(), txtTelefono.getText(), txtDireccion.getText());
                personaService.insertar(persona);    
            }
        } catch (Exception e) {
            
            JOptionPane.showInternalMessageDialog(VentanaPrincipal.ventanaPersonas, "Ingrese los datos correctamente", "Datos incorrectos  ", JOptionPane.ERROR_MESSAGE);
        }

    }

/**
	 * Metodo que obtiene los datos de los campos de texto y los actualiza
	 */
	private void actualizarPersona() {
		// Obtengo los campos de texto
		Persona persona = obtenerPersonaInputs();
		// Verifico el contenido de los mismos
		
			try {
				personaService.actualizar(persona);
				VentanaPrincipal.ventanaPersonas.labelCamposVacios.setText("");
			} catch (Exception e) {

				throw new RuntimeException("Error actualizando registro " + e);
			}
		

	}

    private Persona obtenerPersonaInputs() {
        Persona persona = null;
        try {
            long dni = Long.parseLong(VentanaPrincipal.ventanaPersonas.txtDNI.getText());
            String nombre = VentanaPrincipal.ventanaPersonas.txtNombre.getText();
            String apellido = VentanaPrincipal.ventanaPersonas.txtApellido.getText();
            String telefono = VentanaPrincipal.ventanaPersonas.txtTelefono.getText();
            String direccion = VentanaPrincipal.ventanaPersonas.txtDireccion.getText();
            persona = new Persona(dni, nombre, apellido, telefono, direccion);
        } catch (Exception e) {
            System.out.println("Error obteniendo datos "+e);
            VentanaPrincipal.ventanaPersonas.labelCamposVacios.setText("Error ingrese los datos correspondientes "+e);
        }
        
        return persona;
            
    }

}
