package com.company;

import com.company.dba.HibernateUtil;
import com.company.gui.App;

public class Main {

	public static void main(String[] args) {
		System.out.println("starting");
		// DataSource dbcon = new DataSource();
		// dbcon.executeTest();
		HibernateUtil.getSessionFactory().getCache();
		//App app = new App();
		//app.setVisible(true);
	}
}
