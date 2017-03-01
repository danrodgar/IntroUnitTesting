NAME=slides 

all:
	pdflatex $(NAME).tex && pdflatex $(NAME).tex
clean:
	-rm -f *~ *.out *.aux *.dvi *.ps *.pdf *.toc *.lof *.log *.lot *.flg *.bbl *.blg *.idx *.ind *.ilg *.snm *.nav *.fig.bak ./cfg/*.aux ./cfg/*.log *.vrb
