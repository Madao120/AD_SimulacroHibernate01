package model;

import javax.persistence.*;

@Entity
@Table(name = "edicion_especial")
public class EdicionEspecial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name="contido_extra", length = 255, nullable = false)
    private String contidoExtra;

    public EdicionEspecial(int id, String nome, String contidoExtra) {
        this.id = id;
        this.nome = nome;
        this.contidoExtra = contidoExtra;
    }

    public EdicionEspecial(String nome, String contidoExtra) {
        this.nome = nome;
        this.contidoExtra = contidoExtra;
    }

    public EdicionEspecial() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContidoExtra() {
        return contidoExtra;
    }

    public void setContidoExtra(String contidoExtra) {
        this.contidoExtra = contidoExtra;
    }

    @Override
    public String toString() {
        return "EdicionEspecial{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", contidoExtra='" + contidoExtra + '\'' +
                '}';
    }
}
