package Clases;

import SoftwareTelefonia.Leer;

/**
 *
 * @author Christian Quiroz M.
 */
public class SmarthPhone extends Movil{
    private String versionSo;
    private int cantidadMemoria;

    //Constructor vacio de la clase SmarthPhone
    public SmarthPhone() 
    {
        System.out.println("Ingrese version del Sistema Operativo");
        this.versionSo = Leer.dato();
        System.out.println("Ingrese la cantidad de Memoria");
        this.cantidadMemoria = Leer.datoInt();
    }

    //Getters y Setters de los atributos de la clase SmarthPhone
    public String getVersionSo() {
        return versionSo;
    }

    public void setVersionSo(String versionSo) {
        this.versionSo = versionSo;
    }

    public int getCantidadMemoria() {
        return cantidadMemoria;
    }

    public void setCantidadMemoria(int cantidadMemoria) {
        this.cantidadMemoria = cantidadMemoria;
    }

    @Override
    public long descuento() {
       return 0;
    }
 
    public void imprimeSmartPhone()
    {
        super.imprimeMovil();
        System.out.println("\nVersion: "+this.versionSo+"Cantidad de Memoria: "+this.cantidadMemoria);
    }
            
}
