package services;

import config.HibernateConfig;
import model.EdicionEspecial;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EdicionService {

    public void crearEdicionEspecial(EdicionEspecial edicionEspecial){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(edicionEspecial);

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public EdicionEspecial leerEdicionEspecial(EdicionEspecial edicionEspecial){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            return session.get(EdicionEspecial.class, edicionEspecial.getId());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public List<EdicionEspecial> leerEdicionEspeciales(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            return session.createQuery("FROM EdicionEspecial", EdicionEspecial.class).list();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public EdicionEspecial leerEdicionEspecialNombre(String nome){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            return session.createQuery("FROM EdicionEspecial WHERE nome = :nome", EdicionEspecial.class)
                    .setParameter("nome", nome).uniqueResult();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public void actualiazrEdicionEspecial(int id, EdicionEspecial nuevoEdicionEspecial){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            EdicionEspecial edicionEspecial = session.get(EdicionEspecial.class, id);

            if (edicionEspecial != null){
                edicionEspecial.setNome(nuevoEdicionEspecial.getNome());
                edicionEspecial.setContidoExtra(nuevoEdicionEspecial.getContidoExtra());

                session.update(edicionEspecial);
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

    public void borrarEdicionEspecial(EdicionEspecial edicionEspecial){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            EdicionEspecial edicionEspecialBorrar = session.get(EdicionEspecial.class, edicionEspecial.getId());

            if (edicionEspecialBorrar != null){
                session.delete(edicionEspecialBorrar);
                transaction.commit();
            }
            else{
                System.out.println("Parece que hubo un error en la operación de borrar edicionEspecial");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

