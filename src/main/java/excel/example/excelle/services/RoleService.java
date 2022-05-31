package excel.example.excelle.services;

import java.util.List;

import excel.example.excelle.model.RoleModel;

public interface RoleService {

 void ajouterRole(RoleModel roleModel);
	
	List<RoleModel> afficherRole();
}
