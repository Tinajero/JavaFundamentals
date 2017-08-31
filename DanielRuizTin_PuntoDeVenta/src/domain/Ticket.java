/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Calendar;

/**
 *
 * @author Grupo Salinas 170828
 */
public class Ticket {
    private int numeroTicket;
    private Tienda tienda;
    private Carrito carritoDeCompras;
  
    private Calendar diaDeLaCompra;
    private int anchoDelTicket = 40;
    private int longitudDescripcion;
    private double impuesto;
    
    
    public Ticket(Tienda tienda, Carrito carrito){
        this.numeroTicket++;
        setTienda(tienda);
        setCarritoDeCompras(carrito);        
    }
    
    
    public void display(){
        StringBuilder sb = new StringBuilder();
        int longitudPrecio = String.format("%.2f", carritoDeCompras.getPrecioMaximo()).length();
        
        sb.append(centrar("TICKET", anchoDelTicket));
        sb.append("\n");
         sb.append(centrar("N° " + numeroTicket , anchoDelTicket));
        sb.append("\n");
        sb.append(centrar(tienda.getNombre(), anchoDelTicket));
        sb.append("\n");
        sb.append(centrar(tienda.getDomicilio(), anchoDelTicket));
        sb.append("\n");
        sb.append(centrar(tienda.getTelefono(), anchoDelTicket));
        sb.append("\n");
        sb.append(centrar(tienda.getRegistroFederalontribuyentes(), anchoDelTicket));
        sb.append("\n");
        
        for (int  i = 0; i < anchoDelTicket; i++){
            sb.append("-");
        }
        
        longitudDescripcion = anchoDelTicket - (longitudPrecio + 19);
        
        sb.append("\n");
        sb.append("CODIGO");
        sb.append("\t");
        sb.append(String.format("%-" + longitudDescripcion + "s", "DESCRIPCION"));
        sb.append(" ");
        sb.append( "DESC." );
        sb.append("  ");        
        sb.append("PRECIO UN");                
        sb.append("\n");
        
        for (int  i = 0; i < anchoDelTicket; i++){
            sb.append("-");
        }
        sb.append("\n");
        
        
        
        for (int i = 0; i < carritoDeCompras.getNumeroArticulos(); i++){
            sb.append(carritoDeCompras.getArticulos()[i].display(this.longitudDescripcion, longitudPrecio)).append("\n");
        }
        
        for (int  i = 0; i < anchoDelTicket; i++){
            sb.append("-");
        }
        sb.append("\n");        
        sb.append("IVA");
        int longitudIva = this.anchoDelTicket - "IVA".length(); 
        double iva = carritoDeCompras.getTotal() * this.getImpuesto();
        sb.append(String.format("%"+longitudIva+".2f", iva));
        sb.append("\n");
        sb.append("TOTAL");
        int longitudTotal = this.anchoDelTicket - "TOTAL".length();        
        sb.append(String.format("%"+ longitudTotal +".2f", carritoDeCompras.getTotal() + iva));
        sb.append("\n");
        
        System.out.println( sb.toString());
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Carrito getCarritoDeCompras() {
        return carritoDeCompras;
    }

    public void setCarritoDeCompras(Carrito carritoDeCompras) {
        this.carritoDeCompras = carritoDeCompras;
    }

    public Calendar getDiaDeLaCompra() {
        return diaDeLaCompra;
    }

    public void setDiaDeLaCompra(Calendar diaDeLaCompra) {
        this.diaDeLaCompra = diaDeLaCompra;
    }                
    
    public String centrar(String s, int anchura){      
        if (s == null){
            s = "   ";
        }
        
        int mitad = anchura /2;
        int mitadString = s.length()/2;
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for (int i = 0; i <= mitad; i++){
            
            if (mitad - i <= mitadString){                
                sb.append(s.charAt(c++));
            } else {
                sb.append(" ");
            }
        }
        
        sb.append(s.substring(c));
        
        for (int i = mitad + mitadString; i < anchura; i++){
                sb.append(" ");
        }                                
        return sb.toString();
    }

    public int getAnchoDelTicket() {
        return anchoDelTicket;
    }

    public void setAnchoDelTicket(int anchoDelTicket) {
        this.anchoDelTicket = anchoDelTicket;
    }

    public int getLongitudDescripcion() {
        return longitudDescripcion;
    }

    public void setLongitudDescripcion(int longitudDescripcion) {
        this.longitudDescripcion = longitudDescripcion;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }  
    
}
