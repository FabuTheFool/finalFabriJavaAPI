/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.edu.ucom.entities;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "presupuesto_categoria")
@NamedQueries({
    @NamedQuery(name = "PresupuestoCategoria.findAll", query = "SELECT p FROM PresupuestoCategoria p"),
    @NamedQuery(name = "PresupuestoCategoria.findByIdPresupuesto", query = "SELECT p FROM PresupuestoCategoria p WHERE p.presupuestoCategoriaPK.idPresupuesto = :idPresupuesto"),
    @NamedQuery(name = "PresupuestoCategoria.findByIdCategoria", query = "SELECT p FROM PresupuestoCategoria p WHERE p.presupuestoCategoriaPK.idCategoria = :idCategoria"),
    @NamedQuery(name = "PresupuestoCategoria.findByPrevio", query = "SELECT p FROM PresupuestoCategoria p WHERE p.previo = :previo"),
    @NamedQuery(name = "PresupuestoCategoria.findByReal", query = "SELECT p FROM PresupuestoCategoria p WHERE p.real = :real"),
    @NamedQuery(name = "PresupuestoCategoria.findByDiferencia", query = "SELECT p FROM PresupuestoCategoria p WHERE p.diferencia = :diferencia")})
public class PresupuestoCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresupuestoCategoriaPK presupuestoCategoriaPK;
    @Basic(optional = false)
    @Column(name = "previo")
    private int previo;
    @Basic(optional = false)
    @Column(name = "real")
    private int real;
    @Basic(optional = false)
    @Column(name = "diferencia")
    private int diferencia;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categoria categoria;
    @JoinColumn(name = "id_presupuesto", referencedColumnName = "id_presupuesto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PresupuestoMensual presupuestoMensual;

    public PresupuestoCategoria() {
    }

    public PresupuestoCategoria(PresupuestoCategoriaPK presupuestoCategoriaPK) {
        this.presupuestoCategoriaPK = presupuestoCategoriaPK;
    }

    public PresupuestoCategoria(PresupuestoCategoriaPK presupuestoCategoriaPK, int previo, int real, int diferencia) {
        this.presupuestoCategoriaPK = presupuestoCategoriaPK;
        this.previo = previo;
        this.real = real;
        this.diferencia = diferencia;
    }

    public PresupuestoCategoria(int idPresupuesto, int idCategoria) {
        this.presupuestoCategoriaPK = new PresupuestoCategoriaPK(idPresupuesto, idCategoria);
    }

    public PresupuestoCategoriaPK getPresupuestoCategoriaPK() {
        return presupuestoCategoriaPK;
    }

    public void setPresupuestoCategoriaPK(PresupuestoCategoriaPK presupuestoCategoriaPK) {
        this.presupuestoCategoriaPK = presupuestoCategoriaPK;
    }

    public int getPrevio() {
        return previo;
    }

    public void setPrevio(int previo) {
        this.previo = previo;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(int diferencia) {
        this.diferencia = diferencia;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public PresupuestoMensual getPresupuestoMensual() {
        return presupuestoMensual;
    }

    public void setPresupuestoMensual(PresupuestoMensual presupuestoMensual) {
        this.presupuestoMensual = presupuestoMensual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presupuestoCategoriaPK != null ? presupuestoCategoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoCategoria)) {
            return false;
        }
        PresupuestoCategoria other = (PresupuestoCategoria) object;
        if ((this.presupuestoCategoriaPK == null && other.presupuestoCategoriaPK != null) || (this.presupuestoCategoriaPK != null && !this.presupuestoCategoriaPK.equals(other.presupuestoCategoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.ucom.entities.PresupuestoCategoria[ presupuestoCategoriaPK=" + presupuestoCategoriaPK + " ]";
    }
    
}
