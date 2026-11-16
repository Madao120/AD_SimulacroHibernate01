package services;

import config.HibernateConfig;
import model.Autor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AutorService {

    public void crearAutor(Autor autor){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(autor);

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Autor leerAutor(Autor autor){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            return session.get(Autor.class, autor.getId());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public List<Autor> leerAutores(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            return session.createQuery("FROM Autor", Autor.class).list();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public Autor leerAutorNombre(String nome){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            return session.createQuery("FROM Autor WHERE nome = :nome", Autor.class)
                    .setParameter("nome", nome).uniqueResult();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public void actualiazrAutor(int id, Autor nuevoAutor){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Autor autor = session.get(Autor.class, id);

            if (autor != null){
                autor.setNome(nuevoAutor.getNome());
                autor.setNacionalidade(nuevoAutor.getNacionalidade());

                session.update(autor);
                transaction.commit();
            }
            else{
                System.out.println("No se ha completado la operación");
                transaction.rollback();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void borrarAutor(Autor autor){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Autor autorBorrar = session.get(Autor.class, autor.getId());

            if (autorBorrar != null){
                session.delete(autorBorrar);
                transaction.commit();
            }
            else{
                System.out.println("Parece que hubo un error en la operación de borrar autor");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
