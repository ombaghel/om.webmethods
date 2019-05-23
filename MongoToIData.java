##Reading Mongo to webMethods IS as webMethods Idata Documemnt 

     MongoDatabase db2 = mongoClient.getDatabase(databaseName);
		 MongoCollection<Document> coll2 = db2.getCollection(collectionName);
		 FindIterable<Document> iterable2 = coll2.find(new Document("city.name", "NYC"));
		 iterable2.forEach(new Block<Document>() {
			    @Override
			    public void apply(final Document document) {
					IDataUtil.put( idc, "outputJson", document.toJson() );
			    }
			});
