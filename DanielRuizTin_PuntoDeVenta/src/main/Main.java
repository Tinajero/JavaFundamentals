/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import Interfaces.GeneradorFactura;
import domain.Articulo;
import domain.Carrito;
import domain.Cliente;
import domain.Factura;
import domain.Ticket;
import domain.Tienda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import utils.ValidatorPDV;
/**
 *
 * @author Daniel M. Ruiz Tinajero
 */
public class Main {

   private final static String[] NOMBRE_PRODUCTOS = {"Aceite (1-2-3)",
                "Alimento para bebé Gerber Etapa 1",
                "Atún en Aceite Dolores o Nair (140 Grs)",
                "Azúcar",
                "Bolillo",
                "Café de Grano Internacional o Portales (908 Grs)",
                "Café Soluble Nescafé (95 Grs)",
                "Cajeta Coronado (550 Grs)",
                "Chiles jalapeños La Costeña (220 Grs)",
                "Arroz Verde Valle",
                "Frijol Negro (Granel)",
                "Garbanzo",
                "Haba (500Grs)",
                "Lenteja Verde Valle (500 Grs)"};
  
    private final static double[] PRECIO_PRODUCTOS = {
        22.24,
        9.41,
        13.63,
        24.83,
        1.5,
        152.96,
        42.93,
        65.95,
        9.33,
        26.75,
        33.56,
        36.7,
        37.6,
        30.02  };
    
    private  ArrayList<Articulo> listaArticulos;
    private  Carrito carrito;
    private  HashMap<Integer,Ticket> tickets;
    private  Tienda tienda;
    private  HashMap<String, Cliente> clientes;
    
    private double maximoPrecio;
    
    public static void main(String[] args) {                                      
       Main m = new Main(); 
       m.inicializar();
       m.start();
//        GeneradorFactura ff = f -> {};
//        
//      ff.generarFactura(f);
    }
    
    public void inicializar(){
        int numeroArticulos = NOMBRE_PRODUCTOS.length;
        listaArticulos = new ArrayList<>();
        carrito = new Carrito();
        tienda = new Tienda();
        tienda.setNombre("OXXO S.A de C.V");
        tienda.setDomicilio("Insurgentes Sur 3195, Tlalpan");
        tienda.setTelefono("01 55 5666 8548");
        tienda.setRegistroFederalontribuyentes("CCO8605231N4");
        tickets = new HashMap<>();
        clientes = new HashMap<>();
        maximoPrecio = 0.0;
         for(int i = 0; i < numeroArticulos; i++){
            double precio = PRECIO_PRODUCTOS[i];
            String descripcion = NOMBRE_PRODUCTOS[i];
            int codigo = (int) (Math.random() * 700 + 1);
            double descuento = Math.random()*20.0;
            maximoPrecio = maximoPrecio < precio ? precio: maximoPrecio;         
            listaArticulos.add(new Articulo(codigo,descripcion, precio, descuento));
        }
         
        
    }
    
    public  void start(){
        desplegarMenu();
        int lectura = leerOpcion();
        ejecutarAccion(lectura);
        
    }
    
    public  void desplegarMenu(){
        
        StringBuilder sb = new StringBuilder();
        sb.append("====================================").append("\n");
        sb.append("Bienvenido, seleccione una opción").append("\n");
        sb.append("1) Agregar artículo al carrito").append("\n");
        sb.append("2) Eliminar artículo del carrito").append("\n");
        sb.append("3) Imprimir Ticket y guardarlo").append("\n");
        sb.append("4) Consultar compra por número de ticket").append("\n");
        sb.append("5) Darse de alta como cliente").append("\n");
        sb.append("6) Realizar consulta de cliente por RFC").append("\n");
        sb.append("7) Imprimir factura en pantalla").append("\n");
        sb.append("0) Salir").append("\n");
        sb.append("11) Configuración").append("\n");
        sb.append("====================================").append("\n");
        
        System.out.println(sb.toString());
    }
    
    private  int leerOpcion() {
        String opcion;
        Scanner sc = new Scanner(System.in);
        opcion = sc.nextLine(); 
        
        if (opcion.isEmpty()){
            start();
        }                    
        boolean isNumeric = opcion.chars().allMatch( Character::isDigit );
        
        if (!isNumeric){
            System.out.println("Opción Incorrecta");
            return leerOpcion();
        } else {
            return Integer.parseInt(opcion);
        }

        

    }
    

    private  void ejecutarAccion(int opcion) {
        boolean salir = false;
        switch(opcion){
            case 0: salir = true;
                    break;
            case 1: agregarArticulo();
                    break;
            case 2: eliminarArticulo();
                    break;
            case 3: imprimirTicket(); break;
            case 4: buscarTicket(); break;
            case 5: darDeAltaCliente(); break;
            case 6: buscarClientePorRFC(); break;
            case 7: imprimirFactura(); break;
            case 11: Configuracion();
                    break;
            default:
                   System.out.println("Opción no valida");
                   break;
        }
        
        if (!salir){
            start();
        } else {
            System.exit(0);
        }
    }
    
    public  void agregarArticulo(){
        
        System.out.println("Artículos existentes");
        int longitudDescripcion = 30;
        int longitudPrecio = String.format("%.2f", maximoPrecio).length();        
        
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("CODIGO");
        sb.append("\t");
        sb.append(String.format("%-" + longitudDescripcion + "s", "DESCRIPCIÓN"));
        sb.append(" ");
        sb.append( String.format(" %"+4+"s","DESC." ));
        sb.append("   ");        
        sb.append(String.format(" %"+(longitudPrecio)+"s","PRECIO")); 
        sb.append("  ");   
        sb.append(String.format(" %"+(longitudPrecio)+"s","TOTAL")); 
        sb.append("\n");
        
        System.out.println(sb.toString());
        for(int i = 0; i < listaArticulos.size(); i++){
            System.out.println(i + ") " + listaArticulos.get(i).display(longitudDescripcion, longitudPrecio));
        }
        
        int seleccion = leerOpcion();
        
        if(seleccion >= 0 && seleccion <= listaArticulos.size()){
            carrito.agregarArticulo(listaArticulos.get(seleccion));
            System.out.println("Agregado");
        } else {
            System.out.println("Selección Invalida");
            start();
        }
            
        
               
        
    }
    
    public  void Configuracion(){
        System.out.println("1) Dar de alta artículos");
        System.out.println("2) cambiar Datos de la Tienda");
        System.out.println("3) Regresar");
        
        int config = leerOpcion();
        
        
        switch(config){
            case 1: darDeAltaArticulo();break;
            case 2: configurarTienda(); break;
            case 3: start();
                    break;
            default: 
                    System.out.println("Opción de Configuración Invalida");
                    Configuracion();
                    break;                
        }                
    }
    
    public  void imprimirTicket(){        
//        Scanner in = new Scanner(System.in);                
//        System.out.println("Total a pagar");
//        System.out.println("Introducir dinero recibido");
//        double dineroRecibido = in.nextDouble();                  
        Ticket ticket = new Ticket(tienda, carrito);
//        
//        if ( dineroRecibido <= ticket.getTotal()){
//            System.out.println("Dinero Insuficiente");
//            
//        } else if (dineroRecibido == ticket.getTotal()){
//            System.out.println("Pagado, Gracias por su compra");
//        } else if( dineroRecibido > ticket.getTotal()){
//            System.out.printf("Pagado, Gracias por su compra, su cambio $%.2f", dineroRecibido - ticket.getTotal() );
//        }                
        tickets.put(ticket.getNumeroTicket(), ticket);        
        ticket.setAnchoDelTicket(50);
                
        System.out.println(ticket.display());
        carrito = new Carrito();      
        start();
    }
    
    
    public  void eliminarArticulo(){
        
        System.out.println("Artículos en su carrito de compras");
        System.out.println(carrito.display(40));
        System.out.println("¿Que artículo desea eliminar?");
        int indiceEliminar = leerOpcion();
        if (indiceEliminar >= 0 && indiceEliminar < carrito.getNumeroArticulos()){
            carrito.eliminarArticulo(indiceEliminar);            
        } else {
            System.out.println("Opción incorrecta.");
        }
        
        start();
        
    }
    public  Ticket buscarTicket(){
        Ticket ticket;    
        System.out.println("Introducir número de ticket");
        int ticketNumero = leerOpcion();
        
        if (ticketNumero == 0){
            start();
        }
        
        if (tickets.containsKey(ticketNumero)){                        
            ticket = tickets.get(ticketNumero);
            System.out.println(ticket.display());
            return ticket;
        } else {
            System.out.println("No existe ese ticket");
            return buscarTicket();
        }                                
    }
    
    public  void darDeAltaCliente() {
        Scanner sc = new Scanner(System.in);
        String cadena;
        Cliente cliente = new Cliente();                           
        cadena = ValidatorPDV.leerSoloLetras("Nombre: ");        
        cliente.setNombre(cadena);        
        System.out.println("Domicilio:");
        cadena = sc.nextLine();                
        cliente.setDomicilio(cadena);
        System.out.println("RFC:");
        cadena = sc.nextLine();                
        cliente.setRegistroFederalContribuyentes(cadena);                
        clientes.put(cadena,cliente);                        
    }                
    
    public Cliente buscarClientePorRFC(){
        Cliente cliente;
        Scanner sc = new Scanner(System.in);       
        
        System.out.println("Introducir RFC del cliente a buscar: ");
        
        String cadena;
        cadena = sc.nextLine();
        if (cadena.isEmpty()){
            start();            
        }
        
        if (clientes.containsKey(cadena)){            
            cliente = clientes.get(cadena);
            System.out.println(cliente.display());
            return cliente;
        } else {
            System.out.println("No existe ese Cliente");
            return buscarClientePorRFC();
        }                        
    }
    
        
    public  void darDeAltaArticulo() {
        Scanner sc = new Scanner(System.in);
        int codigo;
        String descripcion;
        double precio, descuento;
        String cadena ;
     
        System.out.println("Código:");          
        codigo = leerOpcion();                     
        System.out.println("Descripción:");
        descripcion = sc.nextLine();                        
        precio = ValidatorPDV.leerSoloDouble("Precio:");           
        descuento = ValidatorPDV.leerSoloDouble("Descuento:");           
        listaArticulos.add(new Articulo(codigo, descripcion, precio, descuento));
        Configuracion();
    }           
    
     public void configurarTienda() {
        Scanner sc = new Scanner(System.in);        
        String nombre;
        String domicilio;
        String telefono;
        String registroFederalontribuyentes;
                              
        System.out.println("Nombre:");
        nombre = sc.nextLine();           
        tienda.setNombre(nombre);
        System.out.println("Domicilio:");
        domicilio = sc.nextLine();   
        tienda.setDomicilio(domicilio);
        System.out.println("Telefono:");
        telefono =  sc.nextLine();      
        tienda.setTelefono(telefono);
        System.out.println("Registro Federal de Contribuyentes:");
        registroFederalontribuyentes = sc.nextLine();   
        tienda.setRegistroFederalontribuyentes(registroFederalontribuyentes);               
        Configuracion();
    }           
     
     public void imprimirFactura(){         
        Ticket ticketFactura = buscarTicket();
        Cliente clienteFactura = buscarClientePorRFC();
//        Factura factura = new Factura(ticketFactura, clienteFactura, tienda);
        
        GeneradorFactura ff = (tf, cf, tienda) -> { System.out.println(new Factura(tf, cf, tienda).display()); };
        ff.generarFactura(ticketFactura, clienteFactura, tienda);
        
//        System.out.println(factura.display());
        
//        factura.generarFactura(ticketFactura, clienteFactura, tienda);
//         GeneradorFactura facturacion = (ticketFactura, clienteFactura, tienda) -> {};                           
     }
    
    
}
