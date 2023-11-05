package com.adrian.memberapi.repository;

import com.adrian.memberapi.exception.EntityNotFoundException;
import com.adrian.memberapi.exception.EntityPersistenceException;
import com.adrian.memberapi.exception.UserNotFoundException;
import com.adrian.memberapi.model.UserCredentials;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserCredentialsRepository implements CustomJPARepository<UserCredentials, Long> {

    private final EntityManager entityManager;

    @Autowired
    public UserCredentialsRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<UserCredentials> find(Long id) {
        UserCredentials userCredentials = entityManager.find(UserCredentials.class, id);
        return Optional.ofNullable(userCredentials);
    }

    @Override
    public List<UserCredentials> findAll() {
        return null;
    }

    @Override
    public UserCredentials save(UserCredentials userCredentials) {
        try{
            if(userCredentials.getId() == null){
                entityManager.persist(userCredentials);
            } else{
                entityManager.merge(userCredentials);
                System.out.println("Merged credentials");
            }
            return userCredentials;
        } catch (EntityPersistenceException e){
            throw new EntityPersistenceException("Could not persist user credentials: " + e.getMessage());
        }

    }


    @Override
    public void delete(Long id) {
        Optional<UserCredentials> userCredentials = find(id);
        if(userCredentials.isPresent()){
            System.out.println("Removing user");
            entityManager.remove(userCredentials.get());
        } else{
            throw new EntityNotFoundException("User with id: " +  id + " not found");
        }
    }


    public UserCredentials findByUsername(String username) {
        TypedQuery<UserCredentials> query = entityManager.createQuery(
                "SELECT u FROM UserCredentials u WHERE u.username = :username", UserCredentials.class);
        query.setParameter("username", username);
        try {
            return query.getSingleResult();
        } catch (RuntimeException e) {
            throw new UserNotFoundException("User with username: " + username + " not found");
        }
    }
}