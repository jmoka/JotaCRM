package top.jota.repository.jasper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Jasper2 {

    public static void main(String caminho) {
        JasperDesign jasperDesign = null;
        JasperReport jasperReport = null;
        JasperPrint jasperPrint = null;
        InputStream entradaArquivo = null;
        
        // Isso define o sistema como não headless, permitindo operações gráficas.
        System.setProperty("java.awt.headless", "false");
                
        
       // String caminho = "C:\\Users\\jotac\\JaspersoftWorkspace\\MyReports\\nivelTodos.jrxml";
        Map<String, Object> parameters = new HashMap<String, Object>();
        String pathReport = caminho ; // Substitua pelo caminho real do seu arquivo .jasper

        // ENTRADA ARQUIVO REPORT.....
        try {
            entradaArquivo = new FileInputStream(new File(pathReport));
        } catch (FileNotFoundException e) {
            System.out.println("Erro na Entrada de Arquivo Jrxml");
            e.printStackTrace();
        }

        // GERAR PAGINA (S) REPORT....
        try {
            jasperDesign = JRXmlLoader.load(entradaArquivo);
        } catch (JRException e) {
            System.out.println("Erro na Entrada de Arquivo Jrxml");
            e.printStackTrace();
        }

        try {
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
        } catch (JRException e) {
            System.out.println("Erro ao Compilar o relatório Jrxml");
            e.printStackTrace();
        }

        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        } catch (JRException e) {
            System.out.println("Erro ao gerar a pagina do relatório Jrxml");
            e.printStackTrace();
        }

        // EXIBIR REPORT
        JasperViewer.viewReport(jasperPrint, false);
    }
}
