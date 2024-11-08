package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Preceptor;
import com.mycompany.myapp.service.dto.PreceptorDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PreceptorMapper {
    PreceptorDto toDto(Preceptor preceptor);

    Preceptor toEntity(PreceptorDto preceptorDto);

    List<PreceptorDto> toDtoList(List<Preceptor> preceptores);

    List<Preceptor> toEntityList(List<PreceptorDto> preceptorDtos);
}
