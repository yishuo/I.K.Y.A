package Gestion_ami;


import javax.ejb.Remote;

@Remote
public interface Demande_FriendsApply {
	public void demande_FriendsApply(int from_userId,int to_userId);

}