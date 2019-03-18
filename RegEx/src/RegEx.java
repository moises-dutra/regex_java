import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public RegEx() {

	}

	public void avaliar(String nomeArquivo, String regex) {

		String texto = "";
		try
		{
			System.out.println("nomeArquivo: " + nomeArquivo);
			texto = new String(Files.readAllBytes(Paths.get(nomeArquivo)));
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return;
		}

		System.out.println("\n##### Início do arquivo: #####");
		System.out.println(texto);
		System.out.println("\n##### Fim do arquivo: #####");
				
		Pattern r = Pattern.compile(regex, Pattern.MULTILINE);
		Matcher m = r.matcher(texto);

		ArrayList<String> lista = new ArrayList <String>();
		while (m.find())
			lista.add(m.group(0));

		if (lista.size() <= 0) {
			
			System.out.println("Sequência NÃO encontrada!");
			return;
		}
			
		System.out.println("Sequência encontrada!");
		System.out.println("Quantidade de elementos: "+ lista.size());
		
		for (String item : lista)
			System.out.println("[ " + item + " ]");

	}

}
