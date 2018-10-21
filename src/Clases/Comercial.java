package Clases;

/**
 *
 * @author Christian Quiroz M.
 */
public class Comercial extends Fijo{
    
    public int cantidadAnexos;

    //constructor vacio de la clase Comercial
    public Comercial() {
    }
   
    //Getters y Setters para todos los atributos de las clase Comercial
    public int getCantidadAnexos() {
        return cantidadAnexos;
    }

    public void setCantidadAnexos(int cantidadAnexos) {
        this.cantidadAnexos = cantidadAnexos;
    }

    
    //?????????????????????????????????????
    @Override
    public String getCodigoZona() {
        return codigoZona;
    }

    /**
     *
     * @param codigoZona
     */
    @Override
    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }
    //????????????????????????????????????

    @Override
    public long descuento() 
    {
        if(this.cantidadAnexos>100)
        {
            return ((super.pagoPorMinutosUsados()*7)/100);
        }
        return 0;
    }


    public void imprimeComercial()
    {
    }

    
    

  
    
}
