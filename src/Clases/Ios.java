package Clases;

import SoftwareTelefonia.Leer;

/**
 *
 * @author Christian Quiroz M.
 */
public class Ios extends SmarthPhone{
    private int modeloSmarth; // (1,2,3,4,5,6)

    //Constructor vacio de la clase Ios
    public Ios() 
    {
        int rpta = 0;
        do{
        System.out.println("Ingrese modelo Smart");
        System.out.println("* 1\n* 2\n* 3\n* 4\n* 5\n* 6");
        rpta = Leer.datoInt();
        this.modeloSmarth = rpta;
        }while(rpta<=1 && rpta>=6);
                
                }
    
    //Getters y Setters de la clase Ios
    public int getModeloSmarth() {
        return modeloSmarth;
    }

    public void setModeloSmarth(int modeloSmarth) {
        this.modeloSmarth = modeloSmarth;
    }

    @Override
    public long descuento() {
        return super.descuento();
    }
    
    private void imprimeIos()
    {
        super.imprimeSmartPhone();
        System.out.println("Modelo IOS: "+this.modeloSmarth);
    }
}
