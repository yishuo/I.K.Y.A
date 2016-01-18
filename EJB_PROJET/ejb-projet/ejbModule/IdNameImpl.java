

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import Gestion_ami.Id_Name;
//import Gestion_ami.Get_User_info;
/**
 * 
 * obtenir id selon son nom.
 * @param <User>
 *
 */
@Stateless(mappedName = "Id_Name")

public class IdNameImpl implements Id_Name {
	
    @PersistenceContext
	private EntityManager em ;

	@SuppressWarnings("unchecked")
	public int idName(String useraccount) {
		// TODO Auto-generated method stub
//		String qlString = "SELECT e FROM user e WHERE e.userid =  :id";
		String qlString = "SELECT e FROM User e WHERE e.userAccount = :useraccount";
		Query query = em.createQuery(qlString);		
		query.setParameter("useraccount", useraccount);
		try{
		User person=(User) query.getSingleResult();
		return person.getUserId();
//		User user = (User)query.getResultList();
		}catch(NoResultException e){
			e.printStackTrace();
			return 0;
		}

	}
}
