package devmultitask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class TesteJEP400 {

	static final String TEXTO = "[devmultitask] Testando acentos aqui: áéíóúç ";
	static final String ARQUIVO = "teste-JEP400.txt";

	public static void main(String[] args) {

		System.out.println("         file.encoding = " + System.getProperty("file.encoding"));
		System.out.println("       Default Charset = " + Charset.defaultCharset());
		System.out.println("Default Charset in Use = " + getDefaultCharSet());

		System.out.println(">> criaArquivoTexto()");
		criaArquivoTexto(TEXTO);

		System.out.println(">> carregaArquivoTexto()");
		carregaArquivoTexto();

	}

	private static void criaArquivoTexto(String texto) {
		try (FileWriter writer = new FileWriter(ARQUIVO); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
			bufferedWriter.write(texto);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private static void carregaArquivoTexto() {
		try (FileReader reader = new FileReader(ARQUIVO); BufferedReader bufferedReader = new BufferedReader(reader)) {
			String line = bufferedReader.readLine();
			System.out.println(line);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private static String getDefaultCharSet() {
		OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
		String enc = writer.getEncoding();
		return enc;
	}
}