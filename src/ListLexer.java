/**
 * Created by IntelliJ IDEA.
 * User: matt
 * Date: 11-12-14
 * Time: 5:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class ListLexer extends Lexer {
    
    public static final int NAME = 2;
    public static final int COMMA = 3;
    public static final int LBRACK = 4;
    public static final int RBRACK = 5;

    public static String[] tokenNames =
            {"n/a", "<EOF>", "NAME", "COMMA", "LBRACK", "RBRACK"};

    public ListLexer(String input) {
        super(input);
    }
    
    public String getTokenName(int n) { return tokenNames[n];}

    boolean isLETTER() { return c >='a' && c<='z' || c>='A' && c<='Z'; }

    public Token nextToken() {
        while(c!=EOF) {
            switch(c) {
                case ' ': case '\t': case '\n': case '\r': WS(); continue;
                case ',': consume(); return new Token(COMMA,",");
                case '[': consume(); return new Token(LBRACK,"[");
                case ']': consume(); return new Token(RBRACK,"]");
                default:
                    if (isLETTER()) return NAME();
                    throw new Error("invalid character "+c);
            }
        }
        return new Token(EOF_TYPE,"<EOF>");
    }

    public Token NAME() {
        StringBuffer buff = new StringBuffer();
        do { buff.append(c); consume(); } while ( isLETTER() );
        return new Token(NAME, buff.toString());
    }

    void WS() {
        while (c==' ' || c=='\t' || c=='\n' || c=='\r') consume();
    }

    
}
