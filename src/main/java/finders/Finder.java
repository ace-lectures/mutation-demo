package finders;

import spoon.Launcher;
import spoon.reflect.declaration.CtElement;

import java.util.Set;

public interface Finder<Element extends CtElement> {

    public Set<Element> findCandidates(Launcher program, int howMany);

}
