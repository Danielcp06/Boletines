package Boletin61.Ejercicio5;

import java.util.*;

public class Diccionario {
    private Map<String, List<String>> diccionario;

    public Diccionario() {
        diccionario = new HashMap<>();
    }

    public Map<String, List<String>> getDiccionario() {
        return diccionario;
    }

    public List<String> buscarPalabra(String palabra){
        return diccionario.get(palabra);
    }

    public void addPalabra(String palabra, String significado){
        if (diccionario.containsKey(palabra)){
            diccionario.get(palabra).add(significado);
        }else{
            List<String> nuevaLista = new ArrayList<>();
            nuevaLista.add(significado);
            diccionario.put(palabra, nuevaLista);
        }
    }

    public void borrarPalabra(String palabra) {
        diccionario.remove(palabra);
    }

    public List<String> listadoPalabras(String comienzaPor) {
        List<String> palabrasQueEmpizanPor = new LinkedList<>();

        for(String palabra : diccionario.keySet()){
            if (palabra.startsWith(comienzaPor)){
                palabrasQueEmpizanPor.add(palabra);
            }
        }

        palabrasQueEmpizanPor.sort(null);

        return palabrasQueEmpizanPor;
    }
}
