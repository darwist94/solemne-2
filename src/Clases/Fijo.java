package Clases;

import SoftwareTelefonia.Leer;

/**
 *
 * @author Christian Quiroz M.
 */
public abstract class Fijo extends Telefonia {
    
    public String codigoZona;

    //Constructor vacio para la clase Fijo
    public Fijo() 
    {
        System.out.println("INGRESE EL CODIGO DE ZONA");
        this.codigoZona  = Leer.dato();
    }

    //Getter y Setters para los atributos de la clase Fijo
    public String getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }
    
    public void imprimeFijo()
    {
        super.imprimeTelefonia();
        System.out.println("Codigo Zona: "+this.codigoZona);
    }
}
