package rewriters;

import spoon.reflect.declaration.CtElement;

public class Trace {

    private final String rewriter;
    private final String file;
    private final int line;
    private final int column;

    public Trace(String name, CtElement e) {
        this.rewriter = name;
        this.file = e.getPosition().getFile().getName();
        this.line = e.getPosition().getLine();
        this.column = e.getPosition().getColumn();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(rewriter).append(",")
                .append(file).append(",")
                .append(line).append(",")
                .append(column);
        return builder.toString();
    }
}
