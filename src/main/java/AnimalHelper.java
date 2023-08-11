import entity.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

public class AnimalHelper {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public AnimalHelper() {

    }
    public List<Animal> getAnimalList() {
        Session session = this.sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Animal.class);
        Root<Animal> root = cq.from(Animal.class);
        Selection[] selections = new Selection[]{root.get("id"), root.get("age"),root.get("name"),root.get("tail")};
        cq.select(cb.construct(Animal.class, selections)).where(cb.like(root.get("name"), "%Push%"));
        Query query = session.createQuery(cq);
        List<Animal> animalList = query.getResultList();
        session.close();
        return animalList;
    }

    public Animal getAnimalById(long id) {
        Session session = this.sessionFactory.openSession();
        Animal author = (Animal)session.get(Animal.class, id);
        session.close();
        return author;
    }

    public Animal addAnimal(Animal animal) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(animal);
        session.getTransaction().commit();
        session.close();
        return animal;
    }
}
