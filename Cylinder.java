public class Cylinder extends Shape{
  private double radius;
  private double height;

  public Cylinder(double radius, double height){
    this.radius = radius;
    this.height = height;
  }
  //surface area
  @Override
  public double surface_area() {
    return (2 * Math.PI * radius * height)
    + (2 * Math.PI * Math.pow(radius, 2));
    }
  //volume
  @Override
  public double volume(){
    return Math.PI * Math.pow(radius, 2) * height;
  }

  //To String
  @Override
    public String toString() {
        return String.format("Cylinder Surface Area: %.2f%nCylinder Volume: %.2f",
        surface_area(), volume());
    }
}
