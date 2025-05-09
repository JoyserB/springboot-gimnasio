package com.corto2.corto2.data;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; 
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "miembros")
public class Miembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String direccion; 

    @OneToMany(mappedBy = "miembro")
    private List<Membresia> membresias;

    @ManyToMany
    @JoinTable(
        name = "asistencia_clase",
        joinColumns = @JoinColumn(name = "miembro_id"),
        inverseJoinColumns = @JoinColumn(name = "clase_id")
    )
    private List<Clase> clasesAsistidas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Membresia> getMembresias() {
        return membresias;
    }

    public void setMembresias(List<Membresia> membresias) {
        this.membresias = membresias;
    }

    public List<Clase> getClasesAsistidas() {
        return clasesAsistidas;
    }

    public void setClasesAsistidas(List<Clase> clasesAsistidas) {
        this.clasesAsistidas = clasesAsistidas;
    }

    
}


