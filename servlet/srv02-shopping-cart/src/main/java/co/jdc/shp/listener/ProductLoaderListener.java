package co.jdc.shp.listener;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.Collectors;

import co.jdc.shp.model.Product;
import co.jdc.shp.model.ProductManager;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ProductLoaderListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	var applicationScope = sce.getServletContext();
    	
    	// Read Data from products.txt file
    	var filePath = applicationScope.getRealPath("/WEB-INF/data/products.txt");
    	
    	try(var stream = Files.lines(Path.of(filePath))) {
        	// Convert to Product List
        	// Create Product Manager
        	// Set Product Manager to application scope
    		
    		var products = stream
    				.map(line -> line.split("\t"))
    				.map(array -> new Product(array))
    				.collect(Collectors.toMap(Product::getId, Function.identity()));
    		
    		var productManager = new ProductManager(products);
    		
    		applicationScope.setAttribute(ProductManager.KEY, productManager);
    		applicationScope.setAttribute("products", productManager.search(null));
    		
    	} catch (Exception e) {
    		e.printStackTrace();
		}
    	
    }

}
