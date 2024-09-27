package dev.web.mensalidades.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;  
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "jogador")
public class Jogador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cod_jogador;

    @Column(name = "nome", nullable = false, length = 60, unique = true)
    private String nome;

    @Column(name = "emeil", nullable = false, length = 60)
    private String email;

    @Column(name = "datanasc", nullable = false)
    private Date datanasc;

    @JsonManagedReference
    @OneToMany(mappedBy="jogador")
    private List<Pagamento> pagamentos;

    public Jogador() {

    }

    public Jogador(String nome, String email, Date datanasc) {
        this.nome = nome;
        this.email = email;
        this.datanasc = datanasc;
    }

    public long getCod_jogador() {
        return cod_jogador;
    }

    public void setCod_jogador(long cod_jogador) {
        this.cod_jogador = cod_jogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public List<Pagamento> getPagamentos(){
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos){
        this.pagamentos = pagamentos;
    }

    @Override
    public String toString() {
        return "Jogador [cod_jogador=" + cod_jogador + ", datanasc=" + datanasc + ", email=" + email + ", nome=" + nome
                + "]";
    }

}
