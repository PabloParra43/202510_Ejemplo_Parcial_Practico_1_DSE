package co.edu.uniandes.dse.parcialprueba.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import java.util.List;
import java.util.ArrayList;

@Data
@Entity
public class EspecialidadEntity extends BaseEntity{

    private String nombre;
    private String descripcion;

    @PodamExclude
    @ManyToMany(mappedBy = "especialidades")
    private List<MedicoEntity> medicos = new ArrayList<>();

}
