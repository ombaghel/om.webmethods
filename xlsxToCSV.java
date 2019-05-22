//Pretty much all flatfiles pass the seperator

public static String XLSTextToFF(InputStream is, String seperator) throws Exception {
		String text = null;

		try {
			StringBuffer sb = new StringBuffer();

			XSSFWorkbook workbook = new XSSFWorkbook(is);
			int numOfSheets = workbook.getNumberOfSheets();

			for (int i = 0; i < numOfSheets; i++) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rowIterator = sheet.rowIterator();

				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();

					Iterator<Cell> cellIterator = row.cellIterator();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						String cellStringValue = null;

						if (cell.getCellType() == CellType.BOOLEAN) {
							boolean booleanValue = cell.getBooleanCellValue();

							cellStringValue = String.valueOf(booleanValue);
						} else if (cell.getCellType() == CellType.NUMERIC) {
							double doubleValue = cell.getNumericCellValue();

							cellStringValue = String.valueOf(doubleValue);
						} else if (cell.getCellType() == CellType.STRING) {
							RichTextString richTextString = cell.getRichStringCellValue();

							cellStringValue = richTextString.getString();
						}

						if (cellStringValue != null) {
							sb.append(cellStringValue);
							sb.append(seperator);
						}
					}

					sb.append("\n");
				}
			}

			text = sb.toString();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return text;
	}
