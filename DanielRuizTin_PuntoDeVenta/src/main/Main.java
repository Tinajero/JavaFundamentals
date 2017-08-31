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
    
    private static int opcionMenu;
    private static Articulo[] listaArticulos = new Articulo[nombreProductos.length];
    private static Carrito carrito;
    private static Tienda tienda;
    
    public static void main(String[] args) {
        
        int numeroArticulos = nombreProductos.length;
        listaArticulos = new Articulo[numeroArticulos];
        carrito = new Carrito();
        tienda = new Tienda();
        tienda.setNombre("Tienda");
        tienda.setDomicilio("Domicilio");
        tienda.setTelefono("Telefono");
        
        for(int i = 0; i < numeroArticulos; i++){
            double precio = precioProductos[i];
            String descripcion = nombreProductos[i];
            int codigo = (int) (Math.random() * 700 + 1);
            double descuento = Math.random()*20.0;
            listaArticulos[i] = new Articulo(codigo,descripcion, precio, descuento);
        }
        
       start();
    }
    
    public static void start(){
        desplegarMenu();
        int lectura = leerOpcion();
        ejecutarAccion(lectura);
        
    }
    
    public static void desplegarMenu(){
        
        StringBuilder sb = new StringBuilder();
         sb.append("====================================").append("\n");
        sb.append("Bienvenido, seleccione una opcion").append("\n");
        sb.append("1) Agregar articulo al carrito").append("\n");
        sb.append("2) Eliminar articulo del carrito").append("\n");
        sb.append("3) Imprimir ticket en pantalla").append("\n");
        sb.append("4) consultar compra por numero de ticket").append("\n");
        sb.append("5) Darse de alta como cliente").append("\n");
        sb.append("6) Realizar consulta de cliente por RFC").append("\n");
        sb.append("7) Imprimir factura en pantalla").append("\n");
        sb.append("0) Salir").append("\n");
        sb.append("11) Configuracion").append("\n");
        sb.append("====================================").append("\n");
        
        System.out.println(sb.toString());
    }
    
    private static int leerOpcion() {
        int opcion;
        Scanner sc = new Scanner(System.in);
        opcion = sc.nextInt();        
        return opcion;
    }
    

    private static void ejecutarAccion(int opcion) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean salir = false;
        switch(opcion){
            case 0: salir = true;
                    break;
            case 1: agregarArticulo();
                    break;
            case 2: break;
            case 3: imprimirTicket(); break;
            case 4: break;
            case 11: Configuracion();
                    break;
            default:
                   System.out.println("Opcion no valida");
                   break;
        }
        
        if (!salir)
            start();
    }
    
    public static void agregarArticulo(){
        
        System.out.println("Articulos existentes");
        
        for(int i = 0; i < listaArticulos.length; i++){
            System.out.println(i + ") " + listaArticulos[i].display(30, 4));
        }
        
        int seleccion = leerOpcion();
        
        if(seleccion >= 0 && seleccion <= listaArticulos.length){
            carrito.agregarArticulo(listaArticulos[seleccion]);
            System.out.println("Agregado");
        } else {
            System.out.println("Seleccion Invalida");
            start();
        }
            
        
               
        
    }
    
    public static void Configuracion(){
        System.out.println("1) Dar de alta articulos");
        System.out.println("2) cambiar Datos de la Tienda");
        System.out.println("3) Regresar");
        
        int config = leerOpcion();
        
        
        switch(config){
            case 1: break;
            case 2: break;
            case 3: start();
                    break;
            default: 
                    System.out.println("Opcion de Configuracion Invalida");
                    Configuracion();
                    break;                
        }                
    }
    
    public static void imprimirTicket(){
        Ticket ticket = new Ticket(tienda, carrito);
        
        ticket.display();
        
        start();
    }
    
    public static void cambiarDatosTienda(){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Nombre: ");                
        String nombre = in.nextLine();
        
        tienda.setNombre(nombre);
        
    }
    
    
    
    
    
}
