package top.jota.db.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

import top.jota.db.exception.DbExcepition;

@Component
public class DbProperties {

	public static Properties dbPropretiesMysqlLocal() {
		
		String nomeDB = "cpanel";

		try (FileInputStream fs = new FileInputStream("src/main/resources/"+nomeDB+".properties")) {
		
			Properties props = new Properties();
			props.load(fs);
			System.out.println("Arquivo properties encontrado");
			return props;

		} catch (IOException e) {
			System.out.println("Arquivo properties não encontrado");
			throw new DbExcepition(e.getMessage());
		}
	}
	
	/*
	public static Properties obterProperties() {
		
		String nomeDB = "exportarRelatorio";
		String caminhoArquivo = "src/main/resources/"+nomeDB+".properties";
        try (InputStream fs = new FileInputStream(caminhoArquivo)) {
            Properties props = new Properties();
            props.load(fs);
            System.out.println("Arquivo properties encontrado");
            return props;
        } catch (IOException e) {
            System.out.println("Arquivo properties não encontrado");
            throw new RuntimeException(e.getMessage(), e);
        }
    }
		
*/
	public static void salvarPropertiesDiretorioRelatório(String caminhoArquivo, String novoCaminhoSaida, Properties props) {
        // Atualiza a propriedade caminhoSaida
        props.setProperty("caminhoSaida", novoCaminhoSaida);

        try (OutputStream os = new FileOutputStream(caminhoArquivo)) {
            props.store(os, "Comentário opcional");
            System.out.println("Propriedades salvas com sucesso");
        } catch (IOException e) {
            System.out.println("Erro ao salvar as propriedades");
            throw new RuntimeException(e.getMessage(), e);
        }
	
	}
	
	
	
	
public static Properties obterProperties(String nomeDB) {
	
		String caminhoArquivo = "src/main/resources/"+nomeDB+".properties";
        try (InputStream fs = new FileInputStream(caminhoArquivo)) {
            Properties props = new Properties();
            props.load(fs);
            System.out.println("Arquivo properties encontrado");
            return props;
        } catch (IOException e) {
            System.out.println("Arquivo properties não encontrado");
            throw new RuntimeException(e.getMessage(), e);
        }
    }


public static void salvarOpcaoStyle(String caminhoArquivo, String opcao, Properties props) {
    // Atualiza a propriedade caminhoSaida
    props.setProperty("style", opcao);

    try (OutputStream os = new FileOutputStream(caminhoArquivo)) {
        props.store(os, "Comentário opcional");
        System.out.println("Propriedades salvas com sucesso");
    } catch (IOException e) {
        System.out.println("Erro ao salvar as propriedades");
        throw new RuntimeException(e.getMessage(), e);
    }

}


}
	
	
	
	
	

