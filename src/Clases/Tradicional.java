package Clases;

import SoftwareTelefonia.Leer;

/**
 *
 * @author cetecom
 */
public class Tradicional extends Movil {
    private String tipoFono;//almeja,slice,normal
    private boolean pantallaColor;

    //Constructor vacio de la clase Tradicional
    public Tradicional() 
    {
        int rpta = 0;
         do{
            System.out.println("\nSeleccione MODELO DE TELEFONO\n1- Almeja\n2- Slice\n3- Normal");
            rpta= Leer.datoInt();
            switch (rpta) {
                case 1:
                    this.tipoFono = "Almeja";
                    break;
                case 2:
                    this.tipoFono = "Slice";
                    break;
                case 3:
                    this.tipoFono = "Normal";
                    break;
                default:
                    System.out.println("\n**INGRESE UNA OPCION VALIDA**");
                    break;
            }
        }while(rpta!=1&&rpta!=2&&rpta!=3);
    }

   //Getters y Setters de la clase Tradicional
    public String getTipoFono() {
        return tipoFono;
    }

    public void setTipoFono(String tipoFono) {
        this.tipoFono = tipoFono;
    }

    public boolean isPantallaColor() {
        return pantallaColor;
    }

    public void setPantallaColor(boolean pantallaColor) {
        this.pantallaColor = pantallaColor;
    }
    
    @Override
    public long descuento() {
        if(super.getPlanFono().getTipoPlan().equalsIgnoreCase("Economico"))
        {
            return ((super.pagoPorMinutosUsados()*17)/100);
        }
        return 0;
    }
    
    public void imprimeTradicional()
    {
        super.imprimeMovil();
        System.out.println("\nTipo Telefono: "+this.tipoFono+"\nPantalla a color: "+(this.pantallaColor? "SI":"NO"));
    }
}
