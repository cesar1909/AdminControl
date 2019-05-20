package mx.ipn.cic.biblioteca.AdminControl.repositories;

import mx.ipn.cic.biblioteca.AdminControl.model.AdminModel;

import javax.transaction.Transactional;

@Transactional
public interface IAdminRepository extends UserBaseRepository<AdminModel>{
}
