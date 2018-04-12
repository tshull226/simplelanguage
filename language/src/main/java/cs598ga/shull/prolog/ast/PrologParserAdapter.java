/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs598ga.shull.prolog.ast;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.TruffleLanguage.ParsingRequest;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.sl.SLLanguage;
import cs598ga.shull.prolog.execution.GlobalEnvironment;
import cs598ga.shull.prolog.parser.*;
import java.io.IOException;
import java.util.Map;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

/**
 *
 * @author tshull7
 */
public class PrologParserAdapter {
	
    protected CallTarget parse(ParsingRequest request) throws Exception {
	    return null;
    }
    public static Map<String, RootCallTarget> parseProlog(SLLanguage language, Source source) throws IOException {

        PrologLexer lexer = new PrologLexer(new ANTLRInputStream(source.getInputStream()));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PrologParser parser = new PrologParser(tokens);
	GlobalEnvironment env = new GlobalEnvironment();
	ASTNodeGenerator walker = new ASTNodeGenerator(env);
	System.out.println("parser started");
	ParseTreeWalker.DEFAULT.walk(walker, parser.p_text());
	System.out.println("parser ended");



	System.out.println("this was successful");

	return null;
    }
}
