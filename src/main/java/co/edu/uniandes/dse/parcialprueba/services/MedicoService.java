package co.edu.uniandes.dse.parcialprueba.services;

import static org.mockito.ArgumentMatchers.contains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.EspecialidadRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicoService {

    private String iniciales = "RM";

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    EspecialidadRepository especialidadRepository;

    @Transactional
    public MedicoEntity createMedicos(MedicoEntity medicoEntity) throws EntityNotFoundException, IllegalOperationException{
        log.info("Inicia creación de médico");

        if (medicoEntity.getRegistroMedico().startsWith(iniciales) ) throw new IllegalOperationException("Registro médico no válido");

        return medicoRepository.save(medicoEntity);
    }

}
