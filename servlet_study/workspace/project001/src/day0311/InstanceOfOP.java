package day0311;


/*
[instanceof 연산자]
- 두 클래스간의 형변환이 가능한지 판단하는 연산자
- 해당 인스턴스변수가 어떤 타입의 변수인지 판단하는 연산자
- 두 클래스간의 상속관계가 있어야 한다.
  즉 is a 관계가 성립해야 한다.
- 형변환이 가능하면 true반환 ,아니면 false반환



*/
class Sup{}
class Sub extends Sup{}

public class InstanceOfOP {

	public static void main(String[] args) {
		//1]두 클래스간 상속관계가 존재하지 않을때
		String string="JAVA";
		
		StringBuffer buffer = new StringBuffer(" WORLD");
		
		//상속관계 미 존재시 대입 연산도 불가
		//string = buffer;//[x]
		//buffer = string;//[x]
		
		System.out.println(string instanceof String ? 
				           "string은 String타입니다" : 
				           "string은 String타입이 아니다");
		System.out.println(string instanceof Object ? 
		           "string은 Object타입니다" : 
		           "string은 Object타입이 아니다");
		System.out.println(buffer instanceof StringBuffer ? 
		           "buffer은 StringBuffer타입니다" : 
		           "buffer은 StringBuffer타입이 아니다");
		//※상속관계가 없을때 instanceof연산자 사용시  컴파일 에러
		//System.out.println(string instanceof StringBuffer);//[x]
		//System.out.println(buffer instanceof String);//[x]
		//1]두 클래스간 상속관계가 존재할때
		//instanceOf연산자로 선 판단하지 않고 형변환시]
		/*
		 * 상속 관계는 존재하나 형변환이 불가한 경우
		 * 컴파일 에러는 발생하지 않으나 실행시 에러 발생
		 * -ClassCastException
		 * 
		 * 실행시 에러를 피하기위해 반드시 instanceOf로 판단후 
		 * 형변환
		 * 
		 */
		
		
		Object object= new Object();
		//String stringObject =(String)object;//[x]실행시 에러
		System.out.println(object instanceof String);
		System.out.println("[object = string;실행 전]");
		if(object instanceof String){
			String stringObject =(String)object;
			System.out.println("형변환이 발생했어요");
		}
		
		object = string;//[o]상속관계 존재 해야만 함.묵시적 형변환.업 캐스팅
		System.out.println("[object = string;실행 후]");
		if(object instanceof String){
			String stringObject =(String)object;
			System.out.println("형변환(강제적 형변환)이 발생했어요");
		}
		
		Sup sup = new Sup();
		
		System.out.println(sup instanceof Sup);//true
		System.out.println(sup instanceof Sub);//false
		System.out.println(sup instanceof Object);//true
		
		Sub sub = new Sub();
		System.out.println(sub instanceof Sub);//true
		System.out.println(sub instanceof Sup);//true
		System.out.println(sub instanceof Object);//true
		
	
	}

}
