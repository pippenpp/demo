package cn.itcast.fruitstore.service;

import java.lang.reflect.Array;
import java.util.ArrayList;

import cn.itcast.fruitstore.dao.AdminDao;
import cn.itcast.fruitstore.domain.FruitItem;

public class AdminService {
	private AdminDao adminDao = new AdminDao();
	
	public ArrayList<FruitItem> queryFruitItem(){
		ArrayList<FruitItem> data = adminDao.queryAllData();
		return data;
	}
	
	public boolean addFruitItem(String number, String name, String price, String unit){
		ArrayList<FruitItem> data = queryFruitItem();
		for(int i=0;i<data.size();i++){
			FruitItem fruitItem = data.get(i);
			if(number.equals(fruitItem.getNumber())){
				return false;
			}
		}
		FruitItem thisFruitItem = new FruitItem(number, name, Double.parseDouble(price), unit);
		adminDao.addFruitItem(thisFruitItem);
		
		return true;
	}

	public boolean updateFruitItem(String number, String name, String price, String unit){
		ArrayList<FruitItem> data = queryFruitItem();
		for(int i=0; i<data.size();i++){
			FruitItem fruitItem = data.get(i);
			if(number.equals(fruitItem.getNumber())){
				adminDao.delFruitItem(number);
				FruitItem thisFruitItem = new FruitItem(number, name, Double.parseDouble(price), unit);
				adminDao.addFruitItem(thisFruitItem);
				return true;
			}
		}
		return false;
	}
	
	public boolean delFruitItem(String delNumber){
		ArrayList<FruitItem> data = queryFruitItem();
		for(int i=0;i<data.size();i++){
			FruitItem fruitItem = data.get(i);
			if(delNumber.equals(fruitItem.getNumber())){
				adminDao.delFruitItem(delNumber);
				return true;
			}
		}
		return false;
	}
	
	
	


}
