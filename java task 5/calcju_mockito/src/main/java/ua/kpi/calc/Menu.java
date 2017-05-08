package ua.kpi.calc;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ua.kpi.calc.commands.AddCommand;
import ua.kpi.calc.commands.Command;
import ua.kpi.calc.commands.DivideCommand;
import ua.kpi.calc.commands.DivideSafelyCommand;

public class Menu {
	private Map<String , Command> commands = new HashMap(){
		{
			put( "add", new AddCommand() );
			put( "delete", new DivideCommand(new Calculator()) );
			put( "divSafe" , new DivideSafelyCommand(new Calculator()));
		}
	};
	
	private View view;
	
	private InputStream in = System.in;
	
	
	
	public Menu(View view) {
		
		this.view = view;
	}



	public void processUser(){
		Scanner scanner = new Scanner(in);
		String input = scanner.nextLine();
		String params[] = input.split("\\s+"); //add 2 3
		if( params.length != 3 ){
			view.showError();
			return;
		}
		Command command = commands.get(params[0]);
		if( command == null){
			view.showError();
			return;
		}
		Integer result = command.execute(params[1], params[2]);
		view.printResult(result);
	}

}
