package cn.itcast.fruitstore.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cn.itcast.fruitstore.tools.GUITools;

//@SuppressWarnings("serial")
public abstract class AbstractMainFrame extends JFrame{
	private JLabel titleLabel = new JLabel(new ImageIcon("FruitStore.jpg"));
	private JButton btn = new JButton("进入系统");
	
	public AbstractMainFrame(){
		this.init();
		this.addComponent();
		this.addListener();
	}

	private void init(){
		this.setTitle("水果超市欢迎您");
		this.setSize(600,400);
		GUITools.center(this);
		GUITools.setTitleImage(this, "FruitStore.jpg");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addComponent() {
		this.add(this.titleLabel, BorderLayout.NORTH);
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(null);
		this.add(btnPanel);
		btn.setBounds(240, 20, 120, 50);
		btnPanel.add(btn);
	}

	private void addListener() {
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				showAdminDialog();
			}
		});
	}

	public abstract void showAdminDialog();

}
