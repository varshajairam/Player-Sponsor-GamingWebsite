package edu.sjsu.cmpe275.lab2.dao;


import edu.sjsu.cmpe275.lab2.exception.InvalidSponsorException;
import edu.sjsu.cmpe275.lab2.exception.SponsorNotFoundException;
import edu.sjsu.cmpe275.lab2.model.Address;
import edu.sjsu.cmpe275.lab2.model.Player;
import edu.sjsu.cmpe275.lab2.model.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class SponsorDaoImpl implements SponsorDao {
  
  private EntityManager entityManager;
 
  @Autowired
  public SponsorDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
  @Override
	public Sponsor getSponsorById(Long id) {
		Sponsor sponsor = entityManager.find(Sponsor.class, id);
		if(sponsor == null) throw new SponsorNotFoundException("Sponsor not found");
		return sponsor;
	}

	@Override
	public Sponsor createSponsor(String name, String description, String street,
												 String city, String state, String zip) {
		if(name.isEmpty()) throw new InvalidSponsorException("name cannot be empty");
		Sponsor sponsor=new Sponsor();
		Address address=new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);
		sponsor.setName(name);
		sponsor.setDescription(description);
		sponsor.setAddress(address);
		Sponsor dbSponsor = entityManager.merge(sponsor);

		return dbSponsor;
	}

	@Override
	public Sponsor deleteSponsor(Long id) {
		Sponsor sponsor=entityManager.find(Sponsor.class, id);
		if(sponsor==null) throw new SponsorNotFoundException("Sponsor not found");
		List<Player> sponsoredPlayers=sponsor.getPlayers();
		if (sponsoredPlayers !=null && !sponsoredPlayers.isEmpty()) {
				sponsoredPlayers.forEach((player) -> player.setSponsor(null));
		}
		Query query = entityManager.createQuery("delete from Sponsor where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
		return sponsor;
	}
	
	@Override
	public Sponsor updateSponsor(Long id,String name, String description, String street, String city, String state, String zip) {
		if(name.isEmpty()) throw new InvalidSponsorException("name cannot be empty");
		Sponsor sponsor=entityManager.find(Sponsor.class, id);
		if(sponsor==null) throw new SponsorNotFoundException("Sponsor not found");
		sponsor.setName(name);
		sponsor.setDescription(description);
		Address address=sponsor.getAddress();
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);
		Sponsor dbSponsor=entityManager.merge(sponsor);
		return dbSponsor;
	}
	
	
	



}
