/*
 * Prime.java
 *
 * Version:
 *          $Id$
 *
 * Revisions:
 *          $Log$
 *
 */

/*
*@Problem       : The class NotHealthy extends Thread class and has methods for simulating the ciggarette smoker problem
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author        : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.1
*@LastModified  : 10/21/2012 9.45 AM
*
*/


public class NotHealthy extends Thread {
	//The table which will contain the chosen ingredients by the agent
	private static String table = null;
	//The object on which agent and smokers are synchronized.
	private static Object sync = new Object();
	//The name of smoker or agent
	String name;
	//The ingredients that a agent or a smoker will have.
	String ingredient;
	//Type of person whether somker or agent.
	String type;
	/**
	 * Constructor to initialize NotHealthy objects
	 */
	NotHealthy(String name,String ingredient,String type) {
		this.name = name;
		this.ingredient = ingredient;
		this.type = type;
	}
	/**
	 * agentTask    Method for agent objects
	 */
	public void agentTask() {
		//Synchronized on common object sync.
		synchronized(NotHealthy.sync) {
			// If table is null then add ingredients to the table.
			if(table == null) {
				//Selecting the first ingredient in a random manner.
				int random = (int)(Math.random()*10)%3;
				table = Character.toString(ingredient.charAt(random));
				//Selecting the second ingredient
				if(random==2) {
					table = table+Character.toString(ingredient.charAt(0));
				} else {
					table = table+Character.toString(ingredient.charAt(random+1));
				}
				System.out.println(this.name+" keeping new ingredients on the table");
				try {
					//Sleep after keeping ingredients.
					this.sleep(2000);
				} catch(Exception e) {
				}
				//Notify all the waiting threads after table is filled.
				sync.notifyAll();
				System.out.println(this.name+" is waitng for table to be empty");
				try {
					//Agent waits until table is null.
					this.wait();
				} catch (Exception e) {}
			}
		}
	}
	/**
	 * smokerTask   Method for smoker objects
	 */
	public void smokerTask() {
		//Synchronized on common object sync.
		synchronized(NotHealthy.sync) {
			//If table is not null see if it has the required ingredients that smoker needs.
			if(table != null) {
				char SIngredient = this.ingredient.charAt(0);
				//Compare the ingredient the smoker has with that on the table and if yes smoke.
				if(SIngredient != table.charAt(0) && SIngredient != table.charAt(1)) {

					System.out.println(this.name+" IS SMOKING ");
					try {
						this.sleep(2000);
					} catch(Exception e) {
					}
					//Put table to null again so that agent can fill it up.
					table = null;
					//Notify all waiting threads and agent.
					sync.notifyAll();
				}
				//Wait for ingredients if the table dosent have what is required.
				try {

				//	System.out.println(this.name+" is waiting ");
					this.wait();
				} catch (Exception e) {
				}
			} else {
				//Wait if table is null.
				try {
					this.wait();
				} catch (Exception e) {
				}
			}
		}
	}
	/**
	 * run()    Run method for threads used to call respective agent and smoker methods.
	 */
	public void run() {
		while(true) {
			if(this.type == "Agent") {
				agentTask();
			} else if(this.type == "Smoker") {
				smokerTask();
			}
		}
	}
	/**
	 * Tests Agent and Smoker threads.
	 */
	public static void main(String args[]) {
		//Create Smoker and Agent threads and test.
		NotHealthy Smoker1 = new NotHealthy("Smoker1","t","Smoker");
		NotHealthy Smoker2 = new NotHealthy("Smoker2","p","Smoker");
		NotHealthy Smoker3 = new NotHealthy("Smoker3","m","Smoker");
		NotHealthy Agent1 = new NotHealthy("Agent1","tpm","Agent");
		Smoker1.start();
		Smoker2.start();
		Smoker3.start();
		Agent1.start();
	}
}
