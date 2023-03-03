package com.upware.sq_qs.methods.controller

import com.upware.sq_qs.queue.controller.Queue
import com.upware.sq_qs.stack.controller.Stack
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/qssq")
class MethodsController() {
    val q = Queue(10)
    val s = Stack(10)
    @GetMapping("/fill-q")
    fun FILLQ_WITHS(): Array<String?> {
        for(i in 0 .. s.getTop()){
            q.insert(s.pop())
        }
        var qDisplay = q.display()
            s.setTop(-1)
        return qDisplay
    }

    @GetMapping("/fill-s")
    fun FILLS_WITHQ(): Array<String?> {

        for(i in q.getFront() .. q.getBack()){
            s.push(q.delete().toString())
        }
        var sShow = s.display()
        q.setFront(-1)
        q.setBack(-1)
        return sShow
    }
    @GetMapping("/gets")
    fun gets(): Array<String?> {
        return s.display()
    }
    @GetMapping("/getq")
    fun getq(): Array<String?> {
        return q.display()
    }
    @PostMapping("/stack/{value}")
    fun push(@PathVariable("value") value: String): Array<String?> {
        s.push(value)
        return gets()
    }

    @PostMapping("/queue/{value}")
    fun insert(@PathVariable("value") value: String): Array<String?> {
        q.insert(value)
        return getq()
    }

    @DeleteMapping("/stack/pop")
    fun pop(): String {
        return s.pop()
    }

    @DeleteMapping("/queue/delete")
    fun delete(): String? {
        return q.delete()
    }



}