package cybersoft.javabackend.java16giratrankimphu.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java16giratrankimphu.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giratrankimphu.user.mapper.GiraUserMapper;
import cybersoft.javabackend.java16giratrankimphu.user.modal.GiraUser;
import cybersoft.javabackend.java16giratrankimphu.user.repository.GiraUserRepository;
@Service
public class GiraUserServiceImpl implements GiraUserService {
	@Autowired
	private GiraUserRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public GiraUserDTO createNewUser(GiraUserDTO dto) {
		GiraUser user = GiraUserMapper.INSTANCE.toModel(dto);
		
		// encode password before save
		user.setPassword(encoder.encode(dto.getPassword()));
		
		GiraUser newUser = repository.save(user);
		
		return GiraUserMapper.INSTANCE.toDTO(newUser);
	}

}
