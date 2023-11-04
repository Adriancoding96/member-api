package com.adrian.memberapi.repository;

import com.adrian.memberapi.exception.EntityNotFoundException;
import com.adrian.memberapi.exception.EntityPersistenceException;
import com.adrian.memberapi.model.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressRepository implements CustomJPARepository<Address, Long>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Address> find(Long id) {
        Address address = entityManager.find(Address.class, id);
        return Optional.ofNullable(address);
    }

    @Override
    public List<Address> findAll() {
        return entityManager.createQuery("SELECT a FROM Address a", Address.class).getResultList();
    }

    @Override
    public Address save(Address address) {
        try{
            if(address.getId() == null){
                entityManager.persist(address);
            } else {
                entityManager.merge(address);
            }
            return address;
        } catch (EntityPersistenceException e){
            throw new EntityPersistenceException("Could not persist address: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Address> address = find(id);
        if (address.isPresent()){
            entityManager.remove(address.get());
        } else{
            throw new EntityNotFoundException("Address with id: " + id + " not found");
        }


    }
}
