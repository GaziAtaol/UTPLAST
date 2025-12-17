package repository;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.metamodel.Metamodel;
import logic.Task;
import java.util.List;
import java.util.Map;

public class TaskRepository {
    
    private static final EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("pjUniTest");
    
    // ==================== CRUD Operations ====================
    public Task save(Task task) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(task);
            em.getTransaction().commit();

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                throw new RuntimeException();
            }
        }
        finally{em.close();}
        
        return task;
    }

    public void delete(Task task) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            
            Task managed = em.find(Task.class, task.getId());
            
            if (managed != null) {
                em.remove(managed);
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error deleting task", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Task> findAll() {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            TypedQuery<Task> query = em.createQuery("SELECT t FROM Task t ORDER BY t.id", Task.class);
            return query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}