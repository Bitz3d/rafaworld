//package pl.rafalab.rafalworld;
//
//import java.util.Arrays;
//import java.util.HashSet;
//
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.context.junit4.SpringRunner;
//import pl.rafalab.rafalworld.Model.Role;
//import pl.rafalab.rafalworld.Model.User;
//import pl.rafalab.rafalworld.Services.EmailSenderImpl;
//
//@RunWith(SpringRunner.class)
////@DataJpaTest 
//public class EntityTest {
//
////	@Autowired
////	private TestEntityManager tem;
//
//	
//	@Test
//	public void mappingRole(){
////		Role e = this.tem.persistFlushFind(new Role("ROLE_USER"));
////		
////		Assertions.assertThat(e.getRole()).isEqualTo("ROLE_USER");
//	}
//	
//	@Test
//	public void mappingUser(){	
////		User u = this.tem.persistFlushFind(new User("test@test.pl", "aA!@3456", 
////						"Test","Testerski", 1,new HashSet<Role>(Arrays.asList(new Role("ROLE_USER")))));
////		Assertions.assertThat(u.getId()).isEqualTo(1L);
////		Assertions.assertThat(u.getEmail()).isEqualTo("test@test.pl");
////		Assertions.assertThat(u.getPassword()).isEqualTo("aA!@3456");
////		Assertions.assertThat(u.getName()).isEqualTo("Test");
////		Assertions.assertThat(u.getLastName()).isEqualTo("Testerski");
////		Assertions.assertThat(u.getActive()).isEqualTo(1);
////		Assertions.assertThat(u.getRoles()).isNotEmpty();		
//	}
//
//	
//}
