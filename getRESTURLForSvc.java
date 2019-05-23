		String	serviceName = IDataUtil.getString( pipelineCursor, "serviceName" );
		String hostName = ServerAPI.getServerName(); 
		serviceName =  serviceName.replace(".", "/"); //boths works
		serviceName = serviceName.substring(0, serviceName.indexOf(":")); //replace last will remove _svcs
		String restURL =  "http://" + hostName + "/rest" + "/" + serviceName;
		 
