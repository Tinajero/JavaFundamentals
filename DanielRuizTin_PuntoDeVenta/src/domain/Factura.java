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
public class Factura implements GeneradorFactura, Displayable{
    
    final static int anchoFactura = 70;
    
    Ticket ticket;
    Cliente cliente;
    Tienda tienda;
    
    public Factura(){
        
    }
    
    
    
    public Factura(Ticket ticket, Cliente cliente, Tienda tienda){
        setTicket(ticket);
        setCliente(cliente);
        setTienda(tienda);
    }
    
    @Override
    public void generarFactura(Ticket ticket, Cliente cliente, Tienda tienda){
        setTicket(ticket);
        setCliente(cliente);
        setTienda(tienda);
        this.display();
    }

    public String display(){
        
        StringBuilder sb = new StringBuilder();
        sb.append( String.format("%"+anchoFactura+"s", tienda.getRegistroFederalontribuyentes()));
        sb.append("\n");
        sb.append( String.format("%"+anchoFactura+"s", tienda.getNombre()));
        sb.append("\n");
        sb.append( String.format("%"+anchoFactura+"s", tienda.getDomicilio()));
        sb.append("\n");
        sb.append( String.format("%"+anchoFactura+"s", tienda.getTelefono()));
        sb.append("\n");sb.append("\n");sb.append("\n");
        sb.append(cliente.getRegistroFederalContribuyentes()).append("\n");
        sb.append(cliente.getNombre()).append("\n");
        sb.append(cliente.getDomicilio()).append("\n");
        
        sb.append(ticket.imprimirTabla(anchoFactura));
//        for (int i = 0; i < sb)
        
        return sb.toString(); 
    }
    
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
    
    
    
}
