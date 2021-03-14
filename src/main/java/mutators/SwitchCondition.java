package mutators;

import finders.Condition;
import finders.Finder;
import rewriters.InvertCondition;
import rewriters.Rewriter;
import spoon.reflect.code.CtBinaryOperator;

public class SwitchCondition extends Mutator<CtBinaryOperator<?>>{
    @Override
    protected Finder<CtBinaryOperator<?>> getFinder() {
        return new Condition();
    }

    @Override
    protected Rewriter<CtBinaryOperator<?>> getRewriter() {
        return new InvertCondition();
    }
}
