package cn.itcast.fruitstore.controller;

import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.itcast.fruitstore.domain.FruitItem;
import cn.itcast.fruitstore.service.AdminService;
import cn.itcast.fruitstore.view.AbstractAdminDialog;

public class AdminDialogController extends AbstractAdminDialog{
	private AdminService adminService = new AdminService();
	public AdminDialogController() {
		super();
	}
	
	public AdminDialogController(Frame owner, boolean modal){
		super(owner, modal);
		queryFruitItem();
	}

	public void queryFruitItem() {
		String[] thead = {"ˮ�����", "ˮ������", "ˮ������(/Ԫ)", "�Ƽ۵�λ"};
		ArrayList<FruitItem> dataList = adminService.queryFruitItem();
		
		String[][] tbody = list2Array(dataList);
		TableModel dataModel = new DefaultTableModel(tbody, thead);
		table.setModel(dataModel);
	}

	public String[][] list2Array(ArrayList<FruitItem> list) {
		String[][] tbody = new String[list.size()][4];
		for(int i=0; i<list.size(); i++){
			FruitItem fruitItem = list.get(i);
			tbody[i][0] = fruitItem.getNumber();
			tbody[i][1] = fruitItem.getName();
			tbody[i][2] = fruitItem.getPrice()+"";
			tbody[i][3] = fruitItem.getUnit();
		}
		return tbody;
	}

	@Override
	public void addFruitItem() {
		String addNumber = addNumberText.getText();
		String addName = addNameText.getText();
		String addPrice = addPriceText.getText();
		String addUnit = addUnitText.getText();
		
		boolean addSuccess = adminService.addFruitItem(addNumber, addName, addPrice, addUnit);
		if(addSuccess){
			queryFruitItem();
		}else{
			JOptionPane.showMessageDialog(this, "ˮ����Ų����ظ�");
		}
	}

	@Override
	public void updateFruitItem() {
		String updateNumber = updateNumberText.getText();
		String updateName = updateNameText.getText();
		String updatePrice = updatePriceText.getText();
		String updateUnit = updateUnitText.getText();
		
		boolean updateSuccess = adminService.updateFruitItem(updateNumber, updateName, updatePrice, updateUnit);
		
		if(updateSuccess){
			queryFruitItem();
		}else{
			JOptionPane.showMessageDialog(this, "û�������ŵ�ˮ�����޷�����");
		}
	}

	@Override
	public void delFruitItem() {
		String delNumber = delNumberText.getText();
		
		boolean delSuccess = adminService.delFruitItem(delNumber);
		
		if(delSuccess){
			queryFruitItem();
		}else{
			JOptionPane.showMessageDialog(this, "û�������ŵ�ˮ�����޷�ɾ��");
		}
		
	}
	

}
