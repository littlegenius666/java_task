package ua.kpi.calc;

public class Runner {
	public static void main(String args[]){
		View view = new View();
		Menu menu = new Menu(view);
		menu.processUser();
	}

}
