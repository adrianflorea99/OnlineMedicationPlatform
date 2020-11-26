package OMP.DTO.Builders;

import OMP.DTO.SideEffectDTO;
import OMP.Entity.SideEffect;

public class SideEffectBuilder {

    private SideEffectBuilder() {
    }

    public static SideEffectDTO toSideEffectDTO(SideEffect sideEffect) {
        return new SideEffectDTO(sideEffect.getId(),
                sideEffect.getEffect());
    }

    public static SideEffect toEntity(SideEffectDTO sideEffectDTO) {
        return new SideEffect(sideEffectDTO.getId(),
                sideEffectDTO.getEffect());
    }
}
