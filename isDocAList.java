		// documentList
		IData[]	documentList = IDataUtil.getIDataArray( pipelineCursor, "inputDoc" );
		if ( documentList != null) {
			isList="true";		
		}
		
		// pipeline
		IDataUtil.put( pipelineCursor, "isList", isList );
