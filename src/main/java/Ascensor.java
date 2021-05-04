import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class Ascensor {
    private final int LIMITE = 1;
    private final Character[] piso = {'0', '0', '0',};

    public String controlAscensor(int pisoActualAscensor, int pisoActualPersona, int limitePersonas,int pisoDestino, String estadoPuerta) throws Exception {
        verificarExcesoPersonas(limitePersonas);
        verificarExcesoPisos(pisoDestino);
        verificarEstadoComienzoDia(pisoActualAscensor,estadoPuerta);
        crearPersona(pisoActualPersona);
        return llamarAscensor(pisoActualPersona,pisoDestino);


    }

    private void crearPersona(int pisoActualPersona) {
        for(int i = 1; i<= piso.length; i++){
            if(i==pisoActualPersona){
                piso[i-1] = '1';
            }
        }
    }
    private String llamarAscensor(int pisoActualPersona,int pisoDestino){
        if(pisoActualPersona==pisoDestino){
            return "No se puede ir al destino";
        }
        return "Se puede ir al destino";

    }

    private void verificarExcesoPisos(int destino) throws Exception {
        if (destino>3) {
            throw new Exception(" esta fuera del rango de pisos");
        }
    }
    private void verificarExcesoPersonas(int destino) throws Exception {
        if (destino>=2) {
            throw new Exception(" esta fuera del rango de personas permitido");
        }
    }
    private void verificarEstadoComienzoDia(int pisoAscensor,String estadoPuerta) throws Exception {
        if (pisoAscensor!=1 && estadoPuerta.equals("Abierto")) {
            throw new Exception(" esta fuera del rango de personas permitido");
        }
    }
}
