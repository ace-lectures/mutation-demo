package mutators;

import finders.Condition;
import finders.Finder;
import rewriters.ConditionAlwaysFalse;
import rewriters.ConditionAlwaysTrue;
import rewriters.Rewriter;
import spoon.reflect.code.CtBinaryOperator;

import java.util.Random;

public class FixCondition extends Mutator<CtBinaryOperator<?>>{
    @Override
    protected Finder<CtBinaryOperator<?>> getFinder() {
        return new Condition();
    }

    @Override
    protected Rewriter<CtBinaryOperator<?>> getRewriter() {
        Random bag = new Random();
        if (bag.nextBoolean())
            return new ConditionAlwaysTrue();
        else
            return new ConditionAlwaysFalse();
    }
}
