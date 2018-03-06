package lab3_v2;

public class Trojkat implements Figura {

	public Trojkat(double dlugoscboku1, double dlugoscboku2, double dlugoscboku3) {
		// TODO Auto-generated constructor stub
		this.dlugoscboku1 = dlugoscboku1;
		this.dlugoscboku2 = dlugoscboku2;
		this.dlugoscboku3 = dlugoscboku3;
	}

	@Override
	public double obliczObwod() {
		// TODO Auto-generated method stub
		return (dlugoscboku1 + dlugoscboku2 + dlugoscboku3);
	}

	@Override
	public double obliczPole() {
		// TODO Auto-generated method stub
		double p = obliczObwod()/2;
		return Math.sqrt(p * (p - dlugoscboku1) * (p - dlugoscboku2) * (p - dlugoscboku3));
	}
	double dlugoscboku1;
	double dlugoscboku2;
	double dlugoscboku3;
}
