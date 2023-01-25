package org.app.models.mappers;

import java.util.List;

import org.app.models.Buku;
import org.app.models.dto.BukuDTO;
import org.mapstruct.*;

@Mapper(componentModel = "cdi"
,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BukuMapper {
    BukuDTO toDto(Buku buku);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdDateTime", ignore = true)
    Buku toEntity(BukuDTO bukuDTO);

    List<Buku> toEntityList(List<BukuDTO> bukuDTOs);

    List<BukuDTO> toDtoList(List<Buku> bukuList);
}
