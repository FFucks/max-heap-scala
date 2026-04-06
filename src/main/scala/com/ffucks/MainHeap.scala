package com.ffucks

@main def runHeap(): Unit = {
    val heapInsert = new MaxHeap();
    heapInsert.buildHeap(Seq(10, 40));

    heapInsert.insert(50);
    println("Heap Insert: " + heapInsert.getHeap());


    val arrayBuild = Seq(1, 5, 10, 4, 7);
    val heap = new MaxHeap();

    println("Array before build: " + arrayBuild);

    heap.buildHeap(arrayBuild);
    println("Heap after build: " + heap.getHeap());

    heap.removeAt(2);
    println("Heap after removeAt: " + heap.getHeap());

    val max = heap.extractMax();
    println("Heap after extractMax: " + heap.getHeap() + " Max Value " + max );
}