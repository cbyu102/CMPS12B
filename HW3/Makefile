JAVASRC    = Chessmoves.java ChessPiece.java
SOURCES    = README Makefile $(JAVASRC)
MAINCLASS  = Chessmoves
CLASSES    = Chessmoves.class Pawn.class Bishop.class ChessPiece.class King.class Knight.class Queen.class Rook.class Node.class
JARFILE    = Chessmoves.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE) analysis.txt
