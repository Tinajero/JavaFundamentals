/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Grupo Salinas 170828
 */
public class Tienda {
    
    private int numero;
    private String nombre;
    private String domicilio;
    private String telefono;
    private String registroFederalontribuyentes;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRegistroFederalontribuyentes() {
        return registroFederalontribuyentes;
    }

    public void setRegistroFederalontribuyentes(String registroFederalontribuyentes) {
        this.registroFederalontribuyentes = registroFederalontribuyentes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
