import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.*;

import Gestion_ami.Rank;

import java.util.List;
import java.awt.*;   
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class record extends JFrame{
	JFrame record = new JFrame("Our Record");
	Container panel = record.getContentPane();
	JPanel panel1 = new JPanel();
    JList recordList = null;
    JButton jb = new JButton("Cancel");
    
    public record(){
    	DefaultListModel myRecordList = new DefaultListModel();
    	InitialContext context=null;
		try {
			context = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Rank rank = null;
	    try {
			rank = (Rank)context.lookup("Rank");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    List<User> userList = rank.rank();
	    for(int i=0; i<userList.size(); i++){
	    	myRecordList.addElement(userList.get(i).getUserAccount()+"         "
	                                +String.valueOf(userList.get(i).getUserRecord()));
	    	System.out.println(userList.get(i).getUserRecord());
	    }
	   
		record.setContentPane(panel);
		record.getLayeredPane().setLayout(null);
		panel.setLayout(null);
		
		recordList = new JList(myRecordList);
		recordList.setBorder(BorderFactory.createTitledBorder("Competition List: "));		
		panel1.add(recordList);
		panel1.setLayout(new GridLayout(1,1));
		panel1.add(new JScrollPane(this.recordList));
		panel.add(panel1);
		panel1.setBounds(10, 10, 240, 240);
		recordList.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){

			}
		});
		
        panel.add(jb);
        jb.setBounds(150, 260, 100, 20);
		jb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent w) {
				// action de register
				record.dispose();
			}
		});
        
        record.setSize(265, 320);
        record.setLocationRelativeTo(null);
        record.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        record.setVisible(true);
        record.setResizable(false);
         
    }
    public static void main(String[] args){
        new record();
    }
}