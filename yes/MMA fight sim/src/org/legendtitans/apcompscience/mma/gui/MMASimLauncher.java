package org.legendtitans.apcompscience.mma.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.legendtitans.apcompscience.mma.Fighter;

public class MMASimLauncher extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Fighter player = new Fighter("He", "Him", 100, 100, 50, 75, null);
	Fighter opponent1 = new Fighter("They", "them", 1000, 1000, 1, 5, null);
	Fighter opponent2 = new Fighter("Stabby", "stabbsters", 10, 10, 50, 99, null);
	Fighter opponent3 = new Fighter("Champo!", "Champion man!", 500, 500, 25, 50, null);
	public void fights() {
		boolean Fight1 = (opponent1.isAlive() == true);
			boolean Fight2 = (opponent2.isAlive() == true | opponent1.isAlive() == false);
				boolean Fight3 = (opponent3.isAlive() == true | opponent2.isAlive() == false | opponent1.isAlive() == false);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MMASimLauncher frame = new MMASimLauncher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MMASimLauncher() {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Player 1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setBounds(115, 96, 171, 197);
		JButton btnNewButton = new JButton("Attack");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent as) {
				initiateAttack();
				opponentAttacks();
			}
		});	
		btnNewButton.setBounds(115, 387, 171, 41);
		contentPane.add(btnNewButton);		
		contentPane.add(lblNewLabel);
		
		
	}
	public void initiateAttack() {
		if (Fight1 == true) {
			int as = player.attack();
			opponent1.setCurrentHitPoints(as);
			
			System.out.println("Player attacks with a strength of "+as);
			System.out.println("Opponent now has "+opponent1.getCurrentHitPoints()+" hit points remaining");		
			if (opponent1.isAlive() == false) {
				System.out.println("He Wins, prepare for you next battle!");
			}
		} 
		if (Fight2 == true) {
			int as = player.attack();
			opponent2.setCurrentHitPoints(as);
			
			System.out.println("Player attacks with a strength of "+as);
			System.out.println("Opponent now has "+opponent2.getCurrentHitPoints()+" hit points remaining");		
			if (opponent2.isAlive() == false) {
				System.out.println("He Wins, prepare for you next battle!");
			}
		}
		if (Fight3 == true) {
			int as = player.attack();
			opponent3.setCurrentHitPoints(as);
			
			System.out.println("Player attacks with a strength of "+as);
			System.out.println("Opponent now has "+opponent3.getCurrentHitPoints()+" hit points remaining");		
			if (opponent3.isAlive() == false) {
				System.out.println("He Wins, you won em all champ!");
			}
		}
			
	}
	public void opponentAttacks() {
		int opponentAs1 = opponent1.attack();
		int opponentAs2 = opponent2.attack();
		int opponentAs3 = opponent3.attack();
		player.setCurrentHitPoints(opponentAs1);
		System.out.println("Opponent attacks with a strength of "+opponentAs1);
		System.out.println("Player now has "+player.getCurrentHitPoints()+" hit points remaining");		
		if (player.isAlive() == false) {
			System.out.println("They Wins, no more fighting for you LOSER!");		
		}
	}
	public void specialAttack() {
		int sa = player.special();
		opponent1.setCurrentHitPoints(sa);
		System.out.println("Player attacks with a strength of "+sa+"special attack super damage!");
		System.out.println("Opponent now has "+opponent1.getCurrentHitPoints()+"hp left!");
		if (opponent1.isAlive() == false) {
			System.out.println("He Wins, prepare for your next battle!");
		}
	}
	public void defendAttack() {
	player.defend();
		 System.out.println("Your hp is now"+ player.getCurrentHitPoints());
	}
	

}
