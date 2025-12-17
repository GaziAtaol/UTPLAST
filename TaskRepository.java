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
// TODO: follow the script
    }

    public List<Task> findAll() {
// TODO: follow the script
        EntityManager em = emf.createEntityManager();
        return null;
    }
}