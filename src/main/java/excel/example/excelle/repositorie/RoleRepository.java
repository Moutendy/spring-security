package excel.example.excelle.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import excel.example.excelle.model.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long>{

}
