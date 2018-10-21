package Clases;

import Interefaces.ServiceTecnicable;

/**
 *
 * @author Christian Quiroz M.
 */
public class PlanFono implements ServiceTecnicable {
    
    private String codigoPlanF;
    private String tipoPlan;
    private String nombrePlan; 
    private boolean estadoServicioTecnico;
    private int valorPlan;
    private int valorAparato;

    //Constructor Vacio de la clase PlanFono
    public PlanFono() 
    {
         
    }

    //Getters y Setters para todos los atributos de la clase PlanFono
    public String getCodigoPlanF() {
        return codigoPlanF;
    }

    public void setCodigoPlanF(String codigoPlanF) {
        this.codigoPlanF = codigoPlanF;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(int rpta) {
        
        switch (rpta) {
            case 1:
                this.tipoPlan = "Economico";
                break;
            case 2:
                this.tipoPlan = "Normal";
                break;
            case 3:
                this.tipoPlan = "Premium";
                break;
            default:
                System.out.println("No se pudo seleccionar");
                break;
        }
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public boolean isEstadoServicioTecnico() {
        return estadoServicioTecnico;
    }

    public void setEstadoServicioTecnico(boolean estadoServicio) {
        this.estadoServicioTecnico = estadoServicio;
    }

    public int getValorPlan() {
        return valorPlan;
    }

    public void setValorPlan(int valorPlan) {
        this.valorPlan = valorPlan;
        
    }

    public int getValorAparato() {
        return valorAparato;
    }

    public void setValorAparato(int valorAparato) {
        this.valorAparato = valorAparato;
    }

    @Override
    public void aplicaServicioTecnico() {
        if(!this.isEstadoServicioTecnico())
        {
            this.estadoServicioTecnico = true;
            System.out.println("Servicio Tecnico Aplicado!");
        }
        else
        {
            System.out.println("Servicio Tecnico ya aplicado!");
        }
    }

    @Override
    public long pagarServicioTecnico() {
       return (long)(this.valorAparato*0.37);
    }
    
    public void imprimePlan()
    {
        System.out.println(this.codigoPlanF+"\n"+this.nombrePlan+"\n"+this.tipoPlan+"\n"+this.valorPlan);
    }
}
