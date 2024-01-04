package com.cg.flatrental.app.service;

import java.util.List;

import com.cg.flatrental.app.entity.Landlord;
import com.cg.flatrental.app.exception.LandlordNotFoundException;


public interface ILandlordService {
	public Landlord addLandlord(Landlord landlord);
	public Landlord updateLandlord(Landlord landlord, int id) throws LandlordNotFoundException;
	public Landlord deleteLandlord(int id) throws LandlordNotFoundException;
	public Landlord viewLandlord(int id) throws LandlordNotFoundException;
	public List<Landlord> viewAllLandlord();
}
