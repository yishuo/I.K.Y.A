package Gestion_ami_Impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import Gestion_ami.Delete_Friend;
//import Gestion_ami.Get_User_info;
/**
 * 
 * supprimer un ami selon son id.
 *
 */
@Stateless(mappedName = "Delete_Friend")

public class DeleteFriendImpl implements Delete_Friend {
	
    @PersistenceContext
	private EntityManager em ;

	@SuppressWarnings("unchecked")
	public void deleteFriend(int userId1, int userId2) {
		// TODO Auto-generated method stub
//		String qlString = "SELECT e FROM user e WHERE e.userid =  :id";
		String qlString = "DELETE FROM List_contact e WHERE e.userId1 = :id1 AND e.userId2 = :id2";
		Query query = em.createQuery(qlString);
//		String id = String.valueOf(userId);
		query.setParameter("id1", userId1);
		query.setParameter("id2", userId2);
		
		query.executeUpdate();
		
//		User friend =(User)query.getSingleResult();
		
//		User user = (User)query.getResultList();

	}
}
