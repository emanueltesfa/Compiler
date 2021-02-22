import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Driver {
    public static void main(String[] args) throws Exception {
        /* Step 1: Scanner/Tokenizer/Lexer */

        // create a CharStream that reads from standard input
        ANTLRInputStream input = new ANTLRInputStream(System.in);

        // create a lexer that feeds off of input CharStream
        LittleLexer lexer = new LittleLexer(input);

        /*Step 2: Parser*/

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        LittleParser parser = new LittleParser(tokens);

        parser.program(); // begin parsing at program rule
        if( parser.getNumberOfSyntaxErrors() == 0 ){
            System.out.println("Accepted");
        } else {
            System.out.println("Not accepted");
        }

        /*
        // Write to output file
        Token token = lexer.nextToken();
        while(token.getType() != Little.EOF) {
            System.out.println("Token Type: " + getTokenType(token.getType()) +
                    "\nValue: " + token.getText());
            token = lexer.nextToken();
        }
         */
    }
/*
    // Step 1 Helper(s)
    private static String getTokenType(int tokenType) {
        switch(tokenType) {
            case Little.KEYWORDS:
                return "KEYWORD";
            case Little.IDENTIFIER:
                return "IDENTIFIER";
            case Little.OPERATORS:
                return "OPERATOR";
            case Little.INTLITERAL:
                return "INTLITERAL";
            case Little.FLOATLITERAL:
                return "FLOATLITERAL";
            case Little.STRINGLITERAL:
                return "STRINGLITERAL";
            default:
                return "UNIDENTIFIED";
        }
    }
 */
}
