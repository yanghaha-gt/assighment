package expressions;

import java.util.Set;

/**
 * Represents a negated boolean expression
 * @version 0.1
 */

/*
 * Class invariants: 
 * The 'expression' cannot be null
 */
class Negation implements Expression {

    private Expression expression;

    /**
     * Constructs a new negated expression
     * @param expression the expression to negate
     * @throws IllegalArgumentException if {@code expression} is {@code null}
     */
    Negation(Expression expression) {
        if ( expression == null ){
            throw new IllegalArgumentException("The 'expresion' cannot be null");
        }
        this.expression = expression;
    }

    @Override
    public boolean evaluate(Interpretation interpretation) {
        if ( interpretation == null ){
            throw new IllegalArgumentException("The 'interpretation' cannot be null");
        }
        return !expression.evaluate(interpretation);
    }

    @Override
    public Set<String> variables() {
        return expression.variables();
    }

    //Check the invariant
    
    public boolean repOK(){
        return expression != null;

    }

}
