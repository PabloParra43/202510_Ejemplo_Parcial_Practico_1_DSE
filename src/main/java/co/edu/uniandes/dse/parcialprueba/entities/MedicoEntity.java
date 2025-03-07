package co.edu.uniandes.dse.parcialprueba.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import java.util.List;
import java.util.ArrayList;

@Data
@Entity
public class MedicoEntity extends BaseEntity {

    private String nombre ;
    private String apellido ;
    private String registroMedico;

    @PodamExclude
    @ManyToMany
    private List<EspecialidadEntity> especialidades = new ArrayList<>();

    
}
