package com.ffucks

import scala.collection.mutable.ArrayBuffer;

class MaxHeap {

    private val heap = ArrayBuffer[Int]();

    def getHeap(): Seq[Int] = {
        heap.toSeq;
    }

    def insert(value: Int): Unit = {
        heap.append(value);
        heapifyUp(heap.size - 1);
    }

    def removeAt(index: Int): Unit = {
        if (index >= heap.size) {
            return;
        }

        val last = heap.remove(heap.size - 1);

        if (index < heap.size) {
            heap(index) = last;

            val parent = (index - 1) / 2;

            if (index > 0 && heap(index) > heap(parent)) {
                heapifyUp(index);
            } else {
                heapifyDown(index);
            }
        }
    }

    def extractMax(): Int = {
        if (heap.isEmpty) {
            throw new RuntimeException("Heap is empty");
        }

        val max = heap(0);
        val last = heap.remove(heap.size - 1);

        if (heap.nonEmpty) {
            heap(0) = last;
            heapifyDown(0);
        }

        max;
    }

    def peek(): Int = {
        if (heap.isEmpty) {
            throw new RuntimeException("Heap is empty");
        }
        heap(0);
    }

    private def heapifyUp(index: Int): Unit = {
        var i = index;

        while (i > 0) {
            val parent = (i - 1) / 2;

            if (heap(i) <= heap(parent)) {
                return;
            }

            swap(i, parent);
            i = parent;
        }
    }

    private def heapifyDown(index: Int): Unit = {
        var i = index;
        val size = heap.size;

        while (true) {
            val left = 2 * i + 1;
            val right = 2 * i + 2;
            var largest = i;

            if (left < size && heap(left) > heap(largest)) {
                largest = left;
            }

            if (right < size && heap(right) > heap(largest)) {
                largest = right;
            }

            if (largest == i) {
                return;
            }

            swap(i, largest);
            i = largest;
        }
    }

    private def swap(i: Int, j: Int): Unit = {
        val temp = heap(i);
        heap(i) = heap(j);
        heap(j) = temp;
    }

    def buildHeap(array: Seq[Int]): Unit = {
        heap.clear();
        heap.appendAll(array);

        for (i <- (heap.size / 2 - 1) to 0 by -1) {
            heapifyDown(i);
        }
    }
}