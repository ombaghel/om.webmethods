		String isInjectionPossible="FALSE";
		String s = "ALLOCATE CLOSE DECLARE DESCRIBE EXECUTE FETCH FREE GET INCLUDE OPEN PREPARE SET WHENEVER EXEC ALTER DROP CREATE SHUTDOWN 1=1";
		String[] words = s.split("\\s+");
	    List<String> tokens = Arrays.asList(words);
		String patternString = "\\b(" + StringUtils.join(tokens, "|") + ")\\b";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(sqlSentence.toUpperCase());
	
		while (matcher.find()) {
		    System.out.println(matcher.group(1));
		    
			if (matcher.group(1)!=null && matcher.group(1)!="")
			isInjectionPossible="TRUE";
		}
		return isInjectionPossible;	
