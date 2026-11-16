package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name="nome", length = 255, nullable = false)
    String nome;

    @Column (name = "nacionalidade", length = 100, nullable = false)
    String nacionalidade;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Manga> mangas;

    public Autor(int id, String nome, String nacionalidade, List<Manga> mangas) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.mangas = mangas;
    }

    public Autor(){};

    public Autor(String nome, String nacionalidade, List<Manga> mangas) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.mangas = mangas;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public List<Manga> getMangas() {
        return mangas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setMangas(List<Manga> mangas) {
        this.mangas = mangas;

        if (mangas != null){
            for (Manga manga : mangas){
                manga.setAutor(this);
            }
        }
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", mangas=" + mangas +
                '}';
    }
}
