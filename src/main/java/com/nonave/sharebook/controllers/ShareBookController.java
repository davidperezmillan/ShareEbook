package com.nonave.sharebook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nonave.sharebook.entities.ShareBook;
import com.nonave.sharebook.repositories.ShareBookDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/sharebook")
public class ShareBookController {

	@Autowired
	private ShareBookDao shareBookDao;

	@GetMapping
	public ResponseEntity<List<ShareBook>> getShareInfos() {
		log.debug("find all Comment");
		return ResponseEntity.ok(shareBookDao.findAll());
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<ShareBook> getShareById(@PathVariable("id") Long id) {
		Optional<ShareBook> optionalShareBook = shareBookDao.findById(id);
		return (optionalShareBook.isPresent()) ? ResponseEntity.ok(optionalShareBook.get())
				: ResponseEntity.noContent().build();

	}

	@PostMapping
	public ResponseEntity<ShareBook> createShare(@RequestBody ShareBook sharebook) {
		
//		Object document;
//		ByteArrayInputStream bais = new ByteArrayInputStream();
//		sharebook.setContent();
		
		sharebook.setStatus(Boolean.TRUE);
		shareBookDao.save(sharebook);
		return ResponseEntity.ok().build();
	}

	// TODO bug no content
	@DeleteMapping(value = "{id}")
	public ResponseEntity<ShareBook> deleteShare(@PathVariable("id") Long id) {
		shareBookDao.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PatchMapping(value = "{id}")
	public ResponseEntity<ShareBook> updateStatusShare(@PathVariable("id") Long id) {
		Optional<ShareBook> optionalShareBook = shareBookDao.findById(id);
		if (optionalShareBook.isPresent()) {
			ShareBook sharebook = optionalShareBook.get();
			sharebook.setStatus(Boolean.FALSE);
			shareBookDao.save(sharebook);
			return ResponseEntity.ok(sharebook);
		}else {
			return ResponseEntity.noContent().build();
		}
	}

}
