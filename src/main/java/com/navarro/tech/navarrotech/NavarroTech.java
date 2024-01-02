/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.navarro.tech.navarrotech;

import com.navarro.tech.navarrotech.controller.ControlerLista;
import com.navarro.tech.navarrotech.controller.ControlerTicket;
import com.navarro.tech.navarrotech.controller.ControllerMain;
import com.navarro.tech.navarrotech.model.ModelTicket;
import com.navarro.tech.navarrotech.print.MiPrintable80;
import com.navarro.tech.navarrotech.view.JPanelListServices;
import com.navarro.tech.navarrotech.view.JdialogInfo;
import com.navarro.tech.navarrotech.view.TicketGUI;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Date;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;

/**
 *
 * @author muqui
 */
public class NavarroTech {

    public static void main(String[] args) {

        //modelo
        ModelTicket modelTicket = new ModelTicket();
        //vista
        TicketGUI ticketGUI = new TicketGUI();
        JdialogInfo jdialogInfo = new JdialogInfo();
        JPanelListServices jPanelListServices = new JPanelListServices();
        //controlador
        ControlerTicket controlerTicket = new ControlerTicket(ticketGUI, jdialogInfo, modelTicket);
        ControlerLista controlerLista = new ControlerLista(ticketGUI, jPanelListServices, modelTicket);
        ControllerMain controllerMain = new ControllerMain(ticketGUI, jPanelListServices, jdialogInfo);

        controlerTicket.start();
//        //PRUEBA IMPRESION
//        HashPrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
//       
//        attr.add(new MediaPrintableArea(0f, 0f, 1 / 72f, 1 / 72f, MediaPrintableArea.INCH));
//
//        PrinterJob job = PrinterJob.getPrinterJob();
//
//        //ModelTicket modelTicket1 = new ModelTicket(0, new Date(), new Date(), "Alberto Corona", "Juarez 80", "3336559921", "Xiaomi", "Redmi 9", 600, 300, 300, "en buen estado");
//        ModelTicket modelTicket1 = new ModelTicket();
//        modelTicket1.setFechaRecibido(new Date());
//        modelTicket1.setFechaEntrega(new Date());
//        modelTicket1.setNombre("Alberto Corona");
//        modelTicket1.setDomicilio("juarez 80");
//        modelTicket1.setTelefono("368855241");
//        modelTicket1.setMarca("xiaomi");
//        modelTicket1.setModelo("Redmi 9");
//        modelTicket1.setPresupueto(600);
//        modelTicket1.setAbono(300);
//        modelTicket1.setResto(300);
//        modelTicket1.setFolio(500);
//        modelTicket1.setEstadoRecibido("buen estado");
//        modelTicket.setOtrasFalla("Se reinicia");
//        modelTicket1.getLista().add("Display");
//        // modelTicket1.getLista().add("Bocina");
//        // modelTicket1.getLista().add("FRP");
//        // modelTicket1.getLista().add("No enciende");
//        modelTicket1.setOtrasFalla("Telefono se reinicia");
//
//        MiPrintable80 miPrintable80 = new MiPrintable80(modelTicket1);
//
//        job.setPrintable(miPrintable80);
//
//        try {
//            if (job.printDialog()) {
//                job.print();
//            }
//        } catch (PrinterException e) {
//            e.printStackTrace();
//        }
//        //FIN PRUEBA IMPRESION
    }
}
