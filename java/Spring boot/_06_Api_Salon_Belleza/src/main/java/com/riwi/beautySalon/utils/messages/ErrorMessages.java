package com.riwi.beautySalon.utils.messages;

public class ErrorMessages {
    
    public static String idNotFound(String entity){

        // return "No hay registro en la entidad "+ entity + "con el id suministrado";

        final String message = "No hay registro en la entidad %s con le id suministrado";

        return String.format(message, entity);
    }
}
