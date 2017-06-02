/**
 * Curso: Elementos de Sistemas
 * Arquivo: CompilationEngine.java
 */

package compiler;

/** 
 * Classe principal do compilador que é responsável por dar rítmo no processo de compilação.
 * Essa classe é responsável por instanciar o Tokenizer, VMWrites e SymbolTable.
 * O processo é gerenciado por funções recursivas.
 */
public class CompilationEngine {
    JackTokenizer jtokenizer;
    VMWriter writer;
    SymbolTable symbolTable;

    /** 
     * Construtor da classe, responsável por iniciar/instanciar os objetos do processo.
     * @param inputfilename nome do arquivo Jack que será compilador.
     * @param outputfilename nome do arquivo VM que receberá o código gerado.
     */   
    public CompilationEngine(String inputfilename, String outputfilename) {
        
        jtokenizer= new JackTokenizer(inputfilename);
        symbolTable= new SymbolTable();
        writer= new VMWriter(outputfilename);
        
        /*
        
        while(jtokenizer.advance()){
        
            switch( jtokenizer.tokenType( jtokenizer.token() ) ){
            
                case jtokenizer.TokenType.KEYWORD:
                    
                    switch( jtokenizer.keyword( jtokenizer.token() ) ){
                    
                        case jtokenizer.KeywordType.CLASS:
                        
                            compileClass();
                            break;
                            
                        case jtokenizer.KeywordType.METHOD:
                            break;
                            
                        case jtokenizer.KeywordType.FUNCTION:
                            break;
                            
                        case jtokenizer.KeywordType.CONSTRUCTOR:
                            break;
                            
                        case jtokenizer.KeywordType.INT:
                            break;
                            
                        case jtokenizer.KeywordType.BOOLEAN:
                            break;
                            
                        case jtokenizer.KeywordType.CHAR:
                            break;
                            
                        case jtokenizer.KeywordType.VOID:
                            break;
                            
                        case jtokenizer.KeywordType.VAR:
                            break;
                            
                        case jtokenizer.KeywordType.STATIC:
                            break;
                            
                        case jtokenizer.KeywordType.FIELD:
                            break;
                            
                        case jtokenizer.KeywordType.LET:
                            break;
                            
                        case jtokenizer.KeywordType.DO:
                            break;
                            
                        case jtokenizer.KeywordType.IF:
                            break;
                            
                        case jtokenizer.KeywordType.ELSE:
                            break;
                            
                        case jtokenizer.KeywordType.WHILE:
                            break;
                            
                        case jtokenizer.KeywordType.RETURN:
                            break;
                            
                        case jtokenizer.KeywordType.TRUE:
                            break;
                            
                        case jtokenizer.KeywordType.FALSE:
                            break;
                            
                        case jtokenizer.KeywordType.NULL:
                            break;
                            
                        case jtokenizer.KeywordType.THIS:
                            break;
                            
                        
                    break;
                    
                case jtokenizer.TokenType.SYMBOL:
                    break;
                    
                case jtokenizer.TokenType.IDENTIFIER:
                    break;
                    
                case jtokenizer.TokenType.INT_CONST:
                    break;
                    
                case jtokenizer.TokenType.STRING_CONST:
                    break;
            }
        }
        */
        
        compileClass();
    }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir do token "class".
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamdas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  'class' className '{' classVarDec* subroutineDec* '}'
     */
    public void compileClass() {
    
        //CLASS
        
        //IDENTIFIER
        if ( jtokenizer.advance() && jtokenizer.tokenType( jtokenizer.token() )==jtokenizer.TokenType.IDENTIFIER ) {
        
            //FAZER AQUI AS COISAS, TALVEZ?
        }else{
            printError("IDENTIFIER");
        }
        
        //SYMBOL
        if ( jtokenizer.advance() && jtokenizer.token().equals("{") {
        
            //FAZER AQUI AS COISAS, TALVEZ?
        }else{
            printError("{");
        }
        
        //**
        
        //**
        
        //SYMBOL
        if ( jtokenizer.advance() && jtokenizer.token().equals("}") {
        
            //FAZER AQUI AS COISAS, TALVEZ?
        }else{
            printError("}");
        }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir das declarações da classe.
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamadas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  ('static' | 'field') type varName (',' varName)* ';' 
     */
    public void compileClassVarDec() {
    
        
        //TYPE
        if ( jtokenizer.advance() && jtokenizer.token().equals("static") {
        
            //FAZER AQUI AS COISAS, TALVEZ?
        }else if( jtokenizer.advance() && jtokenizer.token().equals("field"){
            
            //
        }else{
            printError("TYPE");
        }
        
        //IDENTIFIER
        if ( jtokenizer.advance() && jtokenizer.tokenType( jtokenizer.token() )==jtokenizer.TokenType.IDENTIFIER ) {
        
            //FAZER AQUI AS COISAS, TALVEZ?
        }else{
            printError("IDENTIFIER");
        }
        
        
        //SYMBOL
        if ( jtokenizer.advance() && jtokenizer.token().equals(";") {
        
            //FAZER AQUI AS COISAS, TALVEZ?
        }else{
            printError(";");
        }
    }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir das subrotinas da classe.
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamadas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  ('constructor' | 'function' | 'method')
     *                         ('void' | type) subroutineName '(' parameterList ')'
     *                         subroutineBody 
     */
    public void compileSubroutineDec() {
    
        //KEYWORD
        
        if ( jtokenizer.advance() && jtokenizer.tokenType( jtokenizer.token() )==jtokenizer.TokenType.KEYWORD ) {
            jtokenizer.KeywordType keyword= jtokenizer.keyWord( jtokenizer.token());
            
            if (keyword==jtokenizer.KeyWordType.METHOD || keyword==jtokenizer.KeyWordType.FUNCTION || keyword==jtokenizer.KeyWordType.CONSTRUCTOR) {
        
                //FAZER AQUI AS COISAS, TALVEZ?
            }else{
                printError("CONSTRUCTOR ou FUNCTION ou METHOD");
            }
        }else{
            printError("KEYWORD");
        }
        
        //TYPE
        if ( jtokenizer.advance() && jtokenizer.tokenType( jtokenizer.token() )==jtokenizer.TokenType.KEYWORD ) {
            jtokenizer.KeywordType keyword= jtokenizer.keyWord( jtokenizer.token());
            
            if (keyword==jtokenizer.KeyWordType.VOID || keyword==jtokenizer.KeyWordType.INT || keyword==jtokenizer.KeyWordType.CHAR || keyword==jtokenizer.KeyWordType.BOOLEAN) {
        
                //FAZER AQUI AS COISAS, TALVEZ?
            }else{
                printError("VOID ou INT ou CHAR ou BOOLEAN");
            }
        }else{
            printError("KEYWORD");
        }
        
        //IDENTIFIER
        if ( jtokenizer.advance() && jtokenizer.tokenType( jtokenizer.token() )==jtokenizer.TokenType.IDENTIFIER ) {
        
            //FAZER AQUI AS COISAS, TALVEZ?
        }else{
            printError("IDENTIFIER");
        }
        
        //SYMBOL
        if ( jtokenizer.advance() && jtokenizer.token().equals("(") {
        
            //FAZER AQUI AS COISAS, TALVEZ?
        }else{
            printError("(");
        }
        
        //**
        
        //SYMBOL
        if ( jtokenizer.advance() && jtokenizer.token().equals(")") {
        
            //FAZER AQUI AS COISAS, TALVEZ?
        }else{
            printError(")");
        }
        
        //**
        
        
    
    }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir dos parâmetros da subrotina.
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamadas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  ((type varName) (',' type varName)*)?
     */
    public void compileParameterList() {
        
    }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir das declarações da subrotina.
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamadas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  'var' type varName (',' varName)* ';' 
     */
    public void compileVarDec() {

    }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir do corpo da subrotina.
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamadas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  '{' varDec* statements '}'
     */
    public void compileSubroutineBody() {

    }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir da lista de procedimentos da subrotina.
     * As chaves "{" e "}" não são tratadas nessa rotina de compileStatements.
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamadas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  statement*
     */
    public void compileStatements() {
        
    }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir de procedimentos "do".
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamadas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  'do' subroutineCall ';'
     */
    public void compileDo() {
        
    }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir de procedimentos "let".
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamadas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  'let' varName ('[' expression ']')? '=' expression ';'
     */
    public void compileLet() {

    }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir de procedimentos "while".
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamadas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  'while' '(' expression ')' '{' statements '}'
     */
    public void compileWhile() {

    }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir do "return".
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamadas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  'return' expression? ';'
     */
    public void compileReturn() {

    }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir do procedimento "if".
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamadas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  'if' '(' expression ')' '{' statements '}'
     *                         ('else' '{' statements '}')?
     */
    public void compileIf() {

    }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir de um expressão.
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamadas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  term (op term)*
     */
    public void compileExpression() {
        
    }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir de uma lista de expressões (possivelmente vazia).
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamadas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  (expression (',' expression)* )?
     */
    public void compileExpressionList() {

    }

    /**
     * Realiza as chamadas recursivas para criar a árvores sintática a partir de um termo encontrado.
     * Essa rotina é mais complexas que as demais e no caso dos identificadores precisa tomar decisões
     * que podem levar a verificar tokens mais a frente.
     * Grava no arquivo de saida as instruções (se necessárias) para as intruções baseado na gramática do Jack.
     * Realiza as chamadas para navegar no arquivo fonte (.jack) avançando nos tokens já consumidos.
     * Respectivas gramática:  integerConstant | stringConstant | keywordConstant | varName | varName '['
     *                         expression ']' | subroutineCall | '(' expression ')' | unaryOp term
     */
    public void compileTerm() {
    
    }
    
    public void printError(String expected) {
    
        System.out.println(expected + " esperado, recebemos "+jtokenizer.token()+" que eh um "+jtokenizer.tokenType( jtokenizer.token() ));
    }

}
