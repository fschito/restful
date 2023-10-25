package it.sidesoft.corso.restfulapp.service;
import java.util.ArrayList;

import it.sidesoft.corso.restfulapp.dto.PersonaDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PersonaService {

    public List<PersonaDto> findAll() {
        log.info("Recupero tutte le persone");
        List<PersonaDto> personaDtolist=new ArrayList<>();
        PersonaDto dto1 = new PersonaDto();
        dto1.setId(1L);
        dto1.setCognome("Tommy");
        dto1.setNome("Vercetti");
        personaDtolist.add(dto1);

        PersonaDto dto2 = new PersonaDto();
        dto2.setId(2L);
        dto2.setCognome("Niko");
        dto2.setNome("Bellic");
        personaDtolist.add(dto2);

        return personaDtolist;
    }


    public PersonaDto save(PersonaDto dto) {
        log.info(String.format("Salvo persona: %s", dto.toString()));
        return dto;
    }

    public Optional<PersonaDto> findById(Long id) {
        log.info(String.format("Recupero persona con id:%s", id));
        if (id == 1) {
            PersonaDto dto1 = new PersonaDto();
            dto1.setId(1L);
            dto1.setCognome("Tommy");
            dto1.setNome("Vercetti");
            return Optional.of(dto1);
        }
        return Optional.empty();
    }
}
