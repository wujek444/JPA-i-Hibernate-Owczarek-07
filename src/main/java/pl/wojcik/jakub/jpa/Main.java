package pl.wojcik.jakub.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pl.wojcik.jakub.jpa.domain.Employee;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
//		employee.setId(1); //id teraz generuje się automatycznie
		employee.setFirstName("Sylwia");
		employee.setLastName("Drwal");
		employee.setSalary(4000.2);
		
		Employee employee1 = new Employee();
		employee1.setFirstName("Roman");
		employee1.setLastName("Wójcik");
		employee1.setSalary(3000.2);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(employee1);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
