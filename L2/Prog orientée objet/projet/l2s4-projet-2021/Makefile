SOURCE_PATH = src/*/*/*.java src/*/*.java src/*/*/*.java
CLASS_PACKAGES = -C bin game  -C  bin utils  -C bin personage -C bin player -C bin board -C bin tile

doc: 
	javadoc -d docs -sourcepath $(SOURCE_PATH)

guerre.jar: manifest-war 
	jar cvfm jar/guerre.jar $^ $(CLASS_PACKAGES)

agricole.jar: manifest-agricole
	jar cvfm jar/agricole.jar $^ $(CLASS_PACKAGES)

cls: 
	javac -d bin -cp bin -sourcepath $(SOURCE_PATH)

clean : 
	rm -rf bin/*/*.class bin/*/*/*.class
	
.PHONY: all clean
