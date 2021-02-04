package com.nonave.sharebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nonave.sharebook.entities.ShareBook;

public interface ShareBookDao extends JpaRepository<ShareBook, Long>{

	
	
}

