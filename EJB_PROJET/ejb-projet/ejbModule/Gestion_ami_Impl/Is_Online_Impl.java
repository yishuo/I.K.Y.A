package Gestion_ami_Impl;
import java.util.Collection;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import Gestion_ami.Is_Online;

@Stateless(mappedName = "Is_Online")

public class Is_Online_Impl<User> implements Is_Online {
	public Is_Online_Impl(){		
	}
	 @PersistenceContext
	 private EntityManager em;

	@Override
	public boolean is_online(int userId) {
		// TODO Auto-generated method stub
		String qlString="SELECT e.isOnline FROM User e WHERE e.userId = :id";
		Query query = em.createQuery(qlString);
		query.setParameter("id",userId);
		try{
		User result =(User)query.getSingleResult();
		if((result.toString())=="false"){
//			JOptionPane.showMessageDialog(null,"he is not online","Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}else{
//			JOptionPane.showMessageDialog(null,"he is online","Alert", JOptionPane.WARNING_MESSAGE);
			return true;
		}
		}catch(NoResultException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"we meet a problem with isOnline","Alert", JOptionPane.WARNING_MESSAGE);
			return false;
			
		}

	}

}
