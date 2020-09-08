package cl.com.tikai.flores.helper;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import cl.com.tikai.flores.dto.ResultadoProcesoFlores;


public class ExcelHelper {
	
	private static Logger LOG = LoggerFactory.getLogger(ExcelHelper.class);
	
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  
  private static int INICIO_DE_FILA = 1;
  private static String SI = "SI";
  private static int INICIO_DE_COLUMNA = 4;

  public static boolean hasExcelFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

 
  public static ArrayList<ResultadoProcesoFlores> leeExcel(InputStream is) {
	  ArrayList<ResultadoProcesoFlores> resumenFlores = new ArrayList<ResultadoProcesoFlores>();
		ResultadoProcesoFlores resultadoProcesoFlores;
	    try {      	
      	LOG.info("********INICIANDO LECTURA DE EXCEL*******************");
      	Workbook workbook = new XSSFWorkbook(is);
      	
          Sheet hoja = (XSSFSheet) workbook.getSheetAt(0);
          int numeroFila = 0;
          for (Iterator<Row> iterator = hoja.rowIterator(); iterator.hasNext(); numeroFila++) {
              Row fila = iterator.next();
              if (numeroFila >= INICIO_DE_FILA) {
            	  resultadoProcesoFlores = new ResultadoProcesoFlores();
            	  LOG.info("--->" + fila.getCell(3));

						resultadoProcesoFlores.setNombre(fila.getCell(3) != null ? fila.getCell(3).toString(): "");
	                	resultadoProcesoFlores.setFecha(fila.getCell(4) != null ? fila.getCell(4).toString(): "");
	                	resultadoProcesoFlores.setRock_rose(getValor(fila, INICIO_DE_COLUMNA, INICIO_DE_COLUMNA + 1));
	                	resultadoProcesoFlores.setMimulus(getValor(fila, INICIO_DE_COLUMNA + 2, INICIO_DE_COLUMNA + 3));
	                	resultadoProcesoFlores.setCherry_Plum(getValor(fila, INICIO_DE_COLUMNA + 4, INICIO_DE_COLUMNA + 5));
	                	resultadoProcesoFlores.setAspen(getValor(fila, INICIO_DE_COLUMNA + 6, INICIO_DE_COLUMNA + 7));
	                	resultadoProcesoFlores.setCherRed_Chestnut(getValor(fila, INICIO_DE_COLUMNA + 8, INICIO_DE_COLUMNA + 9));
	                	resultadoProcesoFlores.setCerato(getValor(fila, INICIO_DE_COLUMNA + 10, INICIO_DE_COLUMNA + 11));
	                	resultadoProcesoFlores.setScleranthus(getValor(fila, INICIO_DE_COLUMNA + 12, INICIO_DE_COLUMNA + 13));
	                	resultadoProcesoFlores.setGentian(getValor(fila, INICIO_DE_COLUMNA + 14, INICIO_DE_COLUMNA + 15));
	                	resultadoProcesoFlores.setWild_Oat(getValor(fila, INICIO_DE_COLUMNA + 16, INICIO_DE_COLUMNA + 17));
	                	resultadoProcesoFlores.setGorse(getValor(fila, INICIO_DE_COLUMNA + 18, INICIO_DE_COLUMNA + 19));
	                	resultadoProcesoFlores.setHornbeam(getValor(fila, INICIO_DE_COLUMNA + 20, INICIO_DE_COLUMNA + 21));
	                	resultadoProcesoFlores.setClematis(getValor(fila, INICIO_DE_COLUMNA + 22, INICIO_DE_COLUMNA + 23));
	                	resultadoProcesoFlores.setHoneysuckle(getValor(fila, INICIO_DE_COLUMNA + 24, INICIO_DE_COLUMNA + 25));
	                	resultadoProcesoFlores.setWild_Rose(getValor(fila, INICIO_DE_COLUMNA + 26, INICIO_DE_COLUMNA + 27));
	                	resultadoProcesoFlores.setOlive(getValor(fila, INICIO_DE_COLUMNA + 28, INICIO_DE_COLUMNA + 29));
	                	resultadoProcesoFlores.setWhite_Chestnut(getValor(fila, INICIO_DE_COLUMNA + 30, INICIO_DE_COLUMNA + 31));
	                	resultadoProcesoFlores.setChestnut_Bud(getValor(fila, INICIO_DE_COLUMNA + 32, INICIO_DE_COLUMNA + 33));
	                	resultadoProcesoFlores.setMustard(getValor(fila, INICIO_DE_COLUMNA + 34, INICIO_DE_COLUMNA + 35));
	                	resultadoProcesoFlores.setAgrimony(getValor(fila, INICIO_DE_COLUMNA + 36, INICIO_DE_COLUMNA + 37));
	                	resultadoProcesoFlores.setCentaury(getValor(fila, INICIO_DE_COLUMNA + 38, INICIO_DE_COLUMNA + 39));
	                	resultadoProcesoFlores.setWalnut(getValor(fila, INICIO_DE_COLUMNA + 40, INICIO_DE_COLUMNA + 41));
	                	resultadoProcesoFlores.setHolly(getValor(fila, INICIO_DE_COLUMNA + 42, INICIO_DE_COLUMNA + 43));
	                	resultadoProcesoFlores.setWater_Violet(getValor(fila, INICIO_DE_COLUMNA + 44, INICIO_DE_COLUMNA + 45));
	                	resultadoProcesoFlores.setImpatiens(getValor(fila, INICIO_DE_COLUMNA + 46, INICIO_DE_COLUMNA + 47));
	                	resultadoProcesoFlores.setHeather(getValor(fila, INICIO_DE_COLUMNA + 48, INICIO_DE_COLUMNA + 49));
	                	resultadoProcesoFlores.setLarch(getValor(fila, INICIO_DE_COLUMNA + 50, INICIO_DE_COLUMNA + 51));
	                	resultadoProcesoFlores.setPine(getValor(fila, INICIO_DE_COLUMNA + 52, INICIO_DE_COLUMNA + 53));
	                	resultadoProcesoFlores.setElm(getValor(fila, INICIO_DE_COLUMNA + 54, INICIO_DE_COLUMNA + 55));
	                	resultadoProcesoFlores.setSweet_Chestnut(getValor(fila, INICIO_DE_COLUMNA + 56, INICIO_DE_COLUMNA + 57));
	                	resultadoProcesoFlores.setStar_of_Bethlehem(getValor(fila, INICIO_DE_COLUMNA + 58, INICIO_DE_COLUMNA + 59));
	                	resultadoProcesoFlores.setWillow(getValor(fila, INICIO_DE_COLUMNA + 60, INICIO_DE_COLUMNA + 61));
	                	resultadoProcesoFlores.setOak(getValor(fila, INICIO_DE_COLUMNA + 62, INICIO_DE_COLUMNA + 63));
	                	resultadoProcesoFlores.setCrab_Apple(getValor(fila, INICIO_DE_COLUMNA + 64, INICIO_DE_COLUMNA + 65));
	                	resultadoProcesoFlores.setChicory(getValor(fila, INICIO_DE_COLUMNA + 66, INICIO_DE_COLUMNA + 67));
	                	resultadoProcesoFlores.setVervain(getValor(fila, INICIO_DE_COLUMNA + 68, INICIO_DE_COLUMNA + 69));
	                	resultadoProcesoFlores.setVine(getValor(fila, INICIO_DE_COLUMNA + 70, INICIO_DE_COLUMNA + 71));
	                	resultadoProcesoFlores.setBeech(getValor(fila, INICIO_DE_COLUMNA + 72, INICIO_DE_COLUMNA + 73));
	                	resultadoProcesoFlores.setRock_Water(getValor(fila, INICIO_DE_COLUMNA + 74, INICIO_DE_COLUMNA + 75));
	                	resumenFlores.add(resultadoProcesoFlores);
            	  }
              }              
 
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
  }
	    LOG.info("--->: " + resumenFlores);
	    return resumenFlores;
	}
  
  /**
	 * 
	 * */
  
  public static String getValor(Row fila, int llave1, int llave2) {
      String resultado = "";
      int posicion1 = llave1;
      int posicion2 = llave2;
      if (fila.getCell(posicion1) != null && fila.getCell(posicion2) != null) {
      	if (fila.getCell(posicion1).toString().equalsIgnoreCase(SI) && fila.getCell(posicion2).toString().equalsIgnoreCase(SI)) {
      		resultado = "SI";   
      		//resultado = "<img src=\"file:///C|/flores/imagenes/check.jpg\" width=\"30\" height=\"30\">";
      	}
      } 
      return resultado;
  }
}