/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import domain.Articulo;
import domain.Carrito;
import domain.Cliente;
import domain.Ticket;
import domain.Tienda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author Daniel M. Ruiz Tinajero
 */
public class Main {

   private static String[] nombreProductos = {"Aceite (1-2-3)",
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
  
    private static double[] precioProductos = {
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
    
    private  int opcionMenu;
    private  ArrayList<Articulo> listaArticulos;
    private  Carrito carrito;
    private  HashMap<Integer,Ticket> tickets;
    private  Tienda tienda;
    private  HashMap<String, Cliente> clientes;
    
    public static void main(String[] args) {                                      
       Main m = new Main(); 
       m.inicializar();
       m.start();
    }
    
    public void inicializar(){
         int numeroArticulos = nombreProductos.length;
       listaArticulos = new ArrayList<>();
        carrito = new Carrito();
        tienda = new Tienda();
        tienda.setNombre("Tienda");
        tienda.setDomicilio("Domicilio");
        tienda.setTelefono("Telefono");
        tickets = new HashMap< Integer, Ticket>();
        clientes = new HashMap<>();
         for(int i = 0; i < numeroArticulos; i++){
            double precio = precioProductos[i];
            String descripcion = nombreProductos[i];
            int codigo = (int) (Math.random() * 700 + 1);
            double descuento = Math.random()*20.0;
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
        sb.append("Bienvenido, seleccione una opcion").append("\n");
        sb.append("1) Agregar articulo al carrito").append("\n");
        sb.append("2) Eliminar articulo del carrito").append("\n");
        sb.append("3) Realizar Pago").append("\n");
        sb.append("4) consultar compra por numero de ticket").append("\n");
        sb.append("5) Darse de alta como cliente").append("\n");
        sb.append("6) Realizar consulta de cliente por RFC").append("\n");
        sb.append("7) Imprimir factura en pantalla").append("\n");
        sb.append("0) Salir").append("\n");
        sb.append("11) Configuracion").append("\n");
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
            System.out.println("Opcion Incorreta");
            return leerOpcion();
        } else {
            return Integer.parseInt(opcion);
        }

        

    }
    

    private  void ejecutarAccion(int opcion) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            case 11: Configuracion();
                    break;
            default:
                   System.out.println("Opcion no valida");
                   break;
        }
        
        if (!salir){
            start();
        } else {
            System.exit(0);
        }
    }
    
    public  void agregarArticulo(){
        
        System.out.println("Articulos existentes");
        
        for(int i = 0; i < listaArticulos.size(); i++){
            System.out.println(i + ") " + listaArticulos.get(i).display(30, 4));
        }
        
        int seleccion = leerOpcion();
        
        if(seleccion >= 0 && seleccion <= listaArticulos.size()){
            carrito.agregarArticulo(listaArticulos.get(seleccion));
            System.out.println("Agregado");
        } else {
            System.out.println("Seleccion Invalida");
            start();
        }
            
        
               
        
    }
    
    public  void Configuracion(){
        System.out.println("1) Dar de alta articulos");
        System.out.println("2) cambiar Datos de la Tienda");
        System.out.println("3) Regresar");
        
        int config = leerOpcion();
        
        
        switch(config){
            case 1: darDeAltaArticulo();break;
            case 2: configurarTienda(); break;
            case 3: start();
                    break;
            default: 
                    System.out.println("Opcion de Configuracion Invalida");
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
        ticket.display();       
        carrito = new Carrito();
        ticket = new Ticket(tienda, carrito);
        start();
    }
    
    
    public  void eliminarArticulo(){
        
        System.out.println("Articulos en su carrito de compras");
        System.out.println(carrito.display(40));
        System.out.println("¿Que articulo desea eliminar?");
        int indiceEliminar = leerOpcion();
        if (indiceEliminar >= 0 && indiceEliminar < carrito.getNumeroArticulos()){
            carrito.eliminarArticulo(indiceEliminar);            
        } else {
            System.out.println("Opcion incorrecta.");
        }
        
        start();
        
    }
    public  void buscarTicket(){
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Introducir numero de ticket");
        int ticketNumero = leerOpcion();
        
        if (ticketNumero == 0){
            start();
        }
        
        if (tickets.containsKey(ticketNumero)){            
            tickets.get(ticketNumero).display();            
        } else {
            System.out.println("No existe ese ticket");
            buscarTicket();
        }
        
        
        
    }
    
    public  void darDeAltaCliente() {
        Scanner sc = new Scanner(System.in);
        String cadena = "";
        Cliente cliente = new Cliente();
        
        System.out.println("Nombre:");          
        cadena = sc.nextLine();                
        cliente.setNombre(cadena);
        System.out.println("Domicilio:");
        cadena = sc.nextLine();                
        cliente.setDomicilio(cadena);
        System.out.println("RFC:");
        cadena = sc.nextLine();                
        cliente.setRegistroFederalContribuyentes(cadena);                
        clientes.put(cadena,cliente);                        
    }                
    
    public void buscarClientePorRFC(){
        
        Scanner sc = new Scanner(System.in);
        String cadena = "";
        
        System.out.println("Introducir RFC del cliente a buscar: ");
        
        cadena = sc.nextLine();
        if (cadena.isEmpty()){
            buscarClientePorRFC();     
            return;
        }
        
        if (clientes.containsKey(cadena)){            
            clientes.get(cadena).display();         
        } else {
            System.out.println("No existe ese Cliente");
            buscarClientePorRFC();
        }
        
        start();
        
    }
    
        
    public  void darDeAltaArticulo() {
        Scanner sc = new Scanner(System.in);
        int codigo;
        String descripcion;
        double precio, descuento;
        String cadena = "";
        Cliente cliente = new Cliente();
        
        System.out.println("Codigo:");          
        codigo = sc.nextInt();      
        cadena = sc.nextLine();       
        System.out.println("Descripcion:");
        descripcion = sc.nextLine();                        
        System.out.println("Precio:");
        precio = sc.nextDouble();                
        System.out.println("descuento:");
        descuento = sc.nextDouble();                                        
        listaArticulos.add(new Articulo(codigo, descripcion, precio, descuento));
        Configuracion();
    }           
    
     public void configurarTienda() {
        Scanner sc = new Scanner(System.in);        
        String nombre;
        String domicilio;
        String telefono;
        String registroFederalontribuyentes;
                              
        System.out.println("nombre:");
        nombre = sc.nextLine();           
        tienda.setNombre(nombre);
        System.out.println("domicilio:");
        domicilio = sc.nextLine();   
        tienda.setDomicilio(domicilio);
        System.out.println("telefono:");
        telefono =  sc.nextLine();      
        tienda.setTelefono(telefono);
        System.out.println("registro Federal Contribuyentes:");
        registroFederalontribuyentes = sc.nextLine();   
        tienda.setRegistroFederalontribuyentes(registroFederalontribuyentes);
        
       
        Configuracion();
    }           
    
    
}
