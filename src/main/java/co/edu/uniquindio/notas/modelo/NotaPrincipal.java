package co.edu.uniquindio.notas.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class NotaPrincipal {

    private ArrayList<Nota> notas;

    public NotaPrincipal(){

        notas = new ArrayList<>();

    }

    public void agregarNota(String titulo, String descripcion, String categoria, LocalDateTime fechaCreacion) throws Exception {

        if( titulo == null || titulo.isBlank() || descripcion == null || descripcion.isBlank() ||
                categoria == null || categoria.isBlank() || fechaCreacion == null ) {

            throw new Exception("Todos los campos deben estar rellenados.");

        }
        else {
            Nota nuevaNota = new Nota.Builder()
                    .titulo(titulo)
                    .descripcion(descripcion)
                    .categoria(categoria)
                    .fechaCreacion(fechaCreacion)
                    .build();

            notas.add(nuevaNota);
        }
    }

    public ArrayList<Nota> listarNotas() {

        return notas;

    }

}


