package rewriters;

import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtReturn;
import spoon.reflect.factory.Factory;

public class ReturnNull extends Rewriter<CtReturn<?>> {
    @Override
    protected void rewrite(CtReturn<?> e, Factory factory) {
        CtCodeSnippetStatement snippet = factory.Core().createCodeSnippetStatement();
        snippet.setValue("return null");
        e.replace(snippet);
    }

    @Override
    protected String getName() {
        return "ReturnNull";
    }
}
