/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author João Otavio
 */
@Entity
@Table(name = "livroalugado")
@NamedQueries({
    @NamedQuery(name = "Livroalugado.findAll", query = "SELECT l FROM Livroalugado l")})
public class Livroalugado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LivroalugadoPK livroalugadoPK;
    @Column(name = "dataEmp")
    @Temporal(TemporalType.DATE)
    private Date dataEmp;
    @Column(name = "dataDev")
    @Temporal(TemporalType.DATE)
    private Date dataDev;
    @JoinColumn(name = "Livro_id_livro", referencedColumnName = "id_livro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Livro livro;
    @JoinColumn(name = "Usuario_id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Livroalugado() {
    }

    public Livroalugado(LivroalugadoPK livroalugadoPK) {
        this.livroalugadoPK = livroalugadoPK;
    }

    public Livroalugado(int usuarioidusuario, int livroidlivro) {
        this.livroalugadoPK = new LivroalugadoPK(usuarioidusuario, livroidlivro);
    }

    public LivroalugadoPK getLivroalugadoPK() {
        return livroalugadoPK;
    }

    public void setLivroalugadoPK(LivroalugadoPK livroalugadoPK) {
        this.livroalugadoPK = livroalugadoPK;
    }

    public Date getDataEmp() {
        return dataEmp;
    }

    public void setDataEmp(Date dataEmp) {
        this.dataEmp = dataEmp;
    }

    public Date getDataDev() {
        return dataDev;
    }

    public void setDataDev(Date dataDev) {
        this.dataDev = dataDev;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (livroalugadoPK != null ? livroalugadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livroalugado)) {
            return false;
        }
        Livroalugado other = (Livroalugado) object;
        if ((this.livroalugadoPK == null && other.livroalugadoPK != null) || (this.livroalugadoPK != null && !this.livroalugadoPK.equals(other.livroalugadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Livroalugado[ livroalugadoPK=" + livroalugadoPK + " ]";
    }
    
}
