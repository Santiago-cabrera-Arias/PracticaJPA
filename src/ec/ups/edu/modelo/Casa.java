/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author santi
 */
@Entity
public class Casa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String ubicacion;
    @Column
    private String callePrimaria;
    @Column
    private String calleSecundaria;
    @Column
    private String numeroPisos;
    @Column
    private double valorCasa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCallePrimaria() {
        return callePrimaria;
    }

    public void setCallePrimaria(String callePrimaria) {
        this.callePrimaria = callePrimaria;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(String numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    public double getValorCasa() {
        return valorCasa;
    }

    public void setValorCasa(double valorCasa) {
        this.valorCasa = valorCasa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Casa other = (Casa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Casa{" + "id=" + id + ", ubicacion=" + ubicacion + ", callePrimaria=" + callePrimaria + ", calleSecundaria=" + calleSecundaria + ", numeroPisos=" + numeroPisos + ", valorCasa=" + valorCasa + '}';
    }

}
