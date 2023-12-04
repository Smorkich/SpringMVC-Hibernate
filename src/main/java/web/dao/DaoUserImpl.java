package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;
@Repository
public class DaoUserImpl implements DaoUser {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getUsers() {
        String sql = "SELECT u FROM Users u";
        return entityManager.createQuery(sql, User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        User user1 = new User(user.getName(), user.getLastName(), user.getEmail());
        entityManager.persist(user1);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class,id);
    }
}
