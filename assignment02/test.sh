#!/bin/bash

rm *.class
rm table.pdf
rm graph.pdf

javac HuffmanCode.java

echo Who powers Whooper | java -Xdebug HuffmanCode graph | dot -Tpdf -o graph.pdf
echo Who powers Whooper | java HuffmanCode table | pandoc -o table.pdf

evince table.pdf
evince graph.pdf
