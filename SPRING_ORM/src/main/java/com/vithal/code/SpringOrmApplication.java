package com.vithal.code;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vithal.code.entity.Adress;
import com.vithal.code.entity.Cateory;
import com.vithal.code.entity.Employee;
import com.vithal.code.entity.Laptop;
import com.vithal.code.entity.Product;
import com.vithal.code.entity.Student;
import com.vithal.code.repository.CategoryRepo;
import com.vithal.code.repository.EmployeeRepo;
import com.vithal.code.repository.ProductRepo;
import com.vithal.code.repository.StudentRepo;

@SpringBootApplication
public class SpringOrmApplication implements CommandLineRunner {

	
	private Logger log=LoggerFactory.getLogger(SpringOrmApplication.class);

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private CategoryRepo catRepo;
	
	
	@Autowired
	private ProductRepo proRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringOrmApplication.class, args);
		
		
		
		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
	//one to one mapping
		Student student=new Student();
		student.setStudentId(20);
		student.setStudentName("kavi nivargi");
		student.setStudentCity("sonyal");
		student.setStudentAbout("he's an software engineer learning...");
		
		
		
		log.info("student saved-->> {}, {} ",student.getStudentName(),student.getStudentCity());
		
		Laptop laptop=new Laptop();
		laptop.setLaptopId(45);
		laptop.setLaptopBrand("leno");
		laptop.setLaptopModel("leno12");
		
		laptop.setStudent(student);
		student.setLaptop(laptop);
	
		studentRepo.save(student);
		log.info("Laptop saved -->> {}, {} ",laptop.getLaptopModel(),laptop.getLaptopBrand());
		System.out.println("=================================");
		
		Student student2 = studentRepo.findById(13).get();
	
		log.info("studentName and studentCity are => {},{}",student2.getStudentName(),student2.getStudentCity());
		
		
		//one to Many

		
		Employee employee = new Employee();
		employee.setEmpId(9);
		employee.setEmpName("ravi");
		employee.setEmpCity("sangli");
		employee.setEmpAbout("this employee is bad good");
		
		//empRepo.save(employee);
		System.out.println("--------------------------");
		
		log.info("employee saved {} ",employee.getEmpName());
		
		
		Adress a1 = new Adress();
		a1.setAdressStreet("jath-chadchan");
		a1.setAdressCountry("IND");
		a1.setAdressId(6);
		a1.setAdressZipcode("413416");
		a1.setEmployee(employee);
		
		
		Adress a2 = new Adress();
		a2.setAdressStreet("uatagi-ytutyhj");
		a2.setAdressCountry("IND");
		a2.setAdressId(7);
		a2.setAdressZipcode("124534");
		a2.setEmployee(employee);
		
		List<Adress> adresslist=new ArrayList<>();
		adresslist.add(a1);
		adresslist.add(a2);
		
		
		
		employee.setAdressList(adresslist);
		Employee savedEmployees = empRepo.save(employee);
		log.info("employee saved {} ",savedEmployees.getEmpName());
		
		
		
		//many to many mapping
		
		Product p1 = new Product();
		p1.setPId("p1ID");
		p1.setPName("Iphone");
		Product p2 = new Product();
		p2.setPId("p2ID");
		p2.setPName("samsung");
		Product p3 = new Product();
		p3.setPId("p3ID");
		p3.setPName("Realme");
		
		
		Cateory c1 = new Cateory();
		c1.setCId("cId1");
		c1.setTitle("Electornics");	
		Cateory c2 = new Cateory();
		c2.setCId("cId2");
		c2.setTitle("Mobile phones");
		
		List<Product> cateproduct1 = c1.getProduct();
		log.info("cateproduct1 ==> "+cateproduct1);
		cateproduct1.add(p1);
		cateproduct1.add(p2);
		cateproduct1.add(p3);
		
		List<Product> cateproduct2 = c2.getProduct();
		cateproduct2.add(p1);
		cateproduct2.add(p2);
		
		catRepo.save(c1);
		catRepo.save(c2);
		
		
		
		Cateory cateory = catRepo.findById("cId1").get();
		int size = cateory.getProduct().size();
		
		System.out.println("Product size "+size);
		
		//
		Product product = proRepo.findById("p1ID").get();
		int size2 = product.getCategory().size();
		System.out.println("Category Size "+size2);
	}
	

}
