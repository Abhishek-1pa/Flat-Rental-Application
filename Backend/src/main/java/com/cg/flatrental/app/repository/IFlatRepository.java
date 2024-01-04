package com.cg.flatrental.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flatrental.app.entity.Flat;



@Repository
public interface IFlatRepository extends JpaRepository<Flat, Integer> {

}
