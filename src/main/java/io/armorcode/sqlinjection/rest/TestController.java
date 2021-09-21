package io.armorcode.sqlinjection.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.armorcode.sqlinjection.jpa.TestEntity;
import io.armorcode.sqlinjection.jpa.TestRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

	@Autowired
	TestRepo repo;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void init() {
		TestEntity entity = new TestEntity(1, "TestUser1");
		repo.save(entity);

		TestEntity entity2 = new TestEntity(2, "TestUser2");
		repo.save(entity2);

		repo.flush();
	}

	@RequestMapping("/")
	public String base() {
		return "ok";
	}

	@RequestMapping("/test")
	public List<TestEntity> test(@RequestParam String age, @RequestParam String name, HttpServletRequest request) {

		log.info("/test called with {}, {}", name, age);

		List<TestEntity> list = new ArrayList<>();

		String query = "select * from Test_Entity where name = '" + name + "'";
		System.out.println("Query: " + query);

		jdbcTemplate.query(query, (rs, rowNum) -> new TestEntity(rs.getInt("id"), rs.getString("name")))
				.forEach(entity -> list.add(entity));

		return list;
	}

	@RequestMapping("/health")
	public String health() {
		return new Date().toString();
	}
}
