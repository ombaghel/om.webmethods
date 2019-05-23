		  MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    byte[] hash = digest.digest(data.getBytes("UTF-8"));
	    return DatatypeConverter.printHexBinary(hash).toLowerCase();
