/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 d open the template in the editor.
 */
package com.gestor.vistas;

import com.gestor.controlador.ControladorPrincipal;

/**
 *
 * @author Luis
 */
public class VentanaPrincipal extends javax.swing.JFrame {

//declaramos las ventanas que contiene la ventana padre
    public static VistaLogin login;

    //declaramos el controlador que manejara los eventos
    private ControladorPrincipal controlador = new ControladorPrincipal();

    public static VistaExpediente vistaExpediente;

    public VentanaPrincipal() {
        initComponents();

        //aca hardcodeamos la ventana hija login, la creamos y se la añadimos a la ventana padre del escritorio, luego la mostramos
        login = new VistaLogin();

        vistaExpediente = new VistaExpediente();

        //agregamos el controlador al login
        login.btnIngresar.addActionListener(controlador);
        vistaExpediente.btnGenerarExpediente.addActionListener(controlador);

        escritorio.add(login);
        escritorio.add(vistaExpediente);
        login.show();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GESTOR DE EXPEDIENTES");

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1015, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 762, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    // End of variables declaration//GEN-END:variables
}
