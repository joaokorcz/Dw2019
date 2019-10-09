/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author João Otavio
 */
@Entity
@Table(name = "operador")
@NamedQueries({
    @NamedQuery(name = "Operador.findAll", query = "SELECT o FROM Operador o")})
public class Operador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operador")
    private Integer idOperador;
    @Column(name = "senha")
    private String senha;
    @Column(name = "nome")
    private String nome;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;

    public Operador() {
    }

    public Operador(Integer idOperador) {
        this.idOperador = idOperador;
    }

    public Integer getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(Integer idOperador) {
        this.idOperador = idOperador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperador != null ? idOperador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operador)) {
            return false;
        }
        Operador other = (Operador) object;
        if ((this.idOperador == null && other.idOperador != null) || (this.idOperador != null && !this.idOperador.equals(other.idOperador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Operador[ idOperador=" + idOperador + " ]";
    }
    
}
