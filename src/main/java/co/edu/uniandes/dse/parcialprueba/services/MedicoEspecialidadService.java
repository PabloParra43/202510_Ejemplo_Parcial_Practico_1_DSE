package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.*;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.EspecialidadRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicoEspecialidadService {

    MedicoEntity medicoEntity;
    EspecialidadEntity especialidadEntity;

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    EspecialidadRepository especialidadRepository;

    @Transactional
    private EspecialidadEntity addEspecialidad(Long medicoEntityId, Long especialidadEntityId) throws EntityNotFoundException, IllegalOperationException{

        especialidadRepository.findById(especialidadEntityId)
        .orElseThrow(() -> new EntityNotFoundException("Medico no encontrado con id: " + especialidadEntityId));

        medicoEntity = medicoRepository.findById(medicoEntityId)
    .orElseThrow(() -> new EntityNotFoundException("Medico no encontrado con id: " + medicoEntityId));
        
        medicoEntity.getEspecialidades().add(especialidadEntity);

        return especialidadEntity;
    }
}
