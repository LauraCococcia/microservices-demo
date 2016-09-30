//package io.pivotal.microservices.accounts;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository
//@Transactional(readOnly = true)
//public class AccountRepositoryImp implements AccountRepository {
//
//	@PersistenceContext
//	private EntityManager em;
//
//	@Autowired
//	private AccountRepository repository;
//
//	@Override
//	public Account login(String user, String pwd) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	@Transactional
//	public void save(Account acccount) {
//		// TODO Auto-generated method stub
//		return repository.save(acccount);	
//	}
//
//}
