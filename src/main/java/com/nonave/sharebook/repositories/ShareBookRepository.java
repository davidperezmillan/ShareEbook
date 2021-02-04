package com.nonave.sharebook.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.nonave.sharebook.entities.ShareBook;


@Repository
public class ShareBookRepository 
{
	
    private static List<ShareBook> list = new ArrayList<ShareBook>();
    
    static
    {
        list.add(new ShareBook());
        list.add(new ShareBook());
        list.add(new ShareBook());
    }
    

	public List<ShareBook> findAll(){
		return list;
	}

	public Optional<ShareBook> findById(long id) {
		for (ShareBook sharebook : list) {
			if (sharebook.getId() == id)
				return Optional.of(sharebook);
		}
		return Optional.empty();
	}

	
	public void save(ShareBook sharebook) {
		list.add(sharebook);
	}

	public boolean delete(long id) {
		boolean okko = Boolean.FALSE;
		for (ShareBook sharebook : list) {
			if (sharebook.getId() == id) {
				list.remove(sharebook);
				okko = true;
			}
		}
		return okko;
	}
	
}
