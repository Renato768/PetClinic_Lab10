package com.tecsup.petclinic.service;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;


@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);

	@Autowired
	private OwnerService ownerService;
	
	/**
	 * 
	 * 
	 */
	@Test
	public void testFindOwnerById() throws OwnerNotFoundException {

		long ID = 1;
		String FIRST_NAME = "George";
		Owner owner = null;
		
		try {
			
			owner = ownerService.findById(ID);
			
		} catch (OwnerNotFoundException e) {
			assertThat(e.getMessage(), false);
		}
		logger.info("" + owner);

		assertThat(FIRST_NAME, is(owner.getFirstName()));

	}

	/**
	 * 
	 */
	@Test
	public void testFindOwnerByFist_Name() {

		String FIND_FIRST_NAME = "George";
		int SIZE_EXPECTED = 1;

		List<Owner> owners = ownerService.findByFirstName(FIND_FIRST_NAME);

		assertThat(SIZE_EXPECTED, is(owners.size()));
	}

	/**
	 * 
	 */
	@Test
	public void testFindOwnerByLast_name() {

		String FIND_LAST_NAME = "Franklin";
		int SIZE_EXPECTED = 1;

		List<Owner> owners = ownerService.findByLastName(FIND_LAST_NAME);

		assertThat(SIZE_EXPECTED, is(owners.size()));
	}

	/**
	 * 
	 */
	@Test
	public void testFindOwnerByAddress() {

		String FIND_ADDRESS = "110 W. Liberty St.";
		int SIZE_EXPECTED = 1;

		List<Owner> owners = ownerService.findByAddress(FIND_ADDRESS);

		assertThat(SIZE_EXPECTED, is(owners.size()));
	}
	/**
	 * 
	 */
	@Test
	public void testFindOwnerByCity() {

		String FIND_CITY = "Madison";
		int SIZE_EXPECTED = 1;

		List<Owner> owners = ownerService.findByCity(FIND_CITY);

		assertThat(SIZE_EXPECTED, is(owners.size()));
	}
	/**
	 * 
	 */
	@Test
	public void testFindOwnerByTelephone() {

		String FIND_TELEPHONE = "6085551023";
		int SIZE_EXPECTED = 1;

		List<Owner> owners = ownerService.findByTelephone(FIND_TELEPHONE);

		assertThat(SIZE_EXPECTED, is(owners.size()));
	}	

	/**
	 *  To get ID generate , you need 
	 *  setup in id primary key in your
	 *  entity this annotation :
	 *  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
	@Test
	public void testCreateOwner() {

		String FIRST_NAME = "Renato";
		String LAST_NAME = "Pongo";
		String ADDRESS = "Ate 314";
		String CITY = "Lima";
		String TELEPHONE = "942105215";

		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		Owner owners = ownerService.create(owner);
		logger.info("Owner:" + owners);

		assertThat(owners.getId(), notNullValue());
		assertThat(owners.getFirstName(), is(FIRST_NAME));
		assertThat(owners.getLastName(), is(LAST_NAME));
		assertThat(owners.getAddress(),is(ADDRESS));
		assertThat(owners.getCity(),is(CITY));
		assertThat(owners.getTelephone(),is(TELEPHONE));

	}

	/**
     * 
     */
    @Test
    public void testUpdateOwner() {

    	String FIRST_NAME = "Leonardo";
		String LAST_NAME = "Guzman";
		String ADDRESS = "Ate 315";
		String CITY = "Lima";
		String TELEPHONE = "987654321";
        long create_id = -1;

        String UP_FIRST_NAME = "Leonardo2";
		String UP_LAST_NAME = "Guzman";
		String UP_ADDRESS = "Ate 315";
		String UP_CITY = "Lima";
		String UP_TELEPHONE = "987654321";

        Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);

        // Create record
        logger.info(">" + owner);
        Owner ownerCreated = ownerService.create(owner);
        logger.info(">>" + ownerCreated);

        create_id = ownerCreated.getId();

        // Prepare data for update
        ownerCreated.setFirstName(UP_FIRST_NAME);
        ownerCreated.setLastName(UP_LAST_NAME);
        ownerCreated.setAddress(UP_ADDRESS);
        ownerCreated.setCity(UP_CITY);
        ownerCreated.setTelephone(UP_TELEPHONE);

        // Execute update
        Owner upgradeOwner = ownerService.update(ownerCreated);
        logger.info(">>>>" + upgradeOwner);

        //        ACTUAL       EXPECTED
        assertThat(create_id ,notNullValue());
        assertThat(upgradeOwner.getId(), is(create_id));
        assertThat(upgradeOwner.getFirstName(), is(UP_FIRST_NAME));
        assertThat(upgradeOwner.getLastName(), is(UP_LAST_NAME));
        assertThat(upgradeOwner.getAddress(), is(UP_ADDRESS));
        assertThat(upgradeOwner.getCity(), is(UP_CITY));
        assertThat(upgradeOwner.getTelephone(), is(UP_TELEPHONE));
    }

	/**
	 * 
	 */
	@Test
	public void testDeleteOwner() {

		String FIRST_NAME = "Leonardo";
		String LAST_NAME = "Guzman";
		String ADDRESS = "Ate 315";
		String CITY = "Lima";
		String TELEPHONE = "987654321";

		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		owner = ownerService.create(owner);
		logger.info("" + owner);

		try {
			ownerService.delete(owner.getId());
		} catch (OwnerNotFoundException e) {
			assertThat(e.getMessage(), false);
		}
			
		try {
			ownerService.findById(owner.getId());
			assertThat(true, is(false));
		} catch (OwnerNotFoundException e) {
			assertThat(true, is(true));
		} 				

	}
}
