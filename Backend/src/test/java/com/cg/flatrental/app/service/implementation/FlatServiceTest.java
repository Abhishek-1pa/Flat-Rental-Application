//package com.cg.flatrental.app.service.implementation;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.doNothing;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.cg.flatrental.app.entity.Flat;
//import com.cg.flatrental.app.entity.FlatAddress;
//import com.cg.flatrental.app.entity.Landlord;
//import com.cg.flatrental.app.repository.IFlatRepository;
//
//
//
//@ExtendWith(MockitoExtension.class)
//public class FlatServiceTest {
//	
//	
//	@InjectMocks
//	private IFlatServiceImplementation iFlatService;
//	
//	@Mock
//	private IFlatRepository iFlatRepository;
//	
//	
//	@Test
//	void testViewAllFlats() {
//		
//		List<Flat> flats = getFlatsMockData();		
//		Mockito.when(iFlatRepository.findAll()).thenReturn(flats);
//		
//		List<Flat> flatInfo = iFlatService.viewAllFlat();
//		
//		assertThat(flatInfo.size() == flats.size());
//		assertThat(flatInfo.get(0).getCost().equals(1000.00D));
//		assertThat(flatInfo.get(0).getAvailability().equalsIgnoreCase("yes"));
//	}
//	
//	@Test
//	void testGetFlat() {
//		
//		Long flatId = 1744L;
//		
//		Optional<Flat> flatOpt = getFlatMockData();
//		
//		Mockito.when(iFlatRepository.findById(flatId)).thenReturn(flatOpt);
//		
//		Flat flat = iFlatService.viewFlat(flatId);
//		
//		assertThat(flat.getFlatId().equals(1744L));
//		assertThat(flat.getCost().equals(1000.00D));
//		assertThat(flat.getAvailability().equalsIgnoreCase("yes"));
//	}
//	
//	@Test
//	void testAddFlat() {
//		
//		Optional<Flat> flatOpt = getFlatMockData();
//		Flat flat = flatOpt.get();
//		Mockito.when(iFlatRepository.save(flat)).thenReturn(flat);
//		
//		Flat emp = iFlatService.addFlat(flat);
//		
//		assertThat(flat.getFlatId().equals(1744L));
//		assertThat(flat.getCost().equals(1000.00D));
//		assertThat(flat.getAvailability().equalsIgnoreCase("yes"));
//		
//	}
//	
//	@Test
//	void testUpdateFlat() {
//		
//		Long flatId = 1744L;
//		Optional<Flat> flatOpt = getFlatMockData();
//		Flat flat = flatOpt.get();
//		Mockito.when(iFlatRepository.findById(flatId)).thenReturn(flatOpt);
//		Mockito.when(iFlatRepository.save(flat)).thenReturn(flat);
//		
//		Flat updatedFlat = iFlatService.updateFlat(flat, flatId);
//		
//		assertThat(flat.getCost().equals(updatedFlat.getCost()));
//		assertThat(flat.getAvailability().equals(updatedFlat.getAvailability()));
//		
//	}
//	
//	@Test
//	void testDeleteFlat() {
//		
//		Long flatId = 1744L;
//		Optional<Flat> flatOpt = getFlatMockData();
//		Flat flat = flatOpt.get();
//		Mockito.when(iFlatRepository.findById(flatId)).thenReturn(flatOpt);
//		doNothing().when(iFlatRepository).deleteById(flatId);
//	
//		iFlatService.deleteFlat(flatId);
//		
//		assertThat(flat.getCost().equals(1000.00D));
//		assertThat(flat.getAvailability().equalsIgnoreCase("yes"));
//		
//	}	
//	
//	
//	private List<Flat> getFlatsMockData(){
//		List<Flat> flats = new ArrayList<>();
//		Flat flat1 = new Flat(1744L, 1000.00D, new FlatAddress(), "yes",  new Landlord());
//		Flat flat2 = new Flat(1685L, 1200.00D, new FlatAddress(), "yes",  new Landlord());
//		Flat flat3 = new Flat(1727L, 1400.00D, new FlatAddress(), "yes",  new  Landlord());
//		flats.add(flat1);
//		flats.add(flat2);
//		flats.add(flat3);
//		return flats;
//	}
//	
//	private Optional<Flat> getFlatMockData(){
//		Flat flat = new Flat(1744L, 1000.00D, new FlatAddress(), "yes",  new Landlord());
//		return Optional.of(flat);
//	}
//	
//
//}
//
