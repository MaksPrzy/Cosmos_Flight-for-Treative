package pl.przybylo.flights.mapper;

import org.springframework.stereotype.Component;
import pl.przybylo.flights.domain.Tourist;
import pl.przybylo.flights.dto.TouristNewDto;
import pl.przybylo.flights.dto.TouristViewDto;

import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

@Component
public class TouristMapper {

    public Tourist map(TouristNewDto touristNewDto) {
        return new Tourist(
                touristNewDto.getFirstName(),
                touristNewDto.getLastName(),
                touristNewDto.getSex(),
                touristNewDto.getCountry(),
                touristNewDto.getNote(),
                touristNewDto.getBirthDate()
        );
    }

    public List<TouristViewDto> map(Collection<Tourist> tourists) {
        if (isNull(tourists)) {
            return newArrayList();
        }

        return tourists.stream()
                .map(t -> map(t))
                .collect(toList());
    }

    public TouristViewDto map(Tourist tourist) {
        if (isNull(tourist)) {
            return null;
        }

        return new TouristViewDto(
                tourist.getId(),
                tourist.getFirstName(),
                tourist.getLastName(),
                tourist.getSex(),
                tourist.getCountry(),
                tourist.getNote(),
                tourist.getBirthDate()
        );
    }

}
