/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author João Otavio
 */
@Entity
@Table(name = "local")
@NamedQueries({
    @NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l")})
public class Local implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_local")
    private Integer idLocal;
    @Column(name = "local")
    private String local;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localIdLocal")
    private List<Livro> livroList;

    public Local() {
    }

    public Local(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<Livro> getLivroList() {
        return livroList;
    }

    public void setLivroList(List<Livro> livroList) {
        this.livroList = livroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocal != null ? idLocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.idLocal == null && other.idLocal != null) || (this.idLocal != null && !this.idLocal.equals(other.idLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Local[ idLocal=" + idLocal + " ]";
    }
    
}
