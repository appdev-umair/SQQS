package com.upware.sq_qs.stack.controller



class Stack(val size: Int ) {

    private var top: Int = -1
    private var stack: Array<String?> = arrayOfNulls(size)

    fun getTop(): Int {
        return top
    }
    fun push(value: String): String {
        if(top < size-1) {
            top++
            stack[top] = value
            return value
        }
        return "Stack is full!"
    }

    fun pop(): String {
        if(top >= 0){
            var rtn: String = stack[top].toString()
            stack[top] = null
            top--
            return rtn
        }
        return "Stack is empty!"
    }

    fun display(): Array<String?> {
        return stack
    }

    fun setTop(i: Int) {
        top = i
    }

}