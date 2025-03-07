package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Transactional
@Import(MedicoService.class)
class MedicoServiceTest {

    

}
