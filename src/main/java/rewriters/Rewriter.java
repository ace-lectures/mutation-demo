package rewriters;

import spoon.reflect.declaration.CtElement;
import spoon.reflect.factory.Factory;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class Rewriter<Element extends CtElement> {

    public Set<Trace> rewrite(Set<Element> found, Factory factory) {
        return found.stream().map( e -> {
            this.rewrite(e, factory);
            return new Trace(this.getName(), e);
        }).collect(Collectors.toSet());
    }

    protected abstract void rewrite(Element e, Factory factory);
    protected abstract String getName();
}
