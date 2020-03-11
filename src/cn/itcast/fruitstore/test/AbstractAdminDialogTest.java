package cn.itcast.fruitstore.test;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.itcast.fruitstore.view.AbstractAdminDialog;

public class AbstractAdminDialogTest extends AbstractAdminDialog {
	public AbstractAdminDialogTest(){
		super();
		queryFruitItem();
	}
	
	public void queryFruitItem(){
		String[] thead = new String[]{"ˮ�����","ˮ������","ˮ�����ۣ�/Ԫ��","�Ƽ۵�λ"};
		
		String[][] tbody = new String[][]{
				{"1", "ƻ��", "5.0", "kg"},
				{"2", "����", "3.2", "��"},
				{"3", "ѩ��", "3.8", "��"},
				{"4", "����", "120", "��"}
		};
		
		TableModel data = new DefaultTableModel(tbody, thead);
		table.setModel(data);
	}

	public void addFruitItem() {

	}

	public void updateFruitItem() {

	}

	public void delFruitItem() {

	}

	public static void main(String[] args) {
		new AbstractAdminDialogTest().setVisible(true);
	}

}
