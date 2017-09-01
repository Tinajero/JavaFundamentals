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
public abstract class Persona implements Displayable {
    
    private int numero;
    private String nombre;
    private String domicilio;
    
    @Override
    public String display(){
       StringBuilder sb = new StringBuilder();
       sb.append("Nombre: ").append(nombre).append("\n");
       sb.append("Domicilio: ").append(domicilio).append("\n");
       return sb.toString();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    
}
