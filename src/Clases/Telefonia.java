package Clases;

import Interefaces.Cuentable;
import Interefaces.Impuestable;
import SoftwareTelefonia.Leer;
import java.util.ArrayList;

/**
 *
 * @author Christian Quiroz M.
 */
public abstract class Telefonia implements Impuestable,Cuentable{
    
  
 
    private Compania compania;
    private Usuario usuario;
    private PlanFono planFono;
    private String numeroFono;
    private String region;
    private String comuna;
    private String fechaContrato;
    private int valorMinutoFijo;
    private int valorMinutoMovil;
    private int tarifaFija;
    private int cantidadMinutosUsadosFijo;
    private int cantidadMinutosUsadosMovil;
  
    //Constructor Vacio de la clase Telefonia
    public Telefonia() 
    {
       this.usuario = new Usuario();
       this.compania = new Compania();
       this.planFono = new PlanFono();
       agregaTelefonia();
    }

    //Constructor con parametros de la clase Telefonia
     public Telefonia(Compania compania, Usuario usuario, PlanFono planFono, String numeroFono, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, int tarifaFija, int cantidadMinutosUsadosFijo, int cantidadMinutosUsadosMovil) {
        this.compania = compania;
        this.usuario = usuario;
        this.planFono = planFono;
        this.numeroFono = numeroFono;
        this.region = region;
        this.comuna = comuna;
        this.fechaContrato = fechaContrato;
        this.valorMinutoFijo = valorMinutoFijo;
        this.valorMinutoMovil = valorMinutoMovil;
        this.tarifaFija = tarifaFija;
        this.cantidadMinutosUsadosFijo = cantidadMinutosUsadosFijo;
        this.cantidadMinutosUsadosMovil = cantidadMinutosUsadosMovil;
    }
    
    
    //Getters y Setters de todos los atributos de la clase Telefonia

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PlanFono getPlanFono() {
        return planFono;
    }

    public void setPlanFono(PlanFono planFono) {
        this.planFono = planFono;
    }
 
    
    public String getNumeroFono() {
        return numeroFono;
    }

    public void setNumeroFono(String numeroFono) {
        this.numeroFono = numeroFono;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public int getValorMinutoFijo() {
        return valorMinutoFijo;
    }

    public void setValorMinutoFijo(int valorMinutoFijo) {
        this.valorMinutoFijo = valorMinutoFijo;
    }

    public int getValorMinutoMovil() {
        return valorMinutoMovil;
    }

    public void setValorMinutoMovil(int valorMinutoMovil) {
        this.valorMinutoMovil = valorMinutoMovil;
    }

    public int getTarifaFija() {
        return tarifaFija;
    }

    public void setTarifaFija(int tarifaFija) {
        this.tarifaFija = tarifaFija;
    }

    public int getCantidadMinutosUsadosFijo() {
        return cantidadMinutosUsadosFijo;
    }

    public void setCantidadMinutosUsadosFijo(int cantidadMinutosUsadosFijo) {
        this.cantidadMinutosUsadosFijo = cantidadMinutosUsadosFijo;
    }

    public int getCantidadMinutosUsadosMovil() {
        return cantidadMinutosUsadosMovil;
    }

    public void setCantidadMinutosUsadosMovil(int cantidadMinutosUsadosMovil) {
        this.cantidadMinutosUsadosMovil = cantidadMinutosUsadosMovil;
    }
    


//Metodo de la interface Impuestable, que calcula el impuesto a aplicar, al pagoPorMinutosUsados, si es menor a 100 minutos impuesto especial =13%    
//de caso contrario impuesto normal = 19%
    @Override
    public long impuestoAplicado() {
        long resultado = 0;
        if((this.cantidadMinutosUsadosFijo+this.cantidadMinutosUsadosMovil<=100))
        {
          resultado = (long)(pagoPorMinutosUsados()*Telefonia.impEsp);
        }
        else
        {
            resultado = (long)(pagoPorMinutosUsados()*Telefonia.impNormal);
        }
        return resultado;
    }
//Metodo de la interface Impuestable, que calcula el pago por minutos usados 
    @Override
    public long pagoPorMinutosUsados() {
        return((this.valorMinutoFijo*this.cantidadMinutosUsadosFijo)+(this.valorMinutoMovil*this.cantidadMinutosUsadosMovil));
    }

   
//Metodo de la interface Impuestable, que calcula la tarifa total a pagar 
    @Override
    public long totalPagar()
    {
        return(pagoPorMinutosUsados() + this.tarifaFija - descuento() + impuestoAplicado());
    }
    
//Metodo que imprime una boleta Detallada 
    @Override
    public void muestraDetalle() {
        System.out.println("Pago por minutos Usados:" + this.pagoPorMinutosUsados());
        System.out.println("Pago por Impuestos:" + this.impuestoAplicado());
        System.out.println("Descuento:" + descuento());
        System.out.println("Total a pagar:" + this.totalPagar());
        imprimeTelefonia();
    }
//Metodoo que imprime nombre, rut, telefono, total a pagar 
    @Override
    public void cuentaSimple() {
        
        System.out.println("USUARIO:" + this.usuario.getNombreUs());
        System.out.println("RUT:" + this.usuario.getRunUs());
        System.out.println("Numero Fono:" + this.getNumeroFono());
        System.out.println("Total a pagar:" + this.totalPagar());
    }
    
    
    public int totalMinutos()
    {
  
        int total = this.getCantidadMinutosUsadosFijo() + this.getValorMinutoMovil();
        
        return total;
    }
       
    public boolean existeMarca(String marcaFono){
        
        return false;
    }
    
    public int contadorTelefonos(){
        
        return 0;
    }
    
    public void agregaTelefonia()
    {
        agregaUsuario();
        agregaCompania();
        agregaPlanFono();
         
        asignarTarifas();
        
    }
    
    public void asignarTarifas()
    {
           if(this.getPlanFono().getTipoPlan().equalsIgnoreCase("Economico"))
   {
       this.setTarifaFija(1);
       this.setValorMinutoFijo(1);
       this.setValorMinutoMovil(1);
       this.setCantidadMinutosUsadosMovil(100);
       this.setCantidadMinutosUsadosFijo(200);
   }
   else if(this.getPlanFono().getTipoPlan().equalsIgnoreCase("Normal"))
   {
       this.setTarifaFija(2);
       this.setValorMinutoFijo(2);
       this.setValorMinutoMovil(2);
       this.setCantidadMinutosUsadosMovil(300);
       this.setCantidadMinutosUsadosFijo(400);
   }
   else if(this.getPlanFono().getTipoPlan().equalsIgnoreCase("Premium"))
   {
       this.setTarifaFija(3);
       this.setValorMinutoFijo(3);
       this.setValorMinutoMovil(3);
       this.setCantidadMinutosUsadosMovil(500);
       this.setCantidadMinutosUsadosFijo(600);
       
   }
        
     
    }
 
    public void agregaUsuario()
    {
   
        System.out.println("Ingrese nombre del Usuario");
        usuario.setNombreUs(Leer.dato());
        System.out.println("Ingrese el apellido del Usuario");
        usuario.setApellidoUs(Leer.dato());
        System.out.println("Ingrese el rut del Usuario");
        usuario.setRunUs(Leer.dato());
        System.out.println("Ingrese la Edad");
        usuario.setEdad(Leer.datoInt());
        System.out.println("Ingrese la fecha de nacimiento");
        usuario.setFechaNacimiento(Leer.dato());
        System.out.println("Ingrese el estado civil");
        usuario.setEstadoCivil(Leer.dato());
              
    }      
    public void agregaCompania()
    {
        int rpta =0 ;
        do{
        System.out.println("\n**Seleccione Compañia**\n1- Claro \n2- Movistar\n3- Entel");
        rpta = Leer.datoInt();
            switch (rpta) {
                case 1:
                    this.compania.setNombreCompania("Claro");
                    this.compania.setRutCompania("20.345.234-K");
                    this.compania.setDireccion("Av.Irarrazabal 607");
                    break;
                    case 2:
                   
                        this.compania.setNombreCompania("Movistar");
                        this.compania.setRutCompania("50.678.543-1");
                        this.compania.setDireccion("Av.Francisco Bilbao 809");
                    break;
                    case 3:
                    this.compania.setNombreCompania("Entel");
                    this.compania.setRutCompania("40.890.876-7");
                    this.compania.setDireccion("Hermanos Amunátegui 20");
                    break;
                default:
                    System.out.println("INGRESAR OPCION VALIDA");
            }
        }while(rpta!=1&& rpta!=3&& rpta!=2);
        

        
    }
    public void agregaPlanFono()
    { 
        char a = (char)(Math.random()*26+'A');        
        char b = (char)(Math.random()*26+'A');
        char c = (char)(Math.random()*26+'A');
        int uno = (int)(Math.random()*10);
        int dos = (int)(Math.random()*10);
        int tres = (int)(Math.random()*10);
        String resultado = ""+a+b+c+uno+dos+tres;
        int rpta = 0;
        do{
            if(this.getCompania().getNombreCompania().equalsIgnoreCase("Claro"))
            {
                System.out.println("\n**Seleccione TIPO DE PLAN**\n1- Economico\n2- Normal\n3- Premium ");
                rpta= Leer.datoInt();
                this.planFono.setTipoPlan(rpta);
                switch (rpta) {
                    case 1:
                        int plan = 0;
                        System.out.println("\n**Economico**");
                        do{
                            System.out.println("Selecciona tu plan\n1- Plan Aguja     $9.990\n2- Plan Pablo     $13.990");
                            plan = Leer.datoInt();
                            if(plan == 1)
                            {
                                this.planFono.setCodigoPlanF(resultado);
                                this.planFono.setNombrePlan("Plan Aguja");
                                this.planFono.setValorPlan(5990);
                                
                            }
                            else if(plan == 2)
                            {
                                this.planFono.setCodigoPlanF(resultado);
                                this.planFono.setNombrePlan("Plan Pablo");
                                this.planFono.setValorPlan(9990); 
                            }
                            else
                            {
                                System.out.println("SELECCIONE UNA OPCION VALIDA");
                            }
                        }while(plan!=1&&plan!=2);   
                        break;
                                
                    case 2:
                        int planA = 0;
                        System.out.println("\n**Normal**");
                        do{
                            System.out.println("Selecciona tu plan\n1- Plan Medium     $10.990\n2- Plan Reguleque     $12.990");
                            planA = Leer.datoInt();
                    switch (planA) {
                        case 1:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Medium");
                            this.planFono.setValorPlan(10990);
                            break;
                        case 2:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Reguleque");
                            this.planFono.setValorPlan(12990);
                            break;
                        default:
                            System.out.println("SELECCIONE UNA OPCION VALIDA");
                            break;
                    }
                        }while(planA!=1&&planA!=2);
                        break;
                        
                    case 3:
                        int planB = 0;
                        System.out.println("\n**Premium**");
                        do{
                            System.out.println("Selecciona tu plan\n1- Plan Supremo     $17.990\n2- Plan Milenial    $19.990");
                            planB = Leer.datoInt();
                    switch (planB) {
                        case 1:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Supremo");
                            this.planFono.setValorPlan(17990);
                            break;
                        case 2:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Milenial");
                            this.planFono.setValorPlan(19990);
                            break;
                        default:
                            System.out.println("SELECCIONE UNA OPCION VALIDA");
                            break;
                    }
                        }while(planB!=1&&planB!=2);
                        break;
                    default:
                        System.out.println("SELECCIONE UNA OPCION VALIDA");
                }
            }
            else if(this.getCompania().getNombreCompania().equalsIgnoreCase("Movistar"))
            {
                System.out.println("Seleccione TIPO DE PLAN\n1- Economico\n2- Normal\n3- Premium ");
                rpta= Leer.datoInt();
                this.planFono.setTipoPlan(rpta);
                switch (rpta) {
                    case 1:
                        int plan = 0;
                        System.out.println("\n**Economico**");
                        do{
                            System.out.println("Selecciona tu plan\n1- Plan Aguja     $9.990\n2- Plan Pablo     $13.990");
                            plan = Leer.datoInt();
                    switch (plan) {
                        case 1:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Aguja");
                            this.planFono.setValorPlan(5990);
                            break;
                        case 2:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Pablo");
                            this.planFono.setValorPlan(9990);
                            break;
                        default:
                            System.out.println("SELECCIONE UNA OPCION VALIDA");
                            break;
                    }
                        }while(plan!=1&&plan!=2);   
                        break;
                                
                    case 2:
                        int planA = 0;
                        System.out.println("\n**Normal**");
                        do{
                            System.out.println("Selecciona tu plan\n1- Plan Medium     $10.990\n2- Plan Reguleque     $12.990");
                            planA = Leer.datoInt();
                    switch (planA) {
                        case 1:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Medium");
                            this.planFono.setValorPlan(10990);
                            break;
                        case 2:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Reguleque");
                            this.planFono.setValorPlan(12990);
                            break;
                        default:
                            System.out.println("SELECCIONE UNA OPCION VALIDA");
                            break;
                    }
                        }while(planA!=1&&planA!=2);
                        break;
                        
                    case 3:
                        int planB = 0;
                        System.out.println("\n**Premium**");
                        do{
                            System.out.println("Selecciona tu plan\n1- Plan Supremo     $17.990\n2- Plan Milenial    $19.990");
                            planB = Leer.datoInt();
                    switch (planB) {
                        case 1:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Supremo");
                            this.planFono.setValorPlan(17990);
                            break;
                        case 2:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Milenial");
                            this.planFono.setValorPlan(19990);
                            break;
                        default:
                            System.out.println("SELECCIONE UNA OPCION VALIDA");
                            break;
                    }
                        }while(planB!=1&&planB!=2);
                        break;
                    default:
                        System.out.println("SELECCIONE UNA OPCION VALIDA");
                }
            }
            else if(this.getCompania().getNombreCompania().equalsIgnoreCase("Entel"))
            {
                System.out.println("Seleccione TIPO DE PLAN\n1- Economico\n2- Normal\n3- Premium ");
                rpta= Leer.datoInt();
                this.planFono.setTipoPlan(rpta);
                switch (rpta) {
                    case 1:
                        int plan = 0;
                        System.out.println("\n**Economico**");
                        do{
                            System.out.println("Selecciona tu plan\n1- Plan Aguja     $9.990\n2- Plan Pablo     $13.990");
                            plan = Leer.datoInt();
                    switch (plan) {
                        case 1:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Aguja");
                            this.planFono.setValorPlan(5990);
                            break;
                        case 2:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Pablo");
                            this.planFono.setValorPlan(9990);
                            break;
                        default:
                            System.out.println("SELECCIONE UNA OPCION VALIDA");
                            break;
                    }
                        }while(plan!=1&&plan!=2);   
                        break;
                                
                    case 2:
                        int planA = 0;
                        System.out.println("\n**Normal**");
                        do{
                            System.out.println("Selecciona tu plan\n1- Plan Medium     $10.990\n2- Plan Reguleque     $12.990");
                            planA = Leer.datoInt();
                    switch (planA) {
                        case 1:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Medium");
                            this.planFono.setValorPlan(10990);
                            break;
                        case 2:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Reguleque");
                            this.planFono.setValorPlan(12990);
                            break;
                        default:
                            System.out.println("SELECCIONE UNA OPCION VALIDA");
                            break;
                    }
                        }while(planA!=1&&planA!=2);
                        break;
                        
                    case 3:
                        int planB = 0;
                        System.out.println("\n**Premium**");
                        do{
                            System.out.println("Selecciona tu plan\n1- Plan Supremo     $17.990\n2- Plan Milenial    $19.990");
                            planB = Leer.datoInt();
                    switch (planB) {
                        case 1:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Supremo");
                            this.planFono.setValorPlan(17990);
                            break;
                        case 2:
                            this.planFono.setCodigoPlanF(resultado);
                            this.planFono.setNombrePlan("Plan Milenial");
                            this.planFono.setValorPlan(19990);
                            break;
                        default:
                            System.out.println("SELECCIONE UNA OPCION VALIDA");
                            break;
                    }
                        }while(planB!=1&&planB!=2);
                        break;
                    default:
                        System.out.println("SELECCIONE UNA OPCION VALIDA");
                }
            }
        }while(rpta!=1&&rpta!=2&&rpta!=3);
        System.out.println("Ingrese el valor del aparato");
        planFono.setValorAparato(Leer.datoInt());
        
    }
    
    public void imprimeTelefonia()
    {
        compania.imprimeCompania();
        usuario.imprimeUsuario();
        planFono.imprimePlan();
        System.out.println("\nNumero Telefono: "+this.numeroFono+"\nValor MinutoFijo: $"+this.valorMinutoFijo+ "\nValor MinutoMovil: $"+this.valorMinutoMovil
        +"\nValor TarijaFija: $"+this.tarifaFija);
    }
  
}
