package com.cg.flatrental.app.service;

import java.util.List;

import com.cg.flatrental.app.entity.Flat;
import com.cg.flatrental.app.exception.FlatNotFoundException;


public interface IFlatService {
	public Flat addFlat(Flat flat);
	public Flat updateFlat(Integer flatId , Flat flat) throws FlatNotFoundException;
	public void deleteFlat(Integer flatId) throws FlatNotFoundException;
	public Flat viewFlatById(Integer flatId) throws FlatNotFoundException;
	public List<Flat> getAllFlats();
	}
