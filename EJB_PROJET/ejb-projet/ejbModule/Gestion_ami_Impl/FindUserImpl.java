package Gestion_ami_Impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Gestion_ami.Find_User;

//import Gestion_ami.Get_User_info;
/**
 * 
 * obtenir user selon son account.
 *
 * @param <User>
 */
@Stateless(mappedName = "Find_User")

public class FindUserImpl<User> implements Find_User {
	
    @PersistenceContext
	private EntityManager em ;

	@SuppressWarnings("unchecked")
	public List<User> finduser(String useraccount) {
		// TODO Auto-generated method stub
		String qlString="SELECT e FROM User e WHERE e.userAccount = :useraccount";
//		String qlString="SELECT e FROM user e WHERE e.userid =  :id";
		Query query = em.createQuery(qlString);		
		query.setParameter("useraccount", useraccount);
		List<User> userList = query.getResultList();
//		User user = (User)query.getResultList();
		return userList;
	}

}
