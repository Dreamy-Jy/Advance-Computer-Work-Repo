/*
 * 1. take input from the command line, and file and put them into variables
 * 2. Create the visual environment for the simulator
 * you can find the univeresal foorce between two planets
 */

public class Nbody {

	public static void update(Body[] bodies, double dt) {

		for (int prime = 0; prime < bodies.length; prime++) {
			for(int secondary = 0; secondary < bodies.length; secondary++ ){
				if (prime != secondary)
					bodies[prime].move(bodies[prime].forceFrom(bodies[secondary]), dt);
			}
		}
	}

	public static void animate(Body[] bodies) {
		StdDraw.picture(0, 0, "nbody/starfield.jpg");
		for (int i = 0; i < bodies.length; i++) {
			bodies[i].draw();
		}
	}
	
	public static void printData(Body[] bodies, double T, double dt, double timeNow){
		String set;
		StdOut.println("\n\n\nData for set "+((T-timeNow)/dt)+"out of "+(T/dt)+" sets");
		for(Body b: bodies){
			StdOut.println(b.name+": velX "+b.vX+", velY "+b.vY+", posX "+b.pX+", posY "+b.pY);
		}
	}

	public static void main(String[] args) {

		StdOut.println("iput in your times");
		double T = 157788000; // StdIn.readDouble();
		double dt = 1; // StdIn.readDouble();

		In input = new In("planets.txt");
		int particlesCount = input.readInt();
		double universeRadius = input.readDouble();

		Body[] bodys = new Body[particlesCount];
		for (int i = 0; i < particlesCount; i++) {
			bodys[i] = new Body(input.readDouble(), input.readDouble(), input.readDouble(), input.readDouble(),
					input.readDouble(), input.readString());
		}

		StdDraw.setXscale(-universeRadius, universeRadius);
		StdDraw.setYscale(-universeRadius, universeRadius);
		StdDraw.enableDoubleBuffering();

		StdDraw.picture(0, 0, "nbody/starfield.jpg");
		for (int i = 0; i < bodys.length; i++) {
			bodys[i].draw();
		}
		printData(bodys, T, dt, T);

		for (double timeNow = 0; timeNow < 3; timeNow += 1) {
			update(bodys, dt);
			animate(bodys);
			printData(bodys, T, dt, timeNow);
			StdDraw.show();
			StdDraw.pause(20);
		}
	}

}
