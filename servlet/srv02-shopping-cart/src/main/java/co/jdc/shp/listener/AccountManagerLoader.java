package co.jdc.shp.listener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.jdc.shp.model.AccountManager;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AccountManagerLoader implements ServletContextListener{
	
	private static final String FILE_PATH = "/WEB-INF/data/accounts.obj";
	private AccountManager manager;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		var context = sce.getServletContext();
		var path = context.getRealPath(FILE_PATH);
		
		try(var input = new ObjectInputStream(new FileInputStream(path))) {
			manager = (AccountManager) input.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(null == manager) {
			manager = new AccountManager();
		}
		
		context.setAttribute(AccountManager.KEY, manager);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		var context = sce.getServletContext();
		var path = context.getRealPath(FILE_PATH);
		
		try(var output = new ObjectOutputStream(new FileOutputStream(path))) {
			output.writeObject(manager);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
