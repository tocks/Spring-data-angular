package org.glsid.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.glsid.entities.Compte;
import org.glsid.metier.CompteMetier;
import org.glsid.metier.OperationMetier;
import org.glsid.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@WebService
@Component
public class BanqueSoapService {
	
	@Autowired
	private CompteMetier compteMetier;
	
	@Autowired
	private OperationMetier operationMetier;
	
	public Compte saveCompte(Compte cp) {
		return compteMetier.saveCompte(cp);
	}
	
	@WebMethod
	public Compte getCompte(@WebParam(name="code")String code) {
		return compteMetier.getCompte(code);
	}
	
	@WebMethod
	public boolean verser(
			@WebParam(name="code")String code, 
			@WebParam(name="montant")double montant, 
			@WebParam(name="codeEmp")Long codeEmp) {
		return operationMetier.verser(code, montant, codeEmp);
	}
	public boolean retier(
			@WebParam(name="code")String code, 
			@WebParam(name="montant")double montant, 
			@WebParam(name="codeEmp")Long codeEmp) {
		return operationMetier.retier(code, montant, codeEmp);
	}
	public boolean virement(
			@WebParam(name="cpte1")String cpte1,
			@WebParam(name="cpte2")String cpte2, 
			@WebParam(name="montant")double montant, 
			@WebParam(name="codeEmp")Long codeEmp) {
		return operationMetier.virement(cpte1, cpte2, montant, codeEmp);
	}
	public PageOperation getOperations(
			@WebParam(name="codeCompte")String codeCompte,
			@WebParam(name="page")int page, 
			@WebParam(name="size")int size) {
		return operationMetier.getOperations(codeCompte, page, size);
	}
	

}
