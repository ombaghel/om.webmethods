public static final void excelToJson(IData pipeline) throws ServiceException {
		IDataCursor pipelineCursor = pipeline.getCursor();
		InputStream is = null;
		
		if(pipelineCursor.first("stream")){
		    is = (InputStream) pipelineCursor.getValue();
		}else{
			throw new ServiceException("Input parameter \'stream\' was not found.");
		}
		
		try {
			IDataUtil.put( pipelineCursor, "output", getSheetData(new XSSFWorkbook(is)).toString() );
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		
		}
		pipelineCursor.destroy();
			
	}

public static  JSONObject getWorkBookHeaders(XSSFWorkbook wb ) throws  Exception{
	    JSONObject obj=new JSONObject();
	    JSONArray array=new JSONArray();
	    int SheetSum = wb.getNumberOfSheets();
	    for(int i=0;i<SheetSum;i++){
	         String sheetName=wb.getSheetName(i);
	         XSSFSheet sheet = wb.getSheetAt(i);
	         XSSFRow row = sheet.getRow(0);
	        if(row!=null) {
	            int cellsSum = row.getPhysicalNumberOfCells();
	            array.clear();
	            for (int j = 0; j < cellsSum; j++) {
	                array.add(row.getCell(j).getStringCellValue().trim());
	            }
	            obj.put(sheetName,array);
	        }
	    }
	   return obj;
	}
	
	public static  JSONArray getSheetData(XSSFWorkbook wb ) throws Exception{
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	    JSONObject table = getWorkBookHeaders( wb);
	    System.out.println("tables "+table);
		XSSFSheet sheet = wb.getSheetAt(0);
		
	    int RowSum = sheet.getPhysicalNumberOfRows();
	    int CellSum =  sheet.getRow(0).getPhysicalNumberOfCells();
	   // JSONArray array = JSONArray.fromObject(table.get("Sheet1"));
	    JSONArray array = JSONArray.fromObject(table.get(sheet.getSheetName()));
	
	    JSONArray arr=new JSONArray();
	
	    JSONObject obj_sun =new JSONObject();
	 
	    for(int i=1;i<RowSum;i++){
	
	        XSSFRow row = sheet.getRow(i);
	        obj_sun.clear();
	        for(int j=0;j<CellSum;j++){
	
	            XSSFCell cell = row.getCell(j);
	            if (cell!=null) {
					String cellStringValue = null;
	
					
					if (cell.getCellType() == CellType.BOOLEAN) {
						boolean booleanValue = cell.getBooleanCellValue();
	
						cellStringValue = String.valueOf(booleanValue);
					} else if (cell.getCellType() == CellType.NUMERIC) {
	
						 if (HSSFDateUtil.isCellDateFormatted(cell)) {
							  cellStringValue= dateFormat.format(cell.getDateCellValue()   );
				            }
						 else
						 {
							 double doubleValue = cell.getNumericCellValue();
								cellStringValue = String.valueOf(doubleValue);
	
						 }
					} else if (cell.getCellType() == CellType.STRING) {
						RichTextString richTextString = cell.getRichStringCellValue();
						cellStringValue = richTextString.getString();
					}
					
	                System.out.println(i+" "+array.get(j)+":"+cellStringValue);
	                
	                
	             	obj_sun.put(array.get(j),cellStringValue);
	            }
	            else
	            	obj_sun.put(array.get(j),"");               	
	        }
	        arr.add(obj_sun);
	    }
	
	    return arr;
	}	 
