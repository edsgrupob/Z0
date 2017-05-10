/**
 * Curso: Elementos de Sistemas
 * Arquivo: Code.java
 */

package vmtranslator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

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
     */
    public void writeArithmetic(String command) {

    }

    /**
     * Grava no arquivo de saida as instruções em Assembly para executar o comando de Push ou Pop.
     * @param  command comando de push ou pop a ser analisado.
     * @param  segment segmento de memória a ser usado pelo comando.
     * @param  index índice do segkento de memória a ser usado pelo comando.
     */
    public void writePushPop(Parser.CommandType command, String segment, Integer index) {

    }

    /**
     * Grava no arquivo de saida as instruções em Assembly para inicializar o processo da VM (bootstrap).
     * Também prepara a chamada para a função Sys.init
     * O código deve ser colocado no início do arquivo de saída.
     */
    public void writeInit() {

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
     */
    public void writeCall(String functionName, Integer numArgs) {

    }

    /**
     * Grava no arquivo de saida as instruções em Assembly para o retorno de uma sub rotina.
     */
    public void writeReturn() {

    }

    /**
     * Grava no arquivo de saida as instruções em Assembly para a declaração de uma função.
     * @param  functionName nome da função a ser criada.
     * @param  numLocals número de argumentos a serem passados na função call.
     */
    public void writeFunction(String functionName, Integer numLocals) {

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
