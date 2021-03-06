package Gestion_ami_Impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import Gestion_ami.Verification_User_Account;
@Stateless(mappedName = "Verification_User_Account")

public class Verification_User_Account_Impl<User> implements Verification_User_Account{
	 @PersistenceContext
	 private EntityManager em;

	@Override
	public boolean verification_user_account(String userAccount){
		// TODO Auto-generated method stub
		String qlString="SELECT e FROM User e WHERE e.userAccount = :userAccount ";
		Query query = em.createQuery(qlString);
		query.setParameter("userAccount", userAccount);
		try{
		User result =(User)query.getSingleResult();
//			JOptionPane.showMessageDialog(null,"he exists","Alert", JOptionPane.WARNING_MESSAGE);
			return true;
		}catch(NoResultException e){
//			JOptionPane.showMessageDialog(null,"he doesn't exists","Alert", JOptionPane.WARNING_MESSAGE);
			return false;			
		}

		
	}

}
