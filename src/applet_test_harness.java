import java.awt.Frame;


public class applet_test_harness {

	/**
	 * @param args
	 */
	   private final static int SIZE = 300;//size of window

	     public static void main(String args[]) {

	 		VisualClass aHelloWorldObject = new VisualClass();

	 			//The aHelloWorld object exists

	 		   aHelloWorldObject.init();

	 			//aHelloWorld has now initialized it self

	 		   aHelloWorldObject.start();

	 			//aHelloWorld has now started running

	 		Frame aWindow = new Frame("HelloWorld");

	 			//A window called "HelloWorld" will hold the Applet

	 		   aWindow.add("Center", aHelloWorldObject);

	 			//aWindow now has aHelloWorld in it's center

	 		   aWindow.resize(SIZE, SIZE);

	 		   aWindow.show();

	 			//aWindow is now shown to you (until you CTRL/C)

	     }//main

}
