package ru.skypro.homework.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.entity.Ad;

public interface AdMapper {

    AdMapper INSANCE = Mappers.getMapper(AdMapper.class);

    @Mapping(target = "pk", source = "id")
    @Mapping(target = "author", source = "author.id")
    AdDto adToAdDto(Ad ad);

    @Mapping(target = "id", source = "pk")
    @Mapping(target = "author.id", source = "author")
    Ad adDtoToAd(AdDto adDto);

    CreateOrUpdateAdDto adToCreateOrUpdateAdDto(Ad ad);

    Ad createOrUpdateToAd(CreateOrUpdateAdDto createOrUpdateAdDto);

    ExtendedAdDto adToExtendedDto(Ad ad);

    Ad extendedDtoToAd(ExtendedAdDto extendedAdDto);
}
