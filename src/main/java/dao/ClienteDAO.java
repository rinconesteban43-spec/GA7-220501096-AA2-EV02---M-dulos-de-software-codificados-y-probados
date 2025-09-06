/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Cliente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil; // Clase que crea el SessionFactory

public class ClienteDAO {

    // Crear o guardar cliente
    public boolean guardarCliente(Cliente cliente) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(cliente);
            tx.commit();
            System.out.println("✅ Cliente guardado correctamente");
            return true;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // Listar todos los clientes
    public List<Cliente> listarClientes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Cliente", Cliente.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar cliente por id
    public Cliente buscarClientePorId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Cliente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Actualizar cliente
    public boolean actualizarCliente(Cliente cliente) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(cliente);
            tx.commit();
            System.out.println("✅ Cliente actualizado correctamente");
            return true;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar cliente
    public boolean eliminarCliente(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Cliente cliente = session.get(Cliente.class, id);
            if (cliente == null) {
                System.out.println("⚠ Cliente no encontrado");
                return false;
            }
            tx = session.beginTransaction();
            session.delete(cliente);
            tx.commit();
            System.out.println("✅ Cliente eliminado correctamente");
            return true;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}