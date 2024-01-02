/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.navarro.tech.navarrotech.print;

import com.navarro.tech.navarrotech.model.ModelTicket;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.util.Iterator;

/**
 *
 * @author muqui
 */
public class MiPrintable80 implements Printable {

    ModelTicket modelTicket;
    Font myFont = new Font("Courier New", Font.BOLD, 11);

    public MiPrintable80(ModelTicket modelTicket) {
        this.modelTicket = modelTicket;
    }

    @Override
    public int print(Graphics g, PageFormat f, int pageIndex) {
        if (pageIndex == 0) {

            g.setFont(myFont);
            //Nota
            g.drawString("Nota No:", 10, 10);
            g.drawString("" + modelTicket.getFolio(), 65, 10);
            //Fecha
            g.drawString("Fecha:", 10, 25);
            g.drawString("" + modelTicket.getFechaRecibido(), 55, 25);
            //Nombre
            g.drawString("Nombre:", 10, 40);
            g.drawString(modelTicket.getNombre(), 60, 40);
            //Direccion
            g.drawString("Domicilio:", 10, 55);
            g.drawString(modelTicket.getDomicilio(), 75, 55);
            //Telefono
            g.drawString("Telefono:", 10, 70);
            g.drawString(modelTicket.getTelefono(), 75, 70);
            //Marca
            g.drawString("Marca:", 10, 85);
            g.drawString(modelTicket.getMarca(), 75, 85);
            //Modelo
            g.drawString("Modelo:", 10, 100);
            g.drawString(modelTicket.getModelo(), 75, 100);
            //Falla
            g.drawString("FALLA:", 10, 115);
            int fila = 130;
            Iterator<String> iter = modelTicket.getLista().iterator();
            while (iter.hasNext()) {
                g.drawString(iter.next(), 10, fila);
                //  System.out.print(   " fila " + fila );
                //  System.out.println("");
                fila = fila + 15;
            }
            //otra falla
            System.out.println(" otra falla:  " + modelTicket.getOtrasFalla());
            g.drawString(modelTicket.getOtrasFalla(), 10, fila);
            //Costo
            g.drawString("COSTO REPARACION", 10, fila + 15);
            g.drawString("Costo:", 10, fila + 30);
            g.drawString("" + modelTicket.getPresupueto(), 75, fila + 30);
            //Abono
            g.drawString("Abono:", 10, fila + 45);
            g.drawString("" + modelTicket.getAbono(), 75, fila+45);
            //Saldo
             g.drawString("Saldo:", 10, fila + 60);
            g.drawString("" + modelTicket.getResto(), 75, fila+60);
            //Estado
             g.drawString("Estado del telefono:", 10, fila + 75);
            g.drawString("" + modelTicket.getEstadoRecibido(), 10, fila+90);
            
          //  Fecha de entrega
             g.drawString("Fecha entrega:", 10, fila + 105);
            g.drawString("" + modelTicket.getFechaEntrega(), 95, fila+105);
           // datos adicionales
            String mensajeUno = "En caso de que el cliente no aceptara la reparacion del equipo por el cual causara un reclamo de garantia no fuera procedente, el cliente se compormente al pago de revision de $80 pesos.";
            String mensajeDos="Para recoger el equipo es necesario liquidar el costo de reparacion asi como la presentacion de este documento.";
            String mensajeTres = "Todo equipo no reclamado a los 30 dias de reparado cauara abandono y no nos hacemos responsables por el equipo.";
            
            g.drawString("Nota: " + mensajeUno , 5, fila+120);
            
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }
}
