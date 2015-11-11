package Polynomial;

/**
 * A class to represent a term in an algebraic expression. A term consists of
 * an integer coefficient and a nonnegative integer exponent.
 */
/**
 * @author Paola Jiron
 */
public class Term 
{
    private final int coefficient, exponent;    
    
    /**
     * A constructor for a term that includes a coefficient and an exponent.
     * @param coef The coefficient.
     * @param expo The exponent.
     */
    public Term(int coef, int expo)
    {
        this.coefficient = coef;
        this.exponent = expo;
    }
    /**
     * Accessor method for the coefficient.
     * @return The coefficient.
     */
    public int getCoeff()
    {
        return coefficient;
    }
    /**
     * Accessor method for the exponent.
     * @return The exponent.
     */
    public int getExpo()
    {
        return exponent;
    }
    /**
     * Overrides the toString method and returns a term in string form
     * ex. (6, 5) == 6x^5
     * @return A term in string form.
     */
    public String toString()
    {
        String out= " ";
        
        if(getCoeff() == 1)     // if coeff is 1..
        {
            if(getExpo() == 1)  //.. and the exponent is 1
            {
                out += "x";    // print only the variable
            }
            else
            {
                out += "x^" + getExpo() + " "; // otherwise x^expo
            }
        }
        else if (getExpo() == 1)    //...else if the exponent is 1
        {
            out += getCoeff() + "x";   //..print coeff(x)
        }
        else if (getExpo() == 0)        //...else print the coefficient alone
        {
            out += getCoeff() + " ";
        }
        else 
        {
            out += getCoeff() + "x^" + getExpo();
        }
        
        return out;  
    }
}
