import java.awt.image.*;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormatSymbols;
import javax.imageio.ImageIO;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.MediaTracker;

import java.util.ArrayList;


public class DrawHelper implements ImageObserver{
	TRIndicator pattern2 = new TRIndicator();
	int height = 600;
	int width = 1600;
	BufferedImage hammerimg;
	BufferedImage dojiimg;
	BufferedImage shootingstarimg;
	BufferedImage bullimg;
	BufferedImage bearimg;
	BufferedImage morningimg;
	BufferedImage eveningimg;
	//MediaTracker mt;
	DrawHelper(){
		 

}

public void draw(Graphics g) {

	// TODO Auto-generated method stub
	g.drawRect(0, 0, 10, 10);
}


public void drawCandles2(Graphics gr, ArrayList<candlestick> inpCandles2){
	ArrayList<candlestick> inpCandles = inpCandles2;
	inpCandles = scaleCandles(inpCandles);
	for(int a = 0;a<inpCandles.size();a++){
		
		int open = Math.round(inpCandles.get(a).open);
		int close = Math.round(inpCandles.get(a).close);
		int high = Math.round(inpCandles.get(a).high);
		int low = Math.round(inpCandles.get(a).low);
		
		gr.drawLine(a*10, height - high, a*10, height - low);
		if(close > open){
		
			gr.fillRect(a*10-3, height - close, 6,close - open);
		
		}else
		{
			
			gr.drawRect(a*10-3, height - open, 6,open - close);
			gr.setColor(Color.black);
			gr.fillRect(a*10-3+1, 1 + (height - open), 6-1,(open - close) - 1);
			gr.setColor(Color.white);
		}
	
		
	}
	
}

public void drawCandles(Graphics gr, ArrayList<candlestick> inpCandles2){
	ArrayList<candlestick> inpCandles = inpCandles2;
	inpCandles = scaleCandles(inpCandles);
	int x = width-101;
	for(int a = inpCandles.size()-1;a>=0;a--){
		
		int open = Math.round(inpCandles.get(a).open);
		int close = Math.round(inpCandles.get(a).close);
		int high = Math.round(inpCandles.get(a).high);
		int low = Math.round(inpCandles.get(a).low);
		
		gr.drawLine(x, height - high, x, height - low);
		if(close > open){
		
			gr.fillRect(x-3, height - close, 6,close - open);
		
		}else
		{
			
			gr.drawRect(x-3, height - open, 6,open - close);
			gr.setColor(Color.black);
			gr.fillRect(x-2, 1 + (height - open), 5,(open - close) - 1);
			gr.setColor(Color.white);
		}
	
		x-=10;
	}
	
}

public void drawDoji(Graphics gr, ArrayList<candlestick> inpCandles){
	gr.setColor(Color.GREEN);
	//int height = 500;
	//int x = width-100;
	inpCandles = scaleCandles(inpCandles);
	for(int count = 0;count<inpCandles.size();count++){
		if(inpCandles.get(count).doji){
			gr.fillOval(count * 10-6, height - (Math.round(inpCandles.get(count).high)) - 20, 12, 12);
		}
	}
gr.setColor(Color.white);
}

public void drawGravestoneDoji(Graphics gr, ArrayList<candlestick> inpCandles){
	gr.setColor(Color.BLUE);
	//int height = 500;
	inpCandles = scaleCandles(inpCandles);
	for(int count = 0;count<inpCandles.size();count++){
		if(inpCandles.get(count).gravestoneDoji){
			gr.fillOval(count * 10-6, height - (Math.round(inpCandles.get(count).high)) - 35, 12, 12);
		}
	}
gr.setColor(Color.white);
}

public void drawDragonflyDoji(Graphics gr, ArrayList<candlestick> inpCandles){
	gr.setColor(Color.YELLOW);
	//int height = 500;
	inpCandles = scaleCandles(inpCandles);
	for(int count = 0;count<inpCandles.size();count++){
		if(inpCandles.get(count).dragonflyDoji){
			gr.fillOval(count * 10-6, height - (Math.round(inpCandles.get(count).high)) - 50, 12, 12);
		}
	}
gr.setColor(Color.white);
}

public void drawHammer(Graphics gr, ArrayList<candlestick> inpCandles, BufferedImage img){
	//Image hammer = getImage();
	gr.setColor(Color.MAGENTA);
	//int height = 500;
	inpCandles = scaleCandles(inpCandles);
	for(int count = 0;count<inpCandles.size();count++){
		if(inpCandles.get(count).hammer){
			//gr.fillOval(count * 10-6, height - (Math.round(inpCandles.get(count).high)) - 50, 12, 12);
			gr.drawImage(img, count * 10 - 8, height - (Math.round(inpCandles.get(count).high)) - 50,19,19, this);
		}
	}
gr.setColor(Color.white);
}

public void drawShootingStar(Graphics gr, ArrayList<candlestick> inpCandles){
	gr.setColor(Color.LIGHT_GRAY);
	//int height = 500;
	inpCandles = scaleCandles(inpCandles);
	for(int count = 0;count<inpCandles.size();count++){
		if(inpCandles.get(count).shootingStar){
			gr.fillOval(count * 10-6, height - (Math.round(inpCandles.get(count).high)) - 50, 12, 12);
		}
	}
gr.setColor(Color.white);
}

public void drawBullishEngulf(Graphics gr, ArrayList<candlestick> inpCandles){
	gr.setColor(Color.CYAN);
	//int height = 500;
	inpCandles = scaleCandles(inpCandles);
	for(int count = 0;count<inpCandles.size();count++){
		if(inpCandles.get(count).bullEngulf){
			gr.fillOval(count * 10-6, height - (Math.round(inpCandles.get(count).high)) - 50, 12, 12);
		}
	}
gr.setColor(Color.white);
}

public void drawBearishEngulf(Graphics gr, ArrayList<candlestick> inpCandles){
	gr.setColor(Color.ORANGE);
	//int height = 500;
	inpCandles = scaleCandles(inpCandles);
	for(int count = 0;count<inpCandles.size();count++){
		if(inpCandles.get(count).bearEngulf){
			gr.fillOval(count * 10-6, height - (Math.round(inpCandles.get(count).high)) - 55, 12, 12);
		}
	}
gr.setColor(Color.white);
}

public void drawDarkCloudCover(Graphics gr, ArrayList<candlestick> inpCandles){
	gr.setColor(Color.RED);
	//int height = 500;
	inpCandles = scaleCandles(inpCandles);
	for(int count = 0;count<inpCandles.size();count++){
		if(inpCandles.get(count).darkCloud){
			gr.fillOval(count * 10-6, height - (Math.round(inpCandles.get(count).high)) - 59, 12, 12);
		}
	}
gr.setColor(Color.white);
}

public void drawPiercingPattern(Graphics gr, ArrayList<candlestick> inpCandles){
	gr.setColor(Color.GREEN);
	//gr.draw
	//int height = 500;
	inpCandles = scaleCandles(inpCandles);
	for(int count = 0;count<inpCandles.size();count++){
		if(inpCandles.get(count).piercePattern){
			gr.fillOval(count * 10-6, height - (Math.round(inpCandles.get(count).high)) - 65, 12, 12);
		}
	}
gr.setColor(Color.white);
}

public void drawVolume(Graphics gr, ArrayList<candlestick> inpCandles){
	int x = width-101;
	gr.drawLine(0, height + 100, width, height + 100);
	
	float max = inpCandles.get(0).volume;
	float coeff;
	for(int count = 0;count <inpCandles.size();count++){
		if(inpCandles.get(count).volume> max){
			max = inpCandles.get(count).volume;
	
		}
	}
	coeff = 100/max;
	for(int c = 0; c<inpCandles.size();c++){
		inpCandles.get(c).volume = (long) (inpCandles.get(c).volume * coeff);
	
	}
	for(int count = inpCandles.size()-1;count >=0;count--){
		gr.drawRect(x, height + 200 - Math.round(inpCandles.get(count).volume), 5, Math.round(inpCandles.get(count).volume));
	x-=10;
	}
	
	
}

public void drawRefresh(Graphics gr){
	gr.setColor(Color.BLACK);
	gr.drawRect(0,0,width, height);
	gr.setColor(Color.WHITE);
}

public void drawPrices2(Graphics gr, ArrayList<candlestick> inpCandles){
	float max = findMax(inpCandles);
	float min = findMin(inpCandles);
	gr.drawLine(width - 100, 0, width - 100, height + 100);
	gr.drawString(String.valueOf(max), width - 100, 100);
	gr.drawString(String.valueOf(min), width - 100, height);
}

public void drawPrices(Graphics gr, float min, float max){
	gr.setColor(Color.GRAY);
	gr.drawLine(width - 100, 0, width - 100, height + 100);
	gr.drawLine(0,150,width - 100,150);
	gr.drawLine(0,height + 50,width - 100,height + 50);
	gr.setColor(Color.WHITE);
	gr.drawString(String.valueOf(max), width - 100, 150);
	gr.drawString(String.valueOf(min), width - 100, height+50);
}

public float findMin(ArrayList<candlestick> inpCandles){
	
	float min = inpCandles.get(0).low;
	for(int b  = 0;b<inpCandles.size();b++){
	if (inpCandles.get(b).low<min){
		min = inpCandles.get(b).low;
	}
	}
	return min;
}

public float findMax(ArrayList<candlestick> inpCandles){
	float max = inpCandles.get(0).high;
	for(int a  = 0;a<inpCandles.size();a++){
	if (inpCandles.get(a).high>max){
		max = inpCandles.get(a).high;
	}
	}
	return max;
}

public ArrayList<candlestick> scaleCandles(ArrayList<candlestick> inpCandles){
	float max = findMax(inpCandles);
	float min = findMin(inpCandles);
	float difference = max - min;
	float coeff = 500/difference;
	for(int c = 0; c<inpCandles.size();c++){
		inpCandles.get(c).open = (inpCandles.get(c).open - min)*coeff - 50;
		inpCandles.get(c).high = (inpCandles.get(c).high - min)*coeff - 50;
		inpCandles.get(c).low = (inpCandles.get(c).low - min)*coeff - 50;
		inpCandles.get(c).close = (inpCandles.get(c).close - min)*coeff - 50;
		inpCandles.get(c).MA10 = (inpCandles.get(c).MA10 - min)*coeff - 50;
		inpCandles.get(c).MA50 = (inpCandles.get(c).MA50 - min)*coeff - 50;
		inpCandles.get(c).MA100 = (inpCandles.get(c).MA100 - min)*coeff - 50;
	}
	return inpCandles;
	
}

//public void drawSwingComponents(Container cp){
//
//
//	cp.setLayout(null);
//	JTextField myField = new JTextField("Enter Symbol", 10);
//	myField.setLocation(0, 0);
//	//myField.setSize(50, 90);
//	cp.add(myField);
//	cp.setVisible(true);
//	
//
//	}


public void drawDates(Graphics g1, ArrayList<candlestick> inpCandles) {
	int x = width-101;
	String[] shortMonths = new DateFormatSymbols().getShortMonths();
	int prevMonth = inpCandles.get(inpCandles.size()-1).getMonth();
	for(int i = inpCandles.size()-1;i>=0;i--){
		if (inpCandles.get(i).getMonth() != prevMonth){
			prevMonth = inpCandles.get(i).getMonth();
			String toOutMonth = shortMonths[inpCandles.get(i).getMonth()-1] + " " + Integer.toString(inpCandles.get(i).getYear());
			//int xOfStringToOut = i*10;
			g1.drawString(toOutMonth, x-75, height + 98);
			g1.setColor(Color.gray);
			g1.drawLine(x-5,0,x-5,height + 100);
			g1.setColor(Color.white);
		}
		x-=10;
	}
	g1.drawString(shortMonths[inpCandles.get(inpCandles.size()-1).getMonth()-1]+" "+ Integer.toString(inpCandles.get(inpCandles.size()-1).getYear()), width-101-75, height + 98);
}

public void drawDatesOld(Graphics g1, ArrayList<candlestick> inpCandles) {
	String[] shortMonths = new DateFormatSymbols().getShortMonths();
	int prevMonth = 42;
	for(int i = 0;i<inpCandles.size();i++){
		if (inpCandles.get(i).getMonth() != prevMonth){
			prevMonth = inpCandles.get(i).getMonth();
			String toOutMonth = shortMonths[inpCandles.get(i).getMonth()-1] + " " + Integer.toString(inpCandles.get(i).getYear());
			int xOfStringToOut = i*10;
			g1.drawString(toOutMonth, xOfStringToOut+25, height + 98);
			g1.setColor(Color.gray);
			g1.drawLine(xOfStringToOut-5,0,xOfStringToOut-5,height + 100);
			g1.setColor(Color.white);
		}
	}
	
}

@Override
public boolean imageUpdate(Image img, int infoflags, int x, int y, int width,
		int height) {
	// TODO Auto-generated method stub
	return false;
}

public void drawHammer2(Graphics gr, ArrayList<candlestick> inpCandles, BufferedImage img) {

	for(int count = 0;count<inpCandles.size();count++){
		if(inpCandles.get(count).hammer){
			//gr.fillOval(count * 10-6, height - (Math.round(inpCandles.get(count).high)) - 50, 12, 12);
			gr.drawImage(img, count * 10 - 8, height - (Math.round(inpCandles.get(count).high)) - 25,19,19, this);
		}
	}
gr.setColor(Color.white);
	
}
public void drawPatterns(Graphics gr, ArrayList<candlestick> e, MediaTracker mt, URL codeBase) {
	int x = width-101;
	try {
        URL url = new URL(codeBase, "hammer.gif");
        hammerimg = ImageIO.read(url);
        URL url2 = new URL(codeBase, "doji.gif");
        dojiimg = ImageIO.read(url2);
        URL url3 = new URL(codeBase, "shootingstar.gif");
        shootingstarimg = ImageIO.read(url3);
        URL url4 = new URL(codeBase, "bull.gif");
        bullimg = ImageIO.read(url4);
        URL url5 = new URL(codeBase, "bear.gif");
        bearimg = ImageIO.read(url5);
        URL url6 = new URL(codeBase, "morning.gif");
        morningimg = ImageIO.read(url6);
        URL url7 = new URL(codeBase, "evening.gif");
        eveningimg = ImageIO.read(url7);
    } catch (IOException ex) {
    }
    mt.addImage(hammerimg,1);
    mt.addImage(dojiimg,2);
    mt.addImage(shootingstarimg,3);
    mt.addImage(bullimg,4);
    mt.addImage(bearimg,5);
    mt.addImage(morningimg,6);
    mt.addImage(eveningimg,7);
    try {
        mt.waitForAll();
   }
   catch (InterruptedException  iex) {}
   
	for(int count = e.size()-1; count>=0;count--){
		int numPicsDisplayed = -2;
		candlestick c1 = e.get(count);
		
		if(c1.doji){
			numPicsDisplayed++;
			gr.drawImage(dojiimg, x - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.hammer){
			numPicsDisplayed++;
			gr.drawImage(hammerimg, x - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.shootingStar){
			numPicsDisplayed++;
			gr.drawImage(shootingstarimg, x - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.bullEngulf){
			numPicsDisplayed++;
			gr.drawImage(bullimg, x - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.bearEngulf){
			numPicsDisplayed++;
			gr.drawImage(bearimg, x - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.darkCloud){
			numPicsDisplayed++;
			gr.drawImage(dojiimg, x - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.dragonflyDoji){
			numPicsDisplayed++;
			gr.drawImage(dojiimg, x - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.gravestoneDoji){
			numPicsDisplayed++;
			gr.drawImage(dojiimg, x - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.piercePattern){
			numPicsDisplayed++;
			gr.drawImage(dojiimg, x - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.morningStar){
			numPicsDisplayed++;
			gr.drawImage(morningimg, x - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.eveningStar){
			numPicsDisplayed++;
			gr.drawImage(eveningimg, x - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.harami){
			numPicsDisplayed++;
			gr.drawImage(dojiimg, x - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.bullKicker){
			numPicsDisplayed++;
			gr.drawImage(bullimg, x - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.bearKicker){
			numPicsDisplayed++;
			gr.drawImage(bearimg, x - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		x-=10;
	}
	
}
public void drawPatternsold(Graphics gr, ArrayList<candlestick> e, MediaTracker mt, URL codeBase) {
	try {
        URL url = new URL(codeBase, "hammer.gif");
        hammerimg = ImageIO.read(url);
        URL url2 = new URL(codeBase, "doji.gif");
        dojiimg = ImageIO.read(url2);
        URL url3 = new URL(codeBase, "shootingstar.gif");
        shootingstarimg = ImageIO.read(url3);
        URL url4 = new URL(codeBase, "bull.gif");
        bullimg = ImageIO.read(url4);
        URL url5 = new URL(codeBase, "bear.gif");
        bearimg = ImageIO.read(url5);
        URL url6 = new URL(codeBase, "morning.gif");
        morningimg = ImageIO.read(url6);
        URL url7 = new URL(codeBase, "evening.gif");
        eveningimg = ImageIO.read(url7);
    } catch (IOException ex) {
    }
    mt.addImage(hammerimg,1);
    mt.addImage(dojiimg,2);
    mt.addImage(shootingstarimg,3);
    mt.addImage(bullimg,4);
    mt.addImage(bearimg,5);
    mt.addImage(morningimg,6);
    mt.addImage(eveningimg,7);
    try {
        mt.waitForAll();
   }
   catch (InterruptedException  iex) {}
   
	for(int count = 0; count<e.size();count++){
		int numPicsDisplayed = -2;
		candlestick c1 = e.get(count);
		
		if(c1.doji){
			numPicsDisplayed++;
			gr.drawImage(dojiimg, count * 10 - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.hammer){
			numPicsDisplayed++;
			gr.drawImage(hammerimg, count * 10 - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.shootingStar){
			numPicsDisplayed++;
			gr.drawImage(shootingstarimg, count * 10 - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.bullEngulf){
			numPicsDisplayed++;
			gr.drawImage(bullimg, count * 10 - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.bearEngulf){
			numPicsDisplayed++;
			gr.drawImage(bearimg, count * 10 - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.darkCloud){
			numPicsDisplayed++;
			gr.drawImage(dojiimg, count * 10 - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.dragonflyDoji){
			numPicsDisplayed++;
			gr.drawImage(dojiimg, count * 10 - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.gravestoneDoji){
			numPicsDisplayed++;
			gr.drawImage(dojiimg, count * 10 - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.piercePattern){
			numPicsDisplayed++;
			gr.drawImage(dojiimg, count * 10 - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.morningStar){
			numPicsDisplayed++;
			gr.drawImage(morningimg, count * 10 - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.eveningStar){
			numPicsDisplayed++;
			gr.drawImage(eveningimg, count * 10 - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.harami){
			numPicsDisplayed++;
			gr.drawImage(dojiimg, count * 10 - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.bullKicker){
			numPicsDisplayed++;
			gr.drawImage(bullimg, count * 10 - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
		if(c1.bearKicker){
			numPicsDisplayed++;
			gr.drawImage(bearimg, count * 10 - 10, height - Math.round(c1.high - 27)- numPicsDisplayed*25 - 100, 25, 25, this);
		}
	}
	
}


public void drawTrendLines(Graphics g1, ArrayList<candlestick> e) {
	int x = width - 101;
	
	System.out.println("lalala");
	for(int i = e.size()-1;i>0;i--){
		g1.setColor(Color.CYAN);
		g1.drawLine(x, height - Math.round(e.get(i).MA50), x-10, height - Math.round(e.get(i-1).MA50));
		g1.setColor(Color.RED);
		g1.drawLine(x, height - Math.round(e.get(i).MA10), x-10, height - Math.round(e.get(i-1).MA10));
		g1.setColor(Color.GREEN);
		g1.drawLine(x, height - Math.round(e.get(i).MA100), x-10, height - Math.round(e.get(i-1).MA100));
		//System.out.println(e.get(i).MA50);
		x-=10;
	}
	
}

public void drawQuote(Graphics gr, quote q) {
	// TODO Auto-generated method stub
	gr.setColor(Color.BLACK);
	gr.fillRect(width-90, 0, 100, 125);
	System.out.println("drawing the quote");
	Font origfont = gr.getFont();
	gr.setColor(Color.white);
	gr.drawString(q.name, width-200, 25);
	if(q.difference > 0){
		gr.setColor(Color.GREEN);
	}else if(q.difference < 0){
		gr.setColor(Color.RED);
	} else{
		gr.setColor(Color.GRAY);
	}
	String priceout = String.valueOf(q.price);
	
	gr.setFont(new Font(origfont.getName(),Font.BOLD,origfont.getSize() + 6));
	gr.drawString(priceout, width-90, 90);	
	gr.setFont(origfont);
	gr.drawString(q.difference + "", width-90, 110);
	
}

}
