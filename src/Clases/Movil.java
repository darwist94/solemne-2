package Clases;

import SoftwareTelefonia.Leer;

/**
 *
 * @author cetecom
 */
public abstract class Movil extends Telefonia{
    
    private String codigoAntena;
    private float peso;
    private int duracionBateria;

    //Constructor vacio de la clase Movil
    public Movil() 
    {
       
        char a = (char)(Math.random()*26+'A');        
        char b = (char)(Math.random()*26+'A');
        char c = (char)(Math.random()*26+'A');
        int uno = (int)(Math.random()*10);
        int dos = (int)(Math.random()*10);
        int tres = (int)(Math.random()*10);
        String resultado = ""+a+b+c+uno+dos+tres;
        this.codigoAntena = resultado;
        System.out.println("Ingrese peso de la antena");
        this.peso = Leer.datoInt();
        System.out.println("Ingrese la duracion de la bateria");
        this.duracionBateria = Leer.datoInt();
    }
  
    //Getters y Setters para todos los atributos de la clase Movil
    public String getCodigoAntena() {
        return codigoAntena;
    }

    public void setCodigoAntena(String codigoAntena) {
        this.codigoAntena = codigoAntena;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getDuracionBateria() {
        return duracionBateria;
    }

    public void setDuracionBateria(int duracionBateria) {
        this.duracionBateria = duracionBateria;
    }

    public void imprimeMovil()
    {
        super.imprimeTelefonia();
        System.out.println("\nCodigo Antena: "+this.codigoAntena+"\nDuracion Bateria "+this.duracionBateria+" Horas"+"\nPeso del movil: "+this.peso);
    }
    
    
    
}
