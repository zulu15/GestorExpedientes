package com.gestor.vistas;

import com.empresa.util.UTabla;
import com.gestor.controlador.ControladorPrincipal;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

//import com.empresa.util.UTabla;
public class VistaPersonas extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JScrollPane scrollista;
    public static javax.swing.JTable tabla;
    public static JPanel panelInputs;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelDNI;
    private javax.swing.JLabel labelDireccion;
    public javax.swing.JLabel labelCamposVacios;
    public JTextField txtNombre;
    public JTextField txtTelefono;
    public JLabel labelApellido;
    public JTextField txtApellido;
    public JTextField txtDireccion;
    public JTextField txtDNI;
    private JPanel panelBotones;
    public static JButton btnActualizar;
    public static JButton btnAgregar;
    public static JButton btnEliminar;
    private ControladorPrincipal controlador;

    public VistaPersonas() {

        initComponents();
        agregarControlador();
    }

    private void agregarControlador() {
        controlador = new ControladorPrincipal();
        btnActualizar.addActionListener(controlador);
        btnEliminar.addActionListener(controlador);
        btnAgregar.addActionListener(controlador);
        tabla.addMouseListener(controlador);
    }

    private void initComponents() {

        panelCentral = new javax.swing.JPanel();
        scrollista = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelInputs = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelCamposVacios = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelDNI = new JLabel();

        txtDireccion = new JTextField("Direccion...");
        txtDNI = new JTextField("Dni...");
        txtDNI.setEditable(false);
        txtApellido = new JTextField("Apellido...");
        txtNombre = new javax.swing.JTextField("Nombre...");
        txtTelefono = new javax.swing.JTextField("Telefono...");
        panelBotones = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        // Atributos de redimension del InternalFrame
        setClosable(true);
        setIconifiable(true);
        setMaximizable(false);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        scrollista.setToolTipText("");

        tabla.setModel(UTabla.buildTableModel("personas"));
        scrollista.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
        }

        panelInputs.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Departamentos")));

        labelApellido.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N
        labelApellido.setText("Apellido ");

        labelDireccion.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N
        labelDireccion.setText("Direccion ");

        labelNombre.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N
        labelNombre.setText("Nombre ");

        labelTelefono.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N
        labelTelefono.setText("Telefono");

        labelDNI.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N
        labelDNI.setText("Dni ");

        javax.swing.GroupLayout panelInputsLayout = new javax.swing.GroupLayout(panelInputs);
        panelInputs.setLayout(panelInputsLayout);
        panelInputsLayout.setHorizontalGroup(panelInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelInputsLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelInputsLayout.createSequentialGroup()
                                        .addComponent(labelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDNI))
                                .addGroup(panelInputsLayout.createSequentialGroup()
                                        .addGroup(panelInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(labelApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtApellido)
                                                .addComponent(txtTelefono)
                                                .addComponent(txtDireccion)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInputsLayout.setVerticalGroup(panelInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelInputsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(panelInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        //TEST
                        .addGroup(panelInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        //TEST
                        //TEST
                        .addGroup(panelInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        //TEST

                        .addGroup(panelInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))
        );

        panelBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(1, 15, 12)));

        btnActualizar.setForeground(new java.awt.Color(94, 102, 214));
        btnActualizar.setText("Actualizar Departamento");
        panelBotones.add(btnActualizar);

        btnAgregar.setForeground(new java.awt.Color(117, 220, 103));
        btnAgregar.setText("Nuevo Departamento");
        panelBotones.add(btnAgregar);

        btnEliminar.setForeground(new java.awt.Color(223, 77, 77));
        btnEliminar.setText("Eliminar Departamento");
        panelBotones.add(btnEliminar);

        labelCamposVacios.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        labelCamposVacios.setForeground(new java.awt.Color(218, 62, 62));
        labelCamposVacios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
                panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addGroup(panelCentralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelInputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
                        .addContainerGap())
                .addGroup(panelCentralLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(labelCamposVacios, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCentralLayout.setVerticalGroup(
                panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCentralLayout.createSequentialGroup()
                        .addComponent(scrollista, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addComponent(labelCamposVacios)
                        .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
    }

}
