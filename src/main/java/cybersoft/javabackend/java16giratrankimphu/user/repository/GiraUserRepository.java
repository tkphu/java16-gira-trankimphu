package cybersoft.javabackend.java16giratrankimphu.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java16giratrankimphu.user.modal.GiraUser;

@Repository
public interface GiraUserRepository extends JpaRepository<GiraUser, UUID> {
	Optional<GiraUser> findByUsername(String username);

	Optional<GiraUser> findByEmail(String email);
	
	Optional<GiraUser> findByEmailAndUsername(String email, String username);
	
	Optional<GiraUser> findByUsernameAndPassword(String username, String password);
	
}