package mutators;

import finders.Finder;
import rewriters.Rewriter;
import rewriters.Trace;
import spoon.Launcher;
import spoon.reflect.declaration.CtElement;

import java.util.Set;

public abstract class Mutator<Element extends CtElement> {

    public Set<Trace> mutate(Launcher program, int howMany){
        Set<Element> found = getFinder().findCandidates(program, howMany);
        return getRewriter().rewrite(found, program.getFactory());
    }

    protected abstract Finder<Element> getFinder();
    protected abstract Rewriter<Element> getRewriter();
}
