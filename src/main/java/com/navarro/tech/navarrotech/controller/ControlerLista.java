/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.navarro.tech.navarrotech.controller;

import com.navarro.tech.navarrotech.model.ModelTicket;
import com.navarro.tech.navarrotech.view.JPanelListServices;
import com.navarro.tech.navarrotech.view.TicketGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author muqui
 */
public class ControlerLista implements ActionListener {

    TicketGUI ticketGUI;
    JPanelListServices jPanelListServices;
    ModelTicket modelTicket;

    public ControlerLista(TicketGUI ticketGUI, JPanelListServices jPanelListServices, ModelTicket modelTicket) {

        this.ticketGUI = ticketGUI;
        this.jPanelListServices = jPanelListServices;
        this.modelTicket = modelTicket;
      
    }

 

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

}
