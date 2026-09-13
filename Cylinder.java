public class Cylinder {
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

  public double volume(){
    return Math.PI * Math.pow(radius, 2) * height;
  }

  //To String
  @Override
    public String toString() {
        String.format("Sphere Surface Area: %.2f%nSphere Volume: %.2f",
        surface_area(), volume());
    }
}
