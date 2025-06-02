package expressions;

import java.util.Set;

/**
 * Represents a boolean variable.
 * The variable must follow the format {@code <letter>(<letter-or-number>)*},
 * i.e.: a letter followed by zero or more letters or numbers
 * @version 0.1
 */

/*
 * Class invariants: 
 * The 'var' cannot be null or empty or just blank
 */
class Variable implements Expression {

    private String var;

    /**
     * Constructs a new variable expression
     * @param var the variable associated with this expression
     * @throws IllegalArgumentException if {@code var} doesn't follow the following conditions
     * <ul>
     * <li>is not {@code null}</li>
     * <li>is not empty</li>
     * <li>follows the format {@code <letter>(<letter-or-number>)*}, i.e.: a letter followed by zero or more letters or numbers</li>
     * </ul>
     */
    Variable(String var) {
        //TODO: implement preconditions with exceptions
        if ( var == null || var.isEmpty() ){
            throw new IllegalArgumentException("The 'var' cannot be null or empty");
        }
        this.var = var;
    }

    /* (non-javadoc)
     * @param var the variable to check
     * @return {@code true} iff {@code var} complies with all these conditions:
     * <ul>
     * <li>is not {@code null}</li>
     * <li>is not empty</li>
     * <li>follows the format {@code <letter>(<letter-or-number>)*}, i.e.: a letter followed by zero or more letters or numbers</li>
     * </ul>
     */
    static boolean checkFormat(String var) {
        if ( var == null || var.isEmpty() ){
            return false;
        }
        if ( !Character.isLetter(var.charAt(0)) ){
            return false;
        }
        for ( int i = 0 ; i < var.length() ; i++ ){
            char index = var.charAt(i);
            if ( !Character.isDigit(index) && !Character.isLetter(index) ){
                return false;
            }
        }
        return true;
        
    }

    @Override
    public boolean evaluate(Interpretation interpretation) {
        if ( interpretation == null ){
            throw new IllegalArgumentException("The 'interpretation' cannot be null");
        }
        if ( !interpretation.exists(var) ){
            throw new IllegalArgumentException("This variable is not exist in the interpretation");
        }
        return interpretation.valueOf(this.var);
    
    }

    @Override
    public Set<String> variables() {
        return Set.of(this.var);
    }
    

    //Check invaariant

    public boolean repOK(){
        return var != null && !var.isEmpty() && !var.isBlank();
    }
}
