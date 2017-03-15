package example1;


import java.awt.Button;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.Label;
import java.awt.event.WindowEvent;	//for CloseListener()
import java.awt.event.WindowAdapter;	//for CloseListener()
import java.lang.Integer;		//int from Model is passed as an Integer
import java.util.Observable;		//for update();
import java.awt.event.ActionListener;	//for addController()

public class View {
	
	private TextField myTextField;
	private Button button;
	
	View(){
		System.out.println("View()");
		Frame frame = new Frame("simple MVC");
		frame.add("North",new Label("counter"));
		myTextField = new TextField();
		frame.add("Center", myTextField);
		
		Panel panel = new Panel();
		button = new Button("PressMe");
		panel.add(button);
		frame.add("South", panel);

	frame.addWindowListener(new CloseListener());	
	frame.setSize(200,100);
	frame.setLocation(100,100);
	frame.setVisible(true);

} //View()

// Called from the Model
	public void update(Observable obs, Object obj) {

	//who called us and what did they send?
	//System.out.println ("View      : Observable is " + obs.getClass() + ", object passed is " + obj.getClass());

	//model Pull 
	//ignore obj and ask model for value, 
	//to do this, the view has to know about the model (which I decided I didn't want to do)
	//uncomment next line to do Model Pull
		//myTextField.setText("" + model.getValue());

	//model Push 
	//parse obj
	myTextField.setText("" + ((Integer)obj).intValue());	//obj is an Object, need to cast to an Integer

	} //update()

//to initialise TextField
public void setValue(int v){
		myTextField.setText("" + v);
} //setValue()
	
public void addController(ActionListener controller){
	System.out.println("View      : adding controller");
	button.addActionListener(controller);	//need instance of controller before can add it as a listener 
} //addController()

//uncomment to allow controller to use view to initialise model	
//public void addModel(Model m){
//	System.out.println("View      : adding model");
//	this.model = m;
//} //addModel()

public static class CloseListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		e.getWindow().setVisible(false);
		System.exit(0);
	} //windowClosing()
} //CloseListener

} //View	}
