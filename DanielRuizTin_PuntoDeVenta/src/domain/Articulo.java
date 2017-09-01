/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Daniel Miguel Ruiz Tinajero
 */
public class Articulo {
    
    private int codigo;
    private String descripcion;
    private double precio;  
    private double descuento;    
    final int MAX_LENGTH_DESCRIPCION = 255;
    final String DEFAULT_DESCRIPTION = "DESCRIPCION";
    final int LAST_CODIGO = 8564;
    
    public Articulo(){
        this.setCodigo(-1);
        this.setDescripcion(null);
        this.setPrecio(1.0);
        this.setDescuento(0.0);
    }
    
    public Articulo(Articulo other){
        this(other.getCodigo(), other.getDescripcion(),
                other.getPrecio(), other.getDescuento());        
    }
    
    // el no ponerle public significa que son publicas pero solo para los
    // de adenttro de su paquete, los que estan afuera de su paquete no los puedden ver
    public Articulo(int codigo,String descripcion, double precio, double descuento){
        this.setCodigo(codigo);
        this.setDescripcion(descripcion);
        this.setPrecio(precio);
        this.setDescuento(descuento);
    }
    
    public Articulo(int codigo,String descripcion, double precio){
        this(codigo, descripcion, precio, 0.0);
    }
    
    public int getCodigo() {
        return codigo;
    }

    public final void setCodigo(int codigo) {        
        this.codigo = codigo> 0 ? codigo: (int)(Math.random()* LAST_CODIGO);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && descripcion.length() < MAX_LENGTH_DESCRIPCION){
            this.descripcion = descripcion;
        } else if(descripcion != null && descripcion.length() >= MAX_LENGTH_DESCRIPCION){
             this.descripcion = descripcion.substring(0,MAX_LENGTH_DESCRIPCION);
        } else {
            this.descripcion = DEFAULT_DESCRIPTION;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0.0){
            this.precio = precio;
        } else {
            this.precio = 0.0;
        }
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {        
        this.descuento = descuento >= 0.0 && descuento <= 100.0 ? descuento: 0.0;
    }
    
    public String display(){
        
        StringBuilder sb = new StringBuilder();                 
        sb.append(codigo);
        sb.append("\t");
        sb.append(descripcion);
        sb.append("\t");
        sb.append("$ ").append( String.format("%.2f", precio) );
        sb.append("\t");
        sb.append( String.format("%.2f",descuento)).append("%");
       return sb.toString();
    }
    
    /**
     * Metodo que dado la longitud de descripcion del articulo
     * solo imprime esa longitud;
     * @param lengthDescripcion
     * @return 
     */
    public String display(int lengthDescripcion, int columnsOfPrice){
        
        StringBuilder sb = new StringBuilder();                 
        sb.append(codigo);
        sb.append("\t");
        sb.append(String.format("%-" + lengthDescripcion + "s", chop(descripcion,lengthDescripcion)));
//        sb.append("\t");                                
        sb.append( String.format("%7.2f",descuento)).append(" ");
        sb.append("  ");
        sb.append(" ").append(String.format("%"+columnsOfPrice+".2f", precio) );
        sb.append("   ").append(String.format("%"+columnsOfPrice+".2f", getPrecioConDescuento()) );
        return sb.toString();
    }
    
    private String chop(String s, int length){
        if (s!= null && s.length() > length){
            return s.substring(0, length);
        } else {
            return s;
        }
    }
    
    public double getDescuentoM(){
        return this.descuento / 100.0;
    }
    
    public double getPrecioConDescuento(){
        double substraer =  this.getPrecio() * this.getDescuentoM();
        return this.getPrecio() - substraer ;
    }
    
}
