import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.Point;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.Timer;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import java.awt.Dimension;
import java.awt.image.*;

public class VisualClass extends JApplet implements  MouseListener{

	public int width = 1280;
	public int height = 750;
	private static final long serialVersionUID = 1L;
	StockReciever stockgetter;  //  @jve:decl-index=0:
	TRIndicator pattern = new TRIndicator();  //  @jve:decl-index=0:
	public ArrayList<candlestick> clist= new ArrayList<candlestick>();  
	quote myQuote = new quote();//  @jve:decl-index=0:
	DrawHelper CSDraw = new DrawHelper();  //  @jve:decl-index=0:
//	boolean[] dojis;
//	boolean[] gravestones;
//	boolean[] dragonflies;
//	boolean[] hammers;
//	boolean[] shootingstars;
//	boolean[] bullengulfs;
//	boolean[] bearengulfs;
//	boolean[] darkcloudcovers;
//	boolean[] piercingpatterns;
	BufferedImage hammerimg;
	MediaTracker mt;
	boolean blnDrawFiboOn = false;
	boolean currentlyInLine = false;
	String currentSymbol = null;
	Timer quoteTimer;//  @jve:decl-index=0:
	Point firstpoint = null;  //  @jve:decl-index=0:
	Point secondpoint = null;  //  @jve:decl-index=0:
	
	private JPanel jContentPane = null;  //  @jve:decl-index=0:visual-constraint="-13,7"
	private JButton jbtnReDraw = null;
	private JTextField jtxtSymbol = null;
	//private JTextField jTFOldYear = null;
	public VisualClass() {
		super();	
		
	}

	public void init() {
		this.setContentPane(getJContentPane());
		this.setSize(new Dimension(width, height));
		this.setSize(width, height);
		this.setBackground(Color.BLACK);
		 addMouseListener( this );
		mt = new MediaTracker(this);
		
		quoteTimer = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myQuote = stockgetter.getSingleQuote(currentSymbol);
				// TODO Auto-generated method stub
				Graphics g1 = getGraphics();
				CSDraw.drawQuote(g1, myQuote);
			}
		});
//		 try {
//             URL url = new URL(getCodeBase(), "hammer.gif");
//             hammerimg = ImageIO.read(url);
//         } catch (IOException e) {
//         }
//         mt.addImage(hammerimg,1);
//         try {
//             mt.waitForAll();
//        }
//        catch (InterruptedException  e) {}
		
		//Container content = getContentPane();
		
		//content.add(this);
//		int nowmonth = 11;
//		int nowyear = 2010;
//		int oldday = 3;
//		int oldmonth = 7;
//		int oldyear = 2010;
//		clist = stockgetter.getInfo("WFMI",oldday,oldmonth,oldyear,nowday,nowmonth,nowyear);
//		dojis = pattern.doji(clist);
//		gravestones = pattern.gravestoneDoji(clist);
//		dragonflies = pattern.dragonflyDoji(clist);
//		hammers = pattern.hammer(clist);
//		shootingstars = pattern.shootingStar(clist);
//		bullengulfs = pattern.bullEngulf(clist);


//		Disable initial drawing until reDraw function called.
//		CSDraw.drawCandles(getGraphics(),clist);
//		CSDraw.drawPrices(g, CSDraw.findMin(clist), CSDraw.findMax(clist));
//		CSDraw.drawVolume(getGraphics(), clist);
//		CSDraw.drawDoji(getGraphics(),clist,dojis);
//		CSDraw.drawGravestoneDoji(getGraphics(),clist,gravestones);
//		CSDraw.drawDragonflyDoji(getGraphics(), clist, dragonflies);
//		CSDraw.drawHammer(getGraphics(), clist, hammers);
//		CSDraw.drawShootingStar(getGraphics(), clist, shootingstars);
//		CSDraw.drawBullishEngulf(getGraphics(), clist, bullengulfs);
	}

	public void paintComponents(Graphics g){
		super.paintComponents(g);
		setSize(width,height);
		setBackground(Color.BLACK);
		
		
//		Disable initial drawing until function called.
//		CSDraw.drawCandles(g,clist);
//	
//		CSDraw.drawVolume(g, clist);
//		CSDraw.drawDoji(g,clist,dojis);
//		CSDraw.drawGravestoneDoji(g,clist,gravestones);
//		CSDraw.drawDragonflyDoji(g, clist, dragonflies);
//		CSDraw.drawHammer(g, clist, hammers);
//		CSDraw.drawShootingStar(g, clist, shootingstars);
//		CSDraw.drawBullishEngulf(g, clist, bullengulfs);
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(Color.BLACK);
			jContentPane.setSize(new Dimension(width, height));
			jContentPane.add(getJbtnReDraw(), null);
			jContentPane.add(getJtxtSymbol(), null);
			//jContentPane.add(getJTFOldYear(), null);
			
		}
		return jContentPane;
	}

	private JButton getJbtnReDraw() {
		if (jbtnReDraw == null) {
			jbtnReDraw = new JButton();
			jbtnReDraw.setAction(new AbstractAction(){     
	public void actionPerformed(ActionEvent e) {
	jbtnDrawClick();
	}});
			jbtnReDraw.setBounds(new Rectangle(41, 29, 83, 34));
			jbtnReDraw.setText("ReDraw!");
			jbtnReDraw.setBackground(new Color(89, 91, 60));
			jbtnReDraw.setSelected(true);
			jbtnReDraw.setMnemonic(KeyEvent.VK_UNDEFINED);
			jbtnReDraw.setForeground(Color.white);
			jbtnReDraw.setVisible(true);
		}
		return jbtnReDraw;
	}
	
	private JTextField getJtxtSymbol() {
		if (jtxtSymbol == null) {
			jtxtSymbol = new JTextField();
			jtxtSymbol.setBounds(new Rectangle(178, 33, 99, 29));
			jtxtSymbol.setText("Enter Symbol");
		}
		return jtxtSymbol;
	}
	
	private void jbtnDrawClick(){
		currentSymbol = jtxtSymbol.getText();
		destroyData();
		stockgetter = new StockReciever();
		Calendar nowCalendar = Calendar.getInstance();
		//nowCalendar.set(2011, 1, 25);
		int nowday = nowCalendar.get(Calendar.DATE)/*Integer.parseInt(jTFNewDay.getText())*/;
		int nowmonth = nowCalendar.get(Calendar.MONTH) + 1/*Integer.parseInt(jTFNewMonth.getText())*/;
		int nowyear = nowCalendar.get(Calendar.YEAR)/*Integer.parseInt(jTFNewYear.getText())*/;
		nowCalendar.add(Calendar.DATE, -400);
		int oldday = nowCalendar.get(Calendar.DATE)/*Integer.parseInt(jTFOldDay.getText())*/;
		int oldmonth = nowCalendar.get(Calendar.MONTH) + 1/*Integer.parseInt(jTFOldMonth.getText())*/;
		int oldyear = nowCalendar.get(Calendar.YEAR)/*Integer.parseInt(jTFOldYear.getText())*/;
		clist = stockgetter.getInfo(currentSymbol,oldday,oldmonth,oldyear,nowday,nowmonth,nowyear);
		myQuote = stockgetter.getSingleQuote(currentSymbol);
		//quoteTimer.start();
		ArrayList<candlestick> clist2= stockgetter.getInfo(currentSymbol,oldday,oldmonth,oldyear,nowday,nowmonth,nowyear); 
		
		/*Graphics g4 = getGraphics();
		g4.setColor(Color.WHITE);
		g4.drawString(stockgetter.x() + " ", 100, 100);
		*/
		
		if (clist.size() > 0){
		//System.out.println(CSDraw.findMax(clist) + "Max of clist");
		//System.out.println(CSDraw.findMax(clist2) + "Max of clist2");
//		dojis = pattern.doji(clist);
//		gravestones = pattern.gravestoneDoji(clist);
//		dragonflies = pattern.dragonflyDoji(clist);
//		hammers = pattern.hammer(clist);
//		shootingstars = pattern.shootingStar(clist);
//		bullengulfs = pattern.bullEngulf(clist);
//		bearengulfs = pattern.bearEngulf(clist);
//		darkcloudcovers = pattern.darkCloudCover(clist);
//		piercingpatterns = pattern.piercingPattern(clist);
		
		//myQuote = stockgetter.getSingleQuote(jtxtSymbol.getText());
		pattern.calculatePatterns(clist);
		System.out.println(clist.get(30).date);
		System.out.println(myQuote.name);
		
		Graphics g1 = getGraphics();
		g1.clearRect(0, 0, width, height);
		CSDraw.drawRefresh(g1);
		CSDraw.drawCandles(g1,clist);
		CSDraw.drawPrices(g1, CSDraw.findMin(clist2), CSDraw.findMax(clist2));
		CSDraw.drawDates(g1,clist);
		CSDraw.drawVolume(g1, clist);
		CSDraw.drawPatterns(g1, clist, mt, getCodeBase());
		CSDraw.drawTrendLines(g1,clist);
		CSDraw.drawQuote(g1, myQuote);
		
		
		
//		CSDraw.drawDoji(g1,clist);
//		CSDraw.drawGravestoneDoji(g1,clist);
//		CSDraw.drawDragonflyDoji(g1, clist);
//		//CSDraw.drawHammer(g1, clist, hammers, hammerimg); 
//		CSDraw.drawHammer2(g1, clist, hammerimg);
//		CSDraw.drawShootingStar(g1, clist);
//		CSDraw.drawBullishEngulf(g1, clist);
//		CSDraw.drawBearishEngulf(g1, clist);
//		CSDraw.drawDarkCloudCover(g1, clist);
//		CSDraw.drawPiercingPattern(g1, clist);
		}
		else{
			Component frame = null;
			JOptionPane.showMessageDialog(frame, "Could not find stock: " + currentSymbol);
		}
		
		
	}
	private void destroyData(){
		clist = null;
//		dojis = null;
//		gravestones = null;
//		dragonflies = null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//if (blnDrawFiboOn){
		//System.out.println("sdf");
			//currentlyInLine = true;
			firstpoint = e.getPoint();
			e.consume();
		//}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//if(blnDrawFiboOn && currentlyInLine){
			//blnDrawFiboOn = false;
			currentlyInLine = false;
			secondpoint = e.getPoint();
			Graphics gr = getGraphics();
			gr.setColor(Color.white);
			if(Math.abs(secondpoint.y - firstpoint.y)>60){
			gr.drawLine(firstpoint.x, firstpoint.y, secondpoint.x, secondpoint.y);
			int h = secondpoint.y - firstpoint.y;
			int fib1 = Math.abs((int) (0.382 * h - secondpoint.y));
			int fib2 = Math.abs((int) (0.618 * h - secondpoint.y));
			gr.drawLine(0, fib1, width-100, fib1);
			gr.drawLine(0, fib2, width-100, fib2);
			firstpoint = null;
			secondpoint = null;
			}
			e.consume();
		//}
		
	}

	

}  //  @jve:decl-index=0:visual-constraint="10,10"
