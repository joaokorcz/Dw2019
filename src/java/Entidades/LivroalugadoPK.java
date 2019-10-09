/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author João Otavio
 */
@Embeddable
public class LivroalugadoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Usuario_id_usuario")
    private int usuarioidusuario;
    @Basic(optional = false)
    @Column(name = "Livro_id_livro")
    private int livroidlivro;

    public LivroalugadoPK() {
    }

    public LivroalugadoPK(int usuarioidusuario, int livroidlivro) {
        this.usuarioidusuario = usuarioidusuario;
        this.livroidlivro = livroidlivro;
    }

    public int getUsuarioidusuario() {
        return usuarioidusuario;
    }

    public void setUsuarioidusuario(int usuarioidusuario) {
        this.usuarioidusuario = usuarioidusuario;
    }

    public int getLivroidlivro() {
        return livroidlivro;
    }

    public void setLivroidlivro(int livroidlivro) {
        this.livroidlivro = livroidlivro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioidusuario;
        hash += (int) livroidlivro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LivroalugadoPK)) {
            return false;
        }
        LivroalugadoPK other = (LivroalugadoPK) object;
        if (this.usuarioidusuario != other.usuarioidusuario) {
            return false;
        }
        if (this.livroidlivro != other.livroidlivro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.LivroalugadoPK[ usuarioidusuario=" + usuarioidusuario + ", livroidlivro=" + livroidlivro + " ]";
    }
    
}
