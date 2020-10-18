package com.groupal.libreriaPrismaBackend.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DateUtil {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DateUtil.class);
	
	public static String DATE_FORMAT_AMDHMS = "yyyy/MM/dd HH:mm:ss";
	public static String DATE_FORMAT_DMAHMS = "dd/MM/yyyy HH:mm:ss";
	public static String DATE_FORMAT_DMAHM = "dd/MM/yyyy HH:mm";
	public static String DATE_FORMAT_DMA = "dd/MM/yyyy";
	public static String DATE_FORMAT_DB = "yyyy-MM-dd HH:mm:ss";
	
	public DateUtil() {}

	/**
	 * Valida una fecha con su respectivo formato.
	 * 
	 * @param sDate la fecha a validar
	 * @param format formato de fecha
	 * @return true si la fecha esta ok, false en caso contrario.
	 */
	public static synchronized boolean isValidDate(String sDate, String format) {
		
		boolean hResult = true;

		if("".equals(sDate) || sDate == null) {
			
			hResult = false;
			
		} else {
			
			try {
				
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				sdf.setLenient(false);
				sdf.parse(sDate);
			
			} catch (ParseException pe) {
				
				hResult = false;
				
			}
		}
		
		return hResult;
	}
	
	/**
	 * Convierte un String a Date con su respectivo formato.
	 * 
	 * @param sDate
	 * @param format
	 * @return null si no se puede convertir el string.
	 */
	public static synchronized Date convertStringToDate(String sDate, String format) {
		
		Date dResult = null;

		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			sdf.setLenient(false);
			dResult = sdf.parse(sDate);
			
		} catch (Exception pe) {
			// do nothing.
		}

		return dResult;
	}
	
	/**
	 * Convierte un Date a String con su respectivo formato.
	 * 
	 * @param dDate
	 * @param format
	 * @return String de la fecha convertida.
	 */
	public static synchronized String convertDateToString(Date dDate, String format) {
		
		String sResult = null;
		
		try {
					
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			sResult = sdf.format(dDate);
		
		} catch (Exception pe) {
			// do nothing.
		}
		
		return sResult;
	}
	
	/**
	 * Compara dos fechas. Si la primera es mas chica que
	 * la segunda devuelve -1, si es mas grande que la segunda devuelve 1, y si
	 * son iguales 0.
	 * 
	 * @param dDate1
	 * @param dDate2
	 * @return
	 */
	public static synchronized Integer compareDate(Date dDate1, Date dDate2) {
		
		Integer cmpDate = null;
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(dDate1);
		c2.setTime(dDate2);

		/*
		 * the value 0 if the time represented by the argument is equal to
		 * the time represented by this Calendar; a value less than 0 if the
		 * time of this Calendar is before the time represented by the
		 * argument; and a value greater than 0 if the time of this Calendar
		 * is after the time represented by the argument.
		 */
		if (c1.compareTo(c2) > 0) {
			cmpDate = 1;
		} else if(c1.compareTo(c2) < 0) {
			cmpDate = -1;
		} else {
			cmpDate = 0;
		}
		
		return cmpDate;
	}
	
	public static synchronized Long cantidadDeDiasEntreDosFechas(String dDate1, String dDate2) {
		
		Calendar c3 =  Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(convertStringToDate(dDate1, DATE_FORMAT_DMA));
		c2.setTime(convertStringToDate(dDate2, DATE_FORMAT_DMA));
		
		c3.setTimeInMillis(c1.getTime().getTime() - c2.getTime().getTime());
		
		Long timeInMilis = c3.getTimeInMillis();
		
		Long dias = timeInMilis / 86400000;
		
		LOGGER.info("dias : " + dias);
		
		return dias;			
	}
	
	/**
	 * Funci�n que valida una fecha <code>String</code> dependiendo del
	 * formato que se le asigne. <br>
	 * <br>
	 * Forma de uso:
	 * <code>Utilities.isDate(date, Utilities.DATE_FORMAT_DMA);</code><br>
	 * <br>
	 * Formatos Compatibles: <br>
	 * <code>DATE_FORMAT_DMAHMS</code> = "dd/MM/yyyy HH:mm:ss" <br>
	 * <code>DATE_FORMAT_DMAHM</code> = "dd/MM/yyyy HH:mm" <br>
	 * <code>DATE_FORMAT_DMA</code> = "dd/MM/yyyy"
	 * 
	 * @param dateParam
	 *            Fecha que se desea validar.
	 * @param format
	 *            Formato con el cual se validar� la fecha.
	 * @return Devuelve true si la fecha es correcta y false si no lo es.
	 * @deprecated
	 */
    public static Boolean isDate(String dateParam, String format) {

		boolean validate = true;

		try {

			if (dateParam != null && !"".equals(dateParam) && format != null
					&& !"".equals(format)) {

				int day = 0;
				int month = 0;
				int year = 0;
				int hour = 0;
				int minute = 0;
				int second = 0;

				if (DATE_FORMAT_DMAHMS.equals(format)) {
					day = Integer.parseInt(dateParam.substring(0, 2));
					month = Integer.parseInt(dateParam.substring(3, 5));
					year = Integer.parseInt(dateParam.substring(6, 10));
					hour = Integer.parseInt(dateParam.substring(11, 13));
					minute = Integer.parseInt(dateParam.substring(14, 16));
					second = Integer.parseInt(dateParam.substring(17, 19));

					if ((day < 1 || day > 31)
							|| (month < 1 || month > 12)
							|| (year < 2000 || year > 3000)
							|| !DateUtil.validateLastDayOfMonth(day, month,
									year) || (hour > 23) || (minute > 59)
							|| (second > 59)) {
						validate = false;
					}
				} else if (DATE_FORMAT_DMAHM.equals(format)) {
					day = Integer.parseInt(dateParam.substring(0, 2));
					month = Integer.parseInt(dateParam.substring(3, 5));
					year = Integer.parseInt(dateParam.substring(6, 10));
					hour = Integer.parseInt(dateParam.substring(11, 13));
					minute = Integer.parseInt(dateParam.substring(14, 16));

					if ((day < 1 || day > 31)
							|| (month < 1 || month > 12)
							|| (year < 2000 || year > 3000)
							|| !DateUtil.validateLastDayOfMonth(day, month,
									year) || (hour > 23) || (minute > 59)) {
						validate = false;
					}
				} else if (DATE_FORMAT_DMA.equals(format)) {
					day = Integer.parseInt(dateParam.substring(0, 2));
					month = Integer.parseInt(dateParam.substring(3, 5));
					year = Integer.parseInt(dateParam.substring(6, 10));

					if ((day < 1 || day > 31)
							|| (month < 1 || month > 12)
							|| (year < 2000 || year > 3000)
							|| !DateUtil.validateLastDayOfMonth(day, month,
									year)) {
						validate = false;
					}
				}

				DateFormat df = new SimpleDateFormat(format);

				df.parse(dateParam);

			} else {
				validate = false;
			}

		} catch (Exception e) {
			validate = false;
		}

		return validate;
	}
	
	private static Boolean validateLastDayOfMonth(int dayParam, int monthParam, int yearParam) {

		int maxDayOfMonth = 0;

		boolean validate = true;

		switch (monthParam) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			maxDayOfMonth = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			maxDayOfMonth = 30;
			break;
		case 2:
			if (((yearParam % 4 == 0) && !(yearParam % 100 == 0))
					|| (yearParam % 400 == 0)) {
				maxDayOfMonth = 29;
			} else {
				maxDayOfMonth = 28;
			}
			break;
		default:
			validate = false;
			break;
		}

		if (dayParam > maxDayOfMonth) {
			validate = false;
		}

		return validate;
    }
}
