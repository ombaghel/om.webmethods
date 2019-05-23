   try
		{
		    DataCollector.getDiagnosticData(pipeline);
		}
		catch(Throwable t)
		{
		    throw new ServiceException(t);
		}
