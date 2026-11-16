import model.Autor;
import model.EdicionEspecial;
import model.Manga;
import services.AutorService;
import services.EdicionService;
import services.MangaService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AutorService aService = new AutorService();
        EdicionService eService = new EdicionService();
        MangaService mService = new MangaService();

        ArrayList<Manga> mangas1 = new ArrayList<>();
        Manga m1 = new Manga();
        Manga m2 = new Manga();

        m1.setTitulo("Kagurabachi");
        m2.setTitulo("Enten");

        mangas1.add(m1);
        mangas1.add(m2);

        Autor autor1 = new Autor("Takeru Hokazono", "Japones", mangas1);

        EdicionEspecial edicion1 = new EdicionEspecial("Primer Tomo", "Descripción del Autor");
        EdicionEspecial edicion2 = new EdicionEspecial("One-shot", "Descripción del proceso creativo");

        m1.setXenero("Shonen");
        m1.setVolumes(12);
        m1.setAutor(autor1);
        m1.setEdicionEspecial(edicion1);

        m2.setXenero("Seinen");
        m2.setVolumes(1);
        m2.setAutor(autor1);
        m2.setEdicionEspecial(edicion2);

        eService.crearEdicionEspecial(edicion1);
        eService.crearEdicionEspecial(edicion2);
        aService.crearAutor(autor1);

        ArrayList<Manga> mangasHokazono = (ArrayList<Manga>) mService.leerMangas();

        for (Manga manga : mangasHokazono) {
            System.out.println(manga);
        }

        mangasHokazono.get(0).setTitulo("Kagurabachi: Parte 1");
        mangasHokazono.get(0).setXenero("Seinen/Shonen");

        mService.actualizarManga(mangasHokazono.get(0).getId(), mangasHokazono.get(0));

        ArrayList<Manga> mangasHokazono2 = (ArrayList<Manga>) mService.leerMangas();

        for (Manga manga : mangasHokazono2) {
            System.out.println(manga);
        }

        autor1.setNome("Takeru el Hokazono");

        aService.actualiazrAutor(autor1.getId(), autor1);

        Autor autorHokazono = aService.leerAutorNombre("Takeru el Hokazono");
        System.out.println(autorHokazono);

        ArrayList<Manga> mangasHokazono3 = (ArrayList<Manga>) mService.leerMangas();

        for (Manga manga : mangasHokazono3) {
            System.out.println(manga);
        }

    }
}

