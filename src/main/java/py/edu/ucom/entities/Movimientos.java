/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.edu.ucom.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "movimientos")
@NamedQueries({
    @NamedQuery(name = "Movimientos.findAll", query = "SELECT m FROM Movimientos m"),
    @NamedQuery(name = "Movimientos.findByIdMovimiento", query = "SELECT m FROM Movimientos m WHERE m.idMovimiento = :idMovimiento"),
    @NamedQuery(name = "Movimientos.findByFecha", query = "SELECT m FROM Movimientos m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "Movimientos.findByMonto", query = "SELECT m FROM Movimientos m WHERE m.monto = :monto")})
public class Movimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "monto")
    private int monto;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "id_presupuesto", referencedColumnName = "id_presupuesto")
    @ManyToOne(optional = false)
    private PresupuestoMensual idPresupuesto;

    public Movimientos() {
    }

    public Movimientos(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Movimientos(Integer idMovimiento, Date fecha, int monto) {
        this.idMovimiento = idMovimiento;
        this.fecha = fecha;
        this.monto = monto;
    }

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public PresupuestoMensual getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(PresupuestoMensual idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimiento != null ? idMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimientos)) {
            return false;
        }
        Movimientos other = (Movimientos) object;
        if ((this.idMovimiento == null && other.idMovimiento != null) || (this.idMovimiento != null && !this.idMovimiento.equals(other.idMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.ucom.entities.Movimientos[ idMovimiento=" + idMovimiento + " ]";
    }
    
}
