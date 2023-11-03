package com.adrian.memberapi.repository;

import com.adrian.memberapi.model.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepository implements CustomJPARepository<Address, Long>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Address find(Long id) {
        return entityManager.find(Address.class, id);
    }

    @Override
    public List<Address> findAll() {
        return entityManager.createQuery("SELECT a FROM Address a", Address.class).getResultList();
    }

    @Override
    public Address save(Address address) {
        if(address.getId() == null){
            entityManager.persist(address);
        } else {
            entityManager.merge(address);
        }

        return address;
    }

    @Override
    public void delete(Long id) {
        Address address = find(id);
        if(address != null){
            entityManager.remove(address);
        }

    }
}
