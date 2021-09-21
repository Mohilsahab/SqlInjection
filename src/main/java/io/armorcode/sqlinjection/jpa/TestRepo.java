package io.armorcode.sqlinjection.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<TestEntity, Integer>{

}
