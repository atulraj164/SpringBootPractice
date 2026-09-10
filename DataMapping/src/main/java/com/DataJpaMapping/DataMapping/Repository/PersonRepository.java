package com.DataJpaMapping.DataMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.DataJpaMapping.DataMapping.Entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>{
}
