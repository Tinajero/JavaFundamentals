/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domain.Articulo;
import domain.Carrito;
import domain.Ticket;
import domain.Cliente;
import domain.Tienda;
/**
 *
 * @author Daniel M. Ruiz Tinajero
 */
public class Main {
    
    public static void main(String[] args) {
        Articulo uno = new Articulo();
//        System.out.println(uno.display(20,8));

        Articulo dos = new Articulo(1, "SALSA PICANTE VALENTINA 250 GRS", 17888.99, 10);
//        System.out.println(dos.display(20,8));
        
        
        Articulo[] articulos = new Articulo[]{uno, dos};
        uno.setDescripcion("Nueva descripcion");
        Carrito carro;
        
        carro = new Carrito(articulos);
        
        
//860	Nueva descripcion   	$    1.00	0.00%;        
//        for (int i = 0; i < articulos.length; i++){
//            System.out.println(articulos[i].display());
//        }
        
//        System.out.println("Total: " + carro.getTotal() );

//        for (int i = 0; i < carro.getNumeroArticulos(); i++){
//            System.out.println(carro.getArticulos()[i].display());
//        }
        
//        carro.eliminarArticulo(0);
//        System.out.println("Eliminado total ");        
//        System.out.println("Total: " + carro.getTotal() );
//        for (int i = 0; i < carro.getNumeroArticulos(); i++){
//            System.out.println(carro.getArticulos()[i].display());
//        }
        
        Tienda tienda = new Tienda();
        Cliente cliente = new Cliente();
        
        tienda.setNombre("VIPS");
        tienda.setDomicilio("calle numer 2 Colonia Tal");
        tienda.setTelefono("55-55-555-555");
        tienda.setRegistroFederalontribuyentes("ABCD9023401Q2");
        
        
        Ticket ticket = new Ticket(tienda,carro, cliente);
        ticket.setAnchoDelTicket(70);
        ticket.setLongitudDescripcion(20);
        
        System.out.println("\t".length());
        
        ticket.display();                                    
    }
    
}
