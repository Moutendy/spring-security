package excel.example.excelle.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import excel.example.excelle.model.RoleModel;
import excel.example.excelle.repositorie.RoleRepository;
import excel.example.excelle.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void ajouterRole(RoleModel roleModel) {

		roleRepository.save(roleModel);
	}

	@Override
	public List<RoleModel> afficherRole() {

		return roleRepository.findAll();
	}

}
