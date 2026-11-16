package services;

import config.HibernateConfig;
import model.Manga;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MangaService {

    public void crearManga(Manga manga){
        try (Session session =
                     HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(manga);

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Manga leerManga(int id){
        try (Session session =
                     HibernateConfig.getSessionFactory().openSession()) {

            return session.get(Manga.class, id);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public Manga leerMangaNome (String titulo){
        try (Session session =
                     HibernateConfig.getSessionFactory().openSession()) {

            return session.createQuery("FROM Manga WHERE titulo = :titulo", Manga.class)
                    .setParameter("titulo", titulo).uniqueResult();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public List<Manga> leerMangas (){
        try (Session session =
                     HibernateConfig.getSessionFactory().openSession()) {

            return session.createQuery("FROM Manga", Manga.class).list();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public void actualizarManga(int id, Manga manga_nuevo){
        try (Session session =
                     HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Manga manga = session.get(Manga.class, id);

            if (manga != null){

                manga.setTitulo(manga_nuevo.getTitulo());
                manga.setXenero(manga_nuevo.getXenero());
                manga.setVolumes(manga_nuevo.getVolumes());
                manga.setEdicionEspecial(manga_nuevo.getEdicionEspecial());
                manga.setAutor(manga_nuevo.getAutor());

                session.update(manga);
                transaction.commit();
            }
            else{
                transaction.rollback();
                System.out.println("Parece que no se ha podido realizar la actualización");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void borrarManga (int id){
        try (Session session =
                     HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Manga manga = session.get(Manga.class, id);

            if (manga != null){
                session.delete(manga);
                transaction.commit();
            }
            else {
                transaction.rollback();
                System.out.println("No se ha podido realizar el borrado");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
