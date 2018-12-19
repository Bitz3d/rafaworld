package UtilsTest;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import pl.rafalab.rafalworld.Constants.RafConstants;
import pl.rafalab.rafalworld.RafUtils.RafUtils;

@RunWith(SpringRunner.class)
public class RaUtilsTest {

	@Test
	public void shoud_check_if_emai_pattern_works(){
		
	Assertions.assertThat(RafUtils.checkEmailOrPassword(RafConstants.EMAIL_PATTERN, "someEmail@email.com"))
						 .isEqualTo(true);
	}
	@Test
	public void shoud_check_if_password_pattern_works(){
		
	Assertions.assertThat(RafUtils.checkEmailOrPassword(RafConstants.PASSWORD_PATTERN, "Aa!@3456zed"))
						 .isEqualTo(true);
	}	
	@Test
	public void shoud_check_if_readUserXmlFile_pattern_works(){
		//TODO
		
		Assertions.assertThat(true).isEqualTo(false);	
	}
	
	@Test
	public void shoud_check_if_randomCodeGenerator_pattern_works(){
		
		Assertions.assertThat(RafUtils.randomCodeGenerator()).isNotEmpty();
	}
	
	
}
