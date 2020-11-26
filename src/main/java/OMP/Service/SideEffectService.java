package OMP.Service;

import OMP.DTO.Builders.SideEffectBuilder;
import OMP.DTO.SideEffectDTO;
import OMP.Entity.SideEffect;
import OMP.Repository.SideEffectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SideEffectService {

    private final SideEffectRepository sideEffectRepository;

    @Autowired
    public SideEffectService(SideEffectRepository sideEffectRepository) {
        this.sideEffectRepository = sideEffectRepository;
    }

    public List<SideEffectDTO> findSideEffects() {
        List<SideEffect> sideEffectsList = sideEffectRepository.findAll();
        return sideEffectsList.stream()
                .map(SideEffectBuilder::toSideEffectDTO)
                .collect(Collectors.toList());
    }

    public int insert(SideEffectDTO sideEffectDTO) {
        SideEffect sideEffect = SideEffectBuilder.toEntity(sideEffectDTO);
        sideEffect = sideEffectRepository.save(sideEffect);
        return sideEffect.getId();
    }

    public int update(SideEffectDTO sideEffectDTO) {
        SideEffect sideEffect = SideEffectBuilder.toEntity(sideEffectDTO);
        sideEffect = sideEffectRepository.save(sideEffect);
        return sideEffect.getId();
    }

    public int delete(SideEffectDTO sideEffectDTO) {
        SideEffect sideEffect = SideEffectBuilder.toEntity(sideEffectDTO);
        sideEffectRepository.delete(sideEffect);
        return sideEffect.getId();
    }

}
