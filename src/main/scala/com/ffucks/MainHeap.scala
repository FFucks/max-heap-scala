package com.ffucks

@main def runHeap(): Unit = {
   /* val heapInsert = new MaxHeap();
    heapInsert.buildHeap(Seq(40, 20, 30, 10));

    heapInsert.insert(50);
    println("Heap Insert: " + heapInsert.getHeap());*/


    val arrayBuild = Seq(2, 5, 10, 4, 7, 0);
    val heap = new MaxHeap();

    println("Array before build: " + arrayBuild);

    heap.buildHeap(arrayBuild);
    println("Heap after build: " + heap.getHeap());

    val max = heap.extractMax();
    println("Heap after extractMax: " + heap.getHeap() + " Max Value " + max );
}