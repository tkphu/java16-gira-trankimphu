package cybersoft.javabackend.java16giratrankimphu.role.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.javabackend.java16giratrankimphu.role.model.GiraRole;

@SpringBootTest
@Transactional
public class GiraRoleRepositoryTest {
	
	@Autowired
	private GiraRoleRepository repository;
	
	@Test
	public void shouldNotInsertRole() {
		GiraRole role = GiraRole.builder()
				.code("FOUR")
				.description(null)
				.build();
	}
}
