package it.sidesoft.corso.restfulapp.service;

import it.sidesoft.corso.restfulapp.dto.PersonaDto;
import it.sidesoft.corso.restfulapp.dto.ProgettoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProgettoService {

    @Autowired
    private PersonaService personaService;

    public List<ProgettoDto> findAll() {
        log.info("Recupero tutti i progetti");
        List<ProgettoDto> progettoDtoList=new ArrayList<>();
        ProgettoDto dto1 = new ProgettoDto();
        dto1.setId(1L);
        dto1.setTitolo("Progetto uno");
        dto1.setDescrizione("Descrizione progetto uno");
        dto1.setPersone(personaService.findAll());
        progettoDtoList.add(dto1);

        ProgettoDto dto2 = new ProgettoDto();
        dto2.setId(2L);
        dto2.setTitolo("Progetto due");
        dto2.setDescrizione("Descrizione progetto 2");
        dto2.setPersone(personaService.findAll());
        progettoDtoList.add(dto2);

        return progettoDtoList;
    }


    public ProgettoDto save(ProgettoDto dto) {
        log.info(String.format("Salvo il progetto: %s", dto.toString()));
        return dto;
    }

    public Optional<ProgettoDto> findById(Long id) {
        log.info(String.format("Recupero progetto con id:%s", id));
        if (id == 1) {
            ProgettoDto dto1 = new ProgettoDto();
            dto1.setId(1L);
            dto1.setTitolo("Progetto uno");
            dto1.setDescrizione("Descrizione progetto uno");
            dto1.setPersone(personaService.findAll());
            return Optional.of(dto1);
        }
        return Optional.empty();
    }
}
