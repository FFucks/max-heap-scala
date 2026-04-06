package com.ffucks

@main def runHeap(): Unit = {
    val heapInsert = new MaxHeap();
    heapInsert.buildHeap(Seq(40, 20, 30, 10))

    println("Heap before Insert: " + heapInsert.getHeap())
    heapInsert.insert(50)
    println("Heap After Insert: " + heapInsert.getHeap())

    val arrayBuild = Seq(10, 7, 1, 4, 5, 0)
    val heap = new MaxHeap();

    println("----------------");

    heap.buildHeap(arrayBuild)

    println("Heap Before extractMax: " + arrayBuild)
    val max = heap.extractMax()
    println("Heap After extractMax: " + heap.getHeap() + " Max Value " + max )
}