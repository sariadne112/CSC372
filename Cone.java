public class Cone extends Shape{
   private double radius;
  private double height;

  public Cone(double radius, double height){
    this.radius = radius;
    this.height = height;
  }
  //surface area
  @Override
  public double surface_area() {
    return Math.PI * radius * (radius +  Math.sqrt(Math.pow(height, 2)+ Math.pow(radius, 2)));
    }
  //Volume
  public double volume(){
    return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
  }

  //To String
  @Override
    public String toString() {
        String.format("Cone Surface Area: %.2f%nCone Volume: %.2f",
        surface_area(), volume());
    }
}
