public class ShapeArray{
  public static void main(String[] args) {
    //Instantiate Sphere
    Sphere sphere = new Sphere(50.0);
    //Instantiate Cylinder
    Cylinder cylinder = new Cylinder(50.0, 20.00);
    //Instantiate Cone
    Cone cone = new Cone(50.00, 25.00);
    //Store Array
    Shape[] shapeArray = {sphere, cylinder, cone};
    //loop through
    for(Shape shape : shapeArray) {
      System.out.println(shape.toString());
      System.out.println();
    }
  }
}
