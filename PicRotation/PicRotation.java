class PicRotation{

  public static double rotateX( double oldX, double oldY, double theta, double centerX, double centerY){
    double newX;
    newX = ((oldX-centerX)*Math.cos(theta)) - ((oldY-centerY)*Math.sin(theta)) + centerX;
    return newX;
  }

  public static double rotateY( double oldY, double theta, double centerY){
    double newY;
    newY = ((oldY-centerY)*Math.cos(theta)) - ((oldY-centerY)*Math.sin(theta)) + centerY;
    return newY;
  }

  public static void main(String[] args) {
    Picture pic = new Picture(args[0]);
    double theta = Integer.parseInt(args[1]);
    System.out.println(args[0]+" "+args[1]);
  }
}
