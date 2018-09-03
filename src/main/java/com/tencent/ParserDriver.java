package com.tencent;

import gen.SqlBaseLexer;
import gen.SqlBaseParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class ParserDriver {
    public static void main(String[] args) {
        String query = "SELECT NAME FROM STUDENT WHERE AGE > 18";
        SqlBaseLexer lexer = new SqlBaseLexer(new ANTLRInputStream(query));
        SqlBaseParser parser = new SqlBaseParser(new CommonTokenStream(lexer));
        MyVisitor visitor = new MyVisitor();
        String res = visitor.visitSingleStatement(parser.singleStatement());
        System.out.println("res="+res);
    }
}
