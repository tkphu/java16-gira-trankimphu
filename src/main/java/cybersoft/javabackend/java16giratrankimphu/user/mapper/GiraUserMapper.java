package cybersoft.javabackend.java16giratrankimphu.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.java16giratrankimphu.role.model.GiraRole;
import cybersoft.javabackend.java16giratrankimphu.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giratrankimphu.user.modal.GiraUser;

@Mapper
public interface GiraUserMapper {
	GiraUserMapper INSTANCE = Mappers.getMapper(GiraUserMapper.class);
	
	GiraUser toModel(GiraUserDTO dto);
	
	GiraUserDTO toDTO(GiraUser model);
}