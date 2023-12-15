package top.jota.repository.jasper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Jasper {

    public static void main(String[] args) {
        JasperDesign jasperDesign = null;
        JasperReport jasperReport = null;
        JasperPrint jasperPrint = null;
        InputStream entradaArquivo = null;
        String caminho = "C:\\Users\\jotac\\JaspersoftWorkspace\\MyReports\\nivelTodos.jrxml";
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
