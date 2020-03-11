package cn.itcast.fruitstore.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cn.itcast.fruitstore.tools.GUITools;

public abstract class AbstractAdminDialog extends JDialog {
	private JLabel tableLabel = new JLabel("ˮ���б�");
	private JScrollPane tablePane = new JScrollPane();
	protected JTable table = new JTable();
	private JLabel numberLabel = new JLabel("ˮ�����");
	private JLabel nameLabel = new JLabel("ˮ������");
	private JLabel priceLabel = new JLabel("ˮ������");
	private JLabel unitLabel = new JLabel("�Ƽ۵�λ");
	
	protected JTextField addNumberText = new JTextField(6);
	protected JTextField addNameText = new JTextField(6);
	protected JTextField addPriceText = new JTextField(6);
	protected JTextField addUnitText = new JTextField(6);
	private JButton addBtn = new JButton("���ˮ��");
	
	protected JTextField updateNumberText = new JTextField(6);
	protected JTextField updateNameText = new JTextField(6);
	protected JTextField updatePriceText = new JTextField(6);
	protected JTextField updateUnitText = new JTextField(6);
	private JButton updateBtn = new JButton("�޸�ˮ��");
	
	protected JTextField delNumberText = new JTextField(6);
	private JButton delBtn = new JButton("ɾ��ˮ��");
	
	public AbstractAdminDialog(){
		this(null, true);
	}
	
	public AbstractAdminDialog(Frame owner, boolean modal){
		super(owner, modal);
		this.init();
		this.addComponent();
		this.addListener();
	}

	private void init() {
		this.setTitle("���л������");
		this.setSize(600, 400);
		GUITools.center(this);
		this.setResizable(false);
	}

	private void addComponent() {
		this.setLayout(null);
		tableLabel.setBounds(265, 20, 70, 25);
		this.add(tableLabel);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setEnabled(false);
		tablePane.setBounds(50,50,500,200);
		tablePane.setViewportView(table);
		this.add(tablePane);
		
		numberLabel.setBounds(50,250,70,25);
		nameLabel.setBounds(150,250,70,25);
		priceLabel.setBounds(250,250,70,25);
		unitLabel.setBounds(350,250,70,25);
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(priceLabel);
		this.add(unitLabel);
		
		addNumberText.setBounds(50,280,80,25);
		addNameText.setBounds(150,280,80,25);
		addPriceText.setBounds(250,280,80,25);
		addUnitText.setBounds(350,280,80,25);
		this.add(addNumberText);
		this.add(addNameText);
		this.add(addPriceText);
		this.add(addUnitText);
		addBtn.setBounds(460, 280, 90, 25);
		this.add(addBtn);
		
		updateNumberText.setBounds(50, 310, 80, 25);
		updateNameText.setBounds(150, 310, 80, 25);
		updatePriceText.setBounds(250, 310, 80, 25);
		updateUnitText.setBounds(350, 310, 80, 25);
		this.add(updateNumberText);
		this.add(updateNameText);
		this.add(updatePriceText);
		this.add(updateUnitText);
		updateBtn.setBounds(460, 310, 90, 25);
		this.add(updateBtn);
		
		delNumberText.setBounds(50, 340, 80, 25);
		this.add(delNumberText);
		delBtn.setBounds(460, 340, 90, 25);
		this.add(delBtn);
	}
		

	private void addListener() {
		addBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				addFruitItem();
			}
		});
		
		updateBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				updateFruitItem();
			}
		});
		
		delBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				delFruitItem();
			}
		});
	}

	public abstract void addFruitItem();
	public abstract void updateFruitItem();
	public abstract void delFruitItem();

}
