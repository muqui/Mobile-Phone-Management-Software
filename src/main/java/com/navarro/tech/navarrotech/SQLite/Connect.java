package com.navarro.tech.navarrotech.SQLite;

import com.navarro.tech.navarrotech.model.ModelTicket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author muqui
 */
public class Connect {

    /**
     * Connect to a sample database //String url = "jdbc:sqlite:service.db";
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:service.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(ModelTicket modeloTicket) {
        System.out.println("Fallas arreglo: " + modeloTicket.getLista());
        String sql = "INSERT INTO ticket(fecha,nombre,domicilio,telefono,FechaEntrega,marca,modelo,otraFalla,presupuesto,abono,resto,condicion,imeiSerie) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //fecha de creacion del ticket
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        String fechaRecibido = sdf.format(timestamp);
        //Fin fecha creacion del ticket
        //Fecha entrega
        SimpleDateFormat fechaEntrega = new SimpleDateFormat("yyyy-MM-dd");
        Date date = modeloTicket.getFechaEntrega();
        String fechaEntregaString = fechaEntrega.format(date);

        //fin fecha entrega
        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fechaRecibido);
            pstmt.setString(2, modeloTicket.getNombre());
            pstmt.setString(3, modeloTicket.getDomicilio());
            pstmt.setString(4, modeloTicket.getTelefono());
            pstmt.setString(5, fechaEntregaString);
            pstmt.setString(6, modeloTicket.getMarca());
            pstmt.setString(7, modeloTicket.getModelo());
            pstmt.setString(8, modeloTicket.getOtrasFalla());
            pstmt.setDouble(9, modeloTicket.getPresupueto());
            pstmt.setDouble(10, modeloTicket.getAbono());
            pstmt.setDouble(11, modeloTicket.getResto());
            pstmt.setString(12, modeloTicket.getEstadoRecibido());
            pstmt.setString(13, modeloTicket.getImeiSerie());
            pstmt.executeUpdate();
            String last = getID();
            inserFail(last, modeloTicket.getLista());
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getID() {
        String last = "0";
        String sql = "SELECT MAX(Folio) AS LAST FROM ticket";
        Connection conn = this.connect();
        try {
            PreparedStatement pst1 = conn.prepareStatement(sql);
            ResultSet rs1 = pst1.executeQuery();
            last = rs1.getString("LAST");
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return last;
    }

    public void inserFail(String last, List<String> lista) {
        String sql = "INSERT INTO falla(idTicket,falla) VALUES(?,?)";

        Iterator<String> iter = lista.iterator();

        try {

            while (iter.hasNext()) {
                Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                // System.out.print(iter.next() + " ultimo insert=  " + last);
                pstmt.setString(1, last);
                pstmt.setString(2, iter.next());
                pstmt.executeUpdate();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public DefaultTableModel selectAll() {
        String sql = "SELECT folio,nombre, fecha, FechaEntrega FROM ticket";
        String[] columnNames = {"FOLIO","NOMBRE", "FECHA ENTRADA", "FECHA ENTREGA", "Editar"};
        DefaultTableModel tableModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        tableModel.setColumnIdentifiers(columnNames);
        JButton editar = new JButton("Editar");  //Editar  info  https://github.com/muqui/punto_venta_abarrotes/blob/master/src/modelo/VentasModelo.java
        editar.setName("editar");
        Object[] fila = new Object[tableModel.getColumnCount()];
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
//                System.out.println(rs.getInt("folio") + "\t"
//                        + rs.getString("fecha") + "\t"
//                        + rs.getString("FechaEntrega"));
                fila[0] = rs.getInt("folio");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getString("fecha");
                fila[3] = rs.getString("FechaEntrega");
                fila[4] = editar;
                tableModel.addRow(fila);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tableModel;
    }



}
