package pl.rafalab.rafalworld;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pl.rafalab.rafalworld.Controller.MainController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RafalworldApplicationTests {

	@Autowired
	private MainController mainController;
	
	@Test
	public void contextLoads() {
		
		Assertions.assertThat(mainController).isNotNull();
	}

}
