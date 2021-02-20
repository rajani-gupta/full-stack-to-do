package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Detail;

public interface PersonRepository extends JpaRepository<Detail, String> {
	@Query(" select d from Detail d where d.username like %:name% or d.gender like %:name% or d.age like %:name% or d.hobby like %:name%")
	List<Detail> findByusername(@Param("name") String name);
	

}
