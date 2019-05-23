  //Sometimes needed to resize and save big image in DB/Files
  try {
			  
 			   InputStream imageStream = new BufferedInputStream(new ByteArrayInputStream(originalImage));
 			   BufferedImage img =ImageIO.read(imageStream);
			  int scaleX = (int) (img.getWidth() * 0.5);
			  int scaleY = (int) (img.getHeight() * 0.5);
			   BufferedImage thumbImage = new BufferedImage(scaleX,scaleY, BufferedImage.TYPE_INT_RGB);
	
 			   ImageIO.write(thumbImage, OUTPUT_FORMAT_ID, out);
	
		  }
