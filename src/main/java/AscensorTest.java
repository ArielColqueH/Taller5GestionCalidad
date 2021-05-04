
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
public class AscensorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void capacidad() throws Exception{

        //Preparacion de la prueba
        Ascensor asc = new Ascensor();

        //logica de la prueba
        asc.controlAscensor(1,1,1,3,"Abierto");
        exception.expect(Exception.class);
        asc.controlAscensor(1,1,2,3,"Abierto");
        asc.controlAscensor(1,1,3,3,"Abierto");


    }

    @Test
    public void verificarEstadoDePuertaComienzoDia() throws Exception{

        //Preparacion de la prueba
        Ascensor asc = new Ascensor();

        //logica de la prueba
        asc.controlAscensor(1,1,1,3,"Cerrado");
        exception.expect(Exception.class);
        asc.controlAscensor(2,1,5,3,"Abierto");
        asc.controlAscensor(3,1,2,3,"Abierto");
    }

    @Test
    public void destinoDistintoAPisoActual() throws Exception{

        //Preparacion de la prueba
        Ascensor asc = new Ascensor();

        //logica de la prueba
        String prueba1 = asc.controlAscensor(1,1,1,3,"Abierto");
        String prueba2 = asc.controlAscensor(1,1,1,2,"Abierto");
        String prueba3 = asc.controlAscensor(1,1,1,1,"Abierto");

        //Verificacion o Assert
        assertEquals("Se puede ir al destino", prueba1);
        assertEquals("Se puede ir al destino", prueba2);
        assertEquals("No se puede ir al destino", prueba3);

    }

    @Test
    public void verificarExistenciaPisoLanzarExcepcion() throws Exception{

        //Preparacion de la prueba
        Ascensor asc = new Ascensor();

        //logica de la prueba
        exception.expect(Exception.class);
        asc.controlAscensor(1,1,1,5,"Abierto");

    }


}
