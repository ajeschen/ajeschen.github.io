
public class House implements Comparable<House>{
int caseNum;
int price;
double distance;
int size;

	public House(int caseNum2, int price2, double distance2, int size2){
		caseNum=caseNum2;
		price=price2;
		distance=distance2;
		size=size2;
	}
	
	public int getCaseNum(){
		return caseNum;
	}
	
	public int getPrice(){
		return price;
	}
	
	public double getDistance(){
		return distance;
	}
	
	public int getSize(){
		return size;
	}

	@Override
	public int compareTo(House compareHouse) {
		int comparePrice = ((House) compareHouse).getPrice(); 
		
		//ascending order
		return this.price - comparePrice;
		
		//descending order
		//return compareQuantity - this.quantity;
	}
	
}
