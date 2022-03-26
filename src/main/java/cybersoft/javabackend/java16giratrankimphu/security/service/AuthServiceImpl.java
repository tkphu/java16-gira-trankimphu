package cybersoft.javabackend.java16giratrankimphu.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java16giratrankimphu.security.dto.LoginDTO;
import cybersoft.javabackend.java16giratrankimphu.security.jwt.JwtHelper;
import cybersoft.javabackend.java16giratrankimphu.user.modal.GiraUser;
import cybersoft.javabackend.java16giratrankimphu.user.repository.GiraUserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private GiraUserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtHelper jwtHelper;
	@Override
	public String login(LoginDTO dto) {
		Optional<GiraUser> userOpt = repository.findByUsername(dto.getUsername());
		String encodedPassword = userOpt.get().getPassword();
		if(passwordEncoder.matches(dto.getPassword(), encodedPassword)) {
			return jwtHelper.generateJwtToken(dto.getUsername());
		}
		
		return null;
	}

}
