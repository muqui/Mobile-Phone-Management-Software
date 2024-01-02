package com.navarro.tech.navarrotech.controller;

import com.navarro.tech.navarrotech.SQLite.Connect;
import com.navarro.tech.navarrotech.model.ModelTicket;
import com.navarro.tech.navarrotech.view.JdialogInfo;
import com.navarro.tech.navarrotech.view.TicketGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author muqui
 */
public class ControlerTicket implements ActionListener {

    TicketGUI ticketGUI;
    JdialogInfo jdialogInfo;
    ModelTicket modelTicket;

    public ControlerTicket(TicketGUI ticketGUI, JdialogInfo jdialogInfo, ModelTicket modelTicket) {
        System.out.println("corrio controlador GUI");
        this.ticketGUI = ticketGUI;
        this.jdialogInfo = jdialogInfo;
        this.modelTicket = modelTicket;
        this.jdialogInfo.getjButtonGuardar().addActionListener(this);
    }

    public void start() {

        System.out.println("Ticket: " + modelTicket.getNombre());
        ticketGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //ticketGUI.setUndecorated(true);
        ticketGUI.setVisible(true);
        //render jdialogInfo
        ticketGUI.getjPanelMain().removeAll();
        ticketGUI.getjPanelMain().setLayout(new java.awt.BorderLayout());
        ticketGUI.getjPanelMain().add(jdialogInfo);
        ticketGUI.getjPanelMain().validate();
        ticketGUI.getjPanelMain().repaint();
        ticketGUI.getjToolBarPrincipal().setFloatable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jdialogInfo.getjButtonGuardar()) {
            modelTicket.setNombre(jdialogInfo.getJtextNombre().getText());
            modelTicket.setDomicilio(jdialogInfo.getJtextDomicilio().getText());
            modelTicket.setTelefono(jdialogInfo.getJtextTelefono().getText());
            modelTicket.setMarca(jdialogInfo.getJtextMarca().getText());
            modelTicket.setModelo(jdialogInfo.getJtextModelo().getText());
            modelTicket.setOtrasFalla(jdialogInfo.getJtextOtraFalla().getText());
            modelTicket.setImeiSerie(jdialogInfo.getJtextIMEIserie().getText());
            Double presupuesto = Double.valueOf(jdialogInfo.getJtextPresupuesto().getText());
            modelTicket.setPresupueto(presupuesto);
            Double abono = Double.valueOf(jdialogInfo.getJtextAbono().getText());
            modelTicket.setAbono(abono);
            Double resto = Double.valueOf(jdialogInfo.getJtextResta().getText());
            modelTicket.setResto(resto);
            modelTicket.setEstadoRecibido(jdialogInfo.getjTextAreaEstadoTelefono().getText());
            if (jdialogInfo.getjCheckBoxDisplay().isSelected()) {
                modelTicket.getLista().add("Display");
            }
            if (jdialogInfo.getjCheckBoxCamara().isSelected()) {
                modelTicket.getLista().add("Camara");
            }
            if (jdialogInfo.getjCheckBoxMicrofono().isSelected()) {
                modelTicket.getLista().add("Microfono");
            }
            if (jdialogInfo.getjCheckBoxAuricular().isSelected()) {
                modelTicket.getLista().add("Auricular");
            }
            if (jdialogInfo.getjCheckBoxLiberacion().isSelected()) {
                modelTicket.getLista().add("Liberación");
            }
            if (jdialogInfo.getjCheckBoxPower().isSelected()) {
                modelTicket.getLista().add("Boton Power");
            }
            if (jdialogInfo.getjCheckBoxSim().isSelected()) {
                modelTicket.getLista().add("Bandeja SIM");
            }
            if (jdialogInfo.getjCheckBoxFrp().isSelected()) {
                modelTicket.getLista().add("FRP");
            }
            if (jdialogInfo.getjCheckBoxBateria().isSelected()) {
                modelTicket.getLista().add("Bateria");
            }
            if (jdialogInfo.getjCheckBoxVirus().isSelected()) {
                modelTicket.getLista().add("Virus");
            }
            if (jdialogInfo.getjCheckBoxMojado().isSelected()) {
                modelTicket.getLista().add("Telefono Mojado");
            }
            if (jdialogInfo.getjCheckBoxNoEnciende().isSelected()) {
                modelTicket.getLista().add("No enciende");
            }
            //Fecha de entrega
            // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaEntrega = jdialogInfo.getjDateChooserEntrega().getDate();
            //System.out.println("FECHA DE ENTREGA" +  sdf.format(fechaEntrega));
            modelTicket.setFechaEntrega(fechaEntrega);
            //fin fecha de entrega
            Connect connect = new Connect();
            connect.insert(modelTicket);

        }
    }
}
