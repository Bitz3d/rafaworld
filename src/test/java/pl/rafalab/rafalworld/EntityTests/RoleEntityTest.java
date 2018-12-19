package pl.rafalab.rafalworld.EntityTests;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import pl.rafalab.rafalworld.Model.Role;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleEntityTest {

	@Autowired
	private TestEntityManager tem;
	
	
	@Test
	public void mappingRole(){
		Role e = this.tem.persistFlushFind(new Role("ROLE_USER"));
		
		Assertions.assertThat(e.getRole()).isEqualTo("ROLE_USER");
	}
	
	
	
}
