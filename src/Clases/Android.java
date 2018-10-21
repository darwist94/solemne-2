package Clases;

import SoftwareTelefonia.Leer;

/**
 *
 * @author Christian Quiroz M.  
 */
public class Android extends SmarthPhone{
    
    
    private String marcaFono;

    //Constructor vacio de la clase Android
    public Android() 
    {
        System.out.println("Ingrese la Marca del Telefono");
        this.marcaFono = Leer.dato();
            
        
    }
    
  
    //Getters y Setters de todos los atributods de la clase Android
    public String getMarcaFono() {
        return marcaFono;
    }

    public void setMarcaFono(String marcaFono) {
        this.marcaFono = marcaFono;
    }
    
    @Override
    public boolean existeMarca(String marcaFono){
       
        return getMarcaFono().equalsIgnoreCase(marcaFono);
    }
    
    
    public void imprimeeAndroid()
    {
        super.imprimeSmartPhone();
        System.out.println("Marca Telefono: "+this.marcaFono);
    }
    
    
}
