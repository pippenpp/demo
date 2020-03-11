package cn.itcast.fruitstore.dao;

import java.util.ArrayList;

import cn.itcast.fruitstore.data.DataBase;
import cn.itcast.fruitstore.domain.FruitItem;

public class AdminDao {

	public ArrayList<FruitItem> queryAllData(){
		return DataBase.data;
	}
	
	public void addFruitItem(FruitItem fruitItem){
		DataBase.data.add(fruitItem);
	}
	
	public void delFruitItem(String delNumber){
		for(int i=0; i<DataBase.data.size();i++){
			FruitItem thisFruitItem = DataBase.data.get(i);
			if(thisFruitItem.getNumber().equals(delNumber)){
				DataBase.data.remove(i);
			}
		}
	}
}
