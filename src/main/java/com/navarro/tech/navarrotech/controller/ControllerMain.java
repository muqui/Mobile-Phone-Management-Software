/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.navarro.tech.navarrotech.controller;

import com.navarro.tech.navarrotech.SQLite.Connect;
import com.navarro.tech.navarrotech.helpers.Render;
import com.navarro.tech.navarrotech.model.ModelTicket;
import com.navarro.tech.navarrotech.view.JPanelListServices;
import com.navarro.tech.navarrotech.view.JdialogInfo;
import com.navarro.tech.navarrotech.view.TicketGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author muqui
 */
public class ControllerMain implements ActionListener, MouseListener {

    TicketGUI ticketGUI;
    JPanelListServices jPanelListServices;
    JdialogInfo jdialogInfo;

    public ControllerMain(TicketGUI ticketGUI, JPanelListServices jPanelListServices, JdialogInfo jdialogInfo) {

        this.ticketGUI = ticketGUI;
        this.jPanelListServices = jPanelListServices;
        this.jdialogInfo = jdialogInfo;
        this.ticketGUI.getjButtonShowList().addActionListener(this);
        this.ticketGUI.getjButtonAlta().addActionListener(this);
        jPanelListServices.getjTableServicios().addMouseListener(this); 
    }

    private void showList() {
        //render jdialogInfo
        ticketGUI.getjPanelMain().removeAll();
        ticketGUI.getjPanelMain().setLayout(new java.awt.BorderLayout());
        ticketGUI.getjPanelMain().add(jPanelListServices);
        ticketGUI.getjPanelMain().validate();
        ticketGUI.getjPanelMain().repaint();
        ticketGUI.getjToolBarPrincipal().setFloatable(false);
        Connect connect = new Connect();
        connect.selectAll();
        jPanelListServices.getjTableServicios().setDefaultRenderer(Object.class, new Render());  //La clase Render ayuda a 
        jPanelListServices.getjTableServicios().setRowHeight(40);
        jPanelListServices.getjTableServicios().setModel(connect.selectAll());
    }

    private void showAdd() {
        //render jdialogInfo
        ticketGUI.getjPanelMain().removeAll();
        ticketGUI.getjPanelMain().setLayout(new java.awt.BorderLayout());
        ticketGUI.getjPanelMain().add(jdialogInfo);
        ticketGUI.getjPanelMain().validate();
        ticketGUI.getjPanelMain().repaint();
        ticketGUI.getjToolBarPrincipal().setFloatable(false);
    }

    private void show() {
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
        if (e.getSource() == this.ticketGUI.getjButtonShowList()) {
            showList();
        }
        if (e.getSource() == this.ticketGUI.getjButtonAlta()) {
            showAdd();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int column = jPanelListServices.getjTableServicios().getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY() / jPanelListServices.getjTableServicios().getRowHeight();
        if (row < jPanelListServices.getjTableServicios().getRowCount() && row >= 0 && column < jPanelListServices.getjTableServicios().getColumnCount() && column >= 0) {
            Object value = jPanelListServices.getjTableServicios().getValueAt(row, column);
            
            System.out.println("    MOUSECLICK EN LA TABLA" + jPanelListServices.getjTableServicios().getModel().getValueAt(row, 0));
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                if (boton.getName().equals("editar")) {
                  // String folio = (String)
                   // System.out.println("    BOTON EDITAR ORDER DE SERVICIO "  + folio);
                    JOptionPane.showMessageDialog(null, "Hello World" +jPanelListServices.getjTableServicios().getModel().getValueAt(row, 0));
                }

            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
