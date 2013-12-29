import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;
public class StockReciever{

	//ArrayList<candlestick> clist1 = new ArrayList<candlestick>();
	//Calendar cal = Calendar.getInstance();
	public int x(){
		return 43;
	}
	int width, height;
	int startday ;
	int startmonth;
	int startyear;
	int endday;
	int endmonth;
	int endyear;
	String symbol;
	
	StockReciever(){
		
	}
	public ArrayList<candlestick> getInfo(String symbol, int startday, int startmonth, int startyear, int endday, int endmonth, int endyear){

		ArrayList<candlestick> clist1 = new ArrayList<candlestick>();
		this.symbol = symbol;
		this.startday = startday;
		this.startmonth = startmonth;
		this.startyear = startyear;
		this.endday = endday;
		this.endmonth = endmonth;
		this.endyear = endyear;
		
		try {
			URL urlTemplate = new URL("http://ichart.finance.yahoo.com/table.csv?s="+
					symbol+"&a="+(startmonth - 1)+"&b="+startday+"&c="+startyear+"&d="+(endmonth-1)+
					"&e="+endday+"&f="+endyear+"&g=d&ignore=.csv");
			URLConnection yc = urlTemplate.openConnection();
			 BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			 String inputline;
			 
			 
			 			for(int y = 0;(inputline = in.readLine())!=null;y++){
			 				System.out.println(inputline);
			 					String stocks1[]  = inputline.split(",");
			 					//System.out.println(stocks1[2]);
			 					if(y>0){
			 					clist1.add(new candlestick(stocks1[0],Float.valueOf(stocks1[1]),Float.valueOf(stocks1[2]),Float.valueOf(stocks1[3]),Float.valueOf(stocks1[4]),Long.valueOf(stocks1[5])));
			 					}
			 				}
			 			//System.out.println("Before reversal");
			//for(int x = 0;x<clist1.size();x++){
			//	System.out.println(clist1.get(x).open + "\t " + clist1.get(x).close);
			//}
		Collections.reverse(clist1);
		//System.out.println("after reversal");
		//for(int x = 0;x<clist1.size();x++){
		//	System.out.println(clist1.get(x).open + "\t " + clist1.get(x).close);
		//}
		} catch (Exception e) {
		//e.printStackTrace();
		
			
			

			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return clist1;
	
	}
	
	public quote getSingleQuote(String symbol){
		quote myQuote = new quote();
		try {
			URL urlTemplate1 = new URL("http://finance.yahoo.com/d/quotes.csv?s="+symbol+"&f=nl1c6");
			URLConnection yc1 = urlTemplate1.openConnection();
			 BufferedReader in1 = new BufferedReader(new InputStreamReader(yc1.getInputStream()));
			 String inputline1 = in1.readLine();
			 
			 
			 			
			 					String stocks2[]  = inputline1.split(",");
			 					myQuote.name = stocks2[0].substring(1, stocks2[0].length()-1);
			 					myQuote.price = Float.parseFloat(stocks2[1]);
			 					String sign = stocks2[2].substring(1, 2);
			 					System.out.println(sign);
			 					String differenceUnsigned = stocks2[2].substring(2, stocks2[2].length()-1);
			 					if(sign.equals("+")){
			 					myQuote.difference = Float.parseFloat(differenceUnsigned);
			 					} else if (sign.equals("-")){
			 						myQuote.difference = 0- Float.parseFloat(differenceUnsigned);
			 					} else{
			 						System.out.println("Error parsing quote");
			 					}
			 					
		} catch (Exception e) {
		e.printStackTrace();
		
			
			

			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		System.out.println(myQuote.name);
		return myQuote;
		
	}
}


