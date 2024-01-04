//package com.cg.flatrental.app.service.implementation;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.doNothing;
//
//import java.time.LocalDate;
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
//import com.cg.flatrental.app.entity.FlatBooking;
//import com.cg.flatrental.app.entity.Landlord;
//import com.cg.flatrental.app.entity.Tenant;
//import com.cg.flatrental.app.repository.IFlatBookingRepository;
//
//
//@ExtendWith(MockitoExtension.class)
//public class FlatBookingServiceTest {
//	
//	
//	@InjectMocks
//	private IFlatBookingServiceImplementation iFlatBookingService;
//	
//	@Mock
//	private IFlatBookingRepository iFlatBookingRepository;
//	
//	
//	@Test
//	void testViewAllFlatBookings() {
//		
//		List<FlatBooking> flatBookings = getFlatBookingsMockData();		
//		Mockito.when(iFlatBookingRepository.findAll()).thenReturn(flatBookings);
//		
//		List<FlatBooking> flatBookingInfo = iFlatBookingService.viewFlatBooking();
//		
//		assertThat(flatBookingInfo.size() == flatBookings.size());
//		assertThat(flatBookingInfo.get(0).getBookingNo().equals(1744L));
//		assertThat(flatBookingInfo.get(0).getFlat().equals(new Flat(1745L, 1000.00D, new FlatAddress(), "yes",  new Landlord())));
//	}
//	
//	@Test
//	void testGetFlatBooking() {
//		
//		Long flatBookingId = 1744L;
//		
//		Optional<FlatBooking> flatBookingOpt = getFlatBookingMockData();
//		
//		Mockito.when(iFlatBookingRepository.findById(flatBookingId)).thenReturn(flatBookingOpt);
//		
//		FlatBooking flatBooking = iFlatBookingService.viewFlatBooking(flatBookingId);
//		
//		assertThat(flatBooking.getBookingNo().equals(1744L));
//		assertThat(flatBooking.getFlat().equals(new Flat(1745L, 1000.00D, new FlatAddress(), "yes",  new Landlord())));
//	}
//	
//	@Test
//	void testAddFlatBooking() {
//		
//		Optional<FlatBooking> flatBookingOpt = getFlatBookingMockData();
//		FlatBooking flatBooking = flatBookingOpt.get();
//		Mockito.when(iFlatBookingRepository.save(flatBooking)).thenReturn(flatBooking);
//		
//		FlatBooking emp = iFlatBookingService.addFlatBooking(flatBooking);
//		assertThat(flatBooking.getBookingNo().equals(1744L));
//		assertThat(flatBooking.getFlat().equals(new Flat(1745L, 1000.00D, new FlatAddress(), "yes",  new Landlord())));
//		
//	}
//	
//	@Test
//	void testUpdateFlatBooking() {
//		
//		Long flatBookingId = 1744L;
//		Optional<FlatBooking> flatBookingOpt = getFlatBookingMockData();
//		FlatBooking flatBooking = flatBookingOpt.get();
//		Mockito.when(iFlatBookingRepository.findById(flatBookingId)).thenReturn(flatBookingOpt);
//		Mockito.when(iFlatBookingRepository.save(flatBooking)).thenReturn(flatBooking);
//		
//		FlatBooking updatedFlatBooking = iFlatBookingService.updateFlatBooking(flatBooking, flatBookingId);
//		
//		assertThat(flatBooking.getBookingNo().equals(updatedFlatBooking.getBookingNo()));
//		assertThat(flatBooking.getFlat().equals(updatedFlatBooking.getFlat()));
//		
//	}
//	
//	@Test
//	void testDeleteFlatBooking() {
//		
//		Long flatBookingId = 1744L;
//		Optional<FlatBooking> flatBookingOpt = getFlatBookingMockData();
//		FlatBooking flatBooking = flatBookingOpt.get();
//		Mockito.when(iFlatBookingRepository.findById(flatBookingId)).thenReturn(flatBookingOpt);
//		doNothing().when(iFlatBookingRepository).deleteById(flatBookingId);
//	
//		iFlatBookingService.deleteFlatBooking(flatBookingId);
//		
//		assertThat(flatBooking.getBookingNo().equals(1744L));
//		assertThat(flatBooking.getFlat().equals(new Flat(1745L, 1000.00D, new FlatAddress(), "yes",  new Landlord())));
//		
//	}	
//	
//	
//	private List<FlatBooking> getFlatBookingsMockData(){
//		List<FlatBooking> flatBookings = new ArrayList<>();
//		Flat flat1 = new Flat(1745L, 1000.00D, new FlatAddress(), "yes",  new Landlord());
//		Flat flat2 = new Flat(1685L, 1200.00D, new FlatAddress(), "yes",  new Landlord());
//		Flat flat3 = new Flat(1727L, 1400.00D, new FlatAddress(), "yes",  new  Landlord());
//		Tenant tenant1= new Tenant(1445L, 45, "Abhishek");
//		Tenant tenant2= new Tenant(1446L, 100, "Shivam");
//		Tenant tenant3= new Tenant(1447L, 19, "Peddi");
//		FlatBooking flatBooking1 = new FlatBooking(1744L, flat1, tenant1, LocalDate.of(2022,01,02),LocalDate.of(2023,01,02));
//		FlatBooking flatBooking2 = new FlatBooking(1685L, flat2, tenant2, LocalDate.of(2022,01,02),LocalDate.of(2023,01,02));
//		FlatBooking flatBooking3 = new FlatBooking(1727L, flat3, tenant3, LocalDate.of(2022,01,02),LocalDate.of(2023,01,02));
//		flatBookings.add(flatBooking1);
//		flatBookings.add(flatBooking2);
//		flatBookings.add(flatBooking3);
//		return flatBookings;
//	}
//	
//	private Optional<FlatBooking> getFlatBookingMockData(){
//		Flat flat = new Flat(1745L, 1000.00D, new FlatAddress(), "yes",  new Landlord());
//		Tenant tenant= new Tenant(1445L, 45, "Abhishek");
//		FlatBooking flatBooking = new FlatBooking(1744L, flat, tenant, LocalDate.of(2022,01,02),LocalDate.of(2023,01,02));
//		return Optional.of(flatBooking);
//	}
//	
//
//}
//
//
