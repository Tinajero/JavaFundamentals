/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import domain.Cliente;
import domain.Ticket;
import domain.Tienda;

/**
 *
 * @author Grupo Salinas 170828
 */
public interface GeneradorFactura {
    
    public void generarFactura(Ticket ticket, Cliente cliente, Tienda tienda);
}
