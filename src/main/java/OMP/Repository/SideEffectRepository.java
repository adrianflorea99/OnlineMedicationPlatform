package OMP.Repository;

import OMP.Entity.SideEffect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SideEffectRepository extends JpaRepository<SideEffect, Integer> {

    List<SideEffect> findById(int id);
}
