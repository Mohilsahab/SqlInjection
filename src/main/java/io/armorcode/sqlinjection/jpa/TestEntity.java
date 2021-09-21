package io.armorcode.sqlinjection.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestEntity {

	@Id
	Integer id;
	
	String name;
	
}
