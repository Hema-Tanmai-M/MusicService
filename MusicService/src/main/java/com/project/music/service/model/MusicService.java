package com.project.music.service.model;

import java.util.Collection;
import java.util.List;

public class MusicService<Items> {
	
	private List<Music> Items;
	public MusicService<Items>  book;
	@Override
	public String toString() {
		return "MusicService [Items=" + Items + "]";
	}

	public List<Music> getItems() {
		return Items;
	}

	public void setItems(List<Music> items) {
		Items = items;
	}

	public MusicService(List<Music> items) {
		super();
		Items = items;
	}
	
	public MusicService() {
		super();
		
	}

	public MusicService<Items> getItemsbyID() {
		
		return book;
	}

}
