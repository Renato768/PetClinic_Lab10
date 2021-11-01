package com.tecsup.petclinic.service;

import java.util.List;
import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

/**
 * 
 * @author 
 *
 */
public interface OwnerService {

	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner create(Owner owner);

	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner update(Owner owner);

	/**
	 * 
	 * @param id
	 * @throws OwnerNotFoundException
	 */
	void delete(Long id) throws OwnerNotFoundException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	Owner findById(long id) throws OwnerNotFoundException;

	/**
	 * 
	 * @param firstName
	 * @return
	 */
	List<Owner> findByFirstName(String first_name);

	/**
	 * 
	 * @param lastName
	 * @return
	 */
	List<Owner> findByLastName(String last_name);

	/**
	 * 
	 * @param address
	 * @return
	 */
	List<Owner> findByAddress(String address);
	
	/**
	 * 
	 * @param city
	 * @return
	 */
	List<Owner> findByCity(String city);
	
	/**
	 * 
	 * @param telephone
	 * @return
	 */
	List<Owner> findByTelephone(String telephone);

	/**
	 * 
	 * @return
	 */
	Iterable<Owner> findAll();

}