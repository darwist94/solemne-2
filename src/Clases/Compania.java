package Clases;
/**
 *
 * @author Christian Quiroz M.
 */
public class Compania {
    
    private String rutCompania;
    private String nombreCompania;
    private String Direccion;

    //Constructor vacio de la clase Compania
    public Compania() {
    }

    //Getters y Setters de todos los atributos de la clase Compania
    public String getRutCompania() {
        return rutCompania;
    }

    public void setRutCompania(String rutCompania) {
        this.rutCompania = rutCompania;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    public void imprimeCompania()
    {
        System.out.println(this.rutCompania+"\n"+this.nombreCompania+"\n"+this.Direccion);
    }
    
}
