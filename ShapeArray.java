public class ShapeArray{
  public static void main(String[] args) {
    //Instantiate Sphere
    Sphere sphere = new Sphere(9.0);
    //Instantiate Cylinder
    Cylinder cylinder = new Cylinder(7, 15.67);
    //Instantiate Cone
    Cone cone = new Cone(8.9, 12.00);
    //Store Array
    Shape[] shapeArray = {sphere, cylinder, cone};
    //loop through
    for(Shape shape : shapeArray) {
      System.out.println(shape.toString());
      System.out.println();
    }
  }
}
