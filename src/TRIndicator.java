import java.util.ArrayList;



public class TRIndicator {

	boolean doji(candlestick e){
		if((Math.max(e.open,e.close)- Math.min(e.open, e.close)) < 0.00015*e.close) return true;
			else return false;	
	}
	
	boolean[] doji(ArrayList <candlestick> e){
		boolean[] myArray = new boolean[e.size()];
		for(int count = 0;count < e.size();count++){
			myArray[count] = doji(e.get(count));
			e.get(count).doji = myArray[count];
		}
		return myArray;
		
	}
	
	boolean gravestoneDoji(candlestick eg){
		float lowershadow = eg.close - eg.low;
		float uppershadow = eg.high - eg.open;
		if(doji(eg) && (lowershadow <  (0.25 * uppershadow))) return true;
			else return false;	
	}
	
	boolean[] gravestoneDoji(ArrayList <candlestick> e){
		boolean[] myArray = new boolean[e.size()];
		for(int count = 0;count < e.size();count++){
			myArray[count] = gravestoneDoji(e.get(count));
			e.get(count).gravestoneDoji = myArray[count];
		}
		return myArray;
		
	}
	
	boolean dragonflyDoji(candlestick e){
		float lowershadow = e.close - e.low;
		float uppershadow = e.high - e.open;
		if(doji(e) && (uppershadow < (0.25 * lowershadow))) return true;
			else return false;	
	}
	
	boolean[] dragonflyDoji(ArrayList <candlestick> e){
		boolean[] myArrayfly = new boolean[e.size()];
		for(int count = 0;count < e.size();count++){
			myArrayfly[count] = dragonflyDoji(e.get(count));
			e.get(count).dragonflyDoji = myArrayfly[count];
		}
		return myArrayfly;
		
	}
	
	boolean hammer(candlestick e){
		float lowershadow = e.close - e.low;
		float uppershadow = e.high - e.open;
		float realbody = Math.abs(e.close - e.open);
		if((lowershadow > (2 * realbody)) && (uppershadow <(0.2*lowershadow)) && doji(e)!= true) return true;
			else return false;	
	}
	
	boolean[] hammer(ArrayList <candlestick> e){
		boolean[] myArray = new boolean[e.size()];
		for(int count = 0;count < e.size();count++){
			myArray[count] = hammer(e.get(count));
			e.get(count).hammer = myArray[count];
		}
		return myArray;
		
	}
	
	boolean shootingStar(candlestick e){
		float lowershadow = e.close - e.low;
		float uppershadow = e.high - e.open;
		float realbody = Math.abs(e.close - e.open);
		if((uppershadow > (2 * realbody)) && (lowershadow <(0.2*uppershadow)) && doji(e)!= true) return true;
			else return false;	
	}
	
	boolean[] shootingStar(ArrayList <candlestick> e){
		boolean[] myArray = new boolean[e.size()];
		for(int count = 0;count < e.size();count++){
			myArray[count] = shootingStar(e.get(count));
			e.get(count).shootingStar = myArray[count];
		}
		return myArray;
		
	}
	
	boolean[] bullEngulf(ArrayList <candlestick> e){
		boolean[] myArray = new boolean[e.size()];
		
		for(int count = 1;count < e.size();count++){
			
			candlestick c1 = e.get(count-1);
			candlestick c2 = e.get(count);
			
			if((c1.isBlack() || doji(c1)) && c2.isWhite()){
				if(c1.open<c2.close){
					if(c1.close>c2.open){
						myArray[count] = true;
					}else myArray[count] = false;
				}
			}
			
			c2.bullEngulf = myArray[count];
		}
		
		return myArray;
		
	}
	
	boolean[] bearEngulf(ArrayList <candlestick> e){
		boolean[] myArray = new boolean[e.size()];
		
		for(int count = 1;count < e.size();count++){
			candlestick c1 = e.get(count-1);
			candlestick c2 = e.get(count);

			
			if((c1.isWhite() || doji(c1)) && c2.isBlack()){
				if(c1.open>c2.close){
					if(c1.close<c2.open){
						myArray[count] = true;
					} else myArray[count] = false;
				}
			}
			c2.bearEngulf = myArray[count];
		}
		return myArray;
		
	}
		
	boolean[] darkCloudCover(ArrayList <candlestick> e){
		boolean[] myArray = new boolean[e.size()];
		
		for(int count = 1;count < e.size();count++){
			//float realbody = Math.abs(e.get(count).close - e.get(count).open);
			candlestick c1 = e.get(count-1);
			candlestick c2 = e.get(count);
			if (c1.isWhite() && c2.isBlack()){
				
				if (c2.open > c1.high){
					
					if(c2.close < c1.getOpenCloseAvg() && c2.close > c1.open){
						myArray[count] = true;
					}
				}
				
			}
			//myArray[count] = bullEngulf(e.get(count));
			c2.darkCloud = myArray[count];
		}
		return myArray;
	}
	
	boolean[] piercingPattern(ArrayList <candlestick> e){
		boolean[] myArray = new boolean[e.size()];
		
		for(int count = 1;count < e.size();count++){
			//float realbody = Math.abs(e.get(count).close - e.get(count).open);
			candlestick c1 = e.get(count-1);
			candlestick c2 = e.get(count);
			if (c1.isBlack() && c2.isWhite()){
				
				if (c2.open < c1.low){
					
					if(c2.close > c1.getOpenCloseAvg() && c2.close < c1.open){
						myArray[count] = true;
					}
				}
				
			}
			//myArray[count] = bullEngulf(e.get(count));
			c2.piercePattern = myArray[count];
		}
		return myArray;
	}

	
	public void morningStar(ArrayList <candlestick> e){
		for(int count = 2;count< e.size();count++){
			candlestick c1 = e.get(count-2);
			candlestick c2 = e.get(count-1);
			candlestick c3 = e.get(count);
			if(c1.isBlack() && c3.isWhite()){
				if(c2.open < c1.close && c2.close < c1.close){
					if(c3.close > c1.getOpenCloseAvg()){
						c3.morningStar = true;
					} else c3.morningStar = false;
					
				}
				
			}
		}
	}
	
	private void eveningStar(ArrayList<candlestick> e) {
		for(int count = 2;count< e.size();count++){
			candlestick c1 = e.get(count-2);
			candlestick c2 = e.get(count-1);
			candlestick c3 = e.get(count);
			if(c1.isWhite() && c3.isBlack()){
				if(c2.open > c1.close && c2.close > c1.close){
					if(c3.close < c1.getOpenCloseAvg()){
						c3.eveningStar = true;
					} else c3.eveningStar = false;
					
				}
				
			}
		}
		
	}
	
	private void harami(ArrayList<candlestick> e) {
		for(int count = 1; count<e.size();count++){
			candlestick c1 = e.get(count-1);
			candlestick c2 = e.get(count);
			if(c1.isBlack()){
				if (c2.open<c1.open && c2.open>c1.close){
					if(c2.close< c1.open && c2.close > c1.close){
						if (uptrend(e,count)){
						c2.harami = true;
						}
					} 
				}
			}else{
				if (c2.open>c1.open && c2.open<c1.close){
					if(c2.close> c1.open && c2.close < c1.close){
						c2.harami = true;
					} 
				}
			}
		}
		
	}
	
	private void bullKicker(ArrayList<candlestick> e){
		for(int count = 3;count<e.size();count++){
			candlestick c1 = e.get(count-3);
			candlestick c2 = e.get(count-2);
			candlestick c3 = e.get(count-1);
			candlestick c4 = e.get(count);
			if(downtrend(e,count-1) && c4.isWhite()){
				c4.bullKicker = true;
			}
		}
	}
	
	private void bearKicker(ArrayList<candlestick> e){
		for(int count = 3;count<e.size();count++){
			candlestick c1 = e.get(count-3);
			candlestick c2 = e.get(count-2);
			candlestick c3 = e.get(count-1);
			candlestick c4 = e.get(count);
			if(uptrend(e,count-1) && c4.isBlack()){
				c4.bullKicker = true;
			}
		}
	}
	
	boolean uptrend(ArrayList<candlestick> e, int index){
		if(index>1){
		candlestick c1 = e.get(index - 2);
		candlestick c2 = e.get(index - 1);
		candlestick c3 = e.get(index);
		if(c1.isWhite() && c2.isWhite() && c3.isWhite()){
			if(c3.close > c2.close && c2.close > c1.close){
			return true;
			}else return false;
		} else return false;
	} else return false;
	}
	
	boolean downtrend(ArrayList<candlestick> e, int index){
		if(index>1){
			candlestick c1 = e.get(index - 2);
			candlestick c2 = e.get(index - 1);
			candlestick c3 = e.get(index);
			if(c1.isBlack() && c2.isBlack() && c3.isBlack()){
				if(c3.close < c2.close && c2.close < c1.close){
				return true;
				}else return false;
			} else return false;
		} else return false;
	}
	
	public void calculatePatterns(ArrayList<candlestick> e) {
		// TODO Auto-generated method stub
		doji(e);
		gravestoneDoji(e);
		dragonflyDoji(e);
		hammer(e);
		shootingStar(e);
		bullEngulf(e);
		bearEngulf(e);
		darkCloudCover(e);
		piercingPattern(e);
		morningStar(e);
		eveningStar(e);
		harami(e);
		bullKicker(e);
		bearKicker(e);
		calculateAverages(e);
		
	}
	
	public void calculateAverages(ArrayList<candlestick> e){
		
		ArrayList<Float> prices = new ArrayList<Float>();
		//if(e.size()>200){
		for(int i = 0;i<50;i++){
			prices.add(e.get(i).close);
		}
		for(int i = 50;i<e.size();i++){
		e.get(i).MA50 = AvgOf(prices);
		System.out.println("avg is: " + AvgOf(prices));
		prices.remove(0);
		if(e.get(i).close>0){
		prices.add(49,e.get(i).close);
		System.out.println("adding: " + e.get(i).close);
		}
		}
		
		
		ArrayList<Float> prices2 = new ArrayList<Float>();
		for(int i = 0;i<10;i++){
			prices2.add(e.get(i).close);
		}
		for(int i = 10;i<e.size();i++){
		e.get(i).MA10 = AvgOf(prices2);
		System.out.println("avg is: " + AvgOf(prices2));
		prices2.remove(0);
		if(e.get(i).close>0){
		prices2.add(9,e.get(i).close);
		System.out.println("adding: " + e.get(i).close);
		}
		}
		
		ArrayList<Float> prices3 = new ArrayList<Float>();
		for(int i = 0;i<100;i++){
			prices3.add(e.get(i).close);
		}
		for(int i = 100;i<e.size();i++){
		e.get(i).MA100 = AvgOf(prices3);
		System.out.println("avg is: " + AvgOf(prices3));
		prices3.remove(0);
		if(e.get(i).close>0){
		prices3.add(99,e.get(i).close);
		System.out.println("adding: " + e.get(i).close);
		}
		}
		//}
		
	}

	private float AvgOf(ArrayList<Float> prices) {
		float sum = 0;
		for(float f : prices){
			sum+=f;
		}
		return sum/prices.size();
	}

}
