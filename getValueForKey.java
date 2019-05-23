	if ( inputDoc != null) {
			 IDataCursor idc = inputDoc.getCursor();
		 
		         pValue=IDataUtil.getString(idc,inputKey);
		 
		         IDataUtil.put(pipelineCursor,  "inputKey", pValue);
		
		         idc.destroy();         
		}
