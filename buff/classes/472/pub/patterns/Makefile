dias:=$(wildcard *.dia)
pdfs:=$(addsuffix .pdf,$(basename $(dias)))

TMPL:=0TMPL.tex

%.pdf: %.tex
	pdflatex $<

%.tex: %.eps $(TMPL)
	sed \
	    -e "s/@P@/$*/g" \
	    -e "s/@N@/$(shell patt2page $*)/g" \
	    < $(TMPL) > $@

all: $(pdfs)

clean: ; rm $(pdfs)
