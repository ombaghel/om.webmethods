 		 IData[] aryData = IDataUtil.getIDataArray(cursorIn, "inputList");
		 IData outputDoc = IDataFactory.create();
		 IDataCursor outputDocCursor = outputDoc.getCursor();
					
		        for (int i = 0; i < aryData.length; i++) {
		        	  
		        	  String pKey=null;
		        	  String[] pValue=null;
		      		IDataCursor idc = aryData[i].getCursor();
		      	 while (idc.next())
		      	  {
		      		  String key = idc.getKey();
		              if(key.contains("key"))
		              {
			               pKey = idc.getValue().toString();
		
		              }
		              if(key.contains("values"))
		              {
		            	  pValue=IDataUtil.getStringArray(idc, "values");
		
		              }
		      	  }
		              
			   IDataUtil.put(outputDocCursor, pKey, pValue);
		
			 idc.destroy();         
		
	            }
		
