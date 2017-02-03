public class Body {
	String name;
	final String fileName;
	double pX, pY, vX, vY;
	final double mass;

	public Body(double posX, double posY, double velX, double velY, double Pmass, String fileName) {
		this.fileName = fileName;
		name = this.fileName.substring(0, this.fileName.indexOf(".gif"));
		pX = posX;
		pY = posY;
		vX = velX;
		vY = velY;
		mass = Pmass;
	}

	public void draw() {
		StdDraw.picture(pX, pY, "nbody/" + fileName);
	}

	// needs debugging
	public Vector forceFrom(Body b2) {
		Vector force; // [fx,fy]
		double G = 6.67e-11;
		double r, theta;
		
		r = Math.sqrt(Math.pow(b2.pX - this.pX, 2) + Math.pow(b2.pY - this.pY, 2));
		
		theta = Math.atan((this.pY - b2.pY) / (this.pX - b2.pX));// radian
		force = new Vector((G * this.mass * b2.mass) / Math.pow(r, 2) ,theta);
		return force;
	}

	/*
	 * I assume only one force pair is going in the array
	 * 
	 * needs debugging
	 */
	public void move(Vector force, double dt){
		Vector accel = force.scale(1/mass);
		Vector velocity = new Vector(vX, vY);
		velocity = velocity.plus(accel.scale(dt));//something here is wrong
		pX = velocity.x * dt;
		pY = velocity.y * dt;
	}

	//
	public static class Vector {
		double x;
		double y;

		public Vector(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public Vector(double Mag, double theta, boolean t){
			//theta = Math.toRadians(theta);
			this.x = Mag*Math.cos(theta);
			this.y = Mag*Math.sin(theta);
			//x is negative (+pi/2 to 3pi/4
			//if (theta )
			
		}

		// returns only positive values
		public double magnitude() {
			return Math.sqrt(x * x + y * y);
		}

		public double angle(String unit) {
			if (unit.equals("Rad"))
				return Math.atan(y / x);
			else
				return Math.toDegrees(angle("Rad"));
		}

		public Vector scale(double value) {
			return new Vector(x * value, y * value);
		}

		public Vector scale(Vector v) {
			return new Vector(this.x * v.x, this.y * v.y);
		}

		public Vector plus(Vector v) {
			return new Vector(this.x + v.x, this.y + v.y);
		}

		public Vector minus(Vector v) {
			return new Vector(this.x - v.x, this.y - v.y);
		}
	}

	public static void main(String args[]) {
		Vector force = new Vector(1300, 360 ,true);
		StdOut.println(force.x + " " + force.y);
		StdOut.println(force.magnitude() + " " + force.angle("deg"));

	}
}
