package com.upware.sq_qs.queue.controller

class Queue(var size: Int) {
    private var front: Int = -1
    private var back: Int = -1
    private var queue: Array<String?> = arrayOfNulls(size)

    fun insert(value: String): String {
        if(back < size-1){
            back++
            queue[back] = value
        }
        else{
            return "Queue is full!"
        }
        if(front == -1){
            front = 0
        }
        return value

    }

    fun delete(): String {
        if(front == -1){
            return "Queue is empty!"
        }
        var rtn:  String = queue[front].toString()
        queue[front] = null
        front++
        if(front > back){
            front = -1
            back = -1
        }
        return rtn
    }
    fun getFront(): Int {
        return front
    }

    fun getBack(): Int{
        return back
    }
    fun display(): Array<String?> {
        return queue
    }

    fun setFront(i: Int) {
        front = i
    }

    fun setBack(i: Int) {
        back = i
    }
}