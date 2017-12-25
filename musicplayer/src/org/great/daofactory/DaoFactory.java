package org.great.daofactory;

import org.great.jbasedao.JBaseDao;

public class DaoFactory {
	public static JBaseDao DaoFactory(String className) {
		JBaseDao jd=null;
		try {
			Class forName = Class.forName(className);
			jd = (JBaseDao)forName.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jd;
	}
}
