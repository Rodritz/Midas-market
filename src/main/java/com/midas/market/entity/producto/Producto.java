package com.midas.market.entity.producto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Producto")
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String marca;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Double precio;
    private Integer cantidad;
    private Boolean activo;

    public Producto(DatosRegistroProducto datosRegistroProducto) {
        this.activo = true;
        this.nombre = datosRegistroProducto.nombre();
        this.marca = datosRegistroProducto.marca();
        this.categoria = datosRegistroProducto.categoria();
        this.precio = datosRegistroProducto.precio();
        this.cantidad = datosRegistroProducto.cantidad();
    }
}
