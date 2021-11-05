package com.adl.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adl.main.model.TitleModel;

public interface TitleRepository extends JpaRepository<TitleModel, Integer>{

}
