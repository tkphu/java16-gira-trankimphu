package cybersoft.javabackend.java16giratrankimphu.role.service;

import java.util.List;

import cybersoft.javabackend.java16giratrankimphu.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giratrankimphu.role.model.GiraRole;

public interface GiraRoleService {
	List<GiraRole> findAllEntity();
	GiraRole save(GiraRoleDTO dto);
}
