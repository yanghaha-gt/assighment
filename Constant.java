package expressions;

import java.util.Set;

/**
 * Represents a boolean value, i.e.: true, or false
 * @version 0.1
 */

 /**
  * Class invariants:
  * the 'value' cannot be null
  */
class Constant implements Expression {

    private boolean value;

    /**
     * Constructs a new boolean value
     * @param value the internal boolean value this expression represents
     */
    Constant(boolean value) {
        this.value = value;
    }

    @Override
    public boolean evaluate(Interpretation interpretation) {
        if ( interpretation == null ){
            throw new IllegalArgumentException("The 'interpretation cannot be null");
        }
        return this.value;
    }

    @Override
    public Set<String> variables() {
        return Set.of();
    }   
    
    /*
    * Check the class invariants by repOK
    * Since the type of 'value' is boolean
    * It can only be true or false, never be null
    * Hence, we can always return true
    */

    public boolean repOK(){
        return true;               

    }
}
