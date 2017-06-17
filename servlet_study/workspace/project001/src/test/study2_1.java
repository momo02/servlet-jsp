package test;

public class study2_1 {
	public static void main(String[] args) {
		// 10000원짜리 맥북 생성
		NoteBook notebook = new NoteBook("apple","맥북",001,10000);
		
		MyDate date = new MyDate(19880101);
		
		Programer pgm = new Programer("오형석",date, notebook);
		//형석이가 10000원 짜리 맥북을 갖는다.
		
		System.out.println(pgm.toString());
		
	}
}
class NoteBook {
	//변수
	private String BrandName; 
	private String Model; 
	private int SerialNumber; 
	private int price;
	
	
	//생성자
	NoteBook(){}
	
	NoteBook(String BrandName,String Model,int SerialNumber,int price){
		this.BrandName = BrandName;
		this.Model = Model;
		this.SerialNumber = SerialNumber;
		this.price = price;
	}
	
	//메서드
	public String toString(){
		
		return " 노트북 : 브랜드명 - " + this.BrandName + ", 모델명 - " 
		        + this.Model+ ", 시리얼넘버 - " + this.SerialNumber + ", 가격 - " + this.price;
	}
	
}

class Programer {
	//변수
	private String name;
	private MyDate birthDate; 
	private NoteBook NoteBook;

	//생성자
	Programer(){}
	
	Programer(String name,MyDate birthDate,NoteBook NoteBook){
		this.name = name;
		this.birthDate = birthDate;
		this.NoteBook = NoteBook;
		
	}
		public String toString(){
			
			return " 이름 : " +  this.name + "\n" + birthDate.toString() + "\n" +  NoteBook.toString();
		}
}

class MyDate{
	//변수
	private int birthDate;
	
	//생성자
	MyDate(){}
	
	MyDate(int birthDate){
		this.birthDate = birthDate;
		
	}
	//메서드
	public String toString(){
		
		return " 생일 : " + this.birthDate;
	}
}
