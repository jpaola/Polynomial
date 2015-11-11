package Polynomial;

/**
 * A class to represent a polynomial (a sequence of terms).
 * 
 */
/**
 * @author Paola Jiron
 */
public class Polynomial {

    // instance var's

    private Node head;

    /**
     * Constructs a polynomial with zero terms.
     */
    public Polynomial() {

        head = null;
    }

    /**
     * Constructs a polynomial from an existing one.
     */
    public Polynomial(Polynomial p) 
    {
        head = p.head;
    }

    /**
     * Creates a Term and places it in its proper position in the list
     * by ascending exponent values.
     * @param coeff The coefficient of a term.
     * @param expo The exponent of a term.
     */
    public void addTerm(int coeff, int expo) {

        // assemble new Term and load it into a Node
        
        Node neo = new Node(new Term(coeff,expo));  
        
        // local var's
        Node pointer = head;        // trails the list
        
        if ( head == null)  // if the list is empty
        {
            head = neo;     // append the new term
        }
        // check if neo has a smaller exponent..
        
        else if ( neo.term.getExpo() < pointer.term.getExpo())
        {
            neo.next = head;        // .. if so, place at head of the list
            head = neo;
        }       
        else
        {
            boolean fit = false;            // flag for fit
            Node trailer = head.next;    // will trail the list ahead of pointer
            
            while ( trailer != null && !fit)    // traverse the list
            {
               // if node pointed to by pointer contains a term with greater
               // exponent than neo node term exponent...
                
                if ( neo.term.getExpo() < trailer.term.getExpo())
                {  
                    fit = true;     // set flag
                }
                else    // otherwise, step forward
                {
                    pointer = trailer;          
                    trailer = trailer.next;
                }
            }
            
              neo.next = trailer;      // place at position prior to trailer
              pointer.next = neo;   
        }
        
    }

    /**
     * Computes and returns the sum of the current polynomial with the parameter
     * polynomial.
     *
     * @param p A polynomial.
     * @return The sum of both polynomials.
     */
    public Polynomial polyAdd(Polynomial p) {
        
        // holds terms of both polynomials
        
        Polynomial collection = new Polynomial();   
        
        Node pointer = head;     // points to the head of the list ( implicit )
        
        // collect and cocatinate terms 
        
        while ( pointer != null )
        {
            collection.addTerm(pointer.term.getCoeff(), pointer.term.getExpo());
            
            pointer = pointer.next;     // step forward
        }
        
        pointer = p.head;
        
        while ( pointer != null )
        {
            collection.addTerm(pointer.term.getCoeff(), pointer.term.getExpo());
            
            pointer = pointer.next;     // step forward
        }
        
     return   adder(collection);    // helper polynomial adder returns sum
    
    }

    /**
     * Computes and returns the product of the current polynomial with the
     * parameter polynomial.
     *
     * @param p A polynomial.
     * @return The product of both polynomials as a polynomial.
     */
    public Polynomial polyMultiply(Polynomial p) {
        
        // the product holder
        Polynomial product = new Polynomial();
        
        Node temp = p.head;   // points to the first node on (implicit) list
        
        // traverse the list ( implicit parameter )
        
        while ( temp != null)
        {
          
            Node temp2 = head;  // points to the first node on (explicit) list
            
            // traverse the list ( explicit parameter )
            
            while ( temp2 != null)
            {
                
                // compute the product of coefficients and sum of exponents
                
                int x = temp.term.getCoeff() * temp2.term.getCoeff();
                
                int y = temp.term.getExpo() + temp2.term.getExpo();
                
                // populate the product holding polynomial
                
                product.addTerm(x, y);  
                
                // move to next term ( explicit polynomial)
                
                temp2 = temp2.next;  // point to next term
            }
            temp = temp.next;   // point to next term
        }
        
        return adder(product);  // return simplified result
        
    }
    /**
     * Overrides the toString method and returns a string containing all the
     * terms on the polynomial.
     * @return The polynomial as a string.
     */
    public String toString()
    {
        if (head == null)       // if the list is empty return null
        {
            return null + "\n";
        }
        
        String out = " ";
        
        Node temp = head;       // the first term
        
        while ( temp != null)       // while more nodes..
        {
             out += temp.term.toString();    // ..append current object
             
             temp = temp.next;      //.. and move to the next node
             
             if (temp != null)      // if not pointing to last node..
             {
                 out += " + ";
                 
             }
        }
        return out + "\n";      
    }
/**
 * Utility method which computes and returns the sum of a polynomial with 
 * multiple alike exponents.
 * @return A pointer to a polynomial(the sum).
 */
private Polynomial adder(Polynomial p)
{
        Polynomial sum = new Polynomial();  // will hold the result of the sum
        
        Node trailer = p.head;   // points to head of the collection (p)
        
        if (trailer == null){ return null;}     // if list is empty, return null
        
        Node pointer = p.head.next;         // points to next node 
        
        // will add the coefficients with matching exponents
        
        int adder = trailer.term.getCoeff();    
        
        while (pointer != null) // traverse the list
        {
            // if exponents match... collect and add coefficients 
            
            if(pointer.term.getExpo() == trailer.term.getExpo())
            {
                adder += pointer.term.getCoeff();
                
                pointer = pointer.next;             // step forward
            }
            else    // otherwise, assemble new term and insert into the sum poly
            {
                sum.addTerm(adder, trailer.term.getExpo());
                
                trailer = pointer;    // step to next term w/ differing exponent
                
                pointer = pointer.next;                 // move forward
                
                adder = trailer.term.getCoeff();
            }
        }
        sum.addTerm(adder, trailer.term.getExpo());     // add the last term
        
        return sum;     // return simplified result
}
}

/**
 * A class that implements a Node ( represents a term) in a dynamic data
 * structure with a data bearing field that stores an object of a class
 * specified by a type parameter, and a field that stores a reference to a Node.
 */
class Node<E extends Term> {

    E term;     // an object of the "type variable" class...

    Node next;    // a reference to another Node

    /**
     * Constructs a node object.
     */
    Node(E x) {
        term = x;       // initialize "info" member
        // "pointer" is automatically initialized to 'null'
    }
}
