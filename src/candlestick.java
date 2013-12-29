
public class candlestick {
	String date;
	float open, high, low, close, MA10, MA50, MA100;
	long volume;
	public boolean doji, gravestoneDoji, dragonflyDoji, hammer, shootingStar, 
	bearEngulf, bullEngulf, darkCloud, piercePattern, morningStar, eveningStar, harami, bullKicker, bearKicker;
	//public boolean hammer;
candlestick(String date, float open, float high, float low, float close, long volume){
	this.date = date;
	this.open=open;
	this.close = close;
	this.high = high;
	this.low = low;
	this.volume = volume;
}
/*void draw(){
	
}
boolean doji(){
	return false;
}*/

public int getMonth(){
	String month = date.substring(5, 7);
	return Integer.parseInt(month);
}

public int getYear(){
	String year = date.substring(0,4);
	return Integer.parseInt(year);
}

public int getDay(){
	String day = date.substring(8,10);
	return Integer.parseInt(day);
}

public boolean isWhite(){
	if (open < close) {
		return true;
	}else return false;
}

public boolean isBlack(){
	if (open > close) {
		return true;
	}else return false;
}

public float getOpenCloseAvg(){
	return (open + close)/2;
	
}

}
