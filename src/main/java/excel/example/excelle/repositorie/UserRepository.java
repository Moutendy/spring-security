package excel.example.excelle.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import excel.example.excelle.model.UsersModel;

@Repository
public interface UserRepository extends JpaRepository<UsersModel, Long>{

}
