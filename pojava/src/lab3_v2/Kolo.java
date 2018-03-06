package lab3_v2;

public class Kolo implements Figura {

	public Kolo(double promien) {
		// TODO Auto-generated constructor stub
		this.promien = promien;
	}

	@Override
	public double obliczObwod() {
		// TODO Auto-generated method stub
		return 2*PI*promien;
	}

	@Override
	public double obliczPole() {
		// TODO Auto-generated method stub
		return PI*PI*promien;
	}
	double promien;

}
