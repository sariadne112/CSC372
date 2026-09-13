public class Sphere extends Shape{
  private double radius;
   //radius constructor
  public Sphere(double radius) {
      this.radius = radius;
   }
   //surface area
   @Override
   public double surface_area(){
    return 4.0 * Math.PI * Math.pow(radius, 2);
    }
  //volume
  @Override
    public double volume() {
      return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
  //To String
  @Override
    public String toString() {
      return String.format("Sphere Surface Area: %.2f%nSphere Volume: %.2f",
        surface_area(), volume());
    }
}
