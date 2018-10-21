package Clases;

/**
 *
 * @author Christian Quiroz M.
 */
public class Privado extends Fijo{
    private int identificadorLlamada;

    //Constructor Vacio de la clase Privado
    public Privado() {
    }

    //Getters y Setters para todos los atributos de la clase Privado
    public int getIdentificadorLlamada() {
        return identificadorLlamada;
    }

    public void setIdentificadorLlamada(int identificadorLlamada) {
        this.identificadorLlamada = identificadorLlamada;
    }

    //????????????????????????????????????????????????????????
    @Override
    public String getCodigoZona() {
        return codigoZona;
    }

    @Override
    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }
    //??????????????????????????????????????????????????????????

    /**
     *
     * @return
     */
    @Override
    public int contadorTelefonos(){
        return 1;
    }
    
    @Override
    public long descuento() {
        if((super.getCantidadMinutosUsadosFijo()+super.getCantidadMinutosUsadosMovil())<50)
        {
            return ((super.pagoPorMinutosUsados()*9)/100);
        }
        return 0;
    }    
}
