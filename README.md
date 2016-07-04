# Closest pair problem in n dimensions

## Specification

> Your task is to create a Java/Python program which reads a text file where each line contains the coordinates of a multidimensional point, and then looks for the closest pair of points in the file. If the program has found the closest pair of points, it should output the line numbers of the two closest points.

> The text file contains one point per line. The coordinate values are separated by a tabulator character. The coordinate values are not necessarily integers. In case of a floating point coordinate value the decimal separator is a period.

## Installation and usage

### Prerequisites

Git, Maven 3, JDK 1.8.

### Building, testing and running

After fetching the source (`git clone https://github.com/torzsmokus/closest-pair.git`), run `mvn clean install` for building, `mvn test` for testing and `java -jar target/closest-pair-*.jar` to run the program.

If no input file is specified as an argument, the program looks for a file named `points.tsv`, first in the working directory, then on the classpath (there is a default file in the jar with that name).

The specified output is printed to stdout while some debugging information appears on stderr.

## Discussion

The current implementation is a naïve one (compares each point once with every other). It takes O(_dn²_) time (for _d_ dimensions and _n_ sized input) asimptotically. Nevertheless, it still runs pretty fast (under a second) with the given test data.

The theoretical minimum is Ω(_n_ log _n_) because the Element Uniqueness problem can be reduced to this, which is known to have that limit. (The reduction is quite trivial: if the closest pair has δ=0, the elements aren’t unique.)

It can be shown that an O(_n_ log _n_) solution is possible but far from trivial.

I am currently working on a divide-and-conquer implementation that takes O( _n_ (log _n_)^(_d_–1) ) time.

### References

1. [Suri, Subhash: _Closest Pair Problem_. Lecture slides, UC Santa Barbara, 2002.](https://www.cs.ucsb.edu/~suri/cs235/ClosestPair.pdf)
1. [Indyk, Piotr: _Closest Pair_. Lecture handout, Massachusetts Institute of Technology, 2005.](https://people.csail.mit.edu/indyk/6.838/handouts/lec12.pdf)