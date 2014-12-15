QuadTree Visualisation Demo
========

A quadtree is a tree data structure in which each internal node has exactly four children. Quadtrees are most often used to partition a two-dimensional space by recursively subdividing it into four quadrants or regions. The regions may be square or rectangular, or may have arbitrary shapes. This data structure was named a quadtree by Raphael Finkel and J.L. Bentley in 1974. A similar partitioning is also known as a Q-tree. All forms of quadtrees share some common features:

* They decompose space into adaptable cells
* Each cell (or bucket) has a maximum capacity. When maximum capacity is reached, the bucket splits
* The tree directory follows the spatial decomposition of the quadtree.

*From wikipedia - for more information please follow http://en.wikipedia.org/wiki/Quadtree*

**Project includes few demo scenarios to clear show usability of QuadTree:**

* Only balls (flying balls) - simple visualisation of 2D objects in QuadTree
* Collisions - detection collission between two balls (approximately 150 balls)
* Simple collisions - same as second scene but with only four balls
* Game Of Life - Random world (QuadTree is use also to detect neighbours)
* Gun Cellular Automaton - Special case of Game Of Life

Screenshots
=====

![QuadTree](https://raw.github.com/jirkapenzes/quadtree/master/screenshots/quadtree-balls.png "QuadTree - Balls")

![QuadTree](https://raw.github.com/jirkapenzes/quadtree/master/screenshots/quadtree-gol.png "QuadTree - Gun Cellular Automaton")