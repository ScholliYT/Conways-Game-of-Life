package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class GUI extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public GUI(int _x, int _y, Game g) {
		setTitle("Conway's Game of Life");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnStep = new JButton("Step");
		btnStep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				g.step();
				
			}
		});
		contentPane.add(btnStep, BorderLayout.SOUTH);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(_y, _x));
		contentPane.add(panel, BorderLayout.CENTER);
	}
	
	public JButton addToPanel(Cell cell) {
		JButton btn = new JButton("");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cell.setAliveForNextGen(!cell.isAlive());
				cell.nextGen(); //update cell
			}
		});
		
		panel.add(btn);
		return btn;
	}

}
