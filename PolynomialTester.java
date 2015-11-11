package Polynomial;
/**
 * @author Paola Jiron
 */
public class PolynomialTester
{
   public static void main(String[] args)
   {
      Polynomial p1 = new Polynomial();
      Polynomial p2 = new Polynomial();
      Polynomial p0 = new Polynomial();
      p1.addTerm(5, 2);
      p1.addTerm(4, 5);
      p1.addTerm(3, 3);
      p1.addTerm(1, 2);
      p1.addTerm(5, 6);
      p2.addTerm(3, 8);
      p2.addTerm(2, 5);
      p2.addTerm(1, 2);
      
      Polynomial p3 = p1.polyAdd(p2);
      System.out.println("p1 is " + p1 + "\np2 is " + p2 + "\np1+p2 is " + p3);
      
      Polynomial p4 = p1.polyMultiply(p2);
      System.out.println("p1 is " + p1 + "\np2 is " + p2 + "\np1*p2 is " + p4);
      
      Polynomial p5 = p2.polyMultiply(p2);
      System.out.println("p2 is " + p2 + "\np2*p2 is " + p5);
      
      Polynomial p6 = p0.polyMultiply(p2);
      System.out.println("p0 is " + p0 + "\n" + "p2 is " + p2 + "\np0*p2 is " 
                         + p6);
      
      Polynomial p7 = p0.polyAdd(p2);
      System.out.println("\np0 is " + p0 + "\n" + "p2 is " + p2 + "\np0+p2 is " 
                         + p7);
      
      p1 = p1.polyAdd(p2);
      System.out.println("After p1 = p1+p2  p1 is " + p1);
      
      p2 = p2.polyMultiply(p2);
      System.out.println("After p2 = p2*p2  p2 is " + p2);
   }
}