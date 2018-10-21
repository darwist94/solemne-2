
/**
 *
 * @author Christian Quiroz, Alfredo Gamonal
 */

package SoftwareTelefonia;

//SE IMPORTAN LAS CLASES, DE LOS PACKAGES CORRESPONDIENTES QUE SE USARAN EN LA CLASE MENU
import Clases.Android;
import Clases.Tradicional;
import Clases.Comercial;
import Clases.Ios;
import Clases.Telefonia;
import Clases.Privado;
import java.util.ArrayList;


public class Menu {

 static int enter = 0;
    

    //Metodo MAIN que ejecutara nuestro MENU
    public static void main(String[] args) {
        //Se crara un ArrayList de Telefonia cada vez que se ejecute el MAIN 
        ArrayList<Telefonia> telefonos = new ArrayList();
        int opcionMenu;
       
        
       do{//Se ejecutara el menu y se llamaran a los metodos creados en la clase MENU
           
           muestraMenu();
           opcionMenu = Leer.datoInt();
           menuMenu(opcionMenu,telefonos);
           
       }while(opcionMenu !=8); //Mientras el usuario desee continuar Y cuando decida salir.
    }
    
    public static void muestraMenu()
    {
        System.out.println("******************************\n     TELEFONIA SOLEMNE II\n******************************\n --->>>INGRESE UNA OPCION NUMERICA<<<---"
                + "\n1. AGREGAR TELEFONO\n2. INGRESAR POR TELEFONO\n3. INGRESAR POR RUT"
                + "\n4. Busca Marca\n5. Telefonos Con Servicio Tecnico\n6. Cuentas Sobre los 250 Minutos"
                + "\n7. Telefonos Privados\n8. Salir");
    }
    public static void muestraMenuRut()
    {
        System.out.println("\n******************************\n     MENU POR RUT\n******************************\n>>>INGRESE UNA OPCION NUMERICA<<<"
                + "\n1. ELIMINA TODOS LOS ASOCIADOS AL RUT\n2. CUENTA SIMPLE \n3. VOLVER AL MENU PRINCIPAL");
    }
    public static void menuFono()
    {
        System.out.println("\n******************************\n     MENU POR FONO\n******************************\n>>>INGRESE UNA OPCION NUMERICA<<<"
                + "\n1. ELIMINA FONO\n2. MODIFICA FONO\n3. MUESTRA CUENTA COMPLETA"
                + "\n4. APLICAR SERVICIO TECNICO\n5. VOLVER AL MENU PRINCIPAL");
    }
    
    public static void menuMoficarDatosFono(){
    
        System.out.println("\n******************************\n     MENU MODIFICAR DATOS DE FONO\n******************************\n>>>INGRESE UNA OPCION NUMERICA<<<"
                + "\n1. MODIFICAR USUARIO\n2. MODIFICAR COMPANIA\n3. PLAN DE FONO"
                + "\n4. VOLVER AL MENU PRINCIPAL");
    }
    
    public static void menuMenu(int opcionMenu,ArrayList<Telefonia> telefonos)
    {         int bandera =0;
        switch (opcionMenu) 
        {       
            case 1:// INGRESAR NUMERO TELEFONICO AL ARRAYLIST DE TELEFONOS
                String numeroTelefonico; 
                int flag = 0;
                int rpta = 0 ;
                
                
                do{
                    //SOLICITAMOS un numero telefonico
                    System.out.println("\n**Ingrese numero Telefonico**");
                    numeroTelefonico = Leer.dato();
                
                    //validamos que solo haya ingresado numeros
                    if(!Leer.esNumero(numeroTelefonico)){
                        bandera = 1;
                        System.out.println("**NUMERO TELEFONICO NO DEBE CONTENER LETRAS**");
                        System.out.println("\n**1 Para VOLVER A INTENTAR , cualquier otra tecla para ir al MENU PRINCIPAL**");// Preguntamos al usuario quiere o no continuar ingresando un numero Telefonico
                        rpta = Leer.datoInt();
                    }else{
                        bandera = 0;
                    }
                    
                    //Validamos que el numero ingresado no exista en mi ArrayList de telefonos
                    for (Telefonia t:telefonos)
                    {    
                        if(t.getNumeroFono().equalsIgnoreCase(numeroTelefonico))
                        {
                            bandera = 1;//Si ya existe el numero, bandera cambiara a 1 para ayudar a inicializar otras condicionea 
                            System.out.println("**NUMERO TELEFONICO YA EXISTE**");
                            System.out.println("\n**1 Para VOLVER A INTENTAR , cualquier otra tecla para ir al MENU PRINCIPAL**");// Preguntamos al usuario quiere o no continuar ingresando un numero Telefonico
                            rpta = Leer.datoInt();
                        }
                        else
                        {
                            bandera = 0;//Si no la bandera se mantendra en 0;
                        }
                    }
                    
                    
                }while(bandera == 1&&rpta==1);//Mientras la bandera TENGA UN NUMERO IGUAL y la RESPUESTA sea SI
                
                //SI la bandera se mantiene en 0 se agregara un objeto de TELEFONIA mediante el metodo agregaFono(ArrayList<Telefonia> telefonos,String numeroTelefonico)
                if(bandera==0)
                {
                        agregaFono(telefonos,numeroTelefonico);
                }
                break;
                
            case 2://INGRESAR POR TELEFONO
                int pos = 0;
                rpta = 0;
                if(telefonos.isEmpty())//Si nuestro ArrayList de TELEFONOS esta vacia , no se puede ingresar por telefeno, primero debiese agregar un telefono
                {
                    System.out.println("**NO HAY TELEFONOS AGREGADOS"
                            + "\nAGREGAR UN TELEFONO PRIMERO**");
                    System.out.println("\nENTER PARA CONTINUAR");
                    enter  = Leer.datoInt();
                }
                else//Si no, solicitamos un numero telefonico y lo buscamos en nuestro ArrayList de Telefonos
                {
                     do{
                         //SOLICITAMOS un numero telefonico
                         System.out.println("\n**Ingrese numero Telefonico**");
                         numeroTelefonico = Leer.dato();
                         
                         //Recorremos nuestro ArrayList de TELEFONOS
                         for (int i = 0; i < telefonos.size(); i++)
                         {   
                             if(telefonos.get(i).getNumeroFono().equalsIgnoreCase(numeroTelefonico))
                             { 
                                 //Si el numero telefonico solicitado es igual al de nuestro ArrayList en la posicion i
                                 //Instanciamos una bandera en 1, afirmando que se encontron el numero Telefonico y capturamos la posicion
                                 bandera = 1; //1 ON  - 0 OFF
                                 pos = i;
                             }
                             else //SI NO, DEJAMOS BANDERA EN 0;
                             {
                                 bandera=0;
                             }
                         }
                        
                         //Si la bandera encontro un usuario 
                         //Llamamos al metodo que ejecutara nuestro menu de FONO
                         if(bandera==1)
                         {
                             accionMenuFono(pos,telefonos);    
                         }
                         else
                         {//Si no, lo encuentra le decimos al usuario que el numero no esta registrado
                             System.out.println("\n**NUMERO NO REGISTRADO**");
                             System.out.println("\n1 Para VOLVER A INTENTARLO , cualquier otra tecla para volver al MENU PRINCIPAL");
                             rpta = Leer.datoInt();
                         }
                     }while(bandera ==0&&rpta == 1);//Mientras la respuesta del usuario sea continuar con el menu (SI = 1)y nuestra bandera permanezca en 0=OFF
                }
                break;
            case 3://INGRESAR POR RUT

                String rut = " ";//Creamos una variable String para el rut
                
               //Si nuestro ArrayList de TELEFONOS esta vacio , no se puede ingresar por rut, primero debiese agregar un telefono
                if(telefonos.isEmpty())
                {
                    System.out.println("**NO HAY USUARIOS AGREGADOS"
                            + "\nAGREGAR UN TELEFONO PRIMERO**");
                    System.out.println("\nENTER PARA CONTINUAR");
                    enter  = Leer.datoInt();
                }
                else
                {//Si nuestro ArrayList NO esta Vacio   
                    do{//Solicitamos al usuario ingresar el rut 

                        rpta=0;//Reseteamos respuesta para ocupar la variable nuevamente
                        System.out.println("\n**Ingrese rut del Usuario**");
                        rut= Leer.dato();
                        
                        //Recorremos nuestro ArrayList de telefonos
                        for (int i = 0; i < telefonos.size(); i++)
                        {
                            if(telefonos.get(i).getUsuario().getRunUs().equalsIgnoreCase(rut))
                            {
                                 //Mostramos al usuario sus numeros relacionados al rut
                                 System.out.println("-- "+ telefonos.get(i).getNumeroFono()+" --");
                                 bandera=1;//BANDERA EN ON 
                             }    
                         }
                     
                     //SI bandera ON
                     if(bandera==1)
                     {
                        accionMenuRut(rut,telefonos);//LLAMAMOS A NUESTRO METODO accionMenuRut(String rut,ArrayList<Telefonia> telefonos);
                     }
                    else
                     {//Si, NO lo encuentra, le decimos al usuario que el rut no esta registrado
                        System.out.println("\n**RUT NO REGISTRADO**");
                        System.out.println("\n1 Para VOLVER A INTENTARLO , cualquier otra tecla para volver al MENU PRINCIPAL");
                        rpta = Leer.datoInt();
                    }
                 }while(rpta==1);//Mientras respuesta sea VOLVER A INTENTARLO = 1
                }
                break;
            case 4: //Busca Por marca
                String marca;
                System.out.println("\n**Ingresa la marca del telefono **");
                marca = Leer.dato();
                boolean hayFonos = false;
                
                    for (int i = 0; i < telefonos.size(); i++)
                        {
                            
                            if(telefonos.get(i).existeMarca(marca)){
                                hayFonos = true;
                                System.out.println("\n**Telefono " +(i+1)+ "**");
                                System.out.println("**"+ telefonos.get(i).getNumeroFono() +"**");
                            }
                        
                        }
                    
                    if(!hayFonos){
                    System.out.println("\n NO hay telefonos con esta marca!");
                }
                System.out.println("\nENTER PARA CONTINUAR");
                    enter  = Leer.datoInt();
               
                            
                break;
            case 5://TELEFONOS CON SERVICIO TECNICO
                
                boolean hizoServicio = false;
                for (int i = 0; i < telefonos.size(); i++)
                        {
                        if(telefonos.get(i).getPlanFono().isEstadoServicioTecnico()){
                            hizoServicio = true;
                            System.out.println("\n**Telefono " +(i+1)+ "**");
                            System.out.println("**"+ telefonos.get(i).getNumeroFono() +"**");
                        }
                        }
                if(!hizoServicio){
                    System.out.println("\n NO hay telefonos llevados a servicio tecnico!");
                }
                System.out.println("\nENTER PARA CONTINUAR");
                    enter  = Leer.datoInt();
                
                break;  
            case 6://CUENTAS SOBRE EL 250
                 boolean hayCuentas = false;
                for (int i = 0; i < telefonos.size(); i++)
                        {
                            if(telefonos.get(i).totalMinutos() > 250){
                                hayCuentas = true;
                                System.out.println("\n**Cuenta " +(i+1)+ "**");
                                    telefonos.get(i).cuentaSimple();
                            }
                        }
                
                if(!hayCuentas){
                    System.out.println("\n NO hay Cuentas con Mas de 250 minutos!");
                }
                
                System.out.println("\nENTER PARA CONTINUAR");
                    enter  = Leer.datoInt();
                
                break;
            case 7://TELEFONOS PRIVADOS
                int cantFonos = 0;
                for (int i = 0; i < telefonos.size(); i++)
                        {     
                                cantFonos = telefonos.get(i).contadorTelefonos();
                              
                        }
                        
                System.out.println("\n**Cantidad Telefonos Privados: " +cantFonos+ "**");
                System.out.println("\nENTER PARA CONTINUAR");
                    enter  = Leer.datoInt();
                break;
            case 8://SALIR
                
                break;   
            default:
                System.out.println("**INGRESE OPCION NUMERICA INDICADA**");
                System.out.println("\nENTER PARA CONTINUAR");
                enter  = Leer.datoInt();
        }
    }
  
    public static void agregaFono(ArrayList<Telefonia> telefonos,String numeroTelefonico)
    {
        int botOpc;
                if(numeroTelefonico.length()==9)
                {
                    if(numeroTelefonico.indexOf("8")==0 || numeroTelefonico.indexOf("9")==0)
                    {
                        do{
                            System.out.println("\n* TELEFONO MOVIL *");
                            System.out.println("1- Smart Phone              2- Tradicional ");
                            botOpc = Leer.datoInt();
                            switch (botOpc) {
                                case 1:
                                   int botOpcA = 0;
                                    do{
                                        do{
                                            System.out.println("\n* SMARTPHONE *");
                                            System.out.println("1- Android              2- IOS ");
                                            botOpcA = Leer.datoInt();
                                        }while(botOpcA!=1&&botOpcA!=2);

                                switch (botOpcA) {
                                    case 1:
                                        System.out.println("\n* ANDROID *");
                                        Android android = new Android();
                                        android.setNumeroFono(numeroTelefonico);
                                        telefonos.add(android);
                                        System.out.println("\n**TELEFONO AGREGADO CON EXITO**");
                                        break;
                                    case 2:
                                        System.out.println("\n* IOS *");
                                        Ios iOs = new Ios();
                                        iOs.setNumeroFono(numeroTelefonico);
                                        telefonos.add(iOs);
                                        System.out.println("\n**TELEFONO AGREGADO CON EXITO**");
                                        System.out.println("\nENTER PARA CONTINUAR");
                                        enter  = Leer.datoInt();
                                        break;
                                    default:
                                        System.out.println("INGRESE UNA OPCION VALIDA");
                                        System.out.println("\nENTER PARA CONTINUAR");
                                        enter  = Leer.datoInt();
                                        break;
                                }
                                    }while(botOpc!=1 && botOpc!=2);

                                    break;
                                case 2:
                                    System.out.println("\n* TRADICIONAL *");
                                    Tradicional tradi = new Tradicional();
                                    tradi.setNumeroFono(numeroTelefonico);
                                    telefonos.add(tradi);
                                    System.out.println("\n**TELEFONO AGREGADO CON EXITO**");
                                    System.out.println("\nENTER PARA CONTINUAR");
                                    enter  = Leer.datoInt();

                                    break;
                                default:
                                    System.out.println("INGRESE UNA OPCION VALIDA");
                                    System.out.println("\nENTER PARA CONTINUAR");
                                    enter  = Leer.datoInt();
                            }
                        } while(botOpc!=1 && botOpc!=2);
                //aqui va telefono fijo
                    }else{
                            do{
                                System.out.println("\n* TELEFONO FIJO *");
                                System.out.println("1- Comercial              2- Privado ");
                                botOpc = Leer.datoInt();
                                switch (botOpc) 
                                {
                                    case 1:
                                        System.out.println("\n* COMERCIAL *");
                                        Comercial comercial = new Comercial();
                                        comercial.setNumeroFono(numeroTelefonico);
                                        telefonos.add(comercial);
                                        System.out.println("\n**TELEFONO AGREGADO CON EXITO**");
                                      System.out.println("\nENTER PARA CONTINUAR");
                                      enter  = Leer.datoInt();
                                        break;   
                                    case 2:
                                        System.out.println("\n* PRIVADO *");
                                         Privado privado = new Privado();
                                         privado.setNumeroFono(numeroTelefonico);
                                         telefonos.add(privado);
                                         System.out.println("\n**TELEFONO AGREGADO CON EXITO**");
                                         System.out.println("\nENTER PARA CONTINUAR");   
                                         enter  = Leer.datoInt();
                                         break;
                                    default:
                                        System.out.println("Ingrese una opcion valida");
                                        System.out.println("\nENTER PARA CONTINUAR");      
                                        enter  = Leer.datoInt();
                                }
                            }
                            while(botOpc!=1&&botOpc!=2);
                    }
                }
                else
                {
                    System.out.println("\n**INGRESE NUMERO DE 9 DIGITOS**\n");
                    System.out.println("\nENTER PARA CONTINUAR");                    
                    enter  = Leer.datoInt();
                }

    }
    public static void accionMenuFono(int pos,ArrayList<Telefonia> telefonos)
    {
    int rpta = 0;
    do
    {//Mostramos nuestro menu para telefonos e interactuamos con el mismo;
        menuFono();
        rpta = Leer.datoInt();//Respuesta del usuario
        switch (rpta)
        {
            case 1://BORRAR FONO       
                rpta =0;//Reseteamos respuesta para poder volver a usar la variable                      
                System.out.println("\nSE BORRARAN TODOS LOS DATOS DE "+telefonos.get(pos).getNumeroFono()+"\nCON RUT "+telefonos.get(pos).getUsuario().getRunUs() );
                System.out.println("1 para CONFIRMAR , cualquier otra tecla para volver al MENU DE TELEFONOS");
                                                 
                rpta = Leer.datoInt();//Confirmacion del usuario
                
                //Si el usuario confirma, eliminamos los datos del telefono en la posicion encontrada
                if(rpta==1)
                {
                    telefonos.remove(pos);
                    rpta=5;//Ponemos la variable de respuesta en la opcion SALIR ya que despues de eliminarlo no debiese poder hacer nada mas ese usuario
                    System.out.println("**ELIMINADO CON EXITO**");//LE ENTREGAMOS LA CONFIRMACION AL USUARIO    
                    System.out.println("\nENTER PARA CONTINUAR");
                    enter  = Leer.datoInt();
                }                 
                break;    
            case 2://MODIFICA FONO
                
                modificarFono(pos,telefonos);
                //DALE OPCIONES MODIFICAR QUE WEAS DEL USUARIO MENOS EL TELEFONO; TAL VEZ COMPAÑIA , PLAN , RUT, DIRECCION,
                
                break;                
            case 3://MUESTRA CUENTA COMPLETA                                            
            
                telefonos.get(pos).muestraDetalle();
                System.out.println("\nPRESIONE ENTER PARA CONTINUAR");
                enter = Leer.datoInt();
                break;                
            case 4://APLICA SERVICIO TECNICO
                
                telefonos.get(pos).getPlanFono().aplicaServicioTecnico();
                System.out.println("\nPRESIONE ENTER PARA CONTINUAR");
                enter = Leer.datoInt();
                break;
                
            case 5:// VOLVER AL MENU PRINCIPAL
                break;
            default:
                //MENSAJE POR DEFECTO QUE ARROJAREMOS EN CASO DE QUE EL USUARIO SE EQUIVOQUE
                System.out.println("**INGRESE OPCION VALIDA**");
                System.out.println("\nDesea continuar 1 Para SI , cualquier otra tecla para volver al MENU PRINCIPAL");
                rpta = Leer.datoInt();//CONFIRMACION DEL USUARIO

                //SI EL USUARIO DECIDE SEGUIR CON EL MENU NO HACEMOS NADA
                if(rpta==1)                           
                {}
                else//SI NO, seteamos la variable y la ponemos en la opcion VOLVER AL MENU PRINCIPAL
                {
                    rpta = 5;    
                }                              
        }
    }while(rpta==1||rpta!=5);//Mientras respuesta sea SI = 1 O respuesta sea SALIR = 5;
    
}

    public static void modificarFono(int pos, ArrayList<Telefonia> telefonos)
    {
        int rpta;
        
        do{
            menuMoficarDatosFono();
            rpta = Leer.datoInt();//Respuesta del usuario
            // seteamos nuevamente las datos que se vayan a modificar
            switch (rpta)
            {
                case 1:
                    telefonos.get(pos).agregaUsuario();
                    System.out.println("**MODIFICADO CON EXITO**");//LE ENTREGAMOS LA CONFIRMACION AL USUARIO
                    System.out.println("\nPRESIONE ENTER PARA CONTINUAR");
                    enter = Leer.datoInt();
                    break;
                case 2:
                    telefonos.get(pos).agregaCompania();
                    System.out.println("**MODIFICADO CON EXITO**");//LE ENTREGAMOS LA CONFIRMACION AL USUARIO
                    System.out.println("\nPRESIONE ENTER PARA CONTINUAR");
                    enter = Leer.datoInt();
                    break;
                case 3:
                    telefonos.get(pos).agregaPlanFono();
                    telefonos.get(pos).asignarTarifas();
                    System.out.println("**MODIFICADO CON EXITO**");//LE ENTREGAMOS LA CONFIRMACION AL USUARIO
                    System.out.println("\nPRESIONE ENTER PARA CONTINUAR");
                    enter = Leer.datoInt();
                    break;
                case 4:
                break;
                default:
                    //MENSAJE POR DEFECTO QUE ARROJAREMOS EN CASO DE QUE EL USUARIO SE EQUIVOQUE
                    System.out.println("**INGRESE OPCION VALIDA**");
                    System.out.println("\nDesea modificar otra informacion 1 Para SI , cualquier otra tecla para volver al MENU PRINCIPAL");
                    rpta = Leer.datoInt();//CONFIRMACION DEL USUARIO 
                  
                    break;
            }
            
        }while(rpta == 1);
    }
    
    private static void accionMenuRut(String rut, ArrayList<Telefonia> telefonos)
    {
        int rpta = 0;
        int bandera = 0;
        do
        {//Mostramos nuestro menu para telefonos e interactuamos con el mismo;
            muestraMenuRut();
            rpta = Leer.datoInt();//Respuesta del usuario
             
            
            switch (rpta)
            {
            
                case 1://BORRAR TODOS LOS ELEMENTOS ASOCIADOS AL RUT       
                
                    int confirmacion = 0; 
                     
                    System.out.println("\nSE BORRARAN TODOS LOS DATOS ASOCIADOS AL RUT "+rut );
                    System.out.println("1 para CONFIRMAR , presione ENTER para volver al MENU POR RUT");
                    confirmacion = Leer.datoInt();//CONFIRMACION DEL USUARIO
                    
                    //SI EL USUARIO CONFIRMA BORRAR TODOS LOS DATOS RELACIONADOS A ESE RUT
                    if(confirmacion==1)
                    {
                        int pos = 0;
                        
                        do
                        {   //recorreremos el ArrayList de telefonos
                            for (int i = 0; i < telefonos.size(); i++)   
                            {   //Si nuestro recorrido encuentra un rut igual al ingresado por el usuario
                                if(telefonos.get(i).getUsuario().getRunUs().equalsIgnoreCase(rut))
                                {
                                    bandera = 1;//BANDERA ON
                                    pos= i;//Capturamos la posicion en donde se encuentra
                                }
                            }    
                            telefonos.remove(pos);//ELIMINAMOS DESDE AFUERA DEL RECORRIDO YA QUE CADA VEZ QUE SE BORRA CAMBIA EL LARGO DE ESTE
                            
                      }while(bandera ==1&&!telefonos.isEmpty());//MIENTRAS LA BANDERA este en ON y nuestro ArrayList NO ESTE VACIO
                        
                      rpta=3;//Ponemos la variable de respuesta en la opcion SALIR ya que despues de eliminar no debiese poder hacer nada mas ese usuario
                      System.out.println("**ELIMINADO CON EXITO**");//LE ENTREGAMOS LA CONFIRMACION AL USUARIO     
                    
                      System.out.println("\nPRESIONE ENTER PARA CONTINUAR");
                      enter = Leer.datoInt();
                    }
                    
                    break;
                case 2://CUENTA SIMPLE
                    //Recorremos nuestro ArrayList de telefonos
                    for (int i = 0; i < telefonos.size(); i++) 
                    {
                        //Si el rut ingresado por el usuario es el mismo guardado en nuestro ArrayList de telefonos
                        if(telefonos.get(i).getUsuario().getRunUs().equalsIgnoreCase(rut))
                        {
                            //Mostrara el metodo implementado por TELEFONIA de la interface CUENTABLE
                            telefonos.get(i).cuentaSimple();
                            System.out.println("\nPRESIONE ENTER PARA CONTINUAR");
                            enter = Leer.datoInt();
                        }
                    }
                    break;                    
                case 3://VOLVER AL MENU PRINCIPAL                                             

                    break;    
                default:
                    //MENSAJE POR DEFECTO QUE ARROJAREMOS EN CASO DE QUE EL USUARIO SE EQUIVOQUE
                    System.out.println("**INGRESE OPCION VALIDA**");
                    System.out.println("\nDesea continuar 1 Para SI , cualquier otra tecla para volver al MENU PRINCIPAL");
                    rpta = Leer.datoInt();//CONFIRMACION DEL USUARIO                         
                        
                    //SI EL USUARIO DECIDE SEGUIR CON EL MENU NO HACEMOS NADA
                    //SI NO, seteamos la variable y la ponemos en la opcion VOLVER AL MENU PRINCIPAL
                    if(rpta!=1)
                    {
                        rpta = 3;
                    }
                                    
            }   
        }while(rpta==1||rpta!=3);//Mientras respuesta sea SI = 1 O respuesta sea SALIR = 5;
        
    }

}