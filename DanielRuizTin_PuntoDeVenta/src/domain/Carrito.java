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
public class Carrito {
    
   private Articulo [] articulos ;   
   private int numeroArticulos = 0;
   private final int NUMERO_ARTICULOS_MAX = 100;
   private double total = 0.0;
   private double precioMaximo =  -1.0;

   public Carrito(Articulo[] articulos){
       
       for (Articulo articulo: articulos){
           this.agregarArticulo(articulo);
       }
       
   }
   
    public Articulo[] getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulo[] articulos) {
        this.articulos = articulos;
    }   
    
    public void agregarArticulo(Articulo articulo){
        
        if(articulos == null || numeroArticulos == 0){
            articulos = new Articulo[NUMERO_ARTICULOS_MAX];                                    
        }        
        
        if (numeroArticulos == NUMERO_ARTICULOS_MAX){
            System.out.println("YA NO LE CABEN MAS ARTICULOS A ESTE CARRITO, TOME OTRO PORFAVOR");
            return;
        }
        
        articulos[numeroArticulos++] = new Articulo(articulo);
        
        total += articulo.getPrecioConDescuento();        
        // esto se utilizara para obtener las columnas a la derecha del precio.
        precioMaximo = precioMaximo < articulo.getPrecio() ? articulo.getPrecio():precioMaximo;        
    }
    
    public void eliminarArticulo(int indice){
        
        if (indice < 0 || indice >= numeroArticulos){
            System.out.println("Ese articulo no existe");
            return;
        }
                   
        total -= articulos[indice].getPrecioConDescuento();
        
        for (int i = indice; i <= numeroArticulos; i++ ){
            articulos[i] = articulos[i+1];
        }
        
        numeroArticulos--;
        
        
        
    }

    public int getNumeroArticulos() {
        return numeroArticulos;
    }

    public double getTotal() {
        return total;
    }

    public double getPrecioMaximo() {
        return precioMaximo;
    }
    
    
}
