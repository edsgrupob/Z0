/**
 * Curso: Elementos de Sistemas
 * Arquivo: Code.java
 */

package vmtranslator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import vmtranslator.Parser.CommandType;


/** 
 * Traduz da linguagem vm para códigos assembly.
 */
public class Code {	
	private BufferedWriter writer;
	private String inputfile;
	
    /** 
     * Abre o arquivo de entrada VM e se prepara para analisá-lo.
     * @param filename nome do arquivo VM que será feito o parser.
     * @throws IOException 
     */
	public Code(String filename) throws IOException {
		vmfile(filename);
		
    	try{
            writer = new BufferedWriter(new FileWriter("codeoutput.nasm"));
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Grava no arquivo de saida as instruções em Assembly para executar o comando aritmético.
     * @param  command comando aritmético a ser analisado.
     * @throws IOException 
     */
    public void writeArithmetic(String command) throws IOException {
    	if(command.equals("add")){
    		writer.write("leaw $SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("movw %A, %D");
    		writer.write("leaw $SP, %A");
    		writer.write("movw %D, (%A)");
    		writer.write("movw (%A), %D");
    		writer.write("movw %D, %A");
    		writer.write("movw (%A), %D");
    		writer.write("decw %A");
    		writer.write("addw (%A), %D, %D");
    		writer.write("movw %D, (%A)");
    	}
    	if (command.equals("sub")){
    		writer.write("leaw $SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("movw %A, %D");
    		writer.write("leaw $SP, %A");
    		writer.write("movw %D, (%A)");
    		writer.write("movw (%A), %D");
    		writer.write("movw %D, %A");
    		writer.write("movw (%A), %D");
    		writer.write("decw %A");
    		writer.write("subw %D, (%A), %D");
    		writer.write("movw %D, (%A)");
    	}
    	if (command.equals("neg")){
    		writer.write("leaw $SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("negw (%A)");
    	}
    	if (command.equals("eq")){
    		writer.write("leaw $SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("movw %A, %D");
    		writer.write("leaw $SP, %A");
    		writer.write("movw %D, (%A)");
    		writer.write("movw (%A), %D");
    		writer.write("movw %D, %A");
    		writer.write("movw (%A), %D");
    		writer.write("decw %A");
    		writer.write("subw (%A), %D, %D");
    		writer.write("leaw $TRUE, %A");
    		writer.write("je");
    		writer.write("nop");
    		writer.write("leaw %SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("movw $0, (%A)");
    		writer.write("leaw $END, %A");
    		writer.write("jmp");
    		writer.write("nop");
    		writer.write("TRUE:");
    		writer.write("leaw $SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("movw $1, (%A)");
    		writer.write("END:");

    	}
    	if (command.equals("gt")){
       		writer.write("leaw $SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("movw %A, %D");
    		writer.write("leaw $SP, %A");
    		writer.write("movw %D, (%A)");
    		writer.write("movw (%A), %D");
    		writer.write("movw %D, %A");
    		writer.write("movw (%A), %D");
    		writer.write("decw %A");
    		writer.write("subw %D, (%A), %D");
    		writer.write("leaw $TRUE, %A");
    		writer.write("jg");
    		writer.write("nop");
    		writer.write("leaw %SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("movw $0, (%A)");
    		writer.write("leaw $END, %A");
    		writer.write("jmp");
    		writer.write("nop");
    		writer.write("TRUE:");
    		writer.write("leaw $SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("movw $1, (%A)");
    		writer.write("END:");
    	}
    	if (command.equals("lt")){
       		writer.write("leaw $SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("movw %A, %D");
    		writer.write("leaw $SP, %A");
    		writer.write("movw %D, (%A)");
    		writer.write("movw (%A), %D");
    		writer.write("movw %D, %A");
    		writer.write("movw (%A), %D");
    		writer.write("decw %A");
    		writer.write("subw %D, (%A), %D");
    		writer.write("leaw $TRUE, %A");
    		writer.write("jl");
    		writer.write("nop");
    		writer.write("leaw %SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("movw $0, (%A)");
    		writer.write("leaw $END, %A");
    		writer.write("jmp");
    		writer.write("nop");
    		writer.write("TRUE:");
    		writer.write("leaw $SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("movw $1, (%A)");
    		writer.write("END:");
    		
    	}
    	if(command.equals("and")){
    		writer.write("leaw $SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("movw %A, %D");
    		writer.write("leaw $SP, %A");
    		writer.write("movw %D, (%A)");
    		writer.write("movw (%A), %D");
    		writer.write("movw %D, %A");
    		writer.write("movw (%A), %D");
    		writer.write("decw %A");
    		writer.write("andw %D, (%A), %D");
    		writer.write("movw %D, (%A)");
    	}
    	if (command.equals("or")){
    		writer.write("leaw $SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("movw %A, %D");
    		writer.write("leaw $SP, %A");
    		writer.write("movw %D, (%A)");
    		writer.write("movw (%A), %D");
    		writer.write("movw %D, %A");
    		writer.write("movw (%A), %D");
    		writer.write("decw %A");
    		writer.write("orw %D, (%A), %D");
    		writer.write("movw %D, (%A)");
    	}
    	if (command.equals("not")){
    		writer.write("leaw $SP, %A");
    		writer.write("movw (%A), %A");
    		writer.write("decw %A");
    		writer.write("notw (%A)");
    	}

    }

    /**
     * Grava no arquivo de saida as instruções em Assembly para executar o comando de Push ou Pop.
     * @param  command comando de push ou pop a ser analisado.
     * @param  segment segmento de memória a ser usado pelo comando.
     * @param  index índice do segkento de memória a ser usado pelo comando.
     * @throws IOException 
     */
    public void writePushPop(Parser.CommandType command, String segment, Integer index) throws IOException {
    	try {
	    	if (segment.equals("local")){
	    		segment = "1";
	    	}
	    	if (segment.equals("argument")){
	    		segment = "2";
	    	}
	    	if (segment.equals("this")){
	    		segment = "3";
	    	}
	    	if (segment.equals("that")) {
	    		segment = "4";
	    	}
	    	if (segment.equals("constant")) {
	    		segment = index.toString();
	    	}
	    	
	    	if(command.equals(CommandType.C_PUSH)){
	    		writer.write(String.format("leaw $%s , %A", segment));
	    		writer.write("movw (%A) , %A");
	    		for (int i = 0; i<index; i++){
	    			writer.write("incw %A");
	    		}
	    		writer.write("movw (%A) , %D");
	    		writer.write("leaw $0 , %A");
	    		writer.write("movw (%A) , %A");
	    		writer.write("movw %D , (%A)");
	    		writer.write("incw %A");
	    		writer.write("movw %A , %D");
	    		writer.write("leaw $0 , %A");
	    		writer.write("movw %D , (%A)");
	    	}
	    	else if(command.equals(CommandType.C_POP)){
	    		writer.write("leaw $0, %A");
	    		writer.write("movw (%A) , %D");
	    		writer.write("subw %D , $1 , %D");
	    		writer.write("movw %D , (%A)");
	    		writer.write("movw %D, %A");
	    		writer.write("movw (%A) , %D");
	    		writer.write(String.format("leaw $%s , %A", segment));
	    		writer.write("movw (%A) , %A");
	    		for (int i = 0; i<index; i++){
	    			writer.write("incw %A");
	    		}
	    		writer.write("movw %D , (%A)");
	    	}
	    }
    	catch (IOException e) {
    		System.out.println("writePushPop error");
    	}
    }


    /**
     * Grava no arquivo de saida as instruções em Assembly para inicializar o processo da VM (bootstrap).
     * Também prepara a chamada para a função Sys.init
     * O código deve ser colocado no início do arquivo de saída.
     */
    public void writeInit() {
    	try {
	    	writer.write("leaw $256, %A");
	    	writer.write("movw %A, %D");
	    	writer.write("leaw $SP, %A");
	    	writer.write("movw (%A), %A");
	    	writer.write("movw %A, %D");
	    	}
    	catch (IOException e) {
    		System.out.println("writeInit error");
    	}
    }

    /**
     * Grava no arquivo de saida as instruções em Assembly para gerar o labels (marcadores de jump).
     * @param  label define nome do label (marcador) a ser escrito.
     */
    public void writeLabel(String label) {
    	try {
	    	writer.write(label + ":");
	    	}
    	catch (IOException e) {
    		System.out.println("writeLabel error");
    	}
    }

    /**
     * Grava no arquivo de saida as instruções em Assembly para gerar as instruções de goto (jumps).
     * Realiza um jump incondicional para o label informado.
     * @param  label define jump a ser realizado para um label (marcador).
     */
    public void writeGoto(String label) {
    	try {
	    	writer.write("leaw %" + label + ", %A");
	    	writer.write("jne");
	    	writer.write("nop");
	    	}
    	catch (IOException e) {
    		System.out.println("writeGoto error");
    	}
    }

    /**
     * Grava no arquivo de saida as instruções em Assembly para gerar as instruções de goto condicional (jumps condicionais).
     * Realiza um jump condicional para o label informado.
     * @param  label define jump a ser realizado para um label (marcador).
     */
    public void writeIf(String label) {
    	try {
	    	writer.write("leaw %" + label + ", %A");
	    	writer.write("jne");
	    	writer.write("nop");
	    	}
    	catch (IOException e) {
    		System.out.println("writeIf error");
    	}
    }

    /**
     * Grava no arquivo de saida as instruções em Assembly para uma chamada de função (Call).
     * @param  functionName nome da função a ser "chamada" pelo call.
     * @param  numArgs número de argumentos a serem passados na função call.
     * @throws IOException 
     */
    public void writeCall(String functionName, Integer numArgs) throws IOException {
    	//push return adresss
    	writePushPop(CommandType.C_PUSH, "local", 0);
    	for (int i = 0; i < numArgs; i ++){
    		writePushPop(CommandType.C_PUSH, "argument", i);
    	}
    	writePushPop(CommandType.C_PUSH, "this", 0);
    	writePushPop(CommandType.C_PUSH, "that", 0);
    	for (int i = 0; i < numArgs; i ++){
    		writePushPop(CommandType.C_PUSH, "argument", i);
    	}
    }

    /**
     * Grava no arquivo de saida as instruções em Assembly para o retorno de uma sub rotina.
     */
    public void writeReturn() {
    	try {
	    	writer.write("movw %A, %D");
	    	writer.write("ret");
	    	}
    	catch (IOException e) {
    		System.out.println("writeReturn error");
    	}
    }

    /**
     * Grava no arquivo de saida as instruções em Assembly para a declaração de uma função.
     * @param  functionName nome da função a ser criada.
     * @param  numLocals número de argumentos a serem passados na função call.
     * @throws IOException 
     */
    public void writeFunction(String functionName, Integer numLocals) throws IOException {
      writeLabel(functionName);
      
      for (int i=0; i<numLocals; i++){
    	  writePushPop(CommandType.C_PUSH, "constant", 0);
      }
    }

    /**
     * Armazena o nome do arquivo vm de origem.
     * Usado para definir os dados estáticos do código (por arquivo).
     * @param  filename nome do arquivo sendo tratado.
     */
    public void vmfile(String file) {
    	inputfile = file;
    }

}
