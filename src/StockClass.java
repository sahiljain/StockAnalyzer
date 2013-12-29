import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.awt.*;
import java.applet.*; 
import java.util.*;


public class StockClass extends Applet{
	
	private static final long serialVersionUID = 1L;
	//candlestick csticks[] = new candlestick[10];
	ArrayList<candlestick> clist = new ArrayList<candlestick>();
	int width, height;
	int startday = 1;
	int startmonth = 1;
	int startyear = 2009;
	int endday = 29;
	int endmonth = 10;
	int endyear = 2010;
	String symbol = "GOOG";
	//String[][]stocks = new String[6][500];
	public void init(){
	width = 1680;
	height = 1050;
	makearray();
	
	setSize(width,height);
	}
	
	public void paint (Graphics g){
		g.fillRect(0, 0, getSize().width, getSize().height);
		g.setColor(Color.white);
		//clist.add(new candlestick())
		for(int a = 1;a<clist.size();a++){
			
			//g.drawLine(a, Integer.parseInt(stocks[3][a]), a+1, Integer.parseInt(stocks[3][a+1]));
			//g.fillOval(a*3, height - (Math.round(Float.valueOf(stocks[3][a]).floatValue())), 5, 5);
			//g.drawLine(a*3, height - (Math.round(Float.valueOf(stocks[3][a]).floatValue())), a*3+3, height - (Math.round(Float.valueOf(stocks[3][a+1]).floatValue())));
			g.drawLine(a*10, height - (Math.round(clist.get(a).high)), a*10, height - (Math.round(clist.get(a).low)));
			if(Math.round(clist.get(a).open)> Math.round(clist.get(a).close)){
				//fillrect
				//g.s
				g.fillRect(a*10-3, height - Math.round(clist.get(a).open), 6,Math.round(clist.get(a).open)-Math.round(clist.get(a).close));
				
			}else
			{
				//drawrect
				g.drawRect(a*10-3, height -Math.round(clist.get(a).close), 6,Math.round(clist.get(a).close)-Math.round(clist.get(a).open));
				g.setColor(Color.black);
				g.fillRect(a*10-3+1, 1 + height -(Math.round(clist.get(a).close)), 6-1,Math.round(clist.get(a).close)-Math.round(clist.get(a).open)-1 );
				g.setColor(Color.white);
			}
			System.out.println(clist.get(a).high+"\t" +clist.get(a).low +"\t" +clist.get(a).open +"\t" +clist.get(a).close);
		}
		//g.drawLine(x1, y1, x2, y2);
	}
	
public void makearray(){
	
	try {
		URL urlTemplate = new URL("http://ichart.finance.yahoo.com/table.csv?s="+
				symbol+"&a="+startmonth+"&b="+startday+"&c="+startyear+"&d="+endmonth+
				"&e="+endday+"&f="+endyear+"&g=d&ignore=.csv");
		URLConnection yc = urlTemplate.openConnection();
		 BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		 String inputline;
		 
		 
		 			for(int y = 0;(inputline = in.readLine())!=null;y++){
		 					String stocks1[]  = inputline.split(",");
		 					//System.out.println(stocks1[2]);
		 					if(y>0){
		 					clist.add(new candlestick(stocks1[0],Float.valueOf(stocks1[1]),Float.valueOf(stocks1[2]),Float.valueOf(stocks1[3]),Float.valueOf(stocks1[4]),Long.valueOf(stocks1[5])));
		 					}
		 					/*for(int x = 0;x < 6; x++){
		 							stocks[x][y] = stocks1[x];
		 							
		 						}*/
		 				}
		 //System.out.println(stocks[0][0]);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
