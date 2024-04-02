package co.edu.uniquindio.notas.modelo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter

public class Nota {
    private String titulo;
    private String categoria;
    private String descripcion;
    private LocalDateTime fechaCreacion;

    public Nota(String titulo, String categoria, String descripcion, LocalDateTime fechaCreacion) {

        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;

    }

    public static class Builder {

        private String titulo;
        private String categoria;
        private String descripcion;
        private LocalDateTime fechaCreacion;

        public Builder(){

        }

        public Builder titulo(String titulo){

            this.titulo = titulo;
            return this;

        }

        public Builder categoria(String categoria){

            this.categoria = categoria;
            return this;

        }

        public Builder descripcion(String descripcion){

            this.descripcion = descripcion;
            return this;

        }

        public Builder fechaCreacion(LocalDateTime fechaCreacion){

            this.fechaCreacion = fechaCreacion;
            return this;

        }

        public Nota build() { return  new Nota( titulo, categoria, descripcion , fechaCreacion ); }

    }

}