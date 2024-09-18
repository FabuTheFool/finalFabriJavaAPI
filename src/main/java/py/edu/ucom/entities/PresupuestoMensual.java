/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.edu.ucom.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "presupuesto_mensual")
@NamedQueries({
    @NamedQuery(name = "PresupuestoMensual.findAll", query = "SELECT p FROM PresupuestoMensual p"),
    @NamedQuery(name = "PresupuestoMensual.findByIdPresupuesto", query = "SELECT p FROM PresupuestoMensual p WHERE p.idPresupuesto = :idPresupuesto"),
    @NamedQuery(name = "PresupuestoMensual.findByFechaIncio", query = "SELECT p FROM PresupuestoMensual p WHERE p.fechaIncio = :fechaIncio"),
    @NamedQuery(name = "PresupuestoMensual.findByFechaFin", query = "SELECT p FROM PresupuestoMensual p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "PresupuestoMensual.findBySaldoInicial", query = "SELECT p FROM PresupuestoMensual p WHERE p.saldoInicial = :saldoInicial"),
    @NamedQuery(name = "PresupuestoMensual.findBySaldoFinal", query = "SELECT p FROM PresupuestoMensual p WHERE p.saldoFinal = :saldoFinal"),
    @NamedQuery(name = "PresupuestoMensual.findByEstado", query = "SELECT p FROM PresupuestoMensual p WHERE p.estado = :estado")})
public class PresupuestoMensual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_presupuesto")
    private Integer idPresupuesto;
    @Basic(optional = false)
    @Column(name = "fecha_incio")
    @Temporal(TemporalType.DATE)
    private Date fechaIncio;
    @Basic(optional = false)
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "saldo_inicial")
    private int saldoInicial;
    @Basic(optional = false)
    @Column(name = "saldo_final")
    private int saldoFinal;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "presupuestoMensual")
    private List<PresupuestoCategoria> presupuestoCategoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPresupuesto")
    private List<Movimientos> movimientosList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    public PresupuestoMensual() {
    }

    public PresupuestoMensual(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public PresupuestoMensual(Integer idPresupuesto, Date fechaIncio, Date fechaFin, int saldoInicial, int saldoFinal, String estado) {
        this.idPresupuesto = idPresupuesto;
        this.fechaIncio = fechaIncio;
        this.fechaFin = fechaFin;
        this.saldoInicial = saldoInicial;
        this.saldoFinal = saldoFinal;
        this.estado = estado;
    }

    public Integer getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Date getFechaIncio() {
        return fechaIncio;
    }

    public void setFechaIncio(Date fechaIncio) {
        this.fechaIncio = fechaIncio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(int saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public int getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(int saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<PresupuestoCategoria> getPresupuestoCategoriaList() {
        return presupuestoCategoriaList;
    }

    public void setPresupuestoCategoriaList(List<PresupuestoCategoria> presupuestoCategoriaList) {
        this.presupuestoCategoriaList = presupuestoCategoriaList;
    }

    public List<Movimientos> getMovimientosList() {
        return movimientosList;
    }

    public void setMovimientosList(List<Movimientos> movimientosList) {
        this.movimientosList = movimientosList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresupuesto != null ? idPresupuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoMensual)) {
            return false;
        }
        PresupuestoMensual other = (PresupuestoMensual) object;
        if ((this.idPresupuesto == null && other.idPresupuesto != null) || (this.idPresupuesto != null && !this.idPresupuesto.equals(other.idPresupuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.edu.ucom.entities.PresupuestoMensual[ idPresupuesto=" + idPresupuesto + " ]";
    }
    
}
