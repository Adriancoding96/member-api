package com.adrian.memberapi.repository;

import com.adrian.memberapi.model.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
        if(address.getId() == null){
            entityManager.persist(address);
        } else {
            entityManager.merge(address);
        }

        return address;
    }

    @Override
    public void delete(Long id) {
        Optional<Address> address = find(id);
        address.ifPresent(value -> entityManager.remove(value));

    }
}
