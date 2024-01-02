/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.navarro.tech.navarrotech.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author muqui
 */
public class ModelTicket {
    
    private int folio;
    private Date fechaRecibido;
    private Date fechaEntrega;
    private String nombre;
    private String domicilio;
    private String telefono;

    public ModelTicket(int folio, Date fechaRecibido, Date fechaEntrega, String nombre, String domicilio, String telefono, String marca, String modelo, String otrasFalla, double presupueto, double abono, double resto, String estadoRecibido, String ImeiSerie) {
        this.folio = folio;
        this.fechaRecibido = fechaRecibido;
        this.fechaEntrega = fechaEntrega;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.marca = marca;
        this.modelo = modelo;
        this.otrasFalla = otrasFalla;
        this.presupueto = presupueto;
        this.abono = abono;
        this.resto = resto;
        this.estadoRecibido = estadoRecibido;
        this.ImeiSerie = ImeiSerie;
    }
    private String marca;
    private String modelo;
    private List<String> lista = new ArrayList<>();
    private String otrasFalla;
    private double presupueto;
    private double abono;
    private double resto;
    private String estadoRecibido;
    private String ImeiSerie;

    
    
    
     public ModelTicket() {
  
    }

  
    
    

    /**
     * @return the folio
     */
    public int getFolio() {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * @return the fechaRecibido
     */
    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    /**
     * @param fechaRecibido the fechaRecibido to set
     */
    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    /**
     * @return the fechaEntrega
     */
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * @param fechaEntrega the fechaEntrega to set
     */
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the lista
     */
    public List<String> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<String> lista) {
        this.lista = lista;
    }

    /**
     * @return the presupueto
     */
    public double getPresupueto() {
        return presupueto;
    }

    /**
     * @param presupueto the presupueto to set
     */
    public void setPresupueto(double presupueto) {
        this.presupueto = presupueto;
    }

    /**
     * @return the abono
     */
    public double getAbono() {
        return abono;
    }

    /**
     * @param abono the abono to set
     */
    public void setAbono(double abono) {
        this.abono = abono;
    }

    /**
     * @return the resto
     */
    public double getResto() {
        return resto;
    }

    /**
     * @param resto the resto to set
     */
    public void setResto(double resto) {
        this.resto = resto;
    }

    /**
     * @return the estadoRecibido
     */
    public String getEstadoRecibido() {
        return estadoRecibido;
    }

    /**
     * @param estadoRecibido the estadoRecibido to set
     */
    public void setEstadoRecibido(String estadoRecibido) {
        this.estadoRecibido = estadoRecibido;
    }

    /**
     * @return the otrasFalla
     */
    public String getOtrasFalla() {
        return otrasFalla;
    }

    /**
     * @param otrasFalla the otrasFalla to set
     */
    public void setOtrasFalla(String otrasFalla) {
        this.otrasFalla = otrasFalla;
    }

    /**
     * @return the ImeiSerie
     */
    public String getImeiSerie() {
        return ImeiSerie;
    }

    /**
     * @param ImeiSerie the ImeiSerie to set
     */
    public void setImeiSerie(String ImeiSerie) {
        this.ImeiSerie = ImeiSerie;
    }
   
    
}
