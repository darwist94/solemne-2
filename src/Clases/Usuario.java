package Clases;
/**
 *
 * @author Christian Quiroz M.
 */
public class Usuario {
    
    private String nombreUs;
    private String apellidoUs;
    private String runUs;
    private String fechaNacimiento;
    private String estadoCivil;
    private Integer edad;

    
    //Constructor vacio de la clase Usuario
    public Usuario() {
    }

    //Constructor con parametros de la clase Usuario
    public Usuario(String nombreUs, String apellidoUs, String runUs, String fechaNacimiento, Integer edad, String estadoCivil) {
        this.nombreUs = nombreUs;
        this.apellidoUs = apellidoUs;
        this.runUs = runUs;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
    }
    
    //Getters y Setters de todos los atributos de clase Usuario
    public String getNombreUs() {
        return nombreUs;
    }

    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    public String getApellidoUs() {
        return apellidoUs;
    }

    public void setApellidoUs(String apellidoUs) {
        this.apellidoUs = apellidoUs;
    }

    public String getRunUs() {
        return runUs;
    }

    public void setRunUs(String runUs) {
        this.runUs = runUs;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    public void imprimeUsuario()
    {
        System.out.println(this.nombreUs+"\n"+this.apellidoUs+"\n"+this.runUs+"\n"+this.edad);
    }

   
    
}
