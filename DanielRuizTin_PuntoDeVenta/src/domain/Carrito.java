/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Grupo Salinas 170828
 */
public class Carrito implements Displayable{
    
    //TODO cambiar a auna linkedList para lo del eliminar
   private ArrayList<Articulo> articulos ;     
   private final int NUMERO_ARTICULOS_MAX = 100;
   private double total = 0.0;
   private double precioMaximo =  -1.0;

   public Carrito(){
       
   }
   
   public Carrito(Articulo[] articulos){
       
       for (Articulo articulo: articulos){
           this.agregarArticulo(articulo);
       }
       
   }
   
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }   
    
    public void agregarArticulo(Articulo articulo){
        
        if(articulos == null){
           articulos = new ArrayList<>();                                  
        }                               
        articulos.add(articulo);        
        total += articulo.getPrecioConDescuento();        
        // esto se utilizara para obtener las columnas a la derecha del precio.
        precioMaximo = precioMaximo < articulo.getPrecio() ? articulo.getPrecio():precioMaximo;        
    }
    
    public void eliminarArticulo(int indice){
        
        if (indice < 0 || indice >= articulos.size()){
            System.out.println("Ese articulo no existe");
            return;
        }
                   
        total -= articulos.get(indice).getPrecioConDescuento();
        
//        for (int i = indice; i <= numeroArticulos; i++ ){
//            articulos[i] = articulos[i+1];
//        }

        articulos.remove(indice);
        
                          
    }

    public int getNumeroArticulos() {
        return articulos == null ? 0:articulos.size();
    }

    public double getTotal() {
        return total;
    }

    public double getPrecioMaximo() {
        return precioMaximo;
    }
    
    public String display(){
        StringBuilder sb = new StringBuilder();
        
        int longitudPrecio = String.format("%.2f", this.precioMaximo).length();
        if (getNumeroArticulos() == 0){
            sb.append("No Existen articulos en tu carrito aun.");
        }
        
        for (int i = 0; i < this.articulos.size(); i++){
            sb.append(i).append(" ").append(this.articulos.get(i).display()).append("\n");
        }
        return sb.toString();
    }
    
    public String display(int longitudDescripcion){
        StringBuilder sb = new StringBuilder();
        
        int longitudPrecio = String.format("%.2f", this.precioMaximo).length();
         if (getNumeroArticulos() == 0){
            sb.append("No Existen articulos en tu carrito aun.");
        }
        
        for (int i = 0; i < getNumeroArticulos(); i++){
            sb.append(i).append(" ").append(this.articulos.get(i).display( longitudDescripcion, longitudPrecio)).append("\n");
        }
        return sb.toString();
    }
    
    
}
