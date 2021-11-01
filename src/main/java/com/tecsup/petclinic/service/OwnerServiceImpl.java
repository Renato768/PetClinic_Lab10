package com.tecsup.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.domain.OwnerRepository;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

public class OwnerServiceImpl implements OwnerService{
	private static final Logger logger = LoggerFactory.getLogger(PetServiceImpl.class);

	@Autowired
	OwnerRepository ownerRepository;
	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner create(Owner owner) {
		return ownerRepository.save(owner);
	}
	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner update(Owner owner) {
		return ownerRepository.save(owner);
	}
	/**
	 * 
	 * @param id
	 * @throws OwnerNotFoundException
	 */
	@Override
	public void delete(Long id) throws OwnerNotFoundException {
		Owner owner = findById(id);
		ownerRepository.delete(owner);
		
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Owner findById(long id) throws OwnerNotFoundException {
		Optional<Owner> owner=ownerRepository.findById(id);
		if(!owner.isPresent())
			throw new OwnerNotFoundException("Record no found...");
		return owner.get();
	}

	@Override
	public List<Owner> findByFirstName(String first_name) {
		List<Owner> owners = ownerRepository.findByFirstName(first_name);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}

	@Override
	public List<Owner> findByLastName(String last_name) {
		List<Owner> owners = ownerRepository.findByLastName(last_name);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}
	
	
	@Override
	public List<Owner> findByAddress(String address) {
		List<Owner> owners = ownerRepository.findByAddress(address);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}
	
	@Override
	public List<Owner> findByCity(String city) {
		List<Owner> owners = ownerRepository.findByCity(city);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}
	
	@Override
	public List<Owner> findByTelephone(String telephone) {
		List<Owner> owners = ownerRepository.findByTelephone(telephone);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}

	@Override
	public Iterable<Owner> findAll() {
		// TODO Auto-generated method stub
		return ownerRepository.findAll();
	}

}