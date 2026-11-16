package model;

import javax.persistence.*;

@Entity
@Table(name = "manga")
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "titulo", length = 255, nullable = false)
    private String titulo;

    @Column (name = "xenero", length = 100, nullable = false)
    private String xenero;

    @Column (name = "volumes", length = 100, nullable = false)
    private int volumes;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @OneToOne
    @JoinColumn(name = "edicion_especial_id", nullable = true)
    private EdicionEspecial edicionEspecial;

    public Manga(int id, String titulo, String xenero, int volumes, Autor autor, EdicionEspecial edicionEspecial) {
        this.id = id;
        this.titulo = titulo;
        this.xenero = xenero;
        this.volumes = volumes;
        this.autor = autor;
        this.edicionEspecial = edicionEspecial;
    }

    public Manga(String titulo, String xenero, int volumes, Autor autor, EdicionEspecial edicionEspecial) {
        this.titulo = titulo;
        this.xenero = xenero;
        this.volumes = volumes;
        this.autor = autor;
        this.edicionEspecial = edicionEspecial;
    }

    public Manga() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getXenero() {
        return xenero;
    }

    public void setXenero(String xenero) {
        this.xenero = xenero;
    }

    public int getVolumes() {
        return volumes;
    }

    public void setVolumes(int volumes) {
        this.volumes = volumes;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public EdicionEspecial getEdicionEspecial() {
        return edicionEspecial;
    }

    public void setEdicionEspecial(EdicionEspecial edicionEspecial) {
        this.edicionEspecial = edicionEspecial;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "titulo='" + titulo + '\'' +
                ", id=" + id +
                ", xenero='" + xenero + '\'' +
                ", volumes=" + volumes +
                ", autor=" + autor.getNome() +
                ", edicionEspecial=" + edicionEspecial +
                '}';
    }
}
