package mutators;

import finders.Finder;
import finders.ObjectReturn;
import rewriters.ReturnNull;
import rewriters.Rewriter;
import spoon.reflect.code.CtReturn;

public class IntroduceNullPointer extends Mutator<CtReturn<?>> {
    @Override
    protected Finder<CtReturn<?>> getFinder() {
        return new ObjectReturn();
    }

    @Override
    protected Rewriter<CtReturn<?>> getRewriter() {
        return new ReturnNull();
    }
}
