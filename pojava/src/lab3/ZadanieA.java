package lab3;

public class ZadanieA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kolo k1 = new Kolo(2.5);
		Trojkat t1 = new Trojkat(6, 6, 6);
		
		System.out.println(k1.obliczObwod());
		System.out.println(k1.obliczPole());
		System.out.println(t1.obliczObwod());
		System.out.println(t1.obliczPole());

	}

}
