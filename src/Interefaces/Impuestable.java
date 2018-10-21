
package Interefaces;

/**
 *
 * @author Christian Quiroz M.
 */
public interface Impuestable {

    //atributos estaticos de la interface Impuestable
    int impNormal = 13;//Porcentaje
    int impEsp = 19;//%
    
    //Metodos de la interfaceImpuestable
    public long impuestoAplicado();
    public long pagoPorMinutosUsados();
    public long totalPagar();
    public long descuento();
}